package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.Join;
import View.Table;
import model.Member;
import util.Resource;

public class JoinController implements ActionListener, Resource {
	Join join;
	boolean idcheck = false;

	public JoinController() {
		join = new Join();
		join.btnJoinCreate.addActionListener(this);
		join.btnJoinCancel.addActionListener(this);
		join.btnJoinCheck.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn == join.btnJoinCreate) {
			Member member = new Member();
			if (join.tftJoinId.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
			} else if (join.tftJoinPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			} else if (join.tftJoinCPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호체크를 입력하세요");
			} else if (join.tftJoinName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "이름을 입력하세요");
			} else if (join.tftJoinPhone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			} else if (join.tftJoinEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "이메일을 입력하세요");
			} else if (!idcheck) {
				JOptionPane.showMessageDialog(null, "아이디 중복확인 필요");
			} else if (!join.tftJoinPw.getText().equals(join.tftJoinCPw.getText())) {
				JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.");
			} else {
				member.setMId(join.tftJoinId.getText());
				member.setMPw(join.tftJoinPw.getText());
				member.setMName(join.tftJoinName.getText());
				member.setMPh(join.tftJoinPhone.getText());
				member.setMEmail(join.tftJoinEmail.getText());
				if (join.rbMale.isSelected())
					member.setMSex("남성");
				else
					member.setMSex("여성");
				dao.createMember(member);
				join.dispose();
			}
		} else if (btn == join.btnJoinCancel)

		{
			join.dispose();
		} else if (btn == join.btnJoinCheck) {
			if (join.tftJoinId.getText().equals(""))
				JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
			else if (dao.checkId(join.tftJoinId.getText())) {
				JOptionPane.showMessageDialog(null, "사용가능 아이디입니다.");
				idcheck = true;
			} else {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
				idcheck = false;
			}
		} else {

		}
	}
}
