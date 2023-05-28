<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage Rider</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/RiderServlet" method="post">
<div align = "center">
<h1>Welcome to Naiki Rider Home Page</h1>
<input type="submit" value="Review Request" name= "ReviewRequest" />
<br> <br> <br>
<input type="submit" value="View Profile" name= "ViewProfile" />
<br> <br> <br>
<input type="submit" value="End Ride" name= "EndRide" />
<br> <br> <br>
<input type="submit" value="Edit Profile" name= "Edit" />
<br> <br> <br>
<input type="submit" value="Logout" name= "Logout" />
<br> <br> <br>
</div>
</form>
</body>