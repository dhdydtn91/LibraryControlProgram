package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import util.Util;

public class Dao {
	String id;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 회원가입 member객체를 받아서 업데이트
	public void createMember(Member member) {
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1, member.getMId());
			pstmt.setString(2, member.getMPw());
			pstmt.setString(3, member.getMName());
			pstmt.setString(4, member.getMPh());
			pstmt.setString(5, member.getMEmail());
			pstmt.setString(6, member.getMSex());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "아이디가 생성되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	// 아이디 중복확인 : id를 받아서 중복이면 false 반환
	public boolean checkId(String id) {
		conn = Util.getConnection();
		boolean rt = true;
		try {
			pstmt = conn.prepareStatement("select m_ID from member where m_id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("m_id").equalsIgnoreCase(id))
					rt = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return rt;
	}

	// 회원정보 비밀번호확인 :id와 pw를 받아서 id의 비밀번호가 맞는지 확인
	public boolean checkPw(String id, String Pw) {
		conn = Util.getConnection();
		boolean rt = false;
		try {
			pstmt = conn.prepareStatement("select m_pw from member where m_id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("m_pw").equalsIgnoreCase(Pw))
					rt = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return rt;// 비밀번호가 맞으면 true
	}

	// 아이디찾기: member객체를 받아서 이름,전화번호로 아이디 반환
	public String findId(Member member) {
		conn = Util.getConnection();
		String id = "";
		try {
			pstmt = conn.prepareStatement("select m_ID from member where m_name=? and m_ph=?");
			pstmt.setString(1, member.getMName());
			pstmt.setString(2, member.getMPh());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("m_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return id;
	}

	// 비밀번호 찾기
	public Member findPw(Member member) {
		Member member2 = new Member();
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("select m_pw,m_email from member where m_id=? and m_name=?");
			pstmt.setString(1, member.getMId());
			pstmt.setString(2, member.getMName());
			rs = pstmt.executeQuery();
			member2.setMPw("");
			member2.setMEmail("");
			if (rs.next()) {
				member2.setMPw(rs.getString("m_pw"));
				member2.setMEmail(rs.getString("m_email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return member2;

	}

	// 시트 정보 배열에 저장을 위한 메소드
	public List<Seat> findSeat(int i) {
		List<Seat> list = new ArrayList<>();
		conn = util.Util.getConnection();
		try {
			if (i == 1) {
				pstmt = conn.prepareStatement("select * from Seat where m_id=?");
				pstmt.setString(1, id);
			} else if (i == 2) {
				pstmt = conn.prepareStatement("select * from Seat");
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Seat seat = new Seat();
				seat.setSNo(rs.getInt("s_no"));
				seat.setSId(rs.getString("m_id"));
				list.add(seat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.Util.close(pstmt, rs, conn);
		return list;
	}

	public boolean checkseat() {
		conn = Util.getConnection();
		boolean rt = true;
		try {
			pstmt = conn.prepareStatement("select * from seat where m_id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("m_id").equalsIgnoreCase(id))
					rt = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return rt;
	}

	// 로그인 접속
	public Boolean login(Member member) {
		Boolean login = false;
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from member where m_id=? and m_pw=?");
			pstmt.setString(1, member.getMId());
			pstmt.setString(2, member.getMPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}

		return login;
	}

	// =====================================================================
	// !!!세트!!!
	// 검색

	public List<Object> searchAll(String type) {
		List<Object> List = new ArrayList<>();
		conn = Util.getConnection();
		try {
			switch (type) {
			case "Book":
				pstmt = conn.prepareStatement("select * from book");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Book book = new Book();
					book.setBNo(rs.getInt("b_no"));
					book.setBName(rs.getString("b_name"));
					book.setBWriter(rs.getString("b_writer"));
					book.setBQu(rs.getInt("b_qu"));
					book.setCNo(rs.getInt("c_no"));
					List.add(book);
				}
				break;
			case "Member":
				pstmt = conn.prepareStatement("select * from Member");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Member member = new Member();
					member.setMId(rs.getString("m_id"));
					member.setMName(rs.getString("m_name"));
					member.setMPh(rs.getString("m_ph"));
					member.setMEmail(rs.getString("m_email"));
					member.setMSex(rs.getString("m_sex"));
					member.setMPw(rs.getString("m_pw"));
					List.add(member);
				}
				break;
			case "Message":
				if (id.equals("admin")) {
					pstmt = conn.prepareStatement("select * from message order by reply_no desc,msg_no");
				} else {
					pstmt = conn.prepareStatement(
							"select * from message where msg_id=? or m_id=? order by reply_no desc,msg_no");
					pstmt.setString(1, id);
					pstmt.setString(2, id);
				}
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Message message = new Message();
					message.setMsgNo(rs.getInt("msg_no"));
					message.setMsgSendid(rs.getString("m_id"));
					message.setMsgInwardid(rs.getString("msg_id"));
					message.setMsgTitle(rs.getString("msg_title"));
					message.setMsgContent(rs.getString("msg_content"));
					message.setReplyno(rs.getInt("reply_no"));
					List.add(message);
				}
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}

		return List;
	}

	public List<Object> searchBook(String type, String tftcontent, String comboBoxtitle) {
		List<Object> List = new ArrayList<>();

		conn = Util.getConnection();
		try {
			switch (type) {
			case "Book":
				try {
					switch (comboBoxtitle) {
					case "No":
						pstmt = conn.prepareStatement("select * from book where b_no LIKE ?");
						pstmt.setInt(1, Integer.parseInt(tftcontent));
						break;
					case "Name":
						pstmt = conn.prepareStatement("select * from book  where  b_name LIKE ?");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					case "Writer":
						pstmt = conn.prepareStatement("select * from book  where b_writer LIKE ?");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					case "Pulisher":
						pstmt = conn.prepareStatement(
								"select * from book  where  c_no=(select c_no from company where c_name LIKE ?");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					}
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Book book = new Book();
						book.setBNo(rs.getInt("b_no"));
						book.setBName(rs.getString("b_name"));
						book.setBWriter(rs.getString("b_writer"));
						book.setBQu(rs.getInt("b_qu"));
						book.setCNo(rs.getInt("c_no"));
						List.add(book);
					}
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(null, "숫자를 입력하세요");

				}
				break;
			case "Member":
				switch (comboBoxtitle) {
				case "ID":
					pstmt = conn.prepareStatement("select * from member where m_id like ?");
					pstmt.setString(1, "%"+tftcontent+"%");
					break;
				case "Name":
					pstmt = conn.prepareStatement("select * from member where m_name like ?");
					pstmt.setString(1, "%"+tftcontent+"%");
					break;
				}
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Member member = new Member();
					member.setMId(rs.getString("m_id"));
					member.setMName(rs.getString("m_name"));
					member.setMPh(rs.getString("m_ph"));
					member.setMEmail(rs.getString("m_email"));
					member.setMSex(rs.getString("m_sex"));
					member.setMPw(rs.getString("m_pw"));
					List.add(member);
				}
				break;
			case "Message":
				try {
					switch (comboBoxtitle) {
					case "No":
						pstmt = conn
								.prepareStatement("select * from message where msg_no like ?  order by reply_no desc,msg_no");
						pstmt.setInt(1, Integer.parseInt(tftcontent));
						break;
					case "Title":
						pstmt = conn.prepareStatement(
								"select * from message where msg_Title like ? order by reply_no desc,msg_no");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					case "SendID":
						pstmt = conn
								.prepareStatement("select * from message where m_id like ? order by reply_no desc,msg_no");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					case "InwardID":
						pstmt = conn
								.prepareStatement("select * from message where msg_id like ? order by reply_no desc,msg_no");
						pstmt.setString(1, "%"+tftcontent+"%");
						break;
					}
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Message message = new Message();
						message.setMsgNo(rs.getInt("msg_no"));
						message.setMsgSendid(rs.getString("m_id"));
						message.setMsgInwardid(rs.getString("msg_id"));
						message.setMsgTitle(rs.getString("msg_title"));
						message.setMsgContent(rs.getString("msg_content"));
						message.setReplyno(rs.getInt("reply_no"));
						List.add(message);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "숫자를 입력하세요");
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return List;
	}

	public void createBook(Book book, int companyNum) {
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("insert into book values(BOOK_SEQ.nextval,?,?,?,?)");
			pstmt.setString(1, book.getBName());
			pstmt.setString(2, book.getBWriter());
			pstmt.setInt(3, book.getBQu());
			pstmt.setInt(4, companyNum);
			int result = pstmt.executeUpdate();
			if (!(result > 0)) {
				System.out.println("입력 실패!");
			} else {
				JOptionPane.showMessageDialog(null, "도서 추가 성공");
			}
		} catch (SQLException e) {
		} finally {
			util.Util.close(pstmt, rs, conn);
		}
	}

	// 도서삭제 : book객체의 bookno로 delete
	public void deleteBook(String comboBoxtitle, String tftcontent) {
		System.out.println("delete...");
		conn = Util.getConnection();
		try {
			switch (comboBoxtitle) {
			case "No":
				pstmt = conn.prepareStatement("delete from book where b_no=?");
				pstmt.setInt(1, Integer.parseInt(tftcontent));
				break;
			case "Name":
				pstmt = conn.prepareStatement("delete from book  where  b_name=?");
				pstmt.setString(1, tftcontent);
				break;
			case "Writer":
				pstmt = conn.prepareStatement("delete from book  where b_writer=?");
				pstmt.setString(1, tftcontent);
				break;
			case "Pulisher":
				pstmt = conn.prepareStatement("delete from book  where  c_no=?");
				pstmt.setString(1, tftcontent);
				break;
			}
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	public void createCompany(Company company) {
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("insert into company values(company_seq.nextval,?,?)");
			pstmt.setString(1, company.getCName());
			pstmt.setString(2, company.getCEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	public int findCompany(String cName) {
		// 컴퍼니 넘버 99999일때 없는 회사 처리
		int num = 99999;
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("select c_no from company where c_name=?");
			pstmt.setString(1, cName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("c_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return num;
	}

	// 이메일 주문 : book객체와 수량을 받아서 수량증가
	public void order(Book book, int qu) {
		conn = Util.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update book set b_qu=(select b_qu from book where b_name=?)+? where b_name=?");
			pstmt.setString(1, book.getBName());
			pstmt.setInt(2, qu);
			pstmt.setString(3, book.getBName());
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	// 좌석 설정
	public void setSeatUpdate(String Loginid, Seat seat) {
		conn = util.Util.getConnection();
		try {
			pstmt = conn.prepareStatement("Update Seat Set m_id=? where s_no=?");
			pstmt.setString(1, Loginid);
			pstmt.setInt(2, seat.getSNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.Util.close(pstmt, rs, conn);
		}

	}

	public void setSeatDelete(String Loginid, Seat seat) {
		// 아이티컬럼에
		// null == 빈자리
		// admin == 블락
		// 나머지 == 점유좌석
		conn = util.Util.getConnection();
		try {
			pstmt = conn.prepareStatement("Update Seat Set m_id=? where s_No=?");
			pstmt.setString(1, "");
			pstmt.setInt(2, seat.getSNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.Util.close(pstmt, rs, conn);
		}
	}

	// 회원수정
	public void modifyMember(Member M) {
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("update member set m_pw=?,m_name=?,m_ph=?,m_email=?,m_sex=? where m_id=?");
			pstmt.setString(1, M.getMPw());
			pstmt.setString(2, M.getMName());
			pstmt.setString(3, M.getMPh());
			pstmt.setString(4, M.getMEmail());
			pstmt.setString(5, M.getMSex());
			pstmt.setString(6, M.getMId());
			int res = pstmt.executeUpdate();
			if (!(res > 0)) {
				JOptionPane.showMessageDialog(null, "수정실패!");
			} else {
				JOptionPane.showMessageDialog(null, "수정성공!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	// 도서삭제
	public void deleteMember(Member M) {
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("delete from member where m_id=?");
			pstmt.setString(1, M.getMId());
			int res = pstmt.executeUpdate();
			if (!(res > 0)) {
				JOptionPane.showMessageDialog(null, "삭제실패!");
			} else {
				JOptionPane.showMessageDialog(null, "삭제성공!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
	}

	// 메시지 보내기
	public void sendMessage(Message Msg, String type) {
		conn = util.Util.getConnection();
		try {
			if (type.equals("send")) {
				pstmt = conn.prepareStatement(
						"insert into message values(MESSAGE_SEQ.nextval,?,?,?,?,message_seq.currval)");
				pstmt.setString(1, Msg.getMsgSendid());
				pstmt.setString(2, Msg.getMsgInwardid());
				pstmt.setString(3, Msg.getMsgTitle());
				pstmt.setString(4, Msg.getMsgContent());
			} else {
				pstmt = conn.prepareStatement("insert into message values(MESSAGE_SEQ.nextval,?,?,?,?,?)");
				pstmt.setString(1, Msg.getMsgSendid());
				pstmt.setString(2, Msg.getMsgInwardid());
				pstmt.setString(3, Msg.getMsgTitle());
				pstmt.setString(4, Msg.getMsgContent());
				pstmt.setInt(5, Msg.getReplyno());
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.Util.close(pstmt, rs, conn);
		}
	}

	// 메시지 보기
	public List<Message> viewMessage(String loginid) throws SQLException {
		List<Message> list = new ArrayList<>();
		conn = util.Util.getConnection();
		pstmt = conn.prepareStatement("select * from message where m_id=? or msg_id=?");
		pstmt.setString(1, loginid);
		pstmt.setString(2, loginid);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Message Msg = new Message();
			Msg.setMsgNo(rs.getInt("msg_no"));
			Msg.setMsgSendid(rs.getString("m_id"));
			Msg.setMsgInwardid(rs.getString("msg_id"));
			Msg.setMsgTitle(rs.getString("msg_title"));
			Msg.setMsgContent(rs.getString("msg_content"));
			Msg.setReplyno(rs.getInt("reply_no"));
			list.add(Msg);
		}
		util.Util.close(pstmt, rs, conn);
		return list;
	}

	public void deleteMessage(Message M) {
		conn = util.Util.getConnection();
		try {
			pstmt = conn.prepareStatement("delete from message where msg_no=?");
			pstmt.setInt(1, M.getMsgNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.Util.close(pstmt, rs, conn);
		}
	}

	public List<String> findWord() {
		List<String> list = new ArrayList<>();
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from findword");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("word"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}

		return list;

	}

	public String findEmail(String bName) {
		String email = null;
		conn = Util.getConnection();
		try {
			pstmt = conn
					.prepareStatement("select c_email from company where c_no=(select c_no from book where b_name=?)");
			pstmt.setString(1, bName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				email = rs.getString("c_email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return email;
	}

	public String printCompany(int cNo) {
		String cName = null;
		conn = Util.getConnection();
		try {
			pstmt = conn.prepareStatement("select c_name from company where c_no=?");
			pstmt.setInt(1, cNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cName = rs.getString("c_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(pstmt, rs, conn);
		}
		return cName;
	}

	   public String ckMailStr() {
	      Random random = new Random();
	      int rand = (random.nextInt(6) + 1);
	      String ckStr = null;
	      conn = Util.getConnection();

	      try {
	         pstmt = conn.prepareStatement("select fpw_word from findword where fpw_no=?");
	         pstmt.setInt(1, rand);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            ckStr = rs.getString("fpw_word");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         Util.close(pstmt, rs, conn);
	      }
	      return ckStr;
	   }
}