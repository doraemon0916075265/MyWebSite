<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- Bootstrap3 最新編譯和最佳化的 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<!-- Bootstrap3 選擇性佈景主題 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<!-- Bootstrap3 最新編譯和最佳化的 JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

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
				<li><a href="https://tw.yahoo.com/" target="_blank">buttonL1<span class="sr-only">(current)</span></a></li>
				<li><a href="https://tw.yahoo.com/" target="_blank">buttonL2</a></li>
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
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<!-- 選項 -->
				<li><a href="https://tw.yahoo.com/" target="_blank">buttonR1</a></li>
				<li><a href="https://tw.yahoo.com/" target="_blank">buttonR2</a></li>
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

<!-- css -->
<link href="<%=request.getContextPath()%>/pages/application/Application.css" rel="stylesheet">