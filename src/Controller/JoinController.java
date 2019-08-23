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
				JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���");
			} else if (join.tftJoinPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���");
			} else if (join.tftJoinCPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��й�ȣüũ�� �Է��ϼ���");
			} else if (join.tftJoinName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���");
			} else if (join.tftJoinPhone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �Է��ϼ���");
			} else if (join.tftJoinEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���");
			} else if (!idcheck) {
				JOptionPane.showMessageDialog(null, "���̵� �ߺ�Ȯ�� �ʿ�");
			} else if (!join.tftJoinPw.getText().equals(join.tftJoinCPw.getText())) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ���� �ʽ��ϴ�.");
			} else {
				member.setMId(join.tftJoinId.getText());
				member.setMPw(join.tftJoinPw.getText());
				member.setMName(join.tftJoinName.getText());
				member.setMPh(join.tftJoinPhone.getText());
				member.setMEmail(join.tftJoinEmail.getText());
				if (join.rbMale.isSelected())
					member.setMSex("����");
				else
					member.setMSex("����");
				dao.createMember(member);
				join.dispose();
			}
		} else if (btn == join.btnJoinCancel)

		{
			join.dispose();
		} else if (btn == join.btnJoinCheck) {
			if (join.tftJoinId.getText().equals(""))
				JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
			else if (dao.checkId(join.tftJoinId.getText())) {
				JOptionPane.showMessageDialog(null, "��밡�� ���̵��Դϴ�.");
				idcheck = true;
			} else {
				JOptionPane.showMessageDialog(null, "�̹� ������� ���̵��Դϴ�.");
				idcheck = false;
			}
		} else {

		}
	}
}
