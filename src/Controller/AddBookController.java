package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.AddBook;
import View.AdminBookPanel;
import View.Table;
import model.Book;
import model.Company;
import util.Resource;

public class AddBookController implements ActionListener, Resource {
	AdminBookPanel adminbookpanel = new AdminBookPanel(dao.getId(), new Table("Book", dao.searchAll("Book")));
	AddBook addbook;

	public AddBookController() {
		addbook = new AddBook();
		addbook.btnAdd.addActionListener(this);
		addbook.btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == addbook.btnAdd) {
			Book book = new Book();
			Company company = new Company();
			if (addbook.tftBookName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "å�̸��� �Է��ϼ���");
			} else if (addbook.tftBookWriter.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���");
			} else if (addbook.tftBookQuantity.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "å������ �Է��ϼ���");
			} else if (addbook.tftBookPublisher.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���ǻ縦 �Է��ϼ���");
			} else {
				
				int companyNum = dao.findCompany(addbook.tftBookPublisher.getText());
				
				book.setBName(addbook.tftBookName.getText());
				book.setBWriter(addbook.tftBookWriter.getText());
				try{
				book.setBQu(Integer.parseInt(addbook.tftBookQuantity.getText()));
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է°����մϴ�.");
					return;
				}
				if (companyNum == 99999) {
					// ���ǻ縦 ã�� ����
					JOptionPane.showMessageDialog(null, "���ǻ縦 ����Ͻʽÿ�");
					new CreateCompanyController();
					// ���ǻ� ���� �� �ٽ� ���ǻ� ��ȣ ã��
				}
				book.setCNo(companyNum);
				dao.createBook(book, companyNum);
				
			}
		} else if (btn == addbook.btnCancel) {
			addbook.dispose();

		} else {

		}
	}
}
