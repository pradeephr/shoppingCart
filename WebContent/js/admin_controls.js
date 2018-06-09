/**
 * 
 */
function add_item(){
	$.post("addItem",
		{
			color:$("#color").val(),
			width:$("#width").val(),
			height:$("#height").val(),
			material:$("#material").val(),
			thickness:$("#thickness").val(),
			quantity:$("#quantity").val(),
			price:$("#price").val(),
			img:$("#img").val()
		},
		function(data,status){
			alert("successfully added");
		}
	);
  }
function validate_item(){
	//do validation here
	add_item();
}