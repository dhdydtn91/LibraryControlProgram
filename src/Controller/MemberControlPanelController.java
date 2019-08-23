package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.MemberControlPanel;
import View.Table;
import util.Resource;

public class MemberControlPanelController implements ActionListener, Resource {

	MemberControlPanel memberControl = new MemberControlPanel(dao.getId(),
			new Table("Member", dao.searchAll("Member")));

	public MemberControlPanelController() {
		// MainController.main.setMainPane(memberControl);
		memberControl.btnMemberSearch.addActionListener(this);
		memberControl.btnMemberJoin.addActionListener(this);
		memberControl.btnMemberModify.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == memberControl.btnMemberSearch) {
			if (memberControl.tftMemberSearch.getText().equals(""))
				JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			else {
				memberControl.scrollPane.setVisible(false);
				memberControl.setTable(new Table("Member", dao.searchBook("Member",
						memberControl.tftMemberSearch.getText(), (String) memberControl.comboBox.getSelectedItem())));
			}
		} else if (btn == memberControl.btnMemberJoin) {
			new JoinController();
		} else if (btn == memberControl.btnMemberModify) {
			if (memberControl.jtable.getSelectedRow() < 0)
				JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요");
			else {
				new MemberInfoController(
						(String) memberControl.jtable.getValueAt(memberControl.jtable.getSelectedRow(), 0));
			}
		} else {

		}
	}
}
