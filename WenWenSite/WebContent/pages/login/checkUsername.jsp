<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="global.value.database.GlobalValueSQL"%>
<%
	Thread.sleep(500);
%>
<%
	GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** MySQL 連線字串 **/
	String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	String MYSQL_USER = GVSQL.getMYSQL_USER();
	String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	String NAME_FULL_TABLE = GVSQL.getNAME_FULL_TABLE();
	String CAN_USERNAME_NOT_EXIST = GVSQL.getCAN_USERNAME_NOT_EXIST();
	String CAN_USERNAME_EXIST = GVSQL.getCAN_USERNAME_EXIST();

	String SQLquery = "select count(*) from " + NAME_FULL_TABLE + " where name=?";
	String username = request.getParameter("username");

	if (GVSQL.isUsefulMySQLDriver()) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(SQLquery);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			String output = CAN_USERNAME_NOT_EXIST;
			rs.next();
			if (rs.getInt(1) >= 1) {
				output = CAN_USERNAME_EXIST;
			}
			out.print(output);
		} catch (SQLException e) {
			// 			out.println("Error:" + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
			}
		}
	}
%>