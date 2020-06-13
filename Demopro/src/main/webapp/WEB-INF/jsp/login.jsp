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
		url : "/auth",
		type: request_method,
		////data: {demouserBean: form_data },
		data: tempdata,
        dataType: "text",
        contentType: "application/json",
        success: function(result){
			if(result==="success"){
				sessionStorage.setItem('email', $("#email").val());
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
<body bgcolor="lightblue">
    <h2>Login </h2>
    <form id="myform" method="post">
        <table>
        <tr><td>Email : </td><td><input type="text" id="email" name="email" /> </td></tr>
        <tr><td>Password : </td><td><input type="password" id="password" name="password" /> </td></tr>
        <tr><td><input type="submit" value="Submit" /></td></tr>
        </table>
    </form>
</body>
</body>
</html>