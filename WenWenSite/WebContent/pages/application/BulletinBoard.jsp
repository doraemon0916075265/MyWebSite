<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<br>
<%-- ${initDB} --%>
<br>
<c:if test="${not empty initDB}">
	<c:forEach var="i" begin="0" end="${initDB.size()-1}" step="1">
		<c:out value="${initDB.get(i)}" />
		<br>
	</c:forEach>
</c:if>