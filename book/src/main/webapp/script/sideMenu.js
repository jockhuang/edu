$('dl.xx').each(function(){
	if($(this).children('dt').attr('rel')=='false')
		$(this).children('dd').hide();
	$(this).children('dt').click(function(){
		$(this).next('dd').toggle($(this).attr('rel'), function(){
			if($(this).prev('dt').attr('rel') == 'true'){
				$(this).prev('dt').attr('rel','false');
				$(this).prev('dt').css('background-position','right 0');
			}else{
				$(this).prev('dt').attr('rel','true');
				$(this).prev('dt').css('background-position','right -36px');
			}
		})
	})
})
