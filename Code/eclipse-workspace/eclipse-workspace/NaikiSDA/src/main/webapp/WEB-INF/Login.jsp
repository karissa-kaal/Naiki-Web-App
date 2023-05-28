<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div align = "center">
<h1>Choose your user type to Login</h1>
<a href="<%=request.getContextPath()%>/DonorLogin.jsp" class="btn btn-success">Donor Login</a>
<br> 
<a href="<%=request.getContextPath()%>/AdminLogin.jsp" class="btn btn-success">Admin Login</a>
<br> 
<a href="<%=request.getContextPath()%>/RiderLogin.jsp" class="btn btn-success">Rider Login</a>
<br> <br>
<a href="<%=request.getContextPath()%>/SignUp.jsp" class="btn btn-success">Don't have an account? Sign up instead</a>
</div>
</body>
