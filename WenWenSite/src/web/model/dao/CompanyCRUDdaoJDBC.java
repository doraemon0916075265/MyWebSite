package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import globalService.GlobalValue;
import web.model.bean.CompanyCRUBean;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyCRUDdaoJDBC implements CompanyCRUDdao {
	/** 驅動字串 **/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/** 連線字串 **/
	private static final String CONNURL = "jdbc:mysql://localhost:3306/student";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	/** SQL指令 **/
	private static final String SELECT_ALL = "select * from company.employeeinfo";
	private static final String SELECT_BY_ID = "select * from company.employeeinfo where id=?";
	private static final String INSERT = "insert into company.employeeinfo (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";
	private static final String UPDATE = "update company.employeeinfo set name=?,age=?,cellphone=?,email=?,hiredate=? where id=?;";
	private static final String DELETE = "delete from company.employeeinfo where id=?";

	public List<CompanyCRUBean> select() {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<CompanyCRUBean> result = new ArrayList<CompanyCRUBean>();
		CompanyCRUBean bean = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new CompanyCRUBean();
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

	public CompanyCRUBean select(int id) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		CompanyCRUBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new CompanyCRUBean();
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

	public CompanyCRUBean insert(CompanyCRUBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		CompanyCRUBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			// INSERT = "insert into company.employeeinfo (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(INSERT);
			if (bean != null) {
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getAge());
				pstmt.setString(3, bean.getCellphone());
				pstmt.setString(4, bean.getEmail());
				Date hiredate = bean.getHiredate();
				if (hiredate != null) {
					long time = hiredate.getTime();
					pstmt.setDate(5, new java.sql.Date(time));
				} else {
					pstmt.setDate(5, null);
				}
			}

			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("～～～新增成功～～～");
				result = bean;
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

	public CompanyCRUBean update(CompanyCRUBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		CompanyCRUBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			// UPDATE = "update company.employeeinfo set name=?,age=?,cellphone=?,email=?,hiredate=? where id=?;";
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getAge());
			pstmt.setString(3, bean.getCellphone());
			pstmt.setString(4, bean.getEmail());

			Date hiredate = bean.getHiredate();

			if (hiredate != null) {
				long time = hiredate.getTime();
				pstmt.setDate(5, new java.sql.Date(time));
			} else {
				pstmt.setDate(5, null);
			}

			pstmt.setInt(6, bean.getId());

			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("～～～更新成功～～～");
				result = bean;
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
		GlobalValue USE = new GlobalValue();
		CompanyCRUDdaoJDBC output = new CompanyCRUDdaoJDBC();
		List<CompanyCRUBean> beansSelectAll = new ArrayList<CompanyCRUBean>();
		CompanyCRUBean beanSelectId = new CompanyCRUBean();
		CompanyCRUBean beanInsert = new CompanyCRUBean();
		CompanyCRUBean beanUpdate = new CompanyCRUBean();
		boolean dataDelete = false;
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		System.out.println(sqlTimestamp);

		beansSelectAll = output.select();
		System.out.println("全部查詢");
		for (CompanyCRUBean selectBean : beansSelectAll) {
			System.out.println(selectBean);
		}
		USE.Demarcation();

		beanSelectId = output.select(1);
		System.out.println("id查詢");
		System.out.println(beanSelectId);

		USE.Demarcation();

		System.out.println("Insert");
		beanInsert.setName("boss");
		beanInsert.setAge(18);
		beanInsert.setCellphone("092222222");
		beanInsert.setEmail("boss@gamil.com");
		beanInsert.setHiredate(sqlTimestamp);
		beanInsert = output.insert(beanInsert);
		System.out.println(beanInsert);

		USE.Demarcation();

		System.out.println("Update");
		beanUpdate.setName("snoopy");
		beanUpdate.setAge(18);
		beanUpdate.setCellphone("0955555555");
		beanUpdate.setEmail("snoopy@gamil.com");
		beanUpdate.setHiredate(sqlTimestamp);
		beanUpdate.setId(7);
		// beanUpdate = output.update(beanUpdate);
		System.out.println(beanUpdate);

		USE.Demarcation();

		System.out.println("Delete");
		// dataDelete = output.delete(9);
		System.out.println(dataDelete);

	}
}