/**
 * 
 */
var res_data;

function searchOrder(){
	var card=$('select[name="card"]').val();
	$("#orders").children().hide();
	$("#orders").find('div[name="'+card+'"]').show();
}

function reset(){
	$("#orders").children().show();
}
$(document).ready(function(){
	$.post("getOrderHistory",function(data,status){
		var res="";
		var cards=[];
		  for(var i=0;i<data.length;i++){
			  console.log(data[i]); //ITEMID,QUANTITY,PRICE,CARDNO,IMG
			  res_data=data;
			  res+="<div class='floating-box' width='100px' height='50px' name='"+data[i]["cardNo"]+"' >";
			  res+="<img src='"+data[i]["img"]+"' width='100px' height='100px'>";
			  res+="<label>Price:"+data[i]["price"]+"</label><br/>";
			  res+="<label>Quantity:"+data[i]["quantity"]+"</label><br/>";
			  res+="<label>Payment From:"+data[i]["cardNo"]+"</label>";
	          res+="</div>";
	          cards.push(data[i]["cardNo"]);
	          //cards+="<option name='card' value='"+data[i]["cardNo"]+"'>"+data[i]["cardNo"]+"</option>";
		  }
		  cards=$.unique(cards);
		  cardsHtml="";
		  for(var i=0;i<cards.length;i++)
			  cardsHtml+="<option name='card' value='"+cards[i]+"'>"+cards[i]+"</option>";
		  $("#orders").html(res);
		  $("#cards").html(cardsHtml);
	});
});