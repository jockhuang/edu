<#macro pageLine pageUtil queryCondition>
   <span style="float:left;display:none;">共<em><label id="main_dpVoteList_lblTotalPage">${pageUtil.totalCount}</label></em>条，当前第${pageUtil.currentPage}/${pageUtil.totalPage}页，每页${pageUtil.pageSize}条</span>
   <div style="float:center;">
   <a id="main_dpVoteList_btnPre" title="首页" <#if (pageUtil.currentPage<=1)>class="disenable_up" disabled="disabled" <#else> class="disabled_up" </#if> href="javascript:go(1);">首页</a>   
   <a id="main_dpVoteList_btnPre" title="上一页" <#if (pageUtil.currentPage<=1)>class="disenable_up" disabled="disabled"<#else> class="disabled_up"</#if> href="javascript:go(${pageUtil.prePage});">上一页</a>   
   <a id="main_dpVoteList_btnNext" title="下一页" <#if (pageUtil.currentPage>=pageUtil.totalPage)>class="disenable_down"   disabled="disabled"<#else> class="disabled_down"</#if> href="javascript:go(${pageUtil.nextPage});">下一页</a> 
   <a id="main_dpVoteList_btnNext" title="尾页" <#if (pageUtil.currentPage>=pageUtil.totalPage)>class="disenable_down"   disabled="disabled"<#else> class="disabled_down"</#if> href="javascript:go(${pageUtil.totalPage});">尾页</a>   
   <span style="margin-right:10px;">
    <input id="goPage" style="width:50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${pageUtil.currentPage!1}" type="text">
    <input onclick="goPage();" id="btn" class="btn" type="button" value="Go" style="cursor:pointer;">
    </span>
 </div>
 <script type="text/javascript">
  var query="";
  <#if (queryCondition!="")>
   query="&${queryCondition!''}"
  </#if>
  function go(page){  
   window.location="?currentPage="+page+"&pageSize=${pageUtil.pageSize}"+query;
  }
  function goPage(){
 	var regex = /^\d+$/;
    var page = document.getElementById("goPage").value;
    if(!regex.test(page)){
    	alert("请输入数字！");
    	return;
   }
   if((page > ${pageUtil.totalPage})){
        if(${pageUtil.totalPage}==0){
        	alert("当前查询条件无数据!");
        	return;
        }else if(${pageUtil.totalPage}==1){
        	window.location="?currentPage="+page+"&pageSize=${pageUtil.pageSize}"+query; 
	    	return;
        }else{
	    	alert("请输入1~${pageUtil.totalPage}的页数！");
	    	return;
    	}
    }
    window.location="?currentPage="+page+"&pageSize=${pageUtil.pageSize}"+query; 
 }
 </script>
 </#macro>