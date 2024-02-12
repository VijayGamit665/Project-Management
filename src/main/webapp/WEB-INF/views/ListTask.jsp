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
			<th>TaskId</th>
			<th>ModuleId</th>
			<th>ProjectId</th>
			<th>Status</th>
			<th>EstimatedHours</th>
			<th>TotalUtilizedHours</th>
			<th>DocURL</th>
			<th>Description</th>
			<th>Title</th>
		</tr>
		<c:forEach items="${t}" var="task">
			<tr>
				<td>${task.taskId}</td>
				<td>${task.moduleId}</td>
				<td>${task.projectId}</td>
				<td>${task.status}</td>
				<td>${task.estimatedHours}</td>
				<td>${task.totalUtilizedHours}</td>
				<td>${task.docURL}</td>
				<td>${task.description}</td>
				<td>${task.title}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>