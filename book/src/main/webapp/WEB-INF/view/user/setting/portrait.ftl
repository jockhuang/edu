<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>更新头像_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<link rel="stylesheet" type="text/css" href="http://html.chineseall.cn/static/script/jquery.imgareaselect-0.9.5/css/imgareaselect-default.css"  ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.uploadPreview.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.imgareaselect-0.9.5/scripts/jquery.imgareaselect.pack.js"></script>

</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
<#include "nav.ftl" />
	<dd class="UserSet">
		<#include "msg.ftl" />
		<form action="saveportrait.action" id="p" method="post" onsubmit="return checkForm()" style="margin-left:30px;" enctype="multipart/form-data">
			<#if (cacheImg??)>
			<input type="hidden" name="headImg" value="http://img3.chineseall.cn${cacheImg}" ></input>
			<#else>
			<input type="hidden" name="headImg" ></input>
			</#if>
			<input type="hidden" id="x1" name="x1" ></input>
			<input type="hidden" id="x2" name="x2" ></input>
			<input type="hidden" id="y1" name="y1" ></input>
			<input type="hidden" id="y2" name="y2" ></input>
			<input type="hidden" id="width" name="width" ></input>
			<input type="hidden" id="height" name="height" ></input>
			<input type="hidden" id="emsg" value="${emsg?default('')}" ></input>
			
			<span id="iconView_span" >您现在的头像 </span> <br /><br />
			<div >	
				<div id="preview" class="img" style="padding:0px; overflow: hidden;width: 60px;height: 60px;" ><img id="previewImg" style="width: 60px; height: 60px;" src="http://img3.chineseall.cn${loginUser.headImg?default('/userHeadImg/moren/default.jpg')}" onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" /></div>
				<div class="img" style="padding:0px;" ><img id="uploadIcon" src="http://img3.chineseall.cn${loginUser.headImg?default('/userHeadImg/moren/default.jpg')}" onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" /></div>
			</div>
			<div id="system" class="clear"  >
				您可以上传一张照片作头像：(<a style="cursor: pointer;" onclick="selectSettingType()" >选择上传头像</a>）<br />
				<h4>选择系统头像  <a id="upButton" class="gray" style="cursor: pointer;" onclick="scrollUp()" >上一组</a>  <a id="downButton" class="red" style="cursor: pointer;" onclick="scrollDown()" >下一组</a></h4>
				<div id="sysIcons" style="overflow: hidden;height: 68px;border: 0;padding: 0px;" >
					<#list 1..30 as i >
					<div id="div_${i}" class="img" style="margin-top: 0px;margin-bottom: 0px;" ><img width="60"  onclick="selectedSystemIcon(this)" height="60" src="http://img3.chineseall.cn/userHeadImg/moren/${i}.jpg" /></div>
					</#list>
				</div>
			</div>
			<div id="upload" class="clear" style="display:none;">
				您可以直接选择系统为您提供的头像：(<a style="cursor: pointer;" onclick="selectSettingType()" >选择系统头像</a>）<br />
				<div id="upload_title" ><h4>选择本地图片上传</h4>  <span id="errorInfoSpan" class="red" ></span></div>
				<#if (cacheImg??)>
				<input type="file" id="headIcon" name="uploadIcon" size="50" onchange="changeFile(this);selectedSystemIcon(false);"/>重新选择<br />
				<#else>
				<input type="file" id="headIcon" name="uploadIcon" size="50" onchange="changeFile(this);selectedSystemIcon(false);"/><span class="gray">图片格式 jpg/gif 小于1M</span><br />
				</#if>
			</div>
			<div class="clear">
				<input class="butsub" type="image" src="http://html.chineseall.cn/static/study/style/save_but.jpg">
			</div>
		</form>
	</dd>
</dl>
</div>
</div>
<div id="loading"></div>
<script type="text/javascript">
	var selectedIcon = false;
	function scrollUp(){
		if(!window.intervalID){
			var sysIcons = document.getElementById('sysIcons');
			if(sysIcons.scrollTop >= 68){
				var i = 1;
				var func = function(){
					if(sysIcons.scrollTop - maxTop >= 5){
						sysIcons.scrollTop -= 5;
					}else{
						sysIcons.scrollTop -= (sysIcons.scrollTop - maxTop);
						window.clearInterval(intervalID);
						intervalID = false;
					}
				}
				maxTop = sysIcons.scrollTop - 68;
				intervalID = setInterval(func , 1);
				document.getElementById('downButton').className = 'red';
				document.getElementById('upButton').className = 'red';
			}else{
				document.getElementById('upButton').className = 'gray';
			}
		}
	}
	
	function scrollDown(){
		if(!window.intervalID){
			var sysIcons = document.getElementById('sysIcons');
			if((sysIcons.scrollHeight - sysIcons.scrollTop) > 68){
				var i = 1;
				var func = function(){
					if(maxTop - sysIcons.scrollTop >= 5){
						sysIcons.scrollTop += 5;
					}else{
						sysIcons.scrollTop += (maxTop - sysIcons.scrollTop);
						window.clearInterval(intervalID);
						intervalID = false;
					}
				}
				maxTop = sysIcons.scrollTop + 68;
				intervalID = setInterval(func , 1);
				document.getElementById('downButton').className = 'red';
				document.getElementById('upButton').className = 'red';
			}else{
				document.getElementById('downButton').className = 'gray';
			}
		}
	}
	
	function selectSettingType(){
		if(document.getElementById("upload").style.display == 'none'){
			$('#upload').show(0);
			$('#system').hide(0);
		}else{
			$('#uploadIcon').imgAreaSelect({hide : true});
			$('input[name="x1"],input[name="x2"],input[name="y1"],input[name="y2"],input[name="width"],input[name="height"]').val('');
			$('#system').show(0);
			$('#upload').hide(0);
		}
	}
	
	function selectedSystemIcon(icon){
		if(icon){
			if(selectedIcon){
				selectedIcon.parentNode.style.borderColor = '';
				selectedIcon = icon;
			}else{
				selectedIcon = icon;
			}
			$('input[name="headImg"]').val(icon.src);
			$('#previewImg').attr({src : icon.src});
			$('#uploadIcon').attr({src : icon.src});
			selectedIcon.parentNode.style.borderColor = 'black';
		}else{
			if(selectedIcon){
				selectedIcon.parentNode.style.borderColor = '';
				selectedIcon = false;
			}
			$('input[name="headImg"]').val('');
		}
	}
	
	function changeFile(file){
		if(file.value != ''){
			file.style.backgroundColor = "white";
			var fileType = file.value.substring(file.value.lastIndexOf('.')).toLowerCase();
			if(fileType != '.jpg' && fileType != '.gif'){
				$("#errorInfoSpan").html('图片格式不符,请重新选择.');
				return false;
			}else{
				$('#p').attr({action : 'savecacheportrait.action'}).submit();
			}
		}else{
			$("#errorInfoSpan").html('请选择图片');
			return false;
		}
	}
	
	function checkForm(){
		if($('#p').attr('action') == 'saveportrait'){
			if($('input[name="headImg"]').val()){
				return true;
			}else{
				alert('请按照要求设置头像');
				return false;
			}
		}
		return true;
	}
	
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
	
	$(document).ready(function(){
		$(".tit a:contains('更新头像')").attr('class' , 'hot');
		if(!$('#emsg').val() && $('input[name=headImg]').val()){
			selectSettingType();
			$('#errorInfoSpan').html('加载图片中,请稍后...');
			setTimeout(function(){
				var src = $('input[name=headImg]').val() + "?d=" + new Date().getTime();
				$('#preview img').attr('src' , src);
				$('#uploadIcon').attr('src' , src);
				$('#uploadIcon').attr('style' , '');
				$('#uploadIcon').imgAreaSelect({ x1: 0, y1: 0, x2: 120, y2: 120 , aspectRatio: '1:1' , onSelectChange: preview , enable : true});
				setTimeout(function(){
					var scaleX = 60 / 120;
				    var scaleY = 60 / 120;
				    $('#preview img').css({
				        width: Math.round(scaleX * $('#uploadIcon').attr('offsetWidth')),
				        height: Math.round(scaleY * $('#uploadIcon').attr('offsetHeight')),
				        marginLeft: -Math.round(scaleX * 0),
				        marginTop: -Math.round(scaleY * 0)
				    });
				} , 100);
				$('#errorInfoSpan').html('');
			} , 2000)
			
		}else{
			$('#errorInfoSpan').html($('#emsg').val());
		}
	})
	
</script>
<#include "../bottom.ftl" />
</body>
</html>
