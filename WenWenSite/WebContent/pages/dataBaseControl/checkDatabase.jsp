<%@page import="java.util.*"%>
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
	String SELECT_EXIST_USERNAME = "show databases;";
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

			rs = pstmt.executeQuery();
			List<String> output = new ArrayList<String>();
			while (rs.next()) {
				output.add(rs.getString("database").toString());
			}
			for (int i = 0; i < output.size(); i++) {
				out.print("<b>" + output.get(i) + "</b><br>");
			}
		} catch (SQLException e) {
			out.println("Error:" + e.getMessage());
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
