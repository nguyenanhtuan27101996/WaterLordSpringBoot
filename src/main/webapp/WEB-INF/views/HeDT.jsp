<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
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
                    <a href="#">Lớp</a>
                    <a href="#">Hệ đào tạo</a>
                </div>
            </div>

            <div class="col-lg-10">
                <div>
                    <div class="">
                        <div class="pull-left">
                            <form class="navbar-form" action="#">
                                <input type="text" class="form-control" placeholder="Search">
                                <button type="button" class="btn btn-primary">Filter by name</button>
                            </form>
                        </div>
                    </div>
                    <div class="">
                        <div class="pull-right" style="margin-top:10px">
                            <button class="btn btn-success" type="button">Add new student</button>
                        </div>
                    </div>
                </div>
                <!--Table-->
                <div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Col1</th>
                                <th>Col2</th>
                                <th>Col3</th>
                                <th>Col4</th>
                                <th>Col5</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>

                            <tr>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>mary@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                            <tr>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>july@example.com</td>
                                <td>abc</td>
                                <td>cdf</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
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
            <div class="col-lg-1">
            </div>
        </div>
        <footer>
            
        </footer>
    </body>

    <script src="js/sha256.min.js"></script>

    </html>