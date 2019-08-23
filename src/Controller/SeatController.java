package Controller;

import java.awt.*;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JOptionPane;

import View.SeatPanel;
import model.Seat;
import util.Resource;

public class SeatController implements ActionListener, Resource {
	SeatPanel seatpanel = new SeatPanel(dao.getId());
	List<Seat> list = new ArrayList<>();

	public SeatController() {
		for (int i = 0; i < 12; i++) {
			seatpanel.btnSeat[i].addActionListener(this);
		}

		setseatcolor();

	}

	private void setseatcolor() {
		list = dao.findSeat(2);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSId() == null) { // �� �¼��� ���
				seatpanel.btnSeat[i].setBackground(new Color(255, 255, 255));
				seatpanel.btnSeat[i].setForeground(Color.BLACK);
				seatpanel.btnSeat[i].setText(((int) list.get(i).getSNo() + 1) + " ");
			} else if (list.get(i).getSId().equals("admin")) { // �� �¼��� ���
				seatpanel.btnSeat[i].setBackground(new Color(051, 051, 051));
				seatpanel.btnSeat[i].setForeground(Color.WHITE);
				seatpanel.btnSeat[i].setText("<html><body align=center>" + ((int) list.get(i).getSNo() + 1) + "<br>"	+ "BAN" + "</body></html>");
			} else { // ���� �¼� �ϰ��
				seatpanel.btnSeat[i].setBackground(new Color(128, 128, 128));
				seatpanel.btnSeat[i].setForeground(Color.BLACK);
				seatpanel.btnSeat[i].setText("<html><body align=center>" + ((int) list.get(i).getSNo() + 1) + "<br>"
						+ list.get(i).getSId() + "</body></html>");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		for (int i = 0; i < 12; i++) {
			if (btn == seatpanel.btnSeat[i]) {
				if (dao.getId().equals("admin")) {// ������Ŭ��
					if (list.get(i).getSId() == null) { // Sid�� ����ִ��� ����
						int result = JOptionPane.showConfirmDialog(null, "�����Դϴ�. �¼��� ���ó�� �Ͻðڽ��ϱ�?", "���ó��",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // Ȯ��
							dao.setSeatUpdate("admin", list.get(i));
						} else { // ���

						}
					} else if (list.get(i).getSId().equalsIgnoreCase("admin")) {// �����
																				// ���
						int result = JOptionPane.showConfirmDialog(null, "�¼��� ���ó���� ����Ͻðڽ��ϱ�?", "���ó�� ���",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // Ȯ��
							dao.setSeatDelete(null, list.get(i));
						} else { // ���

						}
					} else {// ȸ���� ������ΰ��
						int result = JOptionPane.showConfirmDialog(null, "ȸ���� �ڸ��� ���ڽ��ϱ�?", "ȸ���ڸ� ����",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // Ȯ��
							dao.setSeatDelete(null, list.get(i));
						} else {

						}
					}
				} else {// ȸ���� Ŭ��
					if (list.get(i).getSId() == null) { // Sid�� ����ִ��� ����
						if (!dao.checkseat()) {
							int result = JOptionPane.showConfirmDialog(null, "�¼��� �̵��Ͻðڽ��ϱ�??", "�¼� �̵�",
									JOptionPane.OK_CANCEL_OPTION);
							if (result == 0) { // Ȯ��
								dao.setSeatDelete(null, dao.findSeat(1).get(0));
								dao.setSeatUpdate(dao.getId(), list.get(i));
								JOptionPane.showMessageDialog(null, (i + 1) + "�� �¼����� �̵��߽��ϴ�.");
							}
						} else {
							int result = JOptionPane.showConfirmDialog(null, "�����Դϴ�. �¼��� �뿩 �Ͻðڽ��ϱ�?", "�¼� �뿩",
									JOptionPane.OK_CANCEL_OPTION);
							if (result == 0) { // Ȯ��
								dao.setSeatUpdate(dao.getId(), list.get(i));
							}
						}
					} else if (list.get(i).getSId().equals("admin")) { // ȸ����
																		// �����ڸ�
																		// Ŭ��
						JOptionPane.showMessageDialog(null, "�뿩 �� �� ���� �¼� �Դϴ�");

					} else if (list.get(i).getSId().equals(dao.getId())) { // �ڽ���
																			// �ڸ�
																			// Ŭ��
						int result = JOptionPane.showConfirmDialog(null, "�¼��� �ݳ��Ͻðڽ��ϱ�?", "�¼� �ݳ�",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // Ȯ��
							dao.setSeatDelete(null, list.get(i));
						}

					} else {// ȸ���� �ٸ� ȸ�� ���̵� Ŭ��
						JOptionPane.showMessageDialog(null, "�뿩 �� �� ���� �¼� �Դϴ�");
					}
				}
			}
		}
		setseatcolor();
		// seatpanel.repaint();

	}
}
