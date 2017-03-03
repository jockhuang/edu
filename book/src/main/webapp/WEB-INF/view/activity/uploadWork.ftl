<#assign fck=JspTaglibs["http://java.fckeditor.net"]/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>

<body>
<div class="huodong">
	<div class="bb1 huodong_left">
		<div class="huodongTitleMenu">
			<ul>
				<li class="b1"><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=0">返回首页</a></li>
				<li class="b2"><a href="/activity/index.action?activityId=${activityId}&currentPage=1">读书活动</a></li>
				<li class="b3"><a href="/activity/book.action?activityId=${activityId}&currentPage=1">活动书单</a></li>
				<li class="b4"><a href="/activity/works.action?activityId=${activityId}&orgTreeId=${orgTreeId}">作品展示</a></li>
				<li class="b5"><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=1">谁在参加</a></li>
				<li class="b6">
					<!-- Baidu Button BEGIN -->
					<div id="bdshare" class="bdshare_b"></div>
					<script type="text/javascript" id="bdshare_js" data="type=button&amp;uid=972509" ></script>
					<script type="text/javascript" id="bdshell_js"></script>
					<script type="text/javascript">
					document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
					</script>
					<!-- Baidu Button END -->
				</li>
			</ul>
		</div>
		<div class="houdongContentBox">
			<div class="tit2">
				<h2>提交作品</h2>
			</div>
			<div class="tijiao">
				<p class="p">用户所属机构：
				<#if orgTree?? && orgTree.viewName>
					${orgTree.viewName}
				</#if>
				</p>
				<form id="workForm" name="workForm" action="/activity/add/pic.action" target="hiddenIframe"  method="post" enctype ="multipart/form-data">
					<input type="hidden" name="activityId" value="${activityId}"></input>
					<div class="iptArea">
						<label>
							<strong><em>*</em>作者：</strong>
							<input class="ipt1" type="text" id="realName" name="realName" value="${user.realName!''}"/>
						</label>
					</div>
					<div class="iptArea">
						<label>
							<strong><em>*</em>指导老师：</strong>
							<input class="ipt1" type="text" id="guide" name="guide" value="无"/>
						</label>
					</div>
					<div class="iptArea">
						<label>
							<strong><em>*</em>年级及班级：</strong>
							<input class="ipt1" type="text" id="className" name="className" value="${user.className!''}"/>
						</label>
					</div>
					<div class="tijiao_box">
						<div class="iptArea">
							<label>
								<strong>电话：</strong>
								<input class="ipt1" type="text" id="phone" name="phone" value="${user.phone!''}"/>
							</label>
						</div>
						<div class="iptArea">
							<label>
								<strong>地址：</strong>
								<input class="ipt1" type="text" id="address" name="address" value="${user.address!''}"/>
							</label>
						</div>
						<div class="iptArea">
							<label>
								<strong>邮箱：</strong>
								<input class="ipt1" type="text" id="email" name="email" value="${user.email!''}"/>
							</label>
						</div>
					</div>
					<div class="iptArea">
						<label>
							<strong><em>*</em>作品标题：</strong>
							<input class="ipt1" type="text" id="worksName" name="worksName"/>
						</label>
						<span>限制30个汉字内</span>
					</div>
					<#if groups?? && groups?size==0>
					<#else>
						<div class="iptArea">
							<label>
								<strong><em>*</em>选择分组：</strong>
								<select class="ipt1" style="width:366px;height:35px;" id="groupId" name="groupId">
									<#list groups as group>
											<option class="ipt1" value="${group.groupId}">${group.groupName}</option>
									</#list>
								</select>
							</label>
						</div>
					</#if>
					<div class="iptArea">
						<label>
							<strong>作品内容：</strong>
							<@fck.editor toolbarSet="Basic" instanceName="worksContent" height="300px" value=""></@fck.editor> 
						</label>
					</div>
					<div class="iptArea tac" style="margin-left:30px">
						<input type="button" class="submit" value="提 交" onclick="saveCompositionWorks();"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="w310 right">
		<div class="bb1 hd_zp">
			<ul>
				<li>
					<strong>参加人数</strong>
					<p><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=1">${activity.joinUserCount}</a></p>
				</li>
				<li>
					<strong class="hot">作品数</strong>
					<p><a href="/activity/works.action?activityId=${activityId}&orgTreeId=${orgTreeId}">${activity.worksCount}</a></p>
				</li>
				<li>
					<strong>活动书单</strong>
					<p><a href="/activity/book.action?activityId=${activityId}&currentPage=1">${activity.acBookCount}</a></p>
				</li>
			</ul>
		</div>
		<#if bulletins??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>活动公告</h2>
				</div>
				<div class="con gg" id="indexUserList">
					<#list bulletins as bulletin>
						<dl>
							<dt><span>${bulletin.creationTime?string("yyyy年MM月dd日 ")}</span><a href="/activity/bulletin.action?activityId=${activityId}&bulletinId=${bulletin.bulletinId}">${bulletin.title}</a></dt>
							<dd>
								<span>${bulletin.creationTime?string("yyyy年MM月dd日 ")}</span>
								<p><a href="/activity/bulletin.action?activityId=${activityId}&bulletinId=${bulletin.bulletinId}">${bulletin.content}</a></p>
							</dd>
						</dl>
					</#list>
				</div>
			</div>
		</#if>
		<#if orgs??>
			<div class="bb1 mt10 rjigou">
				<#list orgs as org>
					<#if org_index == 0>
							<div class="tit1">
								<h2>主办机构</h2>
							</div>
							<dl class="rjigou_dl line">
								<dt><a target="_blank" href="/org/index.action?orgTreeId=${org.orgTreeId}"><img src="http://${imgDomainName!''}/${ImageUtils.getOrgLogoUrl(org.orgTreeId)}" /></a></dt>
								<dd>
									<strong>${org.viewName!''}</strong>
									<p></p>
								</dd>
							</dl>
					<#else>
						<#if org_index == 1>
							<div class="tit1">
								<h2>协办机构</h2>
							</div>
							<div class="rjigou_li">
								<ul>
						</#if>
						<li><a target="_blank" href="/org/index.action?orgTreeId=${org.orgTreeId}"><img src="http://${imgDomainName!''}/${ImageUtils.getOrgLogoUrl(org.orgTreeId)}" /></a><span>${org.viewName!''}</span></li>
						<#if ((orgs?size - org_index)==1)> 
							</ul></div>
						</#if>
					</#if>
				</#list>
			</div>
		</#if>
		<#if users??>
			<div class="bb1 mt10">
				<div class="tit1">
					<h2>谁在参加</h2>
					<span><a href="/activity/joinusers.action?activityId=${activityId}&currentPage=0">查看全部&raquo;</a></span>
				</div>
				<div class="con padb10">
					<div class="indexUserList_dl">
						<#list users as user>
							<dl>
								<dt><a target="_blank" href="/user/${user.userId}/i.action"><img src="http://${imgDomainName!''}/${ImageUtils.getUserImgUrl(user.userId)}"></a></dt>
							</dl>
						</#list>
					</div>
				</div>
			</div>
		</#if>
	</div>
