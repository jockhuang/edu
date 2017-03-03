<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
</head>
<body style="background:#fff;">
<div class="box404">
	<div class="number"><input type="text" class="time" id="time" value="错" /></div>
	<script type="text/javascript">
	</script>
	<h2>ERROR HAPPENED!</h2>
	<p>
		<#if errorCode??&&errorCode.message??>
			${errorCode.code!''}<br/>
			${errorCode.message!''}<br/>
		</#if><br/>
		<#if exception??>
			${exception.message!''}<br/>
			<#list exception.stackTrace as e>
			${e?string}
			</#list>
		</#if><br/>
		<a href="#" id="backLink">返回</a>
	</p>
</div>
<script type="text/javascript">
$("#backLink").click(function(){
	window.history.go(-1);
});
</script>
</body>
</html>