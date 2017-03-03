<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
</head>

<body>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?5.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">用户管理</a> &gt; 正常用户
</div>
<div class="context">
	<form action="/manage/user/listNormalUser.action" method="POST">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th><span class="red"></span>用户名：</th><td>
				<input class="text" name="userName" value="${userName!''}" type="text" />
				</td>
				<td><input type="submit" style="cursor:pointer;" class="buttonmin yellow" value="查 询"></td>
			</tr>
		</table>
	</form>
	<div class="tableToolbar">
		<input onClick="if($('input:checkbox[name=userIds]:checked').length==0){alert('请先选中要操作的用户！')}else{if(confirm('确认要踢出选中的用户？')){kickoutUser();}}" class="button yellow" type="button" value="踢出" />
		<input onClick="uPass();" class="button green" type="button" value="修改用户密码" />
		<script type="text/javascript">
			function kickoutUser(){
				$('#operForm').attr("action","/manage/user/kickoutUser.action");
				$('#operForm').submit();
			}
			
			function uPass(){
				$("#uPass").fadeToggle("slow");
			}
			function updatePassword(){
				if($("#password").val().length<6 || $("#password").val().length>16){
					alert("密码长度在6-16位之间！");
					return false;
				}
				$('#operForm').attr("action","/manage/user/updatePassword.action");
				$('#operForm').submit();
			}
		</script>
	</div>
	<form id="operForm" method="POST">
	<input type="hidden" name="currentPage" value="${pageUtil.currentPage!1}"/>
	<!-- 修改密码开始 -->
	<table id="uPass" style="display:none;" class="formTable" cellpadding="5" cellspacing="0" width="100%">
		<tr>
			<th><span class="red">*</span> 密码修改为：</th><td>
			<input class="text" id="password" name="password" type="text" />
			</td>
			<td><input onClick="if($('input:checkbox[name=userIds]:checked').length==0){alert('请先选中要操作的用户！')}else{if(confirm('确认要修改选中用户的密码？')){updatePassword();}}" class="button green" type="button" value="提交" /></td>
		</tr>
	</table>
	<!-- 修改密码结束 -->
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th></th><th>用户名</th><th>注册时间</th><th>最后登陆</th><th></th>
		</tr>
		<#list pageUtil.items as item>
		<tr>
			<td>
			<input type="checkbox" name="userIds" value="${item.userId!''}" />
			</td><td>${item.userName!''}</td>
			<td><#if item.creationTime??>${item.creationTime?number_to_datetime}</#if></td>
			<td><#if item.lastLoginTime??>${item.lastLoginTime?number_to_datetime}</#if></td>
			<td><a href="/manage/user/kickoutUser.action?userIds=${item.userId!''}&currentPage=${pageUtil.currentPage!1}">踢出</a></td>
		</tr>
		</#list>
		<tr><td colspan="5"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></td></tr>
	</table>
	</form>
</div>
</body>
</html>
