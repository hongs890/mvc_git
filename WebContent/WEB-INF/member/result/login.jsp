<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.MemberServiceImpl" %>
<%@ page import="member.MemberService" %>
<%@ page import="member.MemberBean" %>

<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
<div style="text-align: center">
		<%
		MemberService service = MemberServiceImpl.getInstanceImpl();
		MemberBean member = new MemberBean();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id == ""|| pw == ""){
			%>
			<h2>로그인 실패!!</h2><br/>
			<a href="${context }/member/service/login.jsp">다시 로그인 하시겠습니까?</a>
			<%
		}else{
			member.setId(id);
			member.setPw(pw);
			String name = service.login(member);
			if(name == ""){
				%>
				<h2>로그인 실패!!</h2><br/>
				<a href="${context }/member/service/login.jsp">다시 로그인 하시겠습니까?</a>
				<%
				
			}else{
				response.sendRedirect(null);
			}
		}
	%>
</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
