<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FriendzBook</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img src='<c:url value="/resources/images/blogkeyboard.jpg"/>' alt="...">
      <div class="caption">
        <h3>Blogs</h3>
        <p><a href="blog" class="btn btn-default" role="button">Blogs</a></p>
      </div>
    </div>
  </div>

  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img src="http://www.kompik.ho.ua/images/forum.png" alt="...">
      <div class="caption">
        <h3>Fourms</h3>
        <p><a href="fourm" class="btn btn-default" role="button">Forums</a></p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img src="https://ec.europa.eu/eures/docs/images/gellis/Image/Thematic_chats.jpg" alt="...">
      <div class="caption">
        <h3>Chats</h3>
        <p><a href="chat" class="btn btn-default" role="button">Chats</a></p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
    <img src="http://windows8.iyogi.com/content/dam/windows8-iyogi/2012/11/Microsoft-sending-out-How-to-mails-to-Windows-8-users.jpg" alt="...">
      <div class="caption">
        <h3>Mails</h3>
        <p><a href="SignIn" class="btn btn-default" role="button">Mails</a></p>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="..." alt="...">
    </a>
  </div>
</div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>