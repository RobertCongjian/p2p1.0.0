<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eloan-P2P平台(系统管理平台)</title>
<#include "../common/header.ftl"/>
<script type="text/javascript" src="${ctx}/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js" ></script>

<script type="text/javascript">

	$(function(){

		$("#pagination_container").twbsPagination({
			totalPages:${pageResultSet.totalPage},
			visiblePages:5,
			startPage:${pageResultSet.currentPage},
			first:"首页",
			prev:"上一页",
			next:"下一页",
			last:"末页",
			onPageClick:function(event,page){
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
		
	});
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
				<#assign currentMenu="ipLog" />
				<#include "../common/menu.ftl" />
			</div>
			<form action="${ctx}/user_list.do" name="searchForm" id="searchForm" class="form-inline" method="post">
				<input type="hidden" id="currentPage" name="currentPage" value="" />
			</form>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>用户信息查询</h3>
				</div>
				<div class="panel panel-default">
					<table class="table">
						<thead>
							<tr>
								<th>用户名</th>
								<th>用户状态</th>
								<th>用户类型</th>
								<th>账号类型</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<#list pageResultSet.listData as item>
							<tr>
								<td>${item.username}</a></td>
								<td>${(item.state == 0)?string('有效','失效')}</td>
						        <td>${(item.usertype == 1)?string('前台用户','后台用户')}</td>
								<td>${(item.admin == 1)?string('管理员','普通用户') }</td>
							</tr>
							</#list>
						</tbody>
					</table>
					<div style="text-align: center;" id="pagination_container">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>