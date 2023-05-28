<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Rider.dao.RiderDao" %>
    <%@ page import="Rider.bean.RiderBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<div align = "center">
<h1>My Profile</h1>
<%
RiderDao rdao = new RiderDao();
RiderBean rider = rdao.selectRider(); %>
 <% String username = rider.getUsername(); %>
    <div class="marginTable" ><%=username%></div>
 <% String fname = rider.getFName(); %>
    <div class="marginTable" ><%=fname%></div>
 <% String lname = rider.getLName(); %>
    <div class="marginTable" ><%=lname%></div>
 <% String pno = rider.getphone(); %>
    <div class="marginTable" ><%=pno%></div>
<br><br>
<a href="<%=request.getContextPath()%>/HomePageDonor.jsp" class="btn btn-success">Back to Home Page</a>
</div>
</body>
