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
		// 아무것도 안누르고 실행할때
	}

	public SendMsgController(String type, List<Object> list, Boolean isplay) {
		this.list = list;
		this.type = type;
		this.isplay = isplay;
		messagesend = new MessageSend(type,list, isplay);
		messagesend.btnSend.addActionListener(this);
		messagesend.btnMsgSendCancel.addActionListener(this);
		// 테이블 로우를 선택하고 실행할때
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == messagesend.btnSend) {
			Message Msg;
			if (dao.checkId(messagesend.tftTo.getText())) {
				JOptionPane.showMessageDialog(null, "아이디가 존재하지않습니다!");
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
				dao.sendMessage(Msg, type); // Msg를 보내는 버튼설정
				messagesend.dispose();
			}
		} else if (btn == messagesend.btnMsgSendCancel) {
			messagesend.dispose(); // 취소버튼
		} else {

		}
	}
}
