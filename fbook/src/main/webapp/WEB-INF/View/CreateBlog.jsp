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
	
	<form:form action="./saveBlog" method="post" enctype="multipart/form-data" class="container">
	<ul>
	<c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach>
	</ul>
       	<label for="BlogName" class="sr-only">Blog Name</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path='blogName' id="blogName" class="form-control" placeholder="Blog Name" aria-describedby="basic-addon1"/>
  			<form:input  path='blogType' id="blogType" class="form-control" placeholder="Blog Type" aria-describedby="basic-addon1"/>
  			<form:errors path="blogName" /><br/>
  			<form:errors path="blogType" /><br/>
		</div>
		
		<label for="blogData" class="sr-only">Blog Info</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:textarea path="blogData" class="form-control" id="blogData" placeholder="Your Blog Data" cols="50" rows="15" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="blogData" /><br/>
		<div class="input-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
        </div>
	</form:form>
<%@ include file="footer.jsp" %>
</body>
</html>