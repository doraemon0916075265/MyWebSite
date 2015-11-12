package web.model.service;

import java.util.ArrayList;
import java.util.List;

import web.model.bean.CompanyCRUDBean;
import web.model.dao.CompanyCRUDdaoJDBC;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyService {

	private CompanyCRUDdao companyCRUDdao = new CompanyCRUDdaoJDBC();

	public List<CompanyCRUDBean> select(CompanyCRUDBean bean) {
		List<CompanyCRUDBean> result = null;

		if (bean != null && bean.getId() != 0) {
			CompanyCRUDBean tempbean = companyCRUDdao.select(bean.getId());
			if (tempbean != null) {
				result = new ArrayList<CompanyCRUDBean>();
				result.add(tempbean);
			}
		} else {
			result = companyCRUDdao.select();
		}
		return result;
	}

	public CompanyCRUDBean insert(CompanyCRUDBean bean) {
		CompanyCRUDBean result = null;
		if (bean != null) {
			result = companyCRUDdao.insert(bean);
		}
		return result;
	}

	public CompanyCRUDBean update(CompanyCRUDBean bean) {
		CompanyCRUDBean result = null;
		if (bean != null) {
			result = companyCRUDdao.update(bean);
		}
		return result;
	}

	public boolean delete(CompanyCRUDBean bean) {
		boolean result = false;
		if (bean != null) {
			result = companyCRUDdao.delete(bean.getId());
		}
		return result;
	}
}
