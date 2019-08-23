package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import View.AdminBookPanel;
import View.MemberBookPanel;
import View.Table;
import util.Resource;

public class GuestBookPanelController implements ActionListener, Resource {
	MemberBookPanel guestbook = new MemberBookPanel(dao.getId(), new Table("Book", dao.searchAll("Book")));

	String comboBoxtitle;
	String tftcontent;

	public GuestBookPanelController() {
		guestbook.btnBookSearch.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == guestbook.btnBookSearch) {
//			main.scrollPane.setVisible(false);
			
			comboBoxtitle = guestbook.cbTypeChoice.getSelectedItem().toString();
			tftcontent = guestbook.tftBookSearch.getText();
			
			guestbook.settable(new Table("Book", dao.searchBook("Book", tftcontent, comboBoxtitle)));
		} else {

		}
	}
}
