package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class CreateCompany extends JFrame {
	public JTextField tftCompanyName;
	public JTextField tftCompanyEmail;
	public JTextField tftCompanyNum;
	public JButton btnCreate;
	public JButton btnCancel;
	private JPanel panel;

	public CreateCompany() {
		getContentPane().setLayout(null);
		panel= new JPanel() {
			ImageIcon img = new ImageIcon("Image//CreateCompany.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(53, 89, 57, 15);
		panel.add(lblName);

		JLabel lblPh = new JLabel("Email");
		lblPh.setForeground(Color.WHITE);
		lblPh.setHorizontalAlignment(SwingConstants.CENTER);
		lblPh.setBounds(53, 140, 57, 15);
		panel.add(lblPh);

		tftCompanyName = new JTextField();
		tftCompanyName.setBounds(122, 86, 191, 21);
		panel.add(tftCompanyName);
		tftCompanyName.setColumns(10);

		tftCompanyEmail = new JTextField();
		tftCompanyEmail.setColumns(10);
		tftCompanyEmail.setBounds(122, 137, 191, 21);
		panel.add(tftCompanyEmail);

		btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.WHITE);
		btnCreate.setBounds(65, 199, 97, 23);
		panel.add(btnCreate);

		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(218, 199, 97, 23);
		panel.add(btnCancel);

		
		panel.setBounds(0, 0, 394, 271);
		getContentPane().add(panel);
		panel.setLayout(null);
		setResizable(false);
		setBounds(500, 100, 400, 300);

		setVisible(true);
	}

}
