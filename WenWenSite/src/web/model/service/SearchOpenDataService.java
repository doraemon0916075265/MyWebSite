package web.model.service;

import java.util.List;

import web.model.bean.SearchOpenDataBean;
import web.model.dao.SearchOpenDataJDBC;
import web.model.dao.interfaces.SearchOpenDataDao;

public class SearchOpenDataService {
	private SearchOpenDataDao searchOpenDataDao = new SearchOpenDataJDBC();

	public List<SearchOpenDataBean> select(SearchOpenDataBean bean) {
		List<SearchOpenDataBean> result = null;
		result = searchOpenDataDao.selectURL(bean.getOpt01_DataSource(), bean.getOpt01_Language(), bean.getOpt01_Item());
		return result;
	}
}
