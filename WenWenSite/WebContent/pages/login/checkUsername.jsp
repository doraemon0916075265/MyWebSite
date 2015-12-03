<%@page import="com.sun.crypto.provider.RSACipher"%>
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
	String FULL_TABLE_NAME = GVSQL.getFULL_TABLE_NAME();

	String query = "select count(*) from " + FULL_TABLE_NAME + "where name=?";
	String name = request.getParameter("username");

	if (GVSQL.isUsefulMySQLDriver()) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, name);
		
		rs = pstmt.executeQuery();
		String output = "";

	}
%>