<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>个人资料_${loginUser.displayName?default(loginUser.userName)}的书房</title>
<meta name="keywords" content="art,web" />
<meta name="description" content="artWelcome" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 

<link href="http://html.chineseall.cn/static/study/style/common.css" rel="stylesheet" type="text/css" />
<link href="http://html.chineseall.cn/static/study/script/util/css/util.css" rel="stylesheet" type="text/css" ></link>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/jquery.min.js" ></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/util/util.js" ></script>
</head>
<body>
<#include "../top.ftl" />
<div class="layout">
<#include "../left.ftl" />
<div class="layoutcont">
<dl class="tabjs">
<#include "nav.ftl" />
	<dd class="UserSet" style="height:600px" >
		<#include "msg.ftl" />
		<form onsubmit="return checkForm()" action="savebasic.action" method="post" >
			<table border="0" cellspacing="10" cellpadding="0">
				<tr><th>姓名：</th><td>${loginUser.realName?default('')}（不可修改）</td></tr>
				<tr><th>昵称：</th><td><input type="text" id="uDisplayName" name="displayName" value="${loginUser.displayName?default(loginUser.userName)}" maxlength="15" /></td></tr>
				<tr><th>性别：</th><td>
					<#if (loginUser.gender??)>
					<#if (loginUser.gender == 2)>
					<input type="radio" name="gender" value="1" >男</input>
					<input type="radio" name="gender" value="2" checked="checked" >女</input>
					<#else>
					<input type="radio" name="gender" value="1" checked="checked">男</input>
					<input type="radio" name="gender" value="2" >女</input>
					</#if>
					<#else>
					<input type="radio" name="gender" value="1" >男</input>
					<input type="radio" name="gender" value="2" >女</input>
					</#if>
				</td></tr>
				<#if (loginUser.birthday??)>
				<tr><th>生日：</th><td><input type="text" id="birthday" name="birthday" readonly="readonly" onclick="WdatePicker()" value="${loginUser.birthday?date}" /></td></tr>
				<#else>
				<tr><th>生日：</th><td><input type="text" id="birthday" name="birthday" readonly="readonly" onclick="WdatePicker()" value="" /></td></tr>
				</#if>
				
				<tr><th>QQ：</th><td><input type="text" id="qq" name="qq" maxlength="15" value="${loginUser.qq?default('')}" /></td></tr>
				<tr><th>E-mail：</th><td><input type="text" id="email" name="email" maxlength="40" value="${loginUser.email?default('')}" /></td></tr>
				
				<tr><th>所在地：</th>
					<td id="citySelectTag">
						<dl>
							<dt><span>选择省</span><span class="arr"></span><input id="province" name="province" value="${loginUser.province?default('')}" type="hidden" /></dt><dd></dd>
						</dl>
						<dl>
							<dt><span>选择市</span><span class="arr"></span><input id="city" name="city" value="${loginUser.city?default('')}" type="hidden" /></dt><dd>您还没选择省</dd>
						</dl>
						<dl>
							<dt><span>选择区县</span><span class="arr"></span><input id="county" name="county" value="${loginUser.county?default('')}" type="hidden" /></dt><dd>您还没选择市</dd>
						</dl>
						<script type="text/javascript" src="http://html.chineseall.cn/static/script/area_json.utf8.class.js" ></script>
						<script type="text/javascript" src="http://html.chineseall.cn/static/study/script/areaSet.js"></script>
						<script type="text/javascript">
							if($('#province').val() != ''){
								new setArea(document.getElementById('citySelectTag'),$('#province').val(),$('#city').val(),$('#county').val());	
							}else{
								new setArea(document.getElementById('citySelectTag'),'','','');
							}
						</script>
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
		if($.trim(document.getElementById('uDisplayName').value) == ''){
			alert('昵称不允许为空');
			return false;
		}
		if(document.getElementById('qq').value != '' && 
			!/^[1-9]\d*$/.test(document.getElementById('qq').value)){
			alert('qq号格式不对');
			return false;
		}
		if(document.getElementById('email').value != '' && 
			!/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(document.getElementById('email').value)){
			alert('email格式不对');
			return false;
		}
		if($.trim(document.getElementById('province').value) == ''){
			return false;
		}
		if($.trim(document.getElementById('city').value) == ''){
			return false;
		}
		if($.trim(document.getElementById('county').value) == ''){
			return false;
		}
		return true;
	}

	function initPageData(){
		//初始化地址下拉列表
		var dtArray = document.getElementById('citySelectTag').getElementsByTagName("dt");
		for(var i = 0 ; i < dtArray.length ; i ++){
			dtArray[i].getElementsByTagName('SPAN')[0].innerHTML 
				= dtArray[i].getElementsByTagName('INPUT')[0].value != '' ? dtArray[i].getElementsByTagName('INPUT')[0].value : dtArray[i].getElementsByTagName('SPAN')[0].innerHTML; 
		}
	}
	
	initPageData();
	
	$(".tit a:contains('个人资料')").attr('class' , 'hot');
	
</script>
<#include "../bottom.ftl" />
</body>
</html>
