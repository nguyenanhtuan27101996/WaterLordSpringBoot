<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
					<a href="#" class="active">Sinh viên</a> <a href="#">Lớp</a> <a
						href="#">Hệ đào tạo</a>
				</div>
			</div>

			<div class="col-lg-10">
				<div>
					<div class="">
						<div class="pull-left">
							<form class="navbar-form" action="#">
								<input type="text" class="form-control" placeholder="Search">
								<button type="button" class="btn btn-primary">Filter by
									name</button>
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
								<tr>
									<td id="masv">${s.maSV}</td>
									<td id="tensv">${s.tenSV}</td>
									<td id="ngaysinh"><c:set var="ngaysinh"
											value="${s.ngaySinh}" /> ${fn:substring(ngaysinh,0,10)}</td>
									<td id="gioitinh"><c:choose>
											<c:when test="${s.gioiTinh=='true'}">
							  Nam
							</c:when>
											<c:otherwise>
							   Nữ
							</c:otherwise>
										</c:choose></td>
									<td id="quequan">${s.queQuan}</td>
									<td id="lop">${s.lop.tenLop}</td>
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
				<nav class="pull-right" aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav>
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
							<label>Mã SV:</label>     <input type="text"
								class="form-control" id="text_id">  
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
					<button type="button" class="btn btn-primary save_btn">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//insert sinhvien
		$('.insert_btn').click(
				function() {
					$('#myModal').modal();
					$('.save_btn').click(
							function() {
								var masv = $('#text_id').val();
								var tensv = $('#text_name').val();
								var ngaysinh = $('#text_date').val();
								var gioitinh = $('#text_sex').val();
								var quequan = $('#text_address').val();
								var lop = $('#text_class').val();
								var maker = "<tr><td id='masv'>" + masv
										+ "</td><td id='tensv'>" + tensv
										+ "</td><td id='ngaysinh'>" + ngaysinh
										+ "</td><td id='gioitinh'>" + gioitinh
										+ "</td><td id='quequan'>" + quequan
										+ "</td><td id='lop'>" + lop
										+ "</td></tr>"
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
									success : function(value) {
										if (value === "true") {
											alert("Insert Successfully");
											$('table > tbody >tr:first')
													.before(maker);

										} else
											alert("Insert Failed");

									}

								});
							});
				});
		//end insert sinhvien
	</script>

	<footer> </footer>
</body>


</html>