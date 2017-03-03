<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/tingshu.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/HTML5Player.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
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
					<dt>${c.classInfo.className} ......</dt>
					<dd>
						<ul>
							<#list c.childTypes as d>
								<#assign type = d.typeInfo >
								<#if (typeId ?? && typeId == type.typeId) >
									<#if (type.typeName?length < 6)>
										<li><a class="on" >${type.typeName} <em>(${d.bookCount})</em></a></li>
										<#else>
										<li><a class="on" title="${type.typeName}" >${type.typeName?substring(0 , 6)} <em>(${d.bookCount})</em></a></li>
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
			<!-- 
			<div class="path">
				<h2><a href="#">畅销・小说</a> &gt; <span>经典文学</span></h2>
			</div>
			-->
			<#assign book = detail.bookInfo >
			<div class="con xiangqing">
				<div class="boxListLi5">
					<div class="img"><a href="#"><img src="http://img3.chineseall.cn/audio/${book.imgUrl}" /></a></div>
					<h2><a href="#">${book.bookName}</a></h2>
					<div class="other">作者：<span>${book.authorName}</span> / 朗读：<span>${book.announcerName}</span> / 总章节：<span>${book.audioTimeScaleNo}</span></div>
					<#if (book.description?length > 80) >
						<p title="${book.description}" >${book.description?substring(0 , 80)}..</p>
						<#else>
						<p>${book.description}</p>
					</#if>
					<div class="box">
						<h2 id="playChapter" >${audioes[0].chapterName}</h2>
						<div class="tsBtn">
							<!--
							<a class="video_sc" href="#">收藏</a>
							<a class="video_tj" href="#">推荐</a>
							 -->
						</div>
						<div class="flashVideo">
							<script type="text/javascript">
							var player = new html5player("chineseall_player");
							player.create("http://html.chineseall.cn/static/script/HTML5Player.swf");
							
							$(document).ready(function(){
								$('.video_play').css({'cursor' : 'pointer'}).bind('click' , function(){
									var zj = $(this.parentNode.parentNode).find('.zj')[0]
									$('#playChapter').html(zj.title || zj.innerHTML);
									player.load("getAudioData.action?chapterNo=" + this.rel);
								});
							})
							</script>
						</div>
					</div>
				</div>
				<#if (playerFunc?? && playerFunc == AudioConstants.PLAYER_FUNC_ALL)>
				<div class="xiangqingList">
					<ul>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<#list audioes as a >
						<li>
							<#if (a.chapterName?length > 6)>
							<span class="zj" title="${a.chapterName}">${a.chapterName?substring(0,6)}..</span>
							<#else>
							<span class="zj">${a.chapterName}</span>
							</#if>
							<#if (a.audioFileTimeLenNo??)>
							<span class="time">${a.audioFileTimeLenNo / 60} : ${a.audioFileTimeLenNo % 60}</span>
							<#else>
							<span class="time">未知</span>
							</#if>
							<div class="tsBtn">
								<a class="video_play" rel="${a.chapterNo}" >播放</a>
							</div>
						</li>
							<#if ((a_index + 1) % 24 == 0) >
					</ul>
								<#if (audioes?size > (a_index + 1))>
					<ul>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
								</#if>
							</#if>
						</#list>
					<#if (audioes?size % 24 != 0) >
					</ul>
					</#if>
				</div>
				<div id="page"></div>
				<input type="hidden" id="listTotalCount" value="${audioes?size}" >
				<#else>
				<div class="xiangqingList">
					<ul>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<#list audioes as a >
						<#if (a_index = 0)>
						<li>
							<#if (a.chapterName?length > 6)>
							<span class="zj" title="${a.chapterName}">${a.chapterName?substring(0,6)}..</span>
							<#else>
							<span class="zj">${a.chapterName}</span>
							</#if>
							<#if (a.audioFileTimeLenNo??)>
							<span class="time">${a.audioFileTimeLenNo / 60} : ${a.audioFileTimeLenNo % 60}</span>
							<#else>
							<span class="time">未知</span>
							</#if>
							<div class="tsBtn">
								<a class="video_play" rel="${a.chapterNo}" title="试听" >播放</a>
							</div>
						</li>
						<#else>
						<li style="color:gray" title="没有播放权限~" >
							<#if (a.chapterName?length > 6)>
							<span class="zj" title="${a.chapterName}">${a.chapterName?substring(0,6)}..</span>
							<#else>
							<span class="zj">${a.chapterName}</span>
							</#if>
							<#if (a.audioFileTimeLenNo??)>
							<span class="time">${a.audioFileTimeLenNo / 60} : ${a.audioFileTimeLenNo % 60}</span>
							<#else>
							<span class="time">未知</span>
							</#if>
							<div class="tsBtn">
							</div>
						</li>
						</#if>
							<#if ((a_index + 1) % 24 == 0) >
					</ul>
								<#if (audioes?size > (a_index + 1))>
					<ul>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
						<li class="td">
							<span class="zj">章节列表</span>
							<span class="time">时长</span>
							<div class="tsBtn">
								播放
							</div>
						</li>
								</#if>
							</#if>
						</#list>
					<#if (audioes?size % 24 != 0) >
					</ul>
					</#if>
				</div>
				<div id="page"></div>
				<input type="hidden" id="listTotalCount" value="${audioes?size}" >
				</#if>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	function go(page_index){
		$($('.xiangqingList ul').css({display:'none'})[page_index]).css({display:''});
		$('#currentPage').val(page_index);
		$("#page").pagination($('#listTotalCount').val(), {
 			items_per_page:24,
		    current_page: page_index,
		    prev_text:'上一页',
		    next_text:'下一页' ,
		    num_edge_entries:2,
		    num_display_entries:8,
		    callback : go
		});
		$("#page").find('a').removeAttr('href');
		return false;
	}
	go(0)
	</script>
</div>
</body>
</html>
