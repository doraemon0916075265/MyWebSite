<%@page import="java.util.*"%>
<%@ page import="global.value.service.GlobalValueService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="global.value.database.GlobalValueSQL"%>

<%
	// 此頁純檢查開放資料的 URL
	GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** MySQL 連線字串 **/
	String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	String MYSQL_USER = GVSQL.getMYSQL_USER();
	String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	String SELECT_DATA_URL = "select * from wenwen.wenopt01 where opt01_DataSource=? and opt01_Language=? and opt01_Item=?";
	// http://localhost:8080/WenWenSite/pages/getOpenData/checkOpenDataURL.jsp?opt01_DataSource=%E8%87%BA%E5%8C%97%E5%B8%82%E6%94%BF%E5%BA%9C%E8%B3%87%E6%96%99%E9%96%8B%E6%94%BE%E5%B9%B3%E5%8F%B0&opt01_Language=%E4%B8%AD%E6%96%87&opt01_Item=%E6%99%AF%E9%BB%9E
	String opt01_DataSource = request.getParameter("opt01_DataSource");
	String opt01_Language = request.getParameter("opt01_Language");
	String opt01_Item = request.getParameter("opt01_Item");

	if (GVSQL.isUsefulMySQLDriver()) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_DATA_URL);

			pstmt.setString(1, opt01_DataSource);
			pstmt.setString(2, opt01_Language);
			pstmt.setString(3, opt01_Item);

			rs = pstmt.executeQuery();
			List<String> output = new ArrayList<String>();
			while (rs.next()) {
				output.add(rs.getString("opt01_DataURL"));
			}

			for (int i = 0; i < output.size(); i++) {
				out.print(output.get(i));
			}

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
