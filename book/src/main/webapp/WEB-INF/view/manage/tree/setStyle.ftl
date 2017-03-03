<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?1.0"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<style>
<!--
/* login */
.indexLogin{ border:#add7be 1px solid; border-top:0; background-color:#fff; height:253px; overflow:hidden;}
.indexLogin .tit ul{ height:38px; overflow:hidden;}
.indexLogin .tit li{ float:left; border-top:#add7be 1px solid; padding-top:2px; width:50%; height:35px; line-height:35px; text-align:center; color:#dcdcdc; font-size:18px; cursor:pointer; background:#f5f5f5;}
.indexLogin .tit li em{ display:none;}
.indexLogin .tit li.hot_a{padding-top:0; height:35px; line-height:35px; background:#fff;}
.indexLogin .tit li.hot_a em{ display:inline; margin-left:5px; font-style:italic; font-size:12px; line-height:14px; font-weight:bold; color:#600;}
.indexLogin .con ul{ margin-top:20px; padding:0 35px;}
.indexLogin .con li{ margin:14px auto; width:238px; overflow:hidden;}
.indexLogin .con li input{ float:left; margin:0; padding:0;}
.indexLogin .con li label{ float:left;}
.indexLogin .con li .ipt{ margin:0; padding:0 0 0 40px; border:#999 1px solid; width:195px; height:35px; line-height:35px; font-size:18px; color:#666; background-position:0 -924px; font-family:"微软雅黑"}
.indexLogin .con li .pwd{ background-position:0 -964px;}
.indexLogin .con li .checkbox1{ margin:3px 6px 0 0; display:inline;}
.indexLogin .con li input.login_dl{ border:0; width:114px; height:42px; line-height:42px; font-size:18px; color:#fff; cursor:pointer; background:#1b8b7a;}
.indexLogin .con li input.login_dl:hover{ background:#00b297;}
.indexLogin .con li a.login_mm{ float:right; color:#999;}
.indexLogin .con li a.login_zc{ float:left; margin-left:10px; display:inline; color:#fff; width:114px; text-align:center; line-height:42px; font-size:16px; background:#a3d251;}
.indexLogin .con li a.login_zc:hover{ background:#b2dc68;}
.popupLogin{ position:relative; width:460px; height:359px; overflow:visible;}
.popupLogin .con ul{ margin:0 auto; width:336px; height:250px; overflow:hidden;}
.popupLogin .con li{ margin:20px auto; width:336px;}
.popupLogin .con li .ipt{ width:298px;}
.popupLogin .con li input.login_dl{ margin-left:50px; display:inline; width:236px;}
.popupLogin .close{ position:absolute; top:-10px; right:-10px; width:23px; height:23px; overflow:hidden; text-indent:-999em; background:url(http://html.chineseall.cn/static/style/img/popup_close2.png) no-repeat;}
.login_link{ padding:15px 0 0 40px; height:56px; font-size:16px; line-height:30px; font-style:italic; background:url(http://html.chineseall.cn/static/style/img/login_link_bg.png) repeat-x;}
.login_link span{ float:left; padding:1px 15px 0 0;}
.login_link a.login_zc{ float:left; border:#a23d4e 1px solid; padding:0 22px; color:#fff; background:#c1495d;}
//-->
</style>
<div class="crumbs">
	<a href="">首页</a> &gt;模板选择
	<span style="float:right;"><a href="/manage/tree/showBanner.action">自定义banner</a></span>
</div>
<div class="context">
	<div class="themelist" style="margin-top:10px;">
		<#if templateList??>
			<#list templateList as template>
				<div class="cont" style="margin-top:10px;">
					<img src="http://${imgDomainName!''}${template.thumbnail!''}">
					<span style="width:100%;<#if (orgTree.styleTemplateId!1)==template.id>background-color:lightgreen;</#if>">${template.name!''}</span>
					<span style="clear:both;width:100%;text-align:center;margin-top:10px;">
					<div style="position:relative;margin-top:40px;">
					<input type="button" value="使用" class="button green" onclick="setStyle(${template.id});" style="cursor:pointer;">
					<input type="image" onclick="preview('http://${imgDomainName!''}${template.thumbnail!''}');" src="http://html.chineseall.cn/static/style/manage/skin/zoom.png" class="zoom" style="cursor:pointer;">
					</div>
					</span>
				</div>
			</#list>
		</#if>
	</div>
</div>
<script type="text/javascript">
    function setStyle(templateId){
    	window.location.href="/manage/tree/setStyle.action?templateId="+templateId;
    }
    
    function preview(url){
    	var html = "<div class='indexLogin popupLogin' style='width:310px;height:255px;'>";
		html = html + ("<div class='close' style='cursor:pointer;' id='closeButton'>关闭</div>");
		var frameHtml = "<img style='border:1px solid gray;width:310px;height:255px;' src='" + url + "' />";
		html = html + frameHtml;
		html = html + "</div>";
		pop.show({html:html , top:200});
		$("#closeButton").click(function(){
			pop.close();
		});
    }
</script>