<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page= "../global/top.jsp" />
<jsp:include page= "../global/header.jsp" />
<jsp:include page= "../global/nav.jsp" />
<style>
#member_detail{border: 1px solid gray; width:90%; height: 400px; margin: 0 auto; border-collapse: collapse;}
#member_detail tr{border: 1px solid gray; height:10%}
#member_detail tr td{border: 1px solid gray;}
.font_bold{font-weight: bold;}
.bg_color_yellow{background-color: #EAEAEA}
</style>
<div style="text-align:center">
<form action ="${context }/member.do" method="post">
	<table id="member_detail">
			<tr>
				<td rowspan="6" style="width:30%">
				<img src="${img}/member/${user.profileImg}" alt="W3Schools.com" width="200" height="200"></td>
				<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width:40%">${user.id}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">비밀번호</td>
				<td><input type="text" name="pw" value="${user.pw}"></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td><input type="text" name="email" value="${user.email}"></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">핸드폰 번호</td>
				<td>${user.phone}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${user.ssn.substring(0,6)}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${user.regDate}</td>
			</tr>
		</table>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="direcotry" value="global">
	<input type="submit" value="수정 완료">
	<input type="reset" value="취소">
</form>
<a href="${context }/member.do"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
<a href="${context }/global.do"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
</div>
<jsp:include page= "../global/footer.jsp" />
<jsp:include page= "../global/end.jsp" />
