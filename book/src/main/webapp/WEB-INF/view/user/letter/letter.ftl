<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统书信_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
		<#if (list?? && list?size > 0 && groupUserInfo??)>
		<div class="info">
			<span>您与 ${groupUserInfo.displayName?default(groupUserInfo.userName)} 的对话</span>
			共 ${count?default(0)} 封书信
		</div>
		<dl class="mailTag replaytag">
			<#list list as l>
			<#if (l.sendUserId == groupUserInfo.userId)>
			<dd>
				<a class="del" rel="${l.id}" >删除此条</a>
				<a class="img" href="/user/${groupUserInfo.userId}/i.action" >
				<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(groupUserInfo.userId)}" /></a>
				<div class="cont" >
					<a href="/user/${groupUserInfo.userId}/i.action" >${groupUserInfo.displayName?default(groupUserInfo.userName)}</a><span class="gray">&nbsp;发送于：${l.sendTime?datetime}</span><br />
					标题：<span class="gray">${l.title?default('&lt;无标题&gt;')}</span><br />
					<div class="gray" style="width:100%;" ><span style="color:black;">内容：</span>${l.content?default('')}</div>
				</div>
				<a class="reply_but" rel="${l.id}" >回复</a>
			</dd>
			<#else>
			<dd>
				<a class="del" rel="${l.id}" >删除此条</a>
				<a class="img" ><img onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" 
					src="http://img3.chineseall.cn${loginUser.headImg?default('/userHeadImg/moren/default.jpg')}" /></a>
				<div class="cont" >
					<span class="gray">${l.sendTime?datetime}  我发送给：<a href="/user/${groupUserInfo.userId}/i.action" >${groupUserInfo.displayName?default(groupUserInfo.userName)}</a></span><br />
					标题：<span class="gray">${l.title?default('&lt;无标题&gt;')}</span><br />
					<div class="gray" style="width:100%;" ><span style="color:black;">内容：</span>${l.content?default('')}</div>
				</div>
			</dd>
			</#if>
			</#list>
		</dl>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		<input type="hidden" id="totalCount" value="${count?default(0)}" />
		<form id="p" method="get" action="letter.action" >
			<input type="hidden" id="groupId" name="groupId" value="${groupId}" />
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
		</form>
		<#else>
		<dl class="mailTag replaytag">
			<dd>
				没有书信对话内容~
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
				    current_page: (Number($('#currentPage').val()) - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			var flushPage = function(){
				window.location = window.location;
			}
			$('a.del').bind('click' , function(){
				deleteLetter(this.rel , flushPage);
			})
			$('a.reply_but').bind('click' , function(){
				replyLetter(this.rel , flushPage);
			})
			$('a.del,a.reply_but').css({cursor : 'pointer'})
			
			$(".tit a:contains('私人书信')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>