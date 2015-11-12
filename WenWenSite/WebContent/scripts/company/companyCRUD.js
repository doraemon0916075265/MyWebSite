(function($) {
	$("#cleanInput").click(function() {
		$("input[type='text']").val("");
	});
	$("#selectData").click(function() {
		$("#companyCRUDtable tr:gt(1) td input[type='text']").val("");
	});
}(jQuery));