package model;

public class Company {
public Company() {
	// TODO Auto-generated constructor stub
}
    // ���ǻ��ȣ 
    private int cNo;

    // ���ǻ��̸� 
    private String cName;

    // ���ǻ��̸��� 
    private String cEmail;
    
    public Company(int cNo, String cName, String cEmail) {

		this.cNo = cNo;
		this.cName = cName;
		this.cEmail = cEmail;
	}

	public int getCNo() {
        return cNo;
    }

    public void setCNo(int cNo) {
        this.cNo = cNo;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

   
}