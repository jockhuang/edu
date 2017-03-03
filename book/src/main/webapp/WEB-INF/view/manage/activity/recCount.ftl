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
	<a class="hot" href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
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
	| <a class="hot" href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=2">下级推荐的作品</a>
	</#if>
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=3">本机构用户作品</a>
	| <a href="/manage/activity/works/listScoreAcWorks.action?activityId=${activityId}&type=4">评委打分的作品</a>
	| <a href="/manage/activity/works/listRecAcWorks.action?activityId=${activityId}&type=5">
		<#if orgTreeId==activity.orgTreeId>
			活动获奖作品
		<#else>
			已推荐给上级的作品
		</#if>
	</a>
</div>
<!--内容区-->
<div class="context">
	推荐作品数量控制
	<form method="post" name="form1">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<div>
			<div style="float:left;width:500px;">
				每个机构推荐作品数不能超过<input type="text" value="${config.recommendMaxCount!''}" id="num2" name="num2" style="width:50px;" onBlur="checkData('1');"/>篇或
				该机构投稿总数的<input type="text" value="${config.recommendPercent!''}" id="num1" name="num1" style="width:30px;" onBlur="checkData('2');"/>%。
			</div>
			<br/><br/>
			<div class="cont" style="float:left;width:200px;" >选填，不做限制的请留空。</div>
			<br/><br/>
			<div class="cont" style="float:left;width:150px;">
				<input type="button" value="确认保存" class="buttonmin yellow" style="cursor:pointer;" onclick="checkData('3');">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
</div>
<script type="text/javascript"> 
	function checkData(flag){
		if(flag=='1'){
		   document.getElementById("num1").value='';
		   var num=document.getElementById("num2");
		   if(num.value<=0 ){
		   		alert("请输入大于0的数字");
		   }
		}else if(flag=='2'){
		   document.getElementById("num2").value='';
		   var num=document.getElementById("num1");
		   if(num.value<=0 || num.value>100){
		   		alert("请输入0-100的数字");
		   }
		}else{
		    if(document.getElementById("num1").value!='' || document.getElementById("num2").value!=''){
		    	document.form1.action="/manage/activity/works/updateAcWorksRecCount.action";
        		document.form1.submit();
		    }else{
		    	alert('操作有误,请输入数据');
		    }
		}
	}
</script>