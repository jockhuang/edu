<html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
</head>
<body>
正在去往支付页面..............
<form id ="goToPayForm" action="http://pay.eduyun.cn/paymentservice/paymentrequest" method="get">
<input type="hidden" name="appid" value="${payment.appid!''}" />
<input type="hidden" name="callbackUrl" value="${payment.callbackUrl!''}" /><br/> 
<input type="hidden" name="notifyUrl" value="${payment.notifyUrl!''}" /> <br/>
<input type="hidden" name="providerId" value="${payment.providerId!''}" /> <br/>
<input type="hidden" name="requestId" value="${payment.requestId!''}" /> <br/>
<input type="hidden" name="amount" value="${payment.amount!''}" /> <br/>
<input type="hidden" name="orderId" value="${payment.orderId!''}" /> <br/>
<input type="hidden" name="orderDate" value="${payment.orderDate!''}" /> <br/>
<input type="hidden" name="merAcDate" value="${payment.merAcDate!''}" /> <br/>
<input type="hidden" name="productDesc" value="${payment.productDesc!''}" /> <br/>
<input type="hidden" name="productId" value="${payment.productId!''}" /> <br/>
<input type="hidden" name="productName" value="${payment.productName!''}" /> <br/>
<input type="hidden" name="productNum" value="${payment.productNum!''}" /> <br/>
<input type="hidden" name="usercode" value="${payment.usercode!''}" /> <br/>
<input type="hidden" name="hmac" value="${payment.hmac!''}" /><br/>    
</form>
<script type="text/javascript">
$(document).ready(function(){
    var appid = "${payment.appid!''}";
    var callbackUrl = "${payment.callbackUrl!''}";
    var notifyUrl = "${payment.notifyUrl!''}";
	var providerId = "${payment.providerId!''}";
	var requestId = "${payment.requestId!''}";
	var amount = "${payment.amount!''}";
	var orderId = "${payment.orderId!''}";
	var orderDate = "${payment.orderDate!''}";
	var merAcDate = "${payment.merAcDate!''}";
	var productDesc = "${payment.productDesc!''}";
	var productId = "${payment.productId!''}";
	var productName = "${payment.productName!''}";
	var productNum = "${payment.productNum!''}";
	var usercode = "${payment.usercode!''}";
	var hmac ="${payment.hmac!''}";
	$("#goToPayForm").submit();
});
</script>
</body>
</html>