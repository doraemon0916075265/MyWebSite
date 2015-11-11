package web.model.service;

import web.model.dao.CompanyCRUDdaoJDBC;
import web.model.dao.interfaces.CompanyCRUDdao;

public class CompanyService {

	private CompanyCRUDdao companyCRUDdao = new CompanyCRUDdaoJDBC();

}
