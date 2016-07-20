<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.MemberServiceImpl" %>
<%@ page import="member.MemberService" %>
<%@ page import="member.MemberBean" %>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
<style type="text/css">
span.meta{width: 200px; background-color:yellow; float: left}
</style>
<div style="text-align: center">
	
		<%

		MemberService service = MemberServiceImpl.getInstanceImpl();
		MemberBean member = new MemberBean();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setSsn(ssn);
		member.setEmail(email);
		member.setRegDate();
		name = service.regist(member);
		if(name == ""){
			%>아이디가 이미 사용중입니다 <br/><br/><br/>
			
			<a href="${context }/member/service/regist.jsp">다른 아이디로 가입하시겠습니까?</a><%
		}else{
			
			%>
			<span class="meta">이름 </span><%=name %><br/>
			<span class="meta">ID</span><%=id%><br/>
			<span class="meta">비밀번호</span><%=pw%><br/>
			<span class="meta">SSN</span><%=ssn%><br/>
			<span class="meta">E-mail</span><%=email%><br/>
			<span class="meta">전공</span><%=request.getParameter("major") %><br/>
			<span class="meta">수강과목</span> 
			<%
		String[] subjects = request.getParameterValues("subject");
		if(subjects != null){
			for(int i=0; i<subjects.length; i++){
		%>
				<%= subjects[i] %><br/><br/>
		<%
			}
		}
		%>
		회원가입을 축하드립니다. <%=request.getParameter("name") %> 님!<%
		}
		%>	<br/>	

	<a href="${context }/member/main.jsp"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/index.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
