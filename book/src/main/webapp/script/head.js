//我的书房菜单
var myroom = document.getElementById('myroom'),myroomtag = document.getElementById('myroomtag'),myroomtemp;
if(myroom){
myroom.onmouseover = function(){
	this.style.cssText = 'color:red;';
	myroomtag.style.display = 'block';
	myroomtag.style.height = (myroomtag.getElementsByTagName('div')[1].clientHeight + 20) + 'px';
	clearTimeout(myroomtemp);
}
myroom.onmouseout = myroomout;
myroomtag.onmouseout = myroomout;
myroomtag.onclick = myroomout;
myroomtag.onmousemove = function(){
	this.style.display="block";
	clearTimeout(myroomtemp);
	myroom.style.cssText = 'color:red;';
}
}
function myroomout(){
	myroomtemp = setTimeout(function(){
		myroomtag.style.display = 'none';
		myroom.style.cssText = '';
	},600);
}
