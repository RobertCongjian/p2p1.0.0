<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eloan-P2P平台->我要借款</title>
    <#include "common/links-tpl.ftl" />

    <script type="text/javascript" src="${ctx}/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="${ctx}/js/plugins-override.js"></script>
    <script type="text/javascript">
        $(function () {
            var searchForm = $("#searchForm");
            var gridBody = $("#gridBody");
            searchForm.ajaxForm(function (data) {    //普通请求    获取到代码片段
                gridBody.hide();                   //让当前的页面内容先隐藏
                gridBody.html(data);               //把当前的页面html代码替换成请求到的表单内容
                gridBody.show(500);                //一种淡入的效果
            });
            searchForm.submit();                  //第一次请求之后马上发送一个请求去请求内容

            $("input[name=bidRequestState]").change(function () {
                $("#currentPage").val(1);
                searchForm.submit();
            });
        });
    </script>
</head>
<body>
<!-- 网页头信息 -->
<#include "common/head-tpl.ftl" />
<#assign currentNav="invest" />
<!-- 网页导航 -->
<#include "common/navbar-tpl.ftl" />

<!-- 网页内容 -->
<div class="container" style="min-height: 500px;">
    <h4 class="page-title">投资列表</h4>
    <form action="${ctx}/invest_list.do" id="searchForm" method="POST">
        <input type="hidden" name="currentPage" id="currentPage" value="1">
        <div style="margin: 20px 0px;">
            <span class="text-muted">标的状态</span>
            <div style="margin-left: 30px" class="btn-group" data-toggle="buttons">
                <label class="btn btn-default active">
                    <input type="radio" name="bidRequestState" value="-1" autocomplete="off" checked/>&emsp;全部&emsp;
                </label>
                <label class="btn btn-default">
                    <input type="radio" name="bidRequestState" value="1" autocomplete="off"/>&emsp;招标中&emsp;
                </label>
                <label class="btn btn-default">
                    <input type="radio" name="bidRequestState" value="8" autocomplete="off"/>&emsp;已完成&emsp;
                </label>
            </div>
        </div>
    </form>
    <table class="table el-table table-hover">
        <thead id="gridHead">
        <tr>
            <th>借款人</th>
            <th width="180px">借款标题</th>
            <th>年利率</th>
            <th>金额</th>
            <th>还款方式</th>
            <th>进度</th>
            <th width="80px">操作</th>
        </tr>
        </thead>
        <tbody id="gridBody">

        </tbody>
    </table>
    <div style="text-align: center;" id="page_container">
        <ul id="pagination" class="pagination"></ul>
    </div>
</div>

</body>
</html>