<!DOCTYPE html>
<html lang="en">
<head>
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/search.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>

<body>
<div class="bb1 search">
	<div class="searchBox">
		<div class="searchSearch">
			<div class="searchSearch_ipt">
			<form action="user.action" method="get">
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
				<li id="seatab_btn3"><a href="/search/org.action?word=${(search.word!'')?url}">机构</a></li>
				<li id="seatab_btn4" class="hot_a"><a href="/search/user.action?word=${(search.word!'')?url}">用户</a></li>
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
				<div class="title_box_l"><span>排序：</span><a href="?word=${(search.word!'')?url}&r=${(search.r!'')?url}&s=0&t=<#if search.t=0>1<#else>0</#if>" <#if search.s=0>class="on"</#if>>活跃度 <#if search.s=0><#if search.t=0>↑<#else>↓</#if></#if></a></div>
			</div>
			<div class="houdongContentBox">
				<div class="houdongContentBox_list">
					<#list search.result as item>
					<div class="canjiaArea">
						<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(item.id)}" />
						<span class="w">${item.name}</span>
						<p>
							<#if item.org?exists><#list item.org as org>${org!''} </#list></#if><br />
							<a href="/user/${item.id}/i.action">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="/user/${item.id}/i.action" class="a_mail">加关注</a>
							<a onclick="sendLetter(${item.id})" class="a_mail">发信</a>
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
