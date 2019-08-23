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
			// �޺��ڽ� ���� �� �ؽ�Ʈ �ʵ忡 �ִ� ������ �˻�
			comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
			tftcontent = adminbookpanel.tftBookSearch.getText();
			if (tftcontent.equals("")) {
				JOptionPane.showMessageDialog(null, "�˻��� ������ �Է��ϼ���");
			} else if (comboBoxtitle == "No") {

				adminbookpanel.settable(new Table("Book", dao.searchBook("Book", tftcontent, comboBoxtitle)));
			
			} else {
				adminbookpanel.settable( new Table("Book", dao.searchBook("Book", tftcontent, comboBoxtitle)));
				
			}
		} else if (btn == adminbookpanel.btnBookAdd) {
			// å�߰��� ���� ���ο� â ����
			new AddBookController();
			adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
		} else if (btn == adminbookpanel.btnBookDelete) {
			if (adminbookpanel.jTable.getSelectedColumn() > -1) {
				// ���̺��� �������� ����
				tftcontent = (String) adminbookpanel.jTable.getValueAt(adminbookpanel.jTable.getSelectedRow(), 1);
				dao.deleteBook("Name", tftcontent);
				adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
				JOptionPane.showMessageDialog(null, "å�� ���� �Ǿ����ϴ�");
			} else if (!(adminbookpanel.tftBookSearch.getText().equals(""))) {
				// �ؽ�Ʈ��Ʈ�� �ִ� ������ ����
				comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
				tftcontent = adminbookpanel.tftBookSearch.getText();
				dao.deleteBook(comboBoxtitle, tftcontent);
				adminbookpanel.settable(new Table("Book", dao.searchAll("Book")));
				JOptionPane.showMessageDialog(null, "å�� ���� �Ǿ����ϴ�");
			} else {
				JOptionPane.showMessageDialog(null, "������ å�� �Է��Ͻÿ�. ");
			}

		} else if (btn == adminbookpanel.btnBookOrder) {
			if (adminbookpanel.jTable.getSelectedColumn() > -1) {
				// ���̺��� ����
				tftcontent = (String) adminbookpanel.jTable.getValueAt(adminbookpanel.jTable.getSelectedRow(), 1);
				list = dao.searchBook("Book", tftcontent, "Name");
				book = (Book) list.get(0);
				new OrderController(book);
			} else if (!(adminbookpanel.tftBookSearch.getText().equals(""))) {
				// �ؽ�Ʈ��Ʈ�� �ִ� ������ ����
				comboBoxtitle = adminbookpanel.comboBox.getSelectedItem().toString();
				tftcontent = adminbookpanel.tftBookSearch.getText();
				list = dao.searchBook("Book", tftcontent, comboBoxtitle);
				book = (Book) list.get(0);
				new OrderController(book);
			} else {
				JOptionPane.showMessageDialog(null, "�ֹ��� å�� �˻��ϰų� �����Ͻÿ� ");
			}

		} else {

		}
	}
}