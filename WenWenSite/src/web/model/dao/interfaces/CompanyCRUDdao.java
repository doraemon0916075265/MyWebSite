package web.model.dao.interfaces;

import java.util.List;

import web.model.bean.CompanyCRUDBean;

public interface CompanyCRUDdao {

	public abstract CompanyCRUDBean select(int id);

	public abstract List<CompanyCRUDBean> select();

	public abstract CompanyCRUDBean insert(CompanyCRUDBean bean);

	public abstract CompanyCRUDBean update(CompanyCRUDBean bean);

	public abstract boolean delete(int id);

}
