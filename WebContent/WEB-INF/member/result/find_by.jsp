<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.MemberService" %>
<%@ page import = "member.MemberServiceImpl" %>
<%@page import="member.MemberBean"%>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
<style>
	#member_detail{border: 1px solid gray; width:90%; height: 400px; margin: 0 auto; border-collapse: collapse;}
	#member_detail tr{border: 1px solid gray; height:10%}
	#member_detail tr td{border: 1px solid gray;}
	.font_bold{font-weight: bold;}
	.bg_color_yellow{background-color: yellow}
</style>
<div style="text-align:center">
	<%
	MemberService service = MemberServiceImpl.getInstanceImpl();
	String id = request.getParameter("id");
	MemberBean member = service.findById(id);
	if(member == null){
		%>없는 아이디입니다.<br/><%
	}else{
		%>
	<table id="member_detail">
			<tr>
				<td rowspan="5" style="width:30%">
				<img src="${img }/<%=member.getProfileImg()%>" alt="W3Schools.com" width="200"
			height="200"></td>
				<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width:40%"><%=member.getId() %></td>
			</tr>
				<tr>
				<td class="font_bold bg_color_yellow">비밀번호</td>
				<td>*******</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이 름</td>
				<td><%=member.getName() %></td>
			</tr>
			
			<tr>
				<td class="font_bold bg_color_yellow">성 별</td>
				<td><%=member.getGender() %></td>
			</tr>
				<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td><%=member.getEmail() %></td>
				
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2"><%=member.getSsn().substring(0, 6) %></td>
				
			</tr>
		
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2"><%=member.getRegDate() %></td>
						</tr>
		</table>
<%		
	}
	%>
	<a href="${context }/member/main.jsp"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
