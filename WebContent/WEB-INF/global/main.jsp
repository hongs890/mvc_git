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
<script src="${js}/global.js"></script>
<jsp:include page="nav.jsp" />
	<div id="section">
		<button id ="bt" style="margin:0 auto">
			모던 자바스크립트 GO 
		</button>
	</div>
<jsp:include page="footer.jsp" />
<jsp:include page="end.jsp" />
<script>	
window.onload=init("${context}");
</script>
