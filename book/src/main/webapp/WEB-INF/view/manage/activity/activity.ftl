<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.0"></script>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/kindeditor/kindeditor-all.js"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表 
</div>
<!--内容区-->
<div class="context">
	<form action="/manage/activity/add.action" name="activityInfoForm" method="post">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<tr>
				<th width="120"><span class="red">*</span>活动类型：</th>
				<td>
				<select class="text" id="activityType" name="activityType">
					<option value="1">读书活动</option>
					<option value="3">摄影活动</option>
					<option value="4">绘画活动</option>
				</select>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>活动名称：</th><td>
				<input class="text" id="activityName" name="activityName" type="text" />
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>投稿开始时间：</th><td>
				<input class="text" id="submitStart" name="submitStart" type="text" />
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>投稿结束时间：</th><td>
				<input class="text" id="submitEnd" name="submitEnd" type="text" />
				</td>
			<tr>
				<th><span class="red">*</span>活动结束时间：</th><td>
				<input class="text" id="finishDate" name="finishDate" type="text" />
				</td>
				<th></th><td></td>
			</tr>
			<tr>
				<th><span class="red">*</span>活动简介：</th>
				<td>
				<textarea id="description" name="description" style="width:400px;height:300px;visibility:hidden;"></textarea>
				<script>
		     		var editor;
					KindEditor.ready(function(K) {
						editor = K.create('textarea[name="description"]', {
							resizeType : 1,
							width : "90%",
							uploadJson : '/editorUpload.action',
							afterBlur:function(){ 
					            this.sync(); 
					        },
							items : [
								'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
								'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
								'insertunorderedlist', '|', 'emoticons', 'image', 'link']
						    });
					});
		     	</script>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>可参与用户：</th><td>
				<select id="joinLimit" name="joinLimit">
					<option value="1" checked>本机构及下属机构用户</option>
					<option value="2">仅限本机构用户</option>
					<option value="3">全站用户</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>作品分组：</th><td>
					<input type="checkbox" onclick="showGroup(this);"/> 设置活动作品分组
				</td>
			</tr>
			<tr>
				<th></th><td>请输入分组名称</td>
			</tr>
			<tr>
				<th>1:</th><td><input class="text" id="group1" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>2:</th><td><input class="text" id="group2" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>3:</th><td><input class="text" id="group3" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>4:</th><td><input class="text" id="group4" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>5:</th><td><input class="text" id="group5" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>6:</th><td><input class="text" id="group6" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>7:</th><td><input class="text" id="group7" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>8:</th><td><input class="text" id="group8" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>9:</th><td><input class="text" id="group9" name="group" type="text" /></td>
			</tr>
			<tr>
				<th>10:</th><td><input class="text" id="group10" name="group" type="text" /></td>
			</tr>
			<tr>
				<th><span class="red">*</span>作品审核：</th><td>
				<input type="radio" name="worksModule" value="1" checked/> 提交后直接发布
				<input type="radio" name="worksModule" value="2" /> 审核后发布
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>作品评选模式：</th><td>
				<input type="radio" name="evaluateModule" value="1" checked/> 层层评审 层层推荐
				<input type="radio" name="evaluateModule" value="2" /> 活动创建者统一评审
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button yellow" type="button" value="保存进入下一步" onclick="saveCompositionWorks();"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<link href="http://html.chineseall.cn/static/script/jquery.ui/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" ></link>
<script src="http://html.chineseall.cn/static/script/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery.ui/jquery.ui.core.js"></script>
<script src="http://html.chineseall.cn/static/script/jquery.ui/jquery.ui.widget.js"></script>
<script src="http://html.chineseall.cn/static/script/jquery.ui/jquery.ui.datepicker.js"></script>
<script src="http://html.chineseall.cn/static/script/jquery.ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	var groupname = $('input[name=group]').parent('td').parent('tr').css({'display': 'none'});
	$('#group1').parent('td').parent('tr').prev().css({'display': 'none'});
    function showGroup(obj){
    	if(obj.checked){
    		groupname.css({'display' : ''});
    		$('#group1').parent('td').parent('tr').prev().css({'display': ''});
    	}else{
    		groupname.css({'display' : 'none'});
    		$('#group1').parent('td').parent('tr').prev().css({'display': 'none'});
    	}
    }
	/**
	**投稿开始时间控件
	**/
	$(function() {
		$("#submitStart" ).datepicker();
	});
	/**
	**投稿结束时间控件
	**/
	$(function() {
		$("#submitEnd" ).datepicker();
	});
	/**
	**活动结束时间控件
	**/
	$(function() {
		$("#finishDate" ).datepicker();
	});
	 /**
	 **检查数据合法性
	 **/
	function saveCompositionWorks(){
		var activityName = document.getElementById("activityName").value;
		if(activityName.replace(/\s+/g,"")==""){
		   alert("请输入活动名字！"); 
		   return false; 
	    }else if(activityName.replace(/\s+/g,"").length>25){
			alert("活动名称最多输入25个字符！");
			return false;
		}
		var submitStart = document.getElementById("submitStart").value;
		if(submitStart.replace(/\s+/g,"")==""){
		   alert("请输入投稿开始时间！"); 
		   return false; 
		}
		var submitEnd = document.getElementById("submitEnd").value;
		if(submitEnd.replace(/\s+/g,"")==""){
		   alert("请输入投稿结束时间！"); 
		   return false; 
		}
		var finishDate = document.getElementById("finishDate").value;
		if(submitEnd<=submitStart){
		   alert("投稿结束时间必须大于投稿开始时间！"); 
		   return false; 
		}
		if(finishDate!='' && finishDate<=submitEnd){
		   alert("活动结束时间必须大于投稿结束时间！"); 
		   return false; 
		}
		var description = document.getElementById("description").value;
		if(description.replace(/\s+/g,"")==""){
			alert("请输入简要介绍！");
			return false;
		}else if(description.replace(/\s+/g,"").length>500){
			alert("简要介绍不能超过500个字！");
			return false;
		}
		document.activityInfoForm.submit();
	}
</script>
