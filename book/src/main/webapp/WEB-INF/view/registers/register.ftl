<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="http://html.chineseall.cn/static/style/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<link rel="stylesheet" href="http://html.chineseall.cn/static/script/jquery-ui/themes/base/jquery-ui.css" />
<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.uploadPreview.js" ></script>
<script src="http://html.chineseall.cn/static/script/jquery.validate.js" type="text/javascript"></script>
<script src="http://html.chineseall.cn/static/script/jquery-ui/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script src="http://html.chineseall.cn/static/script/jquery-ui/ui/jquery-ui.js"></script>
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
	<div class="loginStep"><span class="s1"> </span></div>
	<div class="loginContent">
		<p class="p">我们网站是实名注册网站，要求您注册时务必填写真实个人信息（包括姓名、机构、职业、性别等），如果您填写的个人信息有误，将无法参加在线阅读征文活动；如果您机构选择错误，也将导致您无法参加网站的各项活动；如果选择机构时找不到您所在学校，请通知您所在学校老师，让您老师联系我们开通学校。 </p>
		<form id="RegForm" action="/register.action" method="POST">
		<div class="iptArea f">
			<label>
				<strong>您即将注册成为机构：</strong>
				<input id="orgTreeId" name="orgTreeId" type="hidden" value="${currentOrgTree.id}"/>
				<span id="viewName" style="color:red;">${currentOrgTree.viewName}</span>
			</label>
			<span>&nbsp;&nbsp;的用户。</span>
			<span><a href="javascript:void(0);" style="color:#9933CC;" onClick="showDialog();">重选</a></span>
			
			<div id="dialog">
				<iframe id="iframe" height="100%" width="100%" frameborder="0"></iframe>
			</div>
			<script>
				 $("#dialog").dialog({
					autoOpen: false,
					modal: true,
					resizable: false,
					draggable: false,
					width:700,
					height:450,
					show: {
						effect: "explode",
						duration: 1000
					},
					hide: {
						effect: "explode",
						duration: 1000
					},
					close: function(event,ui){
						$("#iframe").attr("src","");
					}
				});
				
				function showDialog(){
					$("#iframe").attr("src","/searchOrg.action");
					$("#dialog").dialog( "open" );
				}
				
				function selectTree(id, viewName){
					$('#orgTreeId').val(id);
					$('#viewName').html(viewName);
					$('#dialog').dialog( "close" );
				}
			</script>
			
		</div>
		<div class="iptArea">
			<label>
				<strong><em>*</em>用户名：</strong>
				<input class="ipt1" id="userName" type="text" name="userName" />
				<script>
					$("#userName").blur(function(){
						$.post("/isInWordUnit.action",{
							userName:$("#userName").val()
						},function(data){
							if(data.flag==1){
								alert(data.message);
								$("#userName").val("");
							}
						})
					})
				</script>
			</label>
			<span>用户名 6~16位字符</span>
		</div>
		<div class="iptArea">
			<label>
				<strong><em>*</em>密码：</strong>
				<input class="ipt1" type="password" id="userPass" name="userPass" />
			</label>
			<span>密码 6~16字符</span>
		</div>
		<div class="iptArea">
			<label>
				<strong><em>*</em>确认密码：</strong>
				<input class="ipt1" type="password" name="confirmPassword" />
			</label>
			<span>再次输入密码确认</span>
		</div>
		<div class="iptArea">
			<label>
				<strong><em>*</em>姓名：</strong>
				<input class="ipt2" type="text" name="realName" />
			</label>
			<span>如果您希望您的机构尽快通过你的申请，请填写真实姓名</span>
		</div>
		<div class="iptArea">
			<strong>性别：</strong>
			<input class="radio" type="radio" name="gender" id="radio" value="1" checked />
			<label class="now" for="radio">男</label>
			<input class="radio" type="radio" name="gender" id="radio2" value="0" />
			<label class="now" for="radio2">女</label>
		</div>
		<div class="iptArea">
			<label>
				<strong>职业：</strong>
				<select class="select" name="identity">
					<option value="1399">请选择一个职业</option>
					<option value="1301">教师</option>
					<option value="1302">小学生</option>
					<option value="1303">初中生</option>
					<option value="1304">高中生（含中职学校学生）</option>
					<option value="1305">家长</option>
					<option value="1306">大学生</option>
					<option value="1310">公务员</option>
					<option value="1320">企业职员</option>
					<option value="1321">企业管理人员</option>
					<option value="1399">其他</option>
				</select>
			</label>
			<span>选择一个职业，书香中国会为您推荐更适合您的书籍。</span>
		</div>
		<div class="iptArea">
			<label>
				<strong>生日：</strong>
				<input class="ipt1" type="text" id="birthday" name="birthday" />
				<script>
				$(function() {
					$( "#birthday" ).datepicker({
						dateFormat:'yy-mm-dd',
						changeMonth:true,
						changeYear:true,
						yearRange:'-100:+0'
					});
				});
				</script>
			</label>
			<span>您会在生日的时候收到书香中国给您的惊喜哦！</span>
		</div>
		<div class="iptArea">
			<strong>所在地：</strong>
			<select class="select" name="province" id="province">
				<option>选择省</option>
			</select>
			<select class="select" name="city" id="city">
				<option>选择市</option>
			</select>
			<select class="select" name="county" id="county">
				<option>选择区</option>
			</select>
			<span>填写所在地，您能够找到更多和您在一起的书友。</span>
		</div>
