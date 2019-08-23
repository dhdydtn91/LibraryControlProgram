package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.CreateCompany;
import model.Company;
import util.Resource;

public class CreateCompanyController implements ActionListener, Resource {
	CreateCompany createCompany;

	public CreateCompanyController() {
		createCompany = new CreateCompany();
		createCompany.btnCreate.addActionListener(this);
		createCompany.btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == createCompany.btnCreate) {
			Company company = new Company();
			if (createCompany.tftCompanyName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "출판사 이름을 입력하세요");
			} else if (createCompany.tftCompanyEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "출판사 이메일을 입력하세요");
			} else {
				company.setCName(createCompany.tftCompanyName.getText());
				company.setCEmail(createCompany.tftCompanyEmail.getText());
				dao.createCompany(company);
				JOptionPane.showMessageDialog(null, "출판사 정보가 등록되었습니다");
				createCompany.dispose();
			}
		} else if (btn == createCompany.btnCancel) {
			createCompany.dispose();
		} else {
		}
	}
}
