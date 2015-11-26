package web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.value.web.GlobalValueWebSite;
import web.globalService.GlobalDataParse;
import web.model.bean.CompanyCRUDBean;
import web.model.service.CompanyService;

@WebServlet("/pages/company/CompanyCRUD.do")
public class CompanyCRUDServlet extends HttpServlet {

	static GlobalValueWebSite GVWS = new GlobalValueWebSite();
	private static String GO_TO_COMPANYCRUD_PAGE = GVWS.getGoToCompanycrudPage();

	private CompanyService service;

	@Override
	public void init() throws ServletException {
		service = new CompanyService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String tempid = request.getParameter("id");
		String name = request.getParameter("name").toLowerCase();
		String tempage = request.getParameter("age");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email").toLowerCase();
		String hiredate = request.getParameter("hiredate");
		String acitonSelector = request.getParameter("actionSelector");

		String database = request.getParameter("database");
		Map<String, String> datas = new HashMap<String, String>();
		request.setAttribute("data", datas);
		datas.put("database", database.trim().toLowerCase());

		// 轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		int id = 0;
		if (tempid != null && tempid.trim().length() != 0) {
			id = GlobalDataParse.convertInt(tempid);
			if (id == -1000) {
				errors.put("id", "請輸入整數");
			}
		}

		if (name != null && name.trim().length() != 0) {
			boolean isLegalname = name.trim().matches("^[\u4e00-\u9fa5|a-zA-Z| ]+$");// 只能輸入漢字或英文或空白
			if (!isLegalname) {
				errors.put("name", "請輸入漢字或英文");
			}
		}

		int age = 0;
		if (tempage != null && tempage.trim().length() != 0) {
			age = GlobalDataParse.convertInt(tempage);
			if (age == -1000) {
				errors.put("age", "請輸入整數");
			}
		}

		if (cellphone != null && cellphone.trim().length() != 0) {
			boolean isLegaCellphone = cellphone.matches("^[09]{2}[0-9]{8}$");// 手機號碼
			if (!isLegaCellphone) {
				errors.put("cellphone", "請輸入合法號碼");
			}
		}

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
			return;
		}

		// 驗證資料
		if (acitonSelector != null) {
			System.out.println("操作：" + acitonSelector + "\t編號：" + tempid + "\t姓名：" + name + "\t年齡：" + tempage + "\t手機：" + cellphone + "\tE-mail：" + email + "\t到職日：" + hiredate + "\t資料庫：" + database);
			if (acitonSelector.equals("新增") || acitonSelector.equals("修改") || acitonSelector.equals("刪除")) {
				if (acitonSelector.equals("新增") || acitonSelector.equals("修改")) {
					/** 新增跟修改，需要name age cellphone email **/
					if (name.trim().length() == 0 || name == null) {
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入姓名");
					} else if (tempage.trim().length() == 0 || tempage == null) {
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入年齡");
					} else if (cellphone.trim().length() == 0 || cellphone == null) {
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入手機");
					} else if (email.trim().length() == 0 || email == null) {
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入 E-mail");
					} else if (acitonSelector.equals("新增") && tempid.trim().length() > 0) {
						/** 新增不用編號 **/
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 不能輸入編號");
					}
				}
				/** 修改跟刪除，需要id **/
				if (acitonSelector.equals("修改") || acitonSelector.equals("刪除")) {
					if (tempid.trim().length() == 0 || tempid == null) {
						errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入編號");
					}
				}
			}
		}

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
			return;
		}

		// 呼叫model
		CompanyCRUDBean bean = new CompanyCRUDBean();
		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		bean.setCellphone(cellphone);
		bean.setEmail(email);
		bean.setHiredate(new java.sql.Timestamp(new Date().getTime()));
		bean.setDatabase(database);

		// 根據Model執行結果導向View
		if (acitonSelector != null && acitonSelector.equals("查詢")) {
			List<CompanyCRUDBean> result = service.select(bean);
			request.setAttribute("select", result);
			if (result == null) {
				errors.put("action", "查詢無資料");
				request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
			} else {
				request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
			}
		} else if (acitonSelector != null && acitonSelector.equals("新增")) {
			CompanyCRUDBean result = service.insert(bean);
			if (result == null) {
				errors.put("action", "新增失敗");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
		} else if (acitonSelector != null && acitonSelector.equals("修改")) {
			CompanyCRUDBean result = service.update(bean);
			if (result == null) {
				errors.put("action", "修改失敗");
			} else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
		} else if (acitonSelector != null && acitonSelector.equals("刪除")) {
			boolean result = service.delete(bean);
			if (!result) {
				errors.put("action", "刪除失敗");
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
		} else {
			errors.put("action", "未知的操作");
			request.getRequestDispatcher(GO_TO_COMPANYCRUD_PAGE).forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
