package web.model.dao.interfaces;

import java.util.List;

import web.model.bean.CompanyCRUBean;

public interface CompanyCRUDdao {

	public abstract CompanyCRUBean select(int id);

	public abstract List<CompanyCRUBean> select();

	public abstract CompanyCRUBean insert(CompanyCRUBean bean);

	public abstract CompanyCRUBean update(CompanyCRUBean bean);

	public abstract boolean delete(int id);

}
