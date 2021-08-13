<%@page import="com.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MSAN Request</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
<script src="Components/datetime.js"></script>
</head>
	<body>
	
		<div class="container"><div class="row"><div class="col-6"> 
		<h1>MSAN Management</h1><br>
		<div id="divItemsGrid">

 <%
 user itemObj = new user(); 
 out.print(itemObj.readAdmin());
 %>
<br>

</div>
		<form id="formItem" name="formItem">
 		MSAN Name :
 		<input id="MSAN_NAME" name="MSAN_NAME" type="text" 
 		class="form-control form-control-sm"><br>
 		Progress Status:
 		<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<input id="PENDING" name="PROGRESS_STATUS" value= "Pending" type="radio" >
 		<label for="PENDING">Pending</label>&nbsp;&nbsp;&nbsp;&nbsp;
 		
 		<input id="DATA_OK" name="PROGRESS_STATUS" value="Data Ok" type="radio">
 		<label for="DATA_OK">Data Ok</label>&nbsp;&nbsp;&nbsp;&nbsp;
 		
 		<input id="ASSINGED" name="PROGRESS_STATUS" value="Assigned" type="radio">
 		<label for="ASSIGNED">Assigned</label>&nbsp;&nbsp;&nbsp;&nbsp;
 		
 		<input id="FEILD_COMPLETED" name="PROGRESS_STATUS" value="Feild Completed" type="radio">
 		<label for="FEILD_COMPLETED">Feiled Complete</label><br>
 		
 		<br>Request time : 
 		<input id="REQ_TIME" name="REQ_TIME" type="datetime-local" class="form-control form-control-sm">
 		
 		<br>Enterd By : 
 		<input id="ENTERED_BY" name="ENTERED_BY" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Enterd On : 
 		<input id="ENTERED_ON" name="ENTERED_ON" type="datetime-local" 
 		class="form-control form-control-sm"><br>
 		
 		<br>Assign To : 
 		<input id="ASSIGN_TO" name="ASSIGN_TO" type="text" 
 		class="form-control form-control-sm"><br>
 		
 		<br>Assign On : 
 		<input id="ASSIGN_ON" name="ASSIGN_ON" type="datetime-local" 
 		class="form-control form-control-sm"><br>
 		
 		<br>Completed On : 
 		<input id="COMLETED_ON" name="COMLETED_ON" type="datetime-local" 
 		class="form-control form-control-sm"><br>
 		
 <input id="btnSaveA" name="btnSaveA" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSaveA" 
 name="hidItemIDSaveA" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>

</div> </div> </div> 
</body>
</html>