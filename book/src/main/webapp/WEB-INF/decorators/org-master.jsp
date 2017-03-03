<%@ taglib prefix="decorator"	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="cn.chineseall.utils.ImageUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title /></title>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<link href="/common/layout.css" rel="stylesheet"  />
<decorator:head />
</head>
<body>
<c:if test="${currentOrgTree.banner!=null && currentOrgTree.banner!=''}" var="condition" scope="request">
<%Long orgTreeId = Long.valueOf(request.getAttribute("orgTreeId").toString());%>
<style type="text/css">
body{background:url(http://img3.chineseall.cn<%=ImageUtils.getOrgBannerUrl(orgTreeId)%>) center top no-repeat;}
</style>
</c:if>
	<div class="header">
		<div class="headTop">
			<div class="headMenu">
			</div>
			<div id="headLogin" class="headLogin" style="display:none;">
			</div>
			<div class="baruser" id="loginlink" style="display:none;">
			</div>
		</div>
		<div class="headMain">
			<img src="/images/h1_banner.jpg" />
			<div class="headSearch">
			<form action="/search/book.action" method="get" id="searchForm">
			<input class="ipt" type="text" name="word" onmouseout="if(this.value=='')this.value=this.defaultValue" onmouseover="if(this.value==this.defaultValue)this.value=''" value="书名/作者名" />
			<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
		<div class="headNav">
			<ul>
				<c:if test="${appendModelList!=null}" var="condition" scope="request">
					<c:forEach var="appendModel" items="${appendModelList}" varStatus="status">  
					<li <c:if test="${status.count==1}">class="aIndex"</c:if>><a href="<c:out value='${appendModel.link}'></c:out>"><c:out value='${appendModel.name}'></c:out></a></li>
					</c:forEach>
				</c:if>
				<li style="float: right;"><a href="http://n.eduyun.cn">返回公共服务平台</a></li>
			</ul>
		</div>
		<div class="headBottom">
			<dl>
				<dt>学生</dt>
				<dd>
					<a href="/eduyun/package/detail.action?id=6">语文</a> 
					<a href="/eduyun/package/detail.action?id=17">作文</a> 
					<a href="/eduyun/package/detail.action?id=13">数学</a> 
					<a href="/eduyun/package/detail.action?id=16">英语</a> 
					<a href="/eduyun/package/detail.action?id=41">学习方法</a> 
					<a href="/eduyun/package/detail.action?id=61">心理健康</a> 
					<a href="/eduyun/package/detail.action?id=56">安全教育</a> 
					<a href="/eduyun/package/detail.action?id=26">名家书苑</a> 
					<a href="/eduyun/package/detail.action?id=25">国内经典</a>
					<a href="/eduyun/package/detail.action?id=46">国外经典</a>
				</dd>
			</dl>
			<ul>
				<li><a href="/eduyun/package/listBookPackages.action?categoryId=2">家长</a></li>
				<li><a href="/eduyun/package/listBookPackages.action?categoryId=8">老师</a></li>
				<li><a href="/eduyun/package/listBookPackages.action?categoryId=9">校长</a></li>
			</ul>
		</div>
	</div>
	<decorator:body />
	<div class="footer">
		<div class="footMain" align="center">
			<p><a href="http://html.chineseall.cn/footer/about.html">关于我们</a> | <a href="http://html.chineseall.cn/footer/copyright.html">版权声明</a> | <a href="http://html.chineseall.cn/footer/lineService.html">在线客服</a> | <a href="http://html.chineseall.cn/footer/help.html">常见问题</a> | <a href="http://html.chineseall.cn/footer/readme.html">积分说明</a> | <a href="http://html.chineseall.cn/footer/partnership.html">商务合作</a> | <a href="http://html.chineseall.cn/footer/contact.html">联系我们</a></p>
				<p style="text-align:center;">
					<br>
				</p>
				<p style="text-align:center;">
					<span style="font-size:small;">主办单位：</span><a href="http://www.eduyun.cn/" target="_blank">&nbsp;</a><span style="font-size:small;">国家教育资源公共服务平台&nbsp;</span> 
				</p>
				<p style="text-align:center;">
					<span style="font-size:small;">战略合作及运营支持：<a href="http://www.chineseall.com/" target="_blank">中文在线</a></span> 
				</p>
				<p>
					<br>
				</p>
				<p>
					<br>
				</p>
				<p style="text-align:center;">
					<br>
				</p>
		</div>
	</div>
	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F961aa2cba564c3f71bfbb0a4cf919ac9' type='text/javascript'%3E%3C/script%3E"));
		
	</script>
</body>
</html>