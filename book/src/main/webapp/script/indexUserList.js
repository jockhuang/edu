/**
 * @author yuyang
 */
var menuTag = document.getElementById('indexUserList');
var menudl = menuTag.getElementsByTagName('dl');
var menudt = menuTag.getElementsByTagName('dt');
var menudd = menuTag.getElementsByTagName('dd');
for(var i=0,j;j=menudl[i++];){
	j.data = i-1;
	j.onmouseover = function(){
		for(var a=0,b;b=menudd[a++];) b.style.display = 'none';
		menudd[this.data].style.display = 'block';
		menudl[this.data].className = 'd';
	}
	j.onmouseout = function(){
		for(var a=0,b;b=menudd[a++];) {
		menudd[this.data].style.display = 'none';
		menudl[this.data].className = '';
		}
	}
}
