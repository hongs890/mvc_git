<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.MemberServiceImpl" %>
<%@ page import = "member.MemberService" %>
<%@ page import = "member.MemberBean" %>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
	<div style="text-align : center">
	<%
	MemberService service = MemberServiceImpl.getInstanceImpl();
	MemberBean member = service.findById(request.getParameter("id"));
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
		member.setPw(pw);
		member.setEmail(email);
		service.update(member);
		response.sendRedirect(null);
		%>
		<h1>회원정보 수정에 성공하였습니다.</h1><br/>
		
		<a href="${context }/member/main.jsp"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/index.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
		<%
		
	
	%>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
