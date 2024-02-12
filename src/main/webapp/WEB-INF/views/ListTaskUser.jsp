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
			<th>TaskUserId</th>
			<th>UserID</th>
			<th>TaskId</th>
			<th>AssignStatus</th>
			<th>StatusId</th>
			<th>UtitlizedHours</th>
		</tr>
		<c:forEach items="${tu}" var="taskuser">
			<tr>
				<td>${taskuser.taskUserId}</td>
				<td>${taskuser.userID}</td>
				<td>${taskuser.taskId}</td>
				<td>${taskuser.assignStatus}</td>
				<td>${taskuser.statusId}</td>
				<td>${taskuser.utitlizedHours}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>