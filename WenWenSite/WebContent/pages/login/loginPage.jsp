<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${LoginTitle}</title>
</head>
<body>
	<center>
		<form action="Login.do">
			<table>
				<thead>
					<tr>
						<th colspan="3"><h3>${LoginTitle}</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>帳號：</td>
						<td><input type="text" name="username" value="${param.username}"></td>
						<td>&nbsp;${error.username}</td>
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
		<h3>
			<a href="<%=request.getContextPath()%>/index.jsp">首頁</a>
		</h3>
	</center>
</body>
</html>