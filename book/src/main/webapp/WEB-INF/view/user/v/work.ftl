<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>TA关注的书友－${userStudy.pageName?default(visitUser.userName)}的书房</title>
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
			<a href="/user/${visitUser.userId}/work.action" class="hot" >TA的作品</a>
		</div>
	</dt>
	<dd>
		<div class="other">
			<span class="info" >TA发表的作品：（全部 ${count?default(0)}）</span>
		</div>
		<#if (list?? && list?size > 0) >
		<div class="tabbox" style="display:block;">
			<#list list as w>
				<div class="zpli">
					<a class="img" href="/activity/index.action?activityId=${w.activityId}" title="${w.activityName}">
					<img src="http://img3.chineseall.cn${w.activityLogo?default('/activityLogo/defaultsmaller.jpg')}" alt="${w.activityName}" /></a>
					<strong><a href="/activity/work.action?activityId=${w.activityId}&worksId=${w.worksId}">${w.worksName}</a></strong>
					<p class="p"><em>[<a href="/activity/work.action?activityId=${w.activityId}&worksId=${w.worksId}">查看</a>]</em></p>
					<p>
						<span>${w.creationTime?datetime} | ${w.reviewCount?default(0)}条评论 ｜${w.pointCount?default(0)}人关注</span>
						<span>${visitUser.displayName?default(visitUser.userName)}</span> 在 <a href="/activity/index.action?activityId=${w.activityId}" title="${w.activityName}" >${w.activityName}</a> 活动中上传
					</p>
				</div>
			</#list>
			<input type="hidden" id="totalCount" value="${count?default(0)}" />
			<form id="p" method="get" action="work.action" >
				<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(0)}" />
			</form>
			<div id="pagination" style="clear:both;padding-top:10px"></div>
		</div>
		<#else>
		<div class="tabbox" style="display:block;">
			<div class="zpul">
				<span>您还未提交过活动作品~</span>
			</div>
		</div>
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
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>