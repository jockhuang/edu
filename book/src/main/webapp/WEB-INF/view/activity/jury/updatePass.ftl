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
				<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">个人信息</a> &gt; 修改密码
			</div>
			<br/>
			<div class="contentSelector">
				<form name="operForm" method="post">	
					<table class="sub" cellpadding="8" cellspacing="0" width="100%">
						<tr>
							<th><span class="red">*</span> 用户名：</th><td>
								<#if user??>
									<input type="hidden" id="userName" name="userName" type="text" value="${user.userName}"/>
									${user.userName}
								<#else>
									<input type="hidden" id="userName" name="userName" type="text" value="${userName!''}"/>${userName!''}
								</#if>
							</td>
						</tr>
						<tr>
							<th><span class="red">*</span> 旧密码：</th><td>
							<input class="text" id="oldPassword" name="oldPassword" type="text" />
							</td>
						</tr>
						<tr>
							<th><span class="red">*</span> 新密码：</th><td>
							<input class="text" id="newPassword" name="newPassword" type="text" />
							</td>
						</tr>
						<tr>
							<th></th>
							<td><input onClick="updatePassword();" class="button green" type="button" value="提交" /></td>
						</tr>
					</table>
				</form>
			</div>
			<script type="text/javascript"> 
			   if('${msg}'!=''){
			      alert('${msg}');
			   }
			   function updatePassword(){
			        var oldPassword=$('#oldPassword').val();
			        if(oldPassword=='' || oldPassword.length<6){
			           alert('旧密码必须大于6位');
			           return false;
			        }
			        var newPassword=$('#newPassword').val();
			        if(newPassword=='' || newPassword.length<6){
			           alert('新密码必须大于6位');
			           return false;
			        }
			   		if(confirm('确认要修改密码？')){
			   			document.operForm.action="/jury/activity/savePassword.action";
						document.operForm.submit();
					}
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