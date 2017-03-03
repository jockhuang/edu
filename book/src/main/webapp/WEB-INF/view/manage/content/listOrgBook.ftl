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
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; <a href="">图书推荐</a> &gt; 添加
</div>
<div class="context">
	<form action="/manage/content/listOrgBook.action" method="POST">
	<div>
		<div style="float:left;width:120px;">
			书名:<input type="text" value="${queryVo.name!''}" name="name" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:120px;">
			作者:<input type="text" value="${queryVo.author!''}" name="author" style="width:80px;"/>
		</div>
		<div class="cont" style="float:left;width:140px;">
			出版社:<input type="text" value="${queryVo.publisher!''}" name="publisher" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:140px;">
			图书id:<input type="text" value="${queryVo.bookId!''}" name="bookId" id="bookId" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:160px;">
			状态:<select id="state" name="state">
			<option value="-1">请选择</option>
			<option value="0" <#if queryVo.state??&&queryVo.state==0>selected</#if>>正常</option>
			<option value="1" <#if queryVo.state??&&queryVo.state==1>selected</#if>>隐藏</option>
			</select>
			<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
		</div>
		<div style="clear:both;margin-bottom:10px;"></div>
	</div>
	</form>
	<form id="operForm" method="POST">
	<#list pageUtil.items as item>
		<div class="listbook2">
			<a class="img" href=""><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(item.bookId)}" style="height:120px;width:85px;" /></a>
			<div class="title">
				<h4 class="left"><a href=""><#if item.bookName??><#if item.bookName?length &lt; 15> ${item.bookName!''} <#else> ${item.bookName?substring(0,15)}... </#if></#if></a></h4>
				<div class="left">
					<span class="gray">状态：</span><#if item.isHidden==0>已隐藏<#else>未隐藏</#if>
				</div>
			</div>
			<p>
				<span class="gray">作者：</span><#if item.author??><#if item.author?length &lt; 10> ${item.author!''} <#else> ${item.author?substring(0,10)}... </#if></#if> <span class="gray">/ 出版社：</span> <#if item.publisher??><#if item.publisher?length &lt; 8> ${item.publisher!''} <#else> ${item.publisher?substring(0,8)}... </#if></#if> <span class="gray"> / 出版日期：</span><#if item.publishDate??><#if item.publishDate?length &lt; 11> ${item.publishDate!''} <#else> ${item.publishDate?substring(0,11)}... </#if></#if> <span class="gray">/ 价格：</span><#if item.bookCurrency??> ${item.bookCurrency!0} </#if>元 <span class="gray">
			</p>
			<p>
				<#if item.intro??><#if item.intro?length &lt; 50> ${item.intro!'暂无简介'} <#else> ${item.intro?substring(0,50)}... </#if><#else>暂无简介</#if>
			</p>
			<p>
				<input onClick="window.location.href='/manage/content/chooseBook.action?id=${item.id!''}&currentPage=${currentPage!1}'" class="button green right" type="button" value="选用" />
			</p>
		</div>
		<br/>
	</#list>
	<br/>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
	</form>
</div>
</body>
</html>
