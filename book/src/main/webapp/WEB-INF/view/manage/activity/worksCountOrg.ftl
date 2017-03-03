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
	<a href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
	<#if orgTreeId==activity.orgTreeId>
		<a class="hot" href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a class="hot" href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<div class="greenNav2">
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动每日投稿数</a> |
	</#if>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">各级作品数统计</a>
	<#if orgTreeId==activity.orgTreeId>
		| <a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=2">协办机构作品数统计</a>
		| <a class="hot" href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=3">单个机构作品数查询</a>
	</#if>
</div>
<!--内容区-->
<div class="context">
	<form action="/manage/activity/works/listAcWorksGroupByOrgTreeId.action" method="post" name="selectWorksForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="3"/>
		<div>
			<div style="float:left;width:200px;">
				机构名称:<input style="width:120px;" id="orgName" name="orgName" type="text" value="${orgName!''}"/>
			</div>
			<div style="float:right;width:180px;">
				<input type="button" value="查 询" class="buttonmin yellow" style="cursor:pointer;" onclick="checkData();">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<form name="acWorksCountForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table width="100%" cellspacing="2" cellpadding="8" class="table">
			<tbody>
				<tr>
					<th>机构名称</th><th>作品数量</th><th>推荐作品数量</th>
				</tr>
				<#if works??>
					<#list works as work>
						<tr class="bg1">
							<td>${work.name!''}</td>
							<td>${work.count!''}</td>
							<td>${work.recCount!''}</td>
						</tr>
					</#list>
				</#if>
			</tbody>
		</table>
	</form>
</div>
<script type="text/javascript">
	function checkData(){
   		var orgName=document.getElementById("orgName");
        if(orgName==''){
       	  alert('请输入机构全名!');
          return false;
        }
        document.selectWorksForm.submit();
    }
</script>