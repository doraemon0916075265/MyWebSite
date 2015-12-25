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
		<form action="FindOpenData.do">
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
					<select class="form-control" id="selectOption<%=size++%>">
						<%
							for (int i = 0; i < DataSourceLen; i++) {
								out.print("<option value=" + DataSource[i] + ">" + DataSource[i] + "</option>");
							}
						%>
					</select>
				</div>
				<div class="col-xs-2">
					<select class="form-control" id="selectOption<%=size++%>">
						<%
							for (int i = 0; i < LanguageLen; i++) {
								out.print("<option value=" + Language[i] + ">" + Language[i] + "</option>");
								// out.print("<option value=" + i + ">" + Language[i] + "</option>");
							}
						%>
					</select>
				</div>
				<div class="col-xs-2">
					<select class="form-control" id="selectOption<%=size++%>">
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
			<button type="submit" class="btn btn-primary btn-pill" id="getOpenDataFile">
				<span class="glyphicon glyphicon-send"></span>
			</button>
		</form>
		<hr>
		<div>result</div>

		<script type="text/javascript">
			(function($) {
				// 去抓資料
				$("#getOpenDataFile").click(function() {
					var xmlHttp = null;
					var optionArray = new Array();
					for (var i = 1; typeof ($("#selectOption" + i).val()) !== 'undefined'; i++) {
						var option = $("#selectOption" + i).val();
						optionArray[i] = option;
					}
					var chooseDataSource = optionArray[1];
					var chooseLanguage = optionArray[2];
					var chooseItem = optionArray[3];
					console.log(optionArray);

				});
			}(jQuery));
		</script>

		<script type="text/javascript">
			(function($) {
				var xmlHttp = null;
				initOption();

				var selectOption1 = document.getElementById("#selectOption1");
				var testtt = document.getElementById("#testtt");

				function initOption() {
					//一開始就要執行第一個下拉選單 
					$("#selectOption1").css('border', '2px solid green');
					var URLget = "../getOpenData/checkOpenDataURL.jsp";
					xmlHttp = new XMLHttpRequest();
					if (xmlHttp != null) {
						xmlHttp.addEventListener("readystatechange", startCheck);
						/** post */
						// xmlHttp.open("post", URLpost, true);
						// xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
						// xmlHttp.send("username=" + username);
						/** get */
						xmlHttp.open("get", URLget, true);
						xmlHttp.send();
					} else {
						alert("${BrowserNotSupport}");
					}
				}

				function startCheck() {

				}

			}(jQuery));
		</script>
	</center>
</body>
</html>