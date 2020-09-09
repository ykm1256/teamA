$("#head").change(function(){
	var head = $("#head").val();
	
	$.ajax({
	url: "incomeTrainerChart.do",
	type: "post",	
	data: { "head": head },
	success: function(data) {
		data = $.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			tid.push(data[i].tid);
			income.push(data[i].income);
			tname.push(data[i].tname);
		}
	},
	error: function(e) {
		alert(e);
	}

}) 
})