<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

 <div style="margin-top:80px">
	   <form name="login" action="adminLogin" method="post">
	   	<label>Username:</label><input type="text" name="username">
	   	<label>Password:</label><input type="text" name="password">
	   	<input type="submit" value="Login" >
	   </form>
 </div>
<jsp:include page="common/footer.jsp"></jsp:include>