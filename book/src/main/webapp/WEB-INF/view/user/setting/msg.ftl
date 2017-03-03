<#if (msg??)>
<div id="remindDiv" style="margin : 10px;padding : 10px;border: 1px solid green;color: green;display: none;background-color: #F5FCF1;width: 500px;"  >${msg}</div>
<script type="text/javascript">
	setTimeout(function(){
		$('#remindDiv').slideDown("slow" , function(){
			setTimeout(function(){
				$('#remindDiv').slideUp("slow");
			} , 3000);
		});
	} , 300);
</script>
<#elseif (emsg??)>
<div id="remindDiv" style="margin : 10px;padding : 10px;border: 1px solid #EB4848;color: #EB4848;display: none;background-color: #F5FCF1;width: 500px;"  >${emsg}</div>
<script type="text/javascript">
	setTimeout(function(){
		$('#remindDiv').slideDown("slow" , function(){
			setTimeout(function(){
				$('#remindDiv').slideUp("slow");
			} , 3000);
		});
	} , 300);
</script>
</#if>		
