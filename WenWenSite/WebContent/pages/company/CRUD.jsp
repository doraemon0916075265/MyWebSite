<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${CompanyName}&nbsp;CRUD</title>
<link href="<%=request.getContextPath()%>/style/Application.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/style/Company.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
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
						<td><input type="text" name="id" value="${param.id}"></td>
						<td>${error.id}</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" value="${param.name}"></td>
						<td>${error.name}</td>
					</tr>
					<tr>
						<td>年齡</td>
						<td><input type="text" name="age" value="${param.age}"></td>
						<td>${error.age}</td>
					</tr>
					<tr>
						<td>手機</td>
						<td><input type="text" name="cellphone" value="${param.cellphone}"></td>
						<td>${error.cellphone}</td>
					</tr>
					<tr>
						<td>E-mail</td>
						<td><input type="text" name="email" value="${param.email}"></td>
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
						<td><input type="submit" value="查詢" name="actionSelector"></td>
						<td><input type="submit" value="新增" name="actionSelector"></td>
						<td><input type="submit" value="修改" name="actionSelector"></td>
						<td><input type="submit" value="刪除" name="actionSelector"></td>
						<td><input type="button" value="清除" id="cleanInput"></td>

					</tr>
				</tbody>
			</table>
			<br>
			<div class="errorMessage">${error.fail}</div>
		</form>
		<hr>
		<c:if test="${not empty error}">
			<h3>${error.action}</h3>
		</c:if>

		<c:if test="${not empty select}">
			<h4>總共有&nbsp;${fn:length(select)}&nbsp;筆資料</h4>
			<table class="resultTable">
				<thead>
					<tr>
						<th>編號</th>
						<th>姓名</th>
						<th>年齡</th>
						<th>手機</th>
						<th>E-mail</th>
						<th>到職日</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${select}">
						<c:url value="/pages/company/CRUD.jsp" var="linkPath">
							<c:param name="id" value="${row.id}" />
							<c:param name="name" value="${row.name}" />
							<c:param name="age" value="${row.age}" />
							<c:param name="cellphone" value="${row.cellphone}" />
							<c:param name="email" value="${row.email}" />
							<c:param name="hiredate" value="${row.hiredate}" />
						</c:url>
						<tr>
							<td>${row.id}</td>
							<td><a href="${linkPath}">${row.name}</a></td>
							<td>${row.age}</td>
							<td>${row.cellphone}</td>
							<td>${row.email}</td>
							<td>${row.hiredate}</td>
						</tr>
					</c:forEach>
					<tr></tr>
				</tbody>
			</table>
			<%-- <div>${select}</div> --%>
		</c:if>

	</center>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/company/companyCRUD.js"></script>
</body>
</html>