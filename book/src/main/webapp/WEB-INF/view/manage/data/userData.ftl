<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>

<body>
<div class="Mcont">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">数据中心</a> &gt; 用户
	</div><br/>
	<div class="greenNav2">
		<a <#if oper==0>class="hot"</#if> href="./userData.action">注册量</a> | <a <#if oper==1>class="hot"</#if> href="./userData.action?oper=1">阅读量</a> | <a <#if oper==2>class="hot"</#if> href="./userData.action?oper=2">停留时长</a> | <a <#if oper==3>class="hot"</#if> href="./userData.action?oper=3">活跃用户数</a>
	</div>
	<div class="context">
		${oper!''}
	</div>
</div>
</body>
</html>
