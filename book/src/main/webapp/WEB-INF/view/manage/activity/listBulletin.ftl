<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="greenNav">
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity.action?activityId=${activityId}">基本信息</a>
		<a href="/manage/activity/collaborator/list.action?activityId=${activityId}">协办机构</a>
		<a class="hot" href="/manage/activity/bulletin/list.action?activityId=${activityId}">活动公告</a>
		<a href="/manage/activity/logo.action?activityId=${activityId}">页面管理</a>
		<a href="/manage/activity/book.action?activityId=${activityId}">书目管理</a>
	</#if>
	<a href="/manage/activity/jury/list.action?activityId=${activityId}">活动评委</a>
	<a href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<!--内容区-->
<div class="context">
	<div class="tableToolbar">
		<input class="button green" type="button" value="添加公告" onclick="addAcBulletin();"/>
	</div>
	<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
		<tr>
			<th>标题</th><th>作者</th><th>发布时间</th><th></th>
		</tr>
		<#if bulletins??>
			<#list bulletins as bulletin>
				<tr>
					<td>${bulletin.title}</td>
					<td>${bulletin.createdBy}</td>
					<td>${bulletin.creationTime?string("yyyy年MM月dd日 ")}</td>
					<td><a href="/manage/activity/bulletin.action?activityId=${activityId}&bulletinId=${bulletin.bulletinId}">修改</a> | <a href="javascript:void(0);delAcBulletin('${bulletin.bulletinId}');">删除</a></td>
				</tr>
			</#list>
		</#if>
	</table>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
</div>
<script type="text/javascript">
	function delAcBulletin(id){
	  if (confirm('确认要删除该公告吗???')){
	    window.location.href='/manage/activity/bulletin/del.action?activityId=${activityId}&bulletinId='+id;
	  }
	}
	function addAcBulletin(){
	    window.location.href='/manage/activity/bulletin.action?activityId=${activityId}';
	}
</script>
