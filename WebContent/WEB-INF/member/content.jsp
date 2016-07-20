<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div style="text-align: center">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
		<h1>회원관리</h1>
			<ol>
				<li><a href="${context }/member/service/regist.jsp">회원가입</a></li>
				<li><a href="${context }/member/service/find_by_id.jsp">내정보보기</a></li>
				<li><a href="${context }/member/service/update.jsp">내정보수정</a></li>
				<li><a href="${context }/member/service/delete.jsp">탈퇴</a></li>
				<li><a href="${context }/member/service/login.jsp">로그인</a></li>
				<li><a href="${context }/member/service/logout.jsp">로그아웃</a></li>
				<li><a href="${context }/member/service/list.jsp">리스트</a></li>
				<li><a href="${context }/member/service/find_by.jsp">검색</a></li>
				<li><a href="${context }/member/service/count.jsp">전체 회원수</a></li>
			</ol>
		</div>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>