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
	<a href="/manage/activity/jury/list.action?activityId=${activityId}">活动已设评委</a> | <a class="hot" href="/manage/activity/jury/list.action?activityId=${activityId}&type=1">新增评委</a>
</div>
<!--内容区-->
<div class="context">
	<form method="post" name="juryForm" action="/manage/activity/jury/add.action">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" id="juryId" name="juryId" value=""/>
		<table class="formTable" cellpadding="7" cellspacing="0" width="100%">
			<tr>
				<th>评委姓名:</th>
				<td>
					<input style="width:100%;" id="realName" name="realName" type="text" />
				</td>
				<td>
				<input class="button green" type="button" value="生成账号" onclick="madeJury();"/>
				</td>
			</tr>
		</table>
		<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
			<tr>
				<th>用户名</th><th>姓名</th><th>密码</th><th></th>
			</tr>
			<#if jurys??>
				<#list jurys as jury>
					<tr>
						<td>${jury.juryName!''}</td>
						<td>${jury.juryRealName!''}</td>
						<td>${jury.juryPass!''}</td>
						<td>
							<#if jury.id==0>
							<#else>
								<a href="javascript:void(0);setJury('${jury.juryId}');">设为评委</a>
							</#if>
						</td>
					</tr>
				</#list>
			</#if>
		</table>
		<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
	</form>
</div>
<script type="text/javascript">
	function madeJury(){
		var realName=document.getElementById("realName");
		if(realName.value==''){
		  alert('请输入评委姓名');
		  return false;
		}else{
			document.juryForm.submit();
		}
	}
   /**
   **设置评委
   **/
   function setJury(juryId){
	    document.getElementById("juryId").value=juryId;
		document.juryForm.submit();
   }
</script>
