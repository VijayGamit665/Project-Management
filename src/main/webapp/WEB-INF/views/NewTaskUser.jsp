<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Task User</h2>
<form action="saveTaskUser" method="post">
UserID : <input type="text" name="userID"/><br><br>
TaskId : <input type="text" name="taskId"/><br><br>
AssignStatus : <input type="text" name="assignStatus"/><br><br>
StatusId : <input type="text" name="statusId"/><br><br>
UtitlizedHours : <input type="text" name="utitlizedHours"/><br><br>
<input Type="Submit" Value="Add Task User">


</form>

</body>
</html>