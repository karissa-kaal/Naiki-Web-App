<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage Donor</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/DonorServlet" method="post">
<div align = "center">
<h1>Welcome to Naiki Donor Home Page</h1>
<input type="submit" value="Request Ride" name= "RequestRide" />
<br> <br> <br>
<input type="submit" value="Donate Money" name= "DonateMoney" />
<br> <br> <br>
<input type="submit" value="View Profile" name= "ViewProfile" />
<br> <br> <br>
<input type="submit" value="Edit Profile" name= "Edit" />
<br> <br> <br>
<input type="submit" value="Logout" name= "Logout"  />
</div>
</form>
</body>
