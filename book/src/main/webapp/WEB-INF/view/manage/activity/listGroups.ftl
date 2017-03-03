<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<style>a.blue:link {color: blue;}</style>
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
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<div class="greenNav2">
	<a href="/manage/activity.action?activityId=${activityId}">基本信息</a> | <a class="hot"  href="/manage/activity/group/listGroup.action?activityId=${activityId}"">活动分组</a>
</div>
<!--内容区-->
<div class="context">
	<form name="groupsForm" method="post" class="table">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<#if groups??>
			<table cellspacing="2" cellpadding="8" class="table">
			<tr>
				<th>排序</th><th>分组名称</th><th></th>
			</tr>
				<#list groups as group>
					<tr class="bg1">
						<td>
							<input type="hidden" id="id${group_index}" name="id" value="${group.groupId!''}"/>
							<input type="text" style="width:30px;" id="sort${group_index}" name="sort" value="${group.sortNo!''}" onBlur="checkData('${group_index}',this);"/>
						</td>
						<td><input type="text" style="width:80px;" id="groupName${group_index}" name="groupName" value="${group.groupName!''}" onBlur="checkData('${group_index}',this);"/>
						</td>
						<td>
							<#if group.groupId == 0>
							<#else>
								<div id="del${group_index}"><a class="blue" href="javascript:void(0);delGroups('${group.groupId}','${group_index}');">删除</a></div>
							</#if>
						</td>
					</tr>
				</#list>
				<tr>
					<th></th><td colspan="3">
					<input class="button green" type="button" value="保存修改" onclick="saveData();"/>
					</td>
				</tr>
			</table>
		</#if>
	</form>
</div>
<script type="text/javascript">
	function checkData(index,object){
		var id=document.getElementById("id"+index);
	    var groupName=document.getElementById("groupName"+index);
	    if(id.value!='' && id.value!='0'){
	       if(groupName.value==''){
	          alert('分组名称不能为空');
	          groupName.focus();
	       }
	    }
	}
	function saveData(){
	   var names=$('input[name=groupName]');
       for(var i=0;i<names.length;i++){
         if(names[i].value!=''){
         	document.groupsForm.action="/manage/activity/group/updateAcGroups.action";
			document.groupsForm.submit();
            return false;
         }
       }
       alert('请填写数据');
	}
	function delGroups(groupId,index){
    	jQuery.ajax({
            type:"POST",
            url: "/manage/activity/group/delAcGroup.action",
            data:'activityId=${activityId}&groupId='+groupId+'&t='+new Date(),
            async: true, 
            dataType:"text",
            error: function(){
                  alert("没有获取到数据...");
            },
            success: function(result){
            	if(result=="true"){
            		$('#id'+index).val(0);
            		$('#sort'+index).val('');
            		$('#groupName'+index).val('');
            		$('#del'+index).html('');
            		alert('删除成功');
            	}else{
            		alert(result);
            	}
           }}
           ); 
    }
</script>