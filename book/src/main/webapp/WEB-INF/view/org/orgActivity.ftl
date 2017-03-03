<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="http://html.chineseall.cn/static/style/huodong.css" rel="stylesheet" />
<script type="text/javascript" src="http://html.chineseall.cn/static/script/tab.js"></script>
</head>

<body>
<div class="huodong">
	<div class="huodong_topList">
		<div class="bb1">
			<div class="tit1">
				<h2><i class="t_x">新</i>最新活动</h2>
				<ul class="bookTab2">
					<#if newActivitys??>
						<#list newActivitys as activity>
						    <#if activity_index == 0>
								<li id="hd1_btn0" onclick=" tabit('hd1',0,${newActivitys?size},'hot')" class="hot_a" >1</li>
							<#elseif activity_index == 1>
								<li id="hd1_btn1" onclick=" tabit('hd1',1,${newActivitys?size},'hot')">2</li>
							<#elseif activity_index == 2>
								<li id="hd1_btn2" onclick=" tabit('hd1',2,${newActivitys?size},'hot')">3</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<#if newActivitys??>
				<#list newActivitys as activity>
				    <#if activity_index == 0>
						<div class="con" id="hd1_div0">
					<#elseif activity_index == 1>
						<div class="con" id="hd1_div1" style="display:none;">
					<#elseif activity_index == 2>
						<div class="con" id="hd1_div2" style="display:none;">
					</#if>
						<div class="hdList">
							<div class="img"><a href="/activity/index.action?activityId=${activity.activityId}"><img src="http://img3.chineseall.cn/${activity.logo!''}" /></a></div>
							<h3><a href="/activity/index.action?activityId=${activity.activityId}">${activity.activityName!''}</a></h3>
							<div class="time">
							${activity.startDate?string("yyyy年MM月dd日 ")}
							—${activity.finishDate?string("yyyy年MM月dd日 ")}
							</div>
							<div class="xx">
								<span><em>类型：</em>
									<#if activity.activityType == 1>
									读书活动
									<#elseif activity.activityType == 2>
									读书征文
									<#elseif activity.activityType == 3>
									摄影比赛
									<#elseif activity.activityType == 4>
									绘画比赛
									</#if>
								</span>
								<span><em>作品：</em>${activity.worksCount} 份</span>
							</div>
							<div class="text">
								<p>活动介绍：${activity.description}</p>
							</div>
							<div class="btn"><a href="/activity/index.action?activityId=${activity.activityId}">提交作品</a></div>
							<ul>
								<li class="b1"><a href="/activity/book.action?activityId=${activity.activityId}&currentPage=1">(${activity.acBookCount})</a></li>
								<li class="b2"><a href="/activity/works.action?activityId=${activity.activityId}&orgTreeId=${orgTreeId}">(${activity.worksCount})</a></li>
								<li class="b3"><a href="/activity/joinusers.action?activityId=${activity.activityId}&currentPage=1">(${activity.joinUserCount})</a></li>
							</ul>
						</div>
					</div>
				</#list>
			</#if>
		</div>
		<div class="bb1">
			<div class="tit1">
				<h2><i class="t_r">热</i>最热门活动</h2>
				<ul class="bookTab2">
					<#if hotActivitys??>
						<#list hotActivitys as activity>
						    <#if activity_index == 0>
								<li id="hd2_btn0" onclick=" tabit('hd2',0,${hotActivitys?size},'hot')" class="hot_a" >1</li>
							<#elseif activity_index == 1>
								<li id="hd2_btn1" onclick=" tabit('hd2',1,${hotActivitys?size},'hot')">2</li>
							<#elseif activity_index == 2>
								<li id="hd2_btn2" onclick=" tabit('hd2',2,${hotActivitys?size},'hot')">3</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<#if hotActivitys??>
				<#list hotActivitys as activity>
				    <#if activity_index == 0>
						<div class="con" id="hd2_div0">
					<#elseif activity_index == 1>
						<div class="con" id="hd2_div1" style="display:none;">
					<#elseif activity_index == 2>
						<div class="con" id="hd2_div2" style="display:none;">
					</#if>
						<div class="hdList">
							<div class="img"><a href="/activity/index.action?activityId=${activity.activityId}"><img src="http://img3.chineseall.cn/${activity.logo!''}" /></a></div>
							<h3><a href="/activity/index.action?activityId=${activity.activityId}">${activity.activityName!''}</a></h3>
							<div class="time">
							${activity.startDate?string("yyyy年MM月dd日 ")}
							—${activity.finishDate?string("yyyy年MM月dd日 ")}
							</div>
							<div class="xx">
								<span><em>类型：</em>
									<#if activity.activityType == 1>
									读书活动
									<#elseif activity.activityType == 2>
									读书征文
									<#elseif activity.activityType == 3>
									摄影比赛
									<#elseif activity.activityType == 4>
									绘画比赛
									</#if>
								</span>
								<span><em>作品：</em>${activity.worksCount} 份</span>
							</div>
							<div class="text">
								<p>活动介绍：${activity.description}</p>
							</div>
							<div class="btn"><a href="/activity/index.action?activityId=${activity.activityId}">提交作品</a></div>
							<ul>
								<li class="b1"><a href="/activity/book.action?activityId=${activity.activityId}&currentPage=1">(${activity.acBookCount})</a></li>
								<li class="b2"><a href="/activity/works.action?activityId=${activity.activityId}&orgTreeId=${orgTreeId}">(${activity.worksCount})</a></li>
								<li class="b3"><a href="/activity/joinusers.action?activityId=${activity.activityId}&currentPage=1">(${activity.joinUserCount})</a></li>
							</ul>
						</div>
					</div>
				</#list>
			</#if>
		</div>
		<div class="bb1">
			<div class="tit1">
				<h2>经典回顾</h2>
				<ul class="bookTab2">
					<#if finishActivitys??>
						<#list finishActivitys as activity>
						    <#if activity_index == 0>
								<li id="hd3_btn0" onclick=" tabit('hd3',0,${finishActivitys?size},'hot')" class="hot_a" >1</li>
							<#elseif activity_index == 1>
								<li id="hd3_btn1" onclick=" tabit('hd3',1,${finishActivitys?size},'hot')">2</li>
							<#elseif activity_index == 2>
								<li id="hd3_btn2" onclick=" tabit('hd3',2,${finishActivitys?size},'hot')">3</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<#if finishActivitys??>
				<#list finishActivitys as activity>
				    <#if activity_index == 0>
						<div class="con" id="hd3_div0">
					<#elseif activity_index == 1>
						<div class="con" id="hd3_div1" style="display:none;">
					<#elseif activity_index == 2>
						<div class="con" id="hd3_div2" style="display:none;">
					</#if>
						<div class="hdList">
							<div class="img"><a href="/activity/index.action?activityId=${activity.activityId}"><img src="http://img3.chineseall.cn/${activity.logo!''}" /></a></div>
							<h3><a href="/activity/index.action?activityId=${activity.activityId}">${activity.activityName!''}</a></h3>
							<div class="time">
							${activity.startDate?string("yyyy年MM月dd日 ")}
							—${activity.finishDate?string("yyyy年MM月dd日 ")}
							</div>
							<div class="xx">
								<span><em>类型：</em>
									<#if activity.activityType == 1>
									读书活动
									<#elseif activity.activityType == 2>
									读书征文
									<#elseif activity.activityType == 3>
									摄影比赛
									<#elseif activity.activityType == 4>
									绘画比赛
									</#if>
								</span>
								<span><em>作品：</em>${activity.worksCount} 份</span>
							</div>
							<div class="text">
								<p>活动介绍：213123${activity.description}</p>
							</div>
							<div class="btn"><a href="/activity/index.action?activityId=${activity.activityId}">点击查看</a></div>
							<ul>
								<li class="b1"><a href="/activity/book.action?activityId=${activity.activityId}&currentPage=1">(${activity.acBookCount})</a></li>
								<li class="b2"><a href="/activity/works.action?activityId=${activity.activityId}&orgTreeId=${orgTreeId}">(${activity.worksCount})</a></li>
								<li class="b3"><a href="/activity/joinusers.action?activityId=${activity.activityId}&currentPage=1">(${activity.joinUserCount})</a></li>
							</ul>
						</div>
					</div>
				</#list>
			</#if>
		</div>
	</div>
	<div class="bb1 mtb10 huodongMeunTitle">
		<h2><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=0">最新作品</a></h2>
		<ul>
			<li class="s1"><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=1">所有征文活动</a></li>
			<li class="s2"><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=3">所有摄影活动</a></li>
			<li class="s3"><a href="/org/activity.action?orgTreeId=${orgTreeId}&activityType=4">所有绘画活动</a></li>
		</ul>
	</div>
	<div class="huodong_bottomList">
		<#if works??>
			<#list works as work>
				<div class="bb1">
					<div class="huodong_list_t">
						<a href="/user/${work.userId}/i.action"><img class="img" src="http://img3.chineseall.cn/${work.userImgUrl!''}" /></a>
						<h3>
						  <a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">${work.worksName}</a>
						</h3>
						<#if work.activityType == 1>
							<div class="p">
							  <#if work.worksContent ? exists>
							  	<a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">${work.worksContent}</a>
						      </#if>
							</div>
						<#elseif work.activityType == 2>
							<div class="p">
							  <#if work.worksContent ? exists>
						       	<a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">${work.worksContent}</a>
						      </#if>
							</div>
						<#elseif work.activityType == 3>
							<div class="pimg">
								<#if work.smallPictureUrl ? exists>
							      <a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">
									<img src="http://img3.chineseall.cn/${work.smallPictureUrl}" />
								  </a>
							    </#if>
							</div>
						<#elseif work.activityType == 4>
							<div class="pimg">
								<#if work.smallPictureUrl ? exists>
							      <a href="/activity/work.action?activityId=${work.activityId}&worksId=${work.worksId}">
									<img src="http://img3.chineseall.cn/${work.smallPictureUrl}" />
								  </a>
							    </#if>
							</div>
						</#if>
						<div class="l">
							<ul>
								<li class="b3">
									<!-- Baidu Button BEGIN -->
									<div id="bdshare" class="bdshare_b"></div>
									<script type="text/javascript" id="bdshare_js" data="type=button&amp;uid=972509" ></script>
									<script type="text/javascript" id="bdshell_js"></script>
									<script type="text/javascript">
										document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
									</script>
									<!-- Baidu Button END -->
								</li>
								<li class="b2" title="评论">
									<#if work.reviewCount ? exists>
								     	${work.reviewCount}
								    </#if>
								</li>
								<li class="b1" title="被赞">
									<#if work.flowersCount ? exists>
								     	${work.flowersCount}
								    </#if>
								</li>
							</ul>
						</div>
					</div>
					<div class="huodong_list_b">
							<#if work.activityType == 1>
								<div class="hdTextBg b1">
									征文
								</div>
							<#elseif work.activityType == 2>
								<div class="hdTextBg b1">
									征文
								</div>
							<#elseif work.activityType == 3>
								<div class="hdTextBg b2">
									摄影
								</div>
							<#elseif work.activityType == 4>
								<div class="hdTextBg b3">
									绘画
								</div>
							</#if>
						<a href="/activity/index.action?activityId=${work.activityId}">${work.activityName}</a>
					</div>
				</div>
			</#list>
		</#if>
	</div>
</div>
</body>
</html>
