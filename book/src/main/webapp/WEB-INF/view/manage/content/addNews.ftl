<#assign fck=JspTaglibs["http://java.fckeditor.net"]/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/kindeditor/kindeditor-all.js"></script>
</head>
<body>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.0"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; 添加新闻
</div>
<div class="context">
	<form id="addNewsForm" action="/manage/content/addNews.action" method="POST">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="100"><span class="red">*</span>标题：</th><td>
				<input class="text" id="title" name="title" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red"></span>内容：</th><td>
				<textarea id="editor" name="content"></textarea>
				<script>
		     		var editor;
					KindEditor.ready(function(K) {
						editor = K.create('textarea[name="content"]', {
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
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red"></span>内容来源：</th><td>
				<input class="text" name="contentSource" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red"></span>跳转链接：</th><td>
				<input class="text" name="linkUrl" type="text" />
				<span class="info">如需链接到其他url请填写，否则请留空。</span></td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="submit" value="提交" />
				<input class="button yellow" type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#addNewsForm").validate({
				rules:{
					title:{
						required:true
					}
				},
				messages:{
					title:{
						required:"请输入新闻标题！"
					}
				},
				errorPlacement: function(error, element) {
					error.css("color","red");					
				    error.appendTo(element.parent().find("span"));
				},
				submitHandler:function(form){
		            $('input[type=submit]').attr('disabled',true);
		            form.submit();
		        } 
			});
		})
	</script>
</div>
</body>
</html>
