<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Donor.dao.DonorDao" %>
    <%@ page import="Donor.bean.DonorBean" %>
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
DonorDao rdao = new DonorDao();
DonorBean Donor = rdao.selectDonor(); %>
 <% String username = Donor.getUsername(); %>
    <div class="marginTable" ><%=username%></div>
 <% String fname = Donor.getFName(); %>
    <div class="marginTable" ><%=fname%></div>
 <% String lname = Donor.getLName(); %>
    <div class="marginTable" ><%=lname%></div>
 <% String pno = Donor.getphone(); %>
    <div class="marginTable" ><%=pno%></div>
 <% String add = Donor.getAddress(); %>
    <div class="marginTable" ><%=add%></div>
<br><br>
<a href="<%=request.getContextPath()%>/HomePageDonor.jsp" class="btn btn-success">Back to Home Page</a>
</div>
</body>
