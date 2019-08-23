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
			if (list.get(i).getSId() == null) { // 빈 좌석일 경우
				seatpanel.btnSeat[i].setBackground(new Color(255, 255, 255));
				seatpanel.btnSeat[i].setForeground(Color.BLACK);
				seatpanel.btnSeat[i].setText(((int) list.get(i).getSNo() + 1) + " ");
			} else if (list.get(i).getSId().equals("admin")) { // 벤 좌석일 경우
				seatpanel.btnSeat[i].setBackground(new Color(051, 051, 051));
				seatpanel.btnSeat[i].setForeground(Color.WHITE);
				seatpanel.btnSeat[i].setText("<html><body align=center>" + ((int) list.get(i).getSNo() + 1) + "<br>"	+ "BAN" + "</body></html>");
			} else { // 점유 좌석 일경우
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
				if (dao.getId().equals("admin")) {// 어드민이클릭
					if (list.get(i).getSId() == null) { // Sid가 비어있는지 구분
						int result = JOptionPane.showConfirmDialog(null, "공석입니다. 좌석을 블락처리 하시겠습니까?", "블락처리",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // 확인
							dao.setSeatUpdate("admin", list.get(i));
						} else { // 취소

						}
					} else if (list.get(i).getSId().equalsIgnoreCase("admin")) {// 블락인
																				// 경우
						int result = JOptionPane.showConfirmDialog(null, "좌석의 블락처리를 취소하시겠습니까?", "블락처리 취소",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // 확인
							dao.setSeatDelete(null, list.get(i));
						} else { // 취소

						}
					} else {// 회원이 사용중인경우
						int result = JOptionPane.showConfirmDialog(null, "회원의 자리를 비우겠습니까?", "회원자리 비우기",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // 확인
							dao.setSeatDelete(null, list.get(i));
						} else {

						}
					}
				} else {// 회원이 클릭
					if (list.get(i).getSId() == null) { // Sid가 비어있는지 구분
						if (!dao.checkseat()) {
							int result = JOptionPane.showConfirmDialog(null, "좌석을 이동하시겠습니까??", "좌석 이동",
									JOptionPane.OK_CANCEL_OPTION);
							if (result == 0) { // 확인
								dao.setSeatDelete(null, dao.findSeat(1).get(0));
								dao.setSeatUpdate(dao.getId(), list.get(i));
								JOptionPane.showMessageDialog(null, (i + 1) + "번 좌석으로 이동했습니다.");
							}
						} else {
							int result = JOptionPane.showConfirmDialog(null, "공석입니다. 좌석을 대여 하시겠습니까?", "좌석 대여",
									JOptionPane.OK_CANCEL_OPTION);
							if (result == 0) { // 확인
								dao.setSeatUpdate(dao.getId(), list.get(i));
							}
						}
					} else if (list.get(i).getSId().equals("admin")) { // 회원이
																		// 어드민자리
																		// 클릭
						JOptionPane.showMessageDialog(null, "대여 할 수 없는 좌석 입니다");

					} else if (list.get(i).getSId().equals(dao.getId())) { // 자신의
																			// 자리
																			// 클릭
						int result = JOptionPane.showConfirmDialog(null, "좌석을 반납하시겠습니까?", "좌석 반납",
								JOptionPane.OK_CANCEL_OPTION);
						if (result == 0) { // 확인
							dao.setSeatDelete(null, list.get(i));
						}

					} else {// 회원이 다른 회원 아이디 클릭
						JOptionPane.showMessageDialog(null, "대여 할 수 없는 좌석 입니다");
					}
				}
			}
		}
		setseatcolor();
		// seatpanel.repaint();

	}
}
