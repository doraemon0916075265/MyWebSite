package web.globalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import globalService.GlobalValue;

public class CreateDatabaseTable {
	/** 在 Eclipse console 建立資料庫 **/
	/** 驅動字串 **/
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	/** 連線字串 **/
	private static final String MYSQL_CONNURL = "jdbc:mysql://localhost:3306/student";
	private static final String MYSQL_USER = "root";
	private static final String MYSQL_PASSWORD = "root";

	/** SQL指令 **/
	private static final String MYSQL_CREATE_DATABASE = "create database ";
	private static final String MYSQL_DROP_DATABASE = "drop database ";

	private boolean createDatabase(String databaseName) {
		/** 新增資料庫 **/
		boolean result = false;
		try {
			// 找驅動程式
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		String SQLdatabaseName = MYSQL_CREATE_DATABASE + databaseName;

		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(SQLdatabaseName);

			try {
				int count = pstmt.executeUpdate();
				if (count == 1) {
					result = true;
				}
			} catch (Exception e) {
				System.out.print("無法執行操作，");
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

		return result;
	}

	private boolean dropDatabase(String databaseName) {
		/** 刪除資料庫 **/
		try {
			// 找驅動程式
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String SQLdatabaseName = MYSQL_DROP_DATABASE + databaseName;

		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(SQLdatabaseName);

			try {
				pstmt.executeUpdate();
				result = true;
			} catch (Exception e) {
				System.out.print("無法執行操作，");
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

		return result;
	}

	public static void main(String[] args) {
		CreateDatabaseTable init = new CreateDatabaseTable();
		GlobalValue USE = new GlobalValue();

		String input;
		String inputName;
		String continueAction = "y";

		while (continueAction.trim().toLowerCase().equals("y")) {
			Scanner sc = new Scanner(System.in);
			System.out.println("你想執行的操作？\t建立資料庫 = createDB ; 移除資料庫 =dropDB");
			input = sc.next();

			if (input.trim().toLowerCase().equals("createdb")) {
				/** 建立database **/
				System.out.println("欲創建資料庫名稱：");
				inputName = sc.next();
				boolean isCreateDB = init.createDatabase(inputName);
				if (isCreateDB) {
					System.out.println("創建成功：" + isCreateDB);
				} else {
					System.out.println("創建失敗");
				}
			} else if (input.trim().toLowerCase().equals("dropdb")) {
				/** 刪除database **/
				System.out.println("欲刪除資料庫名稱：");
				inputName = sc.next();
				boolean isDropDB = init.dropDatabase(inputName);
				if (isDropDB) {
					System.out.println("刪除成功：" + isDropDB);
				} else {
					System.out.println("刪除失敗");
				}
			}

			System.out.println("輸入 y 繼續，任意鍵結束...");
			continueAction = sc.next();
			USE.Demarcation();
			if (!continueAction.trim().toLowerCase().equals("y")) {
				System.out.println("結束");
			}
		}
	}

}
