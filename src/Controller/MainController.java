package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import View.AdminBookPanel;
import View.Main;
import View.MemberBookPanel;
import View.MessagePanel;
import View.SeatPanel;
import util.Resource;

public class MainController implements ActionListener, Resource {
	Main main;
	JPanel mainpanel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public MainController() {
		// AdminBookPanel�� �ʱ� ���� �гη� ����
		if (dao.getId().equals("admin")) // �����ڷ� �α����� �� admin�г� �ʱ⼳��
			main = new Main(new AdminBookPanelController().adminbookpanel);
		else // ȸ������ �α����� �� guest�г� �ʱ⼳��
			main = new Main(new GuestBookPanelController().guestbook);

		main.btnMainBook.addActionListener(this);
		main.btnMainSeat.addActionListener(this);
		main.btnMainMember.addActionListener(this);
		main.btnMainMessage.addActionListener(this);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void btnChangeColor(JButton btn) {
		if (btn == main.btnMainBook) {
			btn.setBackground(Color.BLACK);
			main.btnMainSeat.setBackground(Color.WHITE);
			main.btnMainMember.setBackground(Color.WHITE);
			main.btnMainMessage.setBackground(Color.WHITE);
		} else if (btn == main.btnMainSeat) {
			btn.setBackground(Color.BLACK);
			main.btnMainBook.setBackground(Color.WHITE);
			main.btnMainMember.setBackground(Color.WHITE);
			main.btnMainMessage.setBackground(Color.WHITE);
		} else if (btn == main.btnMainMember) {
			btn.setBackground(Color.BLACK);
			main.btnMainBook.setBackground(Color.WHITE);
			main.btnMainSeat.setBackground(Color.WHITE);
			main.btnMainMessage.setBackground(Color.WHITE);

		} else if (btn == main.btnMainMessage) {
			btn.setBackground(Color.BLACK);
			main.btnMainBook.setBackground(Color.WHITE);
			main.btnMainSeat.setBackground(Color.WHITE);
			main.btnMainMember.setBackground(Color.WHITE);
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn == main.btnMainBook) {
			btnChangeColor(btn);
			if (dao.getId().equals("admin")) {
				main.setMainPane(new AdminBookPanelController().adminbookpanel);
			} else {
				main.setMainPane(new GuestBookPanelController().guestbook);
			}

		} else if (btn == main.btnMainSeat) {
			btnChangeColor(btn);
			SeatController seatcon = new SeatController();
			main.setMainPane(seatcon.seatpanel);

		} else if (btn == main.btnMainMember) {
			btnChangeColor(btn);
			if (dao.getId().equals("admin")) {
				main.setMainPane(new MemberControlPanelController().memberControl);
			} else {
				String Pw = JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���");
				if (dao.checkPw(dao.getId(), Pw)) {
					new MemberInfoController(dao.getId());
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�");
				}
			}
		} else if (btn == main.btnMainMessage) {
			btnChangeColor(btn);
			main.setMainPane(new MessagePanelController().messagepanel);
		}
	}

}
