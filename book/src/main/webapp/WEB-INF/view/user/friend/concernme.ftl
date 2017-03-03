<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>关注我的_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
	<dd class="BookFriend">
		<div class="other">
			<span class="info" >${count} 个书友在关注您</span>
		</div>
		<dl class="listIsilo">
			<#if (list?? && list?size > 0)>
			<#list list as u >
			<dd>
				<a class="img" href="/user/${u.userId}/i.action">
				<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" /></a>
				<a class="tit" href="/user/${u.userId}/i.action" title="${u.displayName?default(u.userName)}" >${textHandle.textEllipsis(u.displayName?default(u.userName) , 6)}</a><br />
				<a name="lbtn" class="red" rel="${u.userId}" >写书信</a><br />
			</dd>
			</#list>
			<form id="p" method="get" action="concernme.action" >
				<input type="hidden" id="totalCount" value="${count}" />
				<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
			</form>
			<div id="pagination" style="clear:both;padding-top:10px"></div>
			<#else>
			<dd>
				<span>还没有人来看过您~</span>
			</dd>
			</#if>
		</dl>
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
			var flushPage = function(){
				window.location = window.location;
			}
			$('a[name="lbtn"]').css({cursor : "pointer"}).bind('click' , function(){
				sendLetter(this.rel);
			})
			$(".tit a:contains('关注我的')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
