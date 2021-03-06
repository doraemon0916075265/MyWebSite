<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="SYSTEM" class="global.value.web.GlobalValueWebSite" scope="application" />
<jsp:useBean id="URL" class="global.value.web.GlobalValueURL" scope="application" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 輸出字串 -->
<c:set var="LoginTitle" value="${SYSTEM.loginTitle}" scope="application" />
<c:set var="AppName" value="${SYSTEM.appName}" scope="application" />
<c:set var="MathPlace" value="${SYSTEM.mathPlace}" scope="application" />
<c:set var="CompanyName" value="${SYSTEM.companyName}" scope="application" />
<c:set var="HomePage" value="${SYSTEM.homePage}" scope="application" />
<c:set var="BulletinBoard" value="${SYSTEM.bulletinBoard}" scope="application" />
<c:set var="Initialize" value="${SYSTEM.initialize}" scope="application" />
<c:set var="Database" value="${SYSTEM.database}" scope="application" />
<c:set var="MySQL" value="${SYSTEM.mysql}" scope="application" />
<c:set var="Oracle" value="${SYSTEM.oracle}" scope="application" />
<c:set var="Checkingdata" value="${SYSTEM.checkingdata}" scope="application" />
<c:set var="BrowserNotSupport" value="${SYSTEM.browserNotSupport}" scope="application" />
<c:set var="Opendata" value="${SYSTEM.opendata}" scope="application" />
<c:set var="ShowDatabase" value="${SYSTEM.showDatabase}" scope="application" />
<!-- File 系列 -->
<c:set var="Excel" value="${SYSTEM.filetypeExcel}" scope="application" />
<!-- DataType 系列 -->
<c:set var="Xml" value="${SYSTEM.datatypeXml}" scope="application" />
<c:set var="Json" value="${SYSTEM.datatypeJson}" scope="application" />
<!-- 外部 URL 系列 -->
<c:set var="DatatpeZhXViewpoint" value="${URL.datatpeZhXViewpoint}" scope="application" />
<c:set var="DatatpeEnXViewpoint" value="${URL.datatpeEnXViewpoint}" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-${HomePage}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
</head>
<body>
	<c:import url="/pages/application/TabBar.jsp" context="${pageContext.request.contextPath}" />
</body>
</html>