<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
	@import url(http://weloveiconfonts.com/api/?family=typicons);
[class*="typicons-"]:before {
  font-family: 'Typicons', sans-serif;
}

.module {
  width: 300px;
  margin: 20px auto;
}

.top-bar {
  background: #666;
  color: white;
  padding: 0.5rem;
  position: relative;
  overflow: hidden;
}
.top-bar h1 {
  display: inline;
  font-size: 1.1rem;
}
.top-bar .typicons-message {
  display: inline-block;
  padding: 4px 5px 2px 5px;
}
.top-bar .typicons-minus {
  position: relative;
  top: 3px;
}
.top-bar .left {
  float: left;
}
.top-bar .right {
  float: right;
  padding-top: 5px;
}
.top-bar > * {
  position: relative;
}
.top-bar::before {
  content: "";
  position: absolute;
  top: -100%;
  left: 0;
  right: 0;
  bottom: -100%;
  opacity: 0.25;
  background: radial-gradient(#ffffff, #000000);
  animation: pulse 1s ease alternate infinite;
}

.discussion {
  list-style: none;
  background: #e5e5e5;
  margin: 0;
  padding: 0 0 50px 0;
}
.discussion li {
  padding: 0.5rem;
  overflow: hidden;
  display: flex;
}
.discussion .avatar {
  width: 40px;
  position: relative;
}
.discussion .avatar img {
  display: block;
  width: 100%;
}

.other .avatar:after {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  width: 0;
  height: 0;
  border: 5px solid white;
  border-left-color: transparent;
  border-bottom-color: transparent;
}

.self {
  justify-content: flex-end;
  align-items: flex-end;
}
.self .messages {
  order: 1;
  border-bottom-right-radius: 0;
}
.self .avatar {
  order: 2;
}
.self .avatar:after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 0;
  border: 5px solid white;
  border-right-color: transparent;
  border-top-color: transparent;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

.messages {
  background: white;
  padding: 10px;
  border-radius: 2px;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
}
.messages p {
  font-size: 1.0rem;
  margin: 0 0 0.2rem 0;
}
.messages time {
  font-size: 0.9rem;
  color: #ccc;
}

@keyframes pulse {
  from {
    opacity: 0;
  }
  to {
    opacity: 0.5;
  }
}
#messagewindow {
    overflow: auto;
}
</style>
<script type="text/javascript">
	function scrollDw()
	{
		var objDiv = document.getElementById("last");
		objDiv.scrollTop = objDiv.scrollHeight;
	}
</script>
</head>
<body onload="scrollDw()">
<div id="messagewindow">
Message::
<ol class="discussion">
<c:forEach var="m" items="${messages}">
	<c:if test="${m.fromUserId!=user.userId}">
    <li class="other">
      <div class="avatar">
        <img src="<c:url value="/resources/images/User/${m.fromUserId}.jpg"/>" />
      </div>
      <div class="messages">
        <p>${m.message}</p>
        <time datetime="2009-11-13T20:00">${m.messageDate}</time>
      </div>
    </li>
    </c:if>
    <c:if test="${m.fromUserId==user.userId}">
    <li class="self">
      <div class="avatar">
        <img src="<c:url value="/resources/images/User/${user.userId}.jpg"/>" />
      </div>
      <div class="messages">
        <p>${m.message}</p>
        <time datetime="2009-11-13T20:00">${m.messageDate}</time>
      </div>
    </li>
    </c:if>
    </c:forEach>
  </ol>
  </div>
  <div id="last">
	<br/><br/><br/><br/><br/>
 </div>
	<div style="bottom:0px;position: fixed;">
		<form:form action="Message" method="post">
			<div class="input-group">
  				<span class="input-group-addon" id="basic-addon1">@</span>
  				<form:textarea path="message" class="form-control" id="message" placeholder="Your Message" aria-describedby="basic-addon1" cols="30" rows="4"></form:textarea>
				<button class="btn btn-lg btn-primary btn-block" type="submit">send</button>
			</div>
		</form:form>
	</div>
</body>
</html>