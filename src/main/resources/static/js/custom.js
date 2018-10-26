$(document).ready(function(){
	$("body").on("click",".btn-delete",function(){
		var maLop = $(this).closest("tr").find("#p-malop").text();
		var self = $(this);
		var choice = confirm("Are you want to delete this account ? ");
		if (choice == true){
			$.ajax({
				url : "/lop/delete",
				type : "POST",
				data : {
					maLop : maLop
				},
				success : function(value) {
					if ("true" == value.toString()) {
						alert("Xóa lớp thành công !");
						self.closest("tr").remove();
					} else {
						alert("Xóa lớp thất bại !");
					}

				}
			});
		}	
	});
	
	$("#btn-insert").click(function(){
		var self = $(this);
		$("#modelFormInsertLop").modal("show");
		
		$("#btn-save-insert").click(function(){
			var maLop = $("#modelFormInsertLop").find("#text-malop").val();
			var tenLop = $("#modelFormInsertLop").find("#text-tenlop").val();
			alert(maLop + tenLop);
//			
//			if (pwd.length > 6 && validateEmail(email)){
//				$.ajax({
//					url : "/account/insert",
//					type : "POST",
//					data : {
//						fullName: fullName,
//						telephoneNumber: telephoneNumber,
//						email: email,
//						pwd: pwd
//					},
//					success : function(value) {
//						if (parseInt(value) > 0) {
//							$("#modelFormInsertAccount").modal("hide");
//							alert("Insert successfully");
//							var hashPwd = sha256.create();
//							hashPwd.update(pwd);
//							hashPwd.hex();
//							
//							var htmlElement = "<tr>";
//							htmlElement += "<td id='p-accountid'>"+parseInt(value)+"</td>";
//							htmlElement += "<td id='p-fullname'>"+fullName+"</td>";
//							htmlElement += "<td id='p-telephone-number'>"+telephoneNumber+"</td>";
//							htmlElement += "<td id='p-email'>"+email+"</td>";
//							htmlElement += "<td id='p-password'>"+hashPwd+"</td>";
//							htmlElement += "<td><button class='btn btn-warning btn-update'>Update</button></td></td>";
//							htmlElement += "<td><button class='btn btn-danger btn-delete'>Delete</button></td>";
//							htmlElement += "</tr>";
//							self.closest("body").find("#content-account").append(htmlElement);
//							
//						} else {
//							$("#modelFormInsertAccount").modal("hide");
//							alert("Insert error");
//						}
//					}
//				});
//			} else {
//				alert("Mật khẩu không đủ mạnh hoặc email sai định dạng !");
//			}
//			
		});
	});
});