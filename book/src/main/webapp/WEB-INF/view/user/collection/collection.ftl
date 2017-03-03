<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的藏书_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
		<div class="info">
			<span class="right">全部  ${count?default(0)} 本图书</span>
			<!--
			<div class="tab">
				我的图书标签：<span class="gray">（点击标签分类浏览）</span><br />
				<div>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >寓言</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >马克吐温</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >杨鹏</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >韩剧</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >恐龙王</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >教程</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >海宝</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >励志</a>
					<a style="cursor: pointer;" onclick="$('#tag').val(this.innerHTML);go(0)" >美国</a>
				</div>
			</div>
			-->
		</div>
		<dl id="collectionList" class="listIsilo" style="padding: 0px;" >
			<#if (list?? && list?size > 0)>
			<#list list as b >
			<dd>
				<a class="img" target="_blank" href="/book/detail.action?bookId=${b.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" alt="${b.name}" /></a>
				<a class="tit" target="_blank" href="/book/detail.action?bookId=${b.id}" title="${b.name}" >${textHandle.textEllipsis(b.name , 6)}</a><br />
				<font color="gray" ></font><span title="${b.author?default('')}" >${textHandle.textEllipsis(b.author?default('暂无作者信息') , 6)}</span><br />
				<font color="gray" ></font><span title="${b.publisher?default('')}" >${textHandle.textEllipsis(b.publisher?default('暂无出版社信息') , 7)}</span><br />
				<#--
				<a class="commendbut" >推荐给书友</a> 
				-->
				<a class="red" name="delbtn" rel="${b.id}" >删除</a>
			</dd>
			</#list>
			<form id="p" method="get" action="collection.action" >
				<input type="hidden" id="totalCount" value="${count}" />
				<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
			</form>
			<div id="pagination" style="clear:both;padding-top:10px"></div>
			<#else>
			<dd>
				<span>您还没收藏过图书~</span>
			</dd>
			</#if>
		</dl>
		
	</dd>
</dl>
</div>
</div>
<script type="text/javascript" src="/common/script/recommendBook.js" ></script>
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
			$('a[name="delbtn"]').css({cursor: 'pointer'}).bind('click' , function(){
				deleteCollection(this.rel , flushPage)
			});
			$(".tit a:contains('我的藏书')").attr('class' , 'hot');
			
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
