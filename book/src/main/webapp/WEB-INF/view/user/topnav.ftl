<link href="/common/layout.css" rel="stylesheet" />
<div class="header" style="margin-bottom:10px;">
	<div class="headTop">
	</div>
	<div class="headMain">
		<img src="/images/h1_banner.jpg" />
		<div class="headSearch">
		<form action="/search/book.action" method="get" id="searchForm">
		<input class="ipt" type="text" name="word" onmouseout="if(this.value=='')this.value=this.defaultValue" onmouseover="if(this.value==this.defaultValue)this.value=''" value="书名/作者名" />
		<input class="btn" type="submit" value="" />
		</form>
		</div>
	</div>
			
	<div class="headNav">
		<ul>
			<#if appendModelList??>
				<#list appendModelList as appendModel>  
				<li <#if appendModel_index==0>class="aIndex"</#if>><a href="${appendModel.link!''}">${appendModel.name}</a></li>
				</#list>
				<li style="float: right;"><a href="http://n.eduyun.cn">返回公共服务平台</a></li>
			</#if>
		</ul>
	</div>
	<div class="headBottom">
		<dl>
			<dt>学生</dt>
			<dd>
				<a href="/eduyun/package/detail.action?id=6">语文</a> 
				<a href="/eduyun/package/detail.action?id=17">作文</a> 
				<a href="/eduyun/package/detail.action?id=13">数学</a> 
				<a href="/eduyun/package/detail.action?id=16">英语</a> 
				<a href="/eduyun/package/detail.action?id=41">学习方法</a> 
				<a href="/eduyun/package/detail.action?id=61">心理健康</a> 
				<a href="/eduyun/package/detail.action?id=56">安全教育</a> 
				<a href="/eduyun/package/detail.action?id=26">名家书苑</a> 
				<a href="/eduyun/package/detail.action?id=25">国内经典</a>
				<a href="/eduyun/package/detail.action?id=46">国外经典</a>
			</dd>
		</dl>
		<ul>
			<li><a href="/eduyun/package/listBookPackages.action?categoryId=2">家长</a></li>
			<li><a href="/eduyun/package/listBookPackages.action?categoryId=8">老师</a></li>
			<li><a href="/eduyun/package/listBookPackages.action?categoryId=9">校长</a></li>
		</ul>
	</div>
	<script type="text/javascript">
	var hotHref = window.location.pathname;
	$('.headNav li a').each(function(){ 
		if(this.href.indexOf(hotHref)>-1 && hotHref.indexOf("/org/index.action")==-1){
			$(this.parentNode).addClass('current');
		}
	})
	</script>
</div>