<script>
	$(function() {
		$.post("/getRegion.action",{
			'parentId':0
		},function(data){
			$(data.regionList).each(function(i,item){
				$("#province").append("<option value='"+item.name+"' rel='"+item.id+"'>"+item.name+"</option>")
			});
		})
	});
	
	$("#province").change(function(){
		$("#city > option :not(:first)").remove();
		$("#county > option :not(:first)").remove();
		if($("#province :checked").attr('rel')!=0){
			$.post("/getRegion.action",{
				'parentId':$("#province :checked").attr('rel')
			},function(data){
				$(data.regionList).each(function(i,item){
					$("#city").append("<option value='"+item.name+"' rel='"+item.id+"'>"+item.name+"</option>")
				});
			})
		}
	})
	
	$("#city").change(function(){
		$("#county > option :not(:first)").remove();
		if($("#city :checked").attr('rel')!=0){
			$.post("/getRegion.action",{
				'parentId':$("#city :checked").attr('rel')
			},function(data){
				$(data.regionList).each(function(i,item){
					$("#county").append("<option value='"+item.name+"' rel='"+item.id+"'>"+item.name+"</option>")
				});
			})
		}
	})
	
</script>
		<div class="iptArea">
			<label>
				<strong>E-mail：</strong>
				<input class="ipt1" type="text" name="email" />
			</label>
			<span>用于登录网站以及找回您的密码</span>
		</div>
		<div class="iptArea">
			<label>
				<strong>QQ号码：</strong>
				<input class="ipt1" type="text" name="qq" />
			</label>
			<span>用于登录网站以及找回您的密码</span>
		</div>
		<div class="submitArea">
			<input name="next" class="s1" type="submit" value="下一步，完善您的资料" />
			<input name="over" type="submit" value="直接完成注册，进入书房" />
		</div>
		</form>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#RegForm").validate({
					rules:{
						userName:{
							required:true,
							byteRangeLength:[6,16],
							remote: {
							    url: "/checkUserName.action",
							    type: "post",
							    dataType: "json",  
							    data: {
							        userName: function() {
							            return $("#userName").val();
							        }
							    }
							}
						},
						userPass:{
							required:true,
							rangelength:[6,16]
						},
						confirmPassword:{
							required:true,
							equalTo:"#userPass"
						},
						realName:{
							required:true
						}
					},
					messages:{
						userName:{
							required:"用户名不能为空",
							byteRangeLength:"用户名 6~16位字符",
							remote:"该用户名已存在"
						},
						userPass:{
							required:"密码不能为空",
							rangelength:"密码 6~16位字符"
						},
						confirmPassword:{
							required:"请再次输入密码确认",
							equalTo:"两次输入的密码不一致"
						},
						realName:{
							required:"姓名不能为空"
						}
					},
					errorPlacement: function(error, element) {
						error.css("color","red");
					    element.parent().parent().find("span").html(error);
					},
					success: function(label) {
					    label.html("&nbsp;");
					}
				});
				jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {
					var length = value.length;
					for(var i = 0; i < value.length; i++){
						if(value.charCodeAt(i) > 127){
							length++;
						}
					}
					return this.optional(element) || ( length >= param[0] && length <= param[1] );
				})
			})
		</script>
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
