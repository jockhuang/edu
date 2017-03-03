var chineseallPlayer = function(id){
	this.obj = this.getObj(id);
	this.loaded = false;
}
chineseallPlayer.prototype = {
	getObj : function(id) {
		return !-[1,]? window[id] : document[id];
	},
	loadURL : function(url){
		this.obj.loadsound(url);
		this.loaded = true;
	},
	startPlay : function(){
		if(!this.loaded){
			alert("请先加载影片");
			return;
		}
		this.obj.startPlay();
	},
	stopPlay : function(){
		this.obj.pausePlay();
	},
	onEndPlay : function(fn){
		chineseallPlayer.compltet = fn;
	}
}

