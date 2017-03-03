<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/yuelanshi.css" rel="stylesheet" />
<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/script/js.js"></script>
<script type="text/javascript" src="/script/tab.js"></script>
<script type="text/javascript" src="/script/vote.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.operation.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.comment.js"></script>
<style type="text/css" >
	.pagination{
		text-align: right;
		padding: 5px;
		padding-top:3px;
	}
	.pagination a, .pagination span {
		cursor:pointer;
		margin: 5px;
		color: #617f9e;
		font-size: 12px;
	}
	.pagination .current {
		color: black;
	}
	
	
/* bookJs */
.bookJs img{ position:absolute;}
.bookJs img,.bookTab1 li img{ display:block; border:#ccc 1px solid; width:64px; height:90px;}
.bookJs h3{ height:18px; overflow:hidden; font-size:12px; font-weight:normal;}
.bookJs span{ display:block; height:18px; overflow:hidden;}
.bookJs p{ height:54px; overflow:hidden; color:#666;}
.bookJs em{ margin-left:8px;}
.bookJs p,.bookJs .xx{ margin:4px 0;}
.xingxing strong{ float:left; font-weight:normal;}
.xingxing span{ float:left; display:block; margin-top:3px; width:72px; height:12px; overflow:hidden; text-indent:-999em; background:url(img/xx.png) no-repeat;}
.xingxing span.s1{ background-position:0 -12px;}
.xingxing span.s2{ background-position:0 -24px;}
.xingxing span.s3{ background-position:0 -36px;}
.xingxing span.s4{ background-position:0 -48px;}
.xingxing span.s5{ background-position:0 -60px;}
/* bookNews */
.bookNews{ padding:0 16px;}
.bookNews .bookJs{ padding:0 0 16px 165px; height:202px;}
.bookNews .bookJs .img{ position:absolute; margin-left:-165px; width:144px; height:202px; padding-right:7px; background:url(img/bookNews_img.png) no-repeat right top;}
.bookNews .bookJs .img img{ width:142px; height:200px;}
.bookNews .bookJs .i{ position:absolute; bottom:1px; right:7px; width:60px; height:60px; overflow:hidden; text-indent:-999em; background:url(img/bookNews_img_i.png) no-repeat;}
.bookNews .bookJs h3{ margin-bottom:4px; font-size:14px;}
.bookNews .bookJs p{ height:36px;}
.bookNews .bookJs p b{ font-weight:normal; color:#000;}
.bookNews .bookJs .bookNews_div{ border:#ccc 1px solid; background:#fafafa;}
.bookNews .bookJs .bookNews_div ul{ padding:6px 0; width:100%; overflow:hidden;}
.bookNews .bookJs .bookNews_div li{ float:left; width:49%; height:26px; line-height:26px; overflow:hidden;}
.bookNews .bookJs .bookNews_div li a{ padding-left:17px; background:url(img/line4.png) no-repeat 11px 8px;}
/* tit */
.tit1{ height:46px;}
.tit1 h2{ float:left; padding:11px 14px 0 14px; font-size:18px; line-height:20px; font-weight:normal;}
.tit1 span{ float:left; padding-top:15px;}
.tit1 i{ float:left; display:block; margin-right:6px; width:20px; height:20px; text-indent:-999em; overflow:hidden;}
.tit1 i.t_x{ background-position:-11px -330px;}
.tit1 i.t_r{ background-position:-11px -370px;}
.tit2{ height:25px; line-height:25px; overflow:hidden; background:url(img/line1.png) repeat-x left center;}
.tit2 h2{ margin:0 auto; width:96px; color:#fff; text-align:center; font-weight:normal; font-size:12px; overflow:hidden; background-color:#fff; background-position:-204px 0;}
.tit2 .more{ float:right; padding-left:5px; background:#fff;}

.bookStyle2 .bookNews{ padding-right:0; width:932px; overflow:hidden;}
.bookStyle2 .bookNews .bookJs{ float:left; padding-left:88px; width:145px; height:104px;}
.bookStyle2 .bookNews .bookJs .img{ margin-left:-88px; padding-right:3px; width:75px; height:104px; background-image:url(img/bookNews_img1.png);}
.bookStyle2 .bookNews .bookJs .img img{ width:73px; height:102px;}
.bookStyle2 .bookNews .bookJs .img .i{ right:4px; width:29px; height:29px; background-image:url(img/bookNews_img1_i.png);}
</style>
</head>
<body>
<#assign book = detail.book>
<div class="yuelanshi">
	<input id="bookId" type="hidden" value="${book.id}" />
	<div class="w950 left">
		<div class="bb1 topBook">
			<!--
			<div class="path">
				<h2><a href="#">畅销・小说</a> &gt; <span>历史</span></h2>
			</div>
			 -->
			<div class="boxListLi5">
				<div class="img"><a><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.id)}" /></a></div>
				<h2><a>${book.name}</a></h2>
				<div class="other">作者：<span>${book.author?default('&lt;暂无作者信息&gt;')}</span> / 出版社：<span>${book.publisher?default('&lt;暂无出版社信息&gt;')}</span> / 出版日期：<span>${book.publishDate?default('&lt;暂无出版日期&gt;')}</span> / 阅读：<span>${detail.readCount}次</span> / 收藏：<span>${detail.collectionCount}次</span> / 推荐：<span>${detail.recommendCount}次</span><!-- / 副本：<span>5个</span> <a href="#">借阅</a> --></div>
				<p>${detail.intro?default('&lt;暂无简介&gt;')}</p>
				<div class="tsBtn">
					<a class="video_yd" target="_blank" href="read.action?bookId=${book.id}"><#if (buy!0)==0>试读<#else>开始阅读</#if></a>
					<#if (buy!0)==0>
						<#if (ReadConstants.BOOK_STATE_NORMAL == book.state)>
						<#if (listCollectionBookId?seq_contains(book.id))>
						<a class="video_no" >已收藏</a>
						<#else>
						<a class="video_sc" href="javascript:book.operation(${book.id}).collection()">收藏</a>
						</#if>
						</#if>
						<a class="video_gm" style="float:right;" href="/user/pay.action?bookId=${book.id!''}" target="_blank">直接购买</a>
						<a class="video_gm" style="float:right;" href="/edushopcart/addShopCart.action?bookId=${book.id!''}" target="_blank">加入购物车</a>
						<span style="font-size: 16px; height: 35px; line-height: 35px; width: 280px;float:right;text-align:right;">价格：<span>#{(price/100);m0}云币&nbsp;&nbsp;</span></span>
					</#if>
				</div>
				<div class="voteBox">
					<strong>总分：</strong>
					<div class="xingxing"><span class="s${book.score?default('0')?substring(0 , 1)}">评星</span><em>${book.score?default('0.0')}</em></div>
					<div class="tsBtn">
						<a id="pfbtn" class="video_yd" onclick="pf()" href="#">评分</a>
					</div>
				</div>
				<div id="vote" style="display:none;">
					<span>点击星星进行评分：</span>
				    <ul>
				    	<li> </li>
				        <li> </li>
				        <li> </li>
				        <li> </li>
				        <li> </li>
				    </ul>
				    <span> </span>
				    <div id="s-bg"> </div>
				    <div class="tsBtn">
						<a class="video_yd" onclick="pf(${book.id})" href="#">评分</a>
					</div>
				</div>
				<script type="text/javascript">
					var vote = $('#vote');
					
					$(document.body).bind('click' , function(event){
						event = event || window.event;
						var t = event.srcElement || event.target
						if(t.id != 'pfbtn' && !$(t).closest('#vote').length){
							vote.hide();
						}
					})
					function pf(bookId){
						vote.show() , score = vote.find('.hove').length;
						if(score){
							book.operation(bookId).vote(score);
							vote.hide();
						}						
					}
				</script>
			</div>
			<#if (listBookLabel?? && listBookLabel?size > 0) >
			<div class="shuqian">
				<h2><a >本书书签 +</a></h2>
				<ul>
					<#list listBookLabel as l>
					<li><a target="_blank" href="/search/book.action?word=${l}&queryfield=5">${l}</a></li>
					</#list>
				</ul>
			</div>
			</#if>
		</div>
	</div>
	<#if eduBookPackageList?? && (eduBookPackageList?size != 0)>
	<div class="left w950">
		<div class="mt10 bb1 bookStyle2">
			<div class="tit1">
				<h2>以下图书专辑含此书</h2>
			</div>
			<div class="bookNews">
				<#list eduBookPackageList as eduBookPackage>
				<div class="bookJs">
					<div class="img"><a href="/eduyun/package/detail.action?id=${eduBookPackage.id!''}"><img src="${eduBookPackage.cover!''}"><span class="i">album</span></a></div>
					<h3><a href="/eduyun/package/detail.action?id=${eduBookPackage.id!''}">${eduBookPackage.name!''}</a></h3>
					<p>#{(eduBookPackage.price/100);m0}云币</p>
					<div class="tsBtn">
						<a class="video_gm" href="/eduyun/package/detail.action?id=${eduBookPackage.id!''}">查看</a>
					</div>
				</div>
				</#list>
			</div>
		</div>
	</div>
	</#if>
	<div class="w630 mt10 left">
		<div class="bb1">
			<#if (directory?? && directory?size > 0)>
			<div class="tit1">
				<h2>目录</h2>
				<span><a href="/book/read.action?bookId=${book.id}&directory=show">进入图书目录页面&raquo;</a></span>
			</div>
			<div class="mulu">
				<dl>
					<#list directory as d>
					<dt><a target="_blank" href="/book/read.action?bookId=${book.id}&mode=${readMode}&page=${d.page}">${d.nodeName?default(d.page)}</a></dt>
					<dd>
					<#if (d.childNodes?? && d.childNodes?size > 0) >
					<ul>
					<#list d.childNodes as child>
					<li><a target="_blank" href="/book/read.action?bookId=${book.id}&mode=${readMode}&page=${child.page}">${child.nodeName?default(child.page)}</a></li>
					</#list>
					<ul>
					</#if>
					</dd>
					</#list>
				</dl>
			</div>
			<#else>
			<div class="mulu" style="margin-top:20px;" >
				<dl><dt>暂无目录</dt></dl>
			</div>
			</#if>
			
			<div class="pinglun">
				<div class="huodongContent_title">
					<h2 class="s1">书评</h2>
					<span id="commentTotalCount" >共 0 条评论</span>
					<#if (!loginUserInfo??)>
					<span style="padding-left: 300px;" ><a href="/showLogin.action?returnUrl=/book/detail.action?bookId=${book.id}" style='color:#123456' >登录</a>&nbsp;后才可以发表书评</span>
					</#if>
				</div>
				<div class="pinglun_input">
					<#if (loginUserInfo??)>
					<textarea id="commentContent" class="tac" placeholder="看完了不说两句不够仗义啊！说归说，不许骂街啊！" ></textarea>
					<input id="submitCommentBtn" class="btn" type="button" value="发 表" />
					</#if>
				</div>
				<div class="pinglun_tab">
					<ul id="comment_tab" >
						<li class="hot_a">所有书评...</li>
						<li>我的书评...</li>
						<li>书友书评...</li>
					</ul>
				</div>
				<div class="comment_pagination" ></div>
				<div class="pinglun_user" id="comment_list">
				</div>
				<div class="comment_pagination" ></div>
			</div>
			<#if (listOtherUserReadingBook?size > 0) >
			<div class="houdongContentBox">
				<div class="tit2">
					<h2>读此书的朋友们也读...</h2>
				</div>
				<div class="bookList">
					<ul id="hd3_div0">
						<#if (listOtherUserReadingBook?size > 4)>
						<#list listOtherUserReadingBook[0..4] as b>
						<li><a href="detail.action?bookId=${b.id}" title="${b.name}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></li>
						</#list>
						<#else>
						<#list listOtherUserReadingBook as b>
						<li><a href="detail.action?bookId=${b.id}" title="${b.name}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></li>
						</#list>
						</#if>
					</ul>
					<#if (listOtherUserReadingBook?size > 5) >
					<ul id="hd3_div1" style="display:none;">
						<#if (listOtherUserReadingBook?size > 9)>
						<#list listOtherUserReadingBook[5..9] as b>
						<li><a href="detail.action?bookId=${b.id}" title="${b.name}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></li>
						</#list>
						<#else>
						<#list listOtherUserReadingBook[5..] as b>
						<li><a href="detail.action?bookId=${b.id}" title="${b.name}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></li>
						</#list>
						</#if>
					</ul>
					</#if>
					<#if (listOtherUserReadingBook?size > 10) >
					<ul id="hd3_div2" style="display:none;">
						<#list listOtherUserReadingBook[10..] as b>
						<li><a href="detail.action?bookId=${b.id}" title="${b.name}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></li>
						</#list>
					</ul>
					</#if>
				</div>
				<ul class="bookTab2">
					<li id="hd3_btn0" onClick=" tabit('hd3',0,3,'hot')" class="hot_a" >1</li>
					<#if (listOtherUserReadingBook?size > 5) >
					<li id="hd3_btn1" onClick=" tabit('hd3',1,3,'hot')">2</li>
					<#if (listOtherUserReadingBook?size > 10) >
					<li id="hd3_btn2" onClick=" tabit('hd3',2,3,'hot')">3</li>
					</#if>
					</#if>
				</ul>
			</div>
			</#if>
		</div>
	</div>
	<div class="w310 mt10 right">
		<#if (listUserReadingDetail?? && listUserReadingDetail?size > 0)>
			<div class="bb1">
				<div class="tit1">
					<h2>我的阅读动态</h2>
					<ul class="bookTab2">
						<li class="hot_a" onclick=" tabit('ts1',0,3,'hot')" id="ts1_btn0">1</li>
						<#if (listUserReadingDetail?size > 1)>
						<li onclick=" tabit('ts1',1,3,'hot')" id="ts1_btn1">2</li>
						<#if (listUserReadingDetail?size > 2)>
						<li onclick=" tabit('ts1',2,3,'hot')" id="ts1_btn2">3</li>
						</#if>
						</#if>
					</ul>
				</div>
				<div class="con box5List">
					<#list listUserReadingDetail as d>
					<#assign b = d.book >
					<#if (d_index == 0)>
					<div id="ts1_div${d_index}" >
					<#else>
					<div id="ts1_div${d_index}" style="display:none" >
					</#if>
						<div class="bookJs">
							<a href="detail.action?bookId=${b.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}"></a>
							<h3><a href="detail.action?bookId=${b.id}">${b.name}</a></h3>
							<span>${b.author?default('&lt;暂无作者信息&gt;')}/${b.publisher?default('&lt;暂无出版社信息&gt;>')}</span>
							<div class="xingxing"><span class="s${b.score?default('0')?substring(0 , 1)}">评星</span><em>${b.score?default('0.0')}</em></div>
							<div class="tsBtn" >
								<a class="video_yd" href="read.action?bookId=${b.id}">继续阅读</a>
							</div>
						</div>
						<p>阅读到第 ${d.readingBook.lastReadPage} 页</p>
					</div>
					</#list>
				</div>
			</div>
		</#if>
		<#if (listOrgDayReadTopBook?? && listOrgDayReadTopBook?size > 0)>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>24小时热评榜</h2>
			</div>
			<div class="con bang">
				<ul>
					<#list listOrgDayReadTopBook as b>
					<li><a href="detail.action?bookId=${b.id}">${b.name}</a></li>
					</#list>
				</ul>
			</div>
		</div>
		</#if>
		
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>猜你可能感兴趣......</h2>
			</div>
			<div class="con boxListLi6">
				<ul>
					<#list listRecommendUserBook as b>
					<li>
						<a href="detail.action?bookId=${b.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a>
						<h3><a href="detail.action?bookId=${b.id}">${b.name}</a></h3>
						<p>
							作者：<span>${b.author?default('&lt;暂无作者信息&gt;')}</span><br />
						</p>
					</li>
					</#list>
				</ul>
			</div>
		</div>
		
		<#if (listReadBookUser?? && listReadBookUser?size > 0)>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>谁阅读了这本书</h2>
				<!-- <span><a href="#">查看全部&raquo;</a></span> -->
			</div>
			<div class="con padb10">
				<div class="indexUserList_dl">
					<#list listReadBookUser as u>
					<dl>
						<dt><a title="${u.displayName?default(u.userName)}" href="/user/${u.userId}/i.action" >
						<img 
						src="http://img3.chineseall.cn${u.headImg?default('/userHeadImg/moren/default.jpg')}" 
						onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" >
						</a></dt>
					</dl>
					</#list>
				</div>
			</div>
		</div>
		</#if>
	</div>
</div>
<script type="text/javascript" >
	String.prototype.replaceAll = function(s1,s2) {
	    return this.replace(new RegExp(s1,"gm"),s2);
	}
	$(document).ready(function(){
	
		var type , listDiv = $('#comment_list'), currentPage = 1 , pageSize = 10 , bookId = $('#bookId').val() , getLabelClazz = function(){
		    return new Array('fz19 c1' , 'fz14 c2' ,
		 'fz19 c3' , 'c4' , 'fz20 c5' , 'fz19 c6' , 'c10' ,
		 'fz16 c6' , 'fz22 c7' , 'fz19 c8');
		} , labelClazz ,
		toPage = function(page_index){
		
			var appendHTML = '' , currentPage = page_index , c = bookComment.list({type : (type || 'all') , currentPage : page_index , 
			pageSize : pageSize , bookId :bookId}) , list = c.list , paginationDiv = $(".comment_pagination");
			
			$('#commentTotalCount').html("共 " + c.count + " 条评论");
			if(c.count){
				paginationDiv.pagination(c.count, {
					items_per_page : pageSize,
					current_page: page_index - 1,
					prev_text:'上一页',
					next_text:'下一页' ,
					callback : function(page_index){toPage(page_index + 1)} ,
					num_edge_entries : 1,
					num_display_entries : 5,
					link_to : 'javascript:void(0)'
				});
				for(var i = 0; i < list.length ; i ++){
					var item = list[i];
					appendHTML += ctemplate.replaceAll('{content}',item.content)
					.replaceAll('{submiterAddress}',('/user/' + item.submiterId + '/i.action'))
					.replaceAll('{submiterHeadImg}',item.submiterHeadImg)
					.replaceAll('{submiterName}',item.submiterName)
					.replaceAll('{submitTime}',item.submitTime)
					.replaceAll('{id}',item.id)
					.replaceAll('{page}',item.page)
					.replaceAll('{usefulCount}',item.usefulCount)
					.replaceAll('{uselessCount}',item.uselessCount);	
				}
				listDiv.html(appendHTML).find('.zan,.cai').css({'cursor' : 'pointer'}).bind('click' , function(){
					var res = this.className == 'zan' ? bookComment.useful(this.rel) : bookComment.useless(this.rel);
					toPage(currentPage);
				});
			}else{
				paginationDiv.html('');
				listDiv.html('<div class="huodong_list_t"><span style="color:gray" >还没有人提交评论哦~</span></div>');
			}
		} , ctemplate = '<div class="huodong_list_t"><div class="dian" ><a class="zan" title="赞成" rel="{id}" >{usefulCount}</a><a class="cai" title="不赞成" rel="{id}">{uselessCount}</a></div><img src="http://img3.chineseall.cn{submiterHeadImg}" class="img"><h3><a href="{submiterAddress}" >{submiterName}</a></h3><span>{submitTime}</span><div class="p">{content}</div></div>';
		
		$('.shuqian li').each(function(){
		    if(!labelClazz || !labelClazz.length){
		        labelClazz = getLabelClazz();
		    }
		    var i = Math.floor(Math.random() * labelClazz.length);
		    this.className = labelClazz[i] || '';
		    labelClazz.splice(i , 1);
		})
		
		$('#comment_tab li').bind('click' , function(){
			$('#comment_tab li').removeClass('hot_a')
			type = this.innerHTML;
			if(type.indexOf('我的书评') == 0){
				type = 'my';
			}else if(type.indexOf('书友书评') == 0){
				type = 'friend'
			}else{
				type = 'all'
			}
			$(this).addClass('hot_a');
			toPage(1);
		});
		
		$('#submitCommentBtn').bind('click' , function(){
			var returnval = bookComment.add({bookId : bookId , content:$('#commentContent').val()});
			if(returnval.success){
				pop.alert('提交成功' , function(){
					$('#comment_tab li:eq(1)').click();
				});
			}else{
				alert(returnval.msg);
			}
		});
		
		toPage(1);
	})
</script>
</body>
</html>