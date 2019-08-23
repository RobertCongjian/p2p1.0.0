<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#usermanage_detail"><span>用户管理</span></a>
		<ul class="in" id="usermanage_detail">
			<li class=""><a href="${ctx}/user_list.do">平台用户管理</a></li>
			<li class=""><a href="${ctx}/recharge_offline_list.do">员工管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#permissionmanage_detail"><span>安全管理</span></a>
		<ul class="in" id="permissionmanage_detail">
			<li class="systemDictionary"><a href="${ctx}/systemDictionary_list.do"><span>系统数据字典目录</span></a></li>
			<li class="systemDictionaryItem"><a href="${ctx}/systemDictionaryItem_list.do"><span>系统数据字典明细</span></a></li>
			<li><a href="${ctx}/permission_list.do"><span>权限管理</span></a></li>
			<li><a href="#"><span>角色管理</span></a></li>
			<li><a href="#"><span>菜单管理</span></a></li>
			<li class="ipLog"><a href="${ctx}/ipLog.do"><span>登录历史</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#auditmanage_detail">
			<span>审核项目</span>
		</a>
		<ul class="in" id="auditmanage_detail">
			<li class="realAuth"><a href="${ctx}/realAuth.do">实名认证审核</a></li>
			<li class="vedioAuth"><a href="${ctx}/vedioAuth.do">视频认证审核</a></li>
			<li class="userFileAuth"><a href="${ctx}/userFileAuth.do">认证材料审核</a></li>
			<li class="bidrequest_publishaudit_list"><a href="${ctx}/bidrequest_publishaudit_list.do">发标前审核</a></li>
			<li class="bidrequest_audit1_list"><a href="${ctx}/bidrequest_audit1_list.do">满标一审</a></li>
			<li class="bidrequest_audit2_list"><a href="${ctx}/bidrequest_audit2_list.do">满标二审</a></li>
			<li class="rechargeOffline"><a href="${ctx}/rechargeOffline.do">线下充值审核</a></li>
			<li class="moneyWithdraw"><a href="${ctx}/moneyWithdraw.do">提现审核</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#systemmanage_detail">
			<span>平台管理</span>
		</a>
		<ul class="in" id="systemmanage_detail">
			<li class="companyBank"><a href="${ctx}/companyBank_list.do">平台账号管理</a></li>
			<li><a href="${ctx}/real_auth_list.do">系统账户流水</a></li>
			<li><a href="${ctx}/bid_request_list.do"> <span>系统设置</span></a></li>
			<li><a href="${ctx}/bid_request_list.do"> <span>企业资讯</span></a></li>
			<li><span><a href="#">友情链接</a></span></li>
			<li><span><a href="#">广告设置</a></span></li>
		</ul>
	</li>
</ul>

<#if currentMenu??>
<script type="text/javascript">
	$(".in li.${currentMenu}").addClass("active");
</script>
</#if>