
<div class="layoutleft">
	<div class="userBox">
		<div class="user_icon"><img alt="${loginUser.displayName}" src="http://img3.chineseall.cn${ImageUtils.getUserImgUrl(loginUser.userId)}" 
			onerror="javascript:this.src='http://img3.chineseall.cn/userHeadImg/moren/default.jpg'" ></div>
		<h3 class="user_name">${loginUser.displayName}</h3>
		<div class="classIcon">
			<#if (loginUser.level??)>
			<img src="${loginUser.level.classic!''}">
			${loginUser.level.level!''}
			<#else>
			<img src="http://www.chineseall.cn/admincommon/images/level_01.png">
			童生
			</#if>
		</div>
		<div class="classIcon">
		</div>
		<p class="info">
			书香积分：${loginUser.score?default(0)}<br />
			<#if (loginUser.province??)>
			${loginUser.province}<#if (loginUser.city??)>&gt;${loginUser.city}</#if>
			</#if>
			<br />
		</p>
		<ul>
			<li><a href="/user/dialogue.action"><em class="mail"></em>书信
			<cite class="c">(${notReadLetterCount})</cite></a></li>
		</ul>
	</div>
	<div id="sideNav" class="sideNav">
		<dl>
			<dt><a href="/user/i.action" ><em class="index"></em>书房首页</a></dt>
			<dd style="display: none;">
			</dd>
		</dl>
		<dl>
			<dt><a href="/user/recommended.action" ><em class="zp"></em>已购图书</a></dt>
			<dd style="display: none;">
				<a href="/user/recommended.action">已购单本图书</a>
				<a href="/user/merecommended.action">已购图书专辑</a>
			</dd>
		</dl>
		<dl>
			<dt><a href="/user/collection.action"><em class="csj"></em>藏书架</a></dt>
			<dd style="display: none;">
				<a href="/user/reading.action">最近阅读</a>
				<a href="/user/collection.action">我的藏书</a>
			</dd>
		</dl>
		<dl>
			<dt><a href="/user/commentbook.action"><em class="ps"></em>书评</a></dt>
			<dd style="display: none;">
				<a href="/user/commentbook.action">我的书评</a>
				<a href="/user/fcomment.action">好友书评</a>
			</dd>
		</dl>
		<dl>
			<dt ><a href="/user/work.action"><em class="zp"></em>我的作品</a></dt>
			<dd style="display: none;">
				<a href="/user/work.action">我的作品</a>
				<a href="/user/fwork.action">好友的作品</a>
			</dd>
		</dl>
		<dl>
			<dt ><a href="/user/meconcern.action"><em class="sy"></em>我的书友</a></dt>
			<dd style="display: none;">
				<a href="/user/meconcern.action">我关注的</a>
				<a href="/user/concernme.action">关注我的</a>
				<a href="/user/visitme.action">谁来看过我</a>
				<a href="/user/concernlog.action">关注记录</a>
			</dd>
		</dl>
		<dl>
			<dt ><a href="/user/listMyOrders.action"><em class="zp"></em>我的订单</a></dt>
		</dl>
	</div>
</div>
<script type="text/javascript">
	var menuTag = document.getElementById('sideNav');
	var menudl = menuTag.getElementsByTagName('dl');
	var menudt = menuTag.getElementsByTagName('dt');
	var menudd = menuTag.getElementsByTagName('dd');
	for(var i=0,j;j=menudl[i++];){
		j.data = i-1;
		j.onmouseover = function(){
			for(var a=0,b;b=menudd[a++];) b.style.display = 'none';

			menudd[this.data].style.display = 'block';
			menudt[this.data].className = 'over';
		}
		j.onmouseout = function(){
			for(var a=0,b;b=menudd[a++];) {
				menudd[this.data].style.display = 'none';
				menudt[this.data].className = '';
			}
		}
	}
	setTimeout(function(){
		var selMenu = $('#sideNav dt a[href="' +window.location.pathname+ '"]')
		if(selMenu.length > 0){
			$(selMenu).parent().parent().attr('class' , 'current');
		}else{
			$('#sideNav dd a[href="' +window.location.pathname+ '"]').parent().parent().attr('class' , 'current');
		}
	} , 500);
</script>