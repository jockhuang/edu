<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?7.0"></script>
<div class="Mcont">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">管理员设置</a> &gt; 修改管理员
	</div>
	<div class="context">
		<form id="updateManagerForm" action="/manage/user/updateManager.action" method="POST" >
		<input type="hidden" id="userId" name="id" value="${user.id!''}" />
			<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
				<tr>
					<th width="100"><span class="red">*</span>用户名：</th><td>
					<input class="text" id="userName" name="userName" value="${user.userName!''}" type="text" maxLength="16" />
					<span class="info"></span></td>
				</tr>
				<tr>
					<th width="100"><span class="red">*</span>密码：</th><td>
					<input class="text" id="userPass" name="userPass" value="${user.userPass!''}" type="password" maxLength="16" />
					<span class="info"></span></td>
				</tr>
				<tr>
					<th width="100"><span class="red">*</span>确认密码：</th><td>
					<input class="text" name="confirmPassword" value="${user.userPass!''}" type="password" maxLength="16" />
					<span class="info"></span></td>
				</tr>
				<tr>
					<th width="100"><span class="red"></span>姓名：</th><td>
					<input class="text" name="realName" value="${userBaseinfo.realName!''}" type="text" />
					<span class="info"></span></td>
				</tr>
				<tr>
					<th width="100"><span class="red">*</span>管理权限：</th><td>
					<#list orgTreeList as item>
						<input name="orgTreeIds" type="checkBox" value="${item.id!0}" <#list sUserList as entity><#if entity.orgTreeId=item.id>checked<#break></#if></#list>/>${item.viewName!''}
					</#list>
					<span class="info"></span></td>
				</tr>
				<tr>
					<th width="100"><span class="red"></span>账户状态：</th><td>
					<input name="userState" value="1" type="radio" checked/>正常
					<input name="userState" value="2" type="radio" <#if user.userState==2>checked</#if>/>停用
					</td>
				</tr>
				<tr>
					<th></th><td>
					<input class="button green" type="submit" value="提交" />
					<input class="button green" onClick="window.location.href='/manage/user/listManager.action'" type="button" value="返回" />
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateManagerForm").validate({
					rules:{
						userName:{
							required:true,
							rangelength:[6,16],
							remote: {
							    url: "/manage/user/checkUserName.action",
							    type: "post",
							    dataType: "json",  
							    data: {
							    	userId:function() {
							            return $("#userId").val();
							        },
							        userName: function() {
							            return $("#userName").val();
							        }
							    }
							}
						},
						userPass:{
							required:true,
							rangelength:[6,16]
						},
						confirmPassword:{
							equalTo:"#userPass"
						},
						orgTreeIds:{
							required:true
						}
					},
					messages:{
						userName:{
							required:"请输入用户名！",
							rangelength:"用户名6~16位字符！",
							remote:"该用户名已存在！"
						},
						userPass:{
							required:"请输入密码！",
							rangelength:"用户名6~16位字符！"
						},
						confirmPassword:{
							equalTo:"两次输入的密码不一致！"
						},
						orgTreeIds:{
							required:"请选择一项！"
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
</div>
</body>
</html>
