<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
 <div align="center">
  <h1>Sign Up to Naiki</h1>
  <form action="<%= request.getContextPath() %>/DonorServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="passcode" /></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="FirstName" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="LastName" /></td>
    </tr>
    <tr>
     <td>Phone No</td>
     <td><input type="text" name="Phone" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="Address" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
   <br> <br> <br>
<a href="<%=request.getContextPath()%>/Login.jsp" class="btn btn-success">Already have an account? Login instead</a>
  </form>
 </div>
</body>
</html>