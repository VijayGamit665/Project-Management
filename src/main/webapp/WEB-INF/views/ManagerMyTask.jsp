<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | DataTables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../../plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../../dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->

		<%@include file="AdminHeader.jsp"%>
		<jsp:include page="ProjectManagerSideBar.jsp"></jsp:include>

		<!-- /.sidebar -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Task List</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">DataTables</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-12">
						<!-- /.card -->
						<div class="card">
							<div class="card-header">
								<ul class="nav nav-pills">
									<li class="nav-item"><a class="nav-link" href="#myTask"
										data-toggle="tab">My Task List</a></li>
									<li class="nav-item"><a class="nav-link"
										href="#myholdTask" data-toggle="tab">Hold Task List</a></li>
									<li class="nav-item"><a class="nav-link"
										href="#myrevokeTask" data-toggle="tab">Revoke Task List</a></li>
								</ul>

							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<div class="tab-content">
									<div class="tab-pane" id="myTask">
										<table id="example1"
											class="table table-bordered table-striped">
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
														<td><a class="btn btn-info btn-sm"
															href="viewtask?taskId=${task.taskId}">View</a>| <a
															class="btn btn-info btn-sm"
															href="edittask?taskId=${task.taskId}">Edit</a>| <a
															class="btn btn-info btn-sm"
															href="listTaskUser?taskId=${task.taskId}">Team</a></td>


													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th>Task Title</th>
													<th>Status</th>
													<th>EstimatedHours</th>
													<th>TotalUtilizedHours</th>
													<th>Description</th>
													<th>Action</th>

												</tr>
											</tfoot>
										</table>
									</div>

									<div class="tab-pane" id="myholdTask">
										<table id="example1"
											class="table table-bordered table-striped">
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
														<td><a class="btn btn-info btn-sm"
															href="viewtask?taskId=${task.taskId}">View</a>| <a
															class="btn btn-info btn-sm"
															href="edittask?taskId=${task.taskId}">Edit</a>| <a
															class="btn btn-info btn-sm"
															href="listTaskUser?taskId=${task.taskId}">Team</a></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th>Task Title</th>
													<th>Status</th>
													<th>EstimatedHours</th>
													<th>TotalUtilizedHours</th>
													<th>Description</th>
													<th>Action</th>

												</tr>
											</tfoot>
										</table>
									</div>
									<div class="tab-pane" id="myrevokeTask">
										<table id="example1"
											class="table table-bordered table-striped">
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
														<td><a class="btn btn-info btn-sm"
															href="viewtask?taskId=${task.taskId}">View</a>| <a
															class="btn btn-info btn-sm"
															href="edittask?taskId=${task.taskId}">Edit</a>| <a
															class="btn btn-info btn-sm"
															href="listTaskUser?taskId=${task.taskId}">Team</a></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th>Task Title</th>
													<th>Status</th>
													<th>EstimatedHours</th>
													<th>TotalUtilizedHours</th>
													<th>Description</th>
													<th>Action</th>
												</tr>
											</tfoot>
										</table>
									</div>

								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.0.4
			</div>
			<strong>Copyright &copy; 2014-2019 <a
				href="http://adminlte.io"></a>.
			</strong>
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables -->
	<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../../dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../../dist/js/demo.js"></script>
	<!-- page script -->
	<script>
		$(function() {
			$("#example1").DataTable({
				"responsive" : true,
				"autoWidth" : false,
			});
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
			});
		});
	</script>
</body>
</html>
