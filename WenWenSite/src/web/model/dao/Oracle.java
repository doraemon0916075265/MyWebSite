package web.model.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Oracle {

	public static void main(String[] args) {
		Connection oracle_conn = null;
		PreparedStatement oracle_stmt = null;
		ResultSet oracle_rs = null;

		Connection mssql_conn = null;
		Statement mssql_stmt = null;
		ResultSet mssql_rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			oracle_conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.215:1521:orcl", "username", "password");

			oracle_stmt = oracle_conn.prepareStatement("insert into Video_ItemInfo values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			mssql_conn = DriverManager.getConnection("jdbc:sqlserver://192.168.0.213:1433;DatabaseName=VIS", "username", "password");

			mssql_stmt = mssql_conn.createStatement();
			mssql_rs = mssql_stmt.executeQuery("select * from VideoItemInfo");

			while (mssql_rs.next()) {
				System.out.println("正在插入ItemIndex：" + mssql_rs.getInt("ItemIndex") + "的记录...");
				oracle_stmt.setInt(1, mssql_rs.getInt("ItemIndex"));
				oracle_stmt.setInt(2, mssql_rs.getInt("VideoId"));
				oracle_stmt.setString(3, mssql_rs.getString("VideoItemName"));
				oracle_stmt.setString(4, mssql_rs.getString("VideoExtName"));
				oracle_stmt.setDouble(5, mssql_rs.getDouble("VideoSize"));
				oracle_stmt.setString(6, mssql_rs.getString("VideoPath"));
				oracle_stmt.setString(7, mssql_rs.getString("VideoType"));
				oracle_stmt.setDate(8, mssql_rs.getDate("VideoDate"));
				oracle_stmt.setString(9, mssql_rs.getString("ApplicationWay"));

				oracle_stmt.executeUpdate();
			}
			System.out.println("插入数据到Video_ItemInfo表中操作已完成！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oracle_rs != null) {
					oracle_rs.close();
					oracle_rs = null;
				}

				if (oracle_stmt != null) {
					oracle_stmt.close();
					oracle_stmt = null;
				}

				if (oracle_conn != null) {
					oracle_conn.close();
					oracle_conn = null;
				}

				if (mssql_rs != null) {
					mssql_rs.close();
					mssql_rs = null;
				}

				if (mssql_stmt != null) {
					mssql_stmt.close();
					mssql_stmt = null;
				}

				if (mssql_conn != null) {
					mssql_conn.close();
					mssql_conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}