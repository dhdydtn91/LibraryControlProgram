package model;

//ȸ�� 
public class Member {
public Member() {
	// TODO Auto-generated constructor stub
}
 // ȸ�����̵� 
 private String mId;

 // ȸ����й�ȣ 
 private String mPw;

 // ȸ���̸� 
 private String mName;

 // ȸ������ȣ 
 private String mPh;

 // ȸ���̸��� 
 private String mEmail;

 // ȸ������ 
 private String mSex;

 public Member(String mId, String mPw, String mName, String mPh, String mEmail, String mSex) {
	this.mId = mId;
	this.mPw = mPw;
	this.mName = mName;
	this.mPh = mPh;
	this.mEmail = mEmail;
	this.mSex = mSex;
}

public String getMId() {
     return mId;
 }

 public void setMId(String mId) {
     this.mId = mId;
 }

 public String getMPw() {
     return mPw;
 }

 public void setMPw(String mPw) {
     this.mPw = mPw;
 }

 public String getMName() {
     return mName;
 }

 public void setMName(String mName) {
     this.mName = mName;
 }

 public String getMPh() {
     return mPh;
 }

 public void setMPh(String mPh) {
     this.mPh = mPh;
 }

 public String getMEmail() {
     return mEmail;
 }

 public void setMEmail(String mEmail) {
     this.mEmail = mEmail;
 }

 public String getMSex() {
     return mSex;
 }

 public void setMSex(String mSex) {
     this.mSex = mSex;
 }

 
}