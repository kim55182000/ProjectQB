<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<!--header start-->
<header class="header black-bg">
	
	<!--logo start-->
	<a href="${pageContext.request.contextPath}/teacher/teacherMain.do" class="logo"><b>QB<span>QB</span></b></a>
	<!--logo end-->

	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<!-- 정원 -->
			<div class="nav notify-row" id="top_menu">
				<ul class="nav top-menu">
					<li id="header_inbox_bar">
					<a href="${pageContext.request.contextPath}/teacher/myMessage.do"> 
					<i class="fa fa-envelope-o"></i>
					<span class="badge bg-theme">5</span>
					</a></li>
					<li id="header_inbox_bar"><a href="${pageContext.request.contextPath}/teacher/myPage.do"> <i
							class="fa fa-user"></i>
					</a></li>
				</ul>
			</div>
			<li><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></li>
			<!--  -->
		</ul>
	</div>
</header>
<!--header end-->

<se:authorize access="isAuthenticated()">
		<se:authentication property="principal.username" var="username"/>
	
	<!-- 웹 소켓 사용해서 현재 몇개의 쪽지가 도착했는지 구해오기. --> 
    <script type="text/javascript">
    var wsUri ="ws://localhost:8090/qb/count.do"
    
    function send_message() {
        websocket = new WebSocket(wsUri);
        
        websocket.onopen = function(evt) {
            onOpen(evt);
        };
        websocket.onmessage = function(evt) {
            onMessage(evt);
        };
        websocket.onerror = function(evt) {
            onError(evt);
        };
    }
   
    function onOpen(evt) 
    {
       websocket.send("${username}");
    }
    
    function onMessage(evt) {
    		$('#count').append(evt.data);
    }
    function onError(evt) {
    	
    }
    

    
        </script>

  </se:authorize>
  