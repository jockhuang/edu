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
		<a class="hot"  href="/manage/activity/logo.action?activityId=${activityId}">页面管理</a>
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
	<a href="/manage/activity/logo.action?activityId=${activityId}">活动logo</a> | <a href="/manage/activity/logo.action?activityId=${activityId}&type=1">添加banner</a> | <a class="hot" href="/manage/activity/works/listAcFriendLink.action?activityId=${activityId}">友情链接</a>
</div>
<!--内容区-->
<div class="context">
	<form name="friendsForm" method="post" enctype ="multipart/form-data">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table cellspacing="2" cellpadding="8" class="table">
			<tr>
				<th>排序</th><th>链接名称</th><th>图片地址</th><th>链接地址</th>
			</tr>
			<#if friends??>
				<#list friends as friend>
					<tr class="bg1">
						<td>
							<input type="hidden" id="id${friend_index}" name="id" value="${friend.id!''}"/>
							<input type="text" style="width:30px;" id="sort${friend_index}" name="sort" value="${friend.sort!''}" onBlur="checkData('${friend_index}',this);"/>
						</td>
						<td><input type="text" style="width:80px;" id="friendName${friend_index}" name="friendName" value="${friend.name!''}" onBlur="checkData('${friend_index}',this);"/>
						</td>
						<td>
						<input type="hidden" id="imgUrl${friend_index}" name="imgUrl" value="${friend.imgUrl!''}"/>
						<input type="file" style="width:320px;" id="linkFile${friend_index}" name="linkFile" onBlur="checkData('${friend_index}',this);"/>
						</td>
						<td><input type="text" style="width:160px;" id="url${friend_index}" name="url" value="${friend.url!''}" onBlur="checkData('${friend_index}',this);"/></td>
					</tr>
				</#list>
			</#if>
			<tr>
				<th></th><td colspan="3">
				<input class="button green" type="button" value="保存修改" onclick="saveData();"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	function checkData(index,object){
	    var friendName=document.getElementById("friendName"+index);
	    var imgUrl=document.getElementById("imgUrl"+index);
	    var url=document.getElementById("url"+index);
	    if(object.value!='' || imgUrl.value!='' || url.value!=''){
	       if(friendName.value==''){
	          alert('链接名称不能为空');
	          friendName.focus();
	       }
	    }
	}
	function saveData(){
	   var names=$('input[name=friendName]');
       for(var i=0;i<names.length;i++){
         if(names[i].value!=''){
         	document.friendsForm.action="/manage/activity/works/updateAcFriendLink.action";
			document.friendsForm.submit();
            return false;
         }
       }
       alert('请填写数据');
	}
</script>