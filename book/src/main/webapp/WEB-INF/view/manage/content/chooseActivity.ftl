<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.2"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; <a href="">活动推荐</a> &gt; <a href="">添加</a> &gt; 选用
</div>
<div class="context">
	<div class="listAction">
		<div class="topcont">
			<a class="img" href=""><img src="http://img3.chineseall.cn${acBaseinfo.logo!''}" /></a>
			<h4><#if acBaseinfo.activityName?length &lt; 25> ${acBaseinfo.activityName} <#else> ${acBaseinfo.activityName?substring(0,25)}... </#if></h4>
			<span class="gray">状态：</span><span class="yellow">
				<#if acBaseinfo.activityState??>
					<#if acBaseinfo.activityState==1>
						未开始
					<#elseif acBaseinfo.activityState==2>
						投稿中
					<#elseif acBaseinfo.activityState==3>
						禁止投稿
					<#elseif acBaseinfo.activityState==4>
						已结束
					<#else>
						未开始
					</#if>
				<#else>
					未开始
				</#if>
			</span>
		</div>
		<div class="bottomcont">
			<p>
				<span class="gray">主办：</span>${acBaseinfo.organizer!'未填写'} <span class="gray">/ 活动类型：</span>
				<#if acBaseinfo.activityType??>
					<#if acBaseinfo.activityType==1>
						读书活动
					<#elseif acBaseinfo.activityType==2>
						读书征文
					<#elseif acBaseinfo.activityType==3>
						摄影比赛
					<#elseif acBaseinfo.activityType==4>
						绘画比赛
					<#else>
						未填写
					</#if>
				<#else>
					未填写
				</#if>
				<span class="gray"> / 开始时间：</span><#if acBaseinfo.startDate??>${acBaseinfo.startDate?date}</#if><span class="gray"> / 结束时间：</span><#if acBaseinfo.finishDate??>${acBaseinfo.finishDate?date}</#if>
			</p>
			<p>
				<span class="gray">推荐书目：</span>${acBaseinfo.acBookCount!0}本 <span class="gray">/ 参与人数：</span>${acBaseinfo.joinUserCount!0} <span class="gray">/ 作品数量：</span>${acBaseinfo.worksCount!0} <span class="gray">
			</p>
		</div>
	</div>
	<br/><br/>
	<form id="operForm" action="/manage/content/addActivityRecommend.action" method="POST">
		<input type="hidden" name="acId" value="${acBaseinfo.activityId!''}"/>
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="100"><span class="red">*</span>活动名称：</th><td>
				<input class="text" id="name" name="name" value="${acBaseinfo.activityName!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>主办机构：</th><td>
				<input class="text" id="directName" name="directName" value="${acBaseinfo.organizer!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>活动简介：</th><td>
				<textarea class="textarea" name="description">${acBaseinfo.description!''}</textarea>
				<span class="info"></span></td>
			</tr>
			<tr>
				<th>当前LOGO：</th><td><img id="showImg" src="${acBaseinfo.logo!''}" /></th>
			</tr>
			<tr>
				<th></th><td>
				<input type="hidden" id="logo" name="logo" value="${acBaseinfo.logo!''}"/>
				<iframe src="/manage/content/showUploadBookImg.action" frameborder="0" width="400px" height="35px"></iframe>
				<span class="info">建议尺寸：280px * 84px</span>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="submit" value="提交" />
				<input class="button yellow" type="reset" value="重置" />
				<input onClick="window.location.href='/manage/content/showAddActivityRecommend.action?currentPage=${currentPage!1}'" class="button yellow" type="button" value="返回" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function setImg(url){
			$("#showImg").attr("src",url);
			$("#logo").val(url.substr(25,url.length));
		}
		$(document).ready(function(){
			$("#operForm").validate({
				rules:{
					name:{
						required:true
					},
					directName:{
						required:true
					},
					description:{
						required:true
					}
				},
				messages:{
					name:{
						required:"请输入活动名称！"
					},
					directName:{
						required:"请输入主办机构！"
					},
					description:{
						required:"请输入活动简介！"
					}
				},
				errorPlacement: function(error, element) {
					error.css("color","red");
				    error.appendTo(element.parent().find("span"));
				}
			});
		})
	</script>
</div>
</body>
</html>
