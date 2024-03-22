<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Task List</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet" href="plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">


		<%@include file="AdminHeader.jsp"%>
		<jsp:include page="DeveloperSideBar.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">${p.title}: ${m.moduleName}</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active"><a href="myModule?projectId=${p.projectId}">Back TO Module</a></li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- -Tables--- -->
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header p-2">
							<ul class="nav nav-pills">
								<li class="nav-item"><a class="nav-link" href="#myTask"
									data-toggle="tab">My Task List</a></li>
								<li class="nav-item"><a class="nav-link" href="#myholdTask"
									data-toggle="tab">Hold Task List</a></li>
								<li class="nav-item"><a class="nav-link"
									href="#myrevokeTask" data-toggle="tab">Revoke Task</a></li>
							</ul>
						</div>
						<!-- /.card-header -->
						<div class="card-body table-responsive p-0">
							<div class="tab-content">
								<div class="tab-pane" id="myTask">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>Task Title</th>
												<th>Status</th>
												<th>EstimatedHours</th>
												<th>TotalUtilizedHours</th>
												<th>Description</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${task}" var="task">
												<tr>
													<td>${task.title}</td>
													<td><c:if test="${task.statusId==1}">
													notStarted
											</c:if> <c:if test="${task.statusId==2}">
													inProgress
											</c:if> <c:if test="${task.statusId==3}">
													lead
											</c:if> <c:if test="${task.statusId==4}">
													Hold
											</c:if> <c:if test="${task.statusId==5}">
													Completed
											</c:if></td>
													<td>${task.estimatedHours}</td>
													<td>${task.totalUtilizedHours}</td>
													<td>${task.description}</td>
													<td>
													<a class="btn btn-info btn-sm" href="mytaskuser?taskId=${task.taskId}">Team</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="tab-pane" id="myholdTask">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>Task Title</th>
												<th>Status</th>
												<th>EstimatedHours</th>
												<th>TotalUtilizedHours</th>
												<th>Description</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${holdtask}" var="task">
												<tr>
													<td>${task.title}</td>
													<td><c:if test="${task.statusId==1}">
													notStarted
											</c:if> <c:if test="${task.statusId==2}">
													inProgress
											</c:if> <c:if test="${task.statusId==3}">
													lead
											</c:if> <c:if test="${task.statusId==4}">
													Hold
											</c:if> <c:if test="${task.statusId==5}">
													Completed
											</c:if></td>
													<td>${task.estimatedHours}</td>
													<td>${task.totalUtilizedHours}</td>
													<td>${task.description}</td>
													<td>
													<a class="btn btn-info btn-sm" href="mytaskuser?taskId=${task.taskId}">Team</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
								<div class="tab-pane" id="myrevokeTask">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>Task Title</th>
												<th>Status</th>
												<th>EstimatedHours</th>
												<th>TotalUtilizedHours</th>
												<th>Description</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${revoketask}" var="task">
												<tr>
													<td>${task.title}</td>
													<td><c:if test="${task.statusId==1}">
													notStarted
											</c:if> <c:if test="${task.statusId==2}">
													inProgress
											</c:if> <c:if test="${task.statusId==3}">
													lead
											</c:if> <c:if test="${task.statusId==4}">
													Hold
											</c:if> <c:if test="${task.statusId==5}">
													Completed
											</c:if></td>
													<td>${task.estimatedHours}</td>
													<td>${task.totalUtilizedHours}</td>
													<td>${task.description}</td>
													<td>
													<a class="btn btn-info btn-sm" href="mytaskuser">Team</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
			<!-- -/Tables--- -->




			<!-- Main content -->
			<section class="content">
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<jsp:include page="AdminFooter.jsp"></jsp:include>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="plugins/moment/moment.min.js"></script>
	<script src="plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="dist/js/demo.js"></script>
</body>
</html>
