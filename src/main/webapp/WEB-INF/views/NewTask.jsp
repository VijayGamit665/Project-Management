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
<h2>New Task</h2>
<form action="saveTask" method="post">

ModuleId : <select name="moduleId">
						<option value="-1">------Select ModuleID-------</option>
						<c:forEach items="${modulelist}" var="modules">
						<option value="${modules.moduleId}">${modules.moduleId}</option>	
						</c:forEach>
					  </select><br><br>
ProjectId : <select name="projectId">
						<option value="-1">------Select ProjectId-------</option>
						<c:forEach items="${projectlist}" var="project">
						<option value="${project.projectId}">${project.projectId}</option>	
						</c:forEach>
					  </select><br><br>
Status : <select name="status">
						<option value="-1">------Select Status-------</option>
						<c:forEach items="${statuss}" var="status">
						<option value="${status.projectStatus}">${status.projectStatus}</option>	
						</c:forEach>
					  </select><br><br>
EstimatedHours : <input type="text" name="estimatedHours"/><br><br>
TotalUtilizedHours : <input type="text" name="totalUtilizedHours"/><br><br>
DocURL : <input type="url" name="docURL"/><br><br>
Description : <input type="text" name="description"/><br><br>
Title : <input type="text" name="title"/><br><br>

<input type="Submit" Value="Add Task"/>

</form>
</body>
</html>