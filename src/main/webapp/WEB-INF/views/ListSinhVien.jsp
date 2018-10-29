<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/style.css"> -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SinhVien</title>
</head>

<body>
	<div>
		<header>
			<div class="container">
				<!--navigation bar-->
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">HỆ THỐNG DU HỌC</a>
						</div>

					</div>
				</nav>
			</div>
		</header>

		<div class="container">
			<!--Filter area and function button-->
			<div class="col-lg-2">
				<div class="vertical-menu">
					<a href="#" class="active">Sinh viên</a>
					 <a href="/lop">Lớp</a> 
					 <a href="/hedaotao">Hệ đào tạo</a>
				</div>
			</div>

			<div class="col-lg-10">
				<div>
					<div class="">
						<div class="pull-left">
							<form class="navbar-form" action="${contextPath}/sinhvien/search" method="POST">
								<input type="text" name="search" class="form-control" placeholder="Search">
								<input type="submit" class="btn btn-primary" value="Search">
							</form>
						</div>
					</div>
					<div class="">
						<div class="pull-right" style="margin-top: 10px">
							<button class="btn btn-success insert_btn" type="button">Add
								new student</button>
						</div>
					</div>
				</div>
				<!--Table-->
				<div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Mã SV</th>
								<th>Tên SV</th>
								<th>Ngày sinh</th>
								<th>Giới tính</th>
								<th>Quê Quán</th>
								<th>Lớp</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listSinhVien}" var="s">
								<tr class="onRow">
									<td>${s.maSV}</td>
									<td >${s.tenSV}</td>
									<td >${s.ngaySinh}</td>
									<c:choose>
									<c:when test="${s.gioiTinh=='true'}"><td >Nam</td></c:when>
									<c:otherwise><td >Nữ</td></c:otherwise>
									</c:choose>
									<td >${s.queQuan}</td>
									<td >${s.lop.tenLop}</td>
									<td>
										<button type="button" class="btn btn-info edit_btn">Edit</button>
									</td>
									<td>
										<button type="button" class="btn btn-info delete_btn ">Delete</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--EndTable-->
				<!-- <nav class="pull-right" aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav> -->
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
	
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<!-- <h4 class="modal-title">Confirmation</h4> -->
				</div>
				<div class="modal-body">
					<div class="col-xs-8 center-block" style="float: none;">


						<div>
							<label>Mã SV:</label>     <input type="text" class="form-control"
								id="text_id">  
						</div>
						<div>
							<label>Tên SV:</label>     <input type="text"
								class="form-control" id="text_name">  
						</div>
						<div>
							<label>Ngày Sinh:</label>     <input type="text"
								class="form-control" id="text_date">  
						</div>
						<div>
							<label>Giới Tính:</label>     <select class="form-control"
								id="text_sex">
								<option value="true">Nam</option>
								<option value="false">Nữ</option>
							</select> 
						</div>
						<div>
							<label>Quê Quán:</label>     <input type="text"
								class="form-control" id="text_address">
						</div>
						<br>
						<div>
							<label>Lớp:</label> <select class="form-control" id="text_class">
								<c:forEach items="${listLop}" var="l">
									<option value="${l.maLop}">${l.tenLop}</option>
								</c:forEach>
							</select>  
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="insert_save">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
	<!--  -->
		<div id="myModal2" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<!-- <h4 class="modal-title">Confirmation</h4> -->
				</div>
				<div class="modal-body">
					<div class="col-xs-8 center-block" style="float: none;">


						<div>
							<label>Mã SV:</label>     <input type="text" class="form-control"
								id="text_id2">  
						</div>
						<div>
							<label>Tên SV:</label>     <input type="text"
								class="form-control" id="text_name2">  
						</div>
						<div>
							<label>Ngày Sinh:</label>     <input type="text"
								class="form-control" id="text_date2">  
						</div>
						<div>
							<label>Giới Tính:</label>     <select class="form-control"
								id="text_sex2">
								<option value="true"> Nam </option>
								<option value="false"> Nữ </option>
							</select> 
						</div>
						<div>
							<label>Quê Quán:</label>     <input type="text"
								class="form-control" id="text_address2">
						</div>
						<br>
						<div>
							<label>Lớp:</label> <select class="form-control" id="text_class2">
								<c:forEach items="${listLop}" var="l">
									<option value="${l.maLop}">${l.tenLop}</option>
								</c:forEach>
							</select>  
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary " id="edit_save">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
<!--   <script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script> 
	<script src="js/sinhvien.js"></script> -->
	<script>
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
														+ "</td><td><button type='button' class='btn btn-info edit_btn'>Edit</button></td>"
														+ "<td><button type='button' class='btn btn-info delete_btn '>Delete</button></td>"
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

		});
		//end delete sinhvien
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
	</script>
	<footer> </footer>
</body>


</html>