<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>最近阅读_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
<dd class="Library">
	<#if (list?? && list?size > 0)>
	<#list list as d>
	<#assign book = d.book />
	<#assign reading = d.readingBook />
	<div class="bookbox">
		<p class="imgleft">
			<a target="_blank" class="img" href="/book/detail.action?bookId=${book.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.id)}" alt="${book.name}" /></a>
			<a target="_blank" class="but" href="/book/read.action?bookId=${book.id}"></a>
			<a rel="7564" name="bookCommentLink" href="/user/bcomment.action?bookId=${book.id}"></a>
		</p>
		<div class="contleft">
			<h2>
				<a target="_blank" href="/book/detail.action?bookId=${book.id}">${book.name}</a>
			</h2>
			<p class="gray">
				作者：${book.author?default('&lt;暂无作者信息&gt;')}
			</p>
			<p>
				${intro[book.id?string]?default('&lt;暂无简介&gt;')}
			</p>
			<p class="gray">
				上次阅读：${reading.lastReadTime?datetime} 第<span class="red">${reading.lastReadPage}</span>页  <br />
			</p>
			<div class="MyQradebox">
				<span>我的评分:</span>
				<#if (userScore[book.id?string]??)>
				<span class="MyQradeboxbit" style="background-position:0 26px;">${userScore[book.id?string]}</span>
				<#else>
				<span >您还没有对它打分哦~</span>
				</#if>
			</div>
		</div>
	</div>
	</#list>
	<form id="p" method="get" action="reading.action" >
		<input type="hidden" id="totalCount" value="${count}" />
		<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
	</form>
	<div id="pagination" style="clear:both;padding-top:10px"></div>
	<#else>
	<div class="bookbox">您还没有这里阅读过图书~</div>
	</#if>
</dd>
</dl>
</div>
</div>
<script type="text/javascript">
	$(document).ready(
		function(){
			$(".MyQradeboxbit").each(function(){
				this.style.backgroundPosition = '0px ' + ((Number(this.innerHTML) + 1) * 26) + 'px';
				this.innerHTML = '';
			});
		
			var go = function(page_index){
				$('#currentPage').val(page_index + 1);
				$('#p').submit();
				return false;
			}
			
			if($('#totalCount').val() != null){
				$("#pagination").pagination($('#totalCount').val(), {
		 			items_per_page:10,
				    current_page: Number($('#currentPage').val() - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			$(".tit a:contains('最近阅读')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
