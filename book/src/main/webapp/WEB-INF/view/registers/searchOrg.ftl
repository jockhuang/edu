<script src="http://html.chineseall.cn/static/script/jquery-1.9.1.js"></script>
<link href="http://html.chineseall.cn/static/style/manage/skin/layout.css" rel="stylesheet" />
<style>
body {
    background: none;
}
</style>
<form action="/searchOrg.action" method="POST">
<table cellpadding="5" cellspacing="2" width="100%" bgcolor="#ffffff">
	<tr>
		<th align="left">选择您的所在地</th>
		<th align="left">机构搜索</th>
	</tr>
	<tr>
		<td>
			<select class="select" id="pro">
				<option value="0">选择省</option>
			</select>
			<select class="select" id="cit">
				<option value="0">选择市</option>
			</select>
			<select class="select" id="cou" name="regionId">
				<option value="0">选择区</option>
			</select>
		</td>
		<td>
			<input type="text" id="orgName" name="orgName" value="${orgName!''}"/> 
			<input type="submit" value="搜索"/>
		</td>
	</tr>
</table>
</form>
<table class="table" cellpadding="5" cellspacing="2" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<th align="left">机构名称</th>
		<th align="left">联系人</th>
		<th align="left">创建时间</th>
		<th align="left">机构人数</th>
		<th align="left">&nbsp;</th>
	</tr>
	<#list pageUtil.items as item>
	<tr>
		<td>${item.viewName!''}</td>
		<td>${item.linkman!''}</td>
		<td><#if item.creationTime??>${item.creationTime?number_to_date}</#if></td>
		<td>${item.total!0}</td>
		<td>
			<input type="button" onClick="window.parent.selectTree(${item.id},'${item.viewName!''}')" value="申请注册"/>
		</td>
	</tr>
	</#list>
	<tr><td colspan="5"><@c.pageLine pageUtil=pageUtil queryCondition=queryCondition /></td></tr>
</table>
<script>
	$(function() {
		$.post("/getRegion.action",{
			'parentId':0
		},function(data){
			$(data.regionList).each(function(i,item){
				$("#pro").append("<option value='"+item.id+"'>"+item.name+"</option>")
			});
		})
	});
	
	$("#pro").change(function(){
		$("#cit > option :not(:first)").remove();
		$("#cou > option :not(:first)").remove();
		if($(this).val()!=0){
			$.post("/getRegion.action",{
				'parentId':$(this).val()
			},function(data){
				$(data.regionList).each(function(i,item){
					$("#cit").append("<option value='"+item.id+"'>"+item.name+"</option>")
				});
			})
		}
	})
	
	$("#cit").change(function(){
		$("#cou > option :not(:first)").remove();
		if($(this).val()!=0){
			$.post("/getRegion.action",{
				'parentId':$(this).val()
			},function(data){
				$(data.regionList).each(function(i,item){
					$("#cou").append("<option value='"+item.id+"'>"+item.name+"</option>")
				});
			})
		}
	})
	
</script>
