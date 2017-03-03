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
	<form action="/manage/activity/works/listSubRecAcWorks.action" method="post" name="selectWorksForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="2"/>
		<input type="hidden" name="isOrMy" value="1"/>
		<div>
			<div style="float:left;width:200px;">
				标题:<input type="text" value="${queryVo.title!''}" name="title" style="width:120px;" />
			</div>
			<div class="cont" style="float:left;width:200px;">
				作者:<input type="text" value="${queryVo.author!''}" name="author" style="width:120px;"/>
			</div>
			<div style="float:left;width:200px;">
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
			<br/><br/>
			<div style="float:left;width:200px;">
				状态:
				<select class="text" name="scoreState" style="width:120px;">
					<option value="0">全部</option>
					<option value="1" <#if queryVo.scoreState==1>selected</#if>>已分配</option>
					<option value="4" <#if queryVo.scoreState==4>selected</#if>>未分配</option>
				</select>
			</div>
			<div style="float:left;width:200px;">
				评委:<input type="text" value="${queryVo.juryName!''}" name="juryName" style="width:120px;" />
			</div>
			<div style="float:right;width:180px;">
				<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<div class="bottomInfo2">
		<div class="right">
			<#if orgSetting??>
			  <input type="hidden" id="orgSettingId" value="${orgSetting.id!''}"/>
			  <input type="hidden" id="allow" value="${orgSetting.allowRecommend!''}"/>
			<#else>
			  <input type="hidden" id="orgSettingId" />
			  <input type="hidden" id="allow"/>
			</#if>
		    <#if orgSetting?? && orgSetting.allowRecommend==0>
		    	<input class="button green" type="button" value="允许下级推荐" onclick="updateAcOrgSetting(this);"/>
		    <#else>
		    	<input class="button green" type="button" value="禁止下级推荐" onclick="updateAcOrgSetting(this);"/>
		    </#if>
		    <#if orgTreeId==activity.orgTreeId>
				<a href="/manage/activity/works/acWorksRecCount.action?activityId=${activityId}">推荐数量控制</a>
			</#if>
		</div>
	</div>
	<div class="tableToolbar">
		<#if acconfig?? && acconfig.evaluateModule==1>
			<input class="button green" type="button" value="分配给评委" onclick="assignToJury();"/>
			<input class="button green" type="button" value="自动分配作品给评委" onclick="autoSetWorksJury();"/>
		</#if>
	</div>
	<form name="acWorksForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="currentPage" value="${queryVo.currentPage}"/>
		<input type="hidden" id="auto" name="auto"/>
		<input type="hidden" name="type" value="2"/>
		<input type="hidden" name="juryId" id="juryId"/>
		<table width="100%" cellspacing="2" cellpadding="8" class="table">
			<tbody>
				<tr>
					<th><input type="checkbox" id="selectAll"></th><th>作品</th><th>作者</th>
					<th>机构</th><th>分组</th><th>鲜花数</th><th>分配至评委</th>
				</tr>
				<#if queryVo?? && queryVo.data??>
					<#list queryVo.data as item>
						<tr class="bg1">
							<td>
								<#if item.juryName??>
								<#else>
									<input type="checkbox" id="id${item_index}" name="worksId" value="${item.worksId}"/>
								</#if>
							</td>
							<td><a href="/manage/activity/works/getWorks.action?activityId=${activityId}&worksId=${item.worksId}">${item.worksName!''}</a>
							<input type="hidden" id="worksName${item_index}" name="worksName" value="${item.worksName}"/>
							</td>
							<td>${item.author!''}</td>
							<td>${item.orgTreeName!''}</td>
							<td>${item.groupName!''}</td>
							<td>${item.flowersCount!''}</td>
							<td>${item.juryName!''}</td>
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
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<div class="w310" id="juryList" style="left:40%;top:50%;position:absolute;width:30%;z-index:15800;display:none;">
	<div class="indexLogin">
		<div class="tit">
		    <ul>
				<li id="indexlogin_btn0" onClick=" tabit('indexlogin',0,2,'hot')" class="hot_a">选择评委</li>
				<li id="indexlogin_btn1" onClick=" tabit('indexlogin',0,2,'hot')" class="hot_a"></li>
			</ul>
		</div>
		<div class="con" id="indexlogin_div0">
			<form action="/login.action" method="post">
				<input type="hidden" name="oauth_token" value="09aab022e5675775a287a4e0d73b24fc"/>
	        	<input type="hidden" name="oauth_callback" value="none"/>
	        	<input type="hidden" name="type" value="0"/>
				<div>
					<table cellspacing="2" cellpadding="8" class="table">
						<tbody>
							<tr>
							</tr>
							<#if jurys??>
								<#list jurys as jury>
									<tr>
										<td align="right" style="width:100px;">
											<input type="radio" id="juryId${jury_index}" name="juryList" value="${jury.juryId}" onclick="changeJuryId('${jury.juryId}');"/>
										</td>
										<td align="center" style="width:240px;">${jury.juryRealName!''}
										</td>
									</tr>
								</#list>
							</#if>
						</tbody>
					</table>
				</div>
	   			<ul>
					<li>
						<input type="button" value="确定" class="login_dl" onclick="setJury();">
						<a id="regist1" class="login_zc" href="javascript:void(0);gb();">取消</a>
					</li>
				</ul>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript"> 
	var bodyHeight = Math.max(document.documentElement.clientHeight,document.body.offsetHeight);
	this.bgBox=document.createElement("div");
	this.bgBox.id="floatDiv";
	function updateAcOrgSetting(obj){
	   var allow= document.getElementById("allow");
	   var id= document.getElementById("orgSettingId");
	   var url;
	   if(obj.value=='禁止下级推荐'){
      	  allow.value="0";
       }else{
      	  allow.value="1";
       }
	   if(id.value==''){
	   	 url='activityId=${activityId}&allow='+allow.value+'&t='+new Date();
	   }else{
	   	 url='activityId=${activityId}&id='+id.value+'&allow='+allow.value+'&t='+new Date();
	   }
       jQuery.ajax({
            type:"POST",
            url: "/manage/activity/works/updateRecLimit.action",
            data:url,
            async: true, 
            dataType:"text",
            error: function(){
                  alert("没有获取到数据...");
            },
            success: function(result){
              if(obj.value=='禁止下级推荐'){
              	  allow.value="0";
              	  obj.value='允许下级推荐';
              }else{
              	  allow.value="1";
              	  obj.value='禁止下级推荐';
              }
           }}
           ); 
    }
	function changeJuryId(id){
       var juryId=document.getElementById("juryId");
       juryId.value=id;
    }
    function assignToJury(){
       var juryId=document.getElementById("juryId0");
       if(juryId==null){
       	  alert('请先为活动设置评委');
          return false;
       }
       var worksIds=$('input[name=worksId]');
       for(var i=0;i<worksIds.length;i++){
         if(worksIds[i].checked==true){
			this.bgBox.style.cssText  = "position:absolute;width:100%;background:gray;z-index:9000;left:0;top:0;filter:alpha(opacity=60);opacity:0.6;height:" + bodyHeight + "px";
			document.getElementById("juryList").style.display="block";
			document.body.appendChild(this.bgBox);
            return false;
         }
       }
       alert('请选择作品');
    }
    function gb(){
		document.getElementById("floatDiv").style.cssText  = "background: none;border: 0;clear: both;display: block;float: none;font-size: 0;margin: 0; padding: 0; overflow: hidden; visibility: hidden; width: 0;height: 0;";
		document.getElementById("juryList").style.display="none";
	}
	$("#selectAll").click(function(){
		$("input[type='checkbox']").each(function(){
			if($("#selectAll").attr("checked")){
				$(this).attr("checked", true);
			}else{
				$(this).attr("checked", false);
			}
		});
	});

   /**
   **设置评委
   **/
   function setJury(){
     	document.acWorksForm.action="/manage/activity/works/addAcWorksJury.action";
        document.acWorksForm.submit();
   }
   
   /**
   **自动分配作品给评委
   **/
   function autoSetWorksJury(){
   		var juryId=document.getElementById("juryId0");
        if(juryId==null){
       	  alert('请先为活动设置评委');
          return false;
        }
        document.getElementById("auto").value="1";
     	document.acWorksForm.action="/manage/activity/works/addAcWorksJury.action";
        document.acWorksForm.submit();
   }
</script>