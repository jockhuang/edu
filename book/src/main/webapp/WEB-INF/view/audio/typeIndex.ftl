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
		<h2>听书分类</h2>
		<!--
		<ul>
			<li><a href="#">中图法分类</a>|</li>
			<li class="on"><a href="#">自定义分类</a></li>
		</ul>
		-->
	</div>
	<div class="fenlei_list" id="fenlei_list">
		<!-- starts_with  -->
		<#list classes as c>
		<div class="fenlei_li sideMenu">
			<dl>
				<dt>${c.classInfo.className} ......</dt>
				<dd>
					<ul>
					<#list c.childTypes as d>
					<#assign type = d.typeInfo >
					<#if (type.typeName?length < 6)>
						<li><a href="room.action?typeId=${type.typeId}&classId=${c.classInfo.classId}&cname=${c.classInfo.className}&orgTreeId=${orgTreeId}">${type.typeName} <em>(${d.bookCount})</em></a></li>
						<#else>
						<li><a href="room.action?typeId=${type.typeId}&classId=${c.classInfo.classId}&cname=${c.classInfo.className}&orgTreeId=${orgTreeId}" title="${type.selfSort.name}" >${type.name?substring(0 , 5)}... <em>(${d.bookCount})</em></a></li>
					</#if>
					</#list>
					</ul>
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
