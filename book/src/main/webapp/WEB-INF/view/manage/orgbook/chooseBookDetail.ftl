<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.1"></script>
<div class="form">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">图书管理</a> &gt; <a href="">选书中心</a> &gt;图书详情
	</div>
	<form id="updateForm" action="/manage/orgbook/addToShopCart.action" method="get">
	<input type="hidden" name="bookIds" value="${bookMap.id}" id="bookIds${bookMap.id}">
	<table width="100%" cellspacing="0" cellpadding="8" class="sub">
		<tbody>
		<tr>
			<th width="150">书名：</th>
			<td>${bookMap.bookName!''}</td>
			<td rowspan="6">
			<img src="http://${imgDomainName!'img3.chineseall.cn'}${ImageUtils.getBookImgUrl(bookMap.id)}" width="160px" height="180px" />
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
			<th>阅读次数：</th><td>${bookMap.readCount!0}</td>
		</tr>
		<tr>
			<th>价格：</th><td><#if bookMap.bookCurrency??>${bookMap.bookCurrency?string("#0")}</#if></td>
		</tr>
		<tr>
			<th>简介：</th><td colspan="2">${bookMap.intro!''}</td>
		</tr>
		<tr>
			<th></th>
			<td colspan="2">
			<div class="tool">
				<input type="button" value="试读" class="button yellow" style="cursor:pointer;" id="tryButton">
				<input type="button" value="放入暂存架" class="button yellow" style="cursor:pointer;" id="addToCartButton">
			</div>
			</td>
		</tr>
	</tbody>
	</table>
	</form>
	<script type="text/javascript">
	$("#tryButton").click(function(){
		window.open("/book/read.action?bookId=${bookMap.id!''}");	
	});
	
	$("#addToCartButton").click(function(){
		$("#updateForm").submit();
	});
	</script>
</div>