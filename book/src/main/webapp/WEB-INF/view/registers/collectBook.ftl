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
<form action="/registers/registerOver.action" method="POST">
<div class="login">
	<div class="loginStep"><span class="s4"> </span></div>
	<div class="loginContent">
		<form>
		<dl class="dlArea w">
			<dt><a class="hyh" href="">换一换</a>下面有你喜欢的书吗？收藏几本看看</dt>
			<dd class="list1">
				<ul class="book">
					<#list bookList as book>
					<li><label><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId)}" /><span>${book.bookName!''}</span><input class="cb1" type="checkbox" name="bookIds" value="${book.bookId}" checked/></label></li>
					</#list>
				</ul>
			</dd>
		</dl>
		<div class="submitArea">
			<input type="submit" value="收藏并完成注册" />
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
