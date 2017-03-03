<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>
	首页
</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<style type="text/css">
.class0{
#background-color:red;
}

.class1{
#background-color:green;
}

</style>
</head>
<body>
	<table border=0>
	<form action="/searchBook.action" method="get">
	<input type="hidden" name="pageSize" value="${pageSize!10}" />
	<tr>
		<td>
			<input type="text" name="keyWords" value="${keyWords!''}" > <input type="submit" value="搜索" />
		</td>
	</tr>
	</form>
	<#list docs as doc>
		<tr><td>${doc.id}||<a href="http://192.168.69.107:8080/book/listChapter.action?id=${doc.id}">${doc.name}</a>||${doc.bookNumber!''}</td></tr>
		<tr><td>${doc.intro!'&nbsp;&nbsp;'}</td></tr>	
		<tr><td><hr/></td></tr>	
	</#list>
	<tr><td colspan="2">(总共${docNums}条，总共${totalPages}页，当前第${currentPage}页)
	<a href="/searchBook.action?currentPage=1&keyWords=${keyWords}&pageSize=${pageSize}">首页</a>
	&nbsp;&nbsp;
	<a href="/searchBook.action?currentPage=${currentPage-1}&keyWords=${keyWords}&pageSize=${pageSize}">上一页</a>
	&nbsp;&nbsp;
	<a href="/searchBook.action?currentPage=<#if currentPage<totalPages>${currentPage+1}<#else>${currentPage}</#if>&keyWords=${keyWords}&pageSize=${pageSize}">下一页</a>
	&nbsp;&nbsp;
	<a href="/searchBook.action?currentPage=${totalPages}&keyWords=${keyWords}&pageSize=${pageSize}">尾页</a></td></tr>		
	</table>
</body>
</html>