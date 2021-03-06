<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Hitch</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Khand" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
  <header>
    <h1 class="myheader">HITCH</h1>
    <img src="images/hitch.png" id="logo">  
    <nav id="navmenu">
      <ul>
        <li id="nav-home"><a href="main.jsp">Home</a></li>
        <li id="nav-ride"><a href="ride.jsp">Ride</a></li>
        <li id="nav-profile"><a href="profile.jsp">Profile</a></li>
        <li id="nav-delivery"><a href="/hitchwebapp/deliver.do">Delivery</a></li>
      </ul>
    </nav>
  </header>
  <h4 id="intro">Welcome to Hitch!</h4>
  <p class="about">Hitch is a taxi and delivery service located on the Southside of Chicago near Illinois Tech.</p>
  <img class="homepic" src="images/southside.jpg" alt="Green Line on the Southside of Chicago">
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>