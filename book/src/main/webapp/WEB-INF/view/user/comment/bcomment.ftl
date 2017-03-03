<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的书评_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
<#include "nav.ftl" />
	<dd class="BookReview">
		<div class="other" >
			<span class="info">&nbsp;</span>
			<a class="red" href="/user/commentbook.action">按书查看</a> | <a class="red" href="/user/comment.action">按单个书评发表时间查看</a> |
		</div>
		<#if (book??)>
		<div class="book">
			<div class="bookimg">
				<a target="_blank" class="img" href="/book/detail.action?bookId=${book.id}" >
				<img width="195" height="280" src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.id)}" /></a>
			</div>
			<div class="cont">
				<h2><a target="_blank" href="/book/detail.action?bookId=${book.id}" ><span title="${book.name}" >${book.name}</span></a></h2>
				作者：<span >${book.author?default('&lt;暂无作者信息&gt;')}</span><br />
				出版社：<span >${book.publisher?default('&lt;暂无出版社信息&gt;')}</span><br />
				出版日期：${book.publishDate?default('')}<br />
				<span title="" ></span>
				<div class="otherInfo">
					<#if (reading??)>
					<div class="times">
						开始阅读时间：<em id="startReadTime" >${reading.firstReadTime?datetime}</em><br />
						最后阅读时间：<em id="endReadTime" >${reading.lastReadTime?datetime}</em><br />
						目前阅读进度：第<em id="readPageCount" >${reading.lastReadPage}</em>页
					</div>
					<#else>
					<div class="times">
						您还没有读过 <em>${book.name}</em> 这本书
					</div>
					</#if>
					<!-- 
					<div class="plan"><em id="readSchedule" >0%</em><span class="load"><span id="readScheduleStyle" style="width:0px;"></span></span></div>
					-->
					<a target="_blank" class="but_goto" href="/book/read.action?bookId=${book.id}"></a>
				</div>
			</div>
		</div>
		</#if>
		<#if (list?? && list?size > 0)>
		<dl id="bookCommentDetail" class="ReviewText">
		<#list list as c >
		<dt><span class="right">第 ${c.page?default(0)} 页</span><strong>第 1条</strong> <span class="gray">${c.submitTime?datetime}</span></dt>
		<dd ><a class="red" name="delBtn" rel="${c.id}" style="float: right;cursor: pointer;" >删除</a>${c.content}</dd>
		</#list>
		</dl>
		<form id="p" method="get" action="bcomment.action" >
			<input type="hidden" id="bookId" name="bookId" value="${book.id}" />
			<input type="hidden" id="currentPage" name="currentPage" value="${currentPage?default(1)}" />
			<input type="hidden" id="totalCount" name="currentPage" value="${count?default(0)}" />
		</form>
		<div id="pagination" style="clear:both;padding-top:10px"></div>
		</#if>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript">
	$(document).ready(
		function(){
			var go = function(page_index){
				$('#currentPage').val(page_index + 1);
				$('#p').submit();
				return false;
			}
			if($('#totalCount').val() != null){
				$("#pagination").pagination($('#totalCount').val(), {
		 			items_per_page:12,
				    current_page: (Number($('#currentPage').val()) - 1),
				    prev_text:'上一页',
				    next_text:'下一页' ,
				    callback : go
				});
			}
			var flushPage = function(){
				window.location = window.location;
			}
			$('a[name="delBtn"]').css({cursor: 'pointer' , float: 'right'}).bind('click' , function(){
				deleteBookComment(this.rel);
			});
			var deleteBookComment = function(commentId){
				confirmBox("确认删除该书评？",function(){
					var params = {"commentId" : commentId}
					$.ajax({
						url : "/book/deletecomment.action",
						data : params,
						cache : false,
						async : false,
						dataType : "json",
						success : function(data) {
							if (data) {
								messageBox(data.msg , (data.success ? 'success' : 'failure') , function(){
									flushPage(); 
								})
							}
						}
					});
				})
			}
			$(".tit a:contains('我的书评')").attr('class' , 'hot');
		}
	)
</script>
<#include "../bottom.ftl" />
</body>
</html>
