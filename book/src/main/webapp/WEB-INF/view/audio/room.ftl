<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/tingshu.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
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
</head>
<body>
<div class="tingshu">
	<div class="w310 left">
		<div class="bb1 sideMenu">
			<#list classes as c>
				<#if (c.classInfo.className?? && cname?? && c.classInfo.className == cname)>
				<dl class="on">
				<#else>
				<dl>
				</#if>
					<dt><a href="room.action?classId=${c.classInfo.classId}&cname=${c.classInfo.className}" >${c.classInfo.className} ......</a></dt>
					<dd>
						<ul>
							<#list c.childTypes as d>
								<#assign type = d.typeInfo >
								<#if (typeId ?? && typeId == type.typeId) >
									<#if (type.typeName?length < 6)>
										<li class="on" ><a>${type.typeName} <em>(${d.bookCount})</em></a></li>
										<#else>
										<li class="on" ><a title="${type.typeName}" >${type.typeName?substring(0 , 6)} <em>(${d.bookCount})</em></a></li>
									</#if>
									<#else>
									<#if (type.typeName?length < 6)>
										<li><a href="room.action?typeId=${type.typeId}&classId=${c.classInfo.classId}&cname=${c.classInfo.className}&tname=${type.typeName}">${type.typeName} <em>(${d.bookCount})</em></a></li>
										<#else>
										<li><a href="room.action?typeId=${type.typeId}&classId=${c.classInfo.classId}&cname=${c.classInfo.className}&tname=${type.typeName}" title="${type.typeName}" >${type.typeName?substring(0 , 5)}... <em>(${d.bookCount})</em></a></li>
									</#if>
								</#if>
							</#list>
							<#if (c_index == (classes?size - 1)) >
								<li class="c"><a href="typeindex.action">【所有分类】</a></li>
							</#if>
						</ul>
					</dd>
				</dl>
			</#list>
		</div>
		<#if (listAudioReadLogDetail?? && listAudioReadLogDetail?size > 0)>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>我的听书动态</h2>
				<ul class="bookTab2">
					<#if (listAudioReadLogDetail?size > 0)>
					<li class="hot_a" onclick=" tabit('ts1',0,${listAudioReadLogDetail?size},'hot')" id="ts1_btn0">1</li>
					<#if (listAudioReadLogDetail?size > 1)>
					<li onclick=" tabit('ts1',1,${listAudioReadLogDetail?size},'hot')" id="ts1_btn1">2</li>
					<#if (listAudioReadLogDetail?size > 2)>
					<li onclick=" tabit('ts1',2,${listAudioReadLogDetail?size},'hot')" id="ts1_btn2">3</li>
					</#if>
					</#if>
					</#if>
				</ul>
			</div>
			<div class="con box5List">
				<#list listAudioReadLogDetail as d >
				<#assign log = d.log />
				<#assign info = d.info />
				<#assign book = d.bookInfo />
				<#if (d_index == 0)>
				<div id="ts1_div${d_index}">
				<#else>
				<div id="ts1_div${d_index}" style="display:none">
				</#if>
					<div class="boxListLi5">
						<div class="img"><a href="detail.action?bookId=${book.bookId}"><img src="http://img3.chineseall.cn/audio/${book.imgUrl}" /></a></div>
						<h2><a href="detail.action?bookId=${book.bookId}">${book.bookName}</a></h2>
						<div class="other">作者：<span>${book.authorName}</span> / 朗读：<span>${book.announcerName}</span></div>
						<div class="tsBtn">
							<a class="video_play" href="detail.action?bookId=${book.bookId}">播放</a>
						</div>
					</div>
					<!-- <strong>刚刚听到：</strong><span>${info.chapterName}</span> -->
				</div>
				</#list>
			</div>
		</div>
		</#if>
		<#if (listRandomGetAudioBookInfo?? && listRandomGetAudioBookInfo?size > 0)>
		<div class="bb1 mt10">
			<div class="tit1">
				<h2>猜你可能感兴趣......</h2>
			</div>
			<div class="con boxListLi6">
				<ul>
					<#list listRandomGetAudioBookInfo as book >
					<li>
						<a href="detail.action?bookId=${book.bookId}"><img src="http://img3.chineseall.cn/audio/${book.imgUrl}" /></a>
						<h3><a href="detail.action?bookId=${book.bookId}">${book.bookName}</a></h3>
						<p>
							作者：<span>${book.authorName}</span><br />
							朗读：<span>${book.announcerName}</span>
						</p>
						<div class="tsBtn">
							<a class="video_play" href="detail.action?bookId=${book.bookId}">播放</a>
						</div>
					</li>
					</#list>
				</ul>
			</div>
		</div>
		</#if>
	</div>
	<div class="w630 right">
		<div class="bb1 tingshuList">
			<div class="path">
				<#if (cname??)>
				<h2><a href="room.action" >全部听书</a> &gt; <a style="color:#123456;" href="room.action?classId=${classId}&cname=${cname}" >${cname}</a> <#if (typeId??)>&gt; <a href="room.action?typeId=${typeId}&cname=${cname}&tname=${tname}" ><span>${tname}</span></a></#if> </h2>
				<#else>
				<h2><a href="room.action" >全部听书</a></h2>
				</#if>
				<!-- <div class="path_px"><a href="#">综合排序</a> / <a href="#" class="on">按更新日期排序</a> / <a href="#">按评价排序</a></div> -->
			</div>
			<div class="con">
			<#if (pageUtil?? && pageUtil.items??)>
			<#assign rightList = pageUtil.items />
			<#list rightList as d>
				<#assign book = d.bookInfo >
				<div class="boxListLi5">
					<div class="img"><a href="detail.action?bookId=${book.bookId}"><img src="http://img3.chineseall.cn/audio/${book.imgUrl}" /></a></div>
					<h2><a href="detail.action?bookId=${book.bookId}">${book.bookName}</a></h2>
					<div class="other">作者：<span>${book.authorName}</span> / 朗读：<span>${book.announcerName}</span> / 总章节：<span>${book.audioTimeScaleNo}</span></div>
					<#if (book.description?length > 80) >
						<p title="${book.description}" >${book.description?substring(0 , 80)}..</p>
						<#else>
							<p>${book.description}</p>
					</#if>
					<div class="tsBtn">
						<a class="video_play" href="detail.action?bookId=${book.bookId}">播放</a>
						<!-- 
							<a class="video_sc" href="#">收藏</a>
							<a class="video_tj" href="#">推荐</a>
						-->
					</div>
				</div>
			</#list>
				<form id="listForm" action="room.action" method="get" >
					<#--<input type="hidden" id="listTotalCount" value="${rightListCount}" >-->
					<input type="hidden" name="currentPage" id="currentPage" value="${currentPage?default(1)}" />
					<#if (typeId??)>
					<input type="hidden" name="typeId" value="${typeId}" />
					<input type="hidden" name="tname" value="${tname?default('')}" />
					</#if>
					<#if (classId??)>
					<input type="hidden" name="classId" value="${classId}" />
					<input type="hidden" name="cname" value="${cname?default('')}" />
					</#if>
				</form>
				<div style="display: inline-block;line-height: 20px;width: 100%;" >
				<@c.pageLine pageUtil=pageUtil queryCondition='' />
				</div>
			</#if>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(
	function(){
		//if($('#page').length){
			//$("#page").pagination($('#listTotalCount').val(), {
	 			//items_per_page:12,
			    //current_page: (Number($('#currentPage').val()) - 1),
			    //prev_text:'上一页',
			    //next_text:'下一页' ,
			    //num_edge_entries:2,
			    //num_display_entries:8,
			    //callback : function(page_index){go(page_index + 1)}
			//});
			//$("#page").find('a').removeAttr('href');
		//}
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
