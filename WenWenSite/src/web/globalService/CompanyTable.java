package web.globalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyTable {
	/** 驅動字串 **/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/** 連線字串 **/
	private static final String CONNURL = "jdbc:mysql://localhost:3306/student";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	/** SQL指令 **/
	private static final String DATABASE = "create database company";

	private boolean createDatabase() {
		boolean result = false;
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(DATABASE);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		CompanyTable init = new CompanyTable();
		boolean createDB = init.createDatabase();
		System.out.println(createDB);
	}

}
