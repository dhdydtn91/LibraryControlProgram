package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.AdminBookPanel;
import View.Order;
import View.Table;
import model.Book;
import util.Resource;
import util.mailUtil;

public class OrderController implements ActionListener, Resource {
   AdminBookPanel adminbookpanel = new AdminBookPanel(dao.getId(), new Table("Book", dao.searchAll("Book")));
   Order order;
   String comboBoxtitle;
   String tftcontent;
   String msg;
   Book book;

   public OrderController(Book book) {
      this.book = book;
      order = new Order(book);
      order.btnOrder.addActionListener(this);
      order.btnCancel.addActionListener(this);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton btn = (JButton) e.getSource();
      if (btn == order.btnOrder) {
         if (order.tftBookQuantity.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "책수량을 입력하세요");
         }
         dao.order(book, Integer.parseInt(order.tftBookQuantity.getText()));

         // 메일보내기
         new mailUtil();

         try {
            MimeMessage message = new MimeMessage(mailUtil.session);
            message.setFrom(new InternetAddress(mailUtil.user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(dao.findEmail(book.getBName())));

            // 메일제목
            message.setSubject("\"" + book.getBName() + "\" 책    " + order.tftBookQuantity.getText() + "권 주문합니다.");

            // 메일내용
            if (order.tftOrderMsg.getText().equals("")) {
               message.setText("4조 프로젝트 입니다.\n\"" + book.getBName() + "\"책    \'" + order.tftBookQuantity.getText()
                     + "\' 권 배송 부탁드립니다.\n\n감사합니다.");
            } else {
               message.setText("4조 프로젝트 입니다.\n\"" + book.getBName() + "\"책    \'" + order.tftBookQuantity.getText()
                     + "\' 권 배송 부탁드립니다.\n\n" + "추가메세지 : " + order.tftOrderMsg.getText() + "\n\n감사합니다.");

            }

            Transport.send(message);
            System.out.println("메일보내기성공");
         } catch (AddressException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("메일보내기실패");
         } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("메일보내기실패");
         }
         order.dispose();
      } else if (btn == order.btnCancel) {
         order.dispose();
      } else {

      }

   }
}