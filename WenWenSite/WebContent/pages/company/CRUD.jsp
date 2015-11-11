<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${CompanyName}&nbsp;CRUD</title>
<link href="<%=request.getContextPath()%>/style/Application.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/style/Company.css" rel="stylesheet">

</head>
<body>
	<center>
		<form action="CompanyCRUD.do">
			<table id="companyCRUDtable">
				<thead>
					<tr>
						<th colspan="3"><h2>${CompanyName}&nbsp;CRUD</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>編號</td>
						<td><input type="text" name="id"></td>
						<td>${error.id}</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name"></td>
						<td>${error.name}</td>
					</tr>
					<tr>
						<td>年齡</td>
						<td><input type="text" name="age"></td>
						<td>${error.age}</td>
					</tr>
					<tr>
						<td>手機</td>
						<td><input type="text" name="cellphone"></td>
						<td>${error.cellphone}</td>
					</tr>
					<tr>
						<td>E-mail</td>
						<td><input type="text" name="email"></td>
						<td>${error.email}</td>
					</tr>
					<tr>
						<td>到職日</td>
						<td><input type="text" name="hiredate"></td>
						<td>${error.hiredate}</td>
					</tr>
				</tbody>


			</table>
			<table>
				<tbody>
					<tr>
						<td><input type="submit" value="全部查詢" name="actionSelector"></td>
						<td><input type="submit" value="單筆查詢" name="actionSelector"></td>
						<td><input type="submit" value="新增" name="actionSelector"></td>
						<td><input type="submit" value="修改" name="actionSelector"></td>
						<td><input type="submit" value="刪除" name="actionSelector"></td>
					</tr>
				</tbody>
			</table>
			<br>
			<div class="errorMessage">${error.fail}</div>
		</form>

	</center>
	<!-- 	name,age,cellphone,email,hiredate -->
</body>
</html>