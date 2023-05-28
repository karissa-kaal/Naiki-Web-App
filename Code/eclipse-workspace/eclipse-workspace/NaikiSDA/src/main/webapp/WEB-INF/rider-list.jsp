<%@ page import="Rider.dao.RiderDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Display Riders List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<form action="<%= request.getContextPath() %>/RiderListServlet" method="post">

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Riders</h3>
			<hr>
			<div class="container text-left">
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>UserName</th>
						<th>FName</th>
						<th>LastName</th>
						<th>Phone Number</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rider" items="${listRider}">

						<tr>
							<td><c:out value="${rider.getUsername()}" /></td>
							<td><c:out value="${rider.getFName()}" /></td>
							<td><c:out value="${rider.getLName()}" /></td>
							<td><c:out value="${rider.getphone()}" /></td>
							<td> <input type="submit" value="Delete" name= "Delete"  /> </td>
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	</form>
</body>
</html>