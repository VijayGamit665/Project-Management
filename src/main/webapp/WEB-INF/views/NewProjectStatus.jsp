<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = 	"saveProjectStatus" method="Post">
Project Status : <input type= "text" name="project"/><br><br>
Title : <input type="text" name="title"/><br><br>
Description : <input type="text" name="description"/><br><br>
DocURL : <input type="url" name="docURL"/><br><br>
EstimatedHours : <input type="time" name="estimatedHours"/><br><br>
TotalUtilizedHours : <input type="time" name="totalUtilizedHours"/><br><br>
ProjectStartDate : <input type="date" name="projectStartDate"/><br><br>
ProjectCompletionDate : <input type ="date" name="projectCompletionDate"/><br><br>
<input type="submit" value="Add Status"/>
</form>

</body>
</html>