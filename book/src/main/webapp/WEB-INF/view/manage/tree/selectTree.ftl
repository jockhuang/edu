<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>机构树选择</title>
</head>
<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?0.0"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">基本信息</a> &gt; 切换机构
</div>
<div class="context" style="padding-top:10px;">
	<div class="jigouList">
	<#list inchargeTreeList as inchargeTree>
		<input type="button"  domain="${inchargeTree.domainName!''}" nodeDomain="${inchargeTree.nodeDomainName!''}" treeId="${inchargeTree.id}" value="${inchargeTree.viewName!''}(${inchargeTree.nodeName!''})" class="button blue" style="cursor:pointer;">
	</#list>
	</div>
</div>
<script type="text/javascript">
	$("input[type='button']").click(function(){
		var domainName = $(this).attr("domain");
		var nodeDomainName =  $(this).attr("nodeDomain");
		var treeId = $(this).attr("treeId");
		var location=window.location.href;
		var currentHost = window.location.host;
		if(domainName){
			location = location.replace(currentHost, domainName);
			window.location.href=location;
		}
		if(nodeDomainName){
			location = location.replace(currentHost, nodeDomainName);
			if(location.indexOf("orgTreeId")!=-1){
				var reg=new RegExp("orgTreeId=\\d*","gmi");
				location = location.replace(reg,"");
				if(location.indexOf("?")!=-1){
					window.location.href=location+"orgTreeId="+treeId;
				}else{
					window.location.href=location+"?orgTreeId="+treeId;
				}
			}else{
				window.location.href=location+"?orgTreeId="+treeId;
			}
		}
	});
</script>
</body>
</html>
