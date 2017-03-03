<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/read.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/read.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.comment.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/book.comment.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/pop.js"></script>
<style>
<!--
/* login */
.indexLogin{ border:#add7be 1px solid; border-top:0; background-color:#fff; height:253px; overflow:hidden;}
.indexLogin .tit ul{ height:38px; overflow:hidden;}
.indexLogin .tit li{ float:left; border-top:#add7be 1px solid; padding-top:2px; width:50%; height:35px; line-height:35px; text-align:center; color:#dcdcdc; font-size:18px; cursor:pointer; background:#f5f5f5;}
.indexLogin .tit li em{ display:none;}
.indexLogin .tit li.hot_a{padding-top:0; height:35px; line-height:35px; background:#fff;}
.indexLogin .tit li.hot_a em{ display:inline; margin-left:5px; font-style:italic; font-size:12px; line-height:14px; font-weight:bold; color:#600;}
.indexLogin .con ul{ margin-top:20px; padding:0 35px;}
.indexLogin .con li{ margin:14px auto; width:238px; overflow:hidden;}
.indexLogin .con li input{ float:left; margin:0; padding:0;}
.indexLogin .con li label{ float:left;}
.indexLogin .con li .ipt{ margin:0; padding:0 0 0 40px; border:#999 1px solid; width:195px; height:35px; line-height:35px; font-size:18px; color:#666; background-position:0 -924px; font-family:"微软雅黑"}
.indexLogin .con li .pwd{ background-position:0 -964px;}
.indexLogin .con li .checkbox1{ margin:3px 6px 0 0; display:inline;}
.indexLogin .con li input.login_dl{ border:0; width:114px; height:42px; line-height:42px; font-size:18px; color:#fff; cursor:pointer; background:#1b8b7a;}
.indexLogin .con li input.login_dl:hover{ background:#00b297;}
.indexLogin .con li a.login_mm{ float:right; color:#999;}
.indexLogin .con li a.login_zc{ float:left; margin-left:10px; display:inline; color:#fff; width:114px; text-align:center; line-height:42px; font-size:16px; background:#a3d251;}
.indexLogin .con li a.login_zc:hover{ background:#b2dc68;}
.popupLogin{ position:relative; width:460px; height:359px; overflow:visible;}
.popupLogin .con ul{ margin:0 auto; width:336px; height:250px; overflow:hidden;}
.popupLogin .con li{ margin:20px auto; width:336px;}
.popupLogin .con li .ipt{ width:298px;}
.popupLogin .con li input.login_dl{ margin-left:50px; display:inline; width:236px;}
.popupLogin .close{ position:absolute; top:-10px; right:-10px; width:23px; height:23px; overflow:hidden; text-indent:-999em; background:url(http://html.chineseall.cn/static/style/img/popup_close2.png) no-repeat;}
.login_link{ padding:15px 0 0 40px; height:56px; font-size:16px; line-height:30px; font-style:italic; background:url(http://html.chineseall.cn/static/style/img/login_link_bg.png) repeat-x;}
.login_link span{ float:left; padding:1px 15px 0 0;}
.login_link a.login_zc{ float:left; border:#a23d4e 1px solid; padding:0 22px; color:#fff; background:#c1495d;}
//-->
</style>
</head>
<style type="text/css" >
	.readMenu a{
		color:#FFFFFF;
	}
	.readMenu a{
		color:#FFFFFF;
	}
	.help{
		display: inline-block; 
		border: 2px solid #DCDCDC; 
		z-index: 9999; 
		width: 300px;
		position: absolute; 
		padding: 20px; 
		background-color: rgb(245, 245, 245);
	}
	.help h3{
		text-align: left;
	}
	.help div{
		text-align: left;
		padding-left: 50px;
	}
	.help div span{
		display: inline-block;
		padding: 10px; 
	}
	.help div span em{
		font-weight: bold;
	}
	.help .closebtn{
		padding: 5px;
		background-color: #8B8B7A;
		color: rgb(255, 255, 255);
		float: right;
	}
</style>
<body >
<input type="hidden" id="headerHeight" value="212"/>
<div class="read">
	<#--
	<div style="background-color: #FDF5E6; color: #CD5C5C; padding: 10px;border:5px;">asddasda</div>
	<div style="background-color: #DCDCDC; color: #123456; padding: 10px;border:5px;">asddasda</div>
	-->
	<div id="msg" style="display:none;padding:10px;width:930px;" ></div>
	<#if (readInfo.func == ReadConstants.READ_FUNC_TEST) >
	<input id="testRead" type="hidden" value="true" />
	</#if>
	<#if (login?? && login) >
	<input id="isLogin" type="hidden" value="true" />
	</#if>
	<input id="bname" type="hidden" value="${book.name}" />
	<input id="price" type="hidden" value="${price!0}" />
	<form action="read.action" method="get" >
		<input name="bookId" type="hidden" value="${book.id}" />
		<input name="page" type="hidden" value="${readInfo.page}" />
		<input name="mode" type="hidden" value="${readInfo.type}" />
	</form>
	<h1>${book.name}<span>作者：${book.author?default('&lt;暂无作者&gt;')}</span></h1>
	<div class="readContent" >
		<#if (readInfo.type == ReadConstants.READ_MODE_TXT)>
		${txtContent?default('<center>读取内容失败</center>')}
		<#elseif (readInfo.type == ReadConstants.READ_MODE_IMG)>
		<img id="pdfPageImg" style="width:800px;margin:auto;display:block;" class="JPG" src="${resourcesPrefix}/read.action?m=${readInfo.tokenKey}&c=${readInfo.tokenContent}" />
		<#elseif (readInfo.type == ReadConstants.READ_MODE_PDF)>
		<iframe id="pdfViewFrame" scrolling="no" frameborder="0" src="${resourcesPrefix}/read.action?m=${readInfo.tokenKey}&c=${readInfo.tokenContent}" width="100%" height="1300" ></iframe>
		</#if>
		<br /><br />
	</div>
	<dl class="ly">
		<dt >留言</dt>
		<dd style="display:none;z-index:100px;" >
			<div class="ly_tit">
				<h2>书评笔记</h2>
			</div>
			<div class="ly_con">
				<div class="lyIptArea">
					<textarea class="textarea" onmouseout="if(this.value=='')this.value=this.defaultValue" onmouseover="if(this.value==this.defaultValue)this.value=''" value="随手写点什么：">随手写点什么：</textarea>
					<input class="submit" type="button" value="发 表" />
				</div>
				<div class="lyList">
					<h2 class="b">“我的”书评笔记：</h2>
					<ul class="mycomment" >
					</ul>
					<h2>本书书评笔记：</h2>
					<ul class="allcomment">
					</ul>
				</div>
			</div>
		</dd>
	</dl>
	<dl class="mulu" >
		<input id="showDirectory" type="hidden" value="${directory?default('hide')}" />
		<dt >目录</dt>
		<dd style="display:none;" >
			<h2>${book.name} - <span>目录：</span></h2>
		</dd>
	</dl>
	<div class="readPage">
		<#if (readInfo.page > 1) >
		<a href="read.action?bookId=${book.id}&page=${readInfo.page - 1}&mode=${readInfo.type}" class="prev">上一页</a>
		<#else>
		<a title="第一页" class="prev"></a>
		</#if>
		<#if (totalPageNum > readInfo.page) >
		<a href="read.action?bookId=${book.id}&page=${readInfo.page + 1}&mode=${readInfo.type}" class="next">下一页</a>
		<#else>
		<a title="已到最后一页" class="next"></a>
		<script>
		$(".next").click(function(){
			if($('#testRead').val() == 'true'){
				preview();
			}
			
		})
		function preview(){
	    	var html = "<div class='indexLogin popupLogin' style='width:560px;height:330px;'>";
			var frameHtml = "<br/><br/><br/><br/><p>"+$("#msg").html()+"</p><br/><br/><p align='center'>如果想阅读正本图书，请<a style='color:red;' href='/edushopcart/addShopCart.action"+
			"?bookId=${book.id!''}' target='_blank'>购买此书</a>&nbsp;&nbsp;价格："+$("#price").val()+"云币&nbsp;&nbsp;或继续<a style='color:red;' id='closeButton' href='javascript:void(0);'>试读</a>此书。</p><br/><br/>";
			html = html + frameHtml;
			html = html + "</div>";
			pop.show({html:html , top:230});
			$("#closeButton").click(function(){
				pop.close();
			});
	    }
		</script>
		</#if>
	</div>
</div>
<!--
<div class="jdt"><span style="height:20%;"></span></div>
-->
<dl class="rightPage">
	<dt class="on">${readInfo.page} / ${totalPageNum}</dt>
	<dd>
		<input class="ipt" type="text" />
		<input class="btn" type="button" value="" />
	</dd>
</dl>
<div class="readMenu" >
	<dl>
		<#if (orgTreeId??)>
		<a href="detail.action?bookId=${book.id}&orgTreeId=${orgTreeId}"><dt class="t1">书主页</dt></a>
		<#else>
		<a href="detail.action?bookId=${book.id}"><dt class="t1">书主页</dt></a>
		</#if>
	</dl>
	<dl id="_mode" >
		<dt class="t2" >阅读方式</dt>
		<dd style="display:none" >
			<ul>
				<#if (readInfo.totalPageNums?keys?seq_contains(ReadConstants.READ_MODE_PDF))>
				<li><a href="read.action?bookId=${book.id}&mode=${ReadConstants.READ_MODE_PDF}">pdf</a></li>
				</#if>
				<#if (readInfo.totalPageNums?keys?seq_contains(ReadConstants.READ_MODE_IMG))>
				<li><a href="read.action?bookId=${book.id}&mode=${ReadConstants.READ_MODE_IMG}">图片</a></li>
				</#if>
				<#if (readInfo.totalPageNums?keys?seq_contains(ReadConstants.READ_MODE_TXT))>
				<li><a href="read.action?bookId=${book.id}&mode=${ReadConstants.READ_MODE_TXT}">文本</a></li>
				</#if>
			</ul>
		</dd>
	</dl>
	<#if (readInfo.type == ReadConstants.READ_MODE_TXT)>
	<dl id="_bgcolor" >
		<dt class="t3"><a href="#">背景颜色</a></dt>
		<dd style="display:none">
			<ul class="b">
				<li style="background:#D5E9D0;"></li>
				<li style="background:#E5E9D0;"></li>
				<li style="background:#E9DFD0;"></li>
				<li style="background:#9F9077;"></li>
				<li style="background:#D0E9E9;"></li>
				<li style="background:#E6D0E9;"></li>
				<li style="background:#D3D0E9;"></li>
			</ul>
		</dd>
	</dl>
	<dl id="_fontsize" >
		<dt class="t4"><a href="#">字体大小</a></dt>
		<dd style="display:none">
			<ul>
				<li>大</li>
				<li>中</li>
				<li>小</li>
			</ul>
		</dd>
	</dl>
	</#if>
	<dl id="_help" >
		<dt class="t5"><a href="#">指南</a></dt>
	</dl>
</div>
<div class="help" style="display:none" >
	<a class="closebtn">关闭提示</a>
	<br>
	<h3>快捷键</h3>
	<div>
		<span><em>光标键左(←)</em> — 上一页</span>
		<br>
		<span><em>光标键右(→)</em> — 下一页</span>
		<br>
		<span><em>H</em> — 显示/关闭 帮助</span>
		<br>
		<span><em>D</em> — 显示/关闭 图书目录</span>
		<br>
		<span><em>C</em> — 显示/关闭 本页书评</span>
		<br>
	</div>
</div>
</body>
</html>
