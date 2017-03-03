<div class="popupTjBook">
	<div class="tit1">
		<h2>推荐 ${book.name}</h2>
		<a class="close" >关闭</a>
	</div>
	<div class="bookJs">
		<a><img src="http://img3.chineseall.cn${ImageUtils.getBookImgUrl(book.id)}"></a>
		<h3><a>${book.name}</a></h3>
		<span>${book.author?default('&lt;暂无作者信息&gt;')} / ${book.publisher?default('&lt;暂无出版社信息&gt;')}</span>
		<p>${intro?default('&lt;暂无简介&gt;')}</p>
		<dl class="tjd">
			<dt>推荐到：</dt>
			<dd class="ipt">
				<label><input id="recommendToMyOrg" class="cb1" type="checkbox" value="1" />我的归属机构</label>
				<label><input id="recommendToFriends" class="cb1" type="checkbox" value="1" />我关注的书友</label>
			</dd>
		</dl>
	</div>
	<#-- 
	<#if (listGroup?? && listGroup?size > 0)>
	<dl class="tjd m">
		<dt>同时推荐到：</dt>
		<dd class="list1">
			<ul>
				<#list listGroup as g>
				<li><label><img src="http://img3.chineseall.cn${g.logo?default('/userHeadImg/moren/default.jpg')}" /><span>${g.groupName}</span><input class="cb1" type="checkbox" value="${g.groupId}" name="groupId" /></label></li>
				</#list>
			</ul>
		</dd>
	</dl>
	</#if>
	-->
	<div class="popup_input">
		<textarea id="comment" ></textarea>
		<div class="popup_input_btn">
			<input type="button" value="推荐" />
			<input class="s2" type="button" value="取消" />
		</div>
	</div>
</div>