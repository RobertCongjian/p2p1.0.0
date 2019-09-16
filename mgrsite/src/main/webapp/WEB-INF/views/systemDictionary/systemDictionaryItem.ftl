<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eloan-P2P平台(系统管理平台)</title>
    <#include "../common/header.ftl"/>
    <script type="text/javascript" src="${ctx}/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="${ctx}/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>


</head>
<body>
<div class="container">
    <#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
            <#assign currentMenu="ipLog" />
            <#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>系统数据字典目录</h3>
            </div>
            <div class="panel panel-default">
                <table class="table">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>内容</th>
                        <th>内容明细</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <#list systemDictionaryItemList as item>
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.systemdictionary.title}</td>
                        <td>${item.title}</td>
                    </tr>
                    </tbody>
                    </#list>
                </table>
                <div style="text-align: center;" id="pagination_container">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>