<%@page import="global.value.web.GlobalValuePullDown"%>
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
		<%
			GlobalValuePullDown GVPD = new GlobalValuePullDown();
			String[] DataSource = GVPD.getPdDataSource();
			String[] Language = GVPD.getPdLanguage();
			String[] Item = GVPD.getPdItem();
			int DataSourceLen = DataSource.length;
			int LanguageLen = Language.length;
			int ItemLen = Item.length;
			int size = 1;
		%>
		<div class="row">
			<div class="col-xs-3">
				<select class="form-control" id="selectOption<%=size%>" name="selectOption<%=size++%>">
					<%
						for (int i = 0; i < DataSourceLen; i++) {
							out.print("<option value=" + DataSource[i] + ">" + DataSource[i] + "</option>");
						}
					%>
				</select>
			</div>
			<div class="col-xs-2">
				<select class="form-control" id="selectOption<%=size%>" name="selectOption<%=size++%>">
					<%
						for (int i = 0; i < LanguageLen; i++) {
							out.print("<option value=" + Language[i] + ">" + Language[i] + "</option>");
							// out.print("<option value=" + i + ">" + Language[i] + "</option>");
						}
					%>
				</select>
			</div>
			<div class="col-xs-2">
				<select class="form-control" id="selectOption<%=size%>" name="selectOption<%=size++%>">
					<%
						for (int i = 0; i < ItemLen; i++) {
							out.print("<option value=" + Item[i] + ">" + Item[i] + "</option>");
							// out.print("<option value=" + i + ">" + Item[i] + "</option>");
						}
					%>
				</select>
			</div>
		</div>
		<br>
		<button type="button" class="btn btn-primary btn-pill" id="getOpenDataFile">
			<span class="glyphicon glyphicon-send"></span>
		</button>
		<br>
		<c:import url="/pages/getOpenData/resultDataForCRUD.jsp" context="${pageContext.request.contextPath}" />
		<br>
		<div id="anyError"></div>
	</center>
	<script type="text/javascript">
		(function($) {
			var xmlHttp = null;

			$("#getOpenDataFile").click(function() {

				var openDataURL = findOpenDataURL();
				console.log(openDataURL);
				if (openDataURL.trim().length != 0) {
					xmlHttp = new XMLHttpRequest();
					if (xmlHttp != null) {
						xmlHttp.addEventListener("readystatechange", function() {
							if (xmlHttp.readyState == 1) {
							} else if (xmlHttp.readyState == 4) {
								if (xmlHttp.status == 200) {
									data = xmlHttp.responseXML;
									console.log(data);
								} else {
									$("#anyError").innerHTML = xmlHttp.status + ":" + xmlHttp.statusText;
								}
							}
						});
						xmlHttp.open("get", openDataURL, true);
						xmlHttp.send();
					} else {
						alert("${BrowserNotSupport}");
					}
				} else {
					$("#anyError").text("無效的操作");
				}

			});

			function findOpenDataURL() {
				var result;
				var optionArray = new Array();
				for (var i = 1; typeof ($("#selectOption" + i).val()) != 'undefined'; i++) {
					optionArray[i] = $("#selectOption" + i).val();
				}

				var opt01_DataSource = optionArray[1];
				var opt01_Language = optionArray[2];
				var opt01_Item = optionArray[3];

				var URLget = "../getOpenData/checkOpenDataURL.jsp?opt01_DataSource=" + opt01_DataSource + "&opt01_Language=" + opt01_Language + "&opt01_Item=" + opt01_Item;

				xmlHttp = new XMLHttpRequest();
				if (xmlHttp != null) {
					xmlHttp.addEventListener("readystatechange", function() {
						if (xmlHttp.readyState == 1) {
						} else if (xmlHttp.readyState == 4) {
							if (xmlHttp.status == 200) {
								result = xmlHttp.responseText;
							} else {
								$("#anyError").innerHTML = xmlHttp.status + ":" + xmlHttp.statusText;
							}
						}
					});
					/** get */
					xmlHttp.open("get", URLget, false);
					xmlHttp.send();
				} else {
					alert("${BrowserNotSupport}");
				}
				return result;
			}

		}(jQuery));
	</script>
</body>
</html>