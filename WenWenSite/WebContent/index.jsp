<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="SYSTEM" class="global.value.web.GlobalValueWebSite" scope="application" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="LoginTitle" value="${SYSTEM.loginTitle}" scope="application" />
<c:set var="AppName" value="${SYSTEM.appName}" scope="application" />
<c:set var="FileExcel" value="${SYSTEM.fileExcel}" scope="application" />
<c:set var="MathPlace" value="${SYSTEM.mathPlace}" scope="application" />
<c:set var="CompanyName" value="${SYSTEM.companyName}" scope="application" />
<c:set var="HomePage" value="${SYSTEM.homePage}" scope="application" />
<c:set var="BulletinBoard" value="${SYSTEM.bulletinBoard}" scope="application" />
<c:set var="Initialize" value="${SYSTEM.initialize}" scope="application" />
<c:set var="Database" value="${SYSTEM.database}" scope="application" />
<c:set var="MySQL" value="${SYSTEM.mysql}" scope="application" />
<c:set var="Oracle" value="${SYSTEM.oracle}" scope="application" />
<c:set var="Checkingdata" value="${SYSTEM.checkingdata}" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
</head>
<body>
	<c:import url="/pages/application/TabBar.jsp" context="${pageContext.request.contextPath}" />
</body>
</html>