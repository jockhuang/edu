<script id="expandScript" type="text/javascript" src="http://html.chineseall.cn/static/script/Qui.class.ExpandMenu.js?4.1"></script>
<div class="crumbs">
	<a href="javascript:void(0);">首页</a> &gt; <a href="javascript:void(0);">活动管理</a> &gt; 活动列表
</div>
<h2>${activity.activityName!''}</h2>
<div class="greenNav">
	<#if orgTreeId==activity.orgTreeId>
		<a href="/manage/activity.action?activityId=${activityId}">基本信息</a>
		<a href="/manage/activity/collaborator/list.action?activityId=${activityId}">协办机构</a>
		<a href="/manage/activity/bulletin/list.action?activityId=${activityId}">活动公告</a>
		<a href="/manage/activity/logo.action?activityId=${activityId}">页面管理</a>
		<a class="hot" href="/manage/activity/book.action?activityId=${activityId}">书目管理</a>
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
	<a class="hot" href="/manage/activity/book.action?activityId=${activityId}">推荐书目</a> | <a href="/manage/activity/book.action?activityId=${activityId}&type=1">添加推荐书目</a>
</div>
<!--内容区-->
<div class="context">
	<form name="acBookForm" method="post">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<table class="listTable" cellpadding="8" cellspacing="2" width="100%">
			<tr>
				<th><input type="checkbox" id="id" name="idAll" onclick="checkAll(this);"/></th>
				<th>
				<input class="button blue right" type="button" value="删除选中的图书" onclick="delAcBook('-1');" />
				</th>
			</tr>
			<#if books??>
				<#list books as book>
					<tr class="bg1">
						<th>
							<input type="checkbox" id="id${book_index}" name="ids" value="${book.bookId}"/>
						</th>
						<td class="listbooks1">
						<a class="book" href="/book/detail.action?bookId=${book.bookId}"><img src="http://${imgDomainName!''}/${ImageUtils.getBookImgUrl(book.bookId)}" /></a><h4><a href="/book/detail.action?bookId=${book.bookId}">${book.bookName}</a></h4>
						<p>
							<#if book.author??>
								<span class="gray">作者：</span>${book.author} 
							</#if>
							<#if book.publisher??>
								<span class="gray">/ 出版社：</span> ${book.publisher} 
							</#if>
							<#if book.publishDate??>
								<span class="gray"> / 出版日期：</span>${book.publishDate}
							</#if>
						</p>
						<p>
							<#if book.intro??>
								${book.intro}
							</#if>
						</p>
						<p>
							<span class="gray">阅读次数：</span>${book.totalReadCount!0}
							<input class="buttonmin" type="button" value="取消推荐" onclick="delAcBook('${book_index}');"/>
						</p></td>
					</tr>
				</#list>
			</#if>
		</table>
	</form>
	<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
</div>
<script type="text/javascript">
	/**
   **全选
   **/
   function checkAll(object){
      var ids=document.getElementsByName("ids");
      for(var i=0;i<ids.length;i++){
         ids[i].checked=object.checked;
      }
   }
   /**
   **删除推荐图书
   **/
   function delAcBook(index){
	      if(index!='-1'){
	         document.getElementById("id"+index).checked=true;  
	      }
	      var ids=document.getElementsByName("ids");
	      for(var i=0;i<ids.length;i++){
	         if(ids[i].checked==true){
	            document.acBookForm.action="/manage/activity/book/del.action";
	            document.acBookForm.submit();
	            return false;
	         }
	      }
	      alert('请选择要删除的图书');
   }
</script>
