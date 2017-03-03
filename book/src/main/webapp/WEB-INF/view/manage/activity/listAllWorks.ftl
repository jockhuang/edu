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
	<a class="hot" href="/manage/activity/works/listAllWorks.action?activityId=${activityId}&type=1">所有作品</a> 
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=2">下级推荐的作品</a>
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
	<form action="/manage/activity/works/listAllWorks.action" method="post" name="selectWorksForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
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
				审核状态:
				<select class="text" name="auditState">
					<#if queryVo.auditState??>
						<option>全部</option>
						<#if queryVo.auditState==0>
							<option value="0" selected>待审核</option>
						<#else>
							<option value="0">待审核</option>
						</#if>
						<#if queryVo.auditState==1>
							<option value="1" selected>已审核</option>
						<#else>
							<option value="1">已审核</option>
						</#if>
					<#else>
						<option value="">全部</option>
						<option value="0">待审核</option>
						<option value="1">已审核</option>
					</#if>
				</select>
			</div>
			<div style="float:right;width:180px;">
				<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<div class="tableToolbar">
		<div class="rightTool">
			<input class="button blue" type="button" value="导出搜到的作品" onclick="exportWorks();"/>
		</div>
		<#if acconfig?? && acconfig.worksModule==2>
			<input class="button green" type="button" value="通过" onclick="updateAcWorksState('1','-1')"/>
			<input class="button" type="button" value="取消审核"  onclick="updateAcWorksState('0','-1')"/>
		</#if>
		<#if acconfig?? && acconfig.evaluateModule==2 && orgTreeId==activity.orgTreeId>
			<input class="button green" type="button" value="分配给评委" onclick="assignToJury();"/>
			<input class="button green" type="button" value="自动分配作品给评委" onclick="autoSetWorksJury();"/>
		</#if>
	</div>
	<form name="acWorksForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="1"/>
		<input type="hidden" id="auditState" name="auditState" value=""/>
		<input type="hidden" name="currentPage" value="${queryVo.currentPage!''}"/>
		<input type="hidden" name="juryId" id="juryId"/>
		<input type="hidden" id="auto" name="auto"/>
		<table width="100%" cellspacing="2" cellpadding="8" class="table">
			<tbody>
				<tr>
					<th><input type="checkbox" id="selectAll"></th><th>作品</th><th>作者</th>
					<th>机构</th><th>分组</th><th>状态</th><th></th>
				</tr>
				<#if queryVo?? && queryVo.data??>
					<#list queryVo.data as item>
						<tr class="bg1">
							<td>
							    <input type="hidden" name="juryIds" value="${item.juryIds!''}"/>
								<input type="checkbox" id="worksId${item_index}" name="worksId" value="${item.worksId}"/>
							</td>
							<td><a href="/manage/activity/works/getWorks.action?activityId=${activityId}&worksId=${item.worksId}">${item.worksName!''}</a></td>
							<td>${item.author!''}</td>
							<td>${item.orgTreeName!''}</td>
							<td>${item.worksGroupName!''}</td>
							<td>
								<#if item.auditState==0>
									待审核
								<#else>
									正常
								</#if>
							</td>
							<td>
								<#if item.auditState==0>
									<a href="javascript:void(0);updateAcWorksState('1','${item_index}')">通过</a>
								<#else>
									<a href="javascript:void(0);updateAcWorksState('0','${item_index}')">取消审核</a>
								</#if>
							</td>
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
<script type="text/javascript"> 
	var bodyHeight = Math.max(document.documentElement.clientHeight,document.body.offsetHeight);
	this.bgBox=document.createElement("div");
	this.bgBox.id="floatDiv";
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
   ** 审核作品
   **/
   function updateAcWorksState(auditState,index){
          document.getElementById("auditState").value=auditState;
	      if(index!='-1'){
	         document.getElementById("worksId"+index).checked=true;  
	      }
	      var worksIds=document.getElementsByName("worksId");
	      for(var i=0;i<worksIds.length;i++){
	         if(worksIds[i].checked==true){
	            document.acWorksForm.action="/manage/activity/works/updateAcWorksState.action";
	            document.acWorksForm.submit();
	            return false;
	         }
	      }
	      alert('请选择作品');
   }
   function exportWorks(){
   		window.location.href="/manage/activity/works/exportWorks.action?${queryCondition}&type=1";
		alert("ok");
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