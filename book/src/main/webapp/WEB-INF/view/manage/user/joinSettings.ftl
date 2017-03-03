<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?5.0"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">用户管理</a> &gt; 加入设置
</div>
<div class="context">
	<form action="/manage/user/changeJoinSettings.action" method="POST">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<td>用户是否需要审核？</td>
			</tr>
			<tr>
			<td>
				<input name="userAudit" value="1" type="radio" <#if orgBaseinfo??><#if (orgBaseinfo.userAudit!0)==1>checked</#if></#if> />需要审核
			</td>
			</tr>
			<tr>
			</tr>
			<tr><td>
				<input name="userAudit" value="2" type="radio" <#if orgBaseinfo??><#if (orgBaseinfo.userAudit!0)==2>checked</#if></#if>/>不需要审核
			</td></tr><tr>
			</tr><tr><td>
				<input class="button green" type="submit" value="确认提交" />
			</td></tr>
		</table>
	</form>
</div>
</body>
</html>
