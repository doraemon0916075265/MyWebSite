package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/company/CompanyCRUD.do")
public class CompanyCRUDServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		String hiredate = request.getParameter("hiredate");
		String actionselector = request.getParameter("actionselector");

		System.out.println("操作：" + actionselector + "\t姓名：" + name + "\t年齡：" + age + "\t手機：" + cellphone + "\tE-mail：" + email + "\t到職日：" + hiredate);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
