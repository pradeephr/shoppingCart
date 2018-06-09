<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
  margin:0;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

</style>
<link rel="stylesheet" href="css/items_design.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarpetStore</title>
</head>
<body>
   <div class="navbar" style="margin-bottom:20px;">
    <% if((String)session.getAttribute("username")!=null) { %>
        <a href="#" > <%= "Welcome "+(String)session.getAttribute("username") %> </a>
    <% }
    else {%>
     	<a href="Register_Login.jsp">Register|Login</a>
    <%} %>
    <a href="welcome.jsp">Home</a>
   <% if((String)session.getAttribute("username")!=null) { %>
        <a id="checkout" href="checkout.jsp">Checkout</a>
        <a href="orderHistory.jsp">OrderHistory</a>
        <form action="logout" method="post"><input type="submit" value="Logout"></form>
   <% }%>
	</div>
   