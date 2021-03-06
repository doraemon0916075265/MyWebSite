<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/styles/Login.css" rel="stylesheet">
</head>
<body>
	<center>
		<br>
		<form action="Login.do">
			<table id="loginMember">
				<tbody>
					<tr>
						<td>帳號：</td>
						<td><input type="text" name="username" value="${param.username}" id="LoginUsername"></td>
						<td>&nbsp;${error.username}<span id="usernameChecker"><img src="<%=request.getContextPath()%>/images/waiting.gif" class="iconWorking">${Checkingdata}</span><span id="usernameCheckResult"></span></td>
					</tr>
					<tr>
						<td>密碼：</td>
						<td><input type="password" name="password" value="${param.password}"></td>
						<td>&nbsp;${error.password}</td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="登入"></td>
						<td>&nbsp;${error.fail}</td>
					</tr>
				</tbody>
			</table>
		</form>
	</center>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/loginPage.js"></script>
</body>
</html>