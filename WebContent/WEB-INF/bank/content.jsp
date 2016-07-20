<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div style="text-align: center">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
				<h1>계좌관리</h1>
			<ol>
				<li><a href="${context}/bank/regist.do">개설</a></li>
				<li><a href="${context}/bank/deposit.do">입금</a></li>
				<li><a href="${context}/bank/withdraw.do">출금</a></li>
				<li><a href="${context}/bank/update.do">비번수정</a></li>
				<li><a href="${context}/bank/delete.do">해지</a></li>
				<li><a href="${context}/bank/list.do">전체조회</a></li>
				<li><a href="${context}/bank/search.do">조회(계좌)</a></li>
				<li><a href="${context}/bank/count.do">통장수</a></li>
			</ol>
		</div>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>