<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="http://html.chineseall.cn/static/style/manage/skin/layout.css" rel="stylesheet" />
<title>书香中国读书活动作品评选</title>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
</head>
<body>
	<div class="Mtop">
		<div class="layout">
			<div class="select">
				<span id="userInfo" style="cursor:pointer;color:white;"></span><span style="cursor:pointer;color:white;margin-left:20px;" id="logoutHref">退出</span>
			</div>
			<div class="title">
				书香中国读书活动作品评选
			</div>
		</div>
	</div>
	<div class="layout">
		<div id="Mnav">
			<dl>
				<dt>
					<span class="open"></span>作品打分
				</dt>
				<dd>
					<a href="/jury/activity/listJuryActivity.action">选择活动</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>个人信息
				</dt>
				<dd>
					<a href="/jury/activity/updatePassword.action">修改密码</a>
				</dd>
			</dl>
		</div>
		<div class="Mcont">
			<div class="crumbs">
				<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">作品打分</a> &gt; 选择活动
			</div>
			<h2 align="center">${activity.activityName!''}</h2>
			<div style="float:left;width:120px;">
				<a href="/jury/activity/works.action?activityId=${work.activityId!''}">&lt;&lt;返回作品列表</a>
			</div>
			<br/>
			<h3 align="center">${work.worksName}</h3>
			<div class="contentSelector">
				<div class="cont">
					<#if work.worksContent??>
						${work.worksContent}
					<#else>
						<img src="http://img3.chineseall.cn/${work.viewPictureUrl!''}" class="img"/></br>
						${work.description!''}
					</#if>
				</div>
				<form name="worksForm" method="post">	
					<div class="form">
						<input type="hidden" id="type" name="type" value="1">
						<input type="hidden" id="activityId" name="activityId" value="${activityId}">
						<input type="hidden" id="worksId" name="worksId" value="${work.worksId}">
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
									<th>作品打分：</th><td>${acWorksRecommend.score}
									<input type="hidden" id="score" name="score" value="${acWorksRecommend.score}">
									</td>
								</tr>
								<tr>
									<th>作品评语：</th><td>${acWorksRecommend.comment!''}</td>
								</tr>
							<#else>
								<tr>
									<th>作品打分：</th><td>
									<input type="text" id="score" name="score" value="">
									满分：100分</td>
								</tr>
								<tr>
									<th>作品评语：</th><td><textarea name="content"></textarea></td>
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
			<script type="text/javascript"> 
			   /**
			   ** 给作品打分
			   **/
			   function addAcWorksScore(){
			   		var score=document.getElementById("score");
			        if(score.value<=0 || score.value>100){
			          alert('分数必须为0-100的数字');
			          return false;
			        }
			        document.worksForm.action="/jury/activity/addAcWorksScore.action";
			        document.worksForm.submit();
			   }
			</script>
		</div>
	</div>
	<div class="footer">
		<div class="layout">
			<a href="/footer/about.html">关于我们</a> | <a
				href="/footer/copyright.html">版权声明</a> | <a
				href="/footer/lineService.html">在线客服</a> | <a
				href="/footer/help.html">常见问题</a> | <a href="/footer/readme.html">积分说明</a>
			| <a href="/footer/partnership.html">商务合作</a> | <a
				href="/footer/contact.html">联系我们</a>
		</div>
		<div class="layout">
			书香中国为中文在线旗下网站 未经许可严禁转载 <br />
			 Copyright © 2010 中文在线 版权所有
			增值电信业务经营许可证编号：沪B2-20090110
		</div>
	</div>
	<script type="text/javascript">
	    $(document).ready(function(){
	    	$("#logoutHref").click(function(){
				$.ajax({
	                url: "/logout.action",
	                async: false,
	                cache: false,
	                type: "post",
	                success: function (data) {
	                   window.location.reload();
	                }
	            });
			});
			$.ajax({
                url: "/getLoginInfo.action",
                async: true,
                cache: false,
                type: "post",
                success: function (data) {
                   if(data["result"]==1){
                   		$("#userInfo").html("欢迎你,"+data["displayName"]+"&nbsp;&nbsp;");
                   }
                }
            });
		});
	</script>
</body>
</html>