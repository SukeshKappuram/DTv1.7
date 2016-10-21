<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	<form:form action="./Register" method="post" enctype="multipart/form-data" class="container">
	
       	<label for="firstName" class="sr-only">Your Name</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path='firstName' id="firstName" class="form-control" placeholder="Firstname" aria-describedby="basic-addon1"/>
  			<form:input  path='lastName' id="lastName" class="form-control" placeholder="Lastname" aria-describedby="basic-addon1"/>
  			<form:errors path="firstName" /><br/>
  			<form:errors path="lastName" /><br/>
		</div>
		
		<label for="userName" class="sr-only">User Name</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path="userName" class="form-control" id="userName" placeholder="Username" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="userName" /><br/>
		
		<label for="mailId" class="sr-only">Mail Id</label>
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path="mailId" id="mailId" class="form-control" placeholder="Mail Id" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="mailId" /><br/>
		
		<label for="phoneNo" class="sr-only">Mobile Number</label>
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path="phoneNo" class="form-control" id="phoneNo"  placeholder="Mobile Number" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="phoneNo" /><br/>
		
		<label for="password" class="sr-only">Password</label>
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path="password" class="form-control" id="password" placeholder="Password" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="password" /><br/>
		
		<label for="ConfirmPassword" class="sr-only">Confirm Password</label>
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path="password" class="form-control" id="ConfirmPassword" placeholder="Confirm Password" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="password" /><br/>
		<div class="input-group">
                	<span class="input-group-addon" id="basic-addon1">@</span>
                		Please select a file to upload : <input type="file" name="file" required="required"/>
        </div>
		<div class="input-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
        	Already Registered? click <a href="UserRegister" >here</a>
        </div>
	</form:form>
<%@ include file="footer.jsp" %>
</body>
</html>