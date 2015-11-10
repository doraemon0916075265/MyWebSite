<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${CompanyName}&nbsp;CRUD</title>
</head>
<body>
	<center>
		<form action="CompanyCRUD.do">
			<table>
				<thead>
					<tr>
						<th colspan="3"><h2>${CompanyName}&nbsp;CRUD</h2></th>
					</tr>
				</thead>
				<tbody>
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
						<td><input type="submit" value="查詢" name="actionselector"></td>
						<td><input type="submit" value="新增" name="actionselector"></td>
						<td><input type="submit" value="修改" name="actionselector"></td>
						<td><input type="submit" value="刪除" name="actionselector"></td>
					</tr>
				</tbody>
			</table>

		</form>

	</center>
	<!-- 	name,age,cellphone,email,hiredate -->
</body>
</html>