package View;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.Resource;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class MessagePanel extends JPanel implements Resource {
	public JTextField tftMsgSearch;
	public JButton btnMsgSearch;
	public JButton btnMsgSend;
	public JButton btnMsgView;
	public JComboBox comboBox;
	public JLabel lbID;
	public JScrollPane scrollPane;
	public JTable jTable;

	public MessagePanel(String loginId, Table table) {
		setLayout(null);

		tftMsgSearch = new JTextField();
		tftMsgSearch.setBounds(135, 53, 105, 23);
		add(tftMsgSearch);
		tftMsgSearch.setColumns(10);

		btnMsgSearch = new JButton("Find");
		btnMsgSearch.setBackground(Color.WHITE);
		btnMsgSearch.setBounds(238, 53, 57, 23);
		add(btnMsgSearch);

		btnMsgSend = new JButton("Send");
		btnMsgSend.setBackground(Color.WHITE);
		btnMsgSend.setBounds(319, 53, 67, 23);
		add(btnMsgSend);

		settable(table);
		String[] msgArr = { "No", "SendID", "InwardID", "Title" };
		comboBox = new JComboBox(msgArr);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(53, 53, 84, 23);
		add(comboBox);
		btnMsgView = new JButton("View");
		btnMsgView.setBackground(Color.WHITE);
		btnMsgView.setBounds(410, 53, 67, 23);

		lbID = new JLabel(loginId + "¥‘ »Øøµ«’¥œ¥Ÿ.");
		lbID.setForeground(Color.WHITE);
		lbID.setFont(new Font("MD¿ÃºŸ√º", Font.PLAIN, 20));
		lbID.setBounds(53, 15, 260, 28);
		add(lbID);

		add(btnMsgView);
		setSize(524, 485);
		setVisible(true);
	}

	public void settable(Table table) {
		jTable = new JTable(table);
		scrollPane = new JScrollPane(jTable);
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
