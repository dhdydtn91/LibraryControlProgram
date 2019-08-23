package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;

public class MemberBookPanel extends JPanel {
	public JTextField tftBookSearch;
	public JButton btnBookSearch;
	public JComboBox cbTypeChoice;
	public JLabel lbID;
	public JScrollPane scrollPane=new JScrollPane();
	public JTable jTable;

	public MemberBookPanel(String loginId, Table table) {
		setLayout(null);
		tftBookSearch = new JTextField();
		tftBookSearch.setBounds(135, 53, 105, 23);
		add(tftBookSearch);
		tftBookSearch.setColumns(10);

		btnBookSearch = new JButton("Find");
		btnBookSearch.setBackground(Color.WHITE);
		btnBookSearch.setBounds(238, 53, 57, 23);
		add(btnBookSearch);

		settable(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 108, 424, 322);
		add(scrollPane);
		String[] bookArr = { "No", "Name", "Writer", "Pulisher" };
		cbTypeChoice = new JComboBox(bookArr);
		cbTypeChoice.setBackground(Color.WHITE);
		cbTypeChoice.setBounds(53, 53, 84, 23);
		add(cbTypeChoice);

		lbID = new JLabel(loginId + "¥‘ »Øøµ«’¥œ¥Ÿ.");
		lbID.setForeground(Color.WHITE);
		lbID.setFont(new Font("MD¿ÃºŸ√º", Font.PLAIN, 20));
		lbID.setBounds(53, 15, 260, 28);
		add(lbID);

		setSize(524, 485);
		setVisible(true);

	}

	public void paintComponent(Graphics g) {
		ImageIcon img = new ImageIcon("Image//Main.png");

		g.drawImage(img.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponents(g);

	}

	public void settable(Table table) {
		remove(scrollPane);
		jTable = new JTable(table);
		scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(53, 108, 424, 322);
		add(scrollPane);
		setVisible(true);
	}

}
