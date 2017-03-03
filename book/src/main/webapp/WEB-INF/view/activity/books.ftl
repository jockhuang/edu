<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>

<body>
<div class="huodong">
	<div class="bb1 huodong_left">
		<div class="huodongTitleMenu">
			<ul>
				<li class="b1"><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=0">返回首页</a></li>
				<li class="b2"><a href="/activity/index.action?activityId=${activityId}&currentPage=1">读书活动</a></li>
				<li class="b3"><a href="/activity/book.action?activityId=${activityId}&currentPage=1">活动书单</a></li>
				<li class="b4"><a href="/activity/works.action?activityId=${activityId}&orgTreeId=${orgTreeId}">作品展示</a></li>
				<li class="b5"><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=1">谁在参加</a></li>
				<li class="b6">
					<!-- Baidu Button BEGIN -->
					<div id="bdshare" class="bdshare_b"></div>
					<script type="text/javascript" id="bdshare_js" data="type=button&amp;uid=972509" ></script>
					<script type="text/javascript" id="bdshell_js"></script>
					<script type="text/javascript">
					document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
					</script>
					<!-- Baidu Button END -->
				</li>
			</ul>
			<#if activity.activityState == 2>
				<div class="btn"><a href="javascript:uploadWorks();">上传作品</a></div>
			</#if>
		</div>
		<dl class="huodongContentHd">
			<dt>
				<span class="t b1">
					<#if activity.activityType == 1>
						读书活动
					<#elseif activity.activityType == 2>
						读书征文
					<#elseif activity.activityType == 3>
						摄影比赛
					<#elseif activity.activityType == 4>
						绘画比赛
					</#if>
				</span>
				<h3><strong>${activity.activityName!''}</strong>
				<em>(
					<#if activity.activityState == 1>
						未开始
					<#elseif activity.activityState == 2>
						投稿中
					<#elseif activity.activityState == 3>
						禁止投稿
					<#elseif activity.activityState == 4>
						活动结束
					</#if>
				)</em></h3>
				${activity.startDate?string("yyyy年MM月dd日 ")}
				—${activity.finishDate?string("yyyy年MM月dd日 ")}
			</dt>
			<dd>
				<p>${activity.description!''}</p>
			</dd>
		</dl>
		<#if books??>
			<div class="houdongContentBox">
				<div class="bookList">
					<ul>
						<#list books as book>
							<li><a target="_blank" href="/book/detail.action?bookId=${book.id}"><img src="http://${imgDomainName!''}/${ImageUtils.getBookImgUrl(book.id)}" /></a></li>
						</#list>
					</ul>
				</div>
				<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
			</div>
		</#if>
	</div>
	<div class="w310 right">
		<div class="bb1 hd_zp">
			<ul>
				<li>
					<strong>参加人数</strong>
					<p><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=1">${activity.joinUserCount}</a></p>
				</li>
				<li>
					<strong class="hot">作品数</strong>
					<p><a href="/activity/works.action?activityId=${activityId}&orgTreeId=${orgTreeId}">${activity.worksCount}</a></p>
				</li>
				<li>
					<strong>活动书单</strong>
					<p><a href="/activity/book.action?activityId=${activityId}&currentPage=1">${activity.acBookCount}</a></p>
				</li>
			</ul>
		</div>
		<#if bulletins??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>活动公告</h2>
				</div>
				<div class="con gg" id="indexUserList">
					<#list bulletins as bulletin>
						<dl>
							<dt><span>${bulletin.creationTime?string("yyyy年MM月dd日 ")}</span><a href="/activity/bulletin.action?activityId=${activityId}&bulletinId=${bulletin.bulletinId}">${bulletin.title}</a></dt>
							<dd>
								<span>${bulletin.creationTime?string("yyyy年MM月dd日 ")}</span>
								<p><a href="/activity/bulletin.action?activityId=${activityId}&bulletinId=${bulletin.bulletinId}">${bulletin.content}</a></p>
							</dd>
						</dl>
					</#list>
				</div>
			</div>
		</#if>
		<#if orgs??>
			<div class="bb1 mt10 rjigou">
				<#list orgs as org>
					<#if org_index == 0>
							<div class="tit1">
								<h2>主办机构</h2>
							</div>
							<dl class="rjigou_dl line">
								<dt><a target="_blank" href="/org/index.action?orgTreeId=${org.orgTreeId}"><img src="http://${imgDomainName!''}/${ImageUtils.getOrgLogoUrl(org.orgTreeId)}" /></a></dt>
								<dd>
									<strong>${org.viewName!''}</strong>
									<p></p>
								</dd>
							</dl>
					<#else>
						<#if org_index == 1>
							<div class="tit1">
								<h2>协办机构</h2>
							</div>
							<div class="rjigou_li">
								<ul>
						</#if>
						<li><a target="_blank" href="/org/index.action?orgTreeId=${org.orgTreeId}"><img src="http://${imgDomainName!''}/${ImageUtils.getOrgLogoUrl(org.orgTreeId)}" /></a><span>${org.viewName!''}</span></li>
						<#if ((orgs?size - org_index)==1)> 
							</ul></div>
						</#if>
					</#if>
				</#list>
			</div>
		</#if>
		<#if users??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>谁在参加</h2>
					<span><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=0">查看全部&raquo;</a></span>
				</div>
				<div class="con padb10">
					<div class="indexUserList_dl">
						<#list users as user>
							<dl>
								<dt><a target="_blank" href="/user/${user.userId}/i.action"><img src="http://${imgDomainName!''}/${ImageUtils.getUserImgUrl(user.userId)}"></a></dt>
							</dl>
						</#list>
					</div>
				</div>
			</div>
		</#if>
	</div>
</div>
<#if bulletins??>
	<script src="http://html.chineseall.cn/static/script/indexUserList.js" type="text/javascript"></script>
</#if>
<script type="text/javascript">
    function uploadWorks(){
    	jQuery.ajax({
            type:"POST",
            url: "/activity/getUploadWorksLimit.action",
            data:'activityId=${activityId}&t='+new Date(),
            async: true, 
            dataType:"text",
            error: function(){
                  alert("没有获取到数据...");
            },
            success: function(result){
            	if(result=="true"){
              		window.location='/activity/upload/work.action?activityId=${activityId}';
              	}else{
              		alert('您没有该活动的参与权!!');
              	}
           }}
           ); 
    }
</script>
</body>
</html>
