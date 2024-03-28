<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>PMS | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="../../plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="../../index3.html" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>

			<!-- SEARCH FORM -->
			<form class="form-inline ml-3">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search"
						placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

			<!-- Right navbar links -->

		</nav>
		<!-- /.navbar -->

		<jsp:include page="AdminSidebar.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Profile</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Profile</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">


							<!-- Profile Image -->
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle"
											src="../../dist/img/user4-128x128.jpg"
											alt="User profile picture">
									</div>

									<h3 class="profile-username text-center">${user.firstName}
										${user.lastName }</h3>


									<p class="text-muted text-center">
										<c:if test="${user.roleId==1}">
													Admin
											</c:if>

										<c:if test="${user.roleId==2}">
													Project Manager
											</c:if>
										<c:if test="${user.roleId==3}">
													Developer
											</c:if>
									</p>

								</div>
								<!-- /.card-body -->
							</div>

							<!-- /.card -->

							<!-- About Me Box -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">About Me</h3>
								</div>
								<!-- /.card-header -->

								<div class="card-body">
									<strong><i class="fas fa-map-marker-alt mr-1"></i>Address</strong>
									<p class="text-muted">${user.address}</p>

									<strong><i class="fas fa-gender"></i>Gender</strong>
									<p class="text-muted">${user.gender}</p>

									<strong><i class="fas fa-gender"></i>Email</strong>
									<p class="text-muted">${user.email}</p>

									<strong><i class="fas fa-gender"></i>Contect Number</strong>
									<p class="text-muted">${user.contactNum}</p>

									<strong><i class="fas fa-gender"></i>Date of Birth</strong>
									<p class="text-muted">${user.dateOfBirth}</p>

								</div>

								<!-- /.card-body -->
							</div>
							<!-- /.card -->

						</div>
						<!-- /.col -->
						<div class="col-md-9">
							<div class="card">
								<div class="card-header p-2">
									<ul class="nav nav-pills">
										<li class="nav-item"><a class="nav-link active"
											href="#activity" data-toggle="tab">Activity</a></li>
										<li class="nav-item"><a class="nav-link" href="#timeline"
											data-toggle="tab">Timeline</a></li>
										<li class="nav-item"><a class="nav-link" href="#settings"
											data-toggle="tab">Edit Project</a></li>
									</ul>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div class="tab-content">
										<div class="active tab-pane" id="activity">
											<div class="post"></div>
										</div>
										<div class="tab-pane" id="timeline">
											<div class="timeline timeline-inverse"></div>
										</div>
										<div class="tab-pane" id="settings">
											<form class="form-horizontal">
												<div class="form-group row">
													<label for="inputName" class="col-sm-2 col-form-label">Name</label>
													<div class="col-sm-10">
														<input type="email" class="form-control" id="inputName"
															placeholder="Name">
													</div>
												</div>
												<div class="form-group row">
													<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
													<div class="col-sm-10">
														<input type="email" class="form-control" id="inputEmail"
															placeholder="Email">
													</div>
												</div>
												<div class="form-group row">
													<label for="inputName2" class="col-sm-2 col-form-label">Name</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="inputName2"
															placeholder="Name">
													</div>
												</div>
												<div class="form-group row">
													<label for="inputExperience"
														class="col-sm-2 col-form-label">Experience</label>
													<div class="col-sm-10">
														<textarea class="form-control" id="inputExperience"
															placeholder="Experience"></textarea>
													</div>
												</div>
												<div class="form-group row">
													<label for="inputSkills" class="col-sm-2 col-form-label">Skills</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="inputSkills"
															placeholder="Skills">
													</div>
												</div>
												<div class="form-group row">
													<div class="offset-sm-2 col-sm-10">
														<div class="checkbox">
															<label> <input type="checkbox"> I agree
																to the <a href="#">terms and conditions</a>
															</label>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<div class="offset-sm-2 col-sm-10">
														<button type="submit" class="btn btn-danger">Submit</button>
													</div>
												</div>
											</form>
										</div>
										<!-- /.tab-pane -->
									</div>
									<!-- /.tab-content -->
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.nav-tabs-custom -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
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
			</strong> All rights reserved.
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
	<!-- AdminLTE App -->
	<script src="../../dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../../dist/js/demo.js"></script>
</body>
</html>
