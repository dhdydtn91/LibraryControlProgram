package model;

//회원 
public class Member {
public Member() {
	// TODO Auto-generated constructor stub
}
 // 회원아이디 
 private String mId;

 // 회원비밀번호 
 private String mPw;

 // 회원이름 
 private String mName;

 // 회원폰번호 
 private String mPh;

 // 회원이메일 
 private String mEmail;

 // 회원성별 
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