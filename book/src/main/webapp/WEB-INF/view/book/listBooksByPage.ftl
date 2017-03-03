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
	<#list pageUtil.items as item>
		${item.name}<br/>
	</#list>	
	<p>
	<tr>
       <@c.pageLine pageUtil=pageUtil queryCondition=queryCondition />
    </tr>
	</p>
</body>
</html>