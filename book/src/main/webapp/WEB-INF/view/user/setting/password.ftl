<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改密码_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
<#include "nav.ftl" />
	<dd class="UserSet">
		<#include "msg.ftl" />
		<form onsubmit="return checkPassword()" action="savepassword.action" method="post" >
			<table border="0" cellspacing="10" cellpadding="0">
				<tr><td>原密码：</td><td><input name="oldPassword" type="password" maxlength="16" /></td></tr>
				<tr><td>新密码：</td><td><input name="userPass" type="password" maxlength="16" onkeyup="checkPassword()" /></td></tr>
				<tr><td>确认新密码：</td><td><input id="newPassword" type="password" onkeyup="checkPassword()" maxlength="16" /><span class="red" ></span></td></tr>
				<tr><th></th><td><input class="butsub" type="image" src="http://html.chineseall.cn/static/study/style/save_but.jpg"></td></tr>
			</table>
		</form>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript">
	function checkPassword(){
		var oldPassword = document.getElementsByName('oldPassword')[0];
		var userPass = document.getElementsByName('userPass')[0];
		var newPassword = document.getElementById('newPassword');
		if(oldPassword.value.replace(/(^\s*)|(\s*$)/g, "") != ''){
			newPassword.parentNode.childNodes[1].innerHTML = '';
			if(newPassword.value.length >= 8 && newPassword.value.length <= 16){
				if(userPass.value != newPassword.value){
					newPassword.parentNode.childNodes[1].innerHTML = '&nbsp;两次输入密码不一致';
					return false;
				}
			}else{
				newPassword.parentNode.childNodes[1].innerHTML = '&nbsp;密码长度需要8-16个字符';
				return false;
			}
		}else{
			newPassword.parentNode.childNodes[1].innerHTML = '&nbsp;请填写原密码';
			return false;
		}
		return true;
	}
	$(".tit a:contains('修改密码')").attr('class' , 'hot');
</script>

<#include "../bottom.ftl" />
</body>
</html>
