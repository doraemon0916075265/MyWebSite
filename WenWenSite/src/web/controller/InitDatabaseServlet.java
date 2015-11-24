package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.init.InitDB;
import global.value.web.GlobalValueWebSite;

@WebServlet("/InitDatabase.do")
public class InitDatabaseServlet extends HttpServlet {
	static GlobalValueWebSite GVW = new GlobalValueWebSite();
	private static String GO_TO_INDEX_PAGE = GVW.getGoToIndexPage();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date startInit = new Date(System.currentTimeMillis());

		List<String> resultList = new ArrayList<String>();
		resultList = InitDB.runInit();

		request.setAttribute("initDB", resultList);

		Date endInit = new Date(System.currentTimeMillis());
		long costTime = endInit.getTime() - startInit.getTime();
		resultList.add("費時：" + costTime + "毫秒");

		request.getRequestDispatcher(GO_TO_INDEX_PAGE).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
