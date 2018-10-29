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
<link rel="stylesheet" type="text/css" href="css/style.css">
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
							<form style="display: none;" id="logoutForm" method="POST" action="/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<a onclick="document.forms['logoutForm'].submit()">Logout</a>
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
								<input type="text" id="key" class="form-control" placeholder="Search">
								
						</div>
					</div>
					<div class="">
						<div class="pull-right" style="margin-top: 10px">
							<button class="btn btn-success insert_btn" type="button">Thêm sinh viên</button>
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
						<tbody id="table_body">
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
										<button type="button" class="btn btn-warning edit_btn">Cập nhật</button>
									</td>
									<td>
										<button type="button" class="btn btn-danger delete_btn ">Xóa</button>
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
  <script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script> 
	<script src="js/sinhvien.js"></script>
	<script>
	
	</script>
	<footer> </footer>
</body>


</html>