<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>界面设置_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<link href="http://html.chineseall.cn/static/script/yoxview/yoxview.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/yoxview/jquery.yoxview-2.21.min.js" ></script>
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
	<form class="ui" onsubmit="return checkForm()" action="saveui.action" method="post">
		<input id="curtain" value="${userStudy.curtainPicFileName?default('')}" type="hidden" />
		<input id="studyStyle" value="${userStudy.studyStyleCss?default('blue')}" type="hidden" />
		<table border="0" cellspacing="10" cellpadding="0">
			<tr><td width="120" >自定义书房名称：</td><td><input type="text" name="pageName" 
				value="${userStudy.pageName?default(loginUser.displayName?default(loginUser.userName) + '的书房')}" /></td></tr>
			<tr><td>选择一个书房风格：</td>
				<td>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/blue.jpg" /></div><label><input type="radio" name="studyStyleCss" value="blue"  />淡蓝天空</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/black.jpg" /></div><label><input type="radio" name="studyStyleCss" value="black"  />黑色魅力</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/green.jpg" /></div><label><input type="radio" name="studyStyleCss" value="green" />青春绿色</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/violet.jpg" /></div><label><input type="radio" name="studyStyleCss" value="violet" />紫色浪漫</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/gray.jpg" /></div><label><input type="radio" name="studyStyleCss" value="gray" />简洁灰色</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/brown.jpg" /></div><label><input type="radio" name="studyStyleCss" value="brown" />棕色情怀</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/yellow.jpg" /></div><label><input type="radio" name="studyStyleCss" value="yellow" />活力黄色</label></div>
					<div class="list"><div class="img"><img width="60" height="60" src="http://html.chineseall.cn/static/study/style/common/pink.jpg" /></div><label><input type="radio" name="studyStyleCss" value="pink" />公主粉色</label></div>
				</td>
			</tr>
			<tr><td>换您书房的窗帘：</td><td><span class="gray">小提示:点击小图可查看大图</span></td></tr>
			<tr><td></td>
				<td>
					<div class="thumbnails yoxview">
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/1.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/1.jpg" /></a></div><label><input id="radio_1" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/1.jpg" />1</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/2.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/2.jpg" /></a></div><label><input id="radio_2" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/2.jpg" />2</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/3.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/3.jpg" /></a></div><label><input id="radio_3" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/3.jpg" />3</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/4.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/4.jpg" /></a></div><label><input id="radio_4" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/4.jpg" />4</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/5.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/5.jpg" /></a></div><label><input id="radio_5" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/5.jpg" />5</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/6.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/6.jpg" /></a></div><label><input id="radio_6" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/6.jpg" />6</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/7.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/7.jpg" /></a></div><label><input id="radio_7" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/7.jpg" />7</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/8.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/8.jpg" /></a></div><label><input id="radio_8" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/8.jpg" />8</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/9.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/9.jpg" /></a></div><label><input id="radio_9" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/9.jpg" />9</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/10.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/10.jpg" /></a></div><label><input id="radio_10" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/10.jpg" />10</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/11.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/11.jpg" /></a></div><label><input id="radio_11" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/11.jpg" />11</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/12.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/12.jpg" /></a></div><label><input id="radio_12" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/12.jpg" />12</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/13.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/13.jpg" /></a></div><label><input id="radio_13" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/13.jpg" />13</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/14.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/14.jpg" /></a></div><label><input id="radio_14" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/14.jpg" />14</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/15.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/15.jpg" /></a></div><label><input id="radio_15" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/15.jpg" />15</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/16.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/16.jpg" /></a></div><label><input id="radio_16" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/16.jpg" />16</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/17.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/17.jpg" /></a></div><label><input id="radio_17" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/17.jpg" />17</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/18.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/18.jpg" /></a></div><label><input id="radio_18" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/18.jpg" />18</label></div>
						<div class="list"><div class="img"><a href="http://img3.chineseall.cn/curtainPicFile/19.jpg"><img width="150" height="60" src="http://img3.chineseall.cn/curtainPicFile/19.jpg" /></a></div><label><input id="radio_19" name="curtainPicFileName" onclick="document.getElementById('curtain').value = this.value" type="radio" value="/curtainPicFile/19.jpg" />19</label></div>
					</div>
				</td>
			</tr>
			<tr><th></th><td><input class="butsub" type="image" src="http://html.chineseall.cn/static/study/style/save_but.jpg"></td></tr>
		</table>
		</form>
	</dd>
</dl>
</div>
</div>
<script type="text/javascript">
	function checkForm(){
		return true;
	}
	function init(){
		var studyStyle = document.getElementById('studyStyle').value;
		if(studyStyle){
			var fileNames = document.getElementsByName('studyStyleCss');
			for(var i = 0 ; i < fileNames.length ; i ++){
				if(fileNames[i].value == studyStyle){
					fileNames[i].checked = true;
				}
			}
		}
		var curtain = document.getElementById('curtain').value;
		if(curtain){
			var fileNames = document.getElementsByName('curtainPicFileName');
			for(var i = 0 ; i < fileNames.length ; i ++){
				if(fileNames[i].value.indexOf(curtain) > -1){
					fileNames[i].checked = true;
				}
			}
		}
		$(document).ready(function(){
	        $(".yoxview").yoxview({"lang" : "zh-cn" , 
	        	"allowInternalLinks" : true ,
                onSelect: function(i, image)
                {
                	$('#curtain').val(image.media.src);
                	$('#radio_' + (i + 1)).attr('checked' , true);
                }});
	    });
	}
	init();
	$(".tit a:contains('界面设置')").attr('class' , 'hot');
</script>
<#include "../bottom.ftl" />
</body>
</html>
