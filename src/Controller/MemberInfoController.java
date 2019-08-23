package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.Memberinfo;
import View.Table;
import model.Member;
import util.Resource;

public class MemberInfoController implements ActionListener, Resource {
	Memberinfo memberinfo = new Memberinfo(dao.getId());
	Member member;

	public MemberInfoController(String id) {
		member = (Member) dao.searchBook("Member", id, "ID").get(0);
		memberinfo.lbMemberId.setText(member.getMId());
		memberinfo.tftMemberPw.setText(member.getMPw());
		memberinfo.tftMemberName.setText(member.getMName());
		memberinfo.tftMemberPhone.setText(member.getMPh());
		memberinfo.tftMemberEmail.setText(member.getMEmail());
		if (member.getMSex().equals("����"))
			memberinfo.rbMale.setSelected(true);
		else
			memberinfo.rbFemale.setSelected(true);
		memberinfo.btnModify.addActionListener(this);
		memberinfo.btnDelete.addActionListener(this);
		memberinfo.btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == memberinfo.btnModify) {
			member.setMId(memberinfo.lbMemberId.getText());
			member.setMPw(memberinfo.tftMemberPw.getText());
			member.setMName(memberinfo.tftMemberName.getText());
			member.setMPh(memberinfo.tftMemberPhone.getText());
			member.setMEmail(memberinfo.tftMemberEmail.getText());
			if (memberinfo.rbMale.isSelected())
				member.setMSex("����");
			else
				member.setMSex("����");
			dao.modifyMember(member);
			memberinfo.dispose();
		} else if (btn == memberinfo.btnDelete) {
			List<String> list = dao.findWord();
			int i = new Random().nextInt(list.size());
			String input = JOptionPane.showInputDialog("���� �����Ͻ÷��� \"" + list.get(i) + "\" �� �Է��ϼ���");
			if (list.get(i).equals(input)) {
				dao.deleteMember(member);
				memberinfo.dispose();
				if (!dao.getId().equals("admin")) {
					System.exit(0);
				}
			} else if (input.equals("")) {
			} else
				JOptionPane.showMessageDialog(null, "���� ������ Ʋ�Ƚ��ϴ�.");

		} else if (btn == memberinfo.btnCancel) {
			memberinfo.dispose();
		} else {

		}
	}
}
