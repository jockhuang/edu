<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js"></script>
<form id="uploadForm" action="/registers/customavator.action" method="POST" enctype="multipart/form-data">
	<input type="file" id="portrait" name="portrait" multiple/>
</form>
<script>
	$(document).ready(function(){
		$("#portrait").change(function(){
			$("#uploadForm").submit();
		})
		window.parent.setImg(${"'"+(portrait!'http://img3.chineseall.cn/userHeadImg/moren/default.jpg')+"'"});
	})
</script>
