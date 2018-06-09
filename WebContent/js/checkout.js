/**
 * 
 */
var res_data;
var total_price=0;
function removeFromCart(index){
	$.post("removeFromCart",
			{
		       itemId: res_data[index]["id"],
		       price: res_data[index]["price"]
			},
			function(data,status){
				alert("Successfully removed item from cart"+"#"+res_data[index]["id"]);
				$("#"+res_data[index]["id"]).hide();
				total_price-=parseInt(res_data[index]["price"],10);
				$("#totalPrice").val(total_price);
			}
		);
 }
$(document).ready(function(){
	$.post("getCartItems",
		function(data,status){
		  //alert(data);
		  //console.log(data);
		  var res="";
		  for(var i=0;i<data.length;i++){
			  console.log(data[i]);
			  res_data=data;
			  res+="<div width='100px' class='floating-box' height='50px' id='"+data[i]["id"]+"' >";
			  res+="<img src='"+data[i]["img"]+"' width='100px' height='100px'>";
			  res+="<label>Price:"+data[i]["price"]+"</label><br/>";
			  res+="<label>Width:"+data[i]["width"]+"</label><br/>";
			  res+="<label>Height:"+data[i]["height"]+"</label><br/>";
			  res+="<label>Quantity:"+data[i]["count"]+"</label>";
			  res+="<input type='button' value='Remove From Cart' onclick='removeFromCart("+i+")'>";
	          res+="</div>";
	          total_price+=parseInt(data[i]["price"],10);
		  }
		  $("#items").html(res);
		  $("#totalPrice").val(total_price);
	    });
	});