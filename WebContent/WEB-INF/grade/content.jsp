<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<section id="grade_content">
	<h1 id="title">성적관리</h1>
		<article>
			<ol>
				<li><a href="#" id="a_regist">등록</a></li>
				<li><a href="#" id="a_update">수정</a></li>
				<li><a href="#" id="a_delete">삭제</a></li>
				<li><a href="#" id="a_list">목록</a></li>
				<li><a href="#" id="a_count">카운트</a></li>
				<li><a href="#" id="a_find">검색</a></li>
			</ol>
		</article>
	<a href="${context}/global.do"><img id="img_home" src="${img}/home.png" alt="home" /></a>
</section>
<script type="text/javascript">
$(function(){
	$('#grade_content').addClass('box');
	$('#img_home').css('width','30px');
	$('#grade_content > article')
	.css('width','300px')
	.css('margin','0 auto')
	.css('text-align','left');
	$('#title').css('font-size','35px');
	$('#a_regist').click(function(){
		location.href="${context}/grade.do?page=regist";
	});
	$('#a_update').click(function(){
		location.href="${context}/grade.do?page=update";
	});
	$('#a_delete').click(function(){
		location.href="${context}/grade.do?page=delete";
	});
	$('#a_list').click(function(){
		location.href="${context}/grade.do?page=list";
	});
	$('#a_count').click(function(){
		location.href="${context}/grade.do?page=count";
	});
	$('#a_find').click(function(){
		location.href="${context}/grade.do?page=search";
	});
	
});
</script>