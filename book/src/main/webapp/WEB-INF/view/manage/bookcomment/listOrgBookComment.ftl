<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.2"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">图书管理</a> &gt; 书评管理
</div>
<!--内容区-->
<div class="context">
<form action="/manage/bookcomment/listOrgBookComment.action" method="get">
	<div>
		<div style="float:left;width:200px;">
			书名:<input type="text" name="name" <#if bookCommentQueryVo??>value="${bookCommentQueryVo.name!''}"</#if> style="width:150px;" />
		</div>
		<div class="cont" style="float:left;width:200px;">
			作者:<input type="text" name="author" <#if bookCommentQueryVo??>value="${bookCommentQueryVo.author!''}"</#if> style="width:150px;"/>
		</div>
		<div class="cont" style="float:left;width:200px;">
			出版社:<input type="text" name="publisher" <#if bookCommentQueryVo??>value="${bookCommentQueryVo.publisher!''}"</#if> style="width:150px;" />
		</div>
		<div class="cont" style="float:left;width:80px;">
			<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
		</div>
		<div style="clear:both;margin-bottom:10px;"></div>
	</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<#if bookCommentQueryVo?? && bookCommentQueryVo.data?? && (bookCommentQueryVo.data?size > 0)>
	<div>
		<form method="post" action="/manage/bookcomment/deleteOrgBookComment.action">
		<div class="tableToolbar">
			<div class="rightTool">
				<input type="submit" value="删除选中书评" class="button blue" style="cursor:pointer;">
			</div>
			<input type="checkbox" id="selectAll" style="display:none;" />
			<input type="button" id="selectAllButton" value="全选" class="button green" style="cursor:pointer;">
			<input type="button" id="reverseButton" value="反选" class="button yellow" style="cursor:pointer;">
		</div>
		<table bgcolor="#ffffff" width="100%" cellspacing="2" cellpadding="5" class="table">
					<tbody>
					<#list bookCommentQueryVo.data as item>
					<tr>
						<td width="5%">
						<input type="checkbox" name="commentIds" value="${item.id}">
						</td>
						<td width="95%">
						<div style="float:none;clear:both;width:600px;word-wrap:break-word;word-break: normal;white-space:normal;">
						书评：${item.content!''}
						</div>
						<span style="float:none;clear:left;">
						用户:${item.userName!''}&nbsp;&nbsp;书名:${item.bookName!''}
						</span>
						<span style="float:right;">
						 发表于:${(item.submitTime!(.now))?datetime}
						</span>
						</td>
					</tr>
					</#list>
				</tbody>
		</table>
		</form>
	</div>
	<div class="bottomInfo2">
		<div class="bg1">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
	</div>
	</#if>
</div>
<script type="text/javascript">
$("#selectAllButton").click(function(){
	$("#selectAll").attr("checked",!$("#selectAll").attr("checked"));
	$("input[type='checkbox']").each(function(){
		if($("#selectAll").attr("checked")){
			$(this).attr("checked", true);
		}else{
			$(this).attr("checked", false);
		}
	});
});
$("#reverseButton").click(function(){
	$("input[type='checkbox']").each(function(){
		$(this).attr("checked", !$(this).attr("checked"))
	});
});
</script>