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
	<form:form action="./saveForum" method="post" enctype="multipart/form-data" class="container">
	
       	<label for="forumName" class="sr-only">Forum Name</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:input path='forumName' id="forumName" class="form-control" placeholder="Blog Name" aria-describedby="basic-addon1"/>
  			<form:errors path="forumName" /><br/>
		</div>
		
		<label for="forumData" class="sr-only">Forum Info</label> 
		<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<form:textarea path="forumData" class="form-control" id="forumData" placeholder="Your Blog Data" cols="50" rows="5" aria-describedby="basic-addon1"/>
		</div>
		<form:errors path="forumData" /><br/>
		<div class="input-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Post</button>
        </div>
	</form:form>
<%@ include file="footer.jsp" %>
</body>
</html>