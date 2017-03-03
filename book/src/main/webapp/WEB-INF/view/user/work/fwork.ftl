<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书友的书评_${loginUser.displayName?default(loginUser.userName)}的书房</title>
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
<div class="layoutcont"><dl class="tabjs">
<#include "nav.ftl" />
	<dd>
		<div class="tabbox" style="display:block;">
			<#if (list?? && list?size > 0)>
			<div class="zpul">
				<#list list as w >
				<div class="zpli">
					<a class="img" href="/activity/index.action?activityId=${w.activityId}" title="${w.activityName}"><img onerror="this.src='http://img3.chineseall.cn/activityLogo/defaultsmaller.jpg'" 
					 src="http://img3.chineseall.cn//activityLogo/2012/04/17/未命名.jpg" alt="${w.activityName}" /></a>
					<strong><a href="/activity/work.action?activityId=${w.activityId}&worksId=${w.worksId}">${w.worksName}</a></strong>
					<p class="p"><em>[<a href="/activity/work.action?activityId=${w.activityId}&worksId=${w.worksId}">查看</a>]</em></p>
					<p>
						<span>${w.creationTime?datetime} | ${w.reviewCount?default(0)}条评论 ｜${w.pointCount?default(0)}人关注</span>
						<#if (mapUserInfo[w.userId?string]??) >
						<#assign u = mapUserInfo[w.userId?string] />
						<a href="/user/${w.userId}/i.action">${u.displayName?default(u.userName)}</a> 在 <a href="/activity/index.action?activityId=${w.activityId}" title="${w.activityName}" >${w.activityName}</a> 活动中上传
						</#if>
					</p>
				</div>
				</#list>
			</div>
			<input type="hidden" id="totalCount" value="${count?default(0)}" />
			<form id="p" method="get" action="work.action" >
				<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(0)}" />
			</form>
			<div id="pagination" style="clear:both;padding-top:10px"></div>
			<#else>
			<div class="zpul">
				<span>您还未提交过活动作品~</span>
			</div>
			</#if>
		</div>
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
			$(".tit a:contains('书友的作品')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>