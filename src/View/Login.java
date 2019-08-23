package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;

public class Login extends JFrame {
	public JTextField tftId;
	public JPasswordField tftPw;
	public JButton btnLogin;
	public JButton btnJoin;
	public JButton btnFindID;
	public JButton btnFindPw;

	public Login() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel() {
			ImageIcon img = new ImageIcon("Image//Loginbackg.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		panel_1.setBounds(0, 0, 394, 501);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lbid = new JLabel("ID");
		lbid.setForeground(Color.WHITE);
		lbid.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		lbid.setHorizontalAlignment(SwingConstants.CENTER);
		lbid.setBounds(24, 153, 57, 15);
		panel_1.add(lbid);

		JLabel lbPw = new JLabel("PW");
		lbPw.setForeground(Color.WHITE);
		lbPw.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		lbPw.setHorizontalAlignment(SwingConstants.CENTER);
		lbPw.setBounds(20, 201, 57, 15);
		panel_1.add(lbPw);

		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("ÇÑÄÄ À±°íµñ 240", Font.BOLD, 20));
		btnLogin.setBounds(269, 143, 100, 82);
		panel_1.add(btnLogin);

		btnJoin = new JButton("Join");
		btnJoin.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnJoin.setBackground(Color.WHITE);
		btnJoin.setBounds(133, 271, 125, 33);
		panel_1.add(btnJoin);

		btnFindID = new JButton("FindId");
		btnFindID.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnFindID.setBackground(Color.WHITE);
		btnFindID.setBounds(133, 329, 125, 33);
		panel_1.add(btnFindID);

		btnFindPw = new JButton("FindPw");
		btnFindPw.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnFindPw.setBackground(Color.WHITE);
		btnFindPw.setBounds(133, 387, 125, 33);
		panel_1.add(btnFindPw);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(80, 138, 186, 102);
		panel_1.add(layeredPane);
		layeredPane.setLayout(null);
		tftId = new JTextField();
		tftId.setBounds(26, 10, 148, 31);
		layeredPane.add(tftId);
		tftId.setColumns(10);

		tftPw = new JPasswordField();
		tftPw.setBounds(26, 51, 148, 31);
		layeredPane.add(tftPw);
		tftPw.setColumns(10);

		setResizable(false);
		setSize(400, 530);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
