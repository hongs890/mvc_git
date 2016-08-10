<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />
<script src="${js}/douglas.js"></script>
<div id="container">
<section>
	<button id="bt_bom">BOM(Browser Object Model)</button><br/>
	<button id="bt_dom">DOM(Document Object Model)</button><br/>
	<button id="bt_kaup">KAUP</button><br/>
	<button id="bt_creator">CREATOR</button><br/>
</section>
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />
<script>
	window.onload=context.init("${context}");
	
</script>
