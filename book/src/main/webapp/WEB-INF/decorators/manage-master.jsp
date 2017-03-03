<%@ taglib prefix="decorator"	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="http://html.chineseall.cn/static/style/manage/skin/layout.css" rel="stylesheet" />
<title>书香中国</title>
<script type="text/javascript" src="http://html.chineseall.cn/static/script/jquery.min.js"></script>
<decorator:head />
</head>
<body>
	<div class="Mtop">
		<div class="layout">
			<div class="select">
				<span id="userInfo" style="cursor:pointer;color:white;"></span><span style="cursor:pointer;color:white;margin-left:20px;" id="logoutHref">退出</span>
				<br/>
				<span>切换管理后台：</span> 
				<select id="orgTreeIncharge">
					<c:if test="${inchargeTreeList!=null}" var="condition" scope="request">
					<c:forEach var="item" items="${inchargeTreeList}" varStatus="status">
					<c:set var="viewName" value="${item.viewName}(${item.nodeName})"></c:set>
					<c:choose>
					    <c:when test="${viewName.length()>12}">
							<c:set var="viewName" value="${viewName.substring(0, 12)}"></c:set>
					    </c:when>
						<c:otherwise>
					      <c:set var="viewName" value="${viewName}"></c:set>
					     </c:otherwise>
				    </c:choose>
					<option domain="<c:out value='${item.domainName}'></c:out>" nodeDomain="<c:out value='${item.nodeDomainName}'></c:out>" value="<c:out value='${item.id}'></c:out>"  <c:if test="${currentOrgTree.id==item.id}">selected</c:if>>
					<c:out value="${viewName}" />
					</option>
					</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="title">
		    	<c:set var="viewName" value="${currentOrgTree.viewName}(${currentOrgTree.nodeName})"></c:set>
				<c:choose>
				    <c:when test="${viewName.length()>12}">
						<c:set var="viewName" value="${viewName.substring(0, 12)}"></c:set>
				    </c:when>
					<c:otherwise>
				      <c:set var="viewName" value="${viewName}"></c:set>
				     </c:otherwise>
			    </c:choose>
				<c:if test="${currentOrgTree!=null}" var="condition" scope="request">
				<c:choose>
				    <c:when test="${requestScope.currentOrgTree.domainName!=null}">
				       <a href="http://<c:out value='${currentOrgTree.domainName}' ></c:out>/org/index.action" style="color:white;">
				    </c:when>
				    <c:otherwise>
						<a href="http://<c:out value='${currentOrgTree.nodeDomainName}'></c:out>/org/index.action?orgTreeId=<c:out value='${currentOrgTree.id}'></c:out>" style="color:white;">
					</c:otherwise>
				 </c:choose>
				 <c:out value="${viewName}" />
				</a>
				--
				</c:if>
				管理后台
			</div>
		</div>
	</div>
	<div class="layout">
		<div id="Mnav">
			<!--需要程序输出class "hot"-->
			<dl>
				<dt>
					<span class="open"></span>基本信息
				</dt>
				<dd>
					<!--需要程序输出class "hot"-->
					<a href="/manage/tree/selectTree.action">切换机构</a>
					<a href="/manage/tree/showUpdate.action">机构信息</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>页面管理
				</dt>
				<dd>
					<a href="/manage/tree/showStyle.action">页面风格</a>
					<a href="/manage/tree/showNav.action">导航</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>内容管理
				</dt>
				<dd>
					<a href="/manage/content/listNews.action">新闻管理</a>
					<a href="/manage/content/listBookRecommend.action">图书推荐</a>
					<a href="/manage/content/listActivityRecommend.action">活动推荐</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>图书管理
				</dt>
				<dd>
					<a href="/manage/orgbook/listOrgtreeBooks.action">本机构图书</a>
					<a href="/manage/orgbook/listOrgChooseBooks.action">选书中心</a>
					<a href="/manage/bookcomment/listOrgBookComment.action">书评管理</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>活动管理
				</dt>
				<dd>
					<a href="/manage/activity.action">创建活动</a>
				</dd>
				<dd>
					<a href="/manage/activity/list.action">活动列表</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>用户管理
				</dt>
				<dd>
					<a href="/manage/user/joinSettings.action">加入设置</a>
					<a href="/manage/user/listNormalUser.action">正常用户</a>
					<a href="/manage/user/listAuditingUser.action">用户审核</a>
				</dd>
			</dl>
			<!--dl>
				<dt>
					<span class="open"></span>明星机构
				</dt>
				<dd>
					<a href="?9879">内容维护</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<span class="open"></span>明星用户
				</dt>
				<dd>
					<a href="?kjl">内容维护</a>
				</dd>
			</dl-->
			<dl>
				<dt>
					<span class="open"></span>数据中心
				</dt>
				<dd>
					<!--a href="/manage/data/userData.action">用户</a-->
					<a href="/manage/data/bookData.action">图书</a>
				</dd>
			</dl>
			<c:if test="${isOrgManager==0}">
			<dl>
				<dt>
					<span class="open"></span>管理员设置
				</dt>
				<dd>
					<a href="/manage/user/listManager.action">管理员列表</a>
					<a href="/manage/user/showADManager.action">添加管理员</a>
				</dd>
			</dl>
			</c:if>
		</div>
		<div class="Mcont">
			<decorator:body />
		</div>
	</div>
	<div class="footer">
		<div class="layout">
			<a href="/footer/about.html">关于我们</a> | <a
				href="/footer/copyright.html">版权声明</a> | <a
				href="/footer/lineService.html">在线客服</a> | <a
				href="/footer/help.html">常见问题</a> | <a href="/footer/readme.html">积分说明</a>
			| <a href="/footer/partnership.html">商务合作</a> | <a
				href="/footer/contact.html">联系我们</a>
		</div>
		<div class="layout">
			书香中国为中文在线旗下网站 未经许可严禁转载 <br />
			 Copyright © 2010 中文在线 版权所有 
			增值电信业务经营许可证编号：沪B2-20090110
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#orgTreeIncharge").change(function(){
				var selectedOption=$(this).find("option:selected");
				var domainName = $(selectedOption).attr("domain");
				var nodeDomainName =  $(selectedOption).attr("nodeDomain");
				var location=window.location.href;
				var currentHost = window.location.host;
				if(domainName){
					location = location.replace(currentHost, domainName);
					window.location.href=location;
				}else{
					domainName=nodeDomainName;					
				}
				if(domainName){
					location = location.replace(currentHost, domainName);
					if(location.indexOf("orgTreeId")!=-1){
						var reg=new RegExp("orgTreeId=\\d*","gmi");
						location = location.replace(reg,"");
						var index = location.indexOf("?");
						var parameters = location.substring(index+1);
						if(index!=-1 && parameters){
							window.location.href="http://"+domainName+"/manage/tree/selectTree.action?orgTreeId="+$(this).val();
						}else if(index!=-1){
							window.location.href=location+"orgTreeId="+$(this).val();
						}else{
							window.location.href=location+"?orgTreeId="+$(this).val();
						}
					}else{
						var index = location.indexOf("?");
						var parameters = location.substring(index+1);
						if(index!=-1 && parameters){
							window.location.href="http://"+domainName+"/manage/tree/selectTree.action?orgTreeId="+$(this).val();
						}else if(index!=-1){
							window.location.href=location+"orgTreeId="+$(this).val();
						}else{
							window.location.href=location+"?orgTreeId="+$(this).val();
						}
					}
				}
			});
		
			$("#logoutHref").click(function(){
				$.ajax({
	                url: "/logout.action",
	                async: false,
	                cache: false,
	                type: "post",
	                success: function (data) {
	                   window.location.reload();
	                }
	            });
			});
		});
	    $(document).ready(function(){
			$.ajax({
                url: "/getLoginInfo.action",
                async: true,
                cache: false,
                type: "post",
                success: function (data) {
                   if(data["result"]==1){
                   		$("#userInfo").html("欢迎你,"+data["displayName"]+"&nbsp;&nbsp;");
                   }
                }
            });
		});
	</script>
</body>
</html>