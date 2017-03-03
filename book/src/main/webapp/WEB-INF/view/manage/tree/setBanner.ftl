<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?1.0"></script>
<div class="Mcont">
	<div class="crumbs">
		<a href="">首页</a> &gt; <a href="">基本信息</a> &gt; <a href="">页面风格</a> &gt; 设置banner
	</div>
	<!--内容区-->
	<div class="context">
		<form id="bannerForm" action="/manage/tree/setBanner.action" method="post" enctype="multipart/form-data">
			<table width="100%" cellspacing="0" cellpadding="5" class="formTable">
				<tbody>
				<tr>
					<th>当前Banner</th><td>
					<#if !orgBaseinfo?? || !orgBaseinfo.banner?? || orgBaseinfo.banner == "">
					未设置banner或者您已取消了banner的显示
					<#else>
					<img style="width:600px;" src="http://${imgDomainName!''}/${ImageUtils.getOrgBannerUrl(orgBaseinfo.orgTreeId)}">
					</#if>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
					<input type="hidden" value="" name="cancel" id="cancelBox" />
					<input type="file" class="file" name="treeBanner" id="treeBanner">
					<input type="button" value="上传" class="button green" id="uploadButton" style="cursor:pointer;">
					<input type="button" value="取消banner" class="button yellow" id="cancelButton" style="cursor:pointer;">
					<span class="info">建议尺寸：1920px *155px</span>
					</td>
				</tr>
			</tbody></table>
		</form>
	</div>
</div>
<script type="text/javascript">
$("#cancelButton").click(function(){
	$("#cancelBox").val("1");
	$("#bannerForm").submit();
});
$("#uploadButton").click(function(){
	$("#cancelBox").val("");
	$("#bannerForm").submit();
});
</script>