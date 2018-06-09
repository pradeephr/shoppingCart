<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

<%
   if((String)session.getAttribute("username")==null){
	   session.setAttribute("redirect","checkout.jsp");
	   response.sendRedirect("welcome.jsp");
   }
%>
 <div style="margin-top:80px">
  <select name="card" id="cards">
    
  </select>
  <input type="button" value="search" onclick="searchOrder()" >
  <input type="button" value="reset" onclick="reset()" >
 </div>
  <div id="orders">
     
  </div>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/orderHistory.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>