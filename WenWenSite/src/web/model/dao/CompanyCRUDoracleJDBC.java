package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import globalService.GlobalValue;
import web.model.bean.CompanyCRUDBean;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyCRUDoracleJDBC implements CompanyCRUDdao {
	/** Oracle 驅動字串 **/
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	/** Oracle 連線字串 **/
	// jdbc:oracle:thin:[USER/PASSWORD]@[HOST][:PORT]:SID
	private static final String CONNURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "doraemon";
	private static final String PASSWORD = "doraemon";
	/** SQL指令 **/
	private static final String SELECT_ALL = "select * from employeeinfo";
	private static final String SELECT_BY_ID = "select * from employeeinfo where id=?";

	private static final String INSERT = "insert into employeeinfo (id,name,age,cellphone,email,hiredate) values (?,?,?,?,?,?)";
	private static final String UPDATE = "update employeeinfo set name=?,age=?,cellphone=?,email=?,hiredate=? where id=?";
	private static final String DELETE = "delete from employeeinfo where id=?";

	public List<CompanyCRUDBean> select() {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<CompanyCRUDBean> result = new ArrayList<CompanyCRUDBean>();
		CompanyCRUDBean bean = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
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

		return result;
	}

	public CompanyCRUDBean select(int id) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		CompanyCRUDBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
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
		return result;
	}

	public CompanyCRUDBean insert(CompanyCRUDBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		CompanyCRUDBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			// INSERT = "insert into company.employeeinfo
			// (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(INSERT);

			int dataSize = select().size();
			int maxid = select().get(dataSize - 1).getId();

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
				dataSize = select().size();
				CompanyCRUDBean selectBean = select().get(dataSize - 1);
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

		return result;
	}

	public CompanyCRUDBean update(CompanyCRUDBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		CompanyCRUDBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
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
				System.out.println();
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

		return result;
	}

	public boolean delete(int id) {
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
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("～～～刪除成功～～～");
				return true;
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

		return false;
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
