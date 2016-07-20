<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.MemberServiceImpl" %>
<%@ page import = "member.MemberService" %>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
<div style="text-align: center">
	<%
	MemberService service = MemberServiceImpl.getInstanceImpl();
	if(service.getSession() == null||service.getSession().getId() == null){
		%><h1>먼저 로그인을 해주세요</h1><br/>
		<a href="${context }/member/service/login.jsp">로그인 하시겠습니까?</a><br/><br/>
		<%
	}else{
		%>
		<form action="${context }/member/result/logout.jsp" method="post">
		정말 로그아웃 하시겠습니까?<br/><br/>
		<input type="hidden" name="id" value="<%=service.getSession().getId()%>">
		<input type="hidden" name="pw" value="<%=service.getSession().getPw()%>">
		<input type="submit" value="로그아웃"><br/><br/>
		<a href="${context }/member/main.jsp"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
		<%
	}
	
	%>
	</form>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
