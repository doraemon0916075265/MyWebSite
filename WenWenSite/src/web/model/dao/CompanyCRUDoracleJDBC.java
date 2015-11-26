package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import global.value.database.GlobalValueSQL;
import web.model.bean.CompanyCRUDBean;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyCRUDoracleJDBC implements CompanyCRUDdao {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** Oracle 連線字串 **/
	private static String ORACLE_CONNURL = GVSQL.getORACLE_CONNURL();
	private static String ORACLE_USER = GVSQL.getORACLE_USER();
	private static String ORACLE_PASSWORD = GVSQL.getORACLE_PASSWORD();
	/** SQL指令 **/
	private static final String SELECT_ALL = "select * from employeeinfo";
	private static final String SELECT_BY_ID = "select * from employeeinfo where id=?";
	private static final String INSERT = "insert into employeeinfo (id,name,age,cellphone,email,hiredate) values (?,?,?,?,?,?)";
	private static final String UPDATE = "update employeeinfo set name=?,age=?,cellphone=?,email=?,hiredate=? where id=?";
	private static final String DELETE = "delete from employeeinfo where id=?";

	public List<CompanyCRUDBean> select() {
		List<CompanyCRUDBean> result = new ArrayList<CompanyCRUDBean>();
		if (GVSQL.isUsefulOracleDriver()) {
			CompanyCRUDBean bean = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(SELECT_ALL);
				rs = pstmt.executeQuery(SELECT_ALL);

				while (rs.next()) {
					bean = new CompanyCRUDBean();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setAge(rs.getInt("age"));
					bean.setCellphone(rs.getString("cellphone"));
					bean.setEmail(rs.getString("email"));
					bean.setHiredate(rs.getDate("hiredate"));
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

	public CompanyCRUDBean select(int id) {
		CompanyCRUDBean result = null;
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(SELECT_BY_ID);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					result = new CompanyCRUDBean();
					result.setId(rs.getInt("id"));
					result.setName(rs.getString("name"));
					result.setAge(rs.getInt("age"));
					result.setCellphone(rs.getString("cellphone"));
					result.setEmail(rs.getString("email"));
					result.setHiredate(rs.getDate("hiredate"));
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

	public CompanyCRUDBean insert(CompanyCRUDBean bean) {
		CompanyCRUDBean result = null;
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				// INSERT = "insert into company.employeeinfo
				// (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(INSERT);

				List<CompanyCRUDBean> templist = select();
				int dataSize = templist.size();
				int[] tempid = new int[dataSize];
				for (int i = 0; i < dataSize; i++) {
					tempid[i] = templist.get(i).getId();
				}

				Arrays.sort(tempid);

				int maxid = tempid[tempid.length - 1];
				if (bean != null) {
					pstmt.setInt(1, maxid + 1);
					pstmt.setString(2, bean.getName());
					pstmt.setInt(3, bean.getAge());
					pstmt.setString(4, bean.getCellphone());
					pstmt.setString(5, bean.getEmail());
					pstmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

				}
				int count = pstmt.executeUpdate();
				if (count == 1) {
					System.out.println("～～～新增成功～～～");
					CompanyCRUDBean selectBean = select(maxid + 1);
					result = selectBean;
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
		return result;
	}

	public CompanyCRUDBean update(CompanyCRUDBean bean) {
		CompanyCRUDBean result = null;
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				// UPDATE = "update company.employeeinfo set
				// name=?,age=?,cellphone=?,email=?,hiredate=? where id=?;";
				pstmt = conn.prepareStatement(UPDATE);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getAge());
				pstmt.setString(3, bean.getCellphone());
				pstmt.setString(4, bean.getEmail());

				Date hiredate = bean.getHiredate();

				if (hiredate != null) {
					pstmt.setTimestamp(5, new java.sql.Timestamp(bean.getHiredate().getTime()));
				} else {
					pstmt.setDate(5, null);
				}

				pstmt.setInt(6, bean.getId());

				int count = pstmt.executeUpdate();
				if (count == 1) {
					System.out.println("～～～更新成功～～～");
					CompanyCRUDBean updateBean = select(bean.getId());
					result = updateBean;
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

		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(DELETE);
				pstmt.setInt(1, id);

				int count = pstmt.executeUpdate();
				if (count == 1) {
					System.out.println("～～～刪除成功～～～");
					result = true;
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
		return result;
	}

	public static void main(String[] args) throws Throwable {
		/** 測試程式 **/
		// GlobalValue USE = new GlobalValue();
		// CompanyCRUDoracleJDBC output = new CompanyCRUDoracleJDBC();
		// List<CompanyCRUDBean> beansSelectAll = new
		// ArrayList<CompanyCRUDBean>();
		// CompanyCRUDBean beanSelectId = new CompanyCRUDBean();
		// CompanyCRUDBean beanInsert = new CompanyCRUDBean();
		// CompanyCRUDBean beanUpdate = new CompanyCRUDBean();
		// boolean dataDelete = false;
		//
		// beansSelectAll = output.select();
		// System.out.println("全部查詢");
		// for (CompanyCRUDBean selectBean : beansSelectAll) {
		// System.out.println(selectBean);
		// }
		// USE.Demarcation();
		//
		// beanSelectId = output.select(1);
		// System.out.println("id查詢");
		// System.out.println(beanSelectId);
		//
		// USE.Demarcation();
		//
		// System.out.println("Insert");
		// beanInsert.setName("boss");
		// beanInsert.setAge(18);
		// beanInsert.setCellphone("092222222");
		// beanInsert.setEmail("boss@gamil.com");
		// beanInsert = output.insert(beanInsert);
		// System.out.println(beanInsert);
		//
		// USE.Demarcation();
		//
		// Date now = new Date();
		// System.out.println(now);
		// System.out.println("Update");
		// beanUpdate.setName("snoopy");
		// beanUpdate.setAge(18);
		// beanUpdate.setCellphone("0955555555");
		// beanUpdate.setEmail("snoopy@gamil.com");
		// beanUpdate.setHiredate(now);
		// beanUpdate.setId(4);
		// beanUpdate = output.update(beanUpdate);
		// System.out.println(beanUpdate);
		//
		// USE.Demarcation();
		//
		// System.out.println("Delete");
		// dataDelete = output.delete(9);
		// System.out.println(dataDelete);

	}
}
