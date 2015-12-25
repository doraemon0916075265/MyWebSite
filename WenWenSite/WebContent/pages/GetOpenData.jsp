<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}-${Opendata}</title>
<c:import url="/pages/application/ApplicationPage.jsp" context="${pageContext.request.contextPath}" />
<link href="<%=request.getContextPath()%>/styles/GetOpenData.css" rel="stylesheet">
</head>
<body>
	<center>
		<hr>
		<button type="button" class="btn btn-primary btn-pill" id="getFile">
			<span class="glyphicon glyphicon-send"></span>
		</button>
		<br> <br>
		<div id="funTime"></div>
		<br>
		<table class="table table-responsive" id="resultTable">
			<tbody class="fileResult" id="fileResult">
			</tbody>
		</table>
	</center>
	<script type="text/javascript">
		(function($) {
			var startFunction;
			var fileResult = document.getElementById("fileResult");
			var xmlHttp = null;
			$("#getFile").click(function() {
				startFunction = new Date().getTime();
				// var URL = "${DatatpeZhXViewpoint}";
				var URL = "${DatatpeEnXViewpoint}";
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
									// 									console.log("j" + imgArray[j]);
								}
								// 								console.log(rownum + "\t" + stitle + "\t" + cat2 + "\t" + memoTime + "\t" + xbody + "\t" + address + "\t" + imgArray[0]);

								var ELEImg = document.createElement("img");
								ELEImg.setAttribute("src", imgArray[0]);

								// 編號		ELEtd1
								var ELEtd1 = document.createElement("td");
								var TXTrownum = document.createTextNode(rownum);
								ELEtd1.appendChild(TXTrownum);
								// 景點名稱	ELEtd3
								var ELEtd3 = document.createElement("td");
								var TXTrownum = document.createTextNode(stitle);
								ELEtd3.appendChild(TXTrownum);
								// 景點分類	ELEtd4
								var ELEtd4 = document.createElement("td");
								var TXTcat2 = document.createTextNode(cat2);
								ELEtd4.appendChild(TXTcat2);
								// 開放時間	ELEtd5
								var ELEtd5 = document.createElement("td");
								// var ELEtd5Len = 19;
								// var TXTmemoTime = document.createTextNode(memoTime.length >= ELEtd5Len ? memoTime.toString().substring(0, ELEtd5Len) + "..." : memoTime);
								var TXTmemoTime = document.createTextNode(memoTime);
								ELEtd5.appendChild(TXTmemoTime);
								// 景點描述	ELEtd6
								var ELEtd6 = document.createElement("td");
								// var ELEtd6Len = 140;
								// var TXTxbody = document.createTextNode(xbody.length >= ELEtd6Len ? xbody.toString().substring(0, ELEtd6Len) + "..." : xbody);
								var TXTxbody = document.createTextNode(xbody);
								ELEtd6.appendChild(TXTxbody);
								// 景點圖片	ELEtd2
								var ELEtd2 = document.createElement("td");
								var ELEimg = document.createElement("img");
								var SIZEimg = "120px";
								ELEimg.setAttribute("class", "img-circle");
								ELEimg.setAttribute("src", imgArray[0]);
								ELEimg.setAttribute("title", stitle);
								ELEimg.setAttribute("width", SIZEimg);
								ELEimg.setAttribute("height", SIZEimg);
								ELEimg.setAttribute("style", "border:1.5px solid black");
								ELEtd2.appendChild(ELEimg);

								var ELEtr = document.createElement("tr");
								ELEtr.appendChild(ELEtd1);
								ELEtr.appendChild(ELEtd2);
								ELEtr.appendChild(ELEtd3);
								ELEtr.appendChild(ELEtd4);
								ELEtr.appendChild(ELEtd5);
								ELEtr.appendChild(ELEtd6);

								fileResult.appendChild(ELEtr);

							} catch (e) {
							}
						}
					} else {
						$("#getFileResult").innerHTML = xmlHTTP.status + ":" + xmlHTTP.statusText;
					}
					$("#funTime").text("執行時間：" + ((new Date().getTime()) - startFunction).toString() + "毫秒");
				}

			}
		}(jQuery));
	</script>
</body>
</html>