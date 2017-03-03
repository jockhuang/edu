<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>基本信息</title>
		<link type="text/css" rel="stylesheet" href="http://html.chineseall.cn/static/style/manage/skin/layout.css" />
	</head>
	<body>
	<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?0.1"></script>
	<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/kindeditor/kindeditor-all.js"></script>
		<div class="crumbs">
			<a href="">首页</a> &gt; <a href="">基本信息</a> &gt; 机构信息
		</div>
		<!--内容区-->
		<div class="context">
			<form action="/manage/tree/update.action" method="post" >
			<input type="hidden" name="id" value="8" />
				<table width="100%" cellspacing="0" cellpadding="5" class="formTable">
					<tbody>
					<tr>
						<th width="100"><span class="red">*</span>机构名称：</th>
						<td>
						<input type="text" name="orgName" value="${org.name!''}" class="text" disabled=true >
						</td>
					</tr>
					<tr>
						<th><span class="red">*</span>显示名称：</th>
						<td>
						<input type="text" name="viewName" value="${orgTree.viewName!''}"  class="text">
						<input type="checkbox" name="isView" value="1" <#if orgTreeConf??&&orgTreeConf.isView==1>checked=true</#if> />显示
						</td>
					</tr>
					<tr>
						<th>当前logo：</th><td><img src="http://${imgDomainName!'img3.chineseall.cn'}${ImageUtils.getOrgLogoUrl(orgTree.id)}" /></td>
					</tr>
					<tr>
						<th></th><td>
							<iframe src="/manage/tree/showUpdateTreeLogo.action" frameborder="0" width="600px" height="35px"></iframe>
						</td>
					</tr>
					<tr>
						<th><span class="red"> </span>机构简介：</th>
						<td>
						<#if orgBaseinfo??>
					     	<textarea id="editor" name="intro" style="width:300px;height:200px;visibility:hidden;">${orgBaseinfo.description!''}</textarea>
						<#else>
							<textarea id="editor" name="intro" style="width:300px;height:200px;visibility:hidden;"></textarea>
						</#if> 
						<script>
				     		var editor;
							KindEditor.ready(function(K) {
								editor = K.create('textarea[name="intro"]', {
									resizeType : 1,
									width : "90%",
									uploadJson : '/editorUpload.action',
									items : [
										'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
										'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
										'insertunorderedlist', '|', 'emoticons', 'image', 'link']
								    });
							});
				     	</script>
						</td>
					</tr>
					<tr>
						<th><span class="red"> </span>机构页尾：</th>
						<td>
						<#if orgBaseinfo??>
					     	<textarea id="editor" name="footerContent" style="width:300px;height:200px;visibility:hidden;">${orgBaseinfo.footerContent!''}</textarea>
						<#else>
							<textarea id="editor" name="footerContent" style="width:300px;height:200px;visibility:hidden;"></textarea>
						</#if> 
						<script>
				     		var editor;
							KindEditor.ready(function(K) {
								editor = K.create('textarea[name="footerContent"]', {
									resizeType : 1,
									width : "90%",
									uploadJson : '/editorUpload.action',
									items : [
										'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
										'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
										'insertunorderedlist', '|', 'emoticons', 'image', 'link']
								    });
							});
				     	</script>
						</td>
					</tr>
				    <tr>
						<th><span class="red"> </span>管理设置：</th>
						<td>
						<input type="checkbox" name="isAgent" value="1" <#if orgTreeConf??&&orgTreeConf.isDelegate==1>checked=true</#if> />允许代管
						(代管指由平台专业运营人员代为管理维护机构的相关信息)
						</td>
					</tr>
					<tr>
						<th></th><td>
						<input type="submit" value="提交" class="button green">
						</td>
					</tr>
				</tbody></table>
			</form>
		</div>
	</body>
</html>
