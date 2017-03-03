<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>隐私设置_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
<#include "nav.ftl" />
	<dd class="UserSet">
		<#include "msg.ftl" />
		<form action="saveprivacy.action" method="post" >
			<table border="0" cellspacing="10" cellpadding="0">
				<tr><td>愿意让好朋友看看您的书房么：</td><td>
					<#if (userStudy.isCanVisitPage?? && userStudy.isCanVisitPage == 2)>
					<input name="isCanVisitPage" type="radio" value="1" >是</input>
					<input name="isCanVisitPage" type="radio" value="2" checked="checked" >否</input>
					<#else>
					<input name="isCanVisitPage" type="radio" value="1" checked="checked" >是</input>
					<input name="isCanVisitPage" type="radio" value="2" >否</input>
					</#if>
				</td></tr>	
				<tr><td>让好朋友知道您在读什么书：</td><td>
					<#if (userStudy.isPassReadState?? && userStudy.isPassReadState == 2)>
					<input name="isPassReadState" type="radio" value="1" >是</input>
					<input name="isPassReadState" type="radio" value="2" checked="checked" >否</input>
					<#else>
					<input name="isPassReadState" type="radio" value="1" checked="checked" >是</input>
					<input name="isPassReadState" type="radio" value="2" >否</input>
					</#if>
				</td></tr>
				<tr><td>告诉朋友您参加了什么活动：</td><td>
					<#if (userStudy.isPassActivityState?? && userStudy.isPassActivityState == 2)>
					<input name="isPassActivityState" type="radio" value="1" >是</input>
					<input name="isPassActivityState" type="radio" value="2" checked="checked" >否</input>
					<#else>
					<input name="isPassActivityState" type="radio" value="1" checked="checked" >是</input>
					<input name="isPassActivityState" type="radio" value="2" >否</input>
					</#if>
				</td></tr>
				<tr><td>让好朋友都知道您在做什么：</td><td>
					<#if (userStudy.isPassOtherState?? && userStudy.isPassOtherState == 2)>
					<input name="isPassOtherState" type="radio" value="1" >是</input>
					<input name="isPassOtherState" type="radio" value="2" checked="checked" >否</input>
					<#else>
					<input name="isPassOtherState" type="radio" value="1" checked="checked" >是</input>
					<input name="isPassOtherState" type="radio" value="2" >否</input>
					</#if>
				</td></tr>
				<tr><th></th><td><input class="butsub" type="image" src="http://html.chineseall.cn/static/study/style/save_but.jpg"></td></tr>
			</table>
		</form>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript">
$(".tit a:contains('隐私设置')").attr('class' , 'hot');
</script>
<#include "../bottom.ftl" />
</body>
</html>
