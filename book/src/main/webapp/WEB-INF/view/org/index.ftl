<head>
<title>书香中国</title>
<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/script/js.js"></script>
<script type="text/javascript" src="/script/tab.js"></script>
<script type="text/javascript" src="/script/ScrollPic.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.operation.js"></script>
<style>
/* lbox */
.lbox1_list{ position:relative; height:208px; overflow:hidden;}
.lbox1 .bookJs .tsBtn{ margin-top:12px; height:35px;}
.lbox1 .bookJs .tsBtn a{ padding:0 18px; height:35px; line-height:35px; font-size:16px;}
.bj142 .bookJs{ padding:0 8px 0 164px;}
.bookTab1{ padding-left:10px; height:106px; background:url(img/lbox1_tab.png) no-repeat left 6px;}
.bookTab1 li{ float:left; margin:0 3px 0 0; padding:3px; width:66px; height:92px; background:#fff;}
.bookTab1 li img{ border:#ccc 1px solid; width:64px; height:90px;}
.bookTab1 li.hot_a{ background:#d6d7bb;}
.bookJs img,.bookTab1 li img{ display:block; border:#ccc 1px solid; width:64px; height:90px;}
.bookTab1 li img:hover,
html,body,ul,li,p,dl,dt,dd,h1,h2,h3,h4{ margin:0; padding:0;}
ul,li{ list-style-type:none;}
</style>
</head>
<body>
<div class="indexMenuList mtb10">
</div>
<div class="layout mtb10">
	<div class="w630 left">
		<div class="bb1 lbox1">
			<div class="tit1">
				<h2>重磅推荐</h2>
				<span><a href="#">查看更多图书&raquo;</a></span>
			</div>
			<div class="con">
				<div class="lbox1_list bj142">
					<#list hotBookList as hotBook>
					<div class="bookJs" id="ltab1_div${hotBook_index}" <#if hotBook_index!=0>style="display:none;"</#if>>
						<a href="/book/detail.action?bookId=${hotBook.bookId}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(hotBook.bookId)}" /></a>
						<h3><a href="/book/detail.action?bookId=${hotBook.bookId}"><#if (hotBook.name?length > 15)>${hotBook.name?substring(0 , 14)}...<#else>${hotBook.name}</#if></a></h3>
						<span>${hotBook.author?default('&lt;暂无作者&gt;')}/${hotBook.publisher?default('&lt;暂无版社&gt;>')}</span>
						<p>${hotBook.content?default('&lt;暂无简介&gt;')}</p>
						<div class="xingxing"><strong>评价：</strong><span class="s4">评星</span><em>${hotBook.score?default('0.0')}</em></div>
						<div class="tsBtn">
							<a class="video_yd" href="/book/read.action?bookId=${hotBook.bookId}">开始阅读</a>
							<#if hotBook.isCollection==1>
							<a class="video_no" href="javascript:void(0);">已收藏</a>
							<#else>
							<a class="video_sc" href="javascript:book.operation(${hotBook.bookId}).collection()">收藏</a>
							</#if>
						</div>
					</div>
					</#list>
				</div>
				<ul class="bookTab1">
					<#list hotBookList as hotBook>
					<li id="ltab1_btn${hotBook_index}" onmouseover="tabit('ltab1',${hotBook_index},${hotBookList?size},'hot')" <#if hotBook_index==0>class="hot_a"</#if>><a href="/book/detail.action?bookId=${hotBook.bookId}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(hotBook.bookId)}" /></a></li>
					</#list>
				</ul>
			</div>
		</div>
		
		<#if recommendBookList??>
		<div class="bb1 lbox2 mt10">
			<div class="tit1">
				<h2>精品悦读</h2>
				<span><a href="#">查看更多图书&raquo;</a></span>
				<ul class="bookTab2">
					<li id="ltab2_btn0" onclick=" tabit('ltab2',0,3,'hot')" class="hot_a">1</li>
					<li id="ltab2_btn1" onclick=" tabit('ltab2',1,3,'hot')">2</li>
					<li id="ltab2_btn2" onclick=" tabit('ltab2',2,3,'hot')">3</li>
				</ul>
			</div>
			<div class="con">
				<div class="lbox2_list bj85" id="ltab2_div0">
					<#list recommendBookList as book>
					<#if book_index lt 6>
					<div class="bookJs">
						<a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a>
						<h3><a href="/book/detail.action?bookId=${book.bookId!0}">${book.bookName!''}</a></h3>
						<span>${book.author!''}/${book.publisher!''}</span>
						<div class="xingxing"><span class="s${book.score?default('0')?substring(0 , 1)}">评星</span><em>${book.score?default('0.0')}</em></div>
						<p>${book.intro!''}</p>
					</div>
					</#if>
					</#list>
				</div>
				<div class="lbox2_list bj85" id="ltab2_div1" style="display:none;">
					<#list recommendBookList as book>
					<#if book_index gt 5 && book_index lt 12>
					<div class="bookJs">
						<a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a>
						<h3><a href="/book/detail.action?bookId=${book.bookId!0}">${book.bookName!''}</a></h3>
						<span>${book.author!''}/${book.publisher!''}</span>
						<div class="xingxing"><span class="s${book.score?default('0')?substring(0 , 1)}">评星</span><em>${book.score?default('0.0')}</em></div>
						<p>${book.intro!''}</p>
					</div>
					</#if>
					</#list>
				</div>
				<div class="lbox2_list bj85" id="ltab2_div2" style="display:none;">
					<#list recommendBookList as book>
					<#if book_index gt 11>
					<div class="bookJs">
						<a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a>
						<h3><a href="/book/detail.action?bookId=${book.bookId!0}">${book.bookName!''}</a></h3>
						<span>${book.author!''}/${book.publisher!''}</span>
						<div class="xingxing"><span class="s${book.score?default('0')?substring(0 , 1)}">评星</span><em>${book.score?default('0.0')}</em></div>
						<p>${book.intro!''}</p>
					</div>
					</#if>
					</#list>
				</div>
			</div>
		</div>
		</#if>
		
		<div class="banner630">
			<img src="/images/ztydlb.jpg" width="630px" height="70px"/>
		</div>
		
		<#assign i = 0>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>学生图书专辑推荐</h2>
				<span><a href="#">查看更多专辑&raquo;</a></span>
			</div>
			<div class="con">
				<div class="bookList5">
					<#if studentPackages??>
					<#list studentPackages as bookPack>
					<#if bookPack_index gt 1><#break></#if>
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
							<ul id="ISL_Cont_${i!0}">
								<#list bookPack.bookList as book>
								<li><a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a></li>
								</#list>
							</ul>
							<div class="LeftBotton" id="LeftArr${i!0}">left</div>
							<div class="RightBotton" id="RightArr${i!0}">right</div>
							<script type="text/javascript">
								var scrollPic_01 = new ScrollPic();
									scrollPic_01.scrollContId   = "ISL_Cont_${i!0}";
									scrollPic_01.arrLeftId      = "LeftArr${i!0}";
									scrollPic_01.arrRightId     = "RightArr${i!0}";
							
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
					</#if>
				</div>
				<div class="bookList5 bg2">
					<#if studentPackages??>
					<#list studentPackages as bookPack>
					<#if bookPack_index gt 1>
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
							<ul id="ISL_Cont_${i!0}">
								<#list bookPack.bookList as book>
								<li><a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a></li>
								</#list>
							</ul>
							<div class="LeftBotton" id="LeftArr${i!0}">left</div>
							<div class="RightBotton" id="RightArr${i!0}">right</div>
							<script type="text/javascript">
								var scrollPic_01 = new ScrollPic();
									scrollPic_01.scrollContId   = "ISL_Cont_${i!0}";
									scrollPic_01.arrLeftId      = "LeftArr${i!0}";
									scrollPic_01.arrRightId     = "RightArr${i!0}";
							
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
					</#if>
					</#list>
					</#if>
				</div>
			</div>
		</div>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>家长图书专辑推荐</h2>
				<span><a href="#">查看更多专辑&raquo;</a></span>
			</div>
			<div class="con">
				<div class="bookList5">
					<#if patriarchPackages??>
					<#list patriarchPackages as bookPack>
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
							<ul id="ISL_Cont_${i!0}">
								<#list bookPack.bookList as book>
								<li><a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a></li>
								</#list>
							</ul>
							<div class="LeftBotton" id="LeftArr${i!0}">left</div>
							<div class="RightBotton" id="RightArr${i!0}">right</div>
							<script type="text/javascript">
								var scrollPic_01 = new ScrollPic();
									scrollPic_01.scrollContId   = "ISL_Cont_${i!0}";
									scrollPic_01.arrLeftId      = "LeftArr${i!0}";
									scrollPic_01.arrRightId     = "RightArr${i!0}";
							
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
					</#if>
				</div>
			</div>
		</div>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>老师图书专辑</h2>
				<span><a href="#">查看更多专辑&raquo;</a></span>
			</div>
			<div class="con">
				<div class="bookList5">
					<#if teacherPackages??>
					<#list teacherPackages as bookPack>
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
							<ul id="ISL_Cont_${i!0}">
								<#list bookPack.bookList as book>
								<li><a href="/book/detail.action?bookId=${book.bookId!0}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId!0)}" /></a></li>
								</#list>
							</ul>
							<div class="LeftBotton" id="LeftArr${i!0}">left</div>
							<div class="RightBotton" id="RightArr${i!0}">right</div>
							<script type="text/javascript">
								var scrollPic_01 = new ScrollPic();
									scrollPic_01.scrollContId   = "ISL_Cont_${i!0}";
									scrollPic_01.arrLeftId      = "LeftArr${i!0}";
									scrollPic_01.arrRightId     = "RightArr${i!0}";
							
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
					</#if>
				</div>
			</div>
		</div>
		
		<!--div class="bb1 mt10 lbox5" id="indexUserList">
			<div class="indexUserList">
				<h3>初出茅庐小菜鸟</h3>
				<div class="indexUserList_dl" id="newUsers"></div>
			</div>
			<div class="indexUserList">
				<h3>饱读诗书文化人</h3>
				<div class="indexUserList_dl" id="friendsMoreUsers"></div>
			</div>
			<div class="indexUserList">
				<h3>舌战群儒点评家</h3>
				<div class="indexUserList_dl" id="bookCommentUsers"></div>
			</div>
			<div class="indexUserList">
				<h3>活动参与积极者</h3>
				<div class="indexUserList_dl" id="worksMoreUsers"></div>
			</div>
		</div-->
	</div>
	<div class="w310 right">
	    <#if userId??>
	    <!--登陆之后的相关信息-->
		<div class="bb1 bj85 indexUser">
			<div class="canjiaArea">
				<img src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(userId)}">
				<span class="${gender?string('m','w')}">${userName!''}</span>
				<#assign  index = -1 />
				<div class="btn"><a href="/user/i.action">进入我的书房</a> </div>
			</div>
			<#if userReadingBookMap??>
			<div class="bookJs">
				<a href="/book/detail.action?bookId=${userReadingBookMap.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(userReadingBookMap.id)}"></a>
				<h3><a href="/book/detail.action?bookId=${userReadingBookMap.id}">${userReadingBookMap.bookName!''}</a>
				<#if userReadingBookMap.type?? && userReadingBookMap.type == 1>
				<em>第${userReadingBookMap.lastReadPage!1}页</em>
				</#if>
				</h3>
				<span>${userReadingBookMap.author!''}/${userReadingBookMap.publisher!''}</span>
				<div class="time">${userReadingBookMap.publishDate!''}</div>
				<#if userReadingBookMap.type?? && userReadingBookMap.type == 1>
				<div class="jdt">
					<div><span style="width:${(userReadingBookMap.readPageCount!0/userReadingBookMap.totalPage!1)*100}%;"></span></div>${(userReadingBookMap.readPageCount!0/userReadingBookMap.totalPage!1)*100}%
				</div>
				</#if>
				<#if userReadingBookMap.type?? && userReadingBookMap.type == 1>
				<div class="tsBtn">
					<a class="video_yd" href="/book/read.action?bookId=${userReadingBookMap.id}&page=${userReadingBookMap.lastReadPage!1}&mode=1">继续阅读</a>
				</div>
				</#if>
				<#if userReadingBookMap.type?? && userReadingBookMap.type == 2>
				<div class="tsBtn">
					<a class="video_yd" href="/book/read.action?bookId=${userReadingBookMap.id}&page=1&mode=1">首次阅读</a>
				</div>
				</#if>
			</div>
			</#if>
		</div>
	    </#if>
		<div class="bb1 mt10 rbox2">
			<div class="tit1">
				<h2>活动进行时</h2>
				<span><a href="http://book3.chineseall.cn/org/activity.action?orgTreeId=${orgTreeId}&activityType=0">所有活动&raquo;</a></span>
			</div>
			<div class="con">
			    <#if hotActivitys??>
			    <#if (hotActivitys?size > 0) >
			    <#assign top = hotActivitys[0] >
				<div class="hdList">
					<!--div class="img"><img src="http://html.chineseall.cn/static/style/img/280x84.jpg" /></div-->
					<div class="img"><a href="/activity/index.action?activityId=${top.activityId}"><img src="http://img3.chineseall.cn/${top.logo!''}" /></a></div>
					<h3><a href="/activity/index.action?activityId=${top.activityId}">${top.activityName}</a></h3>
					<div class="time">
                    ${top.startDate?string("yyyy年MM月dd日 ")}
					—${top.finishDate?string("yyyy年MM月dd日 ")}
                    </div>
					<div class="xx">
						<span><em>类型：</em>
						<#if top.activityType == 1>
						读书活动
						<#elseif top.activityType == 2>
						读书征文
						<#elseif top.activityType == 3>
						摄影比赛
						<#elseif top.activityType == 4>
						绘画比赛
						</#if>
						</span>
						<span><em>作品：</em>${top.worksCount} 份</span>
					</div>
					<div class="text">
						<p>活动介绍：${top.description}</p>
					</div>
					<div class="btn"><a href="/activity/index.action?activityId=${top.activityId}">提交作品</a></div>
					<ul>
						<li class="b1">(${top.acBookCount})</li>
						<li class="b2">(${top.worksCount})</li>
						<li class="b3">(${top.joinUserCount})</li>
					</ul>
				</div>
				</#if>
				<#if (hotActivitys?size > 1) >
			    <#assign top1 = hotActivitys[1] >
				<div class="hdList">
					<div class="img"><a href="/activity/index.action?activityId=${top1.activityId}"><img src="http://img3.chineseall.cn/${top1.logo!''}" /></a></div>
					<h3><a href="/activity/index.action?activityId=${top1.activityId}">${top1.activityName}</a></h3>
					<div class="time">
					${top1.startDate?string("yyyy年MM月dd日 ")}
					—${top1.finishDate?string("yyyy年MM月dd日 ")}
					</div>
					<div class="xx">
						<span><em>类型：</em>
						<#if top1.activityType == 1>
						读书活动
						<#elseif top1.activityType == 2>
						读书征文
						<#elseif top1.activityType == 3>
						摄影比赛
						<#elseif top1.activityType == 4>
						绘画比赛
						</#if>
						</span>
						<span><em>作品：</em>${top1.worksCount} 份</span>
					</div>
					<div class="text">
						<p>活动介绍：${top1.description}</p>
					</div>
					<div class="btn"><a href="/activity/index.action?activityId=${top1.activityId}">提交作品</a></div>
					<ul>
						<li class="b1">(${top1.acBookCount})</li>
						<li class="b2">(${top1.worksCount})</li>
						<li class="b3">(${top1.joinUserCount})</li>
					</ul>
				</div>
				</#if>
				</#if>
			</div>
		</div>
		
		<div class="bb1 mt10 top">
			<div class="tit">
				<ul>
				    <li id="top_btn0" onclick=" tabit('top',0,2,'hot')" class="hot_a" >阅读榜</li>
					<li id="top_btn1" onclick=" tabit('top',1,2,'hot')">收藏榜</li>
				</ul>
			</div>
			<div class="con">
			    <ul id="top_div0" >
					<#if (listOrgReadingTopBook??&&listOrgReadingTopBook?size > 0) >
						<#assign top = listOrgReadingTopBook[0] >
						<li class="li1 bookJs">
							<a href="/book/detail.action?bookId=${top.id}">
							<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(top.id)}" /></a>
							<#if (top.name?length > 20) >
								<a href="/book/detail.action?bookId=${top.id}" title="${top.name}" >${top.name?substring(0 , 18)}...</a><em>${top.score?default('0.0')}</em>
								<#else>
								<a href="/book/detail.action?bookId=${top.id}">${top.name}</a><em>${top.score?default('0.0')}</em>	
							</#if>
							<span>${top.author?default('&lt;暂无作者信息&gt;')}/${top.publisher?default('&lt;暂无出版社信息&gt;>')}</span>
							<p>
							${intros[top.id?string]?default('&lt;暂无简介&gt;')}
							</p>
						</li>
					</#if>
					<#if (listOrgReadingTopBook??&&listOrgReadingTopBook?size > 1)>
						<#list listOrgReadingTopBook[1..] as b>
							<li>
								<#if (b.name?length > 20) >活动进行时
									<a href="/book/detail.action?bookId=${b.id}" title="${b.name}" >${b.name?substring(0 , 18)}...</a><em>${b.score?default('0.0')}</em>
									<#else>
									<a href="/book/detail.action?bookId=${b.id}">${b.name}</a><em>${b.score?default('0.0')}</em>
								</#if>
							</li>
						</#list>
					</#if>
				</ul>
				<ul id="top_div1" style="display:none;">
					<#if (listOrgCollectionTopBook??&&listOrgCollectionTopBook?size > 0) >
						<#assign top = listOrgCollectionTopBook[0] >
						<li class="li1 bookJs">
							<a href="/book/detail.action?bookId=${top.id}">
							<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(top.id)}" /></a>
							<#if (top.name?length > 20) >
								<a href="detail.action?bookId=${top.id}" title="${top.name}" >${top.name?substring(0 , 18)}...</a><em>${top.score?default('0.0')}</em>
								<#else>
								<a href="detail.action?bookId=${top.id}">${top.name}</a><em>${top.score?default('0.0')}</em>	
							</#if>
							<span>${top.author?default('&lt;暂无作者信息&gt;')}/${top.publisher?default('&lt;暂无出版社信息&gt;>')}</span>
							<p>
							${intros[top.id?string]?default('&lt;暂无简介&gt;')}
							</p>
						</li>
					</#if>
					<#if (listOrgCollectionTopBook??&&listOrgCollectionTopBook?size > 1)>
						<#list listOrgCollectionTopBook[1..] as b>
							<li>
								<#if (b.name?length > 20) >
									<a href="detail.action?bookId=${b.id}" title="${b.name}" >${b.name?substring(0 , 18)}...</a><em>${b.score?default('0.0')}</em>
									<#else>
									<a href="detail.action?bookId=${b.id}">${b.name}</a><em>${b.score?default('0.0')}</em>	
								</#if>
							</li>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
		
		
		<div class="bb1 mt10 lbox4_li2">
			<div class="tit1">
				<h2>热门作者</h2>
				<span><a href="#">查看更多&raquo;</a></span>
			</div>
			<div class="con">
				<ul>
					<li><a href="/search/book.action?word=安徒生">安徒生</a></li>
						<li class="fz19 c1"><a href="/search/book.action?word=格林">格林</a></li>
						<li><a href="/search/book.action?word=冰心">冰心</a></li>
						<li class="fz14 c2"><a href="/search/book.action?word=朱自清">朱自清</a></li>
						<li><a href="/search/book.action?word=鲁迅">鲁迅</a></li>
						<li class="fz19 c3"><a href="/search/book.action?word=金波">金波</a></li>
						<li><a href="/search/book.action?word=茅盾">茅盾</a></li>
						<li class="c4"><a href="/search/book.action?word=郑渊洁">郑渊洁</a></li>
						<li class="fz20 c5"><a href="/search/book.action?word=黄蓓佳">黄蓓佳</a></li>
						<li><a href="/search/book.action?word=曹文轩">曹文轩</a></li>
						<li><a href="/search/book.action?word=饶雪漫">饶雪漫</a></li>
						<li class="fz19 c6"><a href="/search/book.action?word=法布尔">法布尔</a></li>
						<li class="c10"><a href="/search/book.action?word=王尔德">王尔德</a></li>
						<li class="fz16 c6"><a href="/search/book.action?word=梅子涵">梅子涵</a></li>
						<li class="fz22 c7"><a href="/search/book.action?word=海伦•凯勒">海伦•凯勒</a></li>
						<li class="fz19 c8"><a href="/search/book.action?word=圣埃克苏佩里">圣埃克苏佩里</a></li>
						<li><a href="/search/book.action?word=金斯利">金斯利</a></li>
					
				</ul>
			</div>
		</div>
		<div class="bb1 mt10 lbox4">
			<div class="tit1">
				<h2>热门标签</h2>
				<span><a href="#">所有热门标签&raquo;</a></span>
			</div>
			<div class="con">
				<dl>
					<dd>
						<a href="/search/book.action?word=校长&queryfield=5">校长</a>
						<a href="/search/book.action?word=班主任&queryfield=5">班主任</a>
						<a href="/search/book.action?word=教师&queryfield=5">教师</a>
						<a href="/search/book.action?word=家长&queryfield=5">家长</a>
						<a href="/search/book.action?word=名著&queryfield=5">名著</a>
						<a href="/search/book.action?word=诗歌&queryfield=5">诗歌</a>
						<a href="/search/book.action?word=国学&queryfield=5">国学</a>
						<a href="/search/book.action?word=新课标&queryfield=5">新课标</a>
						<a href="/search/book.action?word=科普&queryfield=5">科普</a>
						<a href="/search/book.action?word=百科&queryfield=5">百科</a>
					</dd>
				</dl>
				<dl>
					<dd>
						<a href="/search/book.action?word=考试&queryfield=5">考试</a>
						<a href="/search/book.action?word=名人&queryfield=5">名人</a>
						<a href="/search/book.action?word=文学 &queryfield=5">文学 </a>
						<a href="/search/book.action?word=青春&queryfield=5">青春</a>
						<a href="/search/book.action?word=心理&queryfield=5">心理</a>
						<a href="/search/book.action?word=情商&queryfield=5">情商</a>
						<a href="/search/book.action?word=童话&queryfield=5">童话</a>
						<a href="/search/book.action?word=漫画&queryfield=5">漫画</a>
						<a href="/search/book.action?word=卡通&queryfield=5">卡通</a>
						<a href="/search/book.action?word=假期&queryfield=5">假期</a>
						<a href="/search/book.action?word=儿童&queryfield=5">儿童</a>
					</dd>
				</dl>
				<dl>
					<dd>
						<a href="/search/book.action?word=故事&queryfield=5">故事</a>
						<a href="/search/book.action?word=爱的教育&queryfield=5">爱的教育</a>
						<a href="/search/book.action?word=益智&queryfield=5">益智</a>
						<a href="/search/book.action?word=启蒙&queryfield=5">启蒙</a>
						<a href="/search/book.action?word=家庭教育&queryfield=5">家庭教育</a>
						<a href="/search/book.action?word=成长&queryfield=5">成长</a>
						<a href="/search/book.action?word=生活&queryfield=5">生活</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="bb1 mt10 lbox4_li2">
			<div class="tit1">
				<h2>图书专辑分类</h2>
				<span><a href="/eduyun/package/listBookPackages.action">查看更多&raquo;</a></span>
			</div>
			<div class="con">
				<ul>
					<li><a href="/eduyun/package/detail.action?id=37">古典诗词</a></li>
					<li class="fz19 c1"><a href="/eduyun/package/detail.action?id=25">国内经典</a></li>
					<li><a href="/eduyun/package/detail.action?id=46">国外经典</a></li>
					<li class="fz14 c2"><a href="/eduyun/package/detail.action?id=60">国学经典</a></li>
					<li><a href="/eduyun/package/detail.action?id=26">名家书苑</a></li>
					<li class="fz19 c3"><a href="/eduyun/package/detail.action?id=42">人物传记</a></li>
					<li class="fz14 c2"><a href="/eduyun/package/detail.action?id=39">经典故事</a></li>
					<li><a href="/eduyun/package/detail.action?id=34">新课标必读</a></li>
					<li class="c4"><a href="/eduyun/package/detail.action?id=41">学习方法</a></li>
					<li class="fz20 c5"><a href="/eduyun/package/detail.action?id=44">旅游视界</a></li>
					<li><a href="/eduyun/package/detail.action?id=51">外交风云</a></li>
					<li><a href="/eduyun/package/detail.action?id=24">幽默笑话</a></li>
					<li class="fz19 c6"><a href="/eduyun/package/detail.action?id=27">科幻王国</a></li>
					<li class="c10"><a href="/eduyun/package/detail.action?id=35">益智锦囊</a></li>
					<li class="fz16 c6"><a href="/eduyun/package/detail.action?id=36">青春文学</a></li>
					<li class="fz22 c7"><a href="/eduyun/package/detail.action?id=38">红色党政</a></li>
					<li><a href="/eduyun/package/detail.action?id=66">人际讲堂</a></li>
					<li class="fz19 c9"><a href="/eduyun/package/detail.action?id=61">心理健康</a></li>
					<li class="fz16 c4"><a href="/eduyun/package/detail.action?id=65">感恩教育</a></li>
					<li><a href="/eduyun/package/detail.action?id=58">诚信教育</a></li>
					<li class="fz19 c1"><a href="/eduyun/package/detail.action?id=53">校长书架</a></li>
					<li><a href="/eduyun/package/detail.action?id=54">教育管理</a></li>
					<li class="fz14 c2"><a href="/eduyun/package/detail.action?id=1">班主任书架</a></li>
					<li><a href="/eduyun/package/detail.action?id=2">教师书廊</a></li>
					<li class="fz19 c3"><a href="/eduyun/package/detail.action?id=69">家庭教育</a></li>
					<li><a href="/eduyun/package/detail.action?id=70">亲子阅读</a></li>
					<li class="fz19 c6"><a href="/eduyun/package/detail.action?id=6">语文</a></li>
					<li class="c10"><a href="/eduyun/package/detail.action?id=16">英语</a></li>
					<li class="fz16 c6"><a href="/eduyun/package/detail.action?id=10">物理</a></li>
					<li class="fz22 c7"><a href="/eduyun/package/detail.action?id=21">化学</a></li>
					<li><a href="/eduyun/package/detail.action?id=13">数学</a></li>
					<li class="fz19 c9"><a href="/eduyun/package/detail.action?id=8">政治</a></li>
					<li class="fz16 c4"><a href="/eduyun/package/detail.action?id=15">地理</a></li>
					<li><a href="/eduyun/package/detail.action?id=3">历史</a></li>
					<li class="fz19 c1"><a href="/eduyun/package/detail.action?id=17">作文</a></li>
					<li><a href="/eduyun/package/detail.action?id=9">艺术</a></li>
				</ul>
			</div>
		</div>
		
		<div class="bb1 mt10 rbox4">
			<div class="tit1">
				<h2>正在发生......</h2>
			</div>
			<div class="con">
				<ul  id="dynamic">
					<li>
						获取数据中...
					</li>
				</ul>
			</div>
		</div>
		
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	var  reqdata
	$.ajax({
		url : "/org/getNewUsers.action",
		cache : false,
		async : false,
		dataType : "json",
		success : function(json) {
			reqdata = json;
		}
	})
	if(reqdata){
		//最新用户
		var newUsers = reqdata.newUserList || [];
		h = '';
		for(var i = 0 ; i < newUsers.length ; i ++){
		    	h +='<dl>'
		    	  + '<dt><a href="/user/'+newUsers[i].userId+'/i.action"><img onerror="javascript:this.src=\'http://img3.chineseall.cn/userHeadImg/moren/default.jpg\'" src="http://img3.chineseall.cn/'+newUsers[i].headImg+'" /></a></dt>'
		    	  + '<dd>'
		    	  +'<strong>'+newUsers[i].displayName+'</strong>'
		    	  + '<a href="/user/'+newUsers[i].userId+'/i.action ">加关注</a>'
		    	  +'</dd>'
				  + '</dl>';
		}
		$('#newUsers').html(h);
		
		//书评最多
		var bookCommentUsers = reqdata.bookCommentUserList || [];
		h = '';
		for(var i = 0 ; i < bookCommentUsers.length ; i ++){
		    	h +='<dl>'
		    	  + '<dt><a href="/user/'+bookCommentUsers[i].userId+'/i.action"><img onerror="javascript:this.src=\'http://img3.chineseall.cn/userHeadImg/moren/default.jpg\'" src="http://img3.chineseall.cn/'+bookCommentUsers[i].headImg+'" /></a></dt>'
		    	  + '<dd>'
		    	  +'<strong>'+bookCommentUsers[i].displayName+'</strong>'
		    	  + '<a href="/user/'+bookCommentUsers[i].userId+'/i.action ">加关注</a>'
		    	  +'</dd>'
				  + '</dl>';
		}
		$('#bookCommentUsers').html(h);
		
		//作品最多
		var worksMoreUsers = reqdata.worksUserList || [];
		h = '';
		for(var i = 0 ; i < worksMoreUsers.length ; i ++){
		    	h +='<dl>'
		    	  + '<dt><a href="/user/'+worksMoreUsers[i].userId+'/i.action"><img onerror="javascript:this.src=\'http://img3.chineseall.cn/userHeadImg/moren/default.jpg\'" src="http://img3.chineseall.cn/'+worksMoreUsers[i].headImg+'" /></a></dt>'
		    	  + '<dd>'
		    	  +'<strong>'+worksMoreUsers[i].displayName+'</strong>'
		    	  +'<a href="/user/'+worksMoreUsers[i].userId+'/i.action">加关注</a>'
		    	  +'</dd>'
				  + '</dl>';
		}
		$('#worksMoreUsers').html(h);
		
		//书友最多
		var friendsMoreUsers = reqdata.readBookUserList || [];
		h = '';
		for(var i = 0 ; i < friendsMoreUsers.length ; i ++){
		    	h +='<dl>'
		    	  + '<dt><a href="/user/'+friendsMoreUsers[i].userId+'/i.action"><img onerror="javascript:this.src=\'http://img3.chineseall.cn/userHeadImg/moren/default.jpg\'" src="http://img3.chineseall.cn/'+friendsMoreUsers[i].headImg+'" /></a></dt>'
		    	  + '<dd>'
		    	  +'<strong>'+friendsMoreUsers[i].displayName+'</strong>'
		    	  +'<a href="/user/'+friendsMoreUsers[i].userId+'/i.action">加关注</a>'
		    	  +'</dd>'
				  + '</dl>';
		}
		$('#friendsMoreUsers').html(h);
		var menuTag = document.getElementById('indexUserList');
		var menudl = menuTag.getElementsByTagName('dl');
		var menudt = menuTag.getElementsByTagName('dt');
		var menudd = menuTag.getElementsByTagName('dd');
		for(var i=0,j;j=menudl[i++];){
			j.data = i-1;
			j.onmouseover = function(){
				for(var a=0,b;b=menudd[a++];) b.style.display = 'none';
				menudd[this.data].style.display = 'block';
				menudl[this.data].className = 'd';
			}
			j.onmouseout = function(){
				for(var a=0,b;b=menudd[a++];) {
				menudd[this.data].style.display = 'none';
				menudl[this.data].className = '';
				}
			}
		}
		
	}
})
 $.ajax({
    url: '/org/updateaccessCount.action?orgTreeId=${orgTreeId}&t='+new Date(),
    type: 'GET',
    dataType: 'text',
    timeout: 1000,
    error: function(){},
    success: function(data){}
 });
 var dd = setInterval("reflushDynamic()", 20000);
	function reflushDynamic() {
		$.ajax({
			url : '/org/homepageDynamic.action?t=' + new Date(),
			type : 'GET',
			dataType : 'text',
			timeout : 1000,
			error : function() {
				$("#dynamic").html('未获取到数据...');
			},
			success : function(data) {
				$("#dynamic").html(data);
				clearInterval(dd);
			}
		});
	};
	reflushDynamic();
	
</script>
</body>