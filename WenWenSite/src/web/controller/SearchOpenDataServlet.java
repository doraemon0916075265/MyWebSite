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

import org.apache.commons.lang.StringUtils;

import global.value.web.GlobalValueWebSite;
import web.model.bean.SearchOpenDataBean;
import web.model.service.SearchOpenDataService;

@WebServlet("/pages/getOpenData/FindOpenData.do")
public class SearchOpenDataServlet extends HttpServlet {

	static GlobalValueWebSite GVWS = new GlobalValueWebSite();
	private static String PAGE_GO_TO_CHOOSEOPENDATA = GVWS.getPageGoToChooseopendata();

	private SearchOpenDataService service;

	@Override
	public void init() throws ServletException {
		service = new SearchOpenDataService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 接收資料
		String selectOption1 = request.getParameter("selectOption1").trim();
		String selectOption2 = request.getParameter("selectOption2").trim();
		String selectOption3 = request.getParameter("selectOption3").trim();
		System.out.println(selectOption1 + "\t" + selectOption2 + "\t" + selectOption3);

		// 轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);

		// 驗證資料
		if (selectOption1 == null || selectOption1.trim().length() == 0) {
			errors.put("optionItem", "DataSource Error!");
		}
		if (selectOption2 == null || selectOption2.trim().length() == 0) {
			errors.put("optionItem", "Language Error!");
		}
		if (selectOption3 == null || selectOption3.trim().length() == 0) {
			errors.put("optionItem", "Item Error!");
		}
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher(PAGE_GO_TO_CHOOSEOPENDATA).forward(request, response);
			return;
		}

		SearchOpenDataBean bean = new SearchOpenDataBean();
		bean.setOpt01_DataSource(selectOption1);
		bean.setOpt01_Language(selectOption2);
		bean.setOpt01_Item(selectOption3);

		// 根據Model執行結果導向View
		List<SearchOpenDataBean> resultBean = service.select(bean);
		String output = "";
		if (resultBean.size() != 1 && resultBean.isEmpty()) {
			output = "無效的操作";

		} else {
			output = resultBean.get(0).getOpt01_DataURL();
		}
		request.setAttribute("searchOpenDataXML", output);
		request.getRequestDispatcher(PAGE_GO_TO_CHOOSEOPENDATA).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
