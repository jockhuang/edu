<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表 
</div>
<!--内容区-->
<div class="context">
	<form name="selectForm" method="post">
		<input type="hidden" name="orgTreeId" value="${orgTreeId}"/>
		<div>
			<div style="float:left;width:200px;">
				活动名称:<input style="width:120px;" id="activityName" name="activityName" type="text" value="${activityName!''}"/>
			</div>
			<div class="cont" style="float:left;width:180px;">
				活动类型:
				<select class="text" id="activityType" name="activityType">
					<option value="0" <#if activityType?? && activityType==0> selected</#if>>不限</option>
					<option value="1" <#if activityType?? && activityType==1> selected</#if>>读书活动</option>
					<option value="3" <#if activityType?? && activityType==3> selected</#if>>摄影比赛</option>
					<option value="4" <#if activityType?? && activityType==4> selected</#if>>绘画比赛</option>
				</select>
			</div>
			<div style="float:left;width:180px;">
				进行状态:
				<select class="text" id="activityState" name="activityState">
					<option value="0" <#if activityState?? && activityState==0> selected</#if>>不限</option>
					<option value="1" <#if activityState?? && activityState==1> selected</#if>>未开始</option>
					<option value="2" <#if activityState?? && activityState==2> selected</#if>>投稿中</option>
					<option value="3" <#if activityState?? && activityState==3> selected</#if>>禁止投稿</option>
					<option value="4" <#if activityState?? && activityState==4> selected</#if>>已结束</option>
				</select>
			</div>
			<div style="float:right;width:150px;">
				<input type="button" value="搜索" class="buttonmin yellow" style="cursor:pointer;" onclick="selectActivity();">
				<input class="buttonmin yellow" style="cursor:pointer;" type="button" value="创建新的活动" onclick="createActivity();" />
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<h3>活动管理- 列表</h3>
	<#if activitys??>
		<div class="listAction">
			<#list activitys as activity>
				<div class="topcont">
					<div class="right">
						<#if '${activity.orgTreeId}' == '${orgTreeId}'>
							<#if activity.activityState == 1>
								<input class="button green" type="button" value="开始" id="stateButton1_${activity_index}" name="stateButton1" onclick="changeActivityState('${activity.activityId}','2','${activity_index}');"/>
								<input class="button" type="button" value="结束" id="stateButton2_${activity_index}" name="stateButton2" onclick="changeActivityState('${activity.activityId}','4','${activity_index}');"/>
							 <#elseif activity.activityState == 2>
								<input class="button green" type="button" value="禁止投稿" id="stateButton1_${activity_index}" name="stateButton1" onclick="changeActivityState('${activity.activityId}','3','${activity_index}');"/>
								<input class="button" type="button" value="结束" id="stateButton2_${activity_index}" name="stateButton2" onclick="changeActivityState('${activity.activityId}','4','${activity_index}');"/>
							 <#elseif activity.activityState == 3>
								<input class="button green" type="button" value="允许投稿" id="stateButton1_${activity_index}" name="stateButton1" onclick="changeActivityState('${activity.activityId}','2','${activity_index}');"/>
								<input class="button" type="button" value="结束" id="stateButton2_${activity_index}" name="stateButton2" onclick="changeActivityState('${activity.activityId}','4','${activity_index}');"/>
							 <#elseif activity.activityState == 4>
								<input class="button" type="button" value="重启开启请联系管理员"/>
							 </#if>
						 </#if>
					</div>
					<a class="img" target="_blank" href="/activity/index.action?activityId=${activity.activityId}"><img src="http://img3.chineseall.cn/${activity.logo!''}" /></a>
					<h4><a target="_blank" href="/activity/index.action?activityId=${activity.activityId}">${activity.activityName}</a></h4>
					<span class="gray">状态：</span>
					<span class="yellow" id="activityState${activity_index}">
						 <#if activity.activityState == 1>
							未开始
						 <#elseif activity.activityState == 2>
							投稿中
						 <#elseif activity.activityState == 3>
							禁止投稿
						 <#elseif activity.activityState == 4>
							活动结束
						 </#if>
					</span>
				</div>
				<div class="bottomcont">
					<input class="button blue right" type="button" value="管理" onclick="manageActivity('${activity.activityId}','${activity.orgTreeId}');"/>
					<p>
						<span class="gray">主办：</span>
						<#if activity.organizer??>
							${activity.organizer}
						</#if>
						 <span class="gray">/ 活动类型：</span> 
						 <#if activity.activityType == 1>
							读书活动
						 <#elseif activity.activityType == 2>
							读书征文
						 <#elseif activity.activityType == 3>
							摄影比赛
						 <#elseif activity.activityType == 4>
							绘画比赛
						 </#if>
						 <span class="gray"> / 开始时间：</span>${activity.startDate?string("yyyy年MM月dd日 ")}
						 <span class="gray"> / 结束时间：</span>${activity.finishDate?string("yyyy年MM月dd日 ")} 
					</p>
					<p>
						<span class="gray">推荐书目：</span>${activity.acBookCount}本 <span class="gray">/ 参与人数：</span>${activity.joinUserCount} <span class="gray">/ 作品数量：</span>${activity.worksCount} <span class="gray">
					</p>
				</div>
			</#list>
		</div>
		<div class="bottomInfo2">
			<div class="right">
				<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
			</div>
		</div>
	</#if>
</div>
<script type="text/javascript">
    function manageActivity(activityId,treeId){
      if(treeId!='${orgTreeId}'){
      	window.location.href='/manage/activity/works/listAllWorks.action?type=1&activityId='+activityId;
      }else{
      	window.location.href='/manage/activity.action?activityId='+activityId;
      }
    }
    function selectActivity(){
      document.selectForm.action="/manage/activity/list.action";
      document.selectForm.submit();
    }
    function createActivity(){
      document.selectForm.action="/manage/activity.action";
      document.selectForm.submit();
    }
    function changeActivityState(id,state,index){
    	jQuery.ajax({
            type:"POST",
            url: "/manage/activity/chanage/state.action",
            data:'activityId='+id+'&activityState='+state+'&t='+new Date(),
            async: true, 
            dataType:"html",
         	error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            success: function(result){
              if(state=="2"){
              	document.getElementById('stateButton1_'+index).onclick=function(){changeActivityState(id,'3',index);}
              	$('#stateButton1_'+index).val('禁止投稿');
              	$('#activityState'+index).html('投稿中');
              }else if(state=="3"){
              	document.getElementById('stateButton1_'+index).onclick=function(){changeActivityState(id,'2',index);}
              	$('#stateButton1_'+index).val('允许投稿');
              	$('#activityState'+index).html('禁止投稿');
              }else if(state=="4"){
              	$('#stateButton1_'+index).css('display','none');
              	$('#activityState'+index).html('活动结束');
              	$('#stateButton2_'+index).val('重启开启请联系管理员');
              }
           }}
           ); 
    }
</script>
