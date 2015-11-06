(function($) {

	var temp = $("#output").val();
	$("#calculatorMachine tbody tr td input[type='button']").click(function() {
		var input = $(this).val();

		if (input == "=") {
			try {
				var output = eval(temp);
				if (!isNaN(output)) {
					temp = "" + output;
					$("#output").val(output);
				}
			} catch (e) {
				$("#output").val("error");
				temp = "";
			}
		} else if (input == "clear") {
			temp = "";
			$("#output").val(temp);
		} else if (input == "←") {
			temp = temp.substring(0, temp.length - 1);
			$("#output").val(temp);
		} else {
			temp += input;
			$("#output").val(temp);
		}

	});

	$("body").keyup(function keyboardEvent(event) {
		var answer = $("#output").val();
		var keyinCode = event.keyCode;

		if (keyinCode >= 96 && keyinCode <= 105) {
			// 讀取 0 ~ 9
			answer += (keyinCode - 96);
			temp = answer;
			$("#output").val(temp);
		} else if (keyinCode == 107) {
			answer += "+";
			temp += answer;
			$("#output").val(temp);
		}

		console.log("temp\t" + temp);
		console.log("answer\t" + answer);
	});

}(jQuery));