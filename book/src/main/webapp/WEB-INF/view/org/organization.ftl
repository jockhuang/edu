<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.pagination.js"></script>
</head>
<body>
<div class="huodong">
	<div class="bb1 huodong_left">
		<div class="path">
			<h2><span>${viewName?default('书香中国')}</span><em> — 下属机构<b>${orgcount?default(0)}</b>个</em></h2>
			<div class="path_px"><a rel="child">直属机构</a> / <a rel="all">全部机构</a></div>
		</div>
		<div class="jigou">
		    <#list pageUtil.items as orgs>
			<div class="jigouList">
				<div class="img">
				<a href="http://${orgs.domainName?default('edu.chineseall.cn')}/org/index.action?orgTreeId=${orgs.orgTreeId}"><img src="http://img3.chineseall.cn${orgs.orgLogo}" width="100" height="100"/></a>
				<span>
				<a href="http://${orgs.domainName?default('edu.chineseall.cn')}/org/index.action?orgTreeId=${orgs.orgTreeId}">
				<#if (orgs.viewName?length > 6) >
					${orgs.viewName?substring(0 , 6)}...
					<#else>
					${orgs.viewName}	
				</#if>
				</a></span></div>
				<#if orgs.orgSta??>
				<#assign orgSta = orgs.orgSta >
				<div class="indexMenuList">
					<ul>
						<li class="b1">访问人次:<em>${orgSta.accessCount?default(0)}</em></li>
						<li class="b2">个人书房:<em>${orgSta.userCount?default(0)}</em></li>
						<li class="b3">下属组织:<em>${orgSta.orgCount?default(0)}</em></li>
						<li class="b4">机构活动:<em>${orgSta.activityCount?default(0)}</em></li>
						<li class="b5">电子图书:<em>${orgSta.bookCount?default(0)}</em></li>
					</ul>
				</div>
				</#if>
			</div>
			</#list>
			
		</div>
		<div style="height:16px;margin:15px"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></div>
	</div>
	<form id="listForm" action="organization.action" method="get" >
			<input type="hidden" name="orgTreeId" value="${orgTreeId}" />
			<input type="hidden" name="order" value="${order?default('all')}" />
			<input type="hidden" name="currentPage" id="currentPage" value="${currentPage?default(1)}" />
	</form>
	<div class="w310 right">
		<div class="bb1 rbox1">
			<div class="tit">
				<ul>
					<li id="rtab1_btn0" onclick=" tabit('rtab1',0,2,'hot')" class="hot_a">新闻</li>
				</ul>
			</div>
			<div class="con">
				<ul class="textList" id="rtab1_div0">
				    <#if newsList??>
					<#list newsList as news>
					<li><em>[
					<#if (news.linkUrl?length > 4) >
							<a href="${news.linkUrl}" target="_blank">${news.orgNewsTitle}</a>
							<#else>
							<a href="detail.action?orgTreeId=${orgTreeId}&id=${news.orgNewsId}">${news.orgViewName}</a>	
					</#if>
					]</em>
					<#if (news.linkUrl?length > 4) >
							<a href="${news.linkUrl}" target="_blank">${news.orgNewsTitle}</a>
							<#else>
							<a href="detail.action?orgTreeId=${orgTreeId}&id=${news.orgNewsId}">${news.orgNewsTitle}</a>	
					</#if>
					</li>
					</#list>
					</#if>
				</ul>
			</div>
		</div>
		<div class="bb1 mt10 rbox2">
			<div class="tit1">
				<h2>活动进行时</h2>
				<span><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=0">所有活动&raquo;</a></span>
			</div>
			<#if hotActivitys??>
			<div class="con">
			    <#if (hotActivitys?size > 0) >
			    <#assign top = hotActivitys[0] >
				<div class="hdList">
					<div class="img"><a href="/activity/index.action?activityId=${top.activityId}"><img src="http://img3.chineseall.cn/${top.logo!''}" /></a></div>
					<h3><a href="/activity/index.action?activityId=${top.activityId}">${top.activityName}</a></h3>
					<div class="time">
                    ${top.startDate?string("yyyy年MM月dd日 ")}
					—${top.finishDate?string("yyyy年MM月dd日 ")}
                    </div>
					<div class="xx">
						<span><em>类型：</em>
						<#if top.activityType == 1>
						读书活动
						<#elseif top.activityType == 2>
						读书征文
						<#elseif top.activityType == 3>
						摄影比赛
						<#elseif top.activityType == 4>
						绘画比赛
						</#if>
						</span>
						<span><em>作品：</em>${top.worksCount} 份</span>
					</div>
					<div class="text">
						<p>活动介绍：${top.description}</p>
					</div>
					<div class="btn"><a href="/activity/index.action?activityId=${top.activityId}">提交作品</a></div>
					<ul>
						<li class="b1">(${top.acBookCount})</li>
						<li class="b2">(${top.worksCount})</li>
						<li class="b3">(${top.joinUserCount})</li>
					</ul>
				</div>
				</#if>
				<#if (hotActivitys?size > 1) >
			    <#assign top1 = hotActivitys[1] >
				<div class="hdList">
					<div class="img"><a href="/activity/index.action?activityId=${top1.activityId}"><img src="http://img3.chineseall.cn/${top1.logo!''}" /></a></div>
					<h3><a href="/activity/index.action?activityId=${top1.activityId}">${top1.activityName}</a></h3>
					<div class="time">
					${top1.startDate?string("yyyy年MM月dd日 ")}
					—${top1.finishDate?string("yyyy年MM月dd日 ")}
					</div>
					<div class="xx">
						<span><em>类型：</em>
						<#if top1.activityType == 1>
						读书活动
						<#elseif top1.activityType == 2>
						读书征文
						<#elseif top1.activityType == 3>
						摄影比赛
						<#elseif top1.activityType == 4>
						绘画比赛
						</#if>
						</span>
						<span><em>作品：</em>${top1.worksCount} 份</span>
					</div>
					<div class="text">
						<p>活动介绍：${top1.description}</p>
					</div>
					<div class="btn"><a href="/activity/index.action?activityId=${top1.activityId}">提交作品</a></div>
					<ul>
						<li class="b1">(${top1.acBookCount})</li>
						<li class="b2">(${top1.worksCount})</li>
						<li class="b3">(${top1.joinUserCount})</li>
					</ul>
				</div>
				</#if>
			</div>
			</#if>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(
	function(){
		var  orderByBtn = $('.path_px a'),order =$("input[name='order']") ;
		orderByBtn.css('cursor' , 'pointer').bind('click' , function(){
			order.val(this.rel);
			go(1);
		});
		orderByBtn.filter("[rel='" + order.val() + "']").addClass('on');
	}
)
function go(page_index){
    $('#currentPage').val(page_index);
	$('#listForm').submit();
	return false;
}
</script>
</body>
</html>