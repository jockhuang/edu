<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>私人书信_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
<dd class="MIS">
	<#if (list?? && list?size > 0)>
	<#list list as g >
	<#assign u = mapUserInfo[g.groupUserId?string] />
	<#if (u??)>
	<dl class="mailTag">
		<dd>
			<#if (g.notReadLetterCount?? && g.notReadLetterCount > 0)>
			<img class="mail" src='http://html.chineseall.cn/static/study/style/mail.jpg' />
			<#else>
			<img class="mail" src='http://html.chineseall.cn/static/study/style/mail_open.jpg' />
			</#if>
			<a class="img" href="/user/${u.userId}/i.action" style="cursor: pointer;"  >
			<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" /></a>
			<div class="cont" style="width: 70%;" >
				<a href="/user/${u.userId}/i.action" >${u.displayName?default(u.userName)}</a>
				<#if (g.lastUpdateTime??)>
				<span class="gray">发送于：${g.lastUpdateTime?datetime}</span><br />
				<#else>
				<span class="gray">发送于：</span><br />
				</#if>
				<div class="gray" style="width:100%;" ><span style="color:black;">标题：</span>${g.title?default('&lt;无标题&gt;')}</div>
			</div>
			<a class="red" style="float: right;" href="letter.action?groupId=${g.id}" >&nbsp;打开书信</a>
		</dd>
	</dl>
	</#if>
	</#list>
	<input type="hidden" id="totalCount" value="${count?default(0)}" />
	<form id="p" method="get" action="dialogue.action" >
		<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
	</form>
	<div id="pagination" style="clear:both;padding-top:10px"></div>
	<#else>
	<dl class="mailTag">
		<dd>
			您没有收到书信~
		</dd>
	</dl>
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
		 			items_per_page:10,
				    current_page: Number($('#currentPage').val() - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			$(".tit a:contains('私人书信')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
