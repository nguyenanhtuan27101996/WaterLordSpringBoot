<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid">
		<table class="table">
			<thead>
				<tr>
					<th>Mã lớp</th>
					<th>Tên lớp</th>
					<th>Mã Hệ ĐT</th>
					<th>Mã khoa</th>
					<th>Mã khóa học</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody id="content-lop">
				<c:forEach var="lop" items="${listLop }">
					<tr>
						<td id="p-malop">${lop.getMaLop() }</td>
						<td id="p-tenlop"}>${lop.getTenLop() }</td>
						<td id="p-mahedt"}>${lop.getHeDT().getMaHeDT() }</td>
						<td id="p-makhoa"}>${lop.getKhoa().getMaKhoa() }</td>
						<td id="p-makhoahoc"}>${lop.getKhoaHoc().getMaKhoaHoc() }</td>
						<td><button class="btn btn-warning btn-update">Update</button></td>
						<td><button class="btn btn-danger btn-delete">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row text-center">
			<div class=col-md-3">
				<button id="btn-insert" class="btn btn-success">Insert</button>
			</div>
		</div>
	</div>
	
	<!-- Modal Insert Lop -->
	<div class="modal" id="modelFormInsertLop" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Thêm lớp</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Mã lớp : <input type="text" id="text-malop" class="form-control" placeholder="Điền vào mã lớp">
					<br/>
					Tên lớp : <input type="text" id="text-tenlop" class="form-control"  placeholder="Điền vào tên lớp">
					<br/>
					Mã hệ ĐT :
					<select id="select-mahedt" class="form-control">
						<c:forEach var="heDT" items="${listHeDT }">
							<option value="${heDT.getMaHeDT() }">${heDT.getTenHeDT() }</option>
						</c:forEach>
					</select>
					<br/>
					Mã khoa :
					<select id="select-makhoa" class="form-control">
						<c:forEach var="khoa" items="${listKhoa }">
							<option value="${khoa.getMaKhoa() }">${khoa.getTenKhoa() }</option>
						</c:forEach>
					</select>
					<br/>
					Mã khóa học :
					<select id="select-makhoahoc" class="form-control">
						<c:forEach var="khoaHoc" items="${listKhoaHoc }">
							<option value="${khoaHoc.getMaKhoaHoc() }">${khoaHoc.getTenKhoaHoc() }</option>
						</c:forEach>
					</select>
					<br/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="btn-save-insert" type="button" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>