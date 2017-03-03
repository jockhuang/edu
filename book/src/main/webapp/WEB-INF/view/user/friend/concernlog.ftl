<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>关注记录_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
			<span class="info">关注记录</span> <span class="gray">自动保留30天</span>
		</div>
		<dl class="listIsilo log">
			<#if (list?? && list?size > 0)>
			<#list list as c >
			<#if (c.userId != loginUser.userId && mapUserInfo[c.userId?string]??)>			
			<#assign u = mapUserInfo[c.userId?string] />
			<dd>
				<a class="img" href="/user/${u.userId}/i.action">
				<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" /></a>
				<a class="tit" href="/user/621810" title="${u.displayName?default(u.userName)}">${u.displayName?default(u.userName)}</a> 关注了您<br />
				<span class="gray">${c.concernDate?datetime}</span><br />
				<#if (c.state == 1)>
				<span class="but" >已关注</span>
				<#else>
				<a style="cursor: pointer;" name="cbtn" rel="${u.userId}" class="but" ><strong>+</strong> 关注他</a>				
				</#if>
			</dd>
			<#elseif (mapUserInfo[c.concernUserId?string]??)>
			<#assign u = mapUserInfo[c.concernUserId?string] />
			<dd>
				<a class="img" href="/user/${u.userId}/i.action"><img onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" 
				src="http://img3.chineseall.cn${u.headImg?default('/userHeadImg/moren/default.jpg')}" /></a>
				您关注了 <a class="tit" href="/user/621810" title="${u.displayName?default(u.userName)}">${u.displayName?default(u.userName)}</a><br />
				<span class="gray">${c.concernDate?datetime}</span><br />
			</dd>			
			</#if>
			</#list>
			<form id="p" method="get" action="concernlog.action" >
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
			$('a[name="cbtn"]').css({cursor : "pointer"}).bind('click' , function(){
				addConcern(this.rel , flushPage);
			})
			$(".tit a:contains('关注记录')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
