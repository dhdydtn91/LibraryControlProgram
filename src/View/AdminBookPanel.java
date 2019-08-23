package View;

import javax.swing.JFrame;
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
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class AdminBookPanel extends JPanel {
	public JTextField tftBookSearch;
	public JButton btnBookSearch;
	public JButton btnBookAdd;
	public JButton btnBookDelete;
	public JButton btnBookOrder;
	public JComboBox comboBox;
	public JLabel lbID;
	public JScrollPane scrollPane=new JScrollPane();
	public JTable jTable;

	public AdminBookPanel(String loginId, Table table) {
		setLayout(null);
		tftBookSearch = new JTextField();
		tftBookSearch.setBounds(135, 53, 105, 23);
		add(tftBookSearch);
		tftBookSearch.setColumns(10);

		btnBookSearch = new JButton("Find");
		btnBookSearch.setBackground(Color.WHITE);
		btnBookSearch.setBounds(238, 53, 57, 23);
		add(btnBookSearch);

		btnBookAdd = new JButton("Add");
		btnBookAdd.setBackground(Color.WHITE);
		btnBookAdd.setBounds(319, 53, 67, 23);
		add(btnBookAdd);

		btnBookDelete = new JButton("Del");
		btnBookDelete.setBackground(Color.WHITE);
		btnBookDelete.setBounds(410, 53, 67, 23);
		add(btnBookDelete);

		settable(table);

		btnBookOrder = new JButton("Order");
		btnBookOrder.setBackground(Color.WHITE);
		btnBookOrder.setBounds(410, 440, 67, 23);
		add(btnBookOrder);

		String[] bookArr = { "No", "Name", "Writer", "Pulisher" };
		comboBox = new JComboBox(bookArr);
		comboBox.setFont(new Font("±º∏≤", Font.BOLD, 12));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(53, 53, 84, 21);
		add(comboBox);
		setSize(524, 485);
		lbID = new JLabel(loginId + "¥‘ »Øøµ«’¥œ¥Ÿ.");
		lbID.setForeground(Color.WHITE);
		lbID.setFont(new Font("MD¿ÃºŸ√º", Font.PLAIN, 20));
		lbID.setBounds(53, 15, 260, 28);
		add(lbID);

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
		scrollPane = new JScrollPane(jTable);//jTable.setVisible(true);
		scrollPane.setBounds(53, 108, 424, 322);
		add(scrollPane);
		setVisible(true);
	}

}
