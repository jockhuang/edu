<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
</head>

<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.1"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; 修改图书推荐
</div>
<div class="context">
	<form id="operForm" action="/manage/content/updateBookRecommend.action" method="POST">
	<input type="hidden" name="id" value="${webBookContent.id!0}"/>
	<input type="hidden" name="currentPage" value="${currentPage!1}"/>
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="100"><span class="red">*</span>显示书名：</th><td>
				<input class="text" id="name" name="name" value="${webBookContent.name!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>显示作者：</th><td>
				<input class="text" id="author" name="author" value="${webBookContent.author!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>出版社：</th><td>
				<input class="text" id="publisher" name="publisher" value="${webBookContent.publisher!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>推荐语：</th><td>
				<textarea class="textarea" name="intro">${webBookContent.intro!''}</textarea>
				<span class="info"></span></td>
			</tr>
			<tr>
				<th>显示封面：</th><td><img id="showImg" src="${webBookContent.imageUrl!''}" /></th>
			</tr>
			<tr>
				<th></th><td>
				<input type="hidden" id="imageUrl" name="imageUrl" value="${webBookContent.imageUrl!''}"/>
				<iframe src="/manage/content/showUploadBookImg.action" frameborder="0" width="400px" height="35px"></iframe>
				<span class="info">建议尺寸：85px *120px</span>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="submit" value="提交" />
				<input class="button yellow" type="reset" value="重置" />
				<input onClick="window.location.href='/manage/content/listBookRecommend.action?currentPage=${currentPage!1}'" class="button yellow" type="button" value="返回" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		
		function setImg(url){
			$("#showImg").attr("src",url);
			$("#imageUrl").val(url.substr(25,url.length));
		}
		
		$(document).ready(function(){
			$("#operForm").validate({
				rules:{
					name:{
						required:true
					},
					author:{
						required:true
					},
					publisher:{
						required:true
					},
					intro:{
						required:true
					}
				},
				messages:{
					name:{
						required:"请输入显示书名！"
					},
					author:{
						required:"请输入显示作者！"
					},
					publisher:{
						required:"请输入出版社！"
					},
					intro:{
						required:"请输入推荐语！"
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
