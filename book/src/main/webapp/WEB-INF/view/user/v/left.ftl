<div class="layoutleft">
	<script type="text/javascript" src="/common/user_js/study.js"></script>
	<div class="userBox">
		<div class="user_icon"><img src="http://img3.chineseall.cn${visitUser.headImg?default('http://img3.chineseall.cn/userHeadImg/moren/default.jpg')}" /></div>
		<h3 class="user_name">${visitUser.displayName?default(visitUser.userName)}</h3>
		<div class="classIcon">
		<#if (visitUser.level??)>
		<img src="${visitUser.level.classic}">
		${visitUser.level.level}
		<#else>
		<img src="http://www.chineseall.cn/admincommon/images/level_01.png">
		童生
		</#if>
		</div>
		<p class="info">
			书香积分：${visitUser.score?default(0)}<br />
			<#if (visitUser.province??)>
			${visitUser.province}<#if (visitUser.city??)>&gt;${visitUser.city}</#if>
			</#if>
			<br />
		</p>
		<div class="btn">
			<!-- ygz 已关注样式-->
			<#if (isConcern?? && isConcern)>
			<a class="ygz" >已关注</a>
			<#else>
			<a class="gz" onclick="addConcern(${visitUser.userId} , flushPage)" >加关注</a>
			</#if>
			<a class="fx" onclick="sendLetter(${visitUser.userId})" >发信</a>
		</div>
	</div>
	<div class="sideNav" id="sideNav">
		<dl>
			<dt ><a href="/user/${visitUser.userId}/i.action"><em class="index"></em>TA的书房首页</a></dt>
			<dd></dd>
		</dl>
		<dl>
			<dt ><a href="/user/${visitUser.userId}/collection.action"><em class="csj"></em>TA的藏书架</a></dt>
			<dd >
				<a href="/user/${visitUser.userId}/collection.action">TA的藏书</a>
				<a href="/user/${visitUser.userId}/recommended.action">TA的图书</a>
				<a href="/user/${visitUser.userId}/merecommended.action">TA的图书专辑</a>
			</dd>
		</dl>
		<dl>
			<dt><a href="/user/${visitUser.userId}/comment.action"><em class="ps"></em>TA的书评</a></dt>
			<dd></dd>
		</dl>
		<dl>
			<dt><a href="/user/${visitUser.userId}/work.action"><em class="zp"></em>TA的作品</a></dt>
			<dd></dd>
		</dl>
		<dl>
			<dt><a href="/user/${visitUser.userId}/concern.action"><em class="sy"></em>TA的书友</a></dt>
			<dd>
				<a href="/user/${visitUser.userId}/concern.action">TA关注的</a>
				<a href="/user/${visitUser.userId}/concernhere.action">关注TA的</a>
			</dd>
		</dl>
		<!--
		<dl>
			<dt><a href="/user/30/creategroups"><em class="xz"></em>TA的读书小组</a></dt>
			<dd>
				<a href="/user/30/creategroups">TA创建的小组</a>
				<a href="/user/30/joingroups">TA加入的小组</a>
			</dd>
		</dl> 
		-->
	</div>
	<!--
	<div class="sideOther">
		<a href="/user/vip.jsps">成为<span class="red">VIP</span>账户</a>
		<a href="/footer/readme.html">积分说明</a>
		<a href="/footer/help.html">常见问题</a>
	</div>
	 -->
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
			$('#sideNav dd a[href=' +window.location.pathname+ 
				']').parent().parent().attr('class' , 'current');
		}
	} , 500);
</script>