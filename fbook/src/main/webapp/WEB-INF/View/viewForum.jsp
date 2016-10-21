<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.menu{
		width:200px;
		height:200px;
		background-color: grey;
		float:left;
	}
	.container{
		width: 50%;
		background-color: #CfC;
	}
	.content{
		margin: 0px auto;
		padding:10px 10px 10px 10px;
		background-color: #cff;
	}
</style>
</head>
<body>
<%@ include file="topPannel.jsp" %>
	
<div class="container">
	<div>
		<div>
			<h2>${Forum.forumName}</h2>
		</div>
		<div class="content">
			<p>${Forum.forumData}</p>
			<p style="font-size: 12px;float: right;">${Forum.author}</p><br/><br/>
			<p style="font-size: 10px;float: right;"> on ${Forum.createdDate}</p>
		</div>
	</div>
	<br/><br/><br/>
	
	<div style="text-align: center">
	<div>
		<p><b>comments :</b></p>
		
	</div>
	<c:if test="${user.firstName.length()>0}">
	<div>
		<form:form action="Comment" method="post">
			<label for="commentData" class="sr-only">Comment</label>
			<div class="input-group">
  				<span class="input-group-addon" id="basic-addon1">@</span>
  				<form:textarea path="commentData" class="form-control" id="commentData" placeholder="Your Comment" aria-describedby="basic-addon1" cols="30" rows="4"></form:textarea>
			</div>
			<div class="input-group" style="float:right;">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Post</button>
        	</div>
		</form:form>
	</div>
	</c:if>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>