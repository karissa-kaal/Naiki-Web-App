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
<h1>Ride requested! Status: Pending</h1>

<a href="<%=request.getContextPath()%>/HomePageDonor.jsp" class="btn btn-success">Back to Home Page</a>
</div>
</form>
</body>
