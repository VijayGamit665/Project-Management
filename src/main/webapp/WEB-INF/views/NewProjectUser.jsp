<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Project User</h2>
<form action="saveProjectUser" method="post">
UserId : <select name="userId">
						<option value="-1">------Select UserID-------</option>
						<c:forEach items="${users}" var="user">
						<option value="${user.userId}">${user.userId}</option>	
						</c:forEach>
					  </select><br><br>
ProjectId : <select name="projectId">
						<option value="-1">------Select Project ID-------</option>
						<c:forEach items="${projectlist}" var="project">
						<option value="${project.projectId}">${project.projectId}</option>	
						</c:forEach>
					  </select><br><br>


AssignStatus : <input type="text" name="assignStatus"/><br><br>

<input type="submit" Value="Add Project User">


</form>
</body>
</html>