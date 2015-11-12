(function($) {
	$("#cleanInput").click(function() {
		$("input[type='text']").val("");
	});
	$("#selectData").click(function() {
		$("#companyCRUDtable tbody tr:gt(0) td input[type='text']").val("");
	});
}(jQuery));