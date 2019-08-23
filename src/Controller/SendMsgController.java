package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.MessageSend;
import model.Message;
import util.Resource;

public class SendMsgController implements ActionListener, Resource {
	MessageSend messagesend;
	List<Object> list;
	String type;
	Boolean isplay;

	public SendMsgController(Boolean isplay) {
		this.isplay = isplay;
		this.type = "send";
		messagesend = new MessageSend(type,list, isplay);
		messagesend.btnSend.addActionListener(this);
		messagesend.btnMsgSendCancel.addActionListener(this);
		// �ƹ��͵� �ȴ����� �����Ҷ�
	}

	public SendMsgController(String type, List<Object> list, Boolean isplay) {
		this.list = list;
		this.type = type;
		this.isplay = isplay;
		messagesend = new MessageSend(type,list, isplay);
		messagesend.btnSend.addActionListener(this);
		messagesend.btnMsgSendCancel.addActionListener(this);
		// ���̺� �ο츦 �����ϰ� �����Ҷ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == messagesend.btnSend) {
			Message Msg;
			if (dao.checkId(messagesend.tftTo.getText())) {
				JOptionPane.showMessageDialog(null, "���̵� ���������ʽ��ϴ�!");
				messagesend.tftTo.setText("");
				messagesend.tftTitle.setText("");
				messagesend.tpContent.setText("");
				messagesend.tftTo.requestFocus();
			} else {
				if (!isplay) {
					Msg = new Message();
				} else {
					Msg = (Message) list.get(0);
					Msg.setReplyno(Msg.getMsgNo());
				}
				Msg.setMsgInwardid(dao.getId());
				Msg.setMsgSendid(messagesend.tftTo.getText());
				Msg.setMsgTitle(messagesend.tftTitle.getText());
				Msg.setMsgContent(messagesend.tpContent.getText());
				dao.sendMessage(Msg, type); // Msg�� ������ ��ư����
				messagesend.dispose();
			}
		} else if (btn == messagesend.btnMsgSendCancel) {
			messagesend.dispose(); // ��ҹ�ư
		} else {

		}
	}
}
