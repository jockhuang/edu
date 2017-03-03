<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js"></script>
</head>

<body>
<div class="topLoginBg">
	<div class="loginHead">
		<h1 class="login_logo"><a href="#">书香中国</a></h1>
		<div class="login_rightLink">
			<div class="login_topMenu"><a href="#">书香中国</a><a href="#">阅览室</a><a href="#">平台介绍</a><a href="#">如何成为用户</a></div>
			<div id="links"><strong>中文在线旗下网站</strong> <span style="display: none;"><a target="_blank" href="http://www.17k.com">17k小说网</a> <a target="_blank" href="http://www.chineseall.cn">书香中国</a> <a target="_blank" href="http://www.chineseall.org">全民阅读网</a></span></div>
			<script>
			$(function(){
			$("#links").hover(
				function(){$(this).find("span").show();},
				function(){$(this).find("span").hide();}
			);
			
			});
			</script>
		</div>
	</div>
</div>
<form action="/registers/addFriend.action" method="POST">
<div class="login">
	<div class="loginStep"><span class="s3"> </span></div>
	<div class="loginContent">
		<form>
		<dl class="dlArea">
			<dt><a class="hyh" href="">换一换</a>您可能认识的人：<span>${currentOrgTree.viewName}</span> 的朋友</dt>
			<dd class="list1">
				<ul>
					<#list userList as user>
					<li><label><img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(user.id)}" /><span>${user.displayName!''}</span><input class="cb1" type="checkbox" name="userIds" value="${user.id}" checked /></label></li>
					</#list>
				</ul>
			</dd>
		</dl>
		<div class="submitArea">
			<input name="save" type="submit" value="加为好友" />
			<input name="next" class="s2" type="submit" value="跳过，下一步" />
		</div>
		</form>
	</div>
</div>
</form>
<div class="footer">
	<div class="footMain">
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
	</div>
</div>
<script type="text/javascript">
var inputText = $(':text,password,textarea');
inputText.focus(function(){$(this).addClass('a')});
inputText.blur(function(){$(this).removeClass('a')});
</script>
</body>
</html>
