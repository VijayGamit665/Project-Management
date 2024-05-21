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
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>
<body class="hold-transition sidebar-mini">
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
								<li class="breadcrumb-item active">Dashboard</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>

				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Content Header (Page header) -->

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-info">
								<div class="inner">
									<h3>${getUserProject}</h3>

									<p>Total Projects</p>
								</div>
								<div class="icon">
									<i class="ion ion-bag"></i>
								</div>
								<a href="managermyproject" class="small-box-footer">More
									info <i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-success">
								<div class="inner">
									<h3>${getongoinUserproject}</h3>

									<p>OnGoing</p>
								</div>
								<div class="icon">
									<i class="ion ion-stats-bars"></i>
								</div>
								<a href="managerongoingproject" class="small-box-footer">More
									info <i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-warning">
								<div class="inner">
									<h3>${getuserpipelineproject}</h3>

									<p>Pipeline</p>
								</div>
								<div class="icon">
									<i class="ion ion-person-add"></i>
								</div>
								<a href="managerpipelineproject" class="small-box-footer">More
									info <i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-danger">
								<div class="inner">
									<h3>${userdueproject}</h3>

									<p>Due</p>
								</div>
								<div class="icon">
									<i class="ion ion-pie-graph"></i>
								</div>
								<a href="managerdueproject" class="small-box-footer">More
									info <i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
					</div>
				</div>
			</section>

			<!-- /.content -->

			<!-- BAR CHART -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="card card-success">
								<div class="card-header">
									<h3 class="card-title">Project</h3>

									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>
										<button type="button" class="btn btn-tool"
											data-card-widget="remove">
											<i class="fas fa-times"></i>
										</button>
									</div>
								</div>
								<div class="card-body">

									<div>
										<canvas id="myChart"
											style="min-height: 250px; height: 250px; max-height: 500px; max-width: 100%;"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card card-success">
								<div class="card-header">
									<h3 class="card-title">Module</h3>

									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>
										<button type="button" class="btn btn-tool"
											data-card-widget="remove">
											<i class="fas fa-times"></i>
										</button>
									</div>
								</div>
								<div class="card-body">

									<div>
										<canvas id="mChart"
											style="min-height: 250px; height: 250px; max-height: 500px; max-width: 100%;"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="card card-success">
								<div class="card-header">
									<h3 class="card-title">Task</h3>

									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>
										<button type="button" class="btn btn-tool"
											data-card-widget="remove">
											<i class="fas fa-times"></i>
										</button>
									</div>
								</div>
								<div class="card-body">

									<div>
										<canvas id="tChart"
											style="min-height: 250px; height: 250px; max-height: 500px; max-width: 100%;"></canvas>
									</div>
								</div>
							</div>
						</div>



					</div>



				</div>
			</section>


			<!-- /BAR CHART -->




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
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			// Sample data (replace with your dynamic data)
			const projectName = [ ${projectName} ];
			const estimatedHr = [${estimatedHr}];
			const totalUtilizedHours = [${totalUtilizedHours}];
			const moduleName = [${moduleName}];
			const mestimatedHr = [${mestimatedHr}];
			const mtotalUtilizedHours = [${MtotalUtilizedHours}];
			const taskName = [ ${taskName} ];
			const testimatedHr = [${testimatedHr} ];
			const ttotalUtilizedHours = [${ttotalUtilizedHours}];

			// Project Chart
			const ctx = document.getElementById('myChart').getContext('2d');
			new Chart(ctx, {
				type : 'bar',
				data : {
				      labels: [${projectName}],
				      datasets: [{
				        label: '# Estimated Hours',
				        data: [${estimatedHr}],
				        backgroundColor     : 'rgba(60,141,188,0.9)',
				        borderColor         : 'rgba(60,141,188,0.8)',
				        pointRadius          : false,
				        pointColor          : '#3b8bba',
				        pointStrokeColor    : 'rgba(60,141,188,1)',
				        pointHighlightFill  : '#fff',
				        pointHighlightStroke: 'rgba(60,141,188,1)',
				        borderWidth: 1
				      },
				      {
				    	  label : '# Total Utilized Hours',
							data : [${totalUtilizedHours}],
							backgroundColor     : 'rgba(210, 214, 222, 1)',
					          borderColor         : 'rgba(210, 214, 222, 1)',
					          pointRadius         : false,
					          pointColor          : 'rgba(210, 214, 222, 1)',
					          pointStrokeColor    : '#c1c7d1',
					          pointHighlightFill  : '#fff',
					          pointHighlightStroke: 'rgba(220,220,220,1)',
							borderWidth : 1
				      }]
				    },
				options : {
					scales : {
						y : {
							beginAtZero : true	
						}
					}
				}
			});

			// Module Chart
			const ctxM = document.getElementById('mChart').getContext('2d');
			new Chart(ctxM, {
				type : 'bar',
				data : {
				      labels: [${moduleName}],
				      datasets: [{
				        label: '# Estimated Hours',
				        data: [${mestimatedHr}],
				        backgroundColor     : 'rgba(60,141,188,0.9)',
				        borderColor         : 'rgba(60,141,188,0.8)',
				        pointRadius          : false,
				        pointColor          : '#3b8bba',
				        pointStrokeColor    : 'rgba(60,141,188,1)',
				        pointHighlightFill  : '#fff',
				        pointHighlightStroke: 'rgba(60,141,188,1)',
				        borderWidth: 1
				      },
				      {
				    	  label : '# Total Utilized Hours',
							data : [${mtotalUtilizedHours}],
							backgroundColor     : 'rgba(210, 214, 222, 1)',
					          borderColor         : 'rgba(210, 214, 222, 1)',
					          pointRadius         : false,
					          pointColor          : 'rgba(210, 214, 222, 1)',
					          pointStrokeColor    : '#c1c7d1',
					          pointHighlightFill  : '#fff',
					          pointHighlightStroke: 'rgba(220,220,220,1)',
							borderWidth : 1
				      }]
				    },
				options : {
					scales : {
						y : {
							beginAtZero : true
						}
					}
				}
			});

			// Task Chart
			const ctxT = document.getElementById('tChart').getContext('2d');
			new Chart(ctxT, {
				type : 'bar',
				data : {
				      labels: [${taskName}],
				      datasets: [{
				        label: '# Estimated Hours',
				        data: [${testimatedHr}],
				        backgroundColor     : 'rgba(60,141,188,0.9)',
				        borderColor         : 'rgba(60,141,188,0.8)',
				        pointRadius          : false,
				        pointColor          : '#3b8bba',
				        pointStrokeColor    : 'rgba(60,141,188,1)',
				        pointHighlightFill  : '#fff',
				        pointHighlightStroke: 'rgba(60,141,188,1)',
				        borderWidth: 1
				      },
				      {
				    	  label : '# Total Utilized Hours',
							data : [${ttotalUtilizedHours}],
							backgroundColor     : 'rgba(210, 214, 222, 1)',
					          borderColor         : 'rgba(210, 214, 222, 1)',
					          pointRadius         : false,
					          pointColor          : 'rgba(210, 214, 222, 1)',
					          pointStrokeColor    : '#c1c7d1',
					          pointHighlightFill  : '#fff',
					          pointHighlightStroke: 'rgba(220,220,220,1)',
							borderWidth : 1
				      }]
				    },
				options : {
					scales : {
						y : {
							beginAtZero : true
						}
					}
				}
			});
		});
	</script>
</body>
</html>
