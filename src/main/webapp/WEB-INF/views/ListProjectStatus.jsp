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
			<th>ProjectStatusId</th>
			<th>ProjectStatus</th>
		</tr>
		<c:forEach items="${s}" var="projectstatus">
			<tr>
				<td>${projectstatus.projectStatusId}</td>
				<td>${projectstatus.projectStatus}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>