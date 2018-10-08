<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<h2>로그인</h2>
	<h3 class="hidden">방문페이지 로그</h3>
	<ul id="breadscrumb" class="block_hlist clear">
		<li>HOME</li>
		<li>회원가입</li>
		<li>로그인</li>
	</ul>


	<!--  
		1. action="/SpringMVC_Basic02_WebSite_Mybatis_Security/login"
		2. ${pageContext.request.contextPath}/login   >> EL 문법
		3. JSTL 문법  c:set ....   c:url 방법
	-->


	<h3 class="hidden">회원가입 폼</h3>
	<div id="join-form" class="join-form margin-large">
		<!-- 인증이 실패하면 message 확인하기 -->
		<c:if test="${param.error != null}">
			<div>
				로그인실패<br>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
      			이유 : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</c:if>
			</div>
		</c:if>
		<c:url value="/login" var="loginurl"></c:url>
		<form action="${loginurl}" method="post">
			<fieldset>
				<legend class="hidden">로그인 폼</legend>
				<h3>
					<img src="images/txtTitle.png" />
				</h3>
				<ul id="loginBox">
					<li><label for="uid">아이디</label> <input name="username"
						class="text" /></li>
					<li><label for="pwd">비밀번호</label> <input type="password"
						name="password" class="text" /></li>
				</ul>
				<p>
					<input type="submit" id="btnLogin" value="" />
				</p>
				<ul id="loginOption">
					<li><span>아이디 또는 비밀번호를 분실하셨나요?</span><a href="/Member/FindID"><img
							alt="ID/PWD 찾기" src="images/btnFind.png" /></a></li>
					<li><span>아이디가 없으신 분은 회원가입을 해주세요.</span><a
						href="/Member/Agree"><img alt="회원가입" src="images/btnJoin.png" /></a></li>
				</ul>
			</fieldset>
		</form>
	</div>

</div>
