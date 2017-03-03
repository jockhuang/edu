<!DOCTYPE html>
<html lang="en">
<head>
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/search.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.operation.js"></script>

</head>

<body>
<div class="bb1 search">
	<div class="searchBox">
		<div class="searchSearch">
			<div class="searchSearch_ipt">
			<form action="book.action" method="get">
				<input type="hidden" name="queryfield" value="${search.queryfield!'0'}"/>
				<#if search.org gt 0><input type="hidden" name="org" value="${search.org}"/></#if>
				<input class="ipt" type="text" name="word" value="${search.word!''}"/>
				<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
	</div>
	<div id="seatab_div0">
		<div class="searchContent">
		<#if search.word?exists && search.word?length gt 0>
			<div class="h1"><big>${search.word!''}</big> 搜索<b>${search.total!'0'}</b>个</div>
		</#if>
			<div class="p">
				<span>按范围 > <b><#if search.queryfield=0>全部<#elseif search.queryfield=1>作者<#elseif search.queryfield=2>书名<#elseif search.queryfield=3>出版社<#elseif search.queryfield=5>标签</#if></b><#if search.queryfield gt 0><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=0&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}'"><a href="">关闭</a></em></#if></span>
				<#if search.u1?exists && search.u1?length gt 0>
				|
				<span>按图书分类 > <b>${search.custommap[search.u1]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"></em></span>
				<#elseif search.u0?exists && search.u0?length gt 0>
				|
				<span>按图书分类 > <b>${search.custommap[search.u0]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"><a href="">关闭</a></em></span>
				</#if>
				<#if search.c1?exists && search.c1?length gt 0>
				|
				<span>按中图法分类 > <b>${search.categorymap[search.c1]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"></em></span>
				<#elseif search.c0?exists && search.c0?length gt 0>
				|
				<span>按中图法分类 > <b>${search.categorymap[search.c0]}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"><a href="">关闭</a></em></span>
				</#if>
				<#if search.letter?exists && search.letter?length gt 0>
				|
				<span>按书名首字母 > <b>${search.letter}</b><em onclick="window.location.href='?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!'0'}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}'"><a href="">关闭</a></em></span>
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
							<li <#if search.queryfield=0>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=0&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜全部</a></li>
							<li <#if search.queryfield=1>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=1&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜作者</a></li>
							<li <#if search.queryfield=2>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=2&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜书名</a></li>
							<li <#if search.queryfield=3>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=3&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜出版社</a></li>
							<li <#if search.queryfield=5>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=5&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜标签</a></li>
						</ul>
					</dd>
				</dl>
				<div class="tit">
					<ul>
						<li id="seafl1_btn0" onclick=" tabit('seafl1',0,2,'hot')" class="hot_a"><span>按图书分类</span></li>
						<li id="seafl1_btn1" onclick=" tabit('seafl1',1,2,'hot')" ><span>按中图法分类</span></li>
					</ul>
				</div>
				<div id="seafl1_div0">
					<#list search.customcat0 as item>
					<#if item.count gt 0>
					<dl <#if (search.u0?exists && search.u0=item.id)|(search.u1?exists && search.u1?index_of(item.id)=0)>class="on"</#if>>
						<dt><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&u0=${item.id!''}">${item.name!''}<em>(${item.count!'0'})</em></a>......</dt>
						<dd>
							<ul>
							<#if search.customcat1[item.id]?exists>
								<#list search.customcat1[item.id] as item1>
								<#if item1.count gt 0>
								<li <#if search.u1?exists && search.u1=item1.id>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&u1=${item1.id!''}">${item1.name!''}<em>(${item1.count!'0'})</em></a></li>
								</#if>
								</#list>
							</#if>
							</ul>
						</dd>
					</dl>
					</#if>
					</#list>
				</div>
				<div id="seafl1_div1" style="display:none;">
					<#list search.category0 as item>
					<#if item.count gt 0>
					<dl <#if (search.c0?exists && search.c0=item.id)|(search.c1?exists && search.c1?index_of(item.id)=0) >class="on"</#if>>
						<dt><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&c0=${item.id!''}">${item.name!''}<em>(${item.count!'0'})</em></a>......</dt>
						<dd>
							<ul>
								<#list search.category1[item.id] as item1>
								<#if item1.count gt 0>
								<li <#if search.c1?exists && search.c1=item1.id>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&c1=${item1.id!''}">${item1.name!''}<em>(${item1.count!'0'})</em></a></li>
								</#if>
								</#list>
							</ul>
						</dd>
					</dl>
					</#if>
					</#list>
				</div>
			</div>
		</div>
		<div class="w630 right">
			<#if search.queryfield=5>
			<div class="tabList">
				<strong>相关标签:</strong>
				<#assign n = search.tag?size-1 />
				<#if n gt 8>
					<#assign n = 8 />
				</#if>
				<#list search.tag[0..n] as item>
					<span><a href="?word=${item.name?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=5">${item.name}</a></span>
				</#list>
			</div>
			<#else>
			<div class="search_az">
				<strong>书名首字母:</strong>
				<ul>
					<li <#if (!search.letter?exists) || search.letter?length=0>class="on"</#if> style="width:40px;"><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">全部</a/></li>
					<#list search.letters as item>
					<li <#if search.letter?exists && search.letter=item>class="on"</#if>><a href="?word=${(search.word!'')?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=${search.queryfield!''}&letter=${item}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">${item}</a/></li>
					</#list>
				</ul>
			</div>
			</#if>
			<div class="yuelanshiList">
				<div class="con tabContent">
					<#list search.result as item>
					<div class="boxListLi5">
						<div class="img"><a href="/book/detail.action?bookId=${item.id!''}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(item.id)}" /></a></div>
						<h2><a href="/book/read.action?bookId=${item.id!''}">${item.name!''}</a></h2>
						<div class="other"><span><a href="?word=${(item.author!'')?url}&queryfield=1">${item.author!''}</a> / <a href="?word=${(item.publisher!'')?url}&queryfield=3">${item.publisher!''}</a> / ${item.publishDate!''} /</span><div class="xingxing"><span class="s${item.score!'5'}">评星</span></div></div>
						<#if item.tag?exists && item.tag?size gt 0>
							<div class="other">标签:
							<#list item.tag as tag>
								<#if search.word=tag>
									<i>
									<a href="?word=${tag?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=5">${tag}</a>
									</i> 
								<#else>
									<a href="?word=${tag?url}<#if search.org gt 0>&org=${search.org}</#if>&queryfield=5">${tag}</a> 
								</#if>
							</#list>
							</div>
						</#if>
						<p>${item.intro!''}</p>
						<div class="tsBtn">
							<a class="video_yd" href="/book/detail.action?bookId=${item.id!''}"><#if buyInfos[item.id?string]??><#if buyInfos[item.id?string]==0>试读<#else>阅读</#if><#else>阅读</#if></a>
							<a class="video_sc" rel="${item.id!''}" >收藏</a>
							<a class="video_tj" href="/book/detail.action?bookId=${item.id!''}">查看详情</a>
						</div>
					</div>
					</#list>
					<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
<#if (search.c0?exists && search.c0?length gt 0)|(search.c1?exists && search.c1?length gt 0)>
tabit('seafl1',1,2,'hot');
<#else>
tabit('seafl1',0,2,'hot');
</#if>
$('.video_sc[rel],.video_tj[rel]').css({cursor:'pointer'}).bind('click' , function(){
	var bookId = this.id , className = this.className;
	if(className == 'video_sc'){
		book.operation(this.rel).collection();
	}else if(className == 'video_tj'){
		book.operation(this.rel).recommend();
	}
});

</script>
</body>
</html>
