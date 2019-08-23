package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.Login;
import model.Member;
import util.Resource;

public class LoginController implements ActionListener, Resource, KeyListener {
	Login login;

	public LoginController() {
		login = new Login();
		login.tftId.addKeyListener(this);
		login.tftPw.addKeyListener(this);
		login.btnLogin.addActionListener(this);
		login.btnJoin.addActionListener(this);
		login.btnFindID.addActionListener(this);
		login.btnFindPw.addActionListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			actionPerformed(null);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn;
		try {
			btn = (JButton) e.getSource();
		} catch (Exception e1) {
			btn = login.btnLogin;
		}
		if (btn == login.btnLogin) {
			Member member = new Member();
			if (login.tftId.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
				login.tftId.requestFocus();
			} else if (login.tftPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
				login.tftPw.requestFocus();
			} else {
				member.setMId(login.tftId.getText());
				member.setMPw(login.tftPw.getText());
				if (dao.login(member)) {
					login.dispose();
					dao.setId(member.getMId());
					new MainController();
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요");
					login.tftId.requestFocus();
					login.tftPw.setText("");
				}
			}

		} else if (btn == login.btnJoin) {
			new JoinController();
		} else if (btn == login.btnFindID) {
			new FindIDController();
		} else if (btn == login.btnFindPw) {
			new FindPWController();
		} else {

		}
	}

	public static void main(String[] args) {
		new LoginController();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
