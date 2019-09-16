<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eloan-P2P平台->我要借款</title>
<#include "common/links-tpl.ftl" />
</head>
<body>
	<!-- 网页头信息 -->
	<#include "common/head-tpl.ftl" />
	
	<!-- 网页导航 -->
	<#assign currentNav="borrow" />
	<#include "common/navbar-tpl.ftl" />
	
	<!-- 网页内容 -->
	<div class="container el-borrow">
		<div class="row">
			<div class="el-borrow-item col-sm-4">
				<div class="el-borrow-item-title" style="background-color: #40d47e;">
					信用贷
				</div>
				<div class="el-borrow-item-content">
					<p>
						认证后可借金额 <i>¥ ${account.remainBorrowLimit}</i>
					</p>
					<a href="#" class="text-primary">申请条件</a>
					<p class="help-block">仅限成都地区</p>
					<ul>
						<li>
							<#if !(userinfo.isBasicInfo)>
								<a href="${ctx}/userInfo2.do">填写基本资料</a>
								<span class="glyphicon glyphicon-remove" style="color:red;"></span>
							<#else>
								填写基本资料<span class="glyphicon glyphicon-ok" style="color:green;"></span>
							</#if>
						</li>
						<li>
							<#if !(userinfo.isBindPhone)>
								<a href="${ctx}/personal.do">绑定手机</a>
								<span class="glyphicon glyphicon-remove" style="color:red;"></span>
							<#else>
								绑定手机<span class="glyphicon glyphicon-ok" style="color:green;"></span>
							</#if>
						</li>
						<li>
							<#if !(userinfo.isBindEmail)>
								<a href="${ctx}/personal.do">绑定邮箱</a>
								<span class="glyphicon glyphicon-remove" style="color:red;"></span>
							<#else>
								绑定邮箱<span class="glyphicon glyphicon-ok" style="color:green;"></span>
							</#if>
						</li>
						<li>
							<#if (userinfo.authscore<creditBorrowScore)>
								<a href="#">您的材料认证分数${userinfo.authscore}分</a>
								<a href="#">材料认证分数需达到${creditBorrowScore}分</a>
								<span class="glyphicon glyphicon-remove" style="color:red;"></span>
							<#else>
								材料认证分数达到${creditBorrowScore}分<span class="glyphicon glyphicon-ok" style="color:green;">
							</span></#if>
						</li>
					</ul>
					<#if userinfo.isBasicInfo && userinfo.isBindPhone && userinfo.isBindEmail
					        && (userinfo.authscore >= creditBorrowScore) >
						<a href="${ctx}/borrowInfo.do" class="el-borrow-apply">
							申请贷款
						</a>
					<#else>
						<a href="#" class="el-borrow-apply">
							申请贷款
						</a>
					</#if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>