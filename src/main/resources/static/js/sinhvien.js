$(document).ready(function(){
		//insert sinhvien
		$('.insert_btn')
				.click(
						
						function() {
							$('#myModal').modal();
							$('#text_id').val("");
							$('#text_name').val("");
							$('#text_date').val("");
							$('#text_address').val("");
							$('#insert_save')
									.click(
											function() {
												
												var masv = $('#text_id').val();
												var tensv = $('#text_name').val();
												var ngaysinh = $('#text_date').val();
												var gioitinh = $('#text_sex').val();
												var tran_gioitinh;
												if(gioitinh=='true')tran_gioitinh='Nam';
												else tran_gioitinh='Nữ';
												var quequan = $('#text_address').val();
												var lop = $('#text_class').val();
												var tran_lop =$("#text_class  option:selected").text(); //từ đây nè
												
												console.log(tran_lop);
												var maker = "<tr class='onRow'><td>"
														+ masv
														+ "</td><td >"
														+ tensv
														+ "</td><td >"
														+ ngaysinh
														+ "</td><td >"
														+ tran_gioitinh
														+ "</td><td>"
														+ quequan
														+ "</td><td >"
														+ tran_lop
														+ "</td><td><button type='button' class='btn btn-warning edit_btn'>Cập nhật</button></td>"
														+ "<td><button type='button' class='btn btn-danger delete_btn '>Xóa</button></td>"
														+ "</tr>";
														var flag=validate();
														if(flag==true){
												$('#myModal').modal("hide");
												$.ajax({
															url : "sinhvien/insert",
															method : "POST",
															data : {
																masv : masv,
																tensv : tensv,
																ngaysinh : ngaysinh,
																gioitinh : gioitinh,
																quequan : quequan,
																lop : lop
															},
															success : function(
																	value) {
																if (value === "true") {
																	alert("Insert Successfully");
																//	$('table > tbody >tr:first')
																	//		.before(
																//					maker);
																$("table").append(maker);

																} else
																	alert("Insert Failed");

															}

														});
												}
													
											});
							
						});
		//end insert sinhvien
		//update sinhvien
		$(document).on('click','.edit_btn',
				function(e) {
					var masv = $(this).closest('.onRow')
							.find('td:nth-child(1)').text();
					var tensv = $(this).closest('.onRow').find(
							'td:nth-child(2)').text();
					var ngaysinh = $(this).closest('.onRow').find(
							'td:nth-child(3)').text();
					var gioitinh = $(this).closest('.onRow').find(
							'td:nth-child(4)').text().trim();
					console.log(gioitinh);
					var quequan = $(this).closest('.onRow').find(
							'td:nth-child(5)').text();
					var lop = $(this).closest('.onRow').find('td:nth-child(6)')
							.text();
					var e = $(this);
					$('#myModal2').modal();
					$('#text_id2').val(masv);
					$('#text_id2').attr("readonly", true);
					$('#text_name2').val(tensv);
					$('#text_date2').val(ngaysinh);
					$("#text_sex2 option:contains(" + gioitinh + ")").attr(
							'selected', 'selected');
					$('#text_address2').val(quequan);
					$("#text_class2 option:contains(" + lop + ")").attr(
							'selected', 'selected');
					$('#edit_save').click(
							function() {
								
								var masv = $('#text_id2').val();
								var tensv = $('#text_name2').val();
								var ngaysinh = $('#text_date2').val();
								var gioitinh = $('#text_sex2').val();
								var tran_gioitinh =$("#text_sex2  option:selected").text();
								var quequan = $('#text_address2').val();
								var lop = $('#text_class2').val();
								var tran_lop =$("#text_class2  option:selected").text();
								var flag=validate2();
								if(flag==true){
								$('#myModal2').modal("hide");
								$.ajax({
									url : "sinhvien/update",
									method : "POST",
									data : {
										masv : masv,
										tensv : tensv,
										ngaysinh : ngaysinh,
										gioitinh : gioitinh,
										quequan : quequan,
										lop : lop
									},
									success : function(value) {
										if (value === "true") {
											alert("Update Successfully");
											e.closest('.onRow').find(
													'td:nth-child(1)').text(
													masv);
											e.closest('.onRow').find(
													'td:nth-child(2)').text(
													tensv);
											e.closest('.onRow').find(
													'td:nth-child(3)').text(
													ngaysinh);
											e.closest('.onRow').find(
													'td:nth-child(4)').text(
													tran_gioitinh);
											e.closest('.onRow').find(
													'td:nth-child(5)').text(
													quequan);
											e.closest('.onRow').find(
													'td:nth-child(6)').text(
													tran_lop);

										} else
											alert("Update Failed");

									}

								});
								}
							});
				});
		//end update sinhvien
		//delete sinhvien
		$(document).on('click','.delete_btn',
		   function(event) {
			var id = $(this).closest('.onRow').find('td:nth-child(1)').text();
			var event = $(this);
			var choice=confirm("Bạn có muốn xóa không?");
			if(choice){
			$.ajax({
				url : "sinhvien/delete",
				type : "POST",
				data : {
					masv : id

				},
				success : function(value) {
					if (value === "false") {
						alert("Delete không thành công");
					} else {
						alert("Delete thành công");
						event.closest('.onRow').remove();
					}
				}
			});
			}
		});
		//end delete sinhvien
		//seach
		$(document).on('keyup','#key',
		   function(event) {
		var event = $(this);
		var key = $("#key").val();
		$.ajax({
			url : "sinhvien/search",
			type : "POST",
			data : {
				search: key
			},
			success : function(value) {
				event.closest("body").find("#table_body").empty();
				event.closest("body").find("#table_body").append(value);
			}
		});
	});
		//end search
		//validate data
		function validate()
	                {
			var masv = $('#text_id').val().trim();
			var tensv = $('#text_name').val().trim();
			var ngaysinh = $('#text_date').val().trim();
			var tran_gioitinh =$("#text_sex  option:selected").text().trim();
			var quequan = $('#text_address').val().trim();
			var tran_lop =$("#text_class  option:selected").text().trim();
			var checkdate=/^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
			if(/\W/.test(masv)||/\s/.test(masv)||masv==""){
				alert("Mã sinh viên chỉ bao gồm chữ hoặc số và không có khoảng trắng");
				return false;
			    }
			if(tensv==""){
				alert("Tên sinh viên không đúng");
			    return false;
			    }
			if(checkdate.test(ngaysinh)!=true){
				alert("Ngày sinh phải nhập có dạng dd/mm/yy hoặc ngày đó không tồn tại");
			    return false;
			   }
			if(tran_gioitinh==""){
				alert("Bạn chưa chọn giới tính");
			    return false;
		      	}
			if(quequan==""){
				alert("Quê quán sai dịnh dạng");
			    return false;
		      	}
			if(tran_lop==""){
				alert("Bạn chưa chọn lớp");
			    return false;
		      	}
			return true;
	         }
	                
		//end validate data
			//validate êdit data
		function validate2()
	                {
			var masv = $('#text_id2').val().trim();
			var tensv = $('#text_name2').val().trim();
			var ngaysinh = $('#text_date2').val().trim();
			var tran_gioitinh =$("#text_sex2  option:selected").text().trim();
			var quequan = $('#text_address2').val().trim();
			var tran_lop =$("#text_class2  option:selected").text().trim();
			var checkdate=/^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
			if(/\W/.test(masv)||/\s/.test(masv)||masv==""){
				alert("Mã sinh viên chỉ bao gồm chữ hoặc số và không có khoảng trắng");
				return false;
			    }
			if(tensv==""){
				alert("Tên sinh viên không đúng");
			    return false;
			    }
			if(checkdate.test(ngaysinh)!=true){
				alert("Ngày sinh phải nhập có dạng dd/mm/yy hoặc ngày đó không tồn tại");
			    return false;
			   }
			if(tran_gioitinh==""){
				alert("Bạn chưa chọn giới tính");
			    return false;
		      	}
			if(quequan==""){
				alert("Quê quán sai dịnh dạng");
			    return false;
		      	}
			if(tran_lop==""){
				alert("Bạn chưa chọn lớp");
			    return false;
		      	}
			return true;
	         }
	                
		//end validate data
	});