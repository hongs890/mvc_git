<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div style="text-align: center">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
				<h1>계좌관리</h1>
			<ol>
				<li><a href="${context }/member/service/regist.jsp">개설</a></li>
				<li><a href="${context }/member/service/deposit.jsp">입금</a></li>
				<li><a href="${context }/member/service/withdraw.jsp">출금</a></li>
				<li><a href="${context }/member/service/update.jsp">비번수정</a></li>
				<li><a href="${context }/member/service/delete.jsp">해지</a></li>
				<li><a href="${context }/member/service/list.jsp">전체조회</a></li>
				<li><a href="${context }/member/service/search.jsp">조회(계좌)</a></li>
				<li><a href="${context }/member/service/count.jsp">통장수</a></li>
			</ol>
		</div>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>