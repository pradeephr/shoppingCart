/**
 * 
 */
var cards;

$(document).ready(function(){
	$.post("getCards",
			function(data,status){
			  cards=data;
			  var res="";
			  for(var i=0;i<data.length;i++){
				  res+="<input type='radio' name='cardSelected' value='"+cards[i]["cardNo"]+"' >"+cards[i]["cardNo"]+"<br/>";
			  }
			  $("#cards").html(res);
			});
   });
function pay(){
	$.post("payment",
			{
		       cardNo: $('input[name="cardSelected"]:checked').val()
			},
			function(data,status){
		       alert(data);
		       $(location).attr("href","http://localhost:8080/Adv_WWW/");
	       });
}
function validatePayment(){
	if($('input[name="cardSelected"]:checked').val()!=undefined && $('input[name="cardSelected"]:checked').val().length==16)
		pay();
	else
		alert("Please Select a valid payment method");
}
function addCard(){
	//alert($("#newCard").find('input[name="cardno"]').val());
	
	$.post("addCard",
			{
		        name : $("#newCard").find('input[name="name"]').val(),
		        address : $("#newCard").find('input[name="address"]').val(),
				cvv : $("#newCard").find('input[name="cvv"]').val(),
				cardno : $("#newCard").find('input[name="cardno"]').val(),
	 			month : $("#newCard").find('input[name="month"]').val(),
				year : $("#newCard").find('input[name="year"]').val()
			},
			function(data,status){
				alert(data);
				var cardNo=$("#newCard").find("input[name='cardno']").val();
				cards.push(cardNo);
				var res="<input type='radio' name='cardSelected' value='"+cardNo+"' >"+cardNo+"<br/>";
				$("#cards").append(res);
				//$(location).attr("href","http://localhost:8192/Adv_WWW/");
			}
		);
 }