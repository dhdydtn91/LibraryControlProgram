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

import View.FindPw;
import model.Member;
import util.Resource;
import util.mailUtil;

public class FindPWController implements ActionListener, Resource {
   FindPw findpw = new FindPw();
   int count = 0;

   public FindPWController() {
      findpw.btnFind.addActionListener(this);
      findpw.btnCancel.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton btn = (JButton) e.getSource();
      if (btn == findpw.btnFind) {
         Member member = new Member();
         if (findpw.tftFindID.getText().equals(""))
            JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
         else if (findpw.tftFindName.getText().equals(""))
            JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
         else {
            member.setMId(findpw.tftFindID.getText());
            member.setMName(findpw.tftFindName.getText());
            Member member2 = dao.findPw(member);
            if (member2.getMPw().equals(""))
               JOptionPane.showMessageDialog(null, "���̵�, �̸��� �� �� �Ǿ����ϴ�.");
            else {
               String ckStr = dao.ckMailStr();
               System.out.println(ckStr);
               // ���Ϻ�����
               new mailUtil();
               try {
                  MimeMessage message = new MimeMessage(mailUtil.session);
                  message.setFrom(new InternetAddress(mailUtil.user));
                  message.addRecipient(Message.RecipientType.TO, new InternetAddress(member2.getMEmail()));

                  // ��������
                  message.setSubject("\"" + member.getMId() + "\" ȸ���� ��й�ȣ ã�� Ȯ�� �����Դϴ�.");

                  // ���� ����
                  message.setText("4�� ������Ʈ �Դϴ�.\n\"" + member.getMId() + "\"ȸ����    \' ���ȹ��ڴ�\n\n" + ckStr
                        + "\n\n �� ������ �Է¶��� �Է����ֽñ� �ٶ��ϴ�.");
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
               while (true) {
                  if (count > 4) {
                     JOptionPane.showMessageDialog(null, "�õ�Ƚ�� �ʰ�");
                     break;
                  }
                  String Pw = JOptionPane.showInputDialog("����Ȯ��!! (" + count + "ȸ���� /5ȸ)");
                  if (Pw.equals(ckStr)) {
                     JOptionPane.showMessageDialog(null, "��й�ȣ�� " + member2.getMPw() + " �Դϴ�.");
                     break;
                  } else {
                     JOptionPane.showMessageDialog(null, "���ȹ����� Ʋ�Ƚ��ϴ�");
                     count++;
                  }
               }
               findpw.dispose();
            }
         }
      } else if (btn == findpw.btnCancel) {
         findpw.dispose();
      } else {

      }
   }
}