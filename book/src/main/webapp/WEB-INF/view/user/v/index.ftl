<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>书房首页－书香中国</title>
	<meta name="keywords" content="art,web" />
	<meta name="description" content="artWelcome" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content="artwc@foxmail.com" />
	<link rel="icon" href="favicon.ico" />
	<link rel="Shortcut Icon" href="favicon.ico" />
	<link rel="Bookmark" href="favicon.ico" />
	<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
	<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
	<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>
<body>

<#include "top.ftl" />
<div class="layout">
<#include "left.ftl" />


<div class="layoutright">
	<div class="boxr1">
		<div class="titr">
			<h2>TA最近在阅读</h2>
			<a class="more" href="/user/${visitUser.userId}/collection.action">更多&gt;&gt;</a>
		</div>
		<div class="area1">
			<#if (userIndexPageData['lastReadingBook']??)>
			<#assign lastReadingBook = userIndexPageData['lastReadingBook'] />
			<#assign book = lastReadingBook.book />
			<#assign reading = lastReadingBook.readingBook />
			<strong><a href="/book/detail.action?bookId=${book.id}" title="${book.name}" >${book.name}</a></strong>
			<dl>
				<dt>
					<a href="/book/detail.action?bookId=${book.id}" title="${book.name}">
						<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.id)}" alt="${book.name}" />
					</a>
				</dt>
				<dd>
					<span class="star"><img src="http://html.chineseall.cn/static/study/style/common/star/${book.score?default('0')?substring(0 , 1)}.png" alt="${book.score?default('0')}" /></span>
					<span class="c">
						<em title="${book.author?default('')}" >${book.author?default('&lt;暂无作者信息&gt;')}</em> 著<br />
						<em title="${book.publisher?default('')}" >${book.publisher?default('&lt;暂无出版社信息&gt;>')}</em>
					</span>
					<p></p>
				</dd>
			</dl>
			<a href="/book/read.action?bookId=${book.id}" class="btn ms">马上阅读</a>
			<#else>
			<dl>
				<dd>
					<a href="/book/room.action" target="_blank" >
						您还没在这里读过书哦~<br />
						去阅览室看看吧
					</a>
				</dd>
			</dl>
			</#if>
		</div>
	</div>
	<div class="boxr1 mt10">
		<div class="titr">
			<h2>最近来访 ${userIndexPageData['visitMyUserCount']?default(0)} 人</h2>
			<a class="more" href="/user/${visitUser.userId}/concernhere.action">更多&gt;&gt;</a>
		</div>
		<div class="iconImgList style1">
			<#if (userIndexPageData['listVisitMyUser']?? && userIndexPageData['listVisitMyUser']?size > 0) >
			<ul>
				<#list userIndexPageData['listVisitMyUser'] as u>
				<li><a href="/user/${u.userId}/i.action" title="${u.displayName?default(u.userName)}">
				<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" alt="${u.displayName?default(u.userName)}" /></a></li>
				</#list>
			</ul>
			<#else>
			还没有人访问TA的书房..
			</#if>
		</div>
	</div>
	
	
	<div class="boxr2 mt10">
		<div class="titr">
			<h2>谁在关注TA</h2>
			<a class="more" href="/user/${visitUser.userId}/concernhere.action">更多&gt;&gt;</a>
		</div>
		<div class="iconImgList style2">
		<#if (userIndexPageData['listConcernMeUser']?? && userIndexPageData['listConcernMeUser']?size > 0)>
		<ul>
			<#list userIndexPageData['listConcernMeUser'] as u>
			<li><a href="/user/${u.userId}/i.action" title="${u.displayName?default(u.userName)}">
			<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" />${textHandle.textEllipsis(u.displayName?default(u.userName) , 5)}</a></li>
			</#list>
		</ul>
		<#else>
		还没有人关注你..
		</#if>
		</div>
	</div>
	<div class="boxr2 mt10">
		<div class="titr">
			<h2>TA在关注谁</h2>
			<a class="more" href="/user/${visitUser.userId}/concern.action">更多&gt;&gt;</a>
		</div>
		<div class="iconImgList style2">
		<#if (userIndexPageData['listMeConcernUser']?? && userIndexPageData['listMeConcernUser']?size > 0)>
		<ul>
			<#list userIndexPageData['listMeConcernUser'] as u>
			<li><a href="/user/${u.userId}/i.action" title="${u.displayName?default(u.userName)}">
			<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" alt="${u.displayName?default(u.userName)}" />${textHandle.textEllipsis(u.displayName?default(u.userName) , 5)}</a></li>
			</#list>
		</ul>
		<#else>
		他还没有关注书友~
		</#if>
		</div>
	</div>
</div>
<div class="layoutcont" style="width:556px;">
	<dl class="boxc1 tabArea">
		<dt class="titc">
			<div class="tabTitTag">
				<a class="hot" href="#">TA的图书</a><a href="#">TA的图书专辑</a>
			</div>
		</dt>
		<dd>
			<div class="tabbox" style="display:block;">
				<div class="listul">
				<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
				<#list pageUtil.items as b>
				<div class="listli">
					<a class="img" href="/book/detail.action?bookId=${b.bookId}" ><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.bookId)}" /></a>
					<strong><a href="/book/detail.action?bookId=${b.bookId}" title="${b.bookName}" >${textHandle.textEllipsis(b.bookName , 8)}</a></strong>
					<span class="star s${b.score?default('0')?substring(0 , 1)}"></span>
					<span class="c">
						${b.author?default('&lt;暂无作者信息&gt;')}<br />
						${b.publisher?default('&lt;暂无作者信息&gt;')}
					</span>
				</div>
				</#list>
				<#else>
					<span style="padding:10px;display:inline-block;" >TA还没有购买图书~</span>
				</#if>
				</div>
			</div>
			<div class="tabbox">
				<div class="listul">
				<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
				<div class="bookNews" style="width:100%;">
				<#list pageUtil.items as item>
					<div class="bookJs">
						<div class="img"><a href="/eduyun/package/detail.action?id=${item.id!''}"><img src="${item.cover!''}"><span class="i">album</span></a></div>
						<h3><a href="/eduyun/package/detail.action?id=${item.id!''}">${textHandle.textEllipsis(item.name , 8)}</a></h3>
						<p><b>简介：</b>${item.intro!''}</p>
					</div>
				</#list>
				</div>
				<#else>
					<span style="padding:10px;display:inline-block;" >TA还没有购买图书专辑~</span>
				</#if>
				</div>
			</div>
		</dd>
	</dl>
	<div class="boxc1 mt10 sp">
		<div class="titc">
			<h2>TA的书评</h2>
		</div>
		<div class="con">
			<#if (userIndexPageData['listBookComment']?? && userIndexPageData['listBookComment']?size > 0)>
			<ul>
			<#list userIndexPageData['listBookComment'] as c>
			<#if (mapBook[c.bookId?string]??)>
			<#assign b = mapBook[c.bookId?string] />
			<li>
				<a class="img" href="/book/detail.action?bookId=${c.bookId}" title="${b.name}">
				<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" alt="${b.name}" /></a>
				<dl>
					<dt><a href="/book/2099" title="${b.name}">${b.name}</a> <span class="c" title="余秋雨" >作者：${b.author?default('&lt;暂无作者信息&gt;')}</span></dt>
					<dd><span>${c.submitTime?datetime}</span><p>${c.content?default('')}</p></dd>
				</dl>
			</li>
			</#if>
			</#list>
			<a class="moreLinks" href="/user/${visitUser.userId}/comment.action">显示更多书评 ↓</a>
			</ul>
			<#else>
				<span style="padding:10px;display:inline-block;">TA还未提交书评~</span>
			</#if>
		</div>
	</div>
</div>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/tab.js"></script>
<#include "../bottom.ftl" />
</body>
</html>