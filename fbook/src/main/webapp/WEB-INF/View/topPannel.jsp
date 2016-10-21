<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">FriendzBook</a>
    </div>
    
    <ul class="nav navbar-nav">
    	<li>
    	<form class="form-inline pull-xs-right">
    		<input class="form-control" type="text" placeholder="Search" size="50">
    		<button class="btn btn-success-outline" type="submit">Search</button>
  		</form>
  		</li>
  		<li>&nbsp</li>
      <li class="active"><a href="#">Home</a></li>
      <li><a href="blog">Blogs</a></li>
      
      <li><a href="forum">Forums</a></li>
      <li><a href="friends">friends</a></li>
     <!--  <li><img src="<c:url value="/resources/images/Icon-user.png"/>" width="10" height="10"><a href="friends">Profile</a> </li> -->
      <li><a href="Login"> Log out </a></li>
    </ul>
  </div>
</nav>

</body>
</html>