<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="SYSTEM" class="globalService.GlobalValue" scope="application" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="AppName" value="${SYSTEM.appName}" scope="application" />
<c:set var="LoginTitle" value="${SYSTEM.loginTitle}" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>
</head>
<body>
	<center>
		<h3>${AppName}</h3>
		<h3>
			<a href="<%=request.getContextPath()%>/pages/login/loginPage.jsp">會員登入</a>
		</h3>
	</center>
</body>
</html>