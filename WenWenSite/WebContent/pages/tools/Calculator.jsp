<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/MathExam.css">
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
				<td><input type="button" value="清除"></td>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/tools/CalculatorMachine.js"></script>
