<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/yuelanshi.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>

<body>
<div class="fenlei">
	<div class="bb1 fenlei_tit">
		<h2>图书分类</h2>
		<ul>
			<li class="on"><a>中图法分类</a>|</li>
			<li ><a href="selfsortindex.action">自定义分类</a></li>
		</ul>
	</div>
	<div class="fenlei_list" id="fenlei_list">
		<!-- starts_with  -->
		<#list listSort as sort>
		<div class="fenlei_li sideMenu">
			<dl>
				<#if (sort.name?length < 15)>
				<dt>${sort.name} ......</dt>
				<#else>
				<dt title="${sort.name}" >${sort.name?substring(0 , 15)} ......</dt>
				</#if>
				<dd>
					<#if (childSort[sort.id]?? && childSort[sort.id]?size > 0) >
					<ul>
					<#list childSort[sort.id] as childSort>
					<#if (childSort.name?length < 6)>
						<li><a href="/search/book.action?c1=${childSort.id}">${childSort.name} <em>(${childSort.count})</em></a></li>
						<#else>
						<li><a href="/search/book.action?c1=${childSort.id}" title="${childSort.name}" >${childSort.name?substring(0 , 5)}... <em>(${childSort.count})</em></a></li>
					</#if>
					</#list>
					</ul>
					</#if>
				</dd>
			</dl>
		</div>
		</#list>
	</div>
</div>
<script type="text/javascript">
function Waterfall(param){
    this.id = typeof param.container == 'string' ? document.getElementById(param.container) : param.container;
    this.colWidth = param.colWidth;
    this.colCount = param.colCount || 4;
    this.cls = param.cls && param.cls != '' ? param.cls : 'fenlei_li';
    this.init();
}
Waterfall.prototype = {
    getByClass:function(cls,p){
        var arr = [],reg = new RegExp("(^|\\s+)" + cls + "(\\s+|$)","g");
        var nodes = p.getElementsByTagName("*"),len = nodes.length;
        for(var i = 0; i < len; i++){
            if(reg.test(nodes[i].className)){
                arr.push(nodes[i]);
                reg.lastIndex = 0;
            }
        }
        return arr;
    },
    maxArr:function(arr){
        var len = arr.length,temp = arr[0];
        for(var ii= 1; ii < len; ii++){
            if(temp < arr[ii]){
                temp = arr[ii];
            }
        }
        return temp;
    },
    getMar:function(node){
        var dis = 0;
        if(node.currentStyle){
            dis = parseInt(node.currentStyle.marginBottom);
        }else if(document.defaultView){
            dis = parseInt(document.defaultView.getComputedStyle(node,null).marginBottom);
        }
        return dis;
    },
    getMinCol:function(arr){
        var ca = arr,cl = ca.length,temp = ca[0],minc = 0;
        for(var ci = 0; ci < cl; ci++){
            if(temp > ca[ci]){
                temp = ca[ci];
                minc = ci;
            }
        }
        return minc;
    },
    init:function(){
        var _this = this;
        var col = [],//列高
            iArr = [];//索引
        var nodes = _this.getByClass(_this.cls,_this.id),len = nodes.length;
        for(var i = 0; i < _this.colCount; i++){
            col[i] = 0;
        }
        for(var i = 0; i < len; i++){
            nodes[i].h = nodes[i].offsetHeight + _this.getMar(nodes[i]);
            iArr[i] = i;
        }
        for(var i = 0; i < len; i++){
            var ming = _this.getMinCol(col);
            nodes[i].style.left = ming * _this.colWidth + "px";
            nodes[i].style.top = col[ming] + "px";
            col[ming] += nodes[i].h;
        }
        _this.id.style.height = _this.maxArr(col) + "px";
    }
};
new Waterfall({
    "container":"fenlei_list",
    "colWidth":320,
    "colCount":3
});
</script>
</body>
</html>
