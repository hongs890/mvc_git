<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>한빛 아카데미</title>
<link rel="stylesheet" href="${css}/global.css"/>	

</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="nav.jsp" />
	<div id="section" style="margin:0 auto">
		<button onclick="showAlert('You Click me !!')">
			CLICK ME
		</button>
	</div>
<jsp:include page="footer.jsp" />
<jsp:include page="end.jsp" />
<script>	
	function showAlert(){
		alert('you click third !!');
	}
	function clickme(){
		document.getElementsByTagName('button')[0]
		.onclick=showAlert();
	}
	window.onload=clickme();
</script>
