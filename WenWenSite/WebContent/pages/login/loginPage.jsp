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
						<td><input type="text" name="username" value="${param.username}"></td>
						<td>&nbsp;${error.username}<span id="usernameChecker"></span><span id="answer" style="color: red;"></span></td>
					</tr>
					<tr>
						<td>密碼：</td>
						<td><input type="text" name="password" value="${param.password}"></td>
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
	<script type="text/javascript">
		$("input[name='username']").blur(CheckUsername);
		var xmlHttp = null;
		function CheckUsername() {
			var username = $(this).val();
			var URL = "../login/checkUsername.jsp?username=" + username;
			console.log(URL);
			xmlHttp = new XMLHttpRequest();
			if (xmlHttp != null) {
				xmlHttp.addEventListener("readystatechange", startCheck);
				xmlHttp.open("get", URL, true);
				xmlHttp.send();
			} else {
				alert("您的瀏覽器不支援");
			}
		}

		function startCheck() {
			if (xmlHttp.readyState == 1) {
				// 				answerData.style.display = "none";
				// 				spanData.style.display = "inline";
			} else if (xmlHttp.readyState == 4) {
				// 				answerData.style.display = "inline";
				// 				spanData.style.display = "none";
				if (xmlHttp.status == 200) {
					var output = xmlHttp.responseText;
					console.log(output);
					// 					answerData.innerHTML = output;
				} else {
					// 					answerData.innerHTML = xmlHTTP.status + ":" + xmlHTTP.statusText;
				}
			}
		}
	</script>
</body>
</html>