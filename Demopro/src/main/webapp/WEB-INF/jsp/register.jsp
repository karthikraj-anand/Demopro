<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	
	 $("#email").blur(function(){
		 $.ajax({
				url : "/emailUniqueCheck",
				type: "GET",
				data: "email="+$("#email").val() ,
		        dataType: "text",
		        contentType: "application/json",
		        success: function(result){
					if(result==="yes"){
						return true;
					}else if(result==="no"){
						alert("Email Id is Registered Already!");
						$("#email").val("");
						$("#email").focus();
		    			return false;
					}
		          }
			});
	 });

	 /* confirm pwd */
	 $("#cnfpassword").blur(function(){
		var pwd = $("#password").val();
		var cnf = $("#cnfpassword").val();
		
					if(pwd.trim() === cnf.trim()){
						return true;
					}else {
						alert("Confirm password does not match with password!");
						$("#password").val("");
						$("#cnfpassword").val("");
						$("#password").focus();
		    			return false;
					}
	});
	
$("#myform").submit(function(event){
	event.preventDefault(); //prevent default action 
	var post_url = $(this).attr("action"); //get form action url
	var request_method = $(this).attr("method"); //get form GET/POST method
	
	
	var demouserBean = {
            email: $("#email").val(),
            password:$("#password").val()
            
        }
	var tempdata = JSON.stringify(demouserBean);
	
	$.ajax({
		url : "/register",
		type: request_method,
		data: tempdata,
        dataType: "text",
        contentType: "application/json",
        success: function(result){
        	sessionStorage.setItem('email', $("#email").val());
			if(result==="success"){
				window.location.href = '/success';
			}else{
				window.location.href = 'http://localhost:9090/error';
			}
          }
	});
 });
});
</script>
</head>
<body>
<body bgcolor="lightgreen">
<h2>Sign Up</h2>
    <font color="red">${errorMessage}</font>
    <form id="myform" method="post">
    <table>
        <tr><td>Email : </td><td><input type="text" id="email" name="email" required="required" /> </td></tr>
        <tr><td>Password : </td><td><input type="password" id="password" name="password" required="required" /> </td></tr>
        <tr><td>Confirm Password : </td><td><input type="password" id="cnfpassword" name="cnfpassword" required="required" /> </td></tr>
        <tr><td><input type="submit" /></td></tr>
    </table>
    </form>
</body>
</body>
</html>