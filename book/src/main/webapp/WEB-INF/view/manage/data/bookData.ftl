<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国-${orgTreeId}</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?6.0"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">数据中心</a> &gt; 图书
</div><br/>
<div class="greenNav2">
	<a <#if oper==0>class="hot"</#if> href="./bookData.action">收藏排行</a> | <a <#if oper==1>class="hot"</#if> href="./bookData.action?oper=1">阅读排行</a> | <a <#if oper==2>class="hot"</#if> href="./bookData.action?oper=2">评分排行</a> | <a <#if oper==3>class="hot"</#if> href="./bookData.action?oper=3">书评数排行</a>
</div>
<div class="context">
	<!-- 收藏排行开始  -->
	<#if oper==0>
	用户收藏最多的图书
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th>序号</th><th>图书名字</th><th>收藏量</th>
		</tr>
		<#list data as item>
		<tr>
			<td>${item_index+1}</td>
			<td><a href="/book/detail.action?bookId=${item.bookId!0}" target="_blank">${item.bookName!''}</a></td>
			<td>${item.collections!0}</td>
		</tr>
		</#list>
	</table>
	</#if>
	<!-- 收藏排行结束 -->
	
	<!-- 阅读排行开始  -->
	<#if oper==1>
	图书阅读排行
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th>序号</th><th>图书名字</th><th>阅读人数</th>
		</tr>
		<#list data as item>
		<tr>
			<td>${item_index+1}</td>
			<td><a href="/book/detail.action?bookId=${item.bookId!0}" target="_blank">${item.bookName!''}</a></td>
			<td>${item.totalReadCounts!0}</td>
		</tr>
		</#list>
	</table>
	</#if>
	<!-- 阅读排行结束 -->
	
	
	<!-- 评分排行开始  -->
	<#if oper==2>
	图书评分人数排行
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th>序号</th><th>图书名字</th><th>评分人数</th>
		</tr>
		<#list data as item>
		<tr>
			<td>${item_index+1}</td>
			<td><a href="/book/detail.action?bookId=${item.bookId!0}" target="_blank">${item.bookName!''}</a></td>
			<td>${item.scoreUserCount!0}</td>
		</tr>
		</#list>
	</table>
	</#if>
	<!-- 评分排行结束 -->
	
	
	<!-- 书评排行开始  -->
	<#if oper==3>
	图书评论数排行
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th>序号</th><th>图书名字</th><th>总书评书数</th>
		</tr>
		<#list data as item>
		<tr>
			<td>${item_index+1}</td>
			<td><a href="/book/detail.action?bookId=${item.bookId!0}" target="_blank">${item.bookName!''}</a></td>
			<td>${item.comments!0}</td>
		</tr>
		</#list>
	</table>
	</#if>
	<!-- 书评排行结束 -->
</div>
</body>
</html>
