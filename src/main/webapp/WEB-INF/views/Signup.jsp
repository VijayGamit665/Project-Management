<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Project Management</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="../../plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="../../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../../dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="../../index2.html"><b>Project Management</b></a>
		</div>

		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">Register a new membership</p>

				<form action="signup" method="post">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="First Name"
							name="firstName">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Last Name"
							name="lastName">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						Gender : Male &nbsp; <input type="radio" Value="Male"
							name="Gender" /> &nbsp; &nbsp; Female &nbsp; <input type="radio"
							Value="Female" name="Gender" />
						<div class="input-group-append"></div>
					</div>

					<div class="input-group mb-3">
						<input type="email" class="form-control" placeholder="Email"
							name="email">
						<div class="input-group-append">
							<div class="input-group-text">
							<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="Password"
							name="password">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control"
							placeholder="Retype Password" name="retpypepassword">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							placeholder="Contect Number" name="contactNum">
						<div class="input-group-append">
							<div class="input-group-text">
							
							<span class="fas fa-lg fa-phone"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="date" class="form-control"
							placeholder="Date of Birth" name="dateOfBirth">
						<div class="input-group-append">
							<div class="input-group-text">
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<textarea rows="3" cols="37" class="form-control"
							placeholder="Address" name="address"></textarea>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-map-marker"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<select name="state" class="form-control">
							<option value="-1">------Please Select State------</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Uttar Pradesh">Uttar Pradesh</option>
						</select>
						<div class="input-group-append">
							<div class="input-group-text"></div>
						</div>
					</div>
					<div class="input-group mb-3">
						<select name="city" class="form-control">
							<option value="-1">------Please Select City-------</option>
							<option value="Ahmedabad">Ahmedabad</option>
							<option value="Surat">Surat</option>
							<option value="Mumbai">Mumbai</option>
							<option value="Ayodhya">Ayodhya</option>
							<option value="Mahesana">Mahesana</option>
						</select>
						<div class="input-group-append">
							<div class="input-group-text"></div>
						</div>
					</div>
					<div class="row">

						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">Register</button>
						</div>
						<div class="col-4">
							<a href="signup">
								<button type="button" class="btn btn-primary btn-danger">Cencal</button>
							</a>
						</div>

						<!-- /.col -->
					</div>
				</form>

				<a href="login" class="text-center">I already have a membership</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery -->
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../../dist/js/adminlte.min.js"></script>
</body>
</html>
