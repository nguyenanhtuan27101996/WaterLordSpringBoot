$(document).ready(function(){
	// 
    $("#btn-data-input").click(function(){
        $("#data-entry-div").css("background-color", "green");
        alert("Clicked");
    });
    // delete record function
    $("body").on("click",".btn-delete",function(){
		var mahedt = $(this).closest("tr").find("#p-mahedt").text();
		var self = $(this);
		var choice = confirm("Bạn có chắc chắn muốn xóa? ");
		if (choice == true){
			$.ajax({
				url : "/hedaotao/delete",
				type : "POST",
				data : {
					mahedt : mahedt
				},
				success : function(value) {
					if ("true" == value.toString()) {
						alert("Delete successfully !");
						self.closest("tr").remove();
					} else {
						alert("Delete error !");
					}

				}
			});
		}	
	});
    // insert new record function
    
});
