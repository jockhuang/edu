<link href="http://html.chineseall.cn/static/style/manage/skin/layout.css" rel="stylesheet" />
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<form action="/manage/tree/updateTreeLogo.action" method="POST" enctype="multipart/form-data">
<input class="file" type="file" name="treeLogo" id="treeLogo" />
<input class="button green" type="submit" value="上传" />
<span class="info">建议尺寸：100px *100px</span>
</form>
<script>
$(document).ready(function(){
	if("${upload!''}"=="succeed"){
		window.parent.location.reload();
	}
})
</script>