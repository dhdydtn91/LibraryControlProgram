package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FindPw extends JFrame{
	public JTextField tftFindID;
	public JTextField tftFindName;
	public JButton btnFind;
	public JButton btnCancel;
	private JPanel panel;
	public FindPw() {
		getContentPane().setLayout(null);
		 panel  = new JPanel() {
			ImageIcon img = new ImageIcon("Image//FINDPW.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(41, 89, 57, 15);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(41, 138, 57, 15);
		panel.add(lblName);
		
		tftFindID = new JTextField();
		tftFindID.setBounds(110, 86, 191, 21);
		panel.add(tftFindID);
		tftFindID.setColumns(10);
		
		tftFindName = new JTextField();
		tftFindName.setColumns(10);
		tftFindName.setBounds(110, 135, 191, 21);
		panel.add(tftFindName);
		
		btnFind = new JButton("Find");
		btnFind.setBackground(Color.WHITE);
		btnFind.setBounds(69, 199, 97, 23);
		panel.add(btnFind);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(222, 199, 97, 23);
		panel.add(btnCancel);

		
		panel.setBounds(0, 0, 394, 271);
		getContentPane().add(panel);
		setResizable(false);
		setBounds(500, 100, 400, 300);
		setVisible(true);
	}

}
