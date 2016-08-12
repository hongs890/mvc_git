<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />

<div id="container" style='width:100%'>
<h1 style='margin:0 auto; width: 250px'>Creator note</h1>
<section class="formbox">
		<p>input member info</p>
		NAME : <input type="text" name="name" id="name" /><br/>
		SSN : <input type="text" name="ssn" id="ssn" /><br/>
		<button id="bt_spec_show">Create member info</button>	
		<button id="bt_make_account">Create account</button>
</section>
<section class="formbox">
		<p>deposit, withdraw</p>
		money : <input type="text" name="money" id="money" /><br/>
		<button id="bt_deposit">deposit</button>	
		<button id="bt_withdraw">withdraw</button>
</section>
<section class="formbox">
	<p>Member Info</p>
	NAME : <article id="result_name" ></article>
	Age : <article id="result_age" ></article>
	Gender : <article id="result_gender"></article>
	AccountNum : <article id="result_account"></article>
	balance : <article id="rest_money"></article>
</section>
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />
<script src="${js}/douglas.js"></script>
<script>account.init();</script>