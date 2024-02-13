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
<h2>New Module</h2>
<form action="saveModule" method="post">

ModuleId : <input type="text" name="moduleId"/><br><br>
ModuleName : <input type="text" name="moduleName"/><br><br>
ProjectId : <select name="projectId">
				<option value="-1">-----Please Select ProjectId------</option>
				<c:forEach items="${projectslist}" var="project">
				<option value="${project.projectId}">${project.projectId}</option>
				</c:forEach>
           </select>
<br><br>
Status : <select name="status">
				<option value="-1">-----Please Select Status------</option>
				<c:forEach items="${projectStatsulist}" var="statuslist">
				<option value="${statuslist.projectStatus}">${statuslist.projectStatus}</option>
				</c:forEach>
           </select>
<br><br>
Description : <input type="text" name="description"/><br><br>
DocURL : <input type="url" name="docURL"/><br><br>
EstimatedHours :<input type="text" name="estimatedHours"/><br><br>
TotalUtilizedHours : <input type="text" name="totalUtilizedHours"/><br><br>

<input type="submit" value="Add Module">

</form>

</body>
</html>