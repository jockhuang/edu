<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.0"></script>
<style>a.blue:link {color: blue;}</style>
<!--内容区-->
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="context">
	<form>
	<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
		<tr align="center">
			<th></th><td colspan="2" rowspan="3"><h1>基本信息提交成功！</h1></td>
		</tr>
		<tr>
			<th></th><td></td>
		</tr>
		<tr>
			<th></th><td></td>
		</tr>
		<tr>
			<th></th><td></td>
		</tr>
		<tr>
			<th></th><td></td>
		</tr>
		<tr>
			<th></th><td><h2>您可以根据需要完善以下活动信息:</h2></td>
		</tr>
		<tr>
			<th></th><td>活动公告：<span class="info">发布活动最新通知、公告等信息。</span><a class="blue" href="/manage/activity/bulletin.action?activityId=${activityId}">发布公告</a></td>
		</tr>
		<tr>
			<th></th><td>协办机构：<span class="info">协办机构用户也可以参加发起的活动。</span><a class="blue" href="/manage/activity/collaborator/list.action?activityId=${activityId}&type=1"> 添加协办机构</a></td>
		</tr>
		<tr>
			<th></th><td>推荐书目：<span class="info">为参与活动的用户提供阅读引导。</span><a class="blue" href="/manage/activity/book.action?activityId=${activityId}&type=1">添加推荐书目</a></td>
		</tr>
		<tr>
			<th></th><td>活动logo、banner：<span class="info">更换活动页面的图片为自己设计的图片。</span><a class="blue" href="/manage/activity/logo.action?activityId=${activityId}">上传活动logo</a>   <a class="blue" href="/manage/activity/logo.action?activityId=${activityId}&type=1">上传活动banner</a></td>
		</tr>
	</table>
</div>
