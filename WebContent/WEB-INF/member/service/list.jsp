<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page= "../../global/top.jsp" />
<jsp:include page= "../../global/header.jsp" />
<jsp:include page= "../../global/nav.jsp" />
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

p{text-align: center;}
</style>
<div style="text-align: center">
	
	<table>
	  <tr>
    <td>ID</td>
    <td>이름</td>
    <td>등록일</td>
    <td>생년월일</td>
  </tr>
  <tr>
    <td>hong</td>
    <td><a href="detail.jsp">홍길동</a></td>
    <td>2016-07-03</td>
    <td>901001</td>
  </tr>
    <tr>
    <td>lee</td>
    <td><a href="detail.jsp">이순신</a></td>
    <td>2016-07-03</td>
    <td>031001</td>
  </tr>
    <tr>
    <td>song</td>
    <td><a href="detail.jsp">송지효</a></td>
    <td>2016-07-03</td>
    <td>991001</td>
  </tr>
    <tr>
    <td>park</td>
    <td><a href="detail.jsp">박지성</a></td>
    <td>2016-07-03</td>
    <td>061001</td>
  </tr>
    <tr>
    <td>kim</td>
    <td><a href="detail.jsp">김유신</a></td>
    <td>2016-07-03</td>
    <td>951001</td>
  </tr>
</table>
	
	<a href="${context }/member/main.jsp"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global/main.jsp"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>
<jsp:include page= "../../global/footer.jsp" />
<jsp:include page= "../../global/end.jsp" />
