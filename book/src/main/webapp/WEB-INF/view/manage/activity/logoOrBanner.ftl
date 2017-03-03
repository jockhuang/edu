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
    <#if type??>
		<a href="/manage/activity/logo.action?activityId=${activityId}">活动logo</a> | <a class="hot" href="/manage/activity/logo.action?activityId=${activityId}&type=1">添加banner</a> | <a href="/manage/activity/works/listAcFriendLink.action?activityId=${activityId}">友情链接</a>
	<#else>
		<a class="hot" href="/manage/activity/logo.action?activityId=${activityId}">活动logo</a> | <a href="/manage/activity/logo.action?activityId=${activityId}&type=1">添加banner</a> | <a href="/manage/activity/works/listAcFriendLink.action?activityId=${activityId}">友情链接</a>
	</#if>
</div>
<!--内容区--> 
<div class="context">
	<form name="logoOrBannerForm" target="hiddenIframe"  method="post" enctype ="multipart/form-data">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
		<input type="hidden" name="activityId" id="activityId" value="${activityId}"/>
			<#if activity??>
				<#if type??>
					<input type="hidden" name="type" id="type" value="${type}"/>
					<#if activity.banner??>
						<input type="hidden" name="picSrc" id="picSrc" value="${activity.banner}"/>
						<tr>
							<th>当前Banner</th><td><div id="logoOrBanner"><img src="http://img3.chineseall.cn${activity.banner}" /></div>请上传600px * 180px的Banner图</td>
						</tr>
					<#else>
						<input type="hidden" name="picSrc" id="picSrc" value=""/>
						<tr>
							<th>当前Banner</th><td><div id="logoOrBanner"><img src="" /></div>请上传600px * 180px的Banner图</td>
						</tr>
					</#if>
				<#else>
					<#if activity.logo??>
						<input type="hidden" name="picSrc" id="picSrc" value="${activity.logo}"/>
						<tr>
							<th>当前Logo</th><td><div id="logoOrBanner"><img src="http://img3.chineseall.cn${activity.logo}" /></div>请上传280px * 84px的Logo图</td>
						</tr>
					<#else>
						<input type="hidden" name="picSrc" id="picSrc" value=""/>
						<tr>
							<th>当前Logo</th><td><div id="logoOrBanner"><img src="" /></div>请上传280px * 84px的Logo图</td>
						</tr>
					</#if>
				</#if>
			</#if>
			<tr>
				<th></th><td>
				<input class="file" type="file" id="picFile" name="picFile"/>
				<input class="button green" type="button" value="上传" onclick="uploadPic();"/>
				<iframe name="hiddenIframe" style="display:none;"></iframe>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="button" value="确认修改" onclick="savePic();"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	//上传文件的回调函数
    function callback(src){
       if(src!=''){
          alert('上传成功!');
	      var picFile=document.getElementById("picFile");
	      document.getElementById("picSrc").value=src;
	      var strHtml= document.getElementById("logoOrBanner").innerHTML;
	      document.getElementById("logoOrBanner").innerHTML="<img src='http://img3.chineseall.cn/"
	                  +src+"' />";
       }else{
       	  alert('上传失败,请重新操作!');
       }
    }
    function uploadPic(){
    	document.logoOrBannerForm.action="/manage/activity/add/logo.action";
    	document.logoOrBannerForm.submit();
    }
    function savePic(){
    	  document.logoOrBannerForm.action="/manage/activity/save/logo.action";
	      document.logoOrBannerForm.submit();
    }
</script>
