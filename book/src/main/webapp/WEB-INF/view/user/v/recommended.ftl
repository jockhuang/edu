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
			<a href="/user/${visitUser.userId}/collection.action" >TA的收藏</a><a href="/user/${visitUser.userId}/recommended.action" class="hot" >TA的图书</a><a href="/user/${visitUser.userId}/merecommended.action">TA的图书专辑</a>
		</div>
	</dt>
	<dd class="Library">
		<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
		<dl class="listIsilo">
		<#list pageUtil.items as b>
			<dd>
				<a class="img" target="_blank" href="/book/detail.action?bookId=${b.bookId}">
				<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.bookId)}" /></a>
				<a class="tit" target="_blank" href="/book/detail.action?bookId=${b.bookId}"><span title="${b.bookName}" >${b.bookName}</span></a><br />
				<font color="gray" >作  者:</font><span title="${b.author?default('')}" >${b.author?default('')}</span><br />
				<font color="gray">出版社:</font><span title="${b.publisher?default('')}">${b.publisher?default('')}</span><br />
			</dd>
		</#list>
		</dl>
		<div id="pagination" style="clear:both;padding-top:10px">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
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