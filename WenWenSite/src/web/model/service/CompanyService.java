package web.model.service;

import java.util.ArrayList;
import java.util.List;

import web.model.bean.CompanyCRUDBean;
import web.model.dao.CompanyCRUDmysqlJDBC;
import web.model.dao.CompanyCRUDoracleJDBC;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyService {

	private CompanyCRUDdao companyMYSQLdao = new CompanyCRUDmysqlJDBC();
	private CompanyCRUDdao companyORACLEdao = new CompanyCRUDoracleJDBC();

	public List<CompanyCRUDBean> select(CompanyCRUDBean bean) {
		List<CompanyCRUDBean> result = null;
		String database = bean.getDatabase();
		System.out.println(database);
		if (database.trim().toLowerCase().equals("mysql")) {
			// MySQL
			if (bean != null && bean.getId() != 0) {
				CompanyCRUDBean tempbean = companyMYSQLdao.select(bean.getId());
				if (tempbean != null) {
					result = new ArrayList<CompanyCRUDBean>();
					result.add(tempbean);
				}
			} else {
				result = companyMYSQLdao.select();
			}
		} else if (database.trim().toLowerCase().equals("oracle")) {
			// Oracle
			if (bean != null && bean.getId() != 0) {
				CompanyCRUDBean tempbean = companyORACLEdao.select(bean.getId());
				if (tempbean != null) {
					result = new ArrayList<CompanyCRUDBean>();
					result.add(tempbean);
				}
			} else {
				result = companyORACLEdao.select();
			}
		}

		return result;
	}

	public CompanyCRUDBean insert(CompanyCRUDBean bean) {
		String database = bean.getDatabase();
		CompanyCRUDBean result = null;
		if (database.trim().toLowerCase().equals("mysql")) {
			// MySQL
			if (bean != null) {
				result = companyMYSQLdao.insert(bean);
			}
		} else if (database.trim().toLowerCase().equals("oracle")) {
			// Oracle
			if (bean != null) {
				result = companyORACLEdao.insert(bean);
			}
		}
		return result;
	}

	public CompanyCRUDBean update(CompanyCRUDBean bean) {
		CompanyCRUDBean result = null;
		String database = bean.getDatabase();
		if (database.trim().toLowerCase().equals("mysql")) {
			// MySQL
			if (bean != null) {
				result = companyMYSQLdao.update(bean);
			}
		} else if (database.trim().toLowerCase().equals("oracle")) {
			// Oracle
			if (bean != null) {
				result = companyORACLEdao.update(bean);
			}
		}

		return result;
	}

	public boolean delete(CompanyCRUDBean bean) {
		boolean result = false;
		String database = bean.getDatabase();
		if (database.trim().toLowerCase().equals("mysql")) {
			// MySQL
			if (bean != null) {
				result = companyMYSQLdao.delete(bean.getId());
			}
		}
		if (database.trim().toLowerCase().equals("oracle")) {
			// Oracle
			if (bean != null) {
				result = companyORACLEdao.delete(bean.getId());
			}
		}
		return result;
	}
}
