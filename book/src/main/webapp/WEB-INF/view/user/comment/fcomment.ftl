<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书友的书评_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
	<dd class="BookReview">
		<div class="other" >
			<span class="info">全部${count?default(0)}条书评</span>
		</div>
		<#if (list?? && list?size > 0)>
		<dl class="reviewList" >
			<#list list as c >
			<dd>
				<#if (mapBook[c.bookId?string]??)>
				<#assign book = mapBook[c.bookId?string] />
				<h2><a target="_blank" href="/book/detail.action?bookId=${c.bookId}"><span>${book.name}</span></a></h2>
				<a target="_blank" class="img" href="/book/detail.action?bookId=${c.bookId}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(c.bookId)}" /></a>
				<#else>
				<h2><a target="_blank" ><span style="color:gray" >找不到评论图书或图书已下架</span></a></h2>
				<a target="_blank" class="img" ><img src="http://img3.chineseall.cn/bookpic/default.jpg" /></a>	
				</#if>
				<#if (mapUserInfo[c.submiterId?string]??)>
				<#assign user = mapUserInfo[c.submiterId?string] />
				<div class="tit"><#if (c.page?? && c.page > 0)><span class="right">评论页数：第 ${c.page}页</span></#if><a href="/user/${user.userId}/i.action" >${user.displayName?default(user.userName)}</a>&nbsp;<span class="gray">${c.submitTime?datetime}</span></div>
				<#else>
				<div class="tit"><#if (c.page?? && c.page > 0)><span class="right">评论页数：第 ${c.page}页</span></#if><a style="font:color" >[用户已被注销]</a>&nbsp;<span class="gray">${c.submitTime?datetime}</span></div>
				</#if>
				<p>${c.content?default('')}</p>
			</dd>
			</#list>
		</dl>
		<form id="p" method="get" action="fcomment.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
			<input type="hidden" id="totalCount" name="currentPage" value="${count?default(0)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		<#else>
		<dl class="reviewList" ><dd><span>还没有书友写过图书评论~</span></dd></dl>
		</#if>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript">
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
			$(".tit a:contains('书友的书评')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>