/**
 * @author yuyang
 */
//tabit
window.onload = function(){
	var oStar = new Star('vote');
};
function Star(id){
	var _this = this;
	var oBox = document.getElementById(id);
	var i = out = 0;
	this.oLi = oBox.getElementsByTagName('li');
	this.oSpan = oBox.getElementsByTagName('span')[1];
	this.oBj = document.getElementById('s-bg');
	this.apl = ["很不好","不好","一般","好","非常好"];
	this.aMsg = [
				"很不好",
				"不好",
				"一般",
				"好",
				"非常好"
				]
	
	for(i=0;i<this.oLi.length;i++){
		this.oLi[i].index = i
		this.oLi[i].onmouseover = function(){
			for(i=0;i<_this.oLi.length;i++){
				i <= this.index ? _this.oLi[i].className = 'hove' : _this.oLi[i].className = '';
			}
			_this.oBj.style.display = 'block';
			_this.oBj.style.left = this.index * this.offsetWidth + 30 +'px';
			_this.oBj.innerHTML = '<span><b>'+ (this.index + 1) +'</b>分&nbsp;'+ _this.apl[this.index] +'</span><br />'+ _this.aMsg[this.index];
		};
		this.oLi[i].onmouseout = function(){
			for(i=0;i<_this.oLi.length;i++){
				i <= out - 1 ? _this.oLi[i].className = 'hove' : _this.oLi[i].className = '';
			}
			_this.oBj.style.display = 'none';
		};
		
		this.oLi[i].onclick = function(){
			out = this.index + 1;
			//_this.oSpan.innerHTML = '<span class="c"><b>'+ (this.index + 1) +'</b>分&nbsp;'+ _this.apl[this.index] +'</span>&nbsp;'+ _this.aMsg[this.index];
			_this.oSpan.innerHTML = '<span class="c"><b>'+ (this.index + 1) +'</b>分</span>';
		};
	}
};