(function($) {

	var errorExpression = "算式錯誤";
	// var errorMessage = "沒輸入數字";
	var regexpLeastANumber = "/^(?=.*\\d).+$/";// 至少要有一個數字
	var answer;

	$("#calculatorMachine tbody tr td input[type='button']").click(function() {
		answer = $("#output").val();
		var input = $(this).val();
		$("#output").css('color', 'black');

		exceptionHandlerBegin(); // 前置錯誤處理

		// console.log(answer.match(regexpLeastANumber));

		if (input == "=") {
			try {
				var output = eval(answer);
				if (!isNaN(output)) {
					answer = "" + output;
					$("#output").val(output);
					$("#output").css('color', 'blue');
				}
			} catch (e) {
				$("#output").val(errorExpression);
				$("#output").css('color', 'red');
				answer = "";
			}
		} else if (input == "清除") {
			answer = "";
			$("#output").val(answer);
		} else if (input == "←") {
			answer = answer.substring(0, answer.length - 1);
			$("#output").val(answer);
		} else {
			answer += input;
			$("#output").val(answer);
		}

		exceptionHandlerEnd();// 後置錯誤處理

		console.log("answer =\t" + answer);
	});

	$("body").keydown(function keyboardEvent(event) {
		var answer = $("#output").val();
		var keyinCode = event.keyCode;
		$("#output").css('color', 'black');

		exceptionHandlerBegin(); // 前置錯誤處理

		if (keyinCode >= 96 && keyinCode <= 105) {
			// 讀取 0 ~ 9
			answer += (keyinCode - 96);
			$("#output").val(answer);
		} else if (keyinCode == 107) {// 107 => +
			answer += "+";
			$("#output").val(answer);
		} else if (keyinCode == 109) {// 109 => -
			answer += "-";
			$("#output").val(answer);
		} else if (keyinCode == 106) {// 106 => *
			answer += "*";
			$("#output").val(answer);
		} else if (keyinCode == 111) {// 111 => /
			answer += "/";
			$("#output").val(answer);
		} else if (keyinCode == 110) {// 110 => .
			answer += ".";
			$("#output").val(answer);
		} else if (keyinCode == 8) {// 8 => ←
			answer = answer.substring(0, answer.length - 1);
			$("#output").val(answer);
		} else if (keyinCode == 13) {// 13 => Enter
			try {
				var output = eval(answer);
				if (!isNaN(output)) {
					answer = "" + output;
					$("#output").val(output);
					$("#output").css('color', 'blue');
				}
			} catch (e) {
				$("#output").val(errorExpression);
				$("#output").css('color', 'red');
				answer = "";
			}
		} else if (keyinCode == 27) {// esc => 清除
			answer = "";
			$("#output").val(answer);
		}

		exceptionHandlerEnd();// 後置錯誤處理
		console.log("answer =\t" + answer);
	});

	function exceptionHandlerBegin() {
		/** 前置錯誤處理 */
		answer = $("#output").val();
		if (answer == errorExpression) {
			$("#output").val("");
			answer = "";
		}
	}

	function exceptionHandlerEnd() {
		/** 後置錯誤處理 */
		answer = $("#output").val();
		// console.log(answer.match(regexpLeastANumber));

	}

}(jQuery));