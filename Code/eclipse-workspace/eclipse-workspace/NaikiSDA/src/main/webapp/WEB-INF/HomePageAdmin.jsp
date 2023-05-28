<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page Admin</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/AdminServlet" method="post">
<div align = "center">
<h1>Welcome to Naiki Admin Home Page</h1>
<input type="submit" value="View Reports" name= "ViewReports" />
<br> <br> <br>
<input type="submit" value="Add Admin" name= "AddAdmin"  />
<br> <br> <br>
<input type="submit" value="Add Rider" name= "AddRider"  />
<br> <br> <br>
<input type="submit" value="View List of Riders" name= "ListofRiders" />
<br> <br> <br>
<input type="submit" value="View List of Donors" name= "ListofDonors"/>
<br> <br> <br>
<input type="submit" value="Logout" name= "Logout" />
<br> <br> <br>
</div>
</form>
</body>
