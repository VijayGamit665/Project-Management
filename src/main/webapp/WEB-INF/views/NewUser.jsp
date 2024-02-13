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

	<form action="saveUser" method="post">
		     FirstName : <input type="text" name="firstName" /><br>
		<br> LastName : <input type="text" name="lastName" /><br>
		<br> Email : <input type="email" name="email" /><br>
		<br> Password : <input type="password" name="password" /><br>
		<br> Gender : Male<input type="radio" Value="Male" name="Gender" />
		              Female<input type="radio" Value="Female" name="Gender" /><br>
		<br> ContactNum : <input type="text" name="contactNum" /><br>
		<br> DateOfBirth : <input type="date" name="dateOfBirth" /><br>
		<br> Address : <textarea rows="5" cols="25" name="address"></textarea><br>
		<br> City : <select name="city">
					<option value="-1">-----Please Select City-----</option>
					    <option value="Ahmedabad">Ahmedabad</option>
						<option value="Surat">Surat</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Ayodhya">Ayodhya</option>
						<option value="Mahesana">Mahesana</option>
		
		   			</select><br>
		<br> State : <select name="state">
					 <option value="-1">---Please Select State----</option>
					 <option value="Gujarat">Gujarat</option>
					 <option value="Maharashtra">Maharashtra</option>
					 <option value="Uttar Pradesh">Uttar Pradesh</option>
					 </select><br>
		<br> OTP : <input type="text" name="otp" /><br>
		<br> RoleId : 
					<select name="roleId">
					<option value="-1">-----Select Role-----</option>
					<c:forEach items="${roleList}" var="role">
					<option value="${role.roleId}">${role.roleName}</option>
					
					</c:forEach>
					
					</select>
		<br>
		<br> <br>
		<input type="submit" value="Save Role" />

	</form>

</body>
</html>