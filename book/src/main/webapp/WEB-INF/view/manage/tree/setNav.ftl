<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?1.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt;导航设置
</div>
<!--内容区-->
<div class="context">
	<input type="hidden" value="导航" name="currentMenu" id="currentMenu" />
	<form action="/manage/tree/setNav.action" method="post">
		<table width="100%" cellspacing="0" cellpadding="5" class="formTable">
			<tbody>
			<#list 1..10 as index>
			<#assign count=0 />
			<#if orgAppendModelList??>
				<#assign count=(orgAppendModelList?size) />
			</#if>
			<tr>
				<th width="100">${index}、</th><td> 名称:
				<input type="text" name="names" <#if (count >= index)>value="${orgAppendModelList[index-1].name!''}"</#if> class="text2">
				链接:
				<input type="text" name="links" <#if (count >= index)>value="${orgAppendModelList[index-1].link!''}"</#if> <#if index<=3>readonly</#if> class="text2">
				</td>
			</tr>
			</#list>
			<tr>
				<th></th><td align="center">
				<input type="submit" value="提交" class="button green">
				<input type="reset" value="重置" class="button">
				</td>
			</tr>
		</tbody></table>
	</form>
</div>
