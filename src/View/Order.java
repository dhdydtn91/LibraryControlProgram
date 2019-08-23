package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Book;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Order extends JFrame {
   public JTextField tftBookQuantity;
   public JTextField tftOrderMsg;
   public JButton btnOrder;
   public JButton btnCancel;
   public JLabel lbBookname;

   public Order(Book book) {
      getContentPane().setLayout(null);
      JPanel panel = new JPanel() {
			ImageIcon img = new ImageIcon("Image//Order.png");

			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
      JLabel lbBooknameLogo = new JLabel("Name");
      lbBooknameLogo.setForeground(Color.WHITE);
      lbBooknameLogo.setHorizontalAlignment(SwingConstants.CENTER);
      lbBooknameLogo.setBounds(53, 89, 57, 15);
      panel.add(lbBooknameLogo);

      JLabel lbBookquantityLogo = new JLabel("Quantity");
      lbBookquantityLogo.setForeground(Color.WHITE);
      lbBookquantityLogo.setHorizontalAlignment(SwingConstants.CENTER);
      lbBookquantityLogo.setBounds(53, 140, 57, 15);
      panel.add(lbBookquantityLogo);

      JLabel lbMsgLogo = new JLabel("Msg");
      lbMsgLogo.setForeground(Color.WHITE);
      lbMsgLogo.setHorizontalAlignment(SwingConstants.CENTER);
      lbMsgLogo.setBounds(53, 191, 57, 15);
      panel.add(lbMsgLogo);

      lbBookname = new JLabel(book.getBName());
      lbBookname.setForeground(Color.WHITE);
      lbBookname.setBounds(122, 86, 191, 21);
      panel.add(lbBookname);

      tftBookQuantity = new JTextField();
      tftBookQuantity.setBounds(122, 137, 191, 21);
      panel.add(tftBookQuantity);
      tftBookQuantity.setColumns(10);

      tftOrderMsg = new JTextField();
      tftOrderMsg.setBounds(122, 188, 191, 21);
      panel.add(tftOrderMsg);
      tftOrderMsg.setColumns(10);

      btnOrder = new JButton("Order");
      btnOrder.setBackground(Color.WHITE);
      btnOrder.setBounds(65, 250, 97, 23);
      panel.add(btnOrder);

      btnCancel = new JButton("Cancel");
      btnCancel.setBackground(Color.WHITE);
      btnCancel.setBounds(218, 250, 97, 23);
      panel.add(btnCancel);
      
      
      panel.setBounds(0, 0, 384, 361);
      getContentPane().add(panel);
      panel.setLayout(null);

      setBounds(500, 100, 400, 400);
      setVisible(true);

   }
}