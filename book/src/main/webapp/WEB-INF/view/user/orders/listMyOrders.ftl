<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书房首页－书香中国</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="author" content="artwc@foxmail.com" />
<link rel="icon" href="favicon.ico" />
<link rel="Shortcut Icon" href="favicon.ico" />
<link rel="Bookmark" href="favicon.ico" />
<link href="/common/layout.css" rel="stylesheet" />
<link href="/common/yuelanshi.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
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
background:url(/images/table_btn1.png) no-repeat;}
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
height:12px; overflow:hidden; text-indent:-999em; background:url(/images/xx.png)
no-repeat;}
.xingxing span.s1{ background-position:0 -12px;}
.xingxing span.s2{ background-position:0 -24px;}
.xingxing span.s3{ background-position:0 -36px;}
.xingxing span.s4{ background-position:0 -48px;}
.xingxing span.s5{ background-position:0 -60px;}
</style>
</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
	<#list pageUtil.items as item>
	<div class="bookGsd">
		<div class="bookGsd_t">
			<span>书单编号：${item.ordersNo!''}</span><span>购买时间：<#if createTime??>${createTimedatetime}</#if></span>
		</div>
		<div class="bookGsd_c">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<#list item.details as i>
			  <tr>
		    	<#if i['type']==0>
			    <td>
			    	<div class="bookGsd_c_book" style="width:480px;">
			    		<a href="/book/detail.action?bookId=${i['book']['id']!''}" target="_blank"><img src="http://img3.chineseall.cn/${ImageUtils.getBookImgUrl(i['book']['id']!'')}" /></a>
			    		<h3><a href="/book/detail.action?bookId=${i['book']['id']!''}" target="_blank">${i['book']['name']!''}</a></h3>
			    		<span>作者：${i['book']['author']!''}   出版社：${i['book']['publisher']!''}</span>
			    		<p><a href="/book/detail.action?bookId=${i['book']['id']!''}" target="_blank">介绍：${i['book']['intro']!''}</a></p>
			    	</div>
			    </td>
			    <td>#{(i.book.price/100);m0}云币</td>
			    <#else>
			    <td>
			    	<div class="bookGsd_c_book" style="width:480px;">
			    		<a href="/eduyun/package/detail.action?id=${i['package']['id']!''}" target="_blank"><img src="${i['package']['cover']!''}" /></a>
			    		<h3><a href="/eduyun/package/detail.action?id=${i['package']['id']!''}" target="_blank">${i['package']['name']!''}</a></h3>
			    		<p><a href="/eduyun/package/detail.action?id=${i['package']['id']!''}" target="_blank">介绍：${i['package']['intro']!''}</a></p>
			    	</div>
			    </td>
			    <td>#{(i.package.price/100);m0}云币</td>
		    	</#if>
			    <#if i_index==0 && (item.status)==0>
			    <td rowspan="${item.details?size}"><a href="/user/gotoPay.action?ordersId=${item.id!''}" class="table_btn">付款</a></td>
			    </#if>
			  </tr>
			  </#list>
			</table>
		</div>
	</div>
	</#list>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />

</div>
</div>
<#include "../bottom.ftl" />
</body>
</html>