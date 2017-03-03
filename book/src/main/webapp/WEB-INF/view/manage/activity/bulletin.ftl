<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/kindeditor/kindeditor-all.js"></script>
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
	<form name="bulletinForm" method="post">
		<table class="table" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th><span class="red">*</span>标题：</th><td>
					<input id="activityId" name="activityId" type="hidden" value="${activityId}"/>
					<#if bulletin??>
						<input id="bulletinId" name="bulletinId" type="hidden" value="${bulletin.bulletinId}"/>
						<input class="text" id="title" name="title" type="text" value="${bulletin.title}"/>
					<#else>
						<input class="text" id="title" name="title" type="text" />
					</#if>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>内容</th><td>
				<#if bulletin??>
					<textarea id="content" name="content" style="width:400px;height:300px;visibility:hidden;">${bulletin.content!''}</textarea>
				<#else>
					<textarea id="content" name="content" style="width:400px;height:300px;visibility:hidden;"></textarea>
				</#if>
				<script>
		     		var editor;
					KindEditor.ready(function(K) {
						editor = K.create('textarea[name="content"]', {
							resizeType : 1,
							width : "90%",
							uploadJson : '/editorUpload.action',
							afterBlur:function(){ 
					            this.sync(); 
					        }, 
							items : [
								'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
								'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
								'insertunorderedlist', '|', 'emoticons', 'image', 'link']
						    });
					});
		     	</script>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button yellow" type="button" value="保存" onclick="saveBulletin();"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	function saveBulletin(){
		var title = document.getElementById("title").value;
		if(title.replace(/\s+/g,"")==""){
		   alert("请输入标题！"); 
		   return false; 
	    }else if(title.replace(/\s+/g,"").length>25){
			alert("标题最多输入25个字符！");
			return false;
		}
		var content = document.getElementById("content").value;
		if(content.replace(/\s+/g,"")==""){
			alert("请输入内容！");
			return false;
		}
		var bulletinId=document.getElementById("bulletinId");
		if(bulletinId == '' || bulletinId == null){
		  document.bulletinForm.action="/manage/activity/bulletin/add.action";
		}else{
	      document.bulletinForm.action="/manage/activity/bulletin/update.action";
		}
		document.bulletinForm.submit();
	}
</script>
