<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?3.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">图书管理</a> &gt; 暂存架
</div>
<!--内容区-->
<div class="context">
	<div>
		
	</div>
		<form id="purchaseForm" action="/manage/orgbook/buyBookInCart.action" method="post">
		<div class="bottomInfo">
			<#if pageUtil?? && pageUtil.items?? && (pageUtil.items?size > 0)>
			<div class="buttag">
				<input type="button" value="采购暂存架中的图书" class="button yellow"  style="cursor:pointer;"  id="purchaseButton">
			</div>
			</#if>
			我的积分:${leftPoint!0}&nbsp;&nbsp;暂存架图书:${pageUtil.totalCount!0}本&nbsp;&nbsp;所需积分:${needPoint!0}
		</div>
		</form>
		<#if pageUtil?? && pageUtil.items?? && (pageUtil.items?size > 0)>
		<form id="deleteForm" action="/manage/orgbook/deleteBookFromCart.action" method="post">
		<input type="button" value="删除选中" class="button yellow"  style="cursor:pointer;margin-top:10px;"  id="deleteButton">
		<table bgcolor="#ffffff" width="100%" cellspacing="2" cellpadding="5" class="table" style="margin-top:2px;">
		   <tbody>
				<tr>
				   <th><input type="checkbox" id="selectAll"></th><th>书名</th><th>书名作者</th><th>出版社</th><th>价格</th><th>操作</th>
			    </tr>
			<#list pageUtil.items as item>
			<tr style="text-align:center;">
				<td>
				<input type="checkbox" value="${item.bookId}" name="bookIds" id="bookIds${item.bookId}">
				</td>
				<td>${item.bookName!''}</td>
				<td>${item.author!''}</td>
				<td>${item.publisher!''}</td>
				<td>${item.bookCurrency!0}积分</td>
				<td><a href="#" name="deleteLink" id="${item.bookId}">删除</a></td>
			</tr>
			</#list>
			<tr>
			<td colspan="6">
				<div class="bottomInfo2">
					<div class="right">
						<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
					</div>
				</div>
			</td>
			</tr>
		</tbody>
		</table>
		</form>
		</#if>
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

$("#deleteButton").click(function(){
	$("#deleteForm").submit();
});
$("a[name='deleteLink']").click(function(){
	if(confirm("您确认要删除该条目吗?")){
		$("#bookIds"+$(this).attr("id")).attr("checked",true);		
		$("#deleteForm").submit();
	}
});
$("#purchaseButton").click(function(){
	$("#purchaseForm").submit();
});

$(document).ready(function(){
	<#assign msg = RequestParameters["msg"]!''?string/>
	if(${"'"+msg+"'"}!=''){
		alert(${"'"+msg+"'"})
	}
})
</script>