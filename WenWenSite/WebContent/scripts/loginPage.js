(function($) {
	$("#usernameChecker").css('display', 'none');
	$("#LoginUsername").blur(CheckUsername);
	var xmlHttp = null;

	function CheckUsername() {
		var username = $(this).val();
		var usernameLength = username.trim().length;
		var usernameCheckResult = document.getElementById("usernameCheckResult");
		if (usernameLength > 0 && username != null) {
			var URLpost = "../login/checkUsername.jsp?";
			var URLget = "../login/checkUsername.jsp?username=" + username;
			xmlHttp = new XMLHttpRequest();
			if (xmlHttp != null) {
				xmlHttp.addEventListener("readystatechange", startCheck);
				/** post */
				xmlHttp.open("post", URLpost, true);
				xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlHttp.send("username=" + username);
				/** get */
				// xmlHttp.open("get", URLget, true);
				// xmlHttp.send();
			} else {
				alert("${BrowserNotSupport}");
			}
		} else {
			$("#usernameCheckResult").css('display', 'none');
		}

	}

	function startCheck() {
		if (xmlHttp.readyState == 1) {
			$("#usernameCheckResult").text("");
			$("#usernameChecker").css('display', 'inline');
		} else if (xmlHttp.readyState == 4) {
			$("#usernameChecker").css('display', 'none');
			if (xmlHttp.status == 200) {
				var outputText = xmlHttp.responseText;
				usernameCheckResult.innerHTML = outputText;
			} else {
				$("#usernameCheckResult").innerHTML = xmlHTTP.status + ":" + xmlHTTP.statusText;
			}
		}
	}
}(jQuery));