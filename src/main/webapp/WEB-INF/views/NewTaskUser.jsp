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
<h2>New Task User</h2>
<form action="saveTaskUser" method="post">
UserID : <select name="userId">
						<option value="-1">------Select UserID-------</option>
						<c:forEach items="${Users}" var="user">
						<option value="${user.userId}">${user.userId}</option>	
						</c:forEach>
					  </select><br><br>
					  
TaskId : <select name="userId">
						<option value="-1">------Select TaskId-------</option>
						<c:forEach items="${tasklist}" var="task">
						<option value="${task.taskId}">${task.taskId}</option>	
						</c:forEach>
					  </select><br><br>

AssignStatus : <input type="text" name="assignStatus"/><br><br>
StatusId : <select name="userId">
						<option value="-1">------Select StatusId-------</option>
						<c:forEach items="${statuslist}" var="status">
						<option value="${status.projectStatusId}">${status.projectStatusId}</option>	
						</c:forEach>
					  </select><br><br>


UtitlizedHours : <input type="text" name="utitlizedHours"/><br><br>
<input Type="Submit" Value="Add Task User">


</form>

</body>
</html>