<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Task</h2>
<form action="saveTask" method="post">

ModuleId : <input type="text" name="moduleId"/><br><br>
ProjectId : <input type="text" name="projectId"/><br><br>
Status : <input type="text" name="status"/><br><br>
EstimatedHours : <input type="text" name="estimatedHours"/><br><br>
TotalUtilizedHours : <input type="text" name="totalUtilizedHours"/><br><br>
DocURL : <input type="url" name="docURL"/><br><br>
Description : <input type="text" name="description"/><br><br>
Title : <input type="text" name="title"/><br><br>

<input type="Submit" Value="Add Task"/>

</form>
</body>
</html>