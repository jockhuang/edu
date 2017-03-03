<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>关注TA的书友－${userStudy.pageName?default(visitUser.userName)}的书房</title>
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
			<a href="/user/${visitUser.userId}/concern.action" >TA关注的书友</a><a href="/user/${visitUser.userId}/concernhere.action" class="hot" >关注他TA的书友</a>
		</div>
	</dt>
	<dd class="BookFriend">
		<div class="other">
			<span class="info">正在关注TA的人：（全部${count?default(0)}人）</span>
		</div>
		<#if (list?? && list?size > 0) >
		<dl class="listIsilo" >
			<#list list as u>
			<dd>
				<a class="img" href="/user/${u.userId}/i.action"><img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" /></a>
				<a class="tit" href="/user/${u.userId}/i.action" >${textHandle.textEllipsis(u.displayName?default(u.userName) , 6)}</a><br />
				<#if (mapUserId[u.userId?string]??)>
				<a style="color:gray;" >已关注</a>
				<#elseif (loginUser?? && loginUser.userId == u.userId) >
				<br />
				<#else>
				<a style="color:orange;" name="cbtn" rel="${u.userId}" >关注他/她</a>
				</#if>
			</dd>
			</#list>
		</dl>
		<input type="hidden" id="totalCount" value="${count?default(0)}" />
		<form id="p" method="get" action="concernhere.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		<#else>
		<dl class="listIsilo" >
			<dd>
				<span>TA还未关注过其他书友~</span>
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
			$('a[name="cbtn"]').css({cursor: 'pointer'}).bind('click' , function(){
				addConcern(this.rel , flushPage)
			})
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>