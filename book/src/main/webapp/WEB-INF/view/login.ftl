<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>    
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="/static/script/jquery-1.8.3.min.js"></script>
</head>
<body>
<script language="javascript" type="text/javascript">
<#if returnUrl??>
	window.top.location.href="${returnUrl!'/'}";
<#else>
	window.top.location.reload();
</#if>
</script>
</body>
</html>