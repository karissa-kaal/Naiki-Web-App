<%@ page import="DisplayDonorsList.dao.DonorsListDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Display Donors List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>


	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Donors</h3>
			<hr>
			<div class="container text-left">
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>UserName</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Phone Number</th>
						<th>Address</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="donor" items="${listDonor}">

						<tr>
							<td><c:out value="${donor.getUsername()}" /></td>
							<td><c:out value="${donor.getFName()}" /></td>
							<td><c:out value="${donor.getLName()}" /></td>
							<td><c:out value="${donor.getphone()}" /></td>
							<td><c:out value="${donor.getAddress()}" /></td>
							
							
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>