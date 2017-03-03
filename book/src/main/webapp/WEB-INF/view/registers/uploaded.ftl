<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="http://html.chineseall.cn/static/script/jquery.imgareaselect-0.9.5/css/imgareaselect-default.css" />
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.imgareaselect-0.9.5/scripts/jquery.imgareaselect.pack.js"></script>
</head>

<body>
<div class="topLoginBg">
	<div class="loginHead">
		<h1 class="login_logo"><a href="#">书香中国</a></h1>
		<div class="login_rightLink">
			<div class="login_topMenu"><a href="#">书香中国</a><a href="#">阅览室</a><a href="#">平台介绍</a><a href="#">如何成为用户</a></div>
			<div id="links"><strong>中文在线旗下网站</strong> <span style="display: none;"><a target="_blank" href="http://www.17k.com">17k小说网</a> <a target="_blank" href="http://www.chineseall.cn">书香中国</a> <a target="_blank" href="http://www.chineseall.org">全民阅读网</a></span></div>
			<script>
			$(function(){
			$("#links").hover(
				function(){$(this).find("span").show();},
				function(){$(this).find("span").hide();}
			);
			
			});
			</script>
		</div>
	</div>
</div>
<div class="login">
	<div class="loginStep"><span class="s2"> </span></div>
	<form action="/registers/uploaded.action" method="POST">
	<input type="hidden" name="x1" id="x1"/>
	<input type="hidden" name="x2" id="x2" />
	<input type="hidden" name="y1" id="y1"/>
	<input type="hidden" name="y2" id="y2"/>
	<input type="hidden" name="width" id="width"/>
	<input type="hidden" name="height" id="height"/>
	<input type="hidden" name="headImg" id="headImg" value="http://img3.chineseall.cn/userHeadImg/moren/default.jpg"/>
	<div class="loginContent">
		<dl class="dlArea">
			<dt>请设置您的头像让大家认识您：</dt>
			<dd class="chajian">
				<div >	
					<div id="preview" class="img" style="padding:0px; overflow: hidden;width: 60px;height: 60px;float:left;" ><img id="previewImg" style="width: 60px; height: 60px;" src="http://img3.chineseall.cn/userHeadImg/moren/default.jpg" onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" /></div>
					<div class="img" style="padding:0px;float:left; margin-left:50px;" ><img id="uploadIcon" src="http://img3.chineseall.cn/userHeadImg/moren/default.jpg" onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" /></div>
				</div>
				<iframe frameborder="0" width="800" height="50" src="/registers/uploading.action"></iframe>
				<script>
				//截图
				function preview(img, selection) {
				    if (!selection.width || !selection.height)
				        return;
				    var scaleX = 60 / selection.width;
				    var scaleY = 60 / selection.height;
				    $('#preview img').css({
				        width: Math.round(scaleX * img.width),
				        height: Math.round(scaleY * img.height),
				        marginLeft: -Math.round(scaleX * selection.x1),
				        marginTop: -Math.round(scaleY * selection.y1)
				    });
					$('#x1').val(selection.x1);
				    $('#y1').val(selection.y1);
				    $('#x2').val(selection.x2);
				    $('#y2').val(selection.y2);
				    $('#width').val(selection.width);
				    $('#height').val(selection.height);  
				}
				
				function setImg(url){
					$("#headImg").val(url);
					var src = $('input[name=headImg]').val();
					$('#preview img').attr('src' , src);
					$('#uploadIcon').attr('src' , src);
					$('#uploadIcon').attr('style' , '');
					$('#uploadIcon').imgAreaSelect({ x1: 40, y1: 40, x2: 160, y2: 160 , aspectRatio: '1:1' , onSelectChange: preview , enable : true});
				}
				$(document).ready(function(){
					$("img[name=sysHeadList]").click(function(){
						$('#preview img').removeAttr('style').css({width:60 , height:60});
						$('#uploadIcon').imgAreaSelect({hide : true});
						$('input[name="x1"],input[name="x2"],input[name="y1"],input[name="y2"],input[name="width"],input[name="height"]').val('');
						$("#headImg").val($(this).attr("src"));
						var src = $('input[name=headImg]').val() + "?d=" + new Date().getTime();
						$('#preview img').attr('src' , src);
						$('#uploadIcon').attr('src' , src);
					})
				})
				</script>
			</dd>
			<dt>选择系统头像：</dt>
			<dd class="list1">
				<ul>
					<#list 1..20 as i >
					<li><img src="http://img3.chineseall.cn/userHeadImg/moren/${i}.jpg" name="sysHeadList" /></li>
					</#list>
				</ul>
			</dd>
		</dl>
		<div class="submitArea">
			<input name="save" type="submit" value="保存头像" />
			<input name="next" class="s2" type="submit" value="跳过，下一步" />
		</div>
		</form>
	</div>
</div>
<div class="footer">
	<div class="footMain">
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
		<dl>
			<dt>关于我们</dt>
			<dd><a href="#">书香中国</a></dd>
			<dd><a href="#">机构组织</a></dd>
			<dd><a href="#">机构加盟</a></dd>
			<dd><a href="#">联系方式</a></dd>
		</dl>
		<dl>
			<dt>使用帮助</dt>
			<dd><a href="#">如何建立书房</a></dd>
			<dd><a href="#">如何看书</a></dd>
			<dd><a href="#">如何充值</a></dd>
			<dd><a href="#">如何？</a></dd>
		</dl>
	</div>
</div>
<script type="text/javascript">
var inputText = $(':text,password,textarea');
inputText.focus(function(){$(this).addClass('a')});
inputText.blur(function(){$(this).removeClass('a')});
</script>
</body>
</html>
