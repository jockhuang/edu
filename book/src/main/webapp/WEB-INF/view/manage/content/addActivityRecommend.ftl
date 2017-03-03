<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.2"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; <a href="">活动推荐</a> &gt; 添加
</div>
<div class="context">
	<form action="/manage/content/showAddActivityRecommend.action" method="POST">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th><span class="red"></span>关键字：</th><td>
				<input class="text" name="activityName" value="${activityName!''}" type="text" />
				</td>
				<td>
				活动状态：
				<select name="activityState">
					<option value="0">查询所有</option>
					<option value="1" <#if activityState??><#if activityState==1>selected</#if></#if>>未开始</option>
					<option value="2" <#if activityState??><#if activityState==2>selected</#if></#if>>投稿中</option>
					<option value="3" <#if activityState??><#if activityState==3>selected</#if></#if>>禁止投稿</option>
					<option value="4" <#if activityState??><#if activityState==4>selected</#if></#if>>活动结束</option>
				</select>
				</td>
				<td><input type="submit" style="cursor:pointer;" class="buttonmin yellow" value="查 询"></td>
			</tr>
		</table>
	</form>
	<form id="operForm" method="POST">
	<#list pageUtil.items as item>
	<div class="listAction">
		<div class="topcont">
			<div class="right">
				<input onClick="window.location.href='/manage/content/chooseActivity.action?activityId=${item.activityId!0}&currentPage=${currentPage!0}'" class="button green" type="button" value="选用" />
			</div>
			<a class="img" href=""><img src="http://img3.chineseall.cn${item.logo!''}" /></a>
			<h4><#if item.activityName?length &lt; 25> ${item.activityName} <#else> ${item.activityName?substring(0,25)}... </#if></h4>
			<span class="gray">状态：</span><span class="yellow">
				<#if item.activityState??>
					<#if item.activityState==1>
						未开始
					<#elseif item.activityState==2>
						投稿中
					<#elseif item.activityState==3>
						禁止投稿
					<#elseif item.activityState==4>
						已结束
					<#else>
						未开始
					</#if>
				<#else>
					未开始
				</#if>
			</span>
		</div>
		<div class="bottomcont">
			<p>
				<span class="gray">主办：</span>${item.organizer!'未填写'} <span class="gray">/ 活动类型：</span>
				<#if item.activityType??>
					<#if item.activityType==1>
						读书活动
					<#elseif item.activityType==2>
						读书征文
					<#elseif item.activityType==3>
						摄影比赛
					<#elseif item.activityType==4>
						绘画比赛
					<#else>
						未填写
					</#if>
				<#else>
					未填写
				</#if>
				<span class="gray"> / 开始时间：</span><#if item.startDate??>${item.startDate?date}</#if><span class="gray"> / 结束时间：</span><#if item.finishDate??>${item.finishDate?date}</#if>
			</p>
			<p>
				<span class="gray">推荐书目：</span>${item.acBookCount!0}本 <span class="gray">/ 参与人数：</span>${item.joinUserCount!0} <span class="gray">/ 作品数量：</span>${item.worksCount!0} <span class="gray">
			</p>
		</div>
	</div>
	</#list>
	<br/><br/>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
	</form>
</div>
</body>
</html>
