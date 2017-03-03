<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/style.css" rel="stylesheet" />
<script type="text/javascript" src="/script/tab.js"></script>
</head>

<body>
<div class="yuelanshi">
	<div class="w950 left">
		<div class="bb1 topBook">
			<div class="path">
				<h2><a href="javascript:void(0)">首页</a> &gt; <span>学生专辑</span></h2>
			</div>
			<div class="boxListLi5">
				<div class="img"><a href="javascript:void(0);"><img src="${bookPackages['package']['cover']!''}"/></a></div>
				<h2><a href="javascript:void(0);">${bookPackages['package']['name']!''}</a></h2>
				<div class="other">图书数量：${bookPackages['bookList']?size}本 / 图书售价：#{(bookPackages.package.price/100);m0}云币</div>
				<p>${bookPackages['package']['intro']!''}</p>
				<div class="tsBtn">
					<#if (buy!0)==0><a class="video_gm" href="/edushopcart/addShopCart.action?packageId=${bookPackages['package']['id']!''}" target='_blank'>加入购物车</a></#if>
					<#if (buy!0)==0><a class="video_gm" href="/user/pay.action?packageId=${bookPackages['package']['id']!''}" target='_blank'>直接购买</a></#if>
					<#if (buy!0)==1><a class="video_no" href="javascript:void(0);">已购买</span></a></#if>
					<#if (buy!0)==2><a class="video_gm" href="/user/listMyOrders.action" target='_blank'>去支付<span>#{(bookPackages.package.price/100);m0}云币</span></a></#if>
					<#if (count!0)!=0>
						已有<em>${count}人</em>购买
					<#else>
					          此专辑尚无人购买!
					</#if>
				</div>
			</div>
		</div>
	</div>
	<#if bookPackages??>
		<div class="bb1 mt10 w950 left">
			<div class="tit1">
				<h2>所含图书目录(${bookPackages['bookList']?size}本)：</h2>
			</div>
			<div class="con box5List">
				<#if bookPackages['bookList']??>
					<#list bookPackages['bookList'] as book>
						<#assign totalPage = (book_index/9)?int+1 >
						<div class="bookJs group#{totalPage} pageNode" <#if totalPage!=1>style="display:none;"</#if>>
							<a href="/book/detail.action?bookId=${book['bookId']!''}"><img src="http://img3.chineseall.cn/${ImageUtils.getBookImgUrl(book['bookId'])}" /></a>
							<h3><a href="/book/detail.action?bookId=${book['bookId']!''}">${book['name']!''}</a></h3>
							<span>${book['author']!''}/${book['publisher']!''}</span>
							<div class="xingxing"><strong>评价：</strong><span class="s${book.score?default('0')?substring(0 , 1)}">评星</span><em>${book.score?default('0.0')}</em></div>
							<p>${book['intro']!''}</p>
						</div>
					</#list>
				</#if>
				
				<div class="page">
					<a href="javascript:void(0);" onclick="go(parseInt($('.on').html())-1);">&lt;前页</a>
					<#list 1..totalPage as i>
					<a class="pageNo <#if i==1>on</#if>" id="pageNo${i}" onclick="go(${i});" href="javascript:void(0);">${i}</a>
					</#list>
					<a href="javascript:void(0);" onclick="go(parseInt($('.on').html())+1);">后页&gt;</a>
					<span>
					<input class="ipt" id="ipt" type="text" value="1" />
					<input class="btn" onclick="go($('#ipt').val())" type="button" value="go" />
					</span>
					<script>
					function go(no){
						if(no>${totalPage} || no<1){
							alert("请输入1~"+${totalPage}+"页！");
							return false;
						}
						$(".pageNo").removeClass("on");
						$("#pageNo"+no).addClass("on");
						$(".pageNode").hide();
						$(".group"+no).show();
					}
					</script>
				</div>
			</div>
		</div>
	</#if>
</div>
<div class="yuelanshi mtb10">
	<div class="w630 left">
		<div class="bb1">
			<div class="tit1">
				<h2>其他热门图书套装</h2>
				<span><a href="http://eduyun.chineseall.cn/eduyun/package/listBookPackages.action">查看更多专辑&raquo;</a></span>
				<#if bookPackageList??>
					<ul class="bookTab2">
						<#if bookPackageList?size lt 3>
							<li id="ltab2_btn0" onclick=" tabit('ltab2',0,1,'hot')" class="hot_a">1</li>
						</#if>
						<#if bookPackageList?size gt 2 && bookPackageList?size lt 5>
							<li id="ltab2_btn0" onclick=" tabit('ltab2',0,2,'hot')" class="hot_a">1</li>
							<li id="ltab2_btn1" onclick=" tabit('ltab2',1,2,'hot')">2</li>
						</#if>
						<#if bookPackageList?size gt 4>
							<li id="ltab2_btn0" onclick=" tabit('ltab2',0,3,'hot')" class="hot_a">1</li>
							<li id="ltab2_btn1" onclick=" tabit('ltab2',1,3,'hot')">2</li>
							<li id="ltab2_btn2" onclick=" tabit('ltab2',2,3,'hot')">3</li>
						</#if>
					</ul>
				</#if>
			</div>
			<div class="con">
				<#if bookPackageList??>
					<#list bookPackageList as bookPack>
						<#if bookPack_index == 0>
							<div class="bookList5" id="ltab2_div0">
						<#elseif bookPack_index == 2>
							<div class="bookList5" id="ltab2_div1" style="display:none;">
						<#elseif bookPack_index == 4>
							<div class="bookList5" id="ltab2_div2" style="display:none;">
						</#if>
							<div class="bookList5_box">
								<div class="bookList5_book">
									<a href="/eduyun/package/detail.action?id=${bookPack.package.id!''}"><img src="${bookPack.package.cover!''}"></a>
									<h2><a href="/eduyun/package/detail.action?id=${bookPack.package.id!''}">${bookPack.package.name!''}</a></h2>
									<span>图书数量：${bookPack.count!''}</span>
									<span>图书售价：#{(bookPack.package.price/100);m0}云币</span>
									<p>${bookPack.package.intro!''}</p>
									<div class="tsBtn">
										<#if (bookPack.buy!0)==0><a class="video_gm" href="/edushopcart/addShopCart.action?packageId=${bookPack['package']['id']!''}" target='_blank'>购买</a></#if>
										<#if (bookPack.buy!0)==1><a class="video_no" href="javascript:void(0);">已购买</span></a></#if>
										<#if (bookPack.buy!0)==2><a class="video_gm" href="/user/listMyOrders.action" target='_blank'>去支付</a></#if>
									</div>
								</div>
							</div>
						<#if bookPackageList?size lt 3>
							<#if bookPack_index == (bookPackageList?size-1)>
								</div>
							</#if>
						</#if>
						<#if bookPackageList?size gt 2 && bookPackageList?size lt 5>
							<#if bookPack_index == 1 || bookPack_index == (bookPackageList?size-1)>
								</div>
							</#if>
						</#if>
						<#if bookPackageList?size gt 4>
							<#if bookPack_index == 1 || bookPack_index == 3 || bookPack_index == (bookPackageList?size-1)>
								</div>
							</#if>
						</#if>
					</#list>
				</#if>
			</div>
		</div>
	</div>
	<div class="w310 right">
		<div class="bb1 lbox4_li2">
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
	</div>
</div>
<div class="footer">
	<div class="footMain">
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
	</div>
</div>
</body>
</html>
