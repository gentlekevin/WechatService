<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>翼机通+聊天机器人</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/default.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/styles.css">
<link href='http://fonts.useso.com/css?family=Open+Sans:400,600,700'
	rel='stylesheet' type='text/css'>
<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
<style type="text/css">
</style>
</head>
<body>
	<div id="chatbox">
		<div id="chat-messages">
			<div class="message">
				<img src="${ctx}/img/1_copy.png" />
				<div class="bubble">
					您好，很高兴为你服务，您可以直接输入问题~
					<div class="corner"></div>
				</div>
			</div>
			<div class="message right">
				<img src="${ctx}/img/2_copy.jpg" />
				<div class="bubble">
					翼机通加是什么？
				<div class="corner"></div>
				</div>
			</div>
		</div>
		<div id="sendmessage">
			<input type="text" value="Send message..." />
			<button id="send" class="button blue"></button>
		</div>
	</div>
	<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js"></script>
	<script>
	$(document).ready(function () {
	   
	    $('#sendmessage input').focus(function () {
	        if ($(this).val() == 'Send message...') {
	            $(this).val('');
	        }
	    });
	    $('#sendmessage input').focusout(function () {
	        if ($(this).val() == '') {
	            $(this).val('Send message...');
	        }
	    });
	   	});
 
  function  messageOnLeft( s){
	return"<div class='message'> <img src='${ctx}/img/1_copy.png'/>	<div class='bubble'>"+s+
	"<div class='corner'></div>	</div></div>";  
 };
  function  messageOnRight( string){
	  return"<div class='message right'> <img src='${ctx}/img/1_copy.png'/>	<div class='bubble'>"+s+
		"<div class='corner'></div>	</div></div>";  
 };
	
	</script>
</body>
</html>