<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
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
		<div class="zhengwen">
			<div class="zhengwen_path"><a href="javascript:history.back();">返回</a> | <a href="#">征文详情</a></div>
			<div class="zhengwen_tx">
				<a target="_blank" href="/user/${work.userId}/i.action"><img src="http://img3.chineseall.cn/${work.userImgUrl!''}" /></a>
				<h2>${work.worksName!''}</h2>
				<span>
					${work.createdBy!''} 
					<#if work.orgTreeName??>
						/${work.orgTreeName}
					<#else>
					    0
					</#if>
					<#if work.className??>
						/${work.className}
					</#if>
					 <br />
					${work.creationTime?string("yyyy-MM-dd  hh:mm:ss ")}
				</span>
			</div>
			<div class="zhengwenContent">
				<#if activity.activityType == 1>
					<p>${work.worksContent!''}</p>
				<#elseif activity.activityType == 2>
					<p>${work.worksContent!''}</p>
				<#elseif activity.activityType == 3>
				    <div id="xx">
						<img src="http://img3.chineseall.cn/${work.viewPictureUrl!''}"/><br/>
						${work.description!''}
					</div>
					<script type="text/javascript">
						var xx=document.getElementById("xx");
						var imgs=xx.getElementsByTagName("img");
						for (var i=0,g;g=imgs[i];i++) g.onload=function(){
							if (this.width>600){
								this.width=600
							} 
						}
					</script>
				<#elseif activity.activityType == 4>
					<div id="imgXx">
						<img src="http://img3.chineseall.cn/${work.viewPictureUrl!''}"/><br/>
						${work.description!''}
					</div>
					<script type="text/javascript">
						var xx=document.getElementById("imgXx");
						var imgs=xx.getElementsByTagName("img");
						for (var i=0,g;g=imgs[i];i++) g.onload=function(){
							if (this.width>600){
								this.width=600
							} 
						}
					</script>
				</#if>
				<div class="bottomBtn">
					<div class="fx"><!-- Baidu Button BEGIN -->
						<div id="bdshare" class="bdshare_b">分享</div>
						<script type="text/javascript" id="bdshare_js" data="type=button&amp;uid=972509" ></script>
						<script type="text/javascript" id="bdshell_js"></script>
						<script type="text/javascript">
						document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
						</script>
						<!-- Baidu Button END -->
					</div>
					<a href="javascript:sendFlower();" class="z" title="赞一个" id="flower">(${work.flowersCount})</a>
				</div>
			</div>
		</div>
		<div class="pinglun">
			<div class="huodongContent_title">
				<h2 class="s1">留言板</h2>
				<span>共
				<#if workReviewsCount??>
					${workReviewsCount}
				<#else>
				    0
				</#if>
				条留言</span>
			</div>
			<div class="pinglun_input">
				<form id="messageForm" name="messageForm" action="/activity/add/review.action" method="post">
					<textarea name="content" id="content" class="tac"></textarea>
					<input class="btn" type="button" onclick="check();" value="发 表" />
					<input type="hidden" name="activityId" value="${activityId}"/>
					<input type="hidden" name="worksId" value="${work.worksId}"/>
				</form>
			</div>
			<#if workReviews??>
				<div class="pinglun_user">
					<#list workReviews as workReview>
						<div class="huodong_list_t">
							<img src="http://img3.chineseall.cn/${workReview.userImgUrl!''}" class="img"/>
							<h3>${workReview.createdBy!''}</h3><span>${workReview.creationTime?string("yyyy-MM-dd  hh:mm:ss ")}</span>
							<div class="p">${workReview.content!''}</div>
						</div>
					</#list>
				</div>
			</#if>
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
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
		<#if flowerWorks??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>被赞最多的作品</h2>
				</div>
				<div class="con bang">
					<ul>
						<#list flowerWorks as work>
							<li><em>${work.createdBy}</em><a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">${work.worksName}(${work.flowersCount})</a></li>
						</#list>
					</ul>
				</div>
			</div>
		</#if>
		<#if reviewWorks??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>评论最多的作品</h2>
				</div>
				<div class="con bang">
					<ul>
						<#list reviewWorks as work>
							<li><em>${work.createdBy}</em><a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">${work.worksName}(${work.reviewCount})</a></li>
						</#list>
					</ul>
				</div>
			</div>
		</#if>
	</div>
</div>
<script type="text/javascript">
    function sendFlower(){
    	jQuery.ajax({
            type:"POST",
            url: "/activity/send/flower.action",
            data:'activityId=${activityId}&worksId=${work.worksId}&t='+new Date(),
            async: true, 
            dataType:"text",
            error: function(){
                  alert("没有获取到数据...");
            },
            success: function(result){
            	if(result=="请登录!!"){
              		login();
              	}else{
              		alert(result);
              		if(result=='操作成功!'){
              			$('#flower').html('(${work.flowersCount+1})');
              		}
              	}
           }}
           ); 
    }
	function check(){
		var content = document.getElementById('content').value;
		content = content.replace(/^\s+|\s+$/g,"");
		document.getElementById("content").value = content;
		if(content == null || content == ""){
			alert("留言内容不能为空！");
			return;
		}
		if(content.length > 200){
			alert("不得超过200字符！");
			return false;
		}
		if(content.length < 10){
			alert("不得小于10字符！");
			return false;
		}else{
			jQuery.ajax({
		   		type:"POST",
		   		url: "/activity/judgeKeys.action",
		   		data:'content='+encodeURI(encodeURI(content))+'&type=0',
		   		async: false, 
			    success: function(msg){
			      if(msg != "true"){
	    		     alert("你的留言内容包含有敏感词汇(\""+msg+"\"),请重新输入！");
	    		     return false;
	    		  }
			   }
			});
		}
		jQuery.ajax({
            type:"POST",
            url: "/activity/getReviewLimit.action",
            data:'activityId=${activityId}&worksId=${work.worksId}&t='+new Date(),
            async: true, 
            dataType:"text",
            error: function(){
                  alert("没有获取到数据...");
            },
            success: function(result){
              if(result=='true'){
              	document.messageForm.submit();
              }else{
              	if(result=="请登录!!"){
              		login();
              	}else{
              		alert(result);
              	}
              }
           }}
           ); 
		
	}
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
