<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.0"></script>
<div class="form">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">图书管理</a> &gt; <a href="">本机构图书</a> &gt;图书详情
	</div>
	<form id="updateForm" action="/manage/orgbook/setOrgtreeBooksState.action" method="post">
	<input type="hidden" name="orgBookIds" value="${bookMap.bookId}">
	<input type="hidden" name="isHidden" value="${bookMap.isHidden!-1}" id="isHidden">
	<table width="100%" cellspacing="0" cellpadding="8" class="sub">
		<tbody>
			<tr>
				<th width="150">书名：</th>
				<td>${bookMap.bookName!''}</td>
				<td rowspan="6">
				<img src="http://${imgDomainName!'img3.chineseall.cn'}${ImageUtils.getBookImgUrl(bookMap.id)}" width="180px" height="200px" />
				</td>
			</tr>
			<tr>
				<th width="150">作者：</th>
				<td>${bookMap.author!''}</td>
			</tr>
			<tr>
				<th>出版社：</th><td>${bookMap.publisher!''}</td>
			</tr>
			<tr>
				<th>出版日期：</th><td>${bookMap.publishDate!''}</td>
			</tr>
			<tr>
				<th>阅读次数：</th><td>${bookMap.totalReadCount!0}</td>
			</tr>
			<tr>
				<th>推荐日期：</th><td><#if bookMap.creationTime??>${bookMap.creationTime?number_to_date}</#if></td>
			</tr>
			<tr>
				<th>简介：</th><td colspan="2">${bookMap.intro!''}</td>
			</tr>
			<tr>
				<th>状态：</th>
				<td colspan="2">
				<#if bookMap.isHidden?? && bookMap.isHidden==1>
					已隐藏&nbsp;&nbsp;
					<input type="button" value="显示" class="button yellow" style="cursor:pointer;" id="viewButton">
				<#else>
					正常显示&nbsp;&nbsp;
					<input type="button"  value="隐藏"  class="button yellow" style="cursor:pointer;" id="hiddenButton">
				</#if>
				<input type="button" value="返回" class="button" style="cursor:pointer;" id="backButton">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
	<script type="text/javascript">
	$("#backButton").click(function(){
		window.location.href="/manage/orgbook/listOrgtreeBooks.action";	
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
</div>