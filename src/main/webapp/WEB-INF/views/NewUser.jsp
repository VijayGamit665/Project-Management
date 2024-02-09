<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="saveUser" method="post">
FirstName : <input type="text" name="firstName" /><br><br>
LastName : <input type="text" name="lastName"/><br><br>
Email : <input type="email" name="email"/><br><br>
Password : <input type="password" name="password"/><br><br>
Gender : <input type="text" name="gender"/><br><br>
ContactNum : <input type="text" name="contactNum"/><br><br>
DateOfBirth : <input type="date" name="dateOfBirth"/><br><br>
Address : <input type="text" name="address"/><br><br>
City : <input type="text" name="city"/><br><br>
State : <input type="text" name="state"/><br><br>
OTP : <input type="text" name="otp"/><br><br>
RoleId : <input type="text" name="roleId"/><br><br>

		 <br><input type="submit" value="Save Role" />

</form>

</body>
</html>