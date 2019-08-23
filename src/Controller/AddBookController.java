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
				JOptionPane.showMessageDialog(null, "책이름을 입력하세요");
			} else if (addbook.tftBookWriter.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "저자를 입력하세요");
			} else if (addbook.tftBookQuantity.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "책수량을 입력하세요");
			} else if (addbook.tftBookPublisher.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "출판사를 입력하세요");
			} else {
				
				int companyNum = dao.findCompany(addbook.tftBookPublisher.getText());
				
				book.setBName(addbook.tftBookName.getText());
				book.setBWriter(addbook.tftBookWriter.getText());
				try{
				book.setBQu(Integer.parseInt(addbook.tftBookQuantity.getText()));
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "수량은 숫자만 입력가능합니다.");
					return;
				}
				if (companyNum == 99999) {
					// 출판사를 찾기 위해
					JOptionPane.showMessageDialog(null, "출판사를 등록하십시오");
					new CreateCompanyController();
					// 출판사 생성 후 다시 출판사 번호 찾기
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
