<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的书评_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
			<span class="info">全部${count?default(0)}本图书</span>
			| <a class="red" href="/user/commentbook.action">按书查看</a> | <a class="red" href="/user/comment.action">按单个书评发表时间查看</a> |
		</div>
		<dl class="listIsilo" >
			<#if (list?? && list?size > 0)>
			<#list list as b >
			<dd>
				<a class="img" target="_blank" href="/book/detail.action?bookId=${b.id}">
				<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a>
				<a class="tit" target="_blank" href="/book/detail.action?bookId=${b.id}"><span title="${b.name}" >${textHandle.textEllipsis(b.name , 8)}</span></a><br />
				作  者：<span>${textHandle.textEllipsis(b.author?default('暂无作者信息') , 6)}</span><br />
				<span >${textHandle.textEllipsis(b.publisher?default('暂无出版社信息') , 7)}</span><br />
				<a class="red" rel="${b.id}" href="/user/bcomment.action?bookId=${b.id}">查看书评</a>
			</dd>
			</#list>
			<#else>
			<dd><span>您还没有写过图书评论~</span></dd>
			</#if>
		</dl>
		<form id="p" method="get" action="commentbook.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
			<input type="hidden" id="totalCount" name="currentPage" value="${count?default(0)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
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
			$(".tit a:contains('我的书评')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
