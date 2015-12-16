<%@page import="global.value.web.GlobalValuePullDown"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-${Opendata}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
</head>
<body>
	<center>
		<br>
		<%
			GlobalValuePullDown GVPD = new GlobalValuePullDown();
			String[] Language = GVPD.getPdLanguage();
			String[] DataSource = GVPD.getPdDataSource();
			int LanguageLen = Language.length;
			int DataSourceLen = DataSource.length;
		%>
		<div class="row">
			<div class="col-xs-3">
				<select class="form-control">
					<%
						for (int i = 0; i < DataSourceLen; i++) {
							out.print("<option value=" + DataSource[i] + ">" + DataSource[i] + "</option>");
						}
					%>
				</select>
			</div>
			<div class="col-xs-2">
				<select class="form-control">
					<%
						for (int i = 0; i < LanguageLen; i++) {
							out.print("<option value=" + Language[i] + ">" + Language[i] + "</option>");
						}
					%>
				</select>
			</div>
		</div>
		<br>
		<button type="button" class="btn btn-primary btn-pill" id="getFile">
			<span class="glyphicon glyphicon-send"></span>
		</button>
	</center>
</body>
</html>