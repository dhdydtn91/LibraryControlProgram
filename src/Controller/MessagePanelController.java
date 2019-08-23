package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.MessagePanel;
import View.Table;
import model.Message;
import util.Resource;

public class MessagePanelController implements ActionListener, Resource {
	MessagePanel messagepanel = new MessagePanel(dao.getId(), new Table("Message", dao.searchAll("Message")));

	public MessagePanelController() {
		messagepanel.btnMsgSearch.addActionListener(this);
		messagepanel.btnMsgSend.addActionListener(this);
		messagepanel.btnMsgView.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == messagepanel.btnMsgSearch) {
			messagepanel.scrollPane.setVisible(false);
			String combcontent = (String) (messagepanel.comboBox.getSelectedItem());
			if (messagepanel.tftMsgSearch.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�˻��� Ű���带 �Է��ϼ���");
				if (combcontent.equals("No")) {
					messagepanel.settable(new Table("Message", dao.searchBook("Message", "0", combcontent)));
				} else {
					messagepanel.settable(new Table("Message", dao.searchBook("Message", null, combcontent)));
				}
			} else {
				messagepanel.settable(new Table("Message",
						dao.searchBook("Message", messagepanel.tftMsgSearch.getText(), combcontent)));
			}
		} else if (btn == messagepanel.btnMsgSend) {
			if (messagepanel.jTable.getSelectedRow() > -1) {
				Boolean isPlay = true; // �÷��� �����ϴ��� ������ ��
				String type="send";
				new SendMsgController(type,
						dao.searchBook("Message",
								(String) messagepanel.jTable.getValueAt(messagepanel.jTable.getSelectedRow(), 1), "No"),
						isPlay);
			} else {
				Boolean isPlay = false;
				new SendMsgController(isPlay);
			}

		} else if (btn == messagepanel.btnMsgView) {
			if (messagepanel.jTable.getSelectedRow() > -1) {
				new ViewMsgController(dao.searchBook("Message",
						(String) messagepanel.jTable.getValueAt(messagepanel.jTable.getSelectedRow(), 1), "No"));
			} else {
				JOptionPane.showMessageDialog(null, "�޼����� �ݵ�� �������ּ���");
			}
		} else {

		}
	}

}
