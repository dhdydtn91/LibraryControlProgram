package model;

	public class Book {
public Book() {
	// TODO Auto-generated constructor stub
}
	    // å��ȣ 
	    private int bNo;

	    // å�̸� 
	    private String bName;

	    // å���� 
	    private String bWriter;

	    // å���� 
	    private int bQu;

	    // ���ǻ��ȣ 
	    private int cNo;

	    
	    public Book(int bNo, String bName, String bWriter, int bQu, int cNo) {
			this.bNo = bNo;
			this.bName = bName;
			this.bWriter = bWriter;
			this.bQu = bQu;
			this.cNo = cNo;
		}

		public int getBNo() {
	        return bNo;
	    }

	    public void setBNo(int bNo) {
	        this.bNo = bNo;
	    }

	    public String getBName() {
	        return bName;
	    }

	    public void setBName(String bName) {
	        this.bName = bName;
	    }

	    public String getBWriter() {
	        return bWriter;
	    }

	    public void setBWriter(String bWriter) {
	        this.bWriter = bWriter;
	    }

	    public int getBQu() {
	        return bQu;
	    }

	    public void setBQu(int bQu) {
	        this.bQu = bQu;
	    }

	    public int getCNo() {
	        return cNo;
	    }

	    public void setCNo(int cNo) {
	        this.cNo = cNo;
	    }
}
