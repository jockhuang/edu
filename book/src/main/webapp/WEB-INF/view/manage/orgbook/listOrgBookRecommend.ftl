<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">图书管理</a> &gt; <a href="">选书中心</a> &gt; 用户推荐的图书
</div>
<br/>
<div class="greenNav2">
	<a href="/manage/orgbook/listOrgChooseBooks.action">选书中心</a> | <a class="hot" href="/manage/orgbook/listOrgBookRecommend.action">用户推荐的图书</a>
</div>
<!--内容区-->
<div class="context">
	<div>
		<table width="100%" cellspacing="2" cellpadding="8" class="listTable">
			<tbody>
			<tr>
				<th>
				<input type="checkbox" id="selectAll">
				</th>
				<td>
				<div class="leftTool">
				<span style="float:left;">
				<input type="button" value="放入暂存架" class="button yellow" style="cursor:pointer;" id="addShopCartButton">
				<input type="button" value="查看暂存架" class="button green" style="cursor:pointer;" id="shopCartButton">
				</span>
				</div>
				</td>
			</tr>
			<form id="addForm" action="/manage/orgbook/addToShopCart.action" method="post">
			<#list pageUtil.items as item>
			<tr <#if (item_index%2==0)>class="bg1"</#if>>
				<th>
				<input type="checkbox" name="bookIds" value="${item.id}" id="bookIds${item.id}">
				</th>
				<td class="listbooks1">
				<a href="/manage/orgbook/showChooseBookDetail.action?bookId=${item.id}" class="book">
				<img src="http://${imgDomainName!'img3.chineseall.cn'}${ImageUtils.getBookImgUrl(item.id)}"></a><h4>
				<a href="/manage/orgbook/showChooseBookDetail.action?bookId=${item.id}">${item.bookName!''}</a>
				</h4>
				<p>
					<span class="gray">作者：</span>${item.author!''}<span class="gray"> 出版社:</span>${item.publisher!''} <span class="gray"> 出版日期:</span>${item.publishDate!''} <span class="gray"> 推荐次数:</span>${item.total!0}次
				</p>
				<p>
					<span class="gray">简介：</span>${item.intro!''}
				</p>
				<p>
					<span class="gray">阅读次数:</span>${item.totalReadCount!0}
					<span class="gray">价格:</span>${item.bookCurrency!0}积分
					<span style="float:right;">
					<input type="button" value="放入暂存架" class="button yellow" style="cursor:pointer;" name="singleAddButton" id="${item.id}">
					</span>
				</p></td>
			</tr>
			</#list>
			</form>
		</tbody>
		</table>
	</div>
	<div class="bottomInfo2">
		<div class="right">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
	</div>
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

$("#addShopCartButton").click(function(){
	$("#addForm").submit();
});

$("input[name='singleAddButton']").click(function(){
	$("#bookIds"+$(this).attr("id")).attr("checked", true);
	$("#addForm").submit();
});

$("#imgListButton").click(function(){
	//TODO:addCookie
	alert("bbbb");
	window.location.reload();
});

$("#textListButton").click(function(){
	//TODO:addCookie
	alert("aaaa");
	window.location.reload();
});

$("#shopCartButton").click(function(){
	window.location.href="/manage/orgbook/listShopCart.action";
});

$("#exportButton").click(function(){
	if(!'${queryCondition}'){
		alert("您并未添加搜索条件!");
	}
	window.location.href="/manage/orgbook/exportOrgChooseBook.action?${queryCondition}";
});
</script>