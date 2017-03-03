<#assign currentPage = (currentPage!1) - 1  />
<#assign itemsPerPage = itemsPerPage!10  />
<#assign total = total!0  />
<#assign totalPage = total / itemsPerPage  />
<#assign numEdgeEntries = numEdgeEntries!0  />
<#assign numDisplayEntries = numDisplayEntries!0 />
<#if (href??) >
<#assign href = (" href=\"" + href + "&currentPage={currentPage}\"")  />
</#if>
<#if (callback??)>
<#assign href = (href!"" + " onclick=\"" + callback + "({currentPage})\"")  />
</#if>
<div class="pagination">
<span class="current" >共<em>${total}</em>条，当前第${currentPage + 1}/${totalPage + 1}页，每页${itemsPerPage}条</span><br />
<#if (currentPage <= 0)>
<span class="current prev">上一页</span>
<#else>
<a class="prev" ${href?replace("{currentPage}" , (currentPage)?string)} >上一页</a>
</#if>
<#assign begin = currentPage - (numDisplayEntries / 2) + 1 />
<#if (begin < 0) >
<#assign begin = 0 />
</#if>
<#assign end = begin + numDisplayEntries - 1 />
<#if (end > totalPage) >
<#assign end = totalPage />
</#if>
<#if (numEdgeEntries > 0 && (begin - numEdgeEntries) >= 0) >
<#list 0..(numEdgeEntries - 1) as i >
<#if begin != i>
<a class="sp" ${href?replace("{currentPage}" , (i + 1)?string)} >${i + 1}</a>
</#if>
</#list>
<#if ((begin - numEdgeEntries) > (numEdgeEntries - 1))>
<span>...</span>
</#if>
</#if>
<#list begin..end as i >
<#if (i == currentPage)>
<span class="current" >${i + 1}</span>
<#else>
<a ${href?replace("{currentPage}" , (i + 1)?string)} >${i + 1}</a>
</#if>
</#list>
<#if (numEdgeEntries > 0 && (totalPage - end) > 1)>
<#if ((totalPage - end) > numEdgeEntries + 1)>
<span>...</span>
</#if>
<#list (totalPage - numEdgeEntries + 1)..totalPage as i >
<#if (end != i)>
<a class="ep" ${href?replace("{currentPage}" , (i + 1)?string)} >${i + 1}</a>
</#if>
</#list>
</#if>
<#if (currentPage >= totalPage)>
<span class="current next">下一页</span>
<#else>
<a class="next" ${href?replace("{currentPage}" , (currentPage + 2)?string)} >下一页</a>
</#if>
</div>