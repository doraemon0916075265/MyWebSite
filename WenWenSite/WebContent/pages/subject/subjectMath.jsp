<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Math" class="global.value.web.GlobalValueExamName" scope="application" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="MathExam001" value="${Math.mathExam001}" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-題目單元</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />

</head>
<body>
	<center>
		<h2>選題目單元</h2>
		<h4>
			<a href="<%=request.getContextPath()%>/pages/subjectExam/MathExam001.jsp">${MathExam001}</a>
		</h4>
	</center>
</body>
</html>