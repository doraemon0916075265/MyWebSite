(function($) {
	$("#cleanInput").click(clearAllData);
	$("#deleteData").click(clearDataExceptID);
	$("#selectData").click(clearDataExceptID);

	function clearAllData() {
		$("input[type='text']").val("");
	}
	function clearDataExceptID() {
		$("#companyCRUDtable tbody tr:gt(1) td input[type='text']").val("");
	}

}(jQuery));