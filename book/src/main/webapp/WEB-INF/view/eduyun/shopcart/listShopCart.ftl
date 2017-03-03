<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="/common/yuelanshi.css" rel="stylesheet" />
<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
<style>
.bookGsd_t{ border:#c7d5df 1px solid; border-width:1px 1px 0; padding:0
16px; height:28px; line-height:28px; color:#2d2e31; background:#d7dfec;}
.bookGsd_t span{ padding-right:16px;}
.bookGsd_c{ margin-bottom:10px; background:#fff;}
.bookGsd_c table{ border-collapse:collapse;}
.bookGsd_c td{ border:#c7d5df 1px solid; padding:12px;}
.bookGsd_c_book{ padding:0 0 0 68px; height:78px; overflow:hidden;}
.bookGsd_c_book img{ position:absolute; margin-left:-68px; width:58px;
height:78px;}
.bookGsd_c_book p{ height:40px; overflow:hidden;}
a.table_btn{ display:block; margin:0 auto; width:87px; height:29px;
line-height:29px; color:#fff; text-align:center; font-size:14px;
background:url(table_btn1.png) no-repeat;}
a.table_btn:hover{ text-decoration:none;}
.goumaiContent{ margin:10px auto; border:#c7d5df 1px solid;
border-width:1px 0 0 1px; width:949px; overflow:hidden; background:#fff;}
.goumaiContent th{ padding:0 16px; height:28px; line-height:28px;
color:#2d2e31; background:#d7dfec;}
.goumaiContent th span{ margin:0 5px;}
.goumaiContent .gwczt{ padding-left:60%;}
.goumaiContent .gwczt span{ float:left;}
.goumaiContent .ztt{ float:left; margin-top:6px; border:#949aa3 1px solid;
padding:2px; width:100px; height:11px; font-size:0; overflow:hidden;}
.goumaiContent .ztt em{ display:block; float:left; height:11px;
font-size:0; background:#90b2d9;}
.goumaiContent table{ border-collapse:collapse;}
.goumaiContent td{ border:#c7d5df 1px solid; padding:12px;}
.xingxing strong{ float:left; font-weight:normal;}
.xingxing span{ float:left; display:block; margin-top:3px; width:72px;
height:12px; overflow:hidden; text-indent:-999em; background:url(xx.png)
no-repeat;}
.xingxing span.s1{ background-position:0 -12px;}
.xingxing span.s2{ background-position:0 -24px;}
.xingxing span.s3{ background-position:0 -36px;}
.xingxing span.s4{ background-position:0 -48px;}
.xingxing span.s5{ background-position:0 -60px;}
</style>
</head>
<body>
<div class="goumaiContent">
	<form id="deleteForm" action="" method="POST">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<th><input type="checkbox" name="checkAll" checked/><span><a href="javascript:void(0);">全选</a></span><span><a id="deleteCheck" href="javascript:void(0);">批量删除</a></span></th>
			<script>
			$(document).ready(function(){
				$("input[name='checkAll']").click(function(){
					$("input[name='ids']").attr("checked",$(this).attr("checked"));
				})
				$("input[name='ids']").click(function(){
					$("input[name='checkAll']").attr("checked",$("input[name='ids']:checked").length==<#if data??>${data.bookPackageList?size+data.bookList?size}<#else>0</#if>);
				})
				$("#deleteCheck").click(function(){
					$("#deleteForm").attr("action","/edushopcart/deleteItem.action");
					$("#deleteForm").submit();
				})
			})
			</script>
			<th align="right" colspan="3">
				<div class="gwczt">
					<span>购物车状态：</span>
					<div class="ztt">
						<em style="width:<#if data??>${100/(50/(data.bookPackageList?size+data.bookList?size))}<#else>0</#if>%;"></em>
					</div>
					<span><#if data??>${data.bookPackageList?size+data.bookList?size}<#else>0</#if>/50</span>
				</div>
			</th>
		</tr>
		<#if data??>
		<#list data.bookPackageList as package>
		<tr>
			<td align="center" valign="middle"><input type="checkbox" name="ids" value="${package.carId!''}" checked /></td>
			<td>
				<div class="bookGsd_c_book" style="width:400px;">
		    		<a href="/eduyun/package/detail.action?id=${package.id!''}" target="_blank"><img src="${package.cover!''}" /></a>
		    		<h3><a href="/eduyun/package/detail.action?id=${package.id!''}" target="_blank">${package.name!''}</a></h3>
		    		<p><a href="/eduyun/package/detail.action?id=${package.id!''}" target="_blank">推荐语：<#if package.intro??><#if package.intro?length gt 60>${package.intro?substring(0,60)}...<#else>${package.intro!''}</#if></#if> </a></p>
		    	</div>
			</td>
			<td align="center" valign="middle">#{(package.price/100);m0}云币</td>
			<td align="center" valign="middle"><a href="/edushopcart/deleteItem.action?ids=${package.carId!''}">删除</a></td>
		</tr>
		</#list>
		<#list data.bookList as book>
		<tr>
			<td align="center" valign="middle"><input type="checkbox" name="ids" value="${book.carId!''}" checked /></td>
			<td width="55%">
				<div class="bookGsd_c_book">
		    		<a href="/book/detail.action?bookId=${book['bookId']!''}" target="_blank"><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.bookId)}" /></a>
		    		<h3><a href="/book/detail.action?bookId=${book['bookId']!''}" target="_blank">${book['bookName']!''}</a></h3>
		    		<span>作者：${book['author']!''}   出版社：${book['publisher']!''}</span>
		    		<p><a href="/book/detail.action?bookId=${book['bookId']!''}" target="_blank">介绍：<#if book.intro??><#if book.intro?length gt 60>${book.intro?substring(0,60)}...<#else>${book.intro!''}</#if></#if></a></p>
		    	</div>
			</td>
			<td align="center" valign="middle">#{((book.price!0)/100);m0}云币</td>
			<td align="center" valign="middle"><a href="/edushopcart/deleteItem.action?ids=${book.carId!''}">删除</a></td>
		</tr>
		</#list>
		<tr>
			<td align="right" valign="middle" colspan="4"><div class="tsBtn" style="float:right;">
				<a id="addOrderBtn" class="video_gm" style="background: none repeat scroll 0 0 red;" href="javascript:void(0);">去支付</a>
				<script>
					$("#addOrderBtn").click(function(){
						$("#deleteForm").attr("action","/user/addOrders.action");
						$("#deleteForm").submit();
					})
				</script>
			</div></td>
		</tr>
		</#if>
	</table>
	</form>
<!--script>
$(document).ready(function(){
	if("${msg!''}"!=""){
		alert("${msg!''}")
	}
})
</script-->
</div>
</body>
</html>
