<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/yuelanshi.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.operation.js"></script>
<#--
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
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
</style>
-->
<style type="text/css" >
.video_sd{
	background: none repeat scroll 0 0 #CD5C5C;
}
a.video_sd:hover{
	background: none repeat scroll 0 0 #F08080;
}
</style>
</head>
<body>
<div class="yuelanshi">
	<div class="w310 left">
		<div class="bb1 sideMenu">
			<div class="tit1">
				<h2>图书分类</h2>
			</div>
			<#list listOrgSelfSortDetail as sort>
				<#if (sort.selfSort.name?? && sname?? && sort.selfSort.name == sname)>
				<dl class="on">
				<#else>
				<dl>
				</#if>
					<dt>${sort.selfSort.name} ......</dt>
					<dd>
						<ul>
							<#list sort.childSelfSorts as d>
								<#assign childSort = d.selfSort >
								<#if (selfSortId?? && selfSortId == childSort.id) >
									<#if (childSort.name?length < 6)>
										<li class="on" ><a href="room.action?sname=${sort.selfSort.name}&selfSortId=${childSort.id}&selfSortName=${childSort.name}">${childSort.name} <em>(${d.bookCount})</em></a></li>
										<#else>
										<li class="on" ><a href="room.action?sname=${sort.selfSort.name}&selfSortId=${childSort.id}&selfSortName=${childSort.name}" title="${childSort.name}" >${childSort.name?substring(0 , 6)} <em>(${d.bookCount})</em></a></li>
									</#if>
									<#else>
									<#if (childSort.name?length < 6)>
										<li><a href="room.action?sname=${sort.selfSort.name}&selfSortId=${childSort.id}&selfSortName=${childSort.name}">${childSort.name} <em>(${d.bookCount})</em></a></li>
										<#else>
										<li><a href="room.action?sname=${sort.selfSort.name}&selfSortId=${childSort.id}&selfSortName=${childSort.name}" title="${childSort.name}" >${childSort.name?substring(0 , 5)}... <em>(${d.bookCount})</em></a></li>
									</#if>
								</#if>
							</#list>
						</ul>
					</dd>
				</dl>
			</#list>
		</div>
		<div class="bb1 mt10 top">
			<div class="tit">
				<ul style="padding-left:65px;" >
					<li id="top_btn0" onclick=" tabit('top',0,2,'hot')" class="hot_a" >阅读榜</li>
					<li id="top_btn1" onclick=" tabit('top',1,2,'hot')">收藏榜</li>
				</ul>
			</div>
			<div class="con">
				<ul id="top_div0" >
					<#if (listOrgReadingTopBook?size > 0) >
						<#assign top = listOrgReadingTopBook[0] >
						<li class="li1 bookJs">
							<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(top.id)}" />
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
					<#if (listOrgReadingTopBook?size > 1)>
						<#list listOrgReadingTopBook[1..] as b>
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
				<ul id="top_div1" style="display:none;">
					<#if (listOrgCollectionTopBook?size > 0) >
						<#assign top = listOrgCollectionTopBook[0] >
						<li class="li1 bookJs">
							<img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(top.id)}" />
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
					<#if (listOrgCollectionTopBook?size > 1)>
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
		<#if (listReadingDetail?? && listReadingDetail?size > 0)>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>我的阅读动态</h2>
					<ul class="bookTab2">
						<li class="hot_a" onclick=" tabit('ts1',0,3,'hot')" id="ts1_btn0">1</li>
						<#if (listReadingDetail?size > 1)>
						<li onclick=" tabit('ts1',1,3,'hot')" id="ts1_btn1">2</li>
						<#if (listReadingDetail?size > 2)>
						<li onclick=" tabit('ts1',2,3,'hot')" id="ts1_btn2">3</li>
						</#if>
						</#if>
					</ul>
				</div>
				<div class="con box5List">
					<#list listReadingDetail as d>
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
							<div class="btn">
								<a href="read.action?bookId=${b.id}">继续阅读</a>
							</div>
						</div>
						<p>阅读到第 ${d.readingBook.lastReadPage} 页</p>
					</div>
					</#list>
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
	</div>
	<div class="w630 right">
		<div class="bb1 yuelanshiList">
			<div class="path">
			<h2><a href="room.action" >全部图书</a> <#if (selfSortId??)>&gt; <span>${selfSortName}</span></#if> </h2>
				<div class="path_px"><a rel="new" >按更新日期排序</a> / <a rel="score" >按评价排序</a></div>
			</div>
			<div class="con">
				<#if (pageUtil?? && pageUtil.items?? && pageUtil.items?size > 0)>
					<#assign listSelfSortBook = pageUtil.items />
					<#list listSelfSortBook as b>
						<div class="boxListLi5" >
							<div class="img"><a href="detail.action?bookId=${b.id}"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(b.id)}" /></a></div>
							<h2><a href="detail.action?bookId=${b.id}">${b.name}</a></h2>
							<div class="other"><span>${b.author?default('&lt;暂无作者信息&gt;')} / ${b.publisher?default('&lt;暂无出版社信息&gt;')} / ${b.publishDate?default('&lt;暂无出版日期&gt;')} /</span><div class="xingxing"><span class="s${b.score?default('0')?substring(0 , 1)}">评星</span><em>${b.score?default('0.0')}</em></div></div>
							<p>${intros[b.id?string]?default('&lt;暂无简介&gt;')}</p>
							<div class="tsBtn">
								<#if buyInfos[b.id?string]==0><a class="video_sd" href="read.action?bookId=${b.id}">试读</a><#else><a class="video_yd" href="read.action?bookId=${b.id}">阅读</a></#if>
								<#if (listCollectionBookId?seq_contains(b.id))>
								<a class="video_no">已收藏</a>
								<#else>
								<a class="video_sc" href="javascript:book.operation(${b.id}).collection()">收藏</a>
								</#if>
								<a class="video_tj" href="/book/detail.action?bookId=${b.id}">查看详情</a>
							</div>
						</div>
					</#list>
					<div style="display: inline-block;line-height: 20px;width: 100%;" >
					<@c.pageLine pageUtil=pageUtil queryCondition='' />
					</div>
				</#if>
				<form id="listForm" action="room.action" method="get" >
					<input type="hidden" name="currentPage" id="currentPage" value="${currentPage?default(1)}" />
					<input type="hidden" name="sname" value="${sname?default('')}" />
					<input type="hidden" name="selfSortId" value="${selfSortId?default('')}" />
					<input type="hidden" name="selfSortName" value="${selfSortName?default('')}" />
					<input type="hidden" name="order" value="${order?default('new')}" />
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(
	function(){
		//var page = $('#page') , orderByBtn = $('.path_px a') , order = $("input[name='order']");
		//if(page.length){
			//page.pagination($('#listTotalCount').val(), {
	 			//items_per_page:10,
			    //current_page: (Number($('#currentPage').val()) - 1),
			    //prev_text:'上一页',
			    //next_text:'下一页' ,
			    //num_edge_entries:2,
			    //num_display_entries:8,
			    //callback : function(page_index){go(page_index + 1)}
			//});
			//page.find('a').removeAttr('href');
		//}
		var orderByBtn = $('.path_px a') , order = $("input[name='order']");
		
		orderByBtn.css('cursor' , 'pointer').bind('click' , function(){
			order.val(this.rel);
			go(1);
		});
		orderByBtn.filter("[rel='" + order.val() + "']").addClass('on');
	}
)

function go(page_index){
	$('#currentPage').val(page_index);
	$('#listForm').submit();
	return false;
}
</script>
</body>
</html>
