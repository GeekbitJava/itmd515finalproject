<%-- 
Deborah Barndt
Thomas Boller
3-29-18
index.jsp
Programming Assignment 2
This program includes an html login form with an action to go to main.jsp file.
Written by Deborah Barndt & Thomas Boller. --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Hitch, Please Login</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
  <div class="login">
  <header class="header">
    <span class="logo"><img src="/images/hitch.png"></span>
    <span class="loader"></span>
  </header>
  <form class="form">  
    <input class="input" type="text", placeholder="Username">
    <input class="input" type="password" placeholder="Password">
    <button class="btn" type="submit"></button>
  </form>
</div>
<button class ="resetbtn" type= "reset">Reset it</button>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>