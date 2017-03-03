<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/kindeditor/kindeditor-all.js"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="greenNav">
	<#if orgTreeId==activity.orgTreeId>
		<a class="hot" href="/manage/activity.action?activityId=${activityId}">基本信息</a>
		<a href="/manage/activity/collaborator/list.action?activityId=${activityId}">协办机构</a>
		<a href="/manage/activity/bulletin/list.action?activityId=${activityId}">活动公告</a>
		<a href="/manage/activity/logo.action?activityId=${activityId}">页面管理</a>
		<a href="/manage/activity/book.action?activityId=${activityId}">书目管理</a>
	</#if>
	<a href="/manage/activity/jury/list.action?activityId=${activityId}">活动评委</a>
	<a href="/manage/activity/works/listAllWorks.action?activityId=${activityId}">作品评选</a>
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity/works/listAcWorksGroupByDay.action?activityId=${activityId}">活动统计</a>
	<#else>
		<a href="/manage/activity/works/listAcWorksGroupByOrgTreeId.action?activityId=${activityId}&type=1">活动统计</a>
	</#if>
</div>
<div class="greenNav2">
	<a class="hot" href="/manage/activity.action?activityId=${activityId}">基本信息</a> | <a href="/manage/activity/group/listGroup.action?activityId=${activityId}">活动分组</a>
</div>
<!--内容区-->
<div class="context">
	<form action="/manage/activity/update.action" name="activityInfoForm" method="post">
		<table class="formTable" cellpadding="5" cellspacing="0" width="100%">
			<input name="activityId" type="hidden" value="${activity.activityId}"/>
			<tr>
				<th width="120"><span class="red">*</span>活动类型：</th>
				<td>
				<select class="text" id="activityType" name="activityType">
					<#if activity.activityType??>
						<#if activity.activityType==1>
							<option value="1" selected>读书活动</option>
						<#else>
							<option value="1">读书活动</option>
						</#if>
						<#if activity.activityType==3>
							<option value="3" selected>摄影活动</option>
						<#else>
							<option value="3">摄影活动</option>
						</#if>
						<#if activity.activityType==4>
							<option value="4" selected>绘画活动</option>
						<#else>
							<option value="4">绘画活动</option>
						</#if>
					<#else>
						<option value="1">读书活动</option>
						<option value="3">摄影活动</option>
						<option value="4">绘画活动</option>
					</#if>
				</select>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>活动名称：</th><td>
				<#if activity.activityName??>
					<input class="text" id="activityName" name="activityName" type="text" value="${activity.activityName}"/>
				<#else>
					<input class="text" id="activityName" name="activityName" type="text" />
				</#if>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>投稿开始时间：</th><td>
					<#if activity.submitStart??>
						<input class="text" id="submitStart" name="submitStart" type="text" value="${activity.submitStart?string('yyyy-MM-dd')}"/>
					<#else>
						<input class="text" id="submitStart" name="submitStart" type="text" />
					</#if>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>投稿结束时间：</th><td>
					<#if activity.submitEnd??>
						<input class="text" id="submitEnd" name="submitEnd" type="text" value="${activity.submitEnd?string('yyyy-MM-dd')}"/>
					<#else>
						<input class="text" id="submitEnd" name="submitEnd" type="text" />
					</#if>
				</td>
			<tr>
				<th><span class="red">*</span>活动结束时间：</th><td>
					<#if activity.finishDate??>
						<input class="text" id="finishDate" name="finishDate" type="text" value="${activity.finishDate?string('yyyy-MM-dd')}"/>
					<#else>
						<input class="text" id="finishDate" name="finishDate" type="text" />
					</#if>
				</td>
				<th></th><td></td>
			</tr>
			<tr>
				<th><span class="red">*</span>活动简介</th><td>
					<textarea id="description" name="description" style="width:400px;height:300px;visibility:hidden;">${activity.description!''}</textarea>
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
					<#if acconfig?? && acconfig.joinLimit??>
						<#if acconfig.joinLimit==1>
							<option value="1" selected>本机构及下属机构用户</option>
						<#else>
							<option value="1">本机构及下属机构用户</option>
						</#if>
						<#if acconfig.joinLimit==2>
							<option value="2" selected>仅限本机构用户</option>
						<#else>
							<option value="2">仅限本机构用户</option>
						</#if>
						<#if acconfig.joinLimit==3>
							<option value="3" selected>全站用户</option>
						<#else>
							<option value="3">全站用户</option>
						</#if>
					<#else>
						<option value="1">本机构及下属机构用户</option>
						<option value="2">仅限本机构用户</option>
						<option value="3">全站用户</option>
					</#if>
				</select>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>作品审核：</th><td>
					<#if acconfig?? && acconfig.worksModule??>
						<#if acconfig.worksModule==1>
							<input type="radio" name="worksModule" value="1" checked/> 提交后直接发布
						<#else>
							<input type="radio" name="worksModule" value="1"/> 提交后直接发布
						</#if>
						<#if acconfig.worksModule==2>
							<input type="radio" name="worksModule" value="2" checked/> 审核后发布
						<#else>
							<input type="radio" name="worksModule" value="2" /> 审核后发布
						</#if>
					<#else>
						<input type="radio" name="worksModule" value="1" checked/> 提交后直接发布
						<input type="radio" name="worksModule" value="2" /> 审核后发布
					</#if>
				</td>
			</tr>
			<tr>
				<th><span class="red">*</span>作品评选模式：</th><td>
					<#if acconfig?? && acconfig.evaluateModule??>
						<#if acconfig.evaluateModule==1>
							<input type="radio" name="evaluateModule" value="1" checked/> 层层评审 层层推荐
						<#else>
							<input type="radio" name="evaluateModule" value="1"/> 层层评审 层层推荐
						</#if>
						<#if acconfig.evaluateModule==2>
							<input type="radio" name="evaluateModule" value="2" checked/> 活动创建者统一评审
						<#else>
							<input type="radio" name="evaluateModule" value="2" /> 活动创建者统一评审
						</#if>
					<#else>
						<input type="radio" name="evaluateModule" value="1" checked/> 层层评审 层层推荐
						<input type="radio" name="evaluateModule" value="2" /> 活动创建者统一评审
					</#if>
				</td>
			</tr>
			<tr>
				<th></th><td>
				<input class="button yellow" type="button" value="确认保存" onclick="saveCompositionWorks();"/>
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
