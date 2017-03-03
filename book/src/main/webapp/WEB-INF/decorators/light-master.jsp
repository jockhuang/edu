<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<title>
<decorator:title></decorator:title></title>
	<decorator:head></decorator:head>
</head>
<body class="login_body">
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
<div class="Mcont">
	<decorator:body />
</div>
<div class="footer">
	<div class="footMain">
		<dl>
			<dt><a href="http://www.chineseall.cn/footer/about.html">关于我们</a></dt>
			</dl>
			<dl>
				<dt><a href="http://www.chineseall.cn/footer/copyright.html">版权说明</a></dt>
			</dl>
			<dl>
				<dt><a href="http://www.chineseall.cn/footer/lineService.html">在线客服</a></dt>
			</dl>
			<dl>
				<dt><a href="http://www.chineseall.cn/footer/readme.html">常见问题</a></dt>
			</dl>
			<dl>
				<dt><a href="http://www.chineseall.cn/footer/partnership.html">商务合作</a></dt>
			</dl>
			<dl>
				<dt><a href="http://www.chineseall.cn/footer/contact.html">联系我们</a></dt>
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