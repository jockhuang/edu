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
			<form action="activity.action" method="get">
				<input type="hidden" name="queryfield" value="${search.queryfield!'0'}"/>
				<input class="ipt" type="text" name="word" value="${search.word!''}"/>
				<input class="btn" type="submit" value="" />
			</form>
			</div>
		</div>
		<div class="searchMenu">
			<ul>
				<li id="seatab_btn0"><a href="/search/book.action?word=${(search.word!'')?url}">图书</a></li>
				<li id="seatab_btn1"><a href="/search/audio.action?word=${(search.word!'')?url}">听书</a></li>
				<li id="seatab_btn2" class="hot_a"><a href="/search/activity.action?word=${(search.word!'')?url}">活动</a></li>
				<li id="seatab_btn3"><a href="/search/org.action?word=${(search.word!'')?url}">机构</a></li>
				<li id="seatab_btn4"><a href="/search/user.action?word=${(search.word!'')?url}">用户</a></li>
			</ul>
		</div>
	</div>
	<div id="seatab_div2">
		<div class="searchContent">
			<#if search.word?exists && search.word?length gt 0>
			<div class="h1"><big>${search.word!''}</big> 搜索<b>${search.total!'0'}</b>个</div>
			</#if>
		</div>
		<div class="w310 left">
			<div class="sideMenu">
				<div class="tit">
					<h2>活动状态</h2>
				</div>
				<dl class="on">
					<dd>
						<ul>
							<li <#if search.s=0>class="on"</#if>><a href="?word=${(search.word!'')?url}&t=${search.t!'0'}&s=0&queryfield=${search.queryfield!'0'}">全部</a></li>
							<#list status as s>
							<#if s.index gt 1>
							<li <#if s.index=search.s>class="on"</#if>><a href="?word=${(search.word!'')?url}&t=${search.t!'0'}&s=${s.index}&queryfield=${search.queryfield!'0'}">${s.title}</a></li>
							</#if>
							</#list>
						</ul>
					</dd>
				</dl>
				<div class="tit">
					<h2>活动类型</h2>
				</div>
				<dl>
					<dd>
						<ul>
							<li <#if search.t=0>class="on"</#if>><a href="?word=${(search.word!'')?url}&t=0&s=${search.s!'0'}&queryfield=${search.queryfield!'0'}">全部</a></li>
							<#list types as s>
							<#if s.index gt 0>
							<li <#if s.index=search.t>class="on"</#if>><a href="?word=${(search.word!'')?url}&t=${s.index}&s=${search.s!'0'}&queryfield=${search.queryfield!'0'}">${s.title}</a></li>
							</#if>
							</#list>
						</ul>
					</dd>
				</dl>			
			</div>
		</div>
		<div class="w630 right">
			<div class="title_box">
				<div class="title_box_l">
				<a href="?word=${(search.word!'')?url}&t=${search.t!'0'}&s=${search.s!'0'}&queryfield=0"<#if search.queryfield=0> class="on"</#if>>仅看活动</a> / 
				<a href="?word=${(search.word!'')?url}&t=${search.t!'0'}&s=${search.s!'0'}&queryfield=1"<#if search.queryfield=1> class="on"</#if>>仅看作品</a></div>
			</div>
			<div class="search_box3">
				<ul class="search_box3_ul">
					<#if search.queryfield = 0>
					<#list search.result as item>
					<li>
						<div class="hdList">
							<div class="img"><img src="http://img3.chineseall.cn${item.img!'/activityLogo/defaultsmaller.jpg'}" /></div>
							<h3><a href="/activity/index.action?activityId=${item.id}">${item.name}</a></h3>
							<div class="time">${item.startDate?date}—${item.endDate?date}</div>
							<div class="xx">
								<span><em>类型：</em>${ActivityType.getTitle(item.type)}</span>
								<span><em>作品：</em>${item.counts}份</span>
							</div>
							<div class="text">
								<p>活动介绍：${item.intro}</p>
							</div>
							<div class="btn"><a href="/activity/upload/work.action?activityId=${item.id}">提交作品</a></div>
							<!--<ul>
								<li class="b1"><a href="#">(53)</a></li>
								<li class="b2"><a href="#">(34456)</a></li>
								<li class="b3"><a href="#">(34456)</a></li>
							</ul>-->
						</div>
					</li>
					</#list>
					<#elseif search.queryfield = 1>
					<#list search.result as item>
					<li>
						<div class="search_box3_li">
							<div class="huodong_list_t">
								<img class="img" src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(item.userId)}" />
								<h3><a href="/activity/work.action?activityId=${item.activityId}&worksId=${item.id}">${item.name!''}</a></h3>
								<#if item.type = 3 || item.type=4>
								<div class="pimg"><a href="/activity/work.action?activityId=${item.activityId}&worksId=${item.id}"><img src="http://img3.chineseall.cn${item.img!''}" /></a></div>
								<#else>
								<div class="p"><a href="/activity/work.action?activityId=${item.activityId}&worksId=${item.id}">${item.intro!''}</a></div>
								</#if>
								<div class="l">
									<ul>
										<!--li class="b3"><a href="#">分享</a></li-->
										<li class="b2">${item.counts}</li>
										<li class="b1">${item.comments}</li>
									</ul>
								</div>
							</div>
							<div class="huodong_list_b">
								<div class="hdTextBg b<#if item.type=3>2<#elseif item.type=4>3<#else>1</#if>">${ActivityType.getTitle(item.type)}</div>
								<a href="/activity/index.action?activityId=${item.activityId}">${item.activityName}</a>
							</div>
						</div>
					</li>
					</#list>
					</#if>
				</ul>
				<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
			</div>
			
		</div>
	</div>
</div>	
</body>
</html>