</div>
<script src="http://html.chineseall.cn/static/script/indexUserList.js" type="text/javascript"></script>
<script type="text/javascript">
var inputText = $(':text,textarea');
inputText.focus(function(){$(this).addClass('a')});
inputText.blur(function(){$(this).removeClass('a')});
</script>
<script type="text/javascript">
   //提交征文与作品信息
	function saveCompositionWorks(){
	    var oEditor = FCKeditorAPI.GetInstance("worksContent");
	    var value=oEditor.GetXHTML(true);
		var title = document.getElementById("worksName");
		if($.trim(title.value)==""){
			alert("作品标题不能为空！");
			return false;
		}else if($.trim(title.value).length>30){
			alert("作品标题字数太多！！！");
			return false;
		}else{
			var result=true;
			jQuery.ajax({
		   		type:"POST",
		   		url: "/activity/judgeKeys.action",
		   		data:'content='+encodeURI(encodeURI(title.value))+'&type=0',
		   		async: false, 
			    success: function(msg){
			      if(msg != "true"){
	    		     alert("你的作品标题包含有敏感词汇(\""+msg+"\"),请重新输入！");
	    		     result=false;
	    		     return false;
	    		  }
			   }
			});
			if(!result){
				return false;
			}
		}
		if(value.replace(/\s+/g,"")==""){
			alert("作品内容不能为空！");
			return false;
		}else if(value.replace(/\s+/g,"").length>10000){
			alert("因字符超限，建议手工输入，或用TXT文本拷贝谢谢！！！");
			return false;
		}else{
			var result=true;
			jQuery.ajax({
		   		type:"POST",
		   		url: "/activity/judgeKeys.action",
		   		data:'content='+encodeURI(encodeURI(value))+'&type=0',
		   		async: false, 
			    success: function(msg){
			      if(msg != "true"){
			      	var content="";
    		     	var result=msg.split(",");
    		     	for(var i=0;i<result.length;i++){
    		     		content=value.replace(result[i],"[<font color=\"red\">"+result[i]+"</font>]");
    		     	}
    		     	var oEditor = FCKeditorAPI.GetInstance("worksContent");
    		     	oEditor.SetHTML(content);
    		     	alert("你的作品内容包含有敏感词汇(\""+msg+"\"),请重新输入！");
	    		   	result=false;
	    		    return false;
	    		  }
			   }
			});
			if(!result){
				return false;
			}
		}
		if($.trim(document.getElementById("realName").value) == '' || $.trim(document.getElementById("realName").value) == '必填'){
		    alert('请填写作者姓名!');
			return false;
		}
		if($.trim(document.getElementById("realName").value).length > 50){
			alert('姓名过长,请认真填写!!!');
			return false;
		}
		if($.trim(document.getElementById("guide").value) == ''){
		    alert('指导老师不能为空,如果没有可填"无"!');
			return false;
		}
		if($.trim(document.getElementById("guide").value).length > 50){
			alert('指导老师过长,请认真填写!!!');
			return false;
		}
		if($.trim(document.getElementById("className").value) == '' || $.trim(document.getElementById("className").value) == '必填'){
		    alert('请填写班级名称!!!');
			return false;
		}
		if($.trim(document.getElementById("className").value).length > 100){
			alert('班级名称过长,请认真填写!!!');
			return false;
		}
		document.workForm.target="_self";
		document.workForm.action="/activity/add/work.action";
		document.workForm.submit();
	}
</script>
</body>
</html>
