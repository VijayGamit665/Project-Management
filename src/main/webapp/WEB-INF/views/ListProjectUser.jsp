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
<table border="1" align="center">
		<tr>
			<th>ProjectUserId</th>
			<th>UserId</th>
			<th>ProjectId</th>
			<th>AssignStatus</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${pu}" var="projectuser">
			<tr>
				<td>${projectuser.projectUserId}</td>
				<td>${projectuser.userId}</td>
				<td>${projectuser.projectId}</td>
				<td>${projectuser.assignStatus}</td>
				<td><a href="deleteprojectuser?projectUserId=${projectuser.projectUserId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>