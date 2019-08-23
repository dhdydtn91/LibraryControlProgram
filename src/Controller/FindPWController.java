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
            JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
         else if (findpw.tftFindName.getText().equals(""))
            JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
         else {
            member.setMId(findpw.tftFindID.getText());
            member.setMName(findpw.tftFindName.getText());
            Member member2 = dao.findPw(member);
            if (member2.getMPw().equals(""))
               JOptionPane.showMessageDialog(null, "아이디, 이름이 잘 못 되었습니다.");
            else {
               String ckStr = dao.ckMailStr();
               System.out.println(ckStr);
               // 메일보내기
               new mailUtil();
               try {
                  MimeMessage message = new MimeMessage(mailUtil.session);
                  message.setFrom(new InternetAddress(mailUtil.user));
                  message.addRecipient(Message.RecipientType.TO, new InternetAddress(member2.getMEmail()));

                  // 메일제목
                  message.setSubject("\"" + member.getMId() + "\" 회원님 비밀번호 찾기 확인 메일입니다.");

                  // 메일 내용
                  message.setText("4조 프로젝트 입니다.\n\"" + member.getMId() + "\"회원님    \' 보안문자는\n\n" + ckStr
                        + "\n\n 위 문구를 입력란에 입력해주시기 바랍니다.");
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
               while (true) {
                  if (count > 4) {
                     JOptionPane.showMessageDialog(null, "시도횟수 초과");
                     break;
                  }
                  String Pw = JOptionPane.showInputDialog("메일확인!! (" + count + "회실패 /5회)");
                  if (Pw.equals(ckStr)) {
                     JOptionPane.showMessageDialog(null, "비밀번호는 " + member2.getMPw() + " 입니다.");
                     break;
                  } else {
                     JOptionPane.showMessageDialog(null, "보안문구가 틀렸습니다");
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