<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?7.0"></script>
<div class="Mcont">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">管理员设置</a> &gt; 管理员列表
	</div>
	<div class="context">
		<form action="/manage/user/listManager.action" method="POST">
			<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
				<tr>
					<th><span class="red"></span>用户名：</th><td>
					<input class="text" name="userName" value="${userName!''}" type="text" />
					</td>
					<td><input type="submit" style="cursor:pointer;" class="buttonmin yellow" value="查 询"></td>
				</tr>
			</table>
		</form>
		<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
			<tr>
				<th>用户名</th><th>管理的系统</th><th>状态</th><th>最后登陆</th><th></th>
			</tr>
			<#list pageUtil.items as item>
			<tr>
				<td>${item.userName!''}</td>
				<td>
				<#if item.orgName??>
					<#list item.orgName as orgName>
						${orgName!''}
					</#list>
				</#if>
				</td>
				<td><#if item.userState??><#if item.userState==1>正常<#else>停用</#if></#if></td>
				<td><#if item.lastLoginTime??>${item.lastLoginTime?number_to_datetime}</#if></td>
				<td>
					<a href="/manage/user/showUPManager.action?userId=${item.userId!''}">修改</a>
					<a onClick="if(confirm('确认要解除管理权限吗？')){window.location.href='/manage/user/removePermission.action?userId=${item.userId!''}'}" href="javascript:void(0);">解除管理员权限</a>
				</td>
			</tr>
			</#list>
			<tr><td colspan="5"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></td></tr>
		</table>
	</div>
</div>
</body>
</html>
