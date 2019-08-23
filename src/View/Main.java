package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;

public class Main extends JFrame {
	public JButton btnMainBook;
	public JButton btnMainSeat;
	public JButton btnMainMember;
	public JButton btnMainMessage;
	public JPanel Mainpanel;
	public JPanel Sidepanel;
	public ImageIcon bookImage;
	public ImageIcon seatImage;
	public ImageIcon memberImage;
	public ImageIcon messageImage;

	public Main(JPanel panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookImage = new ImageIcon("Image//book.png");
		seatImage = new ImageIcon("Image//seat.png");
		memberImage = new ImageIcon("Image//member.png");
		messageImage = new ImageIcon("Image//msg.png");
		
		Sidepanel = new JPanel();
		Sidepanel.setLayout(new GridLayout(4, 1, 0, 0));

		btnMainBook = new JButton(bookImage);
		Sidepanel.add(btnMainBook);
		btnMainBook.setBackground(Color.BLACK);
		btnMainBook.setFocusPainted(false);
		btnMainBook.setSize(100, 100);
		btnMainBook.setFocusPainted(false);
		btnMainSeat = new JButton(seatImage);
		btnMainSeat.setBackground(Color.WHITE);
		Sidepanel.add(btnMainSeat);

		btnMainMember = new JButton(memberImage);
		btnMainMember.setBackground(Color.WHITE);
		Sidepanel.add(btnMainMember);

		btnMainMessage = new JButton(messageImage);
		btnMainMessage.setBackground(Color.WHITE);
		Sidepanel.add(btnMainMessage);
		
		setMainPane(panel);
		
		setResizable(false);
		setSize(730, 550);
		setLocationRelativeTo(null);
	//	setVisible(true);

	}

	
	public void setMainPane(JPanel panel) {
		 //setVisible(false);
		//dispose();
		getContentPane().removeAll();// 컨텐트펜 내용제거
		// 재 생성
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(BorderLayout.WEST, Sidepanel);
		getContentPane().add(BorderLayout.CENTER, panel);
		setVisible(true);
	}

}
