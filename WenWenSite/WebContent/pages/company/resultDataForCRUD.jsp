<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${not empty error}">
	<!-- 其他錯誤 -->
	<h3>${error.action}</h3>
</c:if>

<c:if test="${not empty data}">
	<!-- 秀出資料庫 -->
	<c:out value="資料庫：${data.database}"></c:out>
</c:if>

<c:if test="${not empty select}">
	<!-- 是否查詢成功 -->
	<h4>總共有&nbsp;${fn:length(select)}&nbsp;筆資料</h4>
	<table class="resultTable">
		<thead>
			<tr>
				<th>編號</th>
				<th>姓名</th>
				<th>年齡</th>
				<th>手機</th>
				<th>E-mail</th>
				<th>建檔日</th>
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
					<td><a href="${linkPath}">${row.id}</a></td>
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

<c:if test="${not empty insert}">
	<!-- 是否新增成功 -->
	<table class="resultTable">
		<thead>
			<tr>
				<th>編號</th>
				<th>姓名</th>
				<th>年齡</th>
				<th>手機</th>
				<th>E-mail</th>
				<th>建檔日</th>
			</tr>
		</thead>
		<tbody>
			<c:url value="/pages/company/CRUD.jsp" var="linkPath">
				<c:param name="id" value="${row.id}" />
				<c:param name="name" value="${row.name}" />
				<c:param name="age" value="${row.age}" />
				<c:param name="cellphone" value="${row.cellphone}" />
				<c:param name="email" value="${row.email}" />
				<c:param name="hiredate" value="${row.hiredate}" />
			</c:url>
			<tr>
				<td><a href="${linkPath}">${insert.id}</a></td>
				<td><a href="${linkPath}">${insert.name}</a></td>
				<td>${insert.age}</td>
				<td>${insert.cellphone}</td>
				<td>${insert.email}</td>
				<td>${insert.hiredate}</td>
			</tr>
			<tr></tr>
		</tbody>
	</table>
	<%-- <div>${insert}</div> --%>
</c:if>
<c:if test="${not empty update}">
	<!-- 是否更新成功 -->
	<table class="resultTable">
		<thead>
			<tr>
				<th>編號</th>
				<th>姓名</th>
				<th>年齡</th>
				<th>手機</th>
				<th>E-mail</th>
				<th>建檔日</th>
			</tr>
		</thead>
		<tbody>
			<c:url value="/pages/company/CRUD.jsp" var="linkPath">
				<c:param name="id" value="${row.id}" />
				<c:param name="name" value="${row.name}" />
				<c:param name="age" value="${row.age}" />
				<c:param name="cellphone" value="${row.cellphone}" />
				<c:param name="email" value="${row.email}" />
				<c:param name="hiredate" value="${row.hiredate}" />
			</c:url>
			<tr>
				<td><a href="${linkPath}">${update.id}</a></td>
				<td><a href="${linkPath}">${update.name}</a></td>
				<td>${update.age}</td>
				<td>${update.cellphone}</td>
				<td>${update.email}</td>
				<td>${update.hiredate}</td>
			</tr>
			<tr></tr>
		</tbody>
	</table>
</c:if>
<c:if test="${not empty delete}">
	<!-- 是否刪除成功 -->
	<h4>刪除&nbsp;${delete}&nbsp;筆資料</h4>
	<%-- <div>${delete}</div> --%>
</c:if>