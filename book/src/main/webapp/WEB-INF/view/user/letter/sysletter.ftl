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
		<div class="info">共 ${count?default(0)}封书信</div>
		<#if (list?? && list?size > 0)>
		<dl class="mailTag">
		<#list list as l >
			<dd>
				<a class="img" ><img src="http://img3.chineseall.cn/userHeadImg/moren/default.jpg" /></a>
				<div class="cont">
					管理员  <span class="gray">发送于：${l.sendTime?datetime}</span><br />
					<span class="gray" >标题：</span><span >${l.title?default('无标题')}</span><br />
					<span class="gray" >内容：</span><span><div align="center">${l.content?default('')}</div></span>
				</div>
			</dd>
		</#list>
		</dl>
		<input type="hidden" id="totalCount" value="${count?default(0)}" />
		<form id="p" method="get" action="sysletter.action" >
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
		</form>
		<#else>
		<dl class="mailTag">
			<dd>
				没有收到系统书信~
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
			$(".tit a:contains('系统书信')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>