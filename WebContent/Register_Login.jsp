<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

 <div style="margin-top:80px;">
   <form id="login">
   	<label>Username:</label><input type="text" name="username">
   	<label>Password:</label><input type="text" name="password">
   	<input type="submit" value="Login" onclick="login()">
   </form>
 </div>
 <div>
   <form id="register" >
   	<label>Username:</label><input type="text" name="username">
   	<label>Password:</label><input type="text" name="password">
   	<input type="button" value="Register" onclick="register()">
   </form>
 </div>
 <a href="admin_login.jsp" ><input type="button" value="Admin"></a>
 <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
 <script type="text/javascript" src="js/register_login.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>  