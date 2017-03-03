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
			<h2>${activity.activityName!''}</h2>
			<!--内容区-->
			<div class="context">
				<form action="/jury/activity/works.action" method="post" name="selectWorksForm">
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
							状态:
							<select class="text" name="scoreState" style="width:60px;">
								<option value="0">全部</option>
								<option value="2" <#if queryVo.scoreState==2>selected</#if>>已打分</option>
								<option value="3" <#if queryVo.scoreState==3>selected</#if>>未打分</option>
							</select>
						</div>
						<div style="float:left;width:200px;">
							排序:
							<select class="text" name="orderby" style="width:120px;">
								<option value="1" <#if queryVo.orderby==1>selected</#if>>按投稿时间倒序</option>
								<option value="2" <#if queryVo.orderby==2>selected</#if>>按鲜花数倒序</option>
								<option value="3" <#if queryVo.orderby==3>selected</#if>>按评委打分倒序</option>
							</select>
						</div>
						<div style="float:right;width:290px;">
							<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
						</div>
						<div style="clear:both;margin-bottom:10px;"></div>
					</div>
				</form>
				<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
				<form name="acBookForm" method="post">
					<input type="hidden" name="activityId" value="${activityId}"/>
					<table width="100%" cellspacing="2" cellpadding="8" class="listTable">
						<tbody>
							<tr>
								<th>作品</th><th>作者</th>
								<th>机构</th><th>分组</th><th>鲜花数</th><th>作品打分</th>
							</tr>
							<#if queryVo?? && queryVo.data??>
								<#list queryVo.data as item>
									<tr class="bg1">
										<td><a href="/jury/activity/work.action?activityId=${activityId}&worksId=${item.worksId}">${item.worksName!''}</a>
										<input type="hidden" id="worksName${item_index}" name="worksName" value="${item.worksName}"/>
										</td>
										<td>${item.author!''}</td>
										<td>${item.orgTreeName!''}</td>
										<td>${item.groupName!''}</td>
										<td>${item.flowersCount!''}</td>
										<td>${item.score!''}</td>
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
