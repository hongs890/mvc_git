<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page= "../global/top.jsp" />
<jsp:include page= "../global/header.jsp" />
<jsp:include page= "../global/nav.jsp" />
	<div style="text-align:center"> <br />
		전체 회원수는${member} 명 입니다.<br/>
	 <a href="${context}/member.do"><img src="${img }/member.png" alt="member" style="width: 30px" /></a> 
	 <a	href="${context}/global.do"><img src="${img }/home.png" alt="home"style="width: 30px" /></a>
	</div>
<jsp:include page= "../global/footer.jsp" />
<jsp:include page= "../global/end.jsp" />
