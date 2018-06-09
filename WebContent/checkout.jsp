<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

<%
   if((String)session.getAttribute("username")==null){
	   session.setAttribute("redirect","checkout.jsp");
	   response.sendRedirect("Register_Login.jsp");
   }
%>
  <div style="margin-top:80px;"></div>
   <span> Welcome to checkout...!</span>
   <div ><a href="welcome.jsp"><input type="button" value="Home"></a></div>
   <div id="items">
   </div>
   <div style="float:right">
     <span> You total is <input type="text" id="totalPrice"></span>
     <a href="payment.jsp"><input type="button" value="Buy" ></a>
   </div>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/checkout.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>