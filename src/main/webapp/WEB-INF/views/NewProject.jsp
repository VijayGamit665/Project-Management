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

<form action="saveProject" method="post">
ProjectId             :<input type="text" name="projectId"/><br><br>
Title                 : <input type="text" name="title"/><br><br>
Description           : <input type="text" name="description"/><br><br>
ProjectStatusId       :<select name="projectStatusId">
						<option value="-1">------Select Project StatusID-------</option>
						<c:forEach items="${projectstatus}" var="status">
						<option value="${status.projectStatusId }">${status.projectStatusId}</option>	
						</c:forEach>
					  </select><br><br>
DocURL                : <input type="url" name="docURL"/><br><br>
EstimatedHours        : <input type="text" name="estimatedHours"/><br><br>
TotalUtilizedHours    : <input type="text" name="totalUtilizedHours"/><br><br>
ProjectStartDate      : <input type="date" name="projectStartDate"/><br><br>
ProjectCompletionDate : <input type ="date" name="projectCompletionDate"/><br><br>
actualCompletionDate  : <input type="text" name="actualCompletionDate"/><br><br>
                       <input type="submit" value="Add Project"/>
</form>

</body>
</html>