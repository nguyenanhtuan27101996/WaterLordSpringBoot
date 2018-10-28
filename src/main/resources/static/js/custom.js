//NATuan3
$(document).ready(function(){
	$("body").on("click",".btn-delete",function(){
		var maLop = $(this).closest("tr").find("#p-malop").text();
		var self = $(this);
		var choice = confirm("Bạn có chắc muốn xóa lớp này ? ");
		
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
			var maHeDT = $("#modelFormInsertLop").find("#select-mahedt").val();
			var maKhoa = $("#modelFormInsertLop").find("#select-makhoa").val();
			var maKhoaHoc = $("#modelFormInsertLop").find("#select-makhoahoc").val();
			
			if (maLop.length > 0 && tenLop.length > 0){
				$.ajax({
					url : "/lop/insert",
					type : "POST",
					data : {
						maLop: maLop,
						tenLop: tenLop,
						maHeDT: maHeDT,
						maKhoa: maKhoa,
						maKhoaHoc: maKhoaHoc
						
					},
					success : function(value) {
						if ("true" == value.toString()) {
							$("#modelFormInsertLop").modal("hide");
							alert("Thêm lớp thành công ! ");
							
							var htmlElement = "<tr>";
							htmlElement += "<td id='p-malop'>"+ maLop +"</td>";
							htmlElement += "<td id='p-tenlop'>"+ tenLop +"</td>";
							htmlElement += "<td id='p-mahedt'>"+ maHeDT +"</td>";
							htmlElement += "<td id='p-makhoa'>"+ maKhoa +"</td>";
							htmlElement += "<td id='p-makhoahoc'>"+ maKhoaHoc +"</td>";
							htmlElement += "<td><button class='btn btn-warning btn-update'>Cập nhật</button></td></td>";
							htmlElement += "<td><button class='btn btn-danger btn-delete'>Xóa</button></td>";
							htmlElement += "</tr>";
							self.closest("body").find("#content-lop").append(htmlElement);
							
						} else {
							$("#modelFormInsertAccount").modal("hide");
							alert("Thêm lớp thất bại ! ");
						}
					}
				});
			} else {
				alert("Mã lớp và tên lớp không được để trống ! ");
			}
			
		});
	});
	
	$("body").on("click",".btn-update",function(){
		var self = $(this);
		var maLop = self.closest("tr").find("#p-malop").text();
		var tenLop = self.closest("tr").find("#p-tenlop").text();
		var maHeDT = self.closest("tr").find("#p-mahedt").text();
		var maKhoa = self.closest("tr").find("#p-makhoa").text();
		var maKhoaHoc = self.closest("tr").find("#p-makhoahoc").text();
		
		$("#modelFormUpdateLop").modal("show");
		$("#modelFormUpdateLop").find("#text-malop").val(maLop);
		$("#modelFormUpdateLop").find("#text-tenlop").val(tenLop);
		$("#modelFormUpdateLop").find("#select-mahedt").val(maHeDT);
		$("#modelFormUpdateLop").find("#select-makhoa").val(maKhoa);
		$("#modelFormUpdateLop").find("#select-makhoahoc").val(maKhoaHoc);

		$("#btn-save-update").click(function(){
			var maLop = $("#modelFormUpdateLop").find("#text-malop").val();
			var tenLop = $("#modelFormUpdateLop").find("#text-tenlop").val();
			var maHeDT = $("#modelFormUpdateLop").find("#select-mahedt").val();
			var maKhoa = $("#modelFormUpdateLop").find("#select-makhoa").val();
			var maKhoaHoc = $("#modelFormUpdateLop").find("#select-makhoahoc").val();
			
			if (tenLop.length > 0){
				$.ajax({
					url : "/lop/update",
					type : "POST",
					data : {
						maLop: maLop,
						tenLop: tenLop,
						maHeDT: maHeDT,
						maKhoa: maKhoa,
						maKhoaHoc: maKhoaHoc
					},
					success : function(value) {
						if ("true" == value.toString()) {
							$("#modelFormUpdateLop").modal("hide");
							alert("Cập nhật thông tin lớp thành công ! ");
							self.closest("tr").find("#p-tenlop").text(tenLop);
							self.closest("tr").find("#p-mahedt").text(maHeDT);
							self.closest("tr").find("#p-makhoa").text(maKhoa);
							self.closest("tr").find("#p-makhoahoc").text(maKhoaHoc);
							
						} else {
							$("#modelFormUpdateLop").modal("hide");
							alert("Cập nhật thông tin lớp thất bại ! ");
						}
					}
				});
			} else {
				alert("Tên lớp không được để trống !");
			}	
		});	
	});
	
	$("#text-filter-tenlop").keyup(function(){
		var self = $(this);
		var tenLop = $(this).val();
		$.ajax({
			url : "/lop/filter",
			type : "POST",
			data : {
				tenLop: tenLop
			},
			success : function(value) {
				self.closest("body").find("#content-lop").empty();
				self.closest("body").find("#content-lop").append(value);
			}
		});
	});
	$("#btn-dangky").click(function(){
		alert("abc");
	});
	
});