<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="greenNav">
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity.action?activityId=${activityId}">基本信息</a>
		<a href="/manage/activity/collaborator/list.action?activityId=${activityId}">协办机构</a>
		<a href="/manage/activity/bulletin/list.action?activityId=${activityId}">活动公告</a>
		<a href="/manage/activity/logo.action?activityId=${activityId}">页面管理</a>
		<a href="/manage/activity/book.action?activityId=${activityId}">书目管理</a>
	</#if>
	<a class="hot" href="/manage/activity/jury/list.action?activityId=${activityId}">活动评委</a>
	<a href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<div class="greenNav2">
	<a class="hot" href="/manage/activity/jury/list.action?activityId=${activityId}">活动已设评委</a> | <a href="/manage/activity/jury/list.action?activityId=${activityId}&type=1">新增评委</a>
</div>
<!--内容区-->
<div class="context">
	<form name="juryForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
			<tr>
				<th>姓名</th><th>用户名</th><th>密码</th><th></th>
			</tr>
			<#if jurys??>
				<#list jurys as jury>
					<tr>
						<td>${jury.juryRealName!''}</td>
						<td>${jury.juryName!''}</td>
						<td>${jury.juryPass!''}</td>
						<td><a href="javascript:void(0);delJury('${jury.id}');">删除</a></td>
					</tr>
				</#list>
			</#if>
		</table>
	</form>
</div>
<script type="text/javascript">
   /**
   **删除评委
   **/
   function delJury(id){
   	   if(confirm('确实要删除该评委吗?')) { 
   		   window.location.href='/manage/activity/jury/del.action?activityId=${activityId}&id='+id; 
   	   }
   }
</script>
