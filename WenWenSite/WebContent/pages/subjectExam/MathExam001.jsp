<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-${MathExam001}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/style/MathExam.css">

</head>
<body>

	<center>

		<h2>${MathExam001}</h2>

		設定數字範圍 = <input type="text" value="1000" id="num01">

		<hr>

		<%
			int num1 = (int) (Math.random() * 5000) + 1;
			int num2 = (int) (Math.random() * 5000) + 1;
		%>

		<table id="MathExam001Table">
			<tr>
				<td></td>
				<td><%=num1%></td>
			</tr>
			<tr>
				<td>+</td>
				<td><%=num2%></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" id="answer"></td>
			</tr>
		</table>



	</center>
</body>
</html>