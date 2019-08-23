package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import model.Message;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

public class MessageView extends JFrame{
	public JButton btnReply;
	public JButton btnMsgViewDelete;
	public JLabel lbMsgViewFrom;
	public JLabel lblMsgViewTitle;
	private JPanel panel;
	
	public MessageView(List<Object> list) {
		panel = new JPanel() {
			ImageIcon img = new ImageIcon("Image//Send.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		getContentPane().setLayout(null);
		Message Msg=(Message) list.get(0);
		JLabel lblMsgViewTitleLogo = new JLabel("Title");
		lblMsgViewTitleLogo.setForeground(Color.WHITE);
		lblMsgViewTitleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgViewTitleLogo.setBounds(54, 40, 57, 15);
		panel.add(lblMsgViewTitleLogo);
		
		lblMsgViewTitle = new JLabel(Msg.getMsgTitle());
		lblMsgViewTitle.setForeground(Color.WHITE);
		lblMsgViewTitle.setBounds(123, 40, 171, 15);
		panel.add(lblMsgViewTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(63, 69, 249, 248);
		panel.add(scrollPane);
		
		JTextArea tpContent = new JTextArea(Msg.getMsgContent());
		tpContent.setLineWrap(true);
		tpContent.setBackground(Color.WHITE);
		tpContent.setEditable(false);
		scrollPane.setViewportView(tpContent);
		
		btnReply = new JButton("Reply");
		btnReply.setBackground(Color.WHITE);
		btnReply.setBounds(63, 339, 97, 23);
		panel.add(btnReply);
		
		btnMsgViewDelete = new JButton("Delete");
		btnMsgViewDelete.setBackground(Color.WHITE);
		btnMsgViewDelete.setBounds(215, 339, 97, 23);
		panel.add(btnMsgViewDelete);
		
		JLabel lbMsgViewFromLogo = new JLabel("From");
		lbMsgViewFromLogo.setForeground(Color.WHITE);
		lbMsgViewFromLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMsgViewFromLogo.setBounds(54, 15, 57, 15);
		panel.add(lbMsgViewFromLogo);
		
		lbMsgViewFrom = new JLabel(Msg.getMsgSendid());
		lbMsgViewFrom.setForeground(Color.WHITE);
		lbMsgViewFrom.setBounds(123, 15, 171, 15);
		panel.add(lbMsgViewFrom);
		
	
		panel.setBounds(0, 0, 384, 434);
		getContentPane().add(panel);
		panel.setLayout(null);
		setVisible(true);
		setSize(400, 473);
	
	}
}
