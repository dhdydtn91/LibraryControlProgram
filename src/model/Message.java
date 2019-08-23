package model;

public class Message {
public Message() {
	// TODO Auto-generated constructor stub
}
    private int msgNo;

    private String msgSendid;

    private String msgInwardid;

    private String msgTitle;

    private String msgContent;
    private int Replyno;

    public int getReplyno() {
		return Replyno;
	}

	public void setReplyno(int replyno) {
		Replyno = replyno;
	}

	

	public Message(int msgNo, String msgSendid, String msgInwardid, String msgTitle, String msgContent, int replyno) {
	
		this.msgNo = msgNo;
		this.msgSendid = msgSendid;
		this.msgInwardid = msgInwardid;
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		Replyno = replyno;
	}

	public int getMsgNo() {
        return msgNo;
    }

    public void setMsgNo(int msgNo) {
        this.msgNo = msgNo;
    }

    public String getMsgSendid() {
        return msgSendid;
    }

    public void setMsgSendid(String msgSendid) {
        this.msgSendid = msgSendid;
    }

    public String getMsgInwardid() {
        return msgInwardid;
    }

    public void setMsgInwardid(String msgInwardid) {
        this.msgInwardid = msgInwardid;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

}