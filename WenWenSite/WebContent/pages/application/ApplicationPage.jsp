<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- Bootstrap3 最新編譯和最佳化的 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<!-- Bootstrap3 最新編譯和最佳化的 JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<center>
	<!-- nav-bar 上方導覽列 -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<!-- 系統名稱 -->
				<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;${SYSTEM.appName}</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!-- 選項 -->
					<li><a href="#" data-toggle="modal" data-target="#calculatorModal">qqqqq</a><span class="sr-only">(current)</span></li>
					<li><a href="https://tw.yahoo.com/" target="_blank"><span class="glyphicon glyphicon-flash"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">下拉1&nbsp;<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action1</a></li>
							<li><a href="#">Action2</a></li>
							<li><a href="#">Action3</a></li>
							<li class="divider"></li>
							<li><a href="#">Action5</a></li>
							<li><a href="#">Action6</a></li>
						</ul></li>
				</ul>
				<!-- 搜尋 -->
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="搜尋">
					</div>
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<!-- 選項 -->
					<li><a href="https://tw.yahoo.com/" target="_blank">buttonR1</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">下拉2&nbsp;<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action1</a></li>
							<li><a href="#">Action2</a></li>
							<li><a href="#">Action3</a></li>
							<li class="divider"></li>
							<li><a href="#">Action5</a></li>
							<li><a href="#">Action6</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<a href="" class="glyphicons calculator"><strong> glyphicons calculator</strong><span>UTF E324</span></a> <span class="glyphicons glyphicons-calculator">qq</span> <i class="fa fa-calculator"></i> <span class="glyphicons glyphicons-calculator"></span>

	<!-- Modal -->
	<div class="modal fade" id="calculatorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">計算機</h4>
				</div>
				<div class="modal-body">
					<c:import url="/pages/tools/Calculator.jsp" context="${pageContext.request.contextPath}" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>


</center>
<!-- css -->
<link href="<%=request.getContextPath()%>/pages/application/Application.css" rel="stylesheet">