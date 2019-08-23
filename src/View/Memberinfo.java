package View;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class Memberinfo extends JFrame {
	public JTextField tftMemberName;
	public JTextField tftMemberPhone;
	public JTextField tftMemberEmail;
	public JButton btnModify;
	public JButton btnDelete;
	public JLabel lbMemberPwLogo;
	public JPasswordField tftMemberPw;
	public JLabel lbMemberIdLogo;
	public JLabel lbMemberId;
	public JButton btnCancel;
	public JRadioButton rbFemale;
	public JRadioButton rbMale;
	public ButtonGroup sexgroup=new ButtonGroup();

	public Memberinfo(String loginId) {
		
		getContentPane().setLayout(null);
		setBounds(173, 0, 524, 485);
		JPanel panel  =new JPanel() {
			ImageIcon img = new ImageIcon("MemberInfo.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		tftMemberName = new JTextField();
		tftMemberName.setBounds(199, 192, 224, 21);
		panel.add(tftMemberName);
		tftMemberName.setColumns(10);

		tftMemberPhone = new JTextField();
		tftMemberPhone.setColumns(10);
		tftMemberPhone.setBounds(199, 233, 224, 21);
		panel.add(tftMemberPhone);

		tftMemberEmail = new JTextField();
		tftMemberEmail.setColumns(10);
		tftMemberEmail.setBounds(199, 275, 224, 21);
		panel.add(tftMemberEmail);

		JLabel lbMemberNameLogo = new JLabel("Name");
		lbMemberNameLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberNameLogo.setBounds(90, 195, 57, 15);
		panel.add(lbMemberNameLogo);

		JLabel lbMemberPhoneLogo = new JLabel("Phone");
		lbMemberPhoneLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberPhoneLogo.setBounds(90, 236, 57, 15);
		panel.add(lbMemberPhoneLogo);

		JLabel lbMemberEmailLogo = new JLabel("Email");
		lbMemberEmailLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberEmailLogo.setBounds(90, 278, 57, 15);
		panel.add(lbMemberEmailLogo);

		JLabel lbMemberSexLogo = new JLabel("Sex");
		lbMemberSexLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberSexLogo.setBounds(90, 322, 57, 15);
		panel.add(lbMemberSexLogo);

		btnModify = new JButton("Modify");
		btnModify.setBackground(Color.WHITE);
		btnModify.setBounds(84, 383, 97, 23);
		panel.add(btnModify);

		btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(218, 383, 97, 23);
		panel.add(btnDelete);

		lbMemberPwLogo = new JLabel("PW");
		lbMemberPwLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberPwLogo.setBounds(90, 153, 57, 15);
		panel.add(lbMemberPwLogo);

		tftMemberPw = new JPasswordField();
		tftMemberPw.setBounds(199, 150, 224, 21);
		panel.add(tftMemberPw);
		tftMemberPw.setColumns(10);

		lbMemberIdLogo = new JLabel("ID");
		lbMemberIdLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberIdLogo.setBounds(90, 107, 57, 15);
		panel.add(lbMemberIdLogo);

		lbMemberId = new JLabel(loginId + "´Ô È¯¿µÇÕ´Ï´Ù.");
		lbMemberId.setBounds(200, 107, 223, 15);
		panel.add(lbMemberId);

		JLabel lbMemberInfoLogo = new JLabel("MemberInfo");
		lbMemberInfoLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMemberInfoLogo.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		lbMemberInfoLogo.setBounds(150, 31, 224, 45);
		panel.add(lbMemberInfoLogo);

		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(345, 383, 97, 23);
		panel.add(btnCancel);
		
		rbMale = new JRadioButton("Male");
		rbMale.setSelected(true);
		rbMale.setBounds(202, 322, 81, 23);
		panel.add(rbMale);
		sexgroup.add(rbMale);
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setBounds(300, 322, 74, 23);
		panel.add(rbFemale);
		sexgroup.add(rbFemale);
		
		
		panel.setBounds(0, 0, 518, 456);
		getContentPane().add(panel);
		panel.setLayout(null);

		setResizable(false);
		setVisible(true);
	}
}
