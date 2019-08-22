<#macro loadSdi sn>
	<#assign list = _SYSTEMDIC_UTIL.listBySn(sn) />
	<#list list as item>
		<option value="${item.id}">${item.title}</option>
	</#list>
</#macro>