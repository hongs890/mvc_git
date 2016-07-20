<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../global/top.jsp" />
<jsp:include page="../../global/header.jsp" />
<div style="text-align: center">
		<form action="${context }/member/result/login.jsp" method="post">
			<span class="meta">ID</span><input type="text" name="id"/><br/>
			<span class="meta">비밀번호</span><input type="password" name="pw"/><br/><br/>
			
			<input type="submit" value="로그인" />
			<input type="reset" value="취소">
		</form> <br/>
	<a href="${context }/index.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
</div>
<jsp:include page="../../global/footer.jsp" />
<jsp:include page="../../global/end.jsp" />