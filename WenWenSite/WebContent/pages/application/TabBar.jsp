<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<center>
	<div role="tabpanel">
		<!-- 導覽列選項 -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#bulletinBoard" aria-controls="bulletinBoard" role="tab" data-toggle="tab">${BulletinBoard}</a></li>
			<li role="presentation"><a href="#appName" aria-controls="appName" role="tab" data-toggle="tab">${AppName}</a></li>
			<li role="presentation"><a href="#companyCRUD" aria-controls="companyCRUD" role="tab" data-toggle="tab">${CompanyName}</a></li>
			<li role="presentation"><a href="#loginMember" aria-controls="loginMember" role="tab" data-toggle="tab">會員登入</a></li>
		</ul>
		<!-- 導覽列內容 -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="bulletinBoard">佈告欄</div>
			<div role="tabpanel" class="tab-pane" id="appName">
				<c:import url="/pages/subject/subject.jsp" context="${pageContext.request.contextPath}" />
			</div>
			<div role="tabpanel" class="tab-pane" id="companyCRUD">
				<h4>
					<a href="<%=request.getContextPath()%>/pages/company/CRUD.jsp">${CompanyName}CRUD</a>
				</h4>
			</div>
			<div role="tabpanel" class="tab-pane" id="loginMember">
				<c:import url="/pages/login/loginPage.jsp" context="${pageContext.request.contextPath}" />
			</div>
		</div>
	</div>
</center>