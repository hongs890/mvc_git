<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="member.MemberServiceImpl" %>
<%@ page import ="member.MemberService" %>
<%@ page import ="member.MemberBean" %>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
	<div style="text-align:center">
		<%
		MemberService service = MemberServiceImpl.getInstanceImpl();
		MemberBean bean = new MemberBean();
		if(request.getParameter("id").equals(service.getSession().getId())
				&&request.getParameter("pw").equals(service.getSession().getPw())){
			bean.setId(service.getSession().getId());
			bean.setPw(service.getSession().getPw());
			service.delete(bean);
			response.sendRedirect(null);
		}else{
			%>잘못된 정보를 입력하셨습니다.<br/>
			<a href="${context }/member/main.jsp">메인화면으로 돌아가기</a><%
		}
		%>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
