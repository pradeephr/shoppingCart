/**
 * 
 */
var res_data;
function addToCart(id){
	console.log("item to be added is "+res_data[id]["id"]+$("#"+res_data[id]["id"]).find('select[name="quantity"]').val());
	var item_quant=$("#"+res_data[id]["id"]).find('select[name="quantity"]').val();
	//call add to cart 
	
	if($('#checkout').attr('href')===undefined){
		alert("Please Login to purchase!");
		return false;
	}
	$.post("cart"
			,{
				id: res_data[id]["id"],
				quantity: item_quant
			 }
			,function(data,status){
		      alert("Successfully added  item to cart");
		      console.log(data);
	    });
	
}
$(document).ready(function(){
	$.post("carpetstore",
		function(data,status){
		  //alert(data);
		  console.log(data);
		  var res="";
		  for(var i=0;i<data.length;i++){
			  console.log(data[i]);
			  res_data=data;
			  res+="<div width='100px' class='floating-box' height='50px' id='"+data[i]["id"]+"' >";
			  res+="<img src='"+data[i]["img"]+"' width='100px' height='100px'>";
			  res+="<label>Price:"+data[i]["price"]+"</label><br/>";
			  res+="<label>Width:"+data[i]["width"]+"</label><br/>";
			  res+="<label>Height:"+data[i]["height"]+"</label><br/>";
			  res+="<label>Quantity:"+"<select name='quantity'>";
			   for(var j=1;j<data[i]["count"];j++){
				   res+="<option value='"+j+"'>"+j+"</option>";
			   }
			  res+="</select>"; 
			  res+="<input type='button' value='Add To Cart' onclick='addToCart("+i+")'>";
	          res+="</div>";
		  }
		  $("#items").html(res);
	    });
	});