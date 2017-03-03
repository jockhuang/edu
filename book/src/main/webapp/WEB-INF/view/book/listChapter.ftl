<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>
	列表页
</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
</head>
<body>
	
	<hr>
	<#list list as article>
		<a href="/book/readChapter.action?id=${article.id}">${article.name}</a><p>
	</#list>
	
	<p>
</body>
</html>