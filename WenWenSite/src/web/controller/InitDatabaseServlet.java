package web.controller;

import java.io.IOException;

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
		try {
			InitDB.runInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(GO_TO_INDEX_PAGE).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
