<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Edit Task</title>
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
		<jsp:include page="ProjectManagerSideBar.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Dashboard</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active"><a
									href="projectManagerDashBoard">Dashboard</a></li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /.content-header -->

			<!-- Main content -->

			<form action="saveTask?moduleId=${task.moduleId}" method="post"">
				<section class="content">
					<div class="row">
						<div class="col-12 col-sm-12">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Edit Task Details</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse" data-toggle="tooltip"
											title="Collapse">
											<i class="fas fa-minus"></i>
										</button>
									</div>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputProjectLeader">Title</label> <input
													type="text" id="inputProjectLeader" class="form-control"
													name="title" value="${task.title}">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputClientCompany">EstimatedHours</label> <input
													type="text" id="inputClientCompany" class="form-control"
													name="estimatedHours" value="${task.estimatedHours}">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputProjectLeader">TotalUtilizedHours</label> <input
													type="text" id="inputProjectLeader" class="form-control"
													name="totalUtilizedHours" value="${task.totalUtilizedHours}">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputProjectLeader">DocURL</label> <input
													type="url" id="inputProjectLeader" class="form-control"
													name="docURL" value="${task.docURL}">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputProjectLeader">Description</label> <input
													type="text" id="inputProjectLeader" class="form-control"
													name="description" value="${task.description}">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="inputStatus">Status</label> <select
													name="statusId" class="form-control">
													<option value="-1">------Select Status-------</option>
													<c:forEach items="${projectStatuslist}" var="taskstatus">
														<option value="${taskstatus.projectStatusId}" ${taskstatus.projectStatusId == task.statusId?"selected":""} >${taskstatus.projectStatus}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<input type="hidden" name="taskId" value="${param.taskId}" />
									<div class="row">
										<div class="col-12">
											<input type="submit" value="Add New Task"
												class="btn btn-success float-left"> <a
												href="listTask?moduleId=${task.moduleId}" class="btn btn-secondary float-right">Cancel</a>
										</div>
									</div>

								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
					</div>
				</section>
			</form>
			<!-- /Main content -->
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