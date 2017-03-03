<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>已购买图书专辑_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
		<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
		<dl class="listIsilo">
		<#list pageUtil.items as item>
			<dd>
				<a class="img" target="_blank" href="/eduyun/package/detail.action?id=${item.id!''}"><img 
				src="${item.cover!''}" /></a>
				<a class="tit" target="_blank" href="/eduyun/package/detail.action?id=${item.id!''}"><span title="${item.name}" >${textHandle.textEllipsis(item.name , 6)}</span></a><br />
				<font color="gray" >介绍:</font><span title="${item.intro?default('')}" >${textHandle.textEllipsis(item.intro?default('') , 6)}</span><br />
			</dd>
		</#list>
		</dl>
		<div id="pagination" style="clear:both;padding-top:10px"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></div>
		<#else>
			<span style="padding:15px;display:inline-block;" >还没有购买图书专辑~</span>
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
			$(".tit a:contains('已购图书专辑')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>