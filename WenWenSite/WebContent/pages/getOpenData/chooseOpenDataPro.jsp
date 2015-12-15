<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-${Opendata}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
</head>
<body>
	<center>
		<br>
		<div class="row">
			<div class="col-xs-2">
				<select class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			<div class="col-xs-2">
				<select class="form-control">
					<option>中文</option>
					<option>English</option>
				</select>
			</div>
		</div>
	</center>
</body>
</html>