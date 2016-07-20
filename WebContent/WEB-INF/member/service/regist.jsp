<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<style>
span.meta{width: 500px; background-color:yellow; float: center}
</style>
<div style="text-align: center">
		<form action="${context }/member/result/regist.jsp" method="post">
		<span class="meta">이름 </span> <input type="text" name="name"/><br/>
		<span class="meta">ID</span><input type="text" name="id"/><br/>
		<span class="meta">비밀번호</span><input type="text" name="pw"/><br/>
		<span class="meta">SSN</span><input type="text" name="ssn"><br/>
		<span class="meta">E-Mail</span><input type="text" name="email"><br/>
		<span class="meta">전공</span> 
		<input type="radio" name="major" value="computer" checked/> 컴공학부
		<input type="radio" name="major" value="mgmt"/> 경영학부
		<input type="radio" name="major" value="math"/> 수학부
		<input type="radio" name="major" value="eng"/> 영문학부<br/>
		<span class="meta">수강과목</span><br/>
		<input type="checkbox" name="subject" value="java"/> 자바
		<input type="checkbox" name="subject" value="sql"/> SQL
		<input type="checkbox" name="subject" value="cpp"/> C++
		<input type="checkbox" name="subject" value="python"/> 파이썬
		<input type="checkbox" name="subject" value="delphi"/> 델파이
		<input type="checkbox" name="subject" value="html"/> HTML<br/>
		<input type="submit" value="회원가입" />
		<input type="reset" value="취소" />
	</form>	
	<a href="${context }/index.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
