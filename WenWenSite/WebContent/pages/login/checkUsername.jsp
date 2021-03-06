<%@ page import="global.value.service.GlobalValueService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="global.value.database.GlobalValueSQL"%>
<%
	// 	Thread.sleep(1500);
%>

<%
	// 此頁純檢查帳號
	GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** MySQL 連線字串 **/
	String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	String MYSQL_USER = GVSQL.getMYSQL_USER();
	String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	String NAME_FULL_TABLE = GVSQL.getNAME_FULL_TABLE();
	String CAN_USERNAME_NOT_EXIST = GVSQL.getCAN_USERNAME_NOT_EXIST();
	String CAN_USERNAME_EXIST = GVSQL.getCAN_USERNAME_EXIST();
	String SELECT_EXIST_USERNAME = "select count(*) from " + NAME_FULL_TABLE + " where name=?";
	String username = request.getParameter("username");
	/** 輸出字串 IMG **/
	GlobalValueService GVS = new GlobalValueService();
	String IMG_TAG_CHECK = GVS.getIMG_TAG_CHECK();
	String IMG_TAG_UNCHECK = GVS.getIMG_TAG_UNCHECK();

	if (GVSQL.isUsefulMySQLDriver()) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_EXIST_USERNAME);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			String output = IMG_TAG_CHECK;
			rs.next();
			if (rs.getInt(1) >= 1) {
				output = IMG_TAG_UNCHECK + CAN_USERNAME_EXIST;
			}
			out.print("<b>" + output + "</b>");
		} catch (SQLException e) {
			out.println("Error:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
%>
