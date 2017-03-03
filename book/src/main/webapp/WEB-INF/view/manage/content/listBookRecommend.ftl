<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; 图书推荐
</div>
<div class="context">
	<form action="/manage/content/listBookRecommend.action" method="POST">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th><span class="red"></span>关键字：</th><td>
				<input class="text" name="keywords" value="${keywords!''}" type="text" />
				</td>
				<td><input type="submit" style="cursor:pointer;" class="buttonmin yellow" value="查 询"></td>
			</tr>
		</table>
	</form>
	<div class="tableToolbar">
		<input onClick="window.location.href='/manage/content/listOrgBook.action'" class="button green" type="button" value="添加" />
		<input onClick="deleteBookRecommend()" class="button green" type="button" value="删除" />
		<script type="text/javascript">
			function deleteBookRecommend(){
				$('#operForm').attr("action","/manage/content/deleteBookRecommend.action");
				$('#operForm').submit();
			}
		</script>
	</div>
	<form id="operForm" method="POST">
	<input type="hidden" name="id" id="id" value="0"/>
	<input type="hidden" name="oper" id="oper" value="up"/>
	<input type="hidden" name="currentPage" value="${currentPage!1}"/>
	<script type="text/javascript">
		function moveBook(id,oper){
			$('#operForm').attr("action","/manage/content/moveBookRecommend.action");
			$("#oper").val(oper);
			$("#id").val(id);
			$('#operForm').submit();
		}
	</script>
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th></th><th>图书名称</th><th>作者</th><th></th><#if ((keywords!'')?length==0)><th></th></#if>
		</tr>
		<#list pageUtil.items as item>
		<tr>
			<td <#if currentPage==1 && item_index<4>style="background-color:#F5E0C1;"</#if>>
			<input type="checkbox" name="ids" value="${item.id!''}" />
			</td><td <#if currentPage==1 && item_index<4>style="background-color:#F5E0C1;"</#if>><#if item.name?length &lt; 15> ${item.name} <#else> ${item.name?substring(0,15)}... </#if></td>
			<td <#if currentPage==1 && item_index<4>style="background-color:#F5E0C1;"</#if>><#if item.author?length &lt; 8> ${item.author} <#else> ${item.author?substring(0,8)}... </#if></td>
			<#if ((keywords!'')?length==0)>
			<td <#if currentPage==1 && item_index<4>style="background-color:#F5E0C1;"</#if>>
				<a href="#" onClick="moveBook(${item.id!''},'up')">上移</a>
				<a href="#" onClick="moveBook(${item.id!''},'down')">下移</a>
			</td>
			</#if>
			<td <#if currentPage==1 && item_index<4>style="background-color:#F5E0C1;"</#if>><a href="/manage/content/showUpdateBookRecommend.action?id=${item.id!''}&currentPage=${currentPage!1}">修改</a></td>
		</tr>
		</#list>
		<tr><td colspan="<#if ((keywords!'')?length==0)>5<#else>4</#if>"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></td></tr>
	</table>
	</form>
</div>
</body>
</html>
