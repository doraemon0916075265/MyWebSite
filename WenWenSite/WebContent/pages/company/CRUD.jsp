<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${CompanyName}&nbsp;CRUD</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
<link href="<%=request.getContextPath()%>/style/Company.css" rel="stylesheet">
</head>
<body>
	<center>
		<h2>${CompanyName}&nbsp;CRUD</h2>
		<form action="CompanyCRUD.do">
			<table id="companyCRUDtable" class="table table-responsive">
				<tbody>
					<tr>
						<td>資料庫</td>
						<td><select name="database" id="database">
								<option value="MySQL" id="MySQL">MySQL</option>
								<option value="Oracle" id="Oracle">Oracle</option>
								<c:if test="${data.database=='MySQL'}">
									<script type="text/javascript">
										$("#MySQL").attr("selected", "selected");
									</script>
								</c:if>
								<c:if test="${data.database=='Oracle'}">
									<script type="text/javascript">
										(function($) {
											$("#Oracle").attr("selected", "selected");
										}(jQuery));
									</script>
								</c:if>

						</select></td>
						<td></td>
					</tr>
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
						<td><input type="text" name="cellphone" value="${param.cellphone}" maxlength="10"></td>
						<td>${error.cellphone}</td>
					</tr>
					<tr>
						<td>E-mail</td>
						<td><input type="text" name="email" value="${param.email}"></td>
						<td>${error.email}</td>
					</tr>
					<!-- <tr> -->
					<!-- 	<td>建檔日</td> -->
					<%-- 	<td><input type="text" name="hiredate" value="${param.hiredate}" readonly="readonly"></td> --%>
					<%-- 	<td>${error.hiredate}</td> --%>
					<!-- </tr> -->
				</tbody>
			</table>
			<table id="companyBTNtable" class="table table-responsive">
				<tbody>
					<tr>
						<td><input type="submit" value="查詢" name="actionSelector" id="selectData"></td>
						<td><input type="submit" value="新增" name="actionSelector" id="insertData"></td>
						<td><input type="submit" value="修改" name="actionSelector" id="updateData"></td>
						<td><input type="submit" value="刪除" name="actionSelector" id="deleteData"></td>
						<td><input type="button" value="清除" name="actionSelector" id="cleanInput"></td>

					</tr>
				</tbody>
			</table>
			<div class="errorMessage">${error.fail}</div>
		</form>
		<hr>
		<c:import url="/pages/company/resultDataForCRUD.jsp" context="${pageContext.request.contextPath}" />
	</center>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/company/companyCRUD.js"></script>
</body>
</html>