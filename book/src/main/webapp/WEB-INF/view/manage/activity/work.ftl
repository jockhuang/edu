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
<h3>作品选登</h3>
<div class="contentSelector">
	<div class="cont">
		<h4>${work.worksName!''}</h4>
		<#if work.worksContent??>
			<p>${work.worksContent}</p>
		<#else>
			<p><img src="http://img3.chineseall.cn/${work.viewPictureUrl!''}" class="img"/></br>
			${work.description!''}</p>
		</#if>
	</div>
	<form name="worksForm" method="post">
		<div class="form">
			<div class="tool">
				<input type="hidden" id="auditState" name="auditState">
				<input type="hidden" id="currentPage" name="currentPage" value="1">
				<input type="hidden" id="juryId" name="juryId">
				<input type="hidden" id="type" name="type" value="3">
				<input type="hidden" id="activityId" name="activityId" value="${activityId}">
				<input type="hidden" id="worksId" name="worksId" value="${work.worksId}">
				<#if work?? && work.auditState==0>
					<input class="button green" type="button" value="通过" onclick="updateAcWorksState('1',0);"/>
				</#if>
				<#if acWorksRecommend?? && acWorksRecommend.recommendState!=1>
					<#if orgTreeId !=work.orgTreeId>
						<input class="button" type="button" value="删除" onclick="delAcWorks('${work.worksId}');"/>
					</#if>
				</#if>
				<#if acWorksRecommend?? && acWorksRecommend.recommendState!=1>
					<#if orgSetting?? && orgSetting.allowRecommend==0>
					<#else>
						<input class="button yellow" type="button" value="推荐给上级" onclick="rec();"/>
					</#if>
				</#if>
				<#if acWorksRecommend?? && acWorksRecommend.juryId??>
				<#elseif acWorksRecommend??>
					<input class="button yellow" type="button" value="分配给评委" onclick="assignToJury();"/>
				</#if>
			</div>
			<table class="sub" cellpadding="8" cellspacing="0" width="100%">
				<tr>
					<th width="150">作者：</th><td>${work.createdBy!''}</td>
				</tr>
				<tr>
					<th>机构：</th><td>${work.orgTreeName!''}</td>
				</tr>
				<tr>
					<th>提交时间：</th><td>${work.creationTime?string("yyyy-MM-dd  hh:mm:ss ")}</td>
				</tr>
				<tr>
					<th>鲜花数：</th><td>${work.flowersCount!''}</td>
				</tr>
				<#if acWorksRecommend?? && acWorksRecommend.score??>
					<tr>
						<th>评委打分：</th><td>${acWorksRecommend.score}
						<input type="hidden" id="score" name="score" value="${acWorksRecommend.score}">
						</td>
					</tr>
					<tr>
						<th>评委：</th><td>
						<#if acWorksRecommend?? && acWorksRecommend.juryName??>
							${acWorksRecommend.juryName!''}
						<#elseif acWorksRecommend?? && acWorksRecommend.score??>
						          管理员
						</#if>
						</td>
					</tr>
					<tr>
						<th>评语：</th><td>${acWorksRecommend.comment!''}</td>
					</tr>
				<#else>
					<tr>
						<th>管理员打分：</th><td>
						<input type="text" id="score" name="score" value="">
						满分：100分</td>
					</tr>
					<tr>
						<th>管理员评语：</th><td><textarea name="content"></textarea></td>
					</tr>
					<tr>
						<th></th><td>
						<input class="button green" type="button" value="提交" onclick="addAcWorksScore();"/>
						</td>
					</tr>
				</#if>
			</table>
		</div>
	</form>
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
						<a id="regist1" class="login_zc" href="avascript:void(0);gb();">取消</a>
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
   /**
   ** 审核作品
   **/
   function updateAcWorksState(auditState,index){
          document.getElementById("auditState").value=auditState;
	      var worksIds=document.getElementsByName("worksIds");
          if(worksIds!=''){
            document.worksForm.action="/manage/activity/works/updateAcWorksState.action";
            document.worksForm.submit();
            return false;
          }
	      alert('您的操作有误!!');
   }
   /**
   ** 删除作品
   **/
   function delAcWorks(worksId){
      if (confirm('确认要删除该作品吗???')){
	     window.location.href='/manage/activity/works/delAcWorks.action?activityId=${activityId}&worksId='+worksId;
	  }
   }
   
   /**
   ** 给作品打分
   **/
   function addAcWorksScore(){
   		var score=document.getElementById("score");
        if(score.value<=0 || score.value>100){
          alert('分数必须为1-100的数字');
          return false;
        }
        document.worksForm.action="/manage/activity/works/addAcWorksScore.action";
        document.worksForm.submit();
   }
   
   function rec(){
   	  if('${recCountLimit}'!='' && '${recCountLimit}'<1){
      		alert("您推荐的作品已达上限,不能再推荐!");
      		return false;
      }
      var score=document.getElementById("score");
      if(score.value==''){
        alert('请打分');
        return false;
      }else if(score.value<=0 || score.value>100){
          alert('分数必须为1-100的数字');
          return false;
      }
      document.worksForm.action="/manage/activity/works/recAcWorks.action";
      document.worksForm.submit();
   }
   function assignToJury(){
        this.bgBox.style.cssText  = "position:absolute;width:100%;background:gray;z-index:9000;left:0;top:0;filter:alpha(opacity=60);opacity:0.6;height:" + bodyHeight + "px";
		document.getElementById("juryList").style.display="block";
		document.body.appendChild(this.bgBox);
    }
    function gb(){
		document.getElementById("floatDiv").style.cssText  = "background: none;border: 0;clear: both;display: block;float: none;font-size: 0;margin: 0; padding: 0; overflow: hidden; visibility: hidden; width: 0;height: 0;";
		document.getElementById("juryList").style.display="none";
	}
    function changeJuryId(id){
       var juryId=document.getElementById("juryId");
       juryId.value=id;
    }
    /**
   **设置评委
   **/
   function setJury(){
     	document.worksForm.action="/manage/activity/works/addAcWorksJury.action";
        document.worksForm.submit();
   }
</script>
