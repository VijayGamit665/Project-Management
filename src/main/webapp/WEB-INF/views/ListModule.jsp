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
			<th>ModuleId</th>
			<th>ModuleName</th>
			<th>projectId</th>
			<th>status</th>
			<th>Description</th>
			<th>DocURL</th>
			<th>EstimatedHours</th>
			<th>TotalUtilizedHours</th>
		</tr>
		<c:forEach items="${m}" var="module">
			<tr>
				<td>${module.moduleId}</td>
				<td>${module.moduleName}</td>
				<td>${module.projectId}</td>
				<td>${module.status}</td>
				<td>${module.description}</td>
				<td>${module.docURL}</td>
				<td>${module.estimatedHours}</td>
				<td>${module.totalUtilizedHours}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>