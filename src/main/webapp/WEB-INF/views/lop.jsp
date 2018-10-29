<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" 
integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" 
crossorigin="anonymous">
<title>Lớp</title>
</head>
<body>
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
                <a href="/sinhvien">Sinh viên</a>
                <a href="/lop" class="active">Lớp</a>
                <a href="/hedaotao">Hệ đào tạo</a>
            </div>
        </div>

        <div class="col-lg-10">
            <div>
                <div class="">
                    <div class="pull-left">
                        <form class="navbar-form" action="#">
                        	<i class="fas fa-filter"></i>&nbsp;&nbsp;&nbsp;
                            <input type="text" id="text-filter-tenlop" class="form-control" placeholder="Lọc theo tên lớp">
                            <!-- <button type="button" id="btn-filter-by-name" class="btn btn-primary">Filter by name</button> -->
                        </form>
                    </div>
                </div>
                <div class="">
                    <div class="pull-right" style="margin-top:10px">
                        <button id="btn-insert" class="btn btn-success" type="button">Thêm lớp</button>
                    </div>
                </div>
            </div>
            <!--Table-->
            <div>
                <table id="table-lop" class="table table-bordered">
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
								<td><button class="btn btn-warning btn-update">Cập nhật</button></td>
								<td><button class="btn btn-danger btn-delete">Xóa</button></td>
							</tr>
						</c:forEach>

					</tbody>
                </table>
            </div>
          
        </div>
        <div class="col-lg-1">
        </div>
    </div>
    <footer>
        
    </footer>
    
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
	
	<!-- Modal Update Lop -->
	<div class="modal" id="modelFormUpdateLop" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Update Account</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Mã lớp : <input type="text" disabled="disabled" id="text-malop" class="form-control" placeholder="Điền vào mã lớp">
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
					<button id="btn-save-update" type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	
    <script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
	
</body>
</html>