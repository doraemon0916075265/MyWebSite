package web.model.dao;

import java.util.List;

import web.model.bean.CompanyCRUBean;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyCRUDdaoJDBC implements CompanyCRUDdao {
	/** 連線字串 **/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
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
			System.out.println("driver成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver失敗");
			e.printStackTrace();
		}
		return null;
	}

	public CompanyCRUBean select(int id) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
			System.out.println("driver成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver失敗");
			e.printStackTrace();
		}
		return null;
	}

	public CompanyCRUBean insert(CompanyCRUBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
			System.out.println("driver成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver失敗");
			e.printStackTrace();
		}
		return null;
	}

	public CompanyCRUBean update(CompanyCRUBean bean) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
			System.out.println("driver成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver失敗");
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		try {
			// 找驅動程式
			Class.forName(DRIVER);
			System.out.println("driver成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver失敗");
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		CompanyCRUDdaoJDBC output = new CompanyCRUDdaoJDBC();
		output.select();
	}
}
