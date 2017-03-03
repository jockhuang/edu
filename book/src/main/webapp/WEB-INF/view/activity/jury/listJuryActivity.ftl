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
	<div class="layout" style="height:480px;">
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
				<!--内容区-->
				<div class="context">
					<form name="selectForm" method="post">
						<input type="hidden" name="orgTreeId" value="${orgTreeId}"/>
						<div>
							<div style="float:left;width:200px;">
								活动名称:<input style="width:120px;" id="activityName" name="activityName" type="text" value="${activityName!''}"/>
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
							</div>
							<div style="clear:both;margin-bottom:10px;"></div>
						</div>
					</form>
				</div>
				<h3>活动管理- 列表</h3>
				<#if activitys??>
					<div class="listAction">
						<#list activitys as activity>
							<div class="topcont">
								<div class="right">
									<input class="button green" type="button" value="作品打分" id="stateButton1_${activity_index}" name="stateButton1" onclick="updateScore('${activity.activityId}');"/>
								</div>
								<a class="img" href="/activity/index.action?activityId=${activity.activityId}"><img src="http://img3.chineseall.cn/${activity.logo!''}" /></a>
								<h4><a href="/activity/index.action?activityId=${activity.activityId}">${activity.activityName}</a></h4>
								<span class="gray">状态：</span>
								<span class="yellow">
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
									 <span class="gray"> / 投稿开始时间：</span>${activity.startDate?string("yyyy年MM月dd日 ")}
									 <span class="gray"> / 投稿结束时间：</span>${activity.finishDate?string("yyyy年MM月dd日 ")} 
								</p>
								<p>
									<span class="gray">分配作品：</span>${activity.scoreWorksCount} <span class="gray">/ 待打分：</span>${activity.noScoreWorksCount} <span class="gray">/ 作品数量：</span>${activity.worksCount} <span class="gray">
								</p>
							</div>
						</#list>
					</div>
					<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
				</#if>
			</div>
			<script type="text/javascript">
			    function updateScore(activityId){
			      window.location.href='/jury/activity/works.action?activityId='+activityId;
			    }
			    function selectActivity(){
			      document.selectForm.action="/jury/activity/listJuryActivity.action";
			      document.selectForm.submit();
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