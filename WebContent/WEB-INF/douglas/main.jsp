<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />
<script src="${js}/douglas.js"></script>
<div id="container">
<section>
	<button id="bom">BOM(Browser Object Model)</button>
	<button id="dom">DOM(Document Object Model)</button>
	<button id="kaup">KAUP</button>
</section>
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />
<script>
	window.onload=init("${context}");
	
</script>
