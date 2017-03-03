<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>找回密码</title>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<link href="/common/layout.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>
<body>
<div class="bb1 zhmm">
	<div class="zhmm_left">
	<form id="findForm" action="/password/findPassword.action" method="get">
		<h2>STEP 1</h2>
		<h3>找回密码</h3>
		<p>请填写用户名</p>
		<div class="zhmmIpt">
			<input type="text"  name="userName"  id="userName" />
		</div>
		<div class="tsBtn">
			<a href="#" class="video_yd" id="validateButton">验 证</a>
		</div>
	</form>
	</div>
	<#if userInfoMap?? && (userInfoMap.email?? || userInfoMap.qq??)>
	<div class="zhmm_right">
	<form id="mailForm" action="/password/sendMail.action" method="post">
		<h2>STEP 2</h2>
		<p>请选择邮箱发送</p>
		<#if userInfoMap.email??>
		<div class="zhmmIpt">
			<label>
				<input class="cb1" type="checkbox" name="type1" value="1"/>
				${userInfoMap.email!''}
			</label>
		</div>
		</#if>
		<#if userInfoMap.qq??>
		<div class="zhmmIpt">
			<label>
				<input class="cb1" type="checkbox" name="type2" value="2"/>
				${userInfoMap.qq!''}
			</label>
		</div>
		</#if>
		</form>
		<div class="tsBtn">
			<a href="#" class="video_yd" id="sendMailButton">发 送</a>
		</div>
	</div>
	<#elseif (result?? && result=="1")>
		<div class="zhmm_right">
		<h2>STEP 2</h2>
		<p>
			${msg!'邮件已发送，请您查收!'}<br />
		</p>
		<div class="tsBtn">
			<a href="/password/showFindPass.action" class="video_yd" id="backButton">返 回</a>
		</div>
	</div>
	<#elseif (result?? && result=="0")>
		<div class="zhmm_right">
		<h2>STEP 2</h2>
		<p>
			${msg!'该用户名未设置邮箱，无法使用邮箱找回密码功能!'}<br />
			请联系管理员找回密码<br />
		</p>
		<div class="tsBtn">
			<a href="/password/showFindPass.action" class="video_yd">返 回</a>
		</div>
	</div>
	<#else>
	<div class="zhmm_right">
		<h2>STEP 2</h2>
		<p>
			若用户名未设置邮箱,将无法使用邮箱找回密码功能<br />
			需要联系管理员找回密码<br />
		</p>
		<div class="tsBtn">
			<a href="/password/showFindPass.action" class="video_yd">返 回</a>
		</div>
	</div>
	</#if>
</div>

<script type="text/javascript">
$("#validateButton").click(function(){
	$("#findForm").submit();
});
$("#sendMailButton").click(function(){
	$("#mailForm").submit();
});
</script>
</body>
</html>