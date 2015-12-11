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
		
		<select>
			<option value="qq">中文</option>
			<option value="qq1">English</option>
			<option value="qq2">qq2</option>
			<option value="qq3">qq3</option>
			<option value="qq4">qq4</option>
			<option value="qq5">qq5</option>
		</select>&nbsp;&nbsp;

		<div style="border: 2px solid green">eeee</div>

		<table>
			<thead>
				<tr>
					<th>qqq</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>qqqqqqqqqq</td>
					<td>wwwwwww</td>
					<td>rrrrrrrr</td>
				</tr>
				<tr>
					<td>uuuuuuuu</td>
					<td>iiiiiiii</td>
					<td>ooooooooo</td>
				</tr>
			</tbody>
		</table>



		<hr>
		<!-- 提供額外視覺上的重量和識別一組按鈕中主要的操作項目 -->
		<button type="button" class="btn btn-primary" id="getFile">getFile</button>
		<br>
		<div id="fileResult"></div>

	</center>
	<script type="text/javascript">
		(function($) {
			var fileResult = document.getElementById("fileResult");
			var xmlHttp = null;
			$("#getFile").click(function() {
				var URL = "http://163.29.157.32:8080/dataset/bd31c976-d3a5-4eed-b8c3-7454bc266afa/resource/36847f3f-deff-4183-a5bb-800737591de5/download/98f7320b0eab491f8a62dcc82fbd4f82.xml";
				xmlHttp = new XMLHttpRequest();
				if (xmlHttp != null) {
					xmlHttp.addEventListener("readystatechange", startCheck);
					xmlHttp.open("get", URL, true);
					xmlHttp.send();
				} else {
					alert("${BrowserNotSupport}");
				}
			});
			function startCheck() {
				if (xmlHttp.readyState == 1) {
				} else if (xmlHttp.readyState == 4) {
					if (xmlHttp.status == 200) {

						// 清除原有的元素
						while (fileResult.hasChildNodes()) {
							fileResult.removeChild(fileResult.lastChild);
						}
						var datas = xmlHttp.responseXML;

						var section = datas.getElementsByTagName("Section");
						var datasLength = section.length;

						for (var i = 0; i < datasLength; i++) {
							try {
								var rownum = section[i].getElementsByTagName("RowNumber")[0].firstChild.nodeValue;
								var stitle = section[i].getElementsByTagName("stitle")[0].firstChild.nodeValue;
								var cat2 = section[i].getElementsByTagName("CAT2")[0].firstChild.nodeValue;
								var memoTime = section[i].getElementsByTagName("MEMO_TIME")[0].firstChild.nodeValue;
								var xbody = section[i].getElementsByTagName("xbody")[0].firstChild.nodeValue;
								var address = section[i].getElementsByTagName("address")[0].firstChild.nodeValue;

								var imgLen = section[i].getElementsByTagName("img").length;
								// 								var imgpath1 = section[i].getElementsByTagName("img")[0].firstChild.nodeValue;
								// 								var imgpath2 = section[i].getElementsByTagName("img")[1].firstChild.nodeValue;
								var imgArray = [];
								for (var j = 0; j < imgLen; j++) {
									imgArray[j] = section[i].getElementsByTagName("img")[j].firstChild.nodeValue;
									console.log("j" + imgArray[j]);
								}
								console.log(rownum + "\t" + stitle + "\t" + cat2 + "\t" + memoTime + "\t" + xbody + "\t" + address + "\t" + imgArray[0]);

								var eletable = document.createElement("table");
								eletable.setAttribute("style", "border:2px solid red");

								fileResult.appendChild(eletable);

							} catch (e) {
								// 																console.log(e.message);
							}
						}

						// 						$("#fileResult").css('border', '2px solid blue');
					} else {
						// 						$("#getFileResult").innerHTML = xmlHTTP.status + ":" + xmlHTTP.statusText;
					}
				}
			}
		}(jQuery));
	</script>
</body>
</html>