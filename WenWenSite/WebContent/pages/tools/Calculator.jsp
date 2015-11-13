<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>計算機</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/MathExam.css">
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />

</head>
<body>
	<center>
		<table id="calculatorMachine">
			<thead>
				<tr>
					<th colspan="4">計算機</th>
				</tr>
				<tr>
					<th colspan="4"><input type="text" id="output"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="button" value="清除"></td>
					<td><input type="button" value="("></td>
					<td><input type="button" value=")"></td>
					<td><input type="button" value="←"></td>
				</tr>
				<tr>
					<td><input type="button" value="7"></td>
					<td><input type="button" value="8"></td>
					<td><input type="button" value="9"></td>
					<td><input type="button" value="/"></td>
				</tr>
				<tr>
					<td><input type="button" value="4"></td>
					<td><input type="button" value="5"></td>
					<td><input type="button" value="6"></td>
					<td><input type="button" value="*"></td>
				</tr>
				<tr>
					<td><input type="button" value="1"></td>
					<td><input type="button" value="2"></td>
					<td><input type="button" value="3"></td>
					<td><input type="button" value="-"></td>
				</tr>
				<tr>
					<td><input type="button" value="0"></td>
					<td><input type="button" value="."></td>
					<td><input type="button" value="="></td>
					<td><input type="button" value="+"></td>
				</tr>

			</tbody>
		</table>
	</center>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/tools/CalculatorMachine.js"></script>
</body>
</html>