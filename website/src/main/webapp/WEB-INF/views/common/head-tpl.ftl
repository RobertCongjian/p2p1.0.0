<div class="el-header" >
		<div class="container" style="position: relative;">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${ctx}/login.html">首页</a></li>
				    //如果logininfo存在
					<#if !logininfo??>
					<li><a href="${ctx}/login.html">登录</a></li>
					<li><a href="${ctx}/register.html">快速注册</a></li>
					<#else>
					<li>
						  <a class="el-current-user" href="${ctx}/personal.do">${logininfo.username}</a>
					</li>
					<li><a  href="${ctx}/recharge.do">账户充值  </a></li>
					<li><a  href="${ctx}/logout.do">注销 </a></li>
					</#if>
				<li><a href="#">帮助</a></li>
			</ul>
		</div>
</div>
