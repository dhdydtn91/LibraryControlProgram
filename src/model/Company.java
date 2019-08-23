package model;

public class Company {
public Company() {
	// TODO Auto-generated constructor stub
}
    // 출판사번호 
    private int cNo;

    // 출판사이름 
    private String cName;

    // 출판사이메일 
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