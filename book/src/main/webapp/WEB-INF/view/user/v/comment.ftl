<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>图书评论－${userStudy.pageName?default(visitUser.userName)}的书房</title>
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
			<a href="/user/${visitUser.userId}/comment.action" class="hot" >TA的书评</a>
		</div>
	</dt>
	<dd class="BookReview">
		<div class="other">
			<span class="info">全部 ${count?default(0)} 条书评</span>
		</div>
		<#if (list?? && list?size > 0)>
		<dl id="bookCommentLog" class="reviewList">
			<#list list as c >
			<#if (mapBook[c.bookId?string]??)>
			<#assign b = mapBook[c.bookId?string] />
			<dd>
				<h2><a target="_blank" href="/book/detail.action?bookId=${c.bookId}"><span >${b.name}</span></a></h2>
				<a target="_blank" class="img" href="/book/detail.action?bookId=${c.bookId}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" alt="${b.name}" /></a>
				<div class="tit"><span class="right">评论页数：第 ${c.page?default(0)} 页</span><span class="gray">${visitUser.displayName?default(visitUser.userName)} ${c.submitTime?datetime}</span></div>
				<p>${c.content}</p>
			</dd>
			</#if>
			</#list>
		</dl>
		<input id="totalCount" type="hidden" value="${count?default(0)}" />
		<form id="p" method="get" action="comment.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		<#else>
		<dl id="bookCommentLog" class="reviewList">
			<dd>
				<span>TA还未发表过书评~</span>
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
		 			items_per_page:10,
				    current_page: (Number($('#currentPage').val()) - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			var flushPage = function(){
				window.location = window.location;
			}
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>