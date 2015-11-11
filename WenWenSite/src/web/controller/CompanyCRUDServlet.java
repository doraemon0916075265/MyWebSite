package web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.globalService.GlobalValue;
import web.model.bean.CompanyCRUBean;
import web.model.service.CompanyService;

@WebServlet("/pages/company/CompanyCRUD.do")
public class CompanyCRUDServlet extends HttpServlet {

	public static final String GO_TO_COMPANYDRUD_CRUD = "/pages/company/CRUD.jsp";

	private CompanyService service;

	@Override
	public void init() throws ServletException {
		service = new CompanyService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String tempid = request.getParameter("id");
		String name = request.getParameter("name");
		String tempage = request.getParameter("age");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		String hiredate = request.getParameter("hiredate");
		String acitonSelector = request.getParameter("actionSelector");

		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);

		if (acitonSelector != null) {
			System.out.println("操作：" + acitonSelector + "\t編號：" + tempid + "\t姓名：" + name + "\t年齡：" + tempage + "\t手機：" + cellphone + "\tE-mail：" + email + "\t到職日：" + hiredate);
			if (acitonSelector.equals("單筆查詢") || acitonSelector.equals("新增") || acitonSelector.equals("修改") || acitonSelector.equals("刪除")) {
				if (tempid.trim().length() == 0 || tempid == null) {
					errors.put("fail", "如果要進行 <b>" + acitonSelector + "</b> 請輸入編號");
				}
			}

		}

		// 轉換資料
		int id = 0;
		if (tempid != null && tempid.trim().length() != 0) {
			id = GlobalValue.convertInt(tempid);
			if (id == -1000) {
				errors.put("id", "請輸入整數");
			}
		}

		int age = 0;
		if (tempage != null && tempage.trim().length() != 0) {
			age = GlobalValue.convertInt(tempage);
			if (age == -1000) {
				errors.put("id", "請輸入整數");
			}
		}

		System.out.println(id);

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher(GO_TO_COMPANYDRUD_CRUD).forward(request, response);
			return;
		}

		// 呼叫model
		CompanyCRUBean bean = new CompanyCRUBean();
		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		bean.setCellphone(cellphone);
		bean.setEmail(email);

		// 根據Model執行結果導向View
		if (acitonSelector != null && acitonSelector.equals("全部查詢")) {
//			List<CompanyCRUBean> result=service;
		} else if (acitonSelector != null && acitonSelector.equals("單筆查詢")) {

		} else if (acitonSelector != null && acitonSelector.equals("新增")) {

		} else if (acitonSelector != null && acitonSelector.equals("修改")) {

		} else if (acitonSelector != null && acitonSelector.equals("刪除")) {

		} else {

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
