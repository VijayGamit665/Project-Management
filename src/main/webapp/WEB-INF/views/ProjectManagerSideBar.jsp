<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">Project Management</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<a href="profile" class="d-block">${user.firstName} ${user.lastName} </a>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

				<li class="nav-item"><a href="projectManagerDashBoard"
					class="nav-link"> <i class="nav-icon fas fa-th"></i>
						<p>
							Dashboard <span class="right badge badge-danger">New</span>
						</p>
				</a></li>
				<li class="nav-header">EXAMPLES</li>
				<li class="nav-item"><a href="newProject" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>Create Project <span class="badge badge-info right"></span>
						</p>
				</a></li>
				<li class="nav-item"><a href="newTask" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>New Task <span class="badge badge-info right"></span>
						</p>
				</a></li>
				<li class="nav-item"><a href="newModule" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>New Module <span class="badge badge-info right"></span>
						</p>
				</a></li>
				<li class="nav-item"><a href="newProjectStatus" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>New Project Status <span class="badge badge-info right"></span>
						</p>
				</a></li>
				<li class="nav-item"><a href="newProjectUser" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>New Project User <span class="badge badge-info right"></span>
						</p>
				</a></li>
				<li class="nav-item"><a href="newTaskUser" class="nav-link"> <i
						class="nav-icon far fa-calendar-alt"></i>
						<p>New Task User <span class="badge badge-info right"></span>
						</p>
				</a></li>
				
						
				<li class="nav-item"><a href="logout" class="nav-link"> <i
						class="nav-icon fas fa-power-off"></i>
						<p>Logout <span class="badge badge-info right"></span>
						</p>
				</a></li>		
								
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
