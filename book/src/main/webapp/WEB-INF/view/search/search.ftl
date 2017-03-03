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
			<form action="search.action" method="get">
				<input class="ipt" type="text" name="word" value="${search.word!''}"/>
				<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
		<div class="searchMenu">
			<ul>
				<li id="seatab_btn0" onclick=" tabit('seatab',0,5,'hot')" class="hot_a"><a href="#">图书</a></li>
				<li id="seatab_btn1" onclick=" tabit('seatab',1,5,'hot')"><a href="#">听书</a></li>
				<li id="seatab_btn2" onclick=" tabit('seatab',2,5,'hot')"><a href="#">活动</a></li>
				<li id="seatab_btn3" onclick=" tabit('seatab',3,5,'hot')"><a href="#">机构</a></li>
				<li id="seatab_btn4" onclick=" tabit('seatab',4,5,'hot')"><a href="#">用户</a></li>
			</ul>
		</div>
	</div>
	<div id="seatab_div0">
		<div class="searchContent">
		<#if search.word?exists && search.word?length gt 0>
			<div class="h1"><big>${search.word!''}</big> 搜索<b>${search.total!'0'}</b>个</div>
		</#if>
			<div class="p">
				<span>按范围 > <b><#if search.queryfield=0>全部<#elseif search.queryfield=1>作者<#elseif search.queryfield=2>书名<#elseif search.queryfield=3>出版社</#if></b><em onclick="window.location.href='?word=${search.word!''}&queryfield=0&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}'"><a href="">关闭</a></em></span>
				<#if search.u1?exists && search.u1?length gt 0>
				|
				<span>按图书分类 > <b>${search.custommap[search.u1]}</b><em onclick="window.location.href='?word=${search.word!''}&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"></em></span>
				<#elseif search.u0?exists && search.u0?length gt 0>
				|
				<span>按图书分类 > <b>${search.custommap[search.u0]}</b><em onclick="window.location.href='?word=${search.word!''}&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"><a href="">关闭</a></em></span>
				</#if>
				<#if search.c1?exists && search.c1?length gt 0>
				|
				<span>按中图法分类 > <b>${search.categorymap[search.c1]}</b><em onclick="window.location.href='?word=${search.word!''}&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"></em></span>
				<#elseif search.c0?exists && search.c0?length gt 0>
				|
				<span>按中图法分类 > <b>${search.categorymap[search.c0]}</b><em onclick="window.location.href='?word=${search.word!''}&queryfield=${search.queryfield!'0'}&letter=${search.letter!''}'"><a href="">关闭</a></em></span>
				</#if>
				<#if search.letter?exists && search.letter?length gt 0>
				|
				<span>按书名首字母 > <b>${search.letter}</b><em onclick="window.location.href='?word=${search.word!''}&queryfield=${search.queryfield!'0'}&c0=${search.c0!''}&c1=${search.c1!''}'"><a href="">关闭</a></em></span>
				</#if>
			</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>按图书分类</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li <#if search.queryfield=0>class="on"</#if>><a href="?word=${search.word!''}&queryfield=0&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜全部</a></li>
							<li <#if search.queryfield=1>class="on"</#if>><a href="?word=${search.word!''}&queryfield=1&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜作者</a></li>
							<li <#if search.queryfield=2>class="on"</#if>><a href="?word=${search.word!''}&queryfield=2&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜书名</a></li>
							<li <#if search.queryfield=3>class="on"</#if>><a href="?word=${search.word!''}&queryfield=3&letter=${search.letter!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">搜出版社</a></li>
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
					<dl class="on">
						<#list search.customcat0 as item>
						<#if item.count gt 0>
						<dt><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&u0=${item.id!''}">${item.name!''}<em>(${item.count!'0'})</em></a>......</dt>
						<dd>
							<ul>
							<#if search.customcat1[item.id]?exists>
								<#list search.customcat1[item.id] as item1>
								<#if item1.count gt 0>
								<li <#if search.u1?exists && search.u1=item1.id>class="on"</#if>><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&u1=${item1.id!''}">${item1.name!''}<em>(${item1.count!'0'})</em></a></li>
								</#if>
								</#list>
							</#if>
							</ul>
						</dd>
						</#if>
						</#list>
						
					</dl>
					
				</div>
				<div id="seafl1_div1" style="display:none;">
					<dl class="on">
						<#list search.category0 as item>
						<#if item.count gt 0>
						<dt><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&c0=${item.id!''}">${item.name!''}<em>(${item.count!'0'})</em></a>......</dt>
						<dd>
							<ul>
								<#list search.category1[item.id] as item1>
								<#if item1.count gt 0>
								<li <#if search.c1?exists && search.c1=item1.id>class="on"</#if>><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&c1=${item1.id!''}">${item1.name!''}<em>(${item1.count!'0'})</em></a></li>
								</#if>
								</#list>
							</ul>
						</dd>
						</#if>
						</#list>
					</dl>
					
				</div>
			</div>
		</div>
		<div class="w630 right">
			<div class="search_az">
				<strong>书名首字母:</strong>
				<ul>
					<li <#if (!search.letter?exists) || search.letter?length=0>class="on"</#if> style="width:40px;"><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">全部</a/></li>
					<#list search.letters as item>
					<li <#if search.letter?exists && search.letter=item>class="on"</#if>><a href="?word=${search.word!''}&queryfield=${search.queryfield!''}&letter=${item}&c0=${search.c0!''}&c1=${search.c1!''}&u0=${search.u0!''}&u1=${search.u1!''}">${item}</a/></li>
					</#list>
				</ul>
			</div>
			<div class="yuelanshiList">
				<div class="con">
					<#list search.result as item>
					<div class="boxListLi5">
						<div class="img"><a href="/book/read.action?bookId=${item.id!''}"><img src="../images/85x120.jpg" /></a></div>
						<h2><a href="/book/read.action?bookId=${item.id!''}">${item.name!''}</a></h2>
						<div class="other"><span>${item.author!''} / ${item.publisher!''} / ${item.publishDate!''} /</span><div class="xx"><span class="s2">评星</span><em>${item.score!'5.0'}</em></div></div>
						<p>${item.intro!''}</p>
						<div class="tsBtn">
							<a class="video_yd" href="/book/read.action?bookId=${item.id!''}">阅读</a>
							<a class="video_sc" href="#">收藏</a>
							<a class="video_tj" href="#">推荐</a>
						</div>
					</div>
					</#list>
					<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
				</div>
			</div>
		</div>
	</div>
	<div id="seatab_div1" style="display:none;">
		<div class="searchContent">
			<div class="h1"><big>白金数据</big> 搜索<b>12</b>个</div>
			<div class="p">
				<span>按范围 > <b><#if search.queryfield=0>全部<#elseif search.queryfield=1>作者<#elseif search.queryfield=2>书名<#elseif search.queryfield=3>出版社</#if></b><em><a href="?currentPage=${pageUtil.currentPage}&pageSize=${pageUtil.pageSize}&${queryCondition!''}&queryfield=0">关闭</a></em></span>|
				<span>按图书分类 > <b>艺术</b><em><a href="#">关闭</a></em></span>|
				<span>按书名首字母 > <b>G</b><em><a href="#">关闭</a></em></span>
			</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>按听书分类</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li <#if search.queryfield=0>class="on"</#if>><a href="?currentPage=${pageUtil.currentPage}&pageSize=${pageUtil.pageSize}&${queryCondition!''}&queryfield=0">搜全部</a></li>
							<li <#if search.queryfield=1>class="on"</#if>><a href="?currentPage=${pageUtil.currentPage}&pageSize=${pageUtil.pageSize}&${queryCondition!''}&queryfield=1">搜作者</a></li>
							<li <#if search.queryfield=2>class="on"</#if>><a href="?currentPage=${pageUtil.currentPage}&pageSize=${pageUtil.pageSize}&${queryCondition!''}&queryfield=2">搜书名</a></li>
							<li <#if search.queryfield=3>class="on"</#if>><a href="?currentPage=${pageUtil.currentPage}&pageSize=${pageUtil.pageSize}&${queryCondition!''}&queryfield=3">搜出版社</a></li>
						</ul>
					</dd>
				</dl>
				<div class="tit">
					<ul>
						<li id="seafl2_btn0" onclick=" tabit('seafl2',0,2,'hot')" class="hot_a"><span>按听书分类</span></li>
						<li id="seafl2_btn1" onclick=" tabit('seafl2',1,2,'hot')" ><span>按中图法分类</span></li>
					</ul>
				</div>
				<div id="seafl2_div0">
					<dl class="on">
						<dt>畅销・小说......</dt>
						<dd>
							<ul>
								<li><a href="#">文学理论 <em>(23)</em></a></li>
								<li><a href="#">国学<em>(6)</em></a></li>
								<li><a href="#">作品赏析<em>(2)</em></a></li>
								<li class="on"><a href="#">经典文学<em>(15)</em></a></li>
								<li><a href="#">散文随笔<em>(16)</em></a></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>儿童・文学 ......</dt>
						<dd>
							<ul>
								<li><a href="#">百科全书<em>(3)</em></a></li>
								<li><a href="#">人体<em>(5)</em></a></li>
								<li><a href="#">地理<em>(14)</em></a></li>
								<li><a href="#">自然灾害<em>(12)</em></a></li>
							</ul>
						</dd>
					</dl>
					
					
				</div>
				<div id="seafl2_div1" style="display:none;">
					<dl class="on">
						<dt>畅销・小说......</dt>
						<dd>
							<ul>
								<li><a href="#">文学理论 <em>(23)</em></a></li>
								<li><a href="#">国学<em>(6)</em></a></li>
								<li><a href="#">作品赏析<em>(2)</em></a></li>
								<li class="on"><a href="#">经典文学<em>(15)</em></a></li>
								<li><a href="#">散文随笔<em>(16)</em></a></li>
							</ul>
						</dd>
					</dl>
					
				</div>
			</div>
		</div>
		<div class="w630 right">
			<div class="search_az">
				<strong>书名首字母:</strong>
				<ul>
					<li class="on" style="width:40px;"><a href="#">全部</a/></li>
					<li><a href="#">A</a/></li>
					<li><a href="#">B</a/></li>
					<li><a href="#">C</a/></li>
					<li><a href="#">D</a/></li>
					<li class="on"><a href="#">E</a/></li>
					<li><a href="#">F</a/></li>
					<li><a href="#">G</a/></li>
					<li><a href="#">H</a/></li>
					<li><a href="#">I</a/></li>
					<li><a href="#">J</a/></li>
					<li><a href="#">K</a/></li>
					<li><a href="#">L</a/></li>
					<li><a href="#">M</a/></li>
					<li><a href="#">N</a/></li>
					<li><a href="#">O</a/></li>
					<li><a href="#">P</a/></li>
					<li><a href="#">Q</a/></li>
					<li><a href="#">R</a/></li>
					<li><a href="#">S</a/></li>
					<li><a href="#">T</a/></li>
					<li><a href="#">U</a/></li>
					<li><a href="#">V</a/></li>
					<li><a href="#">W</a/></li>
					<li><a href="#">X</a/></li>
					<li><a href="#">Y</a/></li>
					<li><a href="#">Z</a/></li>
				</ul>
			</div>
			<div class="tingshuList">
				<div class="con">
					<div class="boxListLi5">
						<div class="img"><a href="#"><img src="../images/85x120.jpg" /></a></div>
						<h2><a href="#">深夜食堂 01</a></h2>
						<div class="other">作者：<span>子金山</span> / 朗读：<span>纪涵邦</span> / 总章节：<span>30</span> / 总时长：<span>11小时55分钟</span></div>
						<p>目送共由七十四篇散文组成，是为一本极具亲情、感人至深的文集。由父亲的逝世、母亲的苍老、儿子的离开、朋友的牵挂、兄弟的携手共行，写出失败和脆弱、失落和放手，写... </p>
						<div class="tsBtn">
							<a class="video_play" href="xiangqing.html">播放</a>
							<a class="video_sc" href="#">收藏</a>
							<a class="video_tj" href="#">推荐</a>
						</div>
					</div>
					<div class="boxListLi5">
						<div class="img"><a href="#"><img src="../images/85x120.jpg" /></a></div>
						<h2><a href="#">深夜食堂 01</a></h2>
						<div class="other">作者：<span>子金山</span> / 朗读：<span>纪涵邦</span> / 总章节：<span>30</span> / 总时长：<span>11小时55分钟</span></div>
						<p>目送共由七十四篇散文组成，是为一本极具亲情、感人至深的文集。由父亲的逝世、母亲的苍老、儿子的离开、朋友的牵挂、兄弟的携手共行，写出失败和脆弱、失落和放手，写... </p>
						<div class="tsBtn">
							<a class="video_play" href="xiangqing.html">播放</a>
							<a class="video_sc" href="#">收藏</a>
							<a class="video_tj" href="#">推荐</a>
						</div>
					</div>
					
					<div class="page">page</div>
				</div>
			</div>
			
		</div>
	</div>
	<div id="seatab_div2" style="display:none;">
		<div class="searchContent">
			<div class="h1"><big>白金数据 东野圭吾</big> 搜索<b>12</b>个</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>活动状态</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li class="on"><a href="#">全部</a></li>
							<li><a href="#">已结束</a></li>
							<li><a href="#">进行中</a></li>
							<li><a href="#">评审中</a></li>
						</ul>
					</dd>
				</dl>
				<div class="tit">
					<h2>活动类型</h2>
				</div>
				<dl>
					<dd>
						<ul>
							<li class="on"><a href="#">全部</a></li>
							<li><a href="#">摄影</a></li>
							<li><a href="#">征文</a></li>
							<li><a href="#">会话</a></li>
						</ul>
					</dd>
				</dl>			
			</div>
		</div>
		<div class="w630 right">
			<div class="title_box">
				<div class="title_box_l"><a href="#" class="on">仅看活动</a> / <a href="#">仅看作品</a></div>
			</div>
			<div class="search_box3">
				<ul class="search_box3_ul">
					<li>
						<div class="hdList">
							<div class="img"><img src="../images/280x84.jpg" /></div>
							<h3><a href="#">喜看家乡新变化 我与祖国共美丽－领航杯主题读书活动</a></h3>
							<div class="time">2012年12月28日—2013年09月30日</div>
							<div class="xx">
								<span><em>类型：</em>读书征文</span>
								<span><em>作品：</em>7253 份</span>
							</div>
							<div class="text">
								<p>活动介绍：认真阅读《共筑中国梦——美丽中国幸福启航》、《党旗飘扬——党的一大到十八大》等系列图书和音像制品，了解祖国、家乡改革开放30多年所取得的伟大成就，结合阅读。</p>
							</div>
							<div class="btn"><a href="#">提交作品</a></div>
							<ul>
								<li class="b1"><a href="#">(53)</a></li>
								<li class="b2"><a href="#">(34456)</a></li>
								<li class="b3"><a href="#">(34456)</a></li>
							</ul>
						</div>
					</li>
					<li>
						<div class="hdList">
							<div class="img"><img src="../images/280x84.jpg" /></div>
							<h3><a href="#">喜看家乡新变化 我与祖国共美丽－领航杯主题读书活动</a></h3>
							<div class="time">2012年12月28日—2013年09月30日</div>
							<div class="xx">
								<span><em>类型：</em>读书征文</span>
								<span><em>作品：</em>7253 份</span>
							</div>
							<div class="text">
								<p>活动介绍：认真阅读《共筑中国梦——美丽中国幸福启航》、《党旗飘扬——党的一大到十八大》等系列图书和音像制品，了解祖国、家乡改革开放30多年所取得的伟大成就，结合阅读。</p>
							</div>
							<div class="btn"><a href="#">提交作品</a></div>
							<ul>
								<li class="b1"><a href="#">(53)</a></li>
								<li class="b2"><a href="#">(34456)</a></li>
								<li class="b3"><a href="#">(34456)</a></li>
							</ul>
						</div>
					</li>
					<li>
						<div class="hdList">
							<div class="img"><img src="../images/280x84.jpg" /></div>
							<h3><a href="#">喜看家乡新变化 我与祖国共美丽－领航杯主题读书活动</a></h3>
							<div class="time">2012年12月28日—2013年09月30日</div>
							<div class="xx">
								<span><em>类型：</em>读书征文</span>
								<span><em>作品：</em>7253 份</span>
							</div>
							<div class="text">
								<p>活动介绍：认真阅读《共筑中国梦——美丽中国幸福启航》、《党旗飘扬——党的一大到十八大》等系列图书和音像制品，了解祖国、家乡改革开放30多年所取得的伟大成就，结合阅读。</p>
							</div>
							<div class="btn"><a href="#">提交作品</a></div>
							<ul>
								<li class="b1"><a href="#">(53)</a></li>
								<li class="b2"><a href="#">(34456)</a></li>
								<li class="b3"><a href="#">(34456)</a></li>
							</ul>
						</div>
					</li>
					<li>
						<div class="hdList">
							<div class="img"><img src="../images/280x84.jpg" /></div>
							<h3><a href="#">喜看家乡新变化 我与祖国共美丽－领航杯主题读书活动</a></h3>
							<div class="time">2012年12月28日—2013年09月30日</div>
							<div class="xx">
								<span><em>类型：</em>读书征文</span>
								<span><em>作品：</em>7253 份</span>
							</div>
							<div class="text">
								<p>活动介绍：认真阅读《共筑中国梦——美丽中国幸福启航》、《党旗飘扬——党的一大到十八大》等系列图书和音像制品，了解祖国、家乡改革开放30多年所取得的伟大成就，结合阅读。</p>
							</div>
							<div class="btn"><a href="#">提交作品</a></div>
							<ul>
								<li class="b1"><a href="#">(53)</a></li>
								<li class="b2"><a href="#">(34456)</a></li>
								<li class="b3"><a href="#">(34456)</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<div class="title_box">
				<div class="title_box_l"><a href="#">仅看活动</a> / <a href="#" class="on">仅看作品</a></div>
			</div>
			<div class="search_box3">
				<ul class="search_box3_ul">
					<li>
						<div class="search_box3_li">
							<div class="huodong_list_t">
								<img class="img" src="../images/60x60.jpg" />
								<h3>热爱祖国</h3>
								<div class="pimg"><a href="#"><img src="../images/64x90.jpg" /></a></div>
								<div class="l">
									<ul>
										<li class="b3"><a href="#">分享</a></li>
										<li class="b2">434</li>
										<li class="b1">23</li>
									</ul>
								</div>
							</div>
							<div class="huodong_list_b">
								<div class="hdTextBg b3">绘画</div>
								<a href="#">喜看家乡新变化 我与祖国共美丽——领航杯主题读书活动</a>
							</div>
						</div>
					</li>
					<li>
						<div class="search_box3_li">
							<div class="huodong_list_t">
								<img class="img" src="../images/60x60.jpg" />
								<h3>热爱祖国</h3>
								<div class="pimg"><a href="#"><img src="../images/142x200.jpg" /></a></div>
								<div class="l">
									<ul>
										<li class="b3"><a href="#">分享</a></li>
										<li class="b2">434</li>
										<li class="b1">23</li>
									</ul>
								</div>
							</div>
							<div class="huodong_list_b">
								<div class="hdTextBg b2">摄影</div>
								<a href="#">喜看家乡新变化 我与祖国共美丽——领航杯主题读书活动</a>
							</div>
						</div>
					</li>
					<li>
						<div class="search_box3_li">
							<div class="huodong_list_t">
								<img class="img" src="../images/60x60.jpg" />
								<h3>热爱祖国</h3>
								<div class="pimg"><a href="#"><img src="../images/142x200.jpg" /></a></div>
								<div class="l">
									<ul>
										<li class="b3"><a href="#">分享</a></li>
										<li class="b2">434</li>
										<li class="b1">23</li>
									</ul>
								</div>
							</div>
							<div class="huodong_list_b">
								<div class="hdTextBg b2">摄影</div>
								<a href="#">喜看家乡新变化 我与祖国共美丽——领航杯主题读书活动</a>
							</div>
						</div>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
	<div id="seatab_div3" style="display:none;">
		<div class="searchContent">
			<div class="h1"><big>白金数据 东野圭吾</big> 搜索：<b>12</b>个</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>机构</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li class="on"><a href="#">全部</a></li>
							<li><a href="#">北京</a></li>
							<li><a href="#">上海</a></li>
							<li><a href="#">辽宁</a></li>
							<li><a href="#">北京</a></li>
							<li><a href="#">上海</a></li>
							<li><a href="#">辽宁</a></li>
						</ul>
					</dd>
				</dl>
								
			</div>
		</div>
		<div class="w630 right">
			<div class="title_box">
				<div class="title_box_l"><span>排序：</span><a href="#" class="on">活跃度 ↑</a> / <a href="#">图书数 / <a href="#">用户数</a></div>
			</div>
			<div class="jigou">
				<div class="jigouList">
					<div class="img"><a href="#"><img src="../images/100x100.jpg" /></a><span><a href="#">果壳网的小站</a></span></div>
					<div class="indexMenuList">
						<ul>
							<li class="b1">访问人次:<em>11610</em></li>
							<li class="b2">个人书房:<em>760</em></li>
							<li class="b3">下属组织:<em>0</em></li>
							<li class="b4">机构活动:<em>3</em></li>
							<li class="b5">电子图书:<em>104807</em></li>
						</ul>
					</div>
					<div class="hot">hot</div>
				</div>
				<div class="jigouList">
					<div class="img"><a href="#"><img src="../images/100x100.jpg" /></a><span><a href="#">果壳网的小站</a></span></div>
					<div class="indexMenuList">
						<ul>
							<li class="b1">访问人次:<em>11610</em></li>
							<li class="b2">个人书房:<em>760</em></li>
							<li class="b3">下属组织:<em>0</em></li>
							<li class="b4">机构活动:<em>3</em></li>
							<li class="b5">电子图书:<em>104807</em></li>
						</ul>
					</div>
					<div class="new">hot</div>
				</div>
				<div class="jigouList">
					<div class="img"><a href="#"><img src="../images/100x100.jpg" /></a><span><a href="#">果壳网的小站</a></span></div>
					<div class="indexMenuList">
						<ul>
							<li class="b1">访问人次:<em>11610</em></li>
							<li class="b2">个人书房:<em>760</em></li>
							<li class="b3">下属组织:<em>0</em></li>
							<li class="b4">机构活动:<em>3</em></li>
							<li class="b5">电子图书:<em>104807</em></li>
						</ul>
					</div>
				</div>
				<div class="jigouList">
					<div class="img"><a href="#"><img src="../images/100x100.jpg" /></a><span><a href="#">果壳网的小站</a></span></div>
					<div class="indexMenuList">
						<ul>
							<li class="b1">访问人次:<em>11610</em></li>
							<li class="b2">个人书房:<em>760</em></li>
							<li class="b3">下属组织:<em>0</em></li>
							<li class="b4">机构活动:<em>3</em></li>
							<li class="b5">电子图书:<em>104807</em></li>
						</ul>
					</div>
				</div>
				<div class="jigouList">
					<div class="img"><a href="#"><img src="../images/100x100.jpg" /></a><span><a href="#">果壳网的小站</a></span></div>
					<div class="indexMenuList">
						<ul>
							<li class="b1">访问人次:<em>11610</em></li>
							<li class="b2">个人书房:<em>760</em></li>
							<li class="b3">下属组织:<em>0</em></li>
							<li class="b4">机构活动:<em>3</em></li>
							<li class="b5">电子图书:<em>104807</em></li>
						</ul>
					</div>
				</div>
				
				
				
			</div>
		</div>
	</div>
	<div id="seatab_div4" style="display:none;">
		<div class="searchContent">
			<div class="h1"><big>白金数据 东野圭吾</big> 搜索<b>12</b>个</div>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>用户</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li class="on"><a href="#">全部</a></li>
							<li><a href="#">北京</a></li>
							<li><a href="#">上海</a></li>
							<li><a href="#">辽宁</a></li>
							<li><a href="#">北京</a></li>
							<li><a href="#">上海</a></li>
							<li><a href="#">辽宁</a></li>
						</ul>
					</dd>
				</dl>
								
			</div>
		</div>
		<div class="w630 right">
			<div class="title_box">
				<div class="title_box_l"><span>排序：</span><a href="#" class="on">活跃度 ↑</a></div>
			</div>
			<div class="houdongContentBox">
				<div class="houdongContentBox_list">
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="w">Rihanna</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_qx">取消关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="w">Rihanna</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_qx">取消关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
					<div class="canjiaArea">
						<img src="../images/60x60.jpg" />
						<span class="m">我是一个好人</span>
						<p>
							<a href="#">书香江苏</a> ｜ <a href="#">书香徐州</a><br />
							<a href="#">Ta的书房</a>
						</p>
						<div class="cja_btn">
							<a href="#" class="a_gz">加关注</a>
							<a href="#" class="a_mail">发信</a>
						</div>
					</div>
				</div>
				<div class="line2"></div>
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
</script>
</body>
</html>
