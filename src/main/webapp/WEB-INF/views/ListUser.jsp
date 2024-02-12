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
			<th>UserID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Gender</th>
			<th>ContactNum</th>
			<th>DateOfBirth</th>
			<th>Address</th>
			<td>City</td>
			<th>State</th>
			<td>OTP</td>
			<td>RoleID</td>
			
		</tr>
		<c:forEach items="${u}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.gender}</td>
				<td>${user.contactNum}</td>
				<td>${user.dateOfBirth}</td>
				<td>${user.address}</td>
				<td>${user.city}</td>
				<td>${user.state}</td>
				<td>${user.otp}</td>
				<td>${user.roleId}</td>	
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>