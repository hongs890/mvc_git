<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.MemberServiceImpl" %>
<%@ page import = "member.MemberService" %>
<%@ page import = "member.MemberBean" %>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
	<div style="text-align: center">
		<%
		MemberService service = MemberServiceImpl.getInstanceImpl();
		
		if(service.getSession() == null || service.getSession().getId()==null){
			%><h1>먼저 로그인을 해주세요</h1><br/>
			<a href="${context }/member/service/login.jsp">로그인 하시겠습니까?</a><br/><br/>
			<%
		}else{
			%>
			<h1>정말 탈퇴하시겠습니까?</h1><br/>
			<form action="${context }/member/result/delete.jsp" method="post">
			<input type="hidden" name="id" value="<%=service.getSession().getId()%>">
			비밀번호를 입력해주세요<input type="text" name="pw"><br/>
			<input type="submit" value="탈퇴">
					<input type="reset" value="취소">
			
			</form> 
			
			<%
		}
		
		%>
		<a href="${context }/member/main.jsp"><img
			src="${img }/member.png" alt="member" style="width: 30px" /></a> <a
			href="${context }/global/main.jsp"><img src="${img }/img/home.png" alt="home"
			style="width: 30px" /></a>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
