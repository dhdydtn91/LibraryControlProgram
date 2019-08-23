package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class Join extends JFrame {
	public JTextField tftJoinId;
	public JPasswordField tftJoinPw;
	public JPasswordField tftJoinCPw;
	public JTextField tftJoinName;
	public JTextField tftJoinPhone;
	public JTextField tftJoinEmail;
	public JButton btnJoinCreate;
	public JButton btnJoinCancel;
	public JButton btnJoinCheck;
	public JRadioButton rbFemale;
	public JRadioButton rbMale;
	public ButtonGroup sexgroup;
	public JPanel panel;

	public Join() {
		getContentPane().setLayout(null);
		
		panel = new JPanel() {
			ImageIcon img = new ImageIcon("Image//JOIN.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(23, 68, 57, 21);
		panel.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(Color.WHITE);
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setBounds(23, 122, 57, 21);
		panel.add(lblPw);

		JLabel lblPwcheck = new JLabel("CheckPw");
		lblPwcheck.setForeground(Color.WHITE);
		lblPwcheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwcheck.setBounds(23, 176, 57, 21);
		panel.add(lblPwcheck);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(23, 230, 57, 21);
		panel.add(lblName);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(23, 284, 57, 21);
		panel.add(lblPhone);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setForeground(Color.WHITE);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setBounds(23, 392, 57, 21);
		panel.add(lblSex);

		tftJoinId = new JTextField();
		tftJoinId.setBounds(112, 68, 172, 21);
		panel.add(tftJoinId);
		tftJoinId.setColumns(10);

		tftJoinPw = new JPasswordField();
		tftJoinPw.setColumns(10);
		tftJoinPw.setBounds(112, 122, 172, 21);
		panel.add(tftJoinPw);

		tftJoinCPw = new JPasswordField();
		tftJoinCPw.setColumns(10);
		tftJoinCPw.setBounds(112, 176, 172, 21);
		panel.add(tftJoinCPw);

		tftJoinName = new JTextField();
		tftJoinName.setColumns(10);
		tftJoinName.setBounds(112, 230, 172, 21);
		panel.add(tftJoinName);

		tftJoinPhone = new JTextField();
		tftJoinPhone.setColumns(10);
		tftJoinPhone.setBounds(112, 284, 172, 21);
		panel.add(tftJoinPhone);

		btnJoinCreate = new JButton("Create");
		btnJoinCreate.setBackground(Color.WHITE);
		btnJoinCreate.setBounds(53, 440, 97, 23);
		panel.add(btnJoinCreate);

		btnJoinCancel = new JButton("Cancel");
		btnJoinCancel.setBackground(Color.WHITE);
		btnJoinCancel.setBounds(234, 440, 97, 23);
		panel.add(btnJoinCancel);

		btnJoinCheck = new JButton("CheckId");
		btnJoinCheck.setBounds(284, 67, 81, 23);
		btnJoinCheck.setBackground(Color.WHITE);
		panel.add(btnJoinCheck);


		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(23, 338, 57, 21);
		panel.add(lblEmail);

		tftJoinEmail = new JTextField();
		tftJoinEmail.setColumns(10);
		tftJoinEmail.setBounds(112, 338, 172, 21);
		panel.add(tftJoinEmail);
		sexgroup = new ButtonGroup();

		rbMale = new JRadioButton("Male");
		rbMale.setBackground(SystemColor.activeCaption);
		rbMale.setForeground(Color.BLACK);
		rbMale.setSelected(true);
		rbMale.setBounds(112, 391, 81, 23);
		panel.add(rbMale);
		sexgroup.add(rbMale);
		rbMale.setOpaque(false);
		rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(SystemColor.activeCaption);
		rbFemale.setForeground(Color.BLACK);
		rbFemale.setBounds(210, 391, 74, 23);
		panel.add(rbFemale);
		sexgroup.add(rbFemale);
		rbFemale.setOpaque(false);
		new TextPrompt("아이디 중복체크 필수", tftJoinId);
		new TextPrompt("비밀번호 입력", tftJoinPw);
		new TextPrompt("비밀번호 확인", tftJoinCPw);
		new TextPrompt("이름 입력", tftJoinName);
		new TextPrompt("\'-\'생략", tftJoinPhone);
		new TextPrompt("이메일 형식으로 입력", tftJoinEmail);
		panel.setBounds(0, 0, 394, 501);
		getContentPane().add(panel);
		panel.setLayout(null);

		
		setResizable(false);
		setBounds(100, 100, 400, 530);
		setVisible(true);
	}

}
