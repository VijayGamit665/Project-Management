<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Module</h2>
<form action="saveModule" method="post">

ModuleId : <input type="text" name="moduleId"/><br><br>
ModuleName : <input type="text" name="moduleName"/><br><br>
ProjectId : <input type="text" name="projectId"/><br><br>
Status : <input type="text" name="status"/><br><br>
Description : <input type="text" name="description"/><br><br>
DocURL : <input type="text" name="docURL"/><br><br>
EstimatedHours :<input type="text" name="estimatedHours"/><br><br>
TotalUtilizedHours : <input type="text" name="totalUtilizedHours"/><br><br>

<input type="submit" value="Add Module">

</form>

</body>
</html>