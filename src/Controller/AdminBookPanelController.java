package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.AdminBookPanel;
import View.Table;
import model.Book;
import util.Resource;

public class AdminBookPanelController implements ActionListener, Resource {
	
	AdminBookPanel adminbookpanel = new AdminBookPanel(dao.getId(), new Table("Book", dao.searchAll("Book")));

	String comboBoxtitle;
	String tftcontent;
	List<Object> list = new ArrayList<>();
	Book book = new Book();

	public AdminBookPanelController() {

		adminbookpanel.btnBookSearch.addActionListener(this);
		adminbookpanel.btnBookAdd.addActionListener(this);
		adminbookpanel.btnBookDelete.addActionListener(this);
		adminbookpanel.btnBookOrder.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == adminbookpanel.btnBookSearch) {
			// 콤보박스 선택 후 텍스트 필드에 있는 값으로 검색
			comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
			tftcontent = adminbookpanel.tftBookSearch.getText();
			if (tftcontent.equals("")) {
				JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
			} else if (comboBoxtitle == "No") {

				adminbookpanel.settable(new Table("Book", dao.searchBook("Book", tftcontent, comboBoxtitle)));
			
			} else {
				adminbookpanel.settable( new Table("Book", dao.searchBook("Book", tftcontent, comboBoxtitle)));
				
			}
		} else if (btn == adminbookpanel.btnBookAdd) {
			// 책추가를 위한 새로운 창 실행
			new AddBookController();
			adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
		} else if (btn == adminbookpanel.btnBookDelete) {
			if (adminbookpanel.jTable.getSelectedColumn() > -1) {
				// 테이블에서 선택으로 삭제
				tftcontent = (String) adminbookpanel.jTable.getValueAt(adminbookpanel.jTable.getSelectedRow(), 1);
				dao.deleteBook("Name", tftcontent);
				adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
				JOptionPane.showMessageDialog(null, "책이 삭제 되었습니다");
			} else if (!(adminbookpanel.tftBookSearch.getText().equals(""))) {
				// 텍스트필트에 있는 값으로 삭제
				comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
				tftcontent = adminbookpanel.tftBookSearch.getText();
				dao.deleteBook(comboBoxtitle, tftcontent);
				adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
				JOptionPane.showMessageDialog(null, "책이 삭제 되었습니다");
			} else {
				JOptionPane.showMessageDialog(null, "삭제할 책을 입력하시오. ");
			}

		} else if (btn == adminbookpanel.btnBookOrder) {
			if (adminbookpanel.jTable.getSelectedColumn() > -1) {
				// 테이블에서 선택
				tftcontent = (String) adminbookpanel.jTable.getValueAt(adminbookpanel.jTable.getSelectedRow(), 1);
				list = dao.searchBook("Book", tftcontent, "Name");
				book = (Book) list.get(0);
				new OrderController(book);
			} else if (!(adminbookpanel.tftBookSearch.getText().equals(""))) {
				// 텍스트필트에 있는 값으로 선택
				comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
				tftcontent = adminbookpanel.tftBookSearch.getText();
				list = dao.searchBook("Book", tftcontent, comboBoxtitle);
				book = (Book) list.get(0);
				new OrderController(book);
			} else {
				JOptionPane.showMessageDialog(null, "주문할 책을 검색하거나 선택하시오 ");
			}

		} else {

		}
	}
}