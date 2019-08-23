package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class MemberControlPanel extends JPanel {
	public JTextField tftMemberSearch;
	public JButton btnMemberSearch;
	public JButton btnMemberJoin;
	public JButton btnMemberModify;
	public JComboBox comboBox;
	public JLabel lbID;
	public JScrollPane scrollPane;
	public JTable jtable;

	public MemberControlPanel(String loginID, Table table) {
		setLayout(null);
		tftMemberSearch = new JTextField();
		tftMemberSearch.setBounds(135, 53, 105, 23);
		add(tftMemberSearch);
		tftMemberSearch.setColumns(10);

		btnMemberSearch = new JButton("Find");
		btnMemberSearch.setBackground(Color.WHITE);
		btnMemberSearch.setBounds(238, 53, 57, 23);
		add(btnMemberSearch);

		btnMemberJoin = new JButton("Join");
		btnMemberJoin.setBackground(Color.WHITE);
		btnMemberJoin.setBounds(319, 53, 67, 23);
		add(btnMemberJoin);

		setTable(table);

		btnMemberModify = new JButton("Mod");
		btnMemberModify.setBackground(Color.WHITE);
		btnMemberModify.setBounds(410, 53, 67, 23);
		add(btnMemberModify);
		String[] memebrControlArr = { "ID", "Name" };
		comboBox = new JComboBox(memebrControlArr);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(53, 53, 84, 23);
		add(comboBox);
		lbID = new JLabel(loginID+ "¥‘ »Øøµ«’¥œ¥Ÿ.");
		lbID.setForeground(Color.WHITE);
		lbID.setFont(new Font("MD¿ÃºŸ√º", Font.PLAIN, 20));
		lbID.setBounds(53, 15, 260, 28);
		add(lbID);

		setSize(524, 485);
		setVisible(true);
	}

	public void setTable(Table table) {
		jtable = new JTable(table);
		scrollPane = new JScrollPane(jtable);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(53, 108, 424, 322);
		add(scrollPane);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		ImageIcon img = new ImageIcon("Image//Main.png");

		g.drawImage(img.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponents(g);
	}

}
