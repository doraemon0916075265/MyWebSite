<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:if test="${not empty error}">
	<hr>
	<c:out value="XML：${error.optionItem}"></c:out>
	<hr>
</c:if>
<c:if test="${not empty searchOpenDataXML}">
	<hr>
	<c:out value="XML：${searchOpenDataXML}"></c:out>
	<hr>
	<script type="text/javascript">
		(function($) {
			var xmlHttp = null;
			var dataURL = "${searchOpenDataXML}";
			var dataURLen = dataURL.length;
			var dataTypeXML = dataURL.substring(dataURLen - 3, dataURLen);
			if (dataTypeXML == "xml") {
				initSearchData();
			}

			function initSearchData() {
				xmlHttp = new XMLHttpRequest();
				if (xmlHttp != null) {
					xmlHttp.addEventListener("readystatechange", startSearch);
					xmlHttp.open("get", dataURL, true);
					xmlHttp.send();
				}
			}

			function startSearch() {
				if (xmlHttp.readyState == 1) {
				} else if (xmlHttp.readyState == 4) {
					if (xmlHttp.status == 200) {
						var datas = xmlHttp.responseXML;
						console.log(datas);
					}
				} else {
					// $("#getFileResult").innerHTML = xmlHTTP.status + ":" + xmlHTTP.statusText;
				}
			}
		}(jQuery));
	</script>
</c:if>
