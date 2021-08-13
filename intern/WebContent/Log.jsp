<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/log.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<h1>Login</h1>
<form id="formLogin">
 Employee Name: 
 <input id="EMP_NAME" name="EMP_NAME" type="text" 
 class="form-control form-control-sm">

 <br>
 <input id="btnLogin" name="btnLogin" type="button" value="Login" 
 class="btn btn-primary">
 <br>
 <br>
 <div id="alertError" class="alert alert-danger"></div>
</form>
<br>

 </div>
</div>
</div>
</body>
</html>