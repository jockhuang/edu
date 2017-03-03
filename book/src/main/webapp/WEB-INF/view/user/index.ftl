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
	<link href="/common/layout.css" rel="stylesheet" />
	<link href="/common/yuelanshi.css" rel="stylesheet" />
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
			<h2>上次阅读</h2>
			<a class="more" href="/user/reading.action">更多&gt;&gt;</a>
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
			<#--
			<div class="bar" >
				<div><span style="width:0%;"></span></div>
				0%
			</div>
			 -->
			<p>
				读到：第<em>${reading.lastReadPage}</em>页 ${reading.firstReadTime?string("yyyy-MM-dd")}<br />
			</p>
			<a href="/book/read.action?bookId=${book.id}" target="_blank" class="btn jx">继续阅读</a>
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
			<h2>来访 ${userIndexPageData['visitMyUserCount']?default(0)} 人</h2>
			<a class="more" href="/user/visitme.action">更多&gt;&gt;</a>
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
			还没有人访问你的书房..
			</#if>
		</div>
	</div>
	
	<div class="boxr2 mt10">
		<div class="titr">
			<h2>谁在关注您</h2>
			<a class="more" href="/user/concernme.action">更多&gt;&gt;</a>
		</div>
		<div class="iconImgList style2">
		<#if (userIndexPageData['listConcernMeUser']?? && userIndexPageData['listConcernMeUser']?size > 0)>
		<ul>
			<#list userIndexPageData['listConcernMeUser'] as u>
			<li><a href="/user/${u.userId}/i.action" title="${u.displayName?default(u.userName)}">
			<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(u.userId)}" alt="${u.displayName?default(u.userName)}" />${textHandle.textEllipsis(u.displayName?default(u.userName) , 5)}</a></li>
			</#list>
		</ul>
		<#else>
		还没有人关注你..
		</#if>
		</div>
	</div>
	<script type="text/javascript" src="http://html.chineseall.cn/static/study/user_js/study.js"></script>
</div>
<div class="layoutcont" style="width:556px;">
	<dl class="boxc1 tabArea">
	<dt class="titc">
		<a href="/user/recommended.action" class="more">查看已购图书</a>
		<div class="tabTitTag">
			<a class="hot" href="/user/i.action">已购单本图书</a><a href="/user/i2.action">已购图书专辑</a>
		</div>
	</dt>
	<dd>
	<div class="tabbox" style="display:block;">
		<div class="listul">
			<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
			<#list pageUtil.items as b>
			<div class="listli">
				<a class="img" href="/book/detail.action?bookId=${b.bookId!0}" ><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.bookId!0)}" /></a>
				<strong><a href="/book/detail.action?bookId=${b.bookId!0}" title="${b.bookName}" >${textHandle.textEllipsis(b.bookName , 8)}</a></strong>
				<span class="star s${b.score?default('0')?substring(0 , 1)}"></span>
				<span class="c">
					${b.author?default('&lt;暂无作者信息&gt;')}<br />
					${b.publisher?default('&lt;暂无出版社信息&gt;')}
				</span>
			</div>
			</#list>
			<#else>
			<span style="padding:15px;display:inline-block;" >还没有购买图书~</span>
			</#if>
		</div>
	</div>
	</dd>
</dl>
		<div class="boxc1 mt10 zzfs">
			<div class="titc">
				<h2>书友动态</h2>
			</div>
			<div class="con">
				<ul id="dynamic" style="display:none;" >
					<#if (listUserPageDynamicInfo??)>
					<#list listUserPageDynamicInfo as d>
					${d[0]}
					</#list>
					</#if>
				</ul>
				<script type="text/javascript">
					function next(){
						dpage = dpage+1;
						if($('#dynamic li[p='+dpage+']').length == 0){
							$('.moreLinks').attr('href' , 'javascript:void(0);');
							$('.moreLinks').css('color' , 'gray');
						}else{
							$('#dynamic li[p='+dpage+']').css('display' , '');
						}
					}
					(function(){
						dpage = -1;
						$('#dynamic li').css('display' , 'none');
						var liarray = $('#dynamic li');
						for(i = 0 ; li = liarray[i] ; i ++){
							$(li).attr('p' , parseInt(i / 3));
						}
						$('#dynamic').css('display' , 'block');
						next();
					})();
				</script>
				<a class="moreLinks" href="javascript:next()">显示更多阅读信息▼</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

(function (){
	var userId = 2512805;
	var detail = getUserReadBookDetail(userId ,$('.bar').attr('id')) ;
	if(detail){
		$('.bar').html('<div><span style="width:' + detail.readSchedule + ';"></span></div>' + detail.readSchedule);
	}
	var dlength = $(".newsdl dd").length;
	if(dlength > 0){
		fori = 0;
		setTimeout(function(){
			$("#news").css({top: $("#news").css('height')});
			$("#news").animate({top: '0px' , opacity: 'show'}, 1000);
			
			if(dlength > 1){
				var f = function(){
					$(".newsdl dd").fadeOut(300);
					setTimeout(function(){
						if(fori >= dlength){
							fori = 0;
						}
						var tlength = 0;
						for(fori; fori < dlength ;fori++){
							tlength = tlength + $(".newsdl dd:eq(" + fori + ")").text().size();
							if(tlength <= 180){
								$(".newsdl dd:eq(" + fori + ")").fadeIn(300);
							}else{
								break;
							}
						}
					} , 350);
					setTimeout(f , 7000);	
				}
				f();
			}else{
				$(".newsdl dd").css('display' , 'block');
			}
		},3000)
	}
})();

String.prototype.size = function() {
	var chars = this.split("");
	if(chars && chars.length > 0){
		var size = 0;
		for(var i = 0 ; i < chars.length ; i ++){
			if(chars[i] != ''){
				size += (/[\u4e00-\u9fa5]/.test(chars[i])) ? 2 : 1;
			}
		}
		return size;
	}else{
		return 0;
	}
}

function newsclose(){
	$('#news').css('display' , 'none');
}

</script>
<#include "bottom.ftl" />
</body>
</html>