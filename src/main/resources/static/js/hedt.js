$(document).ready(function(){
	// 
    $("#btn-data-input").click(function(){
        $("#data-entry-div").css("background-color", "green");
        //alert("Clicked");
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
    $("#btn-insert").click(function(){
    	var pagehdt = $(this);
		var mahedt = $("#data-entry-form").find("#text-mahedt").val();
		var tenhedt = $("#data-entry-form").find("#text-tenhedt").val();
		$.ajax({
			url : "/hedaotao/insert",
			type : "POST",
			data : {
				mahedt: mahedt,
				tenhedt: tenhedt,
			},
			success : function(value) {
				if ("true"==value.toString()) {
					alert("Insert successfully");
					
					var htmlElement = "<tr>";
					htmlElement += "<td id='p-mahedt'>"+mahedt+"</td>";
					htmlElement += "<td id='p-tenhedt'>"+tenhedt+"</td>";
					htmlElement += "<td><button class='btn btn-warning btn-update'>Update</button></td></td>";
					htmlElement += "<td><button class='btn btn-danger btn-delete'>Delete</button></td>";
					htmlElement += "</tr>";
					pagehdt.closest("body").find("#content-hedt").append(htmlElement);
					
				} else {
					alert("Insert error");
				}
			}
		});
	});
    // modify exist record in db
    $("body").on("click",".btn-update",function(){
		var pagehdt = $(this);
		var mahedt = pagehdt.closest("tr").find("#p-mahedt").text();
		var tenhedt = pagehdt.closest("tr").find("#p-tenhedt").text();
		
    	$("#modalUpdateHeDT").modal("show");
		$("#modalUpdateHeDT").find("#text-mahedt").val(mahedt);
		$("#modalUpdateHeDT").find("#text-tenhedt").val(tenhedt);
		
		$("#btn-save-update").click(function(){
			var mahedt = $("#modalUpdateHeDT").find("#text-mahedt").val();
			var tenhedt = $("#modalUpdateHeDT").find("#text-tenhedt").val();
				$.ajax({
					url : "/hedaotao/update",
					type : "POST",
					data : {
						mahedt: mahedt,
						tenhedt: tenhedt
					},
					success : function(value) {
						if ("true" == value.toString()) {
							$("#modalUpdateHeDT").modal("hide");
							alert("Update successfully");
							pagehdt.closest("tr").find("#p-mahedt").text(mahedt);
							pagehdt.closest("tr").find("#p-tenhedt").text(tenhedt);						
						} else {
							$("#modalUpdateHeDT").modal("hide");
							alert("Update error");
						}
					}
				});
		});	
	});
});
