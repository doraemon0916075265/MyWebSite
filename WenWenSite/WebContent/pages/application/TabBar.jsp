<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<center>
	<div role="tabpanel">
		<!-- 導覽列選項 -->
		<ul class="nav nav-tabs" role="tablist">
			<!-- <li role="presentation" class="active"> -->
			<li role="presentation"><a href="#bulletinBoard" aria-controls="bulletinBoard" role="tab" data-toggle="tab">${BulletinBoard}</a></li>
			<li role="presentation"><a href="#appName" aria-controls="appName" role="tab" data-toggle="tab">${AppName}</a></li>
			<li role="presentation"><a href="#companyCRUD" aria-controls="companyCRUD" role="tab" data-toggle="tab">${CompanyName}</a></li>
			<li role="presentation" class="active"><a href="#GetOpenData" aria-controls="testPage" role="tab" data-toggle="tab">testPage</a></li>
		</ul>
		<!-- 導覽列內容 -->
		<div class="tab-content">
			<!-- <div role="tabpanel" class="tab-pane active" id="testPage"> -->
			<div role="tabpanel" class="tab-pane" id="bulletinBoard">
				<c:import url="/pages/application/BulletinBoard.jsp" context="${pageContext.request.contextPath}" />
			</div>
			<div role="tabpanel" class="tab-pane" id="appName">
				<c:import url="/pages/subject/subject.jsp" context="${pageContext.request.contextPath}" />
			</div>
			<div role="tabpanel" class="tab-pane" id="companyCRUD">
				<h3>
					<a href="<%=request.getContextPath()%>/pages/company/CRUD.jsp">${CompanyName}CRUD</a>
				</h3>
			</div>
			<div role="tabpanel" class="tab-pane active" id="GetOpenData">
				<h3>
					<a href="<%=request.getContextPath()%>/pages/GetOpenData.jsp">testPage</a>
				</h3>
			</div>
		</div>
	</div>
</center>