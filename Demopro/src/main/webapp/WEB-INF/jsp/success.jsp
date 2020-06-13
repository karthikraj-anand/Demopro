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
	$("#logindiv").hide();
	$("#registerdiv").hide();
	 var referrer =  document.referrer;
	 ////alert(referrer);
	 var n = referrer.indexOf("9090/");
	 var n5= n+5;
	 var res = referrer.substring(n5);
	 ////alert(res);
	 if(res.startsWith("login")){
		$("#logindiv").show();
		$("#registerdiv").hide();
		$('.usermail').text(sessionStorage.getItem("email"));
	 }else if(res.startsWith("signup")){
		 $("#registerdiv").show();
		 $("#logindiv").hide();
		 $('.usermail').text(sessionStorage.getItem("email"));
	 }
	 sessionStorage.removeItem("email");
});
</script>
</head>
<body>
	<div id="logindiv">
		<span>Welcome</span> <span class="usermail"></span>
	</div>
	
	<div id="registerdiv">
		<span>Successfully </span> <span class="usermail"></span><span> Registered!</span>
	</div>
</body>
</html>