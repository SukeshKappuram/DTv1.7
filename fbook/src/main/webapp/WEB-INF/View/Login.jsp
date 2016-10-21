<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.input-group{
	width:50%;
	padding : 5px 5px 5px 5px;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<form name='f' action='Welcome' method='POST' class="container" >
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">@</span>
  		<input type="text" name="userName" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
	</div>
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">@</span>
  		<input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
	</div>
	<div class="input-group">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
       	New User? click <a href="UserRegister" >here</a>
    </div>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>