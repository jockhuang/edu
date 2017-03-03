/**
 * @author yuyang
 */
$(function(){
$("#search_type span").click(function(){           
	var obj=$(this).next();
	if(obj.css("display")=="none"){
		obj.show();
	}else{
		obj.hide();
	}
});
$("#search_type li").click(function(){
	$("#searchType").val($(this).attr("value"));
	$(this).parent().prev().text($(this).text());
	$(this).parent().hide();
});
});

