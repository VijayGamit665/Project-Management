<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Project Status</h2>

<form action="saveStatus" method = "post">
ProjectStatus :<select name="projectStatus">
                  <option value="-1">-----Please Select Status-----</option>
					    <option value="lead">lead</option>
						<option value="notStarted">notStarted</option>
						<option value="hold">hold</option>
						<option value="inProgress">inProgress</option>
						<option value="completed">completed</option>
			 </select><br><br>
 <br><input type="submit" value="saveProjectStatus" />

</form>

</body>
</html>