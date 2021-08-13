<%@page import="com.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
	<body> 
		<div class="container"><div class="row"><div class="col-6"> 
		<h1>Admin Management</h1>
		<form id="formItem" name="formItem">
 		First Name :
 		<input id="first_name" name="first_name" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Last Name : 
 		<input id="last_name" name="last_name" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Email : 
 		<input id="em" name="em" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>User Name : 
 		<input id="usern" name="usern" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Password : 
 		<input id="pass" name="pass" type="text" 
 		class="form-control form-control-sm"><br>
 		
 <input id="btnSaveA" name="btnSaveA" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSaveA" 
 name="hidItemIDSaveA" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">

 <%
 user itemObj = new user(); 
 out.print(itemObj.readAdmin());
 %>
<br>
<p class="text"><a href="NewFile.jsp">User Management</a></p>
  <p class="text"><a href="Researcher.jsp">Researcher Management</a></p>
</div>
</div> </div> </div> 
</body>
</html>