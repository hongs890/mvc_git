<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div style="text-align: center">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
		<h1>회원관리</h1>
			<ol>
					<li><a href="${context}/member.do?page=regist">회원가입</a></li>
					<li><a href="${context}/member.do?action=find_by_id&page=find_by_id">내정보보기</a></li>
					<li><a href="${context}/member.do?page=update">내정보수정</a></li>
					<li><a href="${context}/member.do?page=delete">탈퇴</a></li>
					<li><a href="${context}/member.do?page=login">로그인</a></li>
					<li><a href="${context}/member.do?page=logout">로그아웃</a></li>
					<li><a href="${context}/member.do?page=list">리스트</a></li>
					<li><a href="${context}/member.do?page=find_by">검색</a></li>
					<li><a href="${context}/member.do?action=count&page=count">전체 회원수</a></li>
			</ol>
		</div>
	<a href="${context}/home.do"><img src="${img}/home.png" alt="home" style="width:30px" /></a>
	</div>