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

public class MessageSend extends JFrame {
   public JTextField tftTo;
   public JTextField tftTitle;
   public JButton btnSend;
   public JButton btnMsgSendCancel;
   public JTextArea tpContent;
   private JPanel panel;

   public MessageSend(String type, List<Object> list, Boolean isplay) {
	      panel= new JPanel() {
				ImageIcon img = new ImageIcon("Image//Send.png");

				public void paintComponent(Graphics g) {
					g.drawImage(img.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);

				}
			};
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(63, 69, 249, 248);
      panel.add(scrollPane);

      getContentPane().setLayout(null);
      
      if (isplay && type.equals("reply")) {
         Message Msg= (Message) list.get(0);
         tftTo = new JTextField(Msg.getMsgSendid());
         tftTitle = new JTextField(Msg.getMsgTitle() + "-re");
         JTextPane textPane = new JTextPane();
         textPane.setEditable(false);
         textPane.setContentType("text/html");
         textPane.setText("<html><body>content:" + Msg.getMsgContent() + "<br><br>"
               + "────────────────────────────────" + "<br><br>" + "</body></html>");
         scrollPane.setColumnHeaderView(textPane);
      } else if (isplay && type.equals("send")) {
         Message Msg= (Message) list.get(0);
         tftTo = new JTextField(Msg.getMsgSendid());
         tftTitle = new JTextField();
         tpContent = new JTextArea();
      } else {
         tftTo = new JTextField();
         tftTitle = new JTextField();
         tpContent = new JTextArea();
      } // JTable 로우를 선택하면 보내는 아이디에 컬럼이 들어가고 아닐경우 빈칸
      JLabel lbTitle = new JLabel("Title");
      lbTitle.setForeground(Color.WHITE);
      lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
      lbTitle.setBounds(54, 39, 57, 15);

      panel.add(lbTitle);

      tpContent = new JTextArea();
      tpContent.setLineWrap(true);
      tpContent.setRows(10);
      tpContent.setColumns(1);
      scrollPane.setViewportView(tpContent);

      btnSend = new JButton("Send");
      btnSend.setBackground(Color.WHITE);
      btnSend.setBounds(63, 339, 97, 23);
      panel.add(btnSend);

      btnMsgSendCancel = new JButton("Cancel");
      btnMsgSendCancel.setBackground(Color.WHITE);
      btnMsgSendCancel.setBounds(215, 339, 97, 23);
      panel.add(btnMsgSendCancel);

      JLabel lblTo = new JLabel("To");
      lblTo.setForeground(Color.WHITE);
      lblTo.setHorizontalAlignment(SwingConstants.CENTER);
      lblTo.setBounds(54, 14, 57, 15);
      panel.add(lblTo);

      tftTo.setBounds(123, 11, 189, 23);
      panel.add(tftTo);
      tftTo.setColumns(10);

      tftTitle.setColumns(10);
      tftTitle.setBounds(123, 36, 189, 23);
      panel.add(tftTitle);
      

      panel.setBounds(0, 0, 384, 434);
      getContentPane().add(panel);
      panel.setLayout(null);
      setVisible(true);
      setSize(400, 473);
   }
}
