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
	<a href="/manage/activity/jury/list.action?activityId=${activityId}">活动评委</a>
	<#if subOrgs?? && subOrgs?size==0>
		<a class="hot" href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=3">作品评选</a>
	<#else>
		<a class="hot" href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
	</#if>
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<div class="greenNav2">
	<#if subOrgs?? && subOrgs?size==0>
	<#else>
	<a href="/manage/activity/works/listAllWorks.action?activityId=${activityId}&type=1">所有作品</a> 
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=2">下级推荐的作品</a>
	</#if>
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=3">本机构用户作品</a>
	| <a href="/manage/activity/works/listScoreAcWorks.action?activityId=${activityId}&type=4">评委打分的作品</a>
	| <a class="hot" href="/manage/activity/works/listRecAcWorks.action?activityId=${activityId}&type=5">
		<#if orgTreeId==activity.orgTreeId>
			活动获奖作品
		<#else>
			已推荐给上级的作品
		</#if>
	</a>
</div>
<!--内容区-->
<div class="context">
	<form method="post" name="selectWorksForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="5"/>
		<div>
			<div style="float:left;width:180px;">
				标题:<input type="text" value="${queryVo.title!''}" name="title" style="width:120px;" />
			</div>
			<div class="cont" style="float:left;width:180px;">
				作者:<input type="text" value="${queryVo.author!''}" name="author" style="width:120px;"/>
			</div>
			<div style="float:left;width:180px;" >
				分组:
				<select class="text" name="groupId" style="width:90px;">
					<#if groups??>
						<option value="0">——————</option>
						<#list groups as group>
						    <#if groupId??>
								<#if group.groupId == groupId>
									<option value="${group.groupId}" selected>${group.groupName}</option>
							    <#else>
							    	<option value="${group.groupId}">${group.groupName}</option>
								</#if>
						    <#else>
						    	<option value="${group.groupId}">${group.groupName}</option>
							</#if>
						</#list>
					</#if>
				</select>
			</div>
			<div class="cont" style="float:right;width:150px;">
				<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<div class="tableToolbar">
		<div class="rightTool">
			<input class="button blue" type="button" value="导出搜到的作品" onclick="exportWorks();"/>
		</div>
	</div>
	<form name="acWorksForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="5"/>
		<table width="100%" cellspacing="2" cellpadding="8" class="table">
			<tbody>
				<tr>
					<th>作品</th><th>作者</th>
					<th>机构</th><th>分组</th>
				</tr>
				<#if queryVo?? && queryVo.data??>
					<#list queryVo.data as item>
						<tr class="bg1">
							<td><a href="/manage/activity/works/getWorks.action?activityId=${activityId}&worksId=${item.worksId}">${item.worksName!''}</a></td>
							<td>${item.author!''}</td>
							<td>${item.orgTreeName!''}</td>
							<td>${item.worksGroupName!''}</td>
						</tr>
					</#list>
				</#if>
			</tbody>
		</table>
	</form>
	<div class="bottomInfo2">
		<div class="right">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
	</div>
</div>
<script type="text/javascript"> 
	function exportWorks(){
     	document.selectWorksForm.action="/manage/activity/works/exportWorks.action";
        document.selectWorksForm.submit();
   }
</script>