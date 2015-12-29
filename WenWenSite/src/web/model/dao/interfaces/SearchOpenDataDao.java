package web.model.dao.interfaces;

import java.util.List;

import web.model.bean.SearchOpenDataBean;

public interface SearchOpenDataDao {
	public abstract List<SearchOpenDataBean> selectURL(String opt01_DataSource, String opt01_Language, String opt01_Item);
}
