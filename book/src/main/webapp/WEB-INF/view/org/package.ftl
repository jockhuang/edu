<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/style.css" rel="stylesheet" />
<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/script/js.js"></script>
<script type="text/javascript" src="/script/tab.js"></script>
<script type="text/javascript" src="/script/vote.js"></script>
<script type="text/javascript" src="/script/ScrollPic.js"></script>
</head>

<body>
<div class="layout mtb10">
	<div class="w310 left" id="nav_left_layout">
		<div class="sideMenuLeft">
			<#list categorieList as categorie>
			<dl class="xx">
				<#assign i = 1>
				<#list categorie.subCategory as subCategory>
					<#if subCategory.id == categoryId>
						<#assign i = 0>
					</#if>
				</#list>
				<dt <#if i=0>class="on" rel="true"<#else>rel="false"</#if>>${categorie.category.name!''}</dt>
				<dd>
					<ul>
						<#list categorie.subCategory as subCategory>
						<li><a href="/eduyun/package/listBookPackages.action?categoryId=${subCategory.id!0}">${subCategory.name!''}</a></li>
						</#list>
					</ul>
				</dd>
			</dl>
			</#list>
		</div>
		
		<script type="text/javascript" src="/script/sideMenu.js"></script>
		<script type="text/javascript"> 
		$.fn.smartFloat = function() {
			var position = function(element) {
				var top = element.position().top, pos = element.css("position");
				$(window).scroll(function() {
					var scrolls = $(this).scrollTop();
					if (scrolls > top) {
						if (window.XMLHttpRequest) {
							element.css({
								position: "fixed",
								top: 0
							});	
						} else {
							element.css({
								top: scrolls
							});	
						}
					}else {
						element.css({
							position: pos,
							top: top
						});	
					}
				});
		};
			return $(this).each(function() {
				position($(this));						 
			});
		};
		//绑定
		$("#nav_left_layout").smartFloat();
		</script>
	</div>
	<div class="w630 right">
		<#assign i = 0>
		<#if bookPackages??>
		<#list bookPackages?keys as key>
		<div class="bb1 bstyle2">
			<div class="tit1">
				<h2>${key}</h2>
				<!--span><a href="#">查看更多专辑&raquo;</a></span-->
			</div>
			<div class="con">
				<div class="bookList5">
					<#list bookPackages[key] as bookPack>
					<#assign i = i+1>
					<div class="bookList5_box">
						<div class="bookList5_book">
							<a href="/eduyun/package/detail.action?id=${bookPack.package.id!''}"><img src="${bookPack.package.cover!''}" /></a>
							<h2><a href="/eduyun/package/detail.action?id=${bookPack.package.id!''}">${bookPack.package.name!''}</a></h2>
							<span>图书数量：#{bookPack.bookCount!0}</span>
							<span>图书售价：#{(bookPack.package.price/100);m0}云币</span>
							<p>${bookPack.package.intro!''}</p>
							<div class="tsBtn">
								<#if (bookPack.buy!0)==0><a class="video_gm" href="/edushopcart/addShopCart.action?packageId=${bookPack['package']['id']!''}" target='_blank'>购买专辑 </a></#if>
								<#if (bookPack.buy!0)==1><a class="video_no" href="javascript:void(0);">已购买</a></#if>
								<#if (bookPack.buy!0)==2><a class="video_gm" href="/user/listMyOrders.action" target='_blank'>去支付</a></#if>
							</div>
						</div>
						<div class="bookList5_ScrollPic">
							<h2>重点书推荐</h2>
							<ul id="ISL_Cont_${i}">
								<#list bookPack.bookList as book>
								<li><a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a></li>
								</#list>
							</ul>
							<div class="LeftBotton" id="LeftArr${i}">left</div>
							<div class="RightBotton" id="RightArr${i}">right</div>
							<script type="text/javascript">
								var scrollPic_01 = new ScrollPic();
									scrollPic_01.scrollContId   = "ISL_Cont_${i}";
									scrollPic_01.arrLeftId      = "LeftArr${i}";
									scrollPic_01.arrRightId     = "RightArr${i}";
							
									scrollPic_01.frameWidth     = 296;
									scrollPic_01.pageWidth      = 74;
							
									scrollPic_01.speed          = 10;
									scrollPic_01.space          = 10;
									scrollPic_01.autoPlay       = false;
									scrollPic_01.autoPlayTime   = .9;
							
									scrollPic_01.initialize();
							</script>
						</div>
					</div>
					</#list>
				</div>
			</div>
		</div>
		</#list>
		</#if>
	</div>
</div>
</body>
</html>