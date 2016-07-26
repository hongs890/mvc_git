<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page= "../global/top.jsp" />
<jsp:include page= "../global/header.jsp" />
<jsp:include page= "../global/nav.jsp" />
<div style="text-align: center">
<table id="member_list">
	<tr>
	    <td>ID</td>
	    <td>이름</td>
	    <td>등록일</td>
	    <td>생년월일</td>
	    <td>E-mail</td>
	    <td>전화번호</td>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
	    <td>${member.id}</td>
	    <td><a href="${context}/member.do?action=find_by_id&page=find_by_id&keyword=${member.id}">${member.name}</a></td>
	    <td>${member.regDate}</td>
	    <td>${member.ssn}</td>
	    <td>${member.email}</td>
	    <td>${member.phone}</td>
	</tr>
	</c:forEach>
</table>
	<a href="${context }/member.do"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global.do"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
</div>
<jsp:include page= "../global/footer.jsp" />
<jsp:include page= "../global/end.jsp" />
