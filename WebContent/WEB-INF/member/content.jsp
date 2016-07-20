<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div style="text-align: center">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
		<h1>회원관리</h1>
			<ol>
					<li><a href="${context}/member/regist.do">회원가입</a></li>
					<li><a href="${context}/member/find_by_id.do">내정보보기</a></li>
					<li><a href="${context}/member/update.do">내정보수정</a></li>
					<li><a href="${context}/member/delete.do">탈퇴</a></li>
					<li><a href="${context}/member/login.do">로그인</a></li>
					<li><a href="${context}/member/logout.do">로그아웃</a></li>
					<li><a href="${context}/member/list.do">리스트</a></li>
					<li><a href="${context}/member/find_by.do">검색</a></li>
					<li><a href="${context}/member/count.do">전체 회원수</a></li>
			</ol>
		</div>
	<a href="${context}/global/main.do"><img src="${img}/home.png" alt="home" style="width:30px" /></a>
	</div>