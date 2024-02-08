<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Signup</h2>
 
      <form action="saveuser" method="post">
      First Name : <input type="text" name="firstName" placeholder="Enter FirstName"/><br><br>
      Last Name  : <input type="text" name="lastName" placeholder="Enter LastName"/><br><br>
      Email      : <input type="text" name="email" placeholder="Enter Email" /><br><br>
      Password   : <input type="password" name="password" placeholder="Enter Password"/><br><br>
      
      <input type="submit" value-"signup" /><br><br>
      </form>
      
      <a href="login">Login</a>
 
</body>
</html>