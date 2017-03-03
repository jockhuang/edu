<link href="http://html.chineseall.cn/static/style/manage/skin/layout.css" rel="stylesheet" />
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<form action="/manage/content/uploadBookImg.action" method="POST" enctype="multipart/form-data">
<input class="file" type="file" name="file" id="file" />
<input class="button green" type="submit" value="上传" />
</form>
<script>
$(document).ready(function(){
	if("${upload!''}"=="succeed"){
		window.parent.setImg(${"'"+(logoUrl!'')+"'"});
	}
})
</script>