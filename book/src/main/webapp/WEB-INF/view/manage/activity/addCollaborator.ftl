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
	<a href="/manage/activity/collaborator/list.action?activityId=${activityId}">活动协办机构</a> | <a class="hot" href="/manage/activity/collaborator/list.action?activityId=${activityId}&type=1">添加协办机构</a>
</div>
<!--内容区-->
<div class="context">
	<form method="post" name="orgTreeForm">
		<table class="formTable" cellpadding="7" cellspacing="0" width="100%">
			<tr>
				<th>查找机构:</th>
				<td>
				<#if key??>
					<input style="width:100%;" id="key" name="key" type="text" value="${key}"/>
				<#else>
					<input style="width:100%;" id="key" name="key" type="text" />
				</#if>
				</td>
				<td>
				<input class="button green" type="button" value="搜索" onclick="checkData();"/>
				</td>
			</tr>
		</table>
		<div class="rightTool">
			<input class="button blue" type="button" value="设选中的为协办机构" onclick="selectOrgCollTree('-1');"/>
		</div>
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table class="table" cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
			<tr>
				<th><input type="checkbox" id="selectAll" name="selectAll"/></th><th>机构名称</th><th></th>
			</tr>
			<#if orgs??>
				<#list orgs as collabortor>
					<tr>
						<td><input type="checkbox" id="orgCollTreeId${collabortor_index}" name="orgCollTreeId" value="${collabortor.id}"/></td>
						<td>${collabortor.viewName}</td>
						<td><a href="javascript:void(0);selectOrgCollTree('${collabortor_index}');">设为协办机构</a></td>
					</tr>
				</#list>
			</#if>
		</table>
		<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
	</form>
</div>
<script type="text/javascript">
	$("#selectAll").click(function(){
		$("input[type='checkbox']").each(function(){
			if($("#selectAll").attr("checked")){
				$(this).attr("checked", true);
			}else{
				$(this).attr("checked", false);
			}
		});
	});
	function checkData(){
		var key=document.getElementsByName("key");
		if(key.value==''){
		  alert('请输入要查询的机构名称');
		  return false;
		}else{
			document.orgTreeForm.submit();
		}
	}
   /**
   **选择协办机构
   **/
   function selectOrgCollTree(index){
	      if(index!='-1'){
	         document.getElementById("orgCollTreeId"+index).checked=true;  
	      }
	      var orgCollTreeIds=document.getElementsByName("orgCollTreeId");
	      for(var i=0;i<orgCollTreeIds.length;i++){
	         if(orgCollTreeIds[i].checked==true){
	            document.orgTreeForm.action="/manage/activity/collaborator/add.action";
	            document.orgTreeForm.submit();
	         return false;
	         }
	      }
	      alert('请选择机构');
   }
</script>
