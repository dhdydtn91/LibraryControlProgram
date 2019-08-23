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
            JOptionPane.showMessageDialog(null, "å������ �Է��ϼ���");
         }
         dao.order(book, Integer.parseInt(order.tftBookQuantity.getText()));

         // ���Ϻ�����
         new mailUtil();

         try {
            MimeMessage message = new MimeMessage(mailUtil.session);
            message.setFrom(new InternetAddress(mailUtil.user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(dao.findEmail(book.getBName())));

            // ��������
            message.setSubject("\"" + book.getBName() + "\" å    " + order.tftBookQuantity.getText() + "�� �ֹ��մϴ�.");

            // ���ϳ���
            if (order.tftOrderMsg.getText().equals("")) {
               message.setText("4�� ������Ʈ �Դϴ�.\n\"" + book.getBName() + "\"å    \'" + order.tftBookQuantity.getText()
                     + "\' �� ��� ��Ź�帳�ϴ�.\n\n�����մϴ�.");
            } else {
               message.setText("4�� ������Ʈ �Դϴ�.\n\"" + book.getBName() + "\"å    \'" + order.tftBookQuantity.getText()
                     + "\' �� ��� ��Ź�帳�ϴ�.\n\n" + "�߰��޼��� : " + order.tftOrderMsg.getText() + "\n\n�����մϴ�.");

            }

            Transport.send(message);
            System.out.println("���Ϻ����⼺��");
         } catch (AddressException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("���Ϻ��������");
         } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("���Ϻ��������");
         }
         order.dispose();
      } else if (btn == order.btnCancel) {
         order.dispose();
      } else {

      }

   }
}