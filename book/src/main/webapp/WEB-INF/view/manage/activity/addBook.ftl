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
	<a href="/manage/activity/book.action?activityId=${activityId}">推荐书目</a> | <a class="hot" href="/manage/activity/book.action?activityId=${activityId}&type=1">添加推荐书目</a>
</div>
<!--内容区-->
<div class="context">
	<form action="/manage/activity/book.action" method="post" name="selectBookForm">
		<input type="hidden" name="activityId" value="${activityId}"/>
		<input type="hidden" name="type" value="${type}"/>
		<div>
			<div style="float:left;width:200px;">
				书&nbsp;&nbsp;&nbsp;名:<input type="text" value="${bookName!''}" name="bookName" style="width:120px;" />
			</div>
			<div class="cont" style="float:left;width:200px;">
				作&nbsp;&nbsp;&nbsp;者:<input type="text" value="${author!''}" name="author" style="width:120px;"/>
			</div>
			<div class="cont" style="float:left;width:200px;">
				出版社:<input type="text" value="${publisher!''}" name="publisher" style="width:120px;" />
			</div>
			<br/><br/>
			<div style="float:left;width:500px;">
				图书id:<input type="text" value="${bookIds!''}" id="bookIds" name="bookIds" style="width:450px;" />
			</div>
			<div style="float:right;width:180px;">
				<input type="button" value="查 询" class="buttonmin yellow" style="cursor:pointer;" onclick="queryBook();">
			</div>
			<div style="clear:both;margin-bottom:10px;"></div>
		</div>
	</form>
	<div style="clear:both;border-bottom: 1px dotted #666666;margin-bottom:10px;"></div>
	<div>
		<form name="acBookForm" method="post">
			<input type="hidden" name="activityId" value="${activityId}"/>
			<table width="100%" cellspacing="2" cellpadding="8" class="listTable">
				<tbody>
					<tr>
						<th>
						<input type="checkbox" id="selectAll">
						</th>
						<td>
						<input class="button blue right" type="button" value="推荐选中的图书" onclick="selectAcBook('-1');" />
						</td>
					</tr>
					<#if books??>
						<#list books as book>
							<tr class="bg1">
								<th>
								    <#if book.id==0>
								    <#else>
								    	<input type="checkbox" id="id${book_index}" name="ids" value="${book.bookId}"/>
								    </#if>
								</th>
								<td class="listbooks1">
								<a class="book" href="/book/detail.action?bookId=${book.bookId}"><img src="http://${imgDomainName!''}/${ImageUtils.getBookImgUrl(book.bookId)}" /></a>
								<h4><a href="/book/detail.action?bookId=${book.bookId}">${book.bookName!''}</a></h4>
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
									<#if book.id==0>
								    <#else>
								    	<input class="buttonmin" type="button" value="推荐" onclick="selectAcBook('${book_index}');"/>
								    </#if>
								</p></td>
							</tr>
						</#list>
					</#if>
				</tbody>
			</table>
		</form>
	</div>
	<div class="bottomInfo2">
		<div class="right">
			<@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
		</div>
	</div>
</div>
<script type="text/javascript"> 
	function queryBook(){
       var bookIds=document.getElementById("bookIds");
       if(bookIds.value!=''){
       	  alert(bookIds.value);
          bookIds.value = bookIds.value.replace(/，/g, ",");
          alert(bookIds.value);
       }
       document.selectBookForm.submit();
   }
	
	$("#selectAll").click(function(){
		$("input[type='checkbox']").each(function(){
			if($("#selectAll").attr("checked")){
				$(this).attr("checked", true);
			}else{
				$(this).attr("checked", false);
			}
		});
	});

   /**
   **推荐图书
   **/
   function selectAcBook(index){
	      if(index!='-1'){
	         document.getElementById("id"+index).checked=true;  
	      }
	      var ids=document.getElementsByName("ids");
	      for(var i=0;i<ids.length;i++){
	         if(ids[i].checked==true){
	            document.acBookForm.action="/manage/activity/book/add.action";
	            document.acBookForm.submit();
	            return false;
	         }
	      }
	      alert('请选择要推荐的图书');
   }
</script>