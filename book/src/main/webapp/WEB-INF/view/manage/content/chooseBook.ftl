<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?2.1"></script>
<link href="http://html.chineseall.cn/static/script/jQueryFileUpload/css/jquery.fileupload-ui.css" rel="stylesheet" />
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
<div class="crumbs">
	<a href="">首页</a> &gt; <a href="">内容管理</a> &gt; <a href="">图书推荐</a> &gt; <a href="">添加</a> &gt; 选用
</div>
<br/>
<div class="context">
	<div class="listbook2">
	<a class="img" href=""><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(bookMap.bookId)}" /></a>
	<div class="title">
		<h4 class="left"><a href=""><#if bookMap.bookName??><#if bookMap.bookName?length &lt; 15> ${bookMap.bookName!''} <#else> ${bookMap.bookName?substring(0,15)}... </#if></#if></a></h4>
		<div class="left">
			<span class="gray">状态：</span><#if bookMap.isHidden==0>已隐藏<#else>未隐藏</#if>
		</div>
	</div>
	<p>
		<span class="gray">作者：</span><#if bookMap.author??><#if bookMap.author?length &lt; 10> ${bookMap.author!''} <#else> ${bookMap.author?substring(0,10)}... </#if></#if> <span class="gray">/ 出版社：</span> <#if bookMap.publisher??><#if bookMap.publisher?length &lt; 8> ${bookMap.publisher!''} <#else> ${bookMap.publisher?substring(0,8)}... </#if></#if> <span class="gray"> / 出版日期：</span><#if bookMap.publishDate??><#if bookMap.publishDate?length &lt; 11> ${bookMap.publishDate!''} <#else> ${bookMap.publishDate?substring(0,11)}... </#if></#if> <span class="gray">/ 价格：</span><#if bookMap.bookCurrency??> ${bookMap.bookCurrency!0} </#if>元 <span class="gray">
	</p>
	<p>
		<#if bookMap.intro??><#if bookMap.intro?length &lt; 50> ${bookMap.intro!'暂无简介'} <#else> ${bookMap.intro?substring(0,50)}... </#if><#else>暂无简介</#if>
	</p>
	<p>
	</p>
	</div>
</div>
<br/>
<form id="operForm" action="/manage/content/addBookRecommend.action" method="POST">
		<input type="hidden" name="bookId" value="${bookMap.bookId!''}"/>
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="100"><span class="red">*</span>显示书名：</th><td>
				<input class="text" id="name" name="name" value="${bookMap.bookName!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>显示作者：</th><td>
				<input class="text" id="author" name="author" value="${bookMap.author!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>出版社：</th><td>
				<input class="text" id="publisher" name="publisher" value="${bookMap.publisher!''}" type="text" />
				<span class="info"></span></td>
			</tr>
			<tr>
				<th width="100"><span class="red">*</span>推荐语：</th><td>
				<textarea class="textarea" name="intro">${bookMap.intro!''}</textarea>
				<span class="info"></span></td>
			</tr>
			<tr>
				<th>显示封面：</th><td><img id="showImg" src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(bookMap.bookId)}" /></th>
			</tr>
			<tr>
				<th></th><td>
				<input type="hidden" id="imageUrl" name="imageUrl" value="${ImageUtils.getBookImgUrl(bookMap.bookId)}"/>
				<iframe src="/manage/content/showUploadBookImg.action" frameborder="0" width="400px" height="35px"></iframe>
				<span class="info">建议尺寸：85px *120px</span>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button green" type="submit" value="提交" />
				<input class="button yellow" type="reset" value="重置" />
				<input onClick="window.location.href='/manage/content/listOrgBook.action?currentPage=${currentPage!1}'" class="button yellow" type="button" value="返回" />
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
