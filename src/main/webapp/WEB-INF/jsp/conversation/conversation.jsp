<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Oracle HCM - Human Capital Management</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="../resource/conversation/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="../resource/conversation/css/style.css">
</head>
<body style="background: -moz-linear-gradient(top, #EAEAEA, #D8D8D8);">
<header class="_demo--heading">
	<div class="_demo--banner">
		<div class="_demo--container" style="white-space:wrap">
			<img class="banner--service-icon" src="../resource/conversation/images/icons/logo.png" alt="Oracle Demo Icon" style="height: 60px; padding-bottom: 5px;"> 			
			<img class="banner--service-icon" src="../resource/conversation/images/icons/ibm.png" style="float:right; height: 60px; padding-bottom: 5px;"  alt="IBM logo">
		</div>
	</div>
</header>
<div class="_demo--container--new" style="width:100%;">
	<div class="_demo--container--new">
		<div class="banner--service-icon-container">
			<img class="banner--service-icon" src="../resource/conversation/images/icons/avatar-watson.svg" style="height: 70px; width:70px;" alt="Watson Icon">
		</div>
		<div class="banner--service-info">
			<h3 class="base--h3">Employee Engagement - Powered by Watson</h3>
			<div class="base--h5" style="color: #FFFFFF">The Dialog service provides a technology platform for managing conversations between Virtual Agents and Employees.</div>
			<div class="banner--service-description" style="color: #FFFFFF"></div>
		</div>
	</div>
</div>	
	<div class="_demo--container">
		<div>
			<input type="hidden" value="dummy" style="display: none;">
			<input type="hidden" name="leavemgmt" value="ABSENCE MANAGEMENT" class="_external--button--green" onclick="clicked('leave application')"/> &nbsp;
			<input type="hidden" value="BRING YOUR OWN DEVICE" class="_external--button--green" onclick="clicked('bring your device')"> &nbsp;
			<input type="hidden" value="CAREER ADVISOR" class="_external--button--blue"> &nbsp;
			<input type="hidden" value="WORKFORCE PREDICTION" class="_external--button--blue"> &nbsp;
			<input type="hidden" value="DEMOGRAPHICS @WORKPLACE" class="_external--button--blue"> &nbsp;
			<input type="hidden" value="RECRUITMENT ASSISTANCE" class="_external--button--blue">
			<input type="hidden" value="${username}" id="username" name="username">
		</div>
		<p style="color: #004E71; font-weight: 800; font-size: 18px">Speak to our Watson Workforce Engagement Advisor</p>
		<div class="data--info_confidence"></div> 
		<div class="_content--dialog" style="width: 100%">
			<div class="chat-window">
				<div class="chat-box">
					<div class="chat-box--pane">
						<div class="chat-box--item_WATSON chat-box--item chat-box--item_HIDDEN">
							<div class="chat-box--container">
								<div class="img-container chat-box--avatar chat-box--avatar_WATSON">
									<img src="../resource/conversation/images/icons/avatar-watson.svg" class="chat-box--avatar-img">
								</div>
								<div class="chat-box--message">
									<div class="chat-box--message-vertical">
										<p class="chat-box--message-text base--p"></p>
									</div>
								</div>
							</div>
						</div>
						<div class="chat-box--item_YOU chat-box--item chat-box--item_HIDDEN">
							<div class="chat-box--container">
								<div class="chat-box--message">
									<div class="chat-box--message-vertical">
										<p class="chat-box--message-text base--p"></p>
									</div>
								</div>
								<div class="img-container chat-box--avatar chat-box--avatar_YOU">
									<img src="../resource/conversation/images/icons/user.png" class="chat-box--avatar-img">
								</div>
							</div>
						</div>
						<!-- adding extra space hack -->
						<div style="height: 15px; visibility: hidden;"></div>
						<div class="loader">
							<div class="loader--fallback"><img src="../resource/conversation/images/watson.gif" width="50" alt=""></div>
						</div>
					</div>
				</div>
				<input type="text" placeholder="Type a response and hit enter" value="" autocomplete="off" class="chat-window--message-input base--text-input">
			</div>
		</div>
		<!-- Property template -->
		<div class="data--variable hidden">
			<span class="data--variable-title"></span>
			<span class="data--variable-value"></span>
		</div>
</div>
	<script type="text/javascript" src="../resource/conversation/js/conversation/jquery.min.js"></script>
  	<script type="text/javascript" src="../resource/conversation/js/conversation/demo.js"></script>
</body>
</html>