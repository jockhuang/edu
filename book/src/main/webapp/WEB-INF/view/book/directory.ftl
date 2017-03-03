<ul>
	<#list directory as d>
	<li><em>${d.page}</em>${d.nodeName?default(d.page)}</li>
	<#if (d.childNodes?? && d.childNodes?size > 0) >
	<#list d.childNodes as child>
	<li><em>${child.page}</em>&nbsp;&nbsp;&nbsp;&nbsp;${child.nodeName?default(child.page)}</li>
	</#list>
	</#if>
	</#list>
</ul>