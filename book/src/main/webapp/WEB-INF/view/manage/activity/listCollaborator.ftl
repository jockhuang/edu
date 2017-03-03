<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="greenNav">
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity.action?activityId=${activityId}">基本信息</a>
		<a class="hot" href="/manage/activity/collaborator/list.action?activityId=${activityId}">协办机构</a>
		<a href="/manage/activity/bulletin/list.action?activityId=${activityId}">活动公告</a>
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
<div class="greenNav2">
	<a class="hot" href="/manage/activity/collaborator/list.action?activityId=${activityId}">活动协办机构</a> | <a href="/manage/activity/collaborator/list.action?activityId=${activityId}&type=1">添加协办机构</a>
</div>
<!--内容区-->
<div class="context">
	<div class="rightTool">
		<input class="button blue" type="button" value="删除选中的机构" onclick="delOrgTree('-1');"/>
	</div>
	<form name="orgTreeForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
			<tr>
				<th><input type="checkbox" id="collaboratorId" name="collaboratorIdAll" onclick="checkAll(this);"/></th><th>机构名称</th><th></th>
			</tr>
			<#if collabortors??>
				<#list collabortors as collabortor>
					<tr>
						<td><input type="checkbox" id="collaboratorId${collabortor_index}" name="collaboratorId" value="${collabortor.collaboratorId}"/></td>
						<td>${collabortor.orgTreeName}</td>
						<td><a href="javascript:void(0);delOrgTree('${collabortor_index}');">删除</a></td>
					</tr>
				</#list>
			</#if>
		</table>
	</form>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
</div>
<script type="text/javascript">
	/**
   **全选
   **/
   function checkAll(object){
      var collaboratorIds=document.getElementsByName("collaboratorId");
      for(var i=0;i<collaboratorIds.length;i++){
         collaboratorIds[i].checked=object.checked;
      }
   }
   /**
   **删除选中的机构
   **/
   function delOrgTree(index){
	      if(index!='-1'){
	         document.getElementById("collaboratorId"+index).checked=true;  
	      }
	      var collaboratorIds=document.getElementsByName("collaboratorId");
	      for(var i=0;i<collaboratorIds.length;i++){
	         if(collaboratorIds[i].checked==true){
	            document.orgTreeForm.action="/manage/activity/collaborator/del.action";
	            document.orgTreeForm.submit();
	            return false;
	         }
	      }
	      alert('请选择要删除的机构');
   }
</script>
