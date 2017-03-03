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
			<form action="audio.action" method="get">
				<input type="hidden" name="queryfield" value="${search.queryfield!'0'}"/>
				<#if search.org gt 0><input type="hidden" name="org" value="${search.org}"/></#if>
				<input class="ipt" type="text" name="word" value="${search.word!''}"/>
				<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
		<div class="searchMenu">
			<ul>
				<li id="seatab_btn0"><a href="/search/book.action?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>">图书</a></li>
				<li id="seatab_btn1" class="hot_a"><a href="/search/audio.action?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>">听书</a></li>
				<li id="seatab_btn2"><a href="/search/activity.action?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>">活动</a></li>
				<li id="seatab_btn3"><a href="/search/org.action?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>">机构</a></li>
				<li id="seatab_btn4"><a href="/search/user.action?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>">用户</a></li>
			</ul>
		</div>
	</div>
	<div id="seatab_div1">
		<div class="searchContent">
			<#if search.word?exists && search.word?length gt 0>
			<div class="h1"><big>${search.word!''}</big> 搜索<b>${search.total!'0'}</b>个</div>
		</#if>
			<div class="p">
				<span>按范围 > <b><#if search.queryfield=0>全部<#elseif search.queryfield=1>作者<#elseif search.queryfield=2>书名<#elseif search.queryfield=4>朗读者</#if></b><#if search.queryfield gt 0><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=0&letter=${search.letter!''}&u0=${search.u0!''}&u1=${search.u1!''}'"><a href="">关闭</a></em></#if></span>
				<#if search.u1?exists && search.u1?length gt 0>
				|
				<span>按听书分类 > <b>${search.custommap[search.u1]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"></em></span>
				<#elseif search.u0?exists && search.u0?length gt 0>
				|
				<span>按听书分类 > <b>${search.custommap[search.u0]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"><a href="">关闭</a></em></span>
				</#if>
				<#if search.letter?exists && search.letter?length gt 0>
				|
				<span>按书名首字母 > <b>${search.letter}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&u0=${search.u0!''}&u1=${search.u1!''}'"><a href="">关闭</a></em></span>
				</#if>
			</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>搜索范围</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li <#if search.queryfield=0>class="on"</#if>><a href="?word=${search.word!''?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=0&letter=${search.letter!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜全部</a></li>
							<li <#if search.queryfield=1>class="on"</#if>><a href="?word=${search.word!''?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=1&letter=${search.letter!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜作者</a></li>
							<li <#if search.queryfield=2>class="on"</#if>><a href="?word=${search.word!''?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=2&letter=${search.letter!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜书名</a></li>
							<li <#if search.queryfield=4>class="on"</#if>><a href="?word=${search.word!''?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=4&letter=${search.letter!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜朗读者</a></li>
						</ul>
					</dd>
				</dl>
				<div class="tit">
					<h2>按听书分类</h2>
				</div>
				<div id="seafl2_div0">
					<#list search.customcat0 as item>
					<#if item.count gt 0>
					<dl <#if (search.u0?exists && search.u0=item.id)|(search.u1?exists && search.u1?index_of(item.id)=0)>class="on"</#if>>
						<dt><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&u0=${item.id!''}">${item.name!''}<em>(${item.count!'0'})</em></a>......</dt>
						<dd>
							<ul>
							<#if search.customcat1[item.id]?exists>
								<#list search.customcat1[item.id] as item1>
								<#if item1.count gt 0>
								<li <#if search.u1?exists && search.u1=item1.id>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&u0=${item.id!''}&u1=${item1.id!''}">${item1.name!''}<em>(${item1.count!'0'})</em></a></li>
								</#if>
								</#list>
							</#if>
							</ul>
						</dd>
					</dl>
					</#if>
					</#list>
				</div>
				
			</div>
		</div>
		<div class="w630 right">
			
			<div class="tingshuList">
				<div class="con">
				<#list search.result as item>
					<div class="boxListLi5">
						<div class="img"><a href="/audio/detail.action?bookId=${item.id!''}"><img src="http://img3.chineseall.cn/audio/${item.img!'/bookpic/default.jpg'}" /></a></div>
						<h2><a href="#">${item.name!''}</a></h2>
						<div class="other">作者：<span><a href="?word=${(item.author!'')?url}&queryfield=1">${item.author!''}</a></span> / 朗读：<span><a href="?word=${(item.reader!'')?url}&queryfield=4">${item.reader!''}</a></span> / 总章节：<span>${item.number!''}</span> / 总时长：<span>${item.time!''}分钟</span></div>
						<p>${item.intro!''}</p>
						<div class="tsBtn">
							<a class="video_play" href="/audio/detail.action?bookId=${item.id!''}">播放</a>
						</div>
					</div>
				</#list>
				<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
					
				</div>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>
