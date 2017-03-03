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
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=2">下级推荐的作品</a>
	</#if>
	| <a href="/manage/activity/works/listSubRecAcWorks.action?activityId=${activityId}&type=3">本机构用户作品</a>
	| <a class="hot" href="/manage/activity/works/listScoreAcWorks.action?activityId=${activityId}&type=4">评委打分的作品</a>
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
	<form action="/manage/activity/works/listScoreAcWorks.action" method="post" name="selectWorksForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="4"/>
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
					<option value="2" <#if queryVo.scoreState==2>selected</#if>>已打分</option>
					<option value="3" <#if queryVo.scoreState==3>selected</#if>>未打分</option>
				</select>
			</div>
			<div style="float:left;width:200px;">
				评委:<input type="text" value="${queryVo.juryName!''}" name="juryName" style="width:120px;" />
			</div>
			<div style="float:left;width:200px;">
				排序:
				<select class="text" name="orderby" style="width:120px;">
					<option value="1" <#if queryVo.orderby==1>selected</#if>>按投稿时间倒序</option>
					<option value="2" <#if queryVo.orderby==2>selected</#if>>按鲜花数倒序</option>
					<option value="3" <#if queryVo.orderby==3>selected</#if>>按评委打分倒序</option>
				</select>
			</div>
			<br/><br/>
			<div style="float:left;width:200px;">
				分数段:<input type="text" value="${queryVo.lowestScore!''}" id="lowestScore" name="lowestScore" style="width:45px;" />--<input type="text" value="${queryVo.highestScore!''}" id="highestScore" name="highestScore" style="width:45px;" />
			</div>
			<div style="float:right;width:180px;">
				<input type="button" value="查 询" class="buttonmin yellow" style="cursor:pointer;" onclick="checkData();">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<div class="tableToolbar">
			<#if orgTreeId==activity.orgTreeId>
				<input class="button green" type="button" value="设为活动优秀作品" onclick="recWorks();"/>
			<#else>
				<#if orgSetting?? && orgSetting.allowRecommend==0>
				<#else>
					<input class="button green" type="button" value="推荐给上级机构" onclick="recWorks();"/>
				</#if>
			</#if>
		
	</div>
	<form name="acBookForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="4"/>
		<table width="100%" cellspacing="2" cellpadding="8" class="table">
			<tbody>
				<tr>
					<th><input type="checkbox" id="selectAll"></th><th>作品</th><th>作者</th>
					<th>机构</th><th>分组</th><th>鲜花数</th><th>评委打分</th><th></th>
				</tr>
				<#if queryVo?? && queryVo.data??>
					<#list queryVo.data as item>
						<tr class="bg1">
							<td>
								<#if item.recommendState?? && item.recommendState==0>
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
							<td>${item.score!''}
								<input type="hidden" id="juryScore${item_index}" name="juryScore" value="${item.score!''}"/>
							</td>
							<td>
								<#if item.recommendState?? && item.recommendState==1>
									已推荐
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
<div class="w310" id="juryListDiv" style="left:40%;top:50%;position:absolute;width:550px;z-index:15800;display:none;">
	<div class="indexLogin" style="width:550px;height:600px;">
			<div class="tit">
			    <ul>
					<li id="indexlogin_btn0" onClick=" tabit('indexlogin',0,2,'hot')" class="hot_a">作品打分</li>
					<li id="indexlogin_btn1" onClick=" tabit('indexlogin',0,2,'hot')" class="hot_a"></li>
				</ul>
			</div>
			<div class="con" id="indexlogin_div0">
				<form name="scoreForm" method="post" action="/manage/activity/works/recAcWorks.action">
					<input type="hidden" name="activityId" value="${activityId}"/>
					<div id="juryList">
					</div>
				</form>
			</div>
	</div>
</div>

<script type="text/javascript">
	var bodyHeight = Math.max(document.documentElement.clientHeight,document.body.offsetHeight);
	this.bgBox=document.createElement("div");
	this.bgBox.id="floatDiv"; 
	function checkData(){
       var lowestScore=document.getElementById("lowestScore");
       if(lowestScore.value!='' && (lowestScore.value>100 || lowestScore.value<0)){
          alert('请输入0-100的数字');
          return false;
       }
       var highestScore=document.getElementById("highestScore");
       if(highestScore.value!='' && (highestScore.value>100 || highestScore.value<0)){
          alert('请输入0-100的数字');
          return false;
       }
       document.selectWorksForm.submit();
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
   **推荐作品
   **/
   function recWorks(){
	      var worksIds=$('input[name=worksId]');
	      var workNames=$('input[name=worksName]');
	      var juryScore;
	      var flag=false;
	      var table='<table cellspacing=\"2\" cellpadding=\"8\" class=\"table\"><tr><th>作品名称</th><th>打分(满分100)</th></tr>';
	      var j=0;
	      for(var i=0;i<worksIds.length;i++){
	         if(worksIds[i].checked==true){
	         	j++;
	         	flag=true;
	            table +='<tr>'
	            	  +'<td align="left" style="width:270px;"><input type="hidden" name="worksId" value="'+worksIds[i].value+'"/>'
	            	  +workNames[i].value+'</td>';
	            	  juryScore=$('#juryScore'+i).val();
	            	  if(juryScore=='' || juryScore<=0){
	            	  table+='<td align="center" style="width:270px;"><input type="text" name="score" id="score'+i+'" value=""/></td>'
	            	  }else{
	            	  	table+='<td align="center" style="width:270px;">'+juryScore+'<input type="hidden" name="score" id="score'+i+'" value="'+juryScore+'"/></td>'
	            	  }
	                  table+='</tr>';
	         }
	      }
	      if(flag==true){
	      	if('${recCountLimit}'!='' && '${recCountLimit}'<j){
	      		alert("您推荐的作品已达上限,不能再推荐!");
	      		return false;
	      	}
	        table+='</table>';
	        table+='<ul><li><input type="button" value="确定推荐" class=\"login_dl\" onclick="rec();"/><a id=\"regist1\" class=\"login_zc\" href=\"javascript:void(0);gb();\">取消</a></li></ul>';
	        $('#juryList').html(table);
	        this.bgBox.style.cssText  = "position:absolute;width:100%;background:gray;z-index:9000;left:0;top:0;filter:alpha(opacity=60);opacity:0.6;height:" + bodyHeight + "px";
			document.getElementById("juryList").style.display="block";
			document.body.appendChild(this.bgBox);
            $('#juryListDiv').css({'display' : ''});
	      }else{
	      	alert('请选择要推荐的作品');
	      }
   }
   function gb(){
		document.getElementById("floatDiv").style.cssText  = "background: none;border: 0;clear: both;display: block;float: none;font-size: 0;margin: 0; padding: 0; overflow: hidden; visibility: hidden; width: 0;height: 0;";
		document.getElementById("juryListDiv").style.display="none";
	}
   function rec(){
      var scores=$('input[name=score]');
      for(var i=0;i<scores.length;i++){
         if(scores[i].value=='' || scores[i].value<=0 || scores[i].value>100){
            alert('分数必须为1-100的数字');
            return false;
         }
      }
      document.scoreForm.submit();
   }
</script>