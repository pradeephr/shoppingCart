/**
 * 
 */
function redirect_page(){
	$(location).attr("href","http://localhost:8080/Adv_WWW/");
	return false;
}
function register(){
	$.post("register",
			{
		       username : $("#register").find('input[name="username"]').val(),
		       password : $("#register").find('input[name="password"]').val()
			},
			function(data,status){
				//alert(data);
				redirect_page();
			});
}
function login(){
	$.post("login",
			{
		       username : $("#login").find('input[name="username"]').val(),
		       password : $("#login").find('input[name="password"]').val()
			},
			function(data,status){
				console.log(data);
				if(data.indexOf("Success")>0){
					console.log("sucess");
					redirect_page();
				}
				else{
					alert("Bad username or password");
				}
			});
}
/*function admin(){
	$.get("getAdmin",{
	         pwd : $("#admin").val()
	     },
	     function(data,status){
	    	 alert("Redirecting..");
	     });
}*/