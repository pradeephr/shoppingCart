<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

   <% if(Boolean.parseBoolean((String)session.getAttribute("admin"))!=true){
	      response.sendRedirect("/welcome.jsp");
   }%>
   <form id="add" style="margin-top:100px">
     <label>Color:</label><input type="text" name="color" id="color"><br/>
     <label>Width:</label><input type="text" name="width" id="width"><br/>
     <label>Height:</label><input type="text" name="height" id="height"><br/>
     <label>Material:</label><input type="text" name="material" id="material"><br/>
     <label>Thickness:</label><input type="text" name="thickness" id="thickness"><br/>
     <label>Quantity:</label><input type="text" name="quantity" id="quantity"><br/>
     <label>Price:</label><input type="text" name="price" id="price"><br/>
     <label>ImgUrl:</label><input type="text" name="img" id="img"><br/>
     <input type="button" value="AddItem" onclick="validate_item()">
   </form>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/admin_controls.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>