package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class AddBook extends JFrame {
	public JTextField tftBookName;
	public JTextField tftBookWriter;
	public JTextField tftBookQuantity;
	public JTextField tftBookPublisher;
	public JButton btnAdd;
	public JButton btnCancel ;
	private JPanel panel;
	public AddBook() {
		getContentPane().setLayout(null);
		panel =new JPanel() {
			ImageIcon img = new ImageIcon("Image//AddBook.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		JLabel lbBookName = new JLabel("Name");
		lbBookName.setForeground(Color.WHITE);
		lbBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookName.setBounds(57, 96, 86, 15);
		panel.add(lbBookName);
		
		tftBookName = new JTextField();
		tftBookName.setBounds(147, 93, 163, 21);
		panel.add(tftBookName);
		tftBookName.setColumns(10);
		
		JLabel lbBookWriter = new JLabel("Writer");
		lbBookWriter.setForeground(Color.WHITE);
		lbBookWriter.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookWriter.setBounds(57, 137, 86, 15);
		panel.add(lbBookWriter);
		
		tftBookWriter = new JTextField();
		tftBookWriter.setColumns(10);
		tftBookWriter.setBounds(147, 134, 163, 21);
		panel.add(tftBookWriter);
		
		JLabel lbBookQuantity = new JLabel("Quantity");
		lbBookQuantity.setForeground(Color.WHITE);
		lbBookQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbBookQuantity.setBounds(57, 180, 86, 15);
		panel.add(lbBookQuantity);
		
		tftBookQuantity = new JTextField();
		tftBookQuantity.setColumns(10);
		tftBookQuantity.setBounds(147, 177, 163, 21);
		panel.add(tftBookQuantity);
		
		JLabel lbPublisher = new JLabel("Publisher");
		lbPublisher.setForeground(Color.WHITE);
		lbPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lbPublisher.setBounds(57, 225, 86, 15);
		panel.add(lbPublisher);
		
		tftBookPublisher = new JTextField();
		tftBookPublisher.setColumns(10);
		tftBookPublisher.setBounds(147, 222, 163, 21);
		panel.add(tftBookPublisher);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(74, 295, 97, 23);
		panel.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(213, 295, 97, 23);
		panel.add(btnCancel);
		
		
		panel.setBounds(0, 0, 384, 361);
		getContentPane().add(panel);
		panel.setLayout(null);
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
}
