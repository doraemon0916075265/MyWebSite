(function($) {

	var errorExpression = "算式錯誤";
	var errorDivisorZero = "Infinity";
	// var errorMessage = "沒輸入數字";
	var regexpLeastANumber = "/^(?=.*\\d).+$/";// 至少要有一個數字
	var answer;

	/** Web Keyboard 網站鍵盤 */
	$("#calculatorMachine tbody tr td input[type='button']").click(function() {
		answer = $("#output").val();
		var input = $(this).val();
		$("#output").css('color', 'black');

		/** 錯誤處理 Start */
		if (answer == errorExpression || answer == errorDivisorZero) {
			$("#output").val("");
			answer = "";
		}
		/** 錯誤處理 End */

		if (input == "=") {
			try {
				var output = eval(answer);
				if (!isNaN(output)) {
					answer = output;
					$("#output").val(output);
					if (output == errorDivisorZero) {
						$("#output").css('color', 'red');
					} else {
						$("#output").css('color', 'blue');
					}
				}
			} catch (e) {
				answer = "";
				$("#output").val(errorExpression);
				$("#output").css('color', 'red');
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

		console.log("answer =\t" + answer);
	});

	/** Real Keyboard 數字鍵盤 */
	$("#calculatorModal").keydown(function keyboardEvent(event) {
		var answer = $("#output").val();
		var keyinCode = event.keyCode;
		$("#output").css('color', 'black');

		/** 錯誤處理 Start */
		answer = $("#output").val();
		console.log("begin answer" + answer);
		if (answer == errorExpression) {
			$("#output").val("");
			answer = "";
		}
		/** 錯誤處理 End */

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
				answer = "";
				$("#output").val(errorExpression);
				$("#output").css('color', 'red');
			}
		} else if (keyinCode == 27) {// esc => 清除
			answer = "";
			$("#output").val(answer);
		}

		console.log("answer =\t" + answer);
	});

}(jQuery));