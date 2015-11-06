<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>計算機</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/MathExam.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<center>
		<table id="calculatorMachine">
			<thead>
				<tr>
					<th colspan="4">計算機</th>
				</tr>
				<tr>
					<th colspan="4"><input type="text" id="output"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="button" value="clear"></td>
					<td><input type="button" value="("></td>
					<td><input type="button" value=")"></td>
					<td><input type="button" value="←"></td>
				</tr>
				<tr>
					<td><input type="button" value="7"></td>
					<td><input type="button" value="8"></td>
					<td><input type="button" value="9"></td>
					<td><input type="button" value="/"></td>
				</tr>
				<tr>
					<td><input type="button" value="4"></td>
					<td><input type="button" value="5"></td>
					<td><input type="button" value="6"></td>
					<td><input type="button" value="*"></td>
				</tr>
				<tr>
					<td><input type="button" value="1"></td>
					<td><input type="button" value="2"></td>
					<td><input type="button" value="3"></td>
					<td><input type="button" value="-"></td>
				</tr>
				<tr>
					<td><input type="button" value="0"></td>
					<td><input type="button" value="."></td>
					<td><input type="button" value="="></td>
					<td><input type="button" value="+"></td>
				</tr>

			</tbody>
		</table>
	</center>
	<script type="text/javascript">
		(function($) {
			var temp = "";
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
		}(jQuery));
	</script>
</body>
</html>