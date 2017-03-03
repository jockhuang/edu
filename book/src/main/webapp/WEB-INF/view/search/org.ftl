<!DOCTYPE html>
<html lang="en">
<head>
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/search.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>

</head>

<body>
<div class="bb1 search">
	<div class="searchBox">
		<div class="searchSearch">
			<div class="searchSearch_ipt">
			<form action="org.action" method="get">
				<input class="ipt" type="text" name="word" value="${search.word!''}"/>
				<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
		<div class="searchMenu">
			<ul>
				<li id="seatab_btn0"><a href="/search/book.action?word=${(search.word!'')?url}">图书</a></li>
				<li id="seatab_btn1"><a href="/search/audio.action?word=${(search.word!'')?url}">听书</a></li>
				<li id="seatab_btn2"><a href="/search/activity.action?word=${(search.word!'')?url}">活动</a></li>
				<li id="seatab_btn3" class="hot_a"><a href="/search/org.action?word=${(search.word!'')?url}">机构</a></li>
				<li id="seatab_btn4"><a href="/search/user.action?word=${(search.word!'')?url}">用户</a></li>
			</ul>
		</div>
	</div>
	<div id="seatab_div4">
		<div class="searchContent">
			<#if search.word?exists && search.word?length gt 0>
			<div class="h1"><big>${search.word!''}</big> 搜索<b>${search.total!'0'}</b>个</div>
			</#if>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>地区</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li <#if (!search.r?exists) || search.r?length=0>class="on"</#if>><a href="?word=${(search.word!'')?url}">全部</a></li>
							<#list search.regions as region>
								<#if region.count gt 0>
								<li <#if search.r?exists && search.r=region.id>class="on"</#if>><a href="?word=${(search.word!'')?url}&r=${region.id?url}">${region.name}</a></li>
								</#if>
							</#list>
						</ul>
					</dd>
				</dl>
								
			</div>
		</div>
		<div class="w630 right">
			<div class="title_box">
				<div class="title_box_l"><span>排序：</span>
				<a href="?word=${(search.word!'')?url}&r=${(search.r!'')?url}&s=0&t=<#if search.s=0 && search.t=1>0<#else>1</#if>" <#if search.s=0>class="on"</#if>>活跃度 <#if search.s=0><#if search.t=0>↑<#else>↓</#if></#if></a> / 
				<a href="?word=${(search.word!'')?url}&r=${(search.r!'')?url}&s=1&t=<#if search.s=1 && search.t=1>0<#else>1</#if>" <#if search.s=1>class="on"</#if>>图书数 <#if search.s=1><#if search.t=0>↑<#else>↓</#if></#if>/ 
				<a href="?word=${(search.word!'')?url}&r=${(search.r!'')?url}&s=2&t=<#if search.s=2 && search.t=1>0<#else>1</#if>" <#if search.s=2>class="on"</#if>>用户数 <#if search.s=2><#if search.t=0>↑<#else>↓</#if></#if></a></div>
			</div>
			<div class="jigou">
					<#list search.result as item>
					<div class="jigouList">
						<div class="img"><a href="http://<#if (item.cdomain?exists && item.cdomain?length gt 0)>${item.cdomain}<#else>${item.domain}/org/index.action?orgTreeId=${item.id}</#if>"><img src="http://img3.chineseall.cn${ImageUtils.getOrgLogoUrl(item.id)}" /></a>
						<span><a href="http://<#if (item.cdomain?exists && item.cdomain?length gt 0)>${item.cdomain}<#else>${item.domain}/org/index.action?orgTreeId=${item.id}</#if>">${item.name}</a></span></div>
						<div class="indexMenuList">
							<ul>
								<li class="b1">访问人次:<em>${item.pv!0}</em></li>
								<li class="b2">个人书房:<em>${item.userNum!0}</em></li>
								<li class="b3">下属组织:<em>${item.subNum!0}</em></li>
								<li class="b4">机构活动:<em>${item.activityNum!0}</em></li>
								<li class="b5">电子图书:<em>${item.bookNum!0}</em></li>
							</ul>
						</div>
					</div>
					</#list>
				</div>
				<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
				<div class="line2"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
