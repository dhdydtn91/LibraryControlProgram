package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.MessageView;
import model.Message;
import util.Resource;

public class ViewMsgController implements ActionListener, Resource {
	MessageView messageview;
	List<Object> list;

	public ViewMsgController(List<Object> list) {
		this.list = list;
		messageview = new MessageView(list);
		messageview.btnReply.addActionListener(this);
		messageview.btnMsgViewDelete.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Message msg = (Message) list.get(0);
		JButton btn = (JButton) e.getSource();
		if (btn == messageview.btnReply) {
			Boolean isplay = true;
			String type = "reply";
			Message Msg = (Message) list.get(0);
			if (Msg.getMsgNo() != Msg.getReplyno()) {
				JOptionPane.showMessageDialog(null, "질문에 대한 답글만 가능합니다!");

			}else{
			new SendMsgController(type, list, isplay);
			}
			messageview.dispose();
		} else if (btn == messageview.btnMsgViewDelete) {
			JOptionPane.showMessageDialog(null, msg.getMsgNo() + "번호의 메세지가 삭제되었습니다!");
			dao.deleteMessage(msg);
			messageview.dispose();
		} else {

		}
	}
}
