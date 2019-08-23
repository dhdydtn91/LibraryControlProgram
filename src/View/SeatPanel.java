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
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

public class SeatPanel extends JPanel {
   public JButton btnSeat[]=new JButton[12];
   public ImageIcon useImage;
   public ImageIcon banImage;
   public ImageIcon emptyImage;
   public JLabel lbID;
   public SeatPanel(String loginId) {
      setLayout(null);
      
      useImage = new ImageIcon("Image//use.png");
      banImage = new ImageIcon("Image//ban.png");
      emptyImage = new ImageIcon("Image//empty.png");
      btnSeat[0] = new JButton("1");
      btnSeat[0].setBackground(Color.WHITE);
      btnSeat[0].setBounds(86, 138, 70, 70);
      add(btnSeat[0]);

      JPanel usablePanel = new JPanel();
      usablePanel.setBounds(305, 52, 180, 54);
      add(usablePanel);
      usablePanel.setLayout(new GridLayout(1, 3, 0, 0));
      usablePanel.setBackground(Color.white);
     
      JLabel lbempty = new JLabel(emptyImage);
      lbempty.setBackground(Color.RED);
      usablePanel.add(lbempty);

      JLabel lbuse = new JLabel(useImage);
      lbuse.setBackground(Color.BLACK);
      usablePanel.add(lbuse);

      JLabel lbban = new JLabel(banImage);
      lbban.setBackground(Color.WHITE);
      usablePanel.add(lbban);

      btnSeat[1] = new JButton("2");
      btnSeat[1].setBackground(Color.WHITE);
      btnSeat[1].setBounds(179, 138, 70, 70);
      add(btnSeat[1]);

      btnSeat[2] = new JButton("3");
      btnSeat[2].setBackground(Color.WHITE);
      btnSeat[2].setBounds(86, 234, 70, 70);
      add(btnSeat[2]);

      btnSeat[3] = new JButton("4");
      btnSeat[3].setBackground(Color.WHITE);
      btnSeat[3].setBounds(179, 234, 70, 70);
      add(btnSeat[3]);

      btnSeat[4] = new JButton("5");
      btnSeat[4].setBackground(Color.WHITE);
      btnSeat[4].setBounds(86, 328, 70, 70);
      add(btnSeat[4]);

      btnSeat[5] = new JButton("6");
      btnSeat[5].setBackground(Color.WHITE);
      btnSeat[5].setBounds(179, 328, 70, 70);
      add(btnSeat[5]);

      btnSeat[6] = new JButton("7");
      btnSeat[6].setBackground(Color.WHITE);
      btnSeat[6].setBounds(321, 138, 70, 70);
      add(btnSeat[6]);

      btnSeat[7] = new JButton("8");
      btnSeat[7].setBackground(Color.WHITE);
      btnSeat[7].setBounds(415, 138, 70, 70);
      add(btnSeat[7]);

      btnSeat[8] = new JButton("9");
      btnSeat[8].setBackground(Color.WHITE);
      btnSeat[8].setBounds(321, 234, 70, 70);
      add(btnSeat[8]);

      btnSeat[9] = new JButton("10");
      btnSeat[9].setBackground(Color.WHITE);
      btnSeat[9].setBounds(415, 234, 70, 70);
      add(btnSeat[9]);

      btnSeat[10] = new JButton("11");
      btnSeat[10].setBackground(Color.WHITE);
      btnSeat[10].setBounds(321, 328, 70, 70);
      add(btnSeat[10]);

      btnSeat[11] = new JButton("12");
      btnSeat[11].setBackground(Color.WHITE);
      btnSeat[11].setBounds(415, 328, 70, 70);
      add(btnSeat[11]);
      
      lbID = new JLabel(loginId + "¥‘ »Øøµ«’¥œ¥Ÿ.");
      lbID.setForeground(Color.WHITE);
      lbID.setFont(new Font("MD¿ÃºŸ√º", Font.PLAIN, 20));
      lbID.setBounds(53, 15, 241, 28);
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

}