package View;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;

public class Table extends AbstractTableModel {
	String[] columnName;
	Object[][] data;

	public Table() {
	}

	public Table(String type, List<Object> list) {
		switch (type) {
		case "Book":
			Dao dao= new Dao();
			columnName = new String[] { "å��ȣ", "å�̸�", "����", "����", "���ǻ�" };
			data = new Object[list.size()][columnName.length];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = ((Book) list.get(i)).getBNo();
				data[i][1] = ((Book) list.get(i)).getBName();
				data[i][2] = ((Book) list.get(i)).getBWriter();
				data[i][3] = ((Book) list.get(i)).getBQu();
				data[i][4] = dao.printCompany(((Book) list.get(i)).getCNo());
			}
			break;
		case "Member":
			columnName = new String[] { "���̵�", "�̸�", "�̸���", "����ȣ", "����", "��й�ȣ" };
			data = new Object[list.size()][columnName.length];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = ((Member) list.get(i)).getMId();
				data[i][1] = ((Member) list.get(i)).getMName();
				data[i][2] = ((Member) list.get(i)).getMEmail();
				data[i][3] = ((Member) list.get(i)).getMPh();
				data[i][4] = ((Member) list.get(i)).getMSex();
				data[i][5] = ((Member) list.get(i)).getMPw();
			}
			break;
		case "Message":
			  columnName = new String[] { "Ÿ��","��ȣ", "������", "�߽���", "����", "�亯��ȣ" };
		         data = new Object[list.size()][columnName.length];
		         for (int i = 0; i < list.size(); i++) {
		            if(((Message) list.get(i)).getMsgNo()==((Message) list.get(i)).getReplyno()){
		               data[i][0] ="����";
		            }else{
		               data[i][0] ="����> ���";
		            }
		            data[i][1] = String.valueOf(((Message) list.get(i)).getMsgNo());
		            data[i][2] = ((Message) list.get(i)).getMsgSendid();
		            data[i][3] = ((Message) list.get(i)).getMsgInwardid();
		            data[i][4] = ((Message) list.get(i)).getMsgTitle();
		            if(((Message) list.get(i)).getMsgNo()==((Message) list.get(i)).getReplyno()){
		               data[i][5] = "";
		            } else {
		               data[i][5] = String.valueOf(((Message) list.get(i)).getReplyno());
		            }
		         }
			break;
		}

	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {

		return data[row][col];
	}
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

}
