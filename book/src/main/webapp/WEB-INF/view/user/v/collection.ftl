<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>藏书架－${userStudy.pageName?default(visitUser.userName)}的书房</title>
	<meta name="keywords" content="art,web" />
	<meta name="description" content="artWelcome" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content="artwc@foxmail.com" />
	<link rel="icon" href="favicon.ico" />
	<link rel="Shortcut Icon" href="favicon.ico" />
	<link rel="Bookmark" href="favicon.ico" />
	<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
	<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
	<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
	<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
</head>
<body>
<#include "top.ftl" />
<div class="layout">
<#include "left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
	<dt class="tit">
		<div class="tabTitTag">
			<a href="/user/${visitUser.userId}/collection.action" class="hot" >TA的收藏</a><a href="/user/${visitUser.userId}/recommended.action" >TA的图书</a><a href="/user/${visitUser.userId}/merecommended.action">TA的图书专辑</a>
		</div>
	</dt>
	<dd class="Library">
		<div class="info">
			<span class="right">全部  ${count?default(0)} 本图书</span>
		</div>
		<#if (list?? && list?size > 0) >
		<dl id="collectionList" class="listIsilo" style="padding: 0px;" >
			<#list list as b>
			<dd>
				<a class="img" target="_blank" href="/book/detail.action?bookId=${b.id}" ><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" alt="${b.name}" /></a>
				<a class="tit" target="_blank" title="${b.name}" href="/book/detail.action?bookId=${b.id}" >${textHandle.textEllipsis(b.name , 6)}</a><br />
				<span>${textHandle.textEllipsis(b.author , 6)?default('&lt;暂无作者信息&gt;')}</span><br />
				<span>${textHandle.textEllipsis(b.publisher , 7)?default('&lt;暂无出版社信息&gt;')}</span></span><br />
				<#if (b.state != 1) >
				<span class="gray" >已下架</span>
				<#elseif (mapBookId[b.id?string]??)>
				<a class="fav" >已收藏</a>
				<#else>
				<a class="stackbut" rel="${b.id}" >收藏</a>
				</#if>
			</dd>
			</#list>
		</dl>
		<input type="hidden" id="totalCount" value="${count?default(0)}" />
		<form id="p" method="get" action="collection.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		<#else>
		<dl id="collectionList" class="listIsilo" style="padding: 0px;" >
			<dd>
				<span>TA还未收藏过图书</span>
			</dd>
		</dl>
		</#if>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript" >
	$(document).ready(
		function(){
			var go = function(page_index){
				$('#currentPage').val(page_index + 1);
				$('#p').submit();
				return false;
			}
			if($('#totalCount').val() != null){
				$("#pagination").pagination($('#totalCount').val(), {
		 			items_per_page:12,
				    current_page: (Number($('#currentPage').val()) - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			$('.stackbut[rel]').css({cursor: 'pointer'}).bind('click' , function(){
				collection(this.rel , flushPage)
			})
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>