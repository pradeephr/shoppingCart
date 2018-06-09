<%@page errorPage="error.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>

 <div id="cards" style="margin-top:80px;">
 </div>
 <div id="newCard">
  <label>Name on Card:</label><input type="text" name="name"><br/>
  <label>Card No:</label><input type="text" maxlength="16" name="cardno"><br>
  <label>Billing Address:</label><input type="text" name="address"><br/>
  <label>CVV:</label><input type="text" maxlength="3" name="cvv"><br/>
  <label>Expiration:</label><input type="text" maxlength="2" name='month'>
  <input type="text" maxlength="4" name="year"><br/>
  <input type="button" value="Add Card" onclick="addCard()">
 </div>
 <input type="button" value="Finish Payment" onclick="validatePayment()">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/payment.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>