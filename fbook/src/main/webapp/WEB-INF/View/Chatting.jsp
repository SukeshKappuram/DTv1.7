<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</style>

</head>
<body>
<%@ include file="topPannel.jsp" %>
<div style="background-image:url('https://i.ytimg.com/vi/5vTIvrlIV9M/maxresdefault.jpg');width:100%;height:200px;">
<div class="menu">
	<ul type="disc">
		<h2>Hello ${user.firstName} !</h2>
		<li><a href="Addblog">Blog +</a></li>
		<li><a href="Addfourm">Forum +</a></li>
		<li><a href="Chat">Chat +</a></li>
	</ul>
</div>
	<img src="<c:url value="/resources/images/User/${user.userId}.jpg"/>" style="float:right;width:200px;height:200px;border-radius:95px;">
</div>
<div>
<div class="container" style="text-align: center;">
	<iframe name="f1" src="" width="75%" height="350px" frameborder="0"></iframe>
	<iframe name="f2" src="./chatUsers" width="20%" height="350px" frameborder="0"></iframe>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>