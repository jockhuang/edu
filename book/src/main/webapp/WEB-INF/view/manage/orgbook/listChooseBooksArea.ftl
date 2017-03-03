<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">基本信息</a> &gt; 页面风格
</div>
<!--内容区-->
<div class="context">
<form action="/manage/orgbook/listOrgtreeBooks.action" method="get">
	<div>
		<div style="float:left;width:120px;">
			书名:<input type="text" value="${bookQueryVo.name!''}" name="name" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:120px;">
			作者:<input type="text" value="${bookQueryVo.author!''}" name="author" style="width:80px;"/>
		</div>
		<div class="cont" style="float:left;width:140px;">
			出版社:<input type="text" value="${bookQueryVo.publisher!''}" name="publisher" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:140px;">
			图书id:<input type="text" value="${bookQueryVo.bookId!''}" name="bookId" id="bookId" style="width:80px;" />
		</div>
		<div class="cont" style="float:left;width:160px;">
			状态:<select id="state" name="state">
			<option value="-1">请选择</option>
			<option value="0" <#if bookQueryVo.state??&&bookQueryVo.state==0>selected</#if>>正常</option>
			<option value="1" <#if bookQueryVo.state??&&bookQueryVo.state==1>selected</#if>>隐藏</option>
			</select>
			<input type="submit" value="查 询" class="buttonmin yellow" style="cursor:pointer;">
		</div>
		<div style="clear:both;margin-bottom:10px;"></div>
	</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<#if bookQueryVo?? && bookQueryVo.data?? && (bookQueryVo.data?size > 0)>
	<div>
	<form id="updateForm" action="/manage/orgbook/setOrgtreeBooksState.action" method="post">
		<input type="hidden" value="-1" name="isHidden" id="isHidden" />
		<table width="100%" cellspacing="2" cellpadding="8" class="listTable">
			<tbody>
			<tr>
				<th>
				<input type="checkbox" id="selectAll">
				</th>
				<td>
				<input type="button" value="导出搜到的图书" class="button blue right">
				<input type="button" value="显示选中图书" class="button yellow" style="cursor:pointer;" id="viewButton">
				<input type="button" value="隐藏选中图书" class="button" style="cursor:pointer;"  id="hiddenButton">
				</td>
			</tr>
			<#list bookQueryVo.data as item>
			<tr <#if (item_index%2==0)>class="bg1"</#if>>
				<th>
				<input type="checkbox" name="orgBookIds" value="${item.id}">
				</th>
				<td class="listbooks1">
				<a href="/manage/orgbook/showChooseBookDetail.action?bookId=${item.id}" class="book"><img src="http://news.google.com/news/tbn/jMuZkAqPvLMJ/6.jpg"></a><h4>
				<a href="/manage/orgbook/showChooseBookDetail.action?bookId=${item.id}">${item.bookName!''}</a>
				</h4>
				<p>
					<span class="gray">作者：</span>${item.author!''}<span class="gray"> 出版社:</span>${item.publisher!''} <span class="gray"> 出版日期:</span>${item.publishDate!''}
				</p>
				<p>
					<span class="gray">简介：</span>${item.intro!''}
				</p>
				<p>
					<span class="gray">阅读次数：</span>${item.totalReadCount!0}
					<#if item.isHidden?? && item.isHidden==1>
						<input type="button"  value="隐藏"  class="buttonmin">
					<#else>
						<input type="button"  value="显示" class="buttonmin yellow">
					</#if>
				</p></td>
			</tr>
			</#list>
		</tbody>
		</table>
	</div>
	<div class="bottomInfo2">
		<div class="right">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
	</div>
	</#if>
</div>
<script type="text/javascript">
$("#selectAll").click(function(){
	$("input[type='checkbox']").each(function(){
		if($("#selectAll").attr("checked")){
			$(this).attr("checked", true);
		}else{
			$(this).attr("checked", false);
		}
	});
});

$("#viewButton").click(function(){
	$("#isHidden").val(0);
	$("#updateForm").submit();
});
$("#hiddenButton").click(function(){
	$("#isHidden").val(1);
	$("#updateForm").submit();
});
</script>