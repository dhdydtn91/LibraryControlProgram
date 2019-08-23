package util;

import java.sql.*;

public class Util {
	   static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	   static String uid = "BookLibrary";
	   static String passwd = "1111";

	   public static Connection getConnection() {
	      Connection conn = null;
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, uid, passwd);
	      } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }

	   public static void close(Connection conn) {
	      if (conn != null)
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   public static void close(ResultSet rs) {
	      if (rs != null)
	         try {
	            rs.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   public static void close(Statement stmt) {
	      if (stmt != null)
	         try {
	            stmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   public static void close(Statement stmt, ResultSet rs, Connection conn) {
	      close(rs);
	      close(stmt);
	      close(conn);
	   }
}