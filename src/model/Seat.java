package model;

public class Seat {
public Seat() {
	// TODO Auto-generated constructor stub
}
    // �¼���ȣ 
    private int sNo;

    // �¼��̸� 
    private String sId;
   
    public Seat(int sNo, String sId) {
		this.sNo = sNo;
		this.sId = sId;
	}

	public int getSNo() {
        return sNo;
    }

    public void setSNo(int sNo) {
        this.sNo = sNo;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

   
   
}