package web.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDatabaseTable {
	InitGlobalValue GV = new InitGlobalValue();

	public void start() {
		String DRIVER = GV.getDriver();
		String CONNURL = GV.getConnurl();
		String USER = GV.getUser();
		String PASSWORD = GV.getPassword();
		String CREATECOMPANY = GV.getCreateDatabase();
		String DROPCOMPANY = GV.getDropCompany();

		try {
			/** 找驅動程式 **/
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/** 刪除資料庫 **/
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(DROPCOMPANY);
			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.print("無法刪除資料庫");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			/** 創建資料庫 **/
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(CREATECOMPANY);
			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.print("無法創建資料庫");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		InsertDatabaseTable idt = new InsertDatabaseTable();
		idt.start();
	}
}
