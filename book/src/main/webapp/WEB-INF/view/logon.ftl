<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/login.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>
<body class="login_body">
<div class="loginIndex">
	<div class="loginIndex_left">
		<div class="login_link">
			<span>您还没有书香中国的账号？请加入</span>
			<a class="login_zc" href="/showRegister.action">立即注册</a>
		</div>
		<div class="login_imgjs">
			<ul class="login_imgjs_ul">
				<li id="imgjs_div0" onclick="tabit_time(this)"><a href="#"><img src="http://html.chineseall.cn/static/images/560x315.jpg" /></a></li>
				<li id="imgjs_div1" onclick="tabit_time(this)" style="display:none;"><a href="#"><img src="http://html.chineseall.cn/static/images/600x180.jpg" /></a></li>
				<li id="imgjs_div2" onclick="tabit_time(this)" style="display:none;"><a href="#"><img src="http://html.chineseall.cn/static/images/280x84.jpg" /></a></li>
			</ul>
			<ul class="bookTab2">
				<li class="hot_a" onclick=" tabit('imgjs',0,3,'hot');tabit_time(this)" id="imgjs_btn0">1</li>
				<li class="btn_b" onclick=" tabit('imgjs',1,3,'hot');tabit_time(this)" id="imgjs_btn1">2</li>
				<li class="btn_b" onclick=" tabit('imgjs',2,3,'hot');tabit_time(this)" id="imgjs_btn2">3</li>
			</ul>
			<script type="text/javascript">
				//自动播放
				var flashjs_n = 0;
				var flashjs_m;
				function flashjs_rool(){
					flashjs_m = setInterval(function(){
						tabit('imgjs',flashjs_n,3,'hot');
						flashjs_n++;
						if(flashjs_n>=3)flashjs_n=0;
					},5000);
				}
				flashjs_rool()
				function tabit_time(tag){
					clearInterval(flashjs_m);
					tag.onmouseout=flashjs_rool;
				}
			</script>
		</div>
	</div>
	<!--登录部分代码-->
	<iframe width="310px" height="255px;" frameborder="0" scrolling="no" src='/customLogin.action?returnUrl=${returnUrl!''}&time=${.now}' style="float:right;margin-right:10px;"></iframe>
</div>
</body>
</html>