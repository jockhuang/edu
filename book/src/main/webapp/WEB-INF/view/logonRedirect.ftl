<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>    
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="/common/layout.css" rel="stylesheet" />
    <script type="text/javascript" src="/static/script/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
	<script type="text/javascript" src="http://html.chineseall.cn/static/script/js.js"></script>
</head>
<body>
<div class="indexLogin" style="border: 0 none;height:253px;">
	<div id="indexlogin_div0" class="con">
		<ul>
			<li><img src="http://html.chineseall.cn/static/images/loading2.gif?${.now}" />&nbsp;&nbsp;登录中.......</li>
		</ul>
	</div>
</div>
<script type="text/javascript">
<#if returnUrl??>
	window.top.location.href="${returnUrl!'/org/index.action'}";
</#if>
</script>
</body>
</html>