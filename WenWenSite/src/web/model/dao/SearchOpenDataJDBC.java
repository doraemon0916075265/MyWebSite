package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.value.database.GlobalValueSQL;
import web.model.bean.SearchOpenDataBean;
import web.model.dao.interfaces.SearchOpenDataDao;

public class SearchOpenDataJDBC implements SearchOpenDataDao {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	private static String MYSQL_USER = GVSQL.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	/** SQL指令 **/
	private static final String SELECT_OPT01_DATAURL = "select * from wenwen.wenopt01 where opt01_DataSource=? and opt01_Language=? and opt01_Item=?";

	public List<SearchOpenDataBean> selectURL(String opt01_DataSource, String opt01_Language, String opt01_Item) {
		List<SearchOpenDataBean> result = new ArrayList<SearchOpenDataBean>();
		SearchOpenDataBean bean = null;
		if (GVSQL.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(SELECT_OPT01_DATAURL);
				pstmt.setString(1, opt01_DataSource);
				pstmt.setString(2, opt01_Language);
				pstmt.setString(3, opt01_Item);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new SearchOpenDataBean();
					bean.setOpt01_DataSource(rs.getString("opt01_DataSource"));
					bean.setOpt01_Language(rs.getString("opt01_Language"));
					bean.setOpt01_Item(rs.getString("opt01_Item"));
					bean.setOpt01_DataURL(rs.getString("opt01_DataURL"));
					result.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		return result;
	}

	public static void main(String[] args) {
		/** 測試程式 **/
		SearchOpenDataJDBC output = new SearchOpenDataJDBC();
		List<SearchOpenDataBean> selectURL = new ArrayList<SearchOpenDataBean>();
		selectURL = output.selectURL("政府資料開放平臺", "中文", "景點");

		for (SearchOpenDataBean searchOpenDataBean : selectURL) {
			System.out.println(searchOpenDataBean.getOpt01_DataURL());
		}
	}
}
