<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.2"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; <a href="">活动推荐</a> &gt; 修改
</div>
<div class="context">
	<form id="operForm" action="/manage/content/updateActivityRecommend.action" method="POST">
	<input type="hidden" name="id" value="${acRecommend.id!0}"/>
	<input type="hidden" name="currentPage" value="${currentPage!1}"/>
	
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="100"><span class="red">*</span>活动名称：</th><td>
				<input class="text" id="name" name="name" value="${acRecommend.name!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>主办机构：</th><td>
				<input class="text" id="directName" name="directName" value="${acRecommend.directName!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>活动简介：</th><td>
				<textarea class="textarea" name="description">${acRecommend.description!''}</textarea>
				<span class="info"></span></td>
			</tr>
			<tr>
				<th>当前LOGO：</th><td><img id="showImg" src="${acRecommend.logo!''}" /></th>
			</tr>
			<tr>
				<th></th><td>
				<input type="hidden" id="logo" name="logo" value="${acRecommend.logo!''}"/>
				<iframe src="/manage/content/showUploadBookImg.action" frameborder="0" width="400px" height="35px"></iframe>
				<span class="info">建议尺寸：280px * 84px</span>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="submit" value="提交" />
				<input class="button yellow" type="reset" value="重置" />
				<input onClick="window.location.href='/manage/content/listActivityRecommend.action?currentPage=${currentPage!1}'" class="button yellow" type="button" value="返回" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function setImg(url){
			$("#showImg").attr("src",url);
			$("#logo").val(url.substr(25,url.length));
		}
		$(document).ready(function(){
			$("#operForm").validate({
				rules:{
					name:{
						required:true
					},
					directName:{
						required:true
					},
					description:{
						required:true
					}
				},
				messages:{
					name:{
						required:"请输入活动名称！"
					},
					directName:{
						required:"请输入主办机构！"
					},
					description:{
						required:"请输入活动简介！"
					}
				},
				errorPlacement: function(error, element) {
					error.css("color","red");
				    error.appendTo(element.parent().find("span"));
				}
			});
		})
	</script>
</div>
</body>
</html>
