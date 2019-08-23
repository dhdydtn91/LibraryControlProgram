package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FindId;
import model.Member;
import util.Resource;

public class FindIDController implements ActionListener, Resource {
	FindId findid = new FindId();

	public FindIDController() {
		findid.btnFind.addActionListener(this);
		findid.btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn == findid.btnFind) {
			if (findid.tftFindName.getText().equals(""))
				JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
			else if (findid.tftFindPhone.getText().equals(""))
				JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �Է��ϼ���.");
			else {
				Member member = new Member();
				member.setMName(findid.tftFindName.getText());
				member.setMPh(findid.tftFindPhone.getText());
				String id = dao.findId(member);
				if (id.equals(""))
					JOptionPane.showMessageDialog(null, "���̵� �����ϴ�.");
				else {
					JOptionPane.showMessageDialog(null, "���̵�� " + id + " �Դϴ�.");
					findid.dispose();
				}
			}
		} else if (btn == findid.btnCancel) {
			findid.dispose();
		} else {

		}
	}
}
