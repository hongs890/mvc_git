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
	MemberBean bean = new MemberBean();
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	bean.setId(id);
	bean.setPw(pw);
	service.logoutSession(bean);
	response.sendRedirect(null);
	%> 
</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
