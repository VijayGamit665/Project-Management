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
			<th>ProjectId</th>
			<th>Title</th>
			<th>Description</th>
			<th>ProjectStatusId</th>
			<th>DocURL</th>
			<th>EstimatedHours</th>
			<th>TotalUtilizedHours</th>
			<th>ProjectStartDate</th>
			<th>ProjectCompletionDate</th>
			<th>ActualCompletionDate</th>
			<th>Action</th>
			
		</tr>
		<c:forEach items="${p}" var="project">
			<tr>
				<td>${project.projectId}</td>
				<td>${project.title}</td>
				<td>${project.description}</td>
				<td>${project.projectStatusId}</td>
				<td>${project.docURL}</td>
				<td>${project.estimatedHours}</td>
				<td>${project.totalUtilizedHours}</td>
				<td>${project.projectStartDate}</td>
				<td>${project.projectCompletionDate}</td>
				<td>${project.actualCompletionDate}</td>
				<td><a href="deleteproject?projectId=${project.projectId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>