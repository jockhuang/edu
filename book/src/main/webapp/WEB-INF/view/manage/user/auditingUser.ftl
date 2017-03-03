<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
<link href="http://html.chineseall.cn/static/style/powerFloat.css" rel="stylesheet" />
<script src="http://html.chineseall.cn/static/script/jquery-powerFloat.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?5.2"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">用户管理</a> &gt; 用户审核
</div>
<div class="context">
	<form action="/manage/user/listAuditingUser.action" method="POST">
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
		<input onClick="if(confirm('确认要踢出选中的用户？')){refuseJoin();}" class="button yellow" type="button" value="踢出" />
		<input onClick="if(confirm('确认要批准选中的用户？')){agreeJoin();}" class="button green" type="button" value="批准加入" />
		<script type="text/javascript">
			function refuseJoin(){
				$('#operForm').attr("action","/manage/user/refuseJoin.action");
				$('#operForm').submit();
			}
			function agreeJoin(){
				$('#operForm').attr("action","/manage/user/agreeJoin.action");
				$('#operForm').submit();
			}
		</script>
	</div>
	<form id="operForm" method="POST">
	<input type="hidden" name="currentPage" value="${pageUtil.currentPage!1}"/>
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th></th><th>用户名</th><th>申请时间</th><th>归属机构</th><th></th>
		</tr>
		<#list pageUtil.items as item>
		<tr>
			<td>
			<input type="checkbox" name="userIds" value="${item.userId!''}" />
			</td><td>${item.userName!''}</td>
			<td><#if item.creationTime??>${item.creationTime?number_to_datetime}</#if></td>
			<td>
			
				<#list item.userOrgList as orgTreeName>
					${orgTreeName.viewName!''}
					<#if orgTreeName_has_next><span class="tipTrigger" tip="<#list item.userOrgList as orgTreeName>${orgTreeName.viewName!''}  </#list>">...</span></#if>
					<#break>
				</#list>
			</td>
			<td><a href="/manage/user/agreeJoin.action?userIds=${item.userId!''}&currentPage=${pageUtil.currentPage!1}">批准加入</a></td>
		</tr>
		</#list>
		<tr><td colspan="5"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></td></tr>
	</table>
	<script>
		$(".tipTrigger").powerFloat({
			offsets: { x: -10, y: 22 },
			showDelay: 200,
			hoverHold: false,
			targetMode: "tip",
			targetAttr: "tip",
			position: "3-4" 
		});
	</script>
	</form>
</div>
</body>
</html>
