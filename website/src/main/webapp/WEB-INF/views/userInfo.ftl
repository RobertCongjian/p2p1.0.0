<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eloan-P2P平台</title>
    <#include "common/links-tpl.ftl" />
    <link type="text/css" rel="stylesheet" href="${ctx}/css/account.css"/>
    <script type="text/javascript" src="${ctx}/js/plugins/jquery.form.js"></script>
    <script>
        $(function () {
            //提交表单
            $("#submitBtn").click(function () {
                $("#userInfoForm").ajaxSubmit({
                    success: function (data) {
                        if (data.success) {
                            $.messager.confirm("提示", "资料保存成功", function () {
                                window.location.reload();
                            });
                        } else {
                            $.messager.confirm("提示", data.msg);
                        }
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
<!-- 网页顶部导航 -->
<#include "common/head-tpl.ftl" />

<#assign currentNav="personal"/>
<!-- 网页导航 -->
<#include "common/navbar-tpl.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
            <#assign currentMenu="userInfo" />
            <#include "common/leftmenu-tpl.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    个人资料
                </div>
                <form id="userInfoForm" class="form-horizontal" action="${ctx}/userInfo_save.do" method="post"
                      style="width: 700px;">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            用户名
                        </label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${logininfo.username}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            真实姓名
                        </label>
                        <div class="col-sm-8">
                            <p class="form-control-static">
                                未认证
                                <a href="${ctx}/realAuth.do">[马上认证]</a>
                                <#--										<#if (userinfo.isRealAuth)>
                                                                            ${userinfo.anonymousRealName}
                                                                        <#else>
                                                                            未认证
                                                                            <a href="/realAuth.do">[马上认证]</a>
                                                                        </#if>-->
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            身份证号码
                        </label>
                        <div class="col-sm-8">
                            <p class="form-control-static">
                                未认证
                                <a href="${ctx}/realAuth.do">[马上认证]</a>
                                <#--										<#if (userinfo.isRealAuth)>
                                                                            ${userinfo.anonymousIdNumber}
                                                                        <#else>
                                                                            未认证
                                                                            <a href="/realAuth.do">[马上认证]</a>
                                                                        </#if>-->
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            手机号码
                        </label>
                        <div class="col-sm-8">
                            <label style="width: 250px;" class="form-control">${userinfo.phonenumber!''}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            个人学历
                        </label>
                        <div class="col-sm-8">
                            <select class="form-control" id="educationbackgroundItem" name="educationbackgroundItem.id"
                                    style="width: 180px" autocomplate="off">
                                <option value="0">-请选择-</option>
                                <#list educationBackgrounds as item>
                                    <option value="${item.id}">${item.title}</option>
                                </#list>
                            </select>
                            <script type="text/javascript">
                                <#if (userinfo.educationbackgroundId)!=0>
                                $("#educationbackgroundItem option[value=${userinfo.educationbackgroundItem.id!-1}]").attr("selected", true);
                                </#if>
                            </script>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            月收入
                        </label>
                        <div class="col-sm-8">
                            <select class="form-control" id="incomegradeItem" name="incomegradeItem.id"
                                    style="width: 180px"
                                    autocomplate="off">
                                <option value="0">-请选择-</option>
                                <#list incomeGrades as item>
                                    <option value="${item.id}">${item.title}</option>
                                </#list>
                            </select>
                            <script type="text/javascript">
                                <#if (userinfo.incomegradeId)!=0>
                                $("#incomegradeItem option[value=${userinfo.incomegradeItem.id!-1}]").attr("selected", true);
                                </#if>

                            </script>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            婚姻情况
                        </label>
                        <div class="col-sm-8">
                            <select class="form-control" id="marriageItem" name="marriageItem.id" style="width: 180px"
                                    autocomplate="off">
                                <option value="0">-请选择-</option>
                                <#list marriages as item>
                                    <option value="${item.id}">${item.title}</option>
                                </#list>
                            </select>
                            <script type="text/javascript">
                                <#if (userinfo.marriageId)!=0>
                                $("#marriageItem option[value=${userinfo.marriageItem.id!-1}]").attr("selected", true);
                                </#if>
                            </script>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            子女情况
                        </label>
                        <div class="col-sm-8">
                            <select class="form-control" id="kidcountItem" name="kidcountItem.id" style="width: 180px"
                                    autocomplate="off">
                                <option value="0">-请选择-</option>
                                <#list kidCounts as item>

                                    <option value="${item.id}">${item.title}</option>
                                </#list>
                            </select>
                            <script type="text/javascript">
                                <#if (userinfo.kidcountId)!=0>
                                $("#kidcountItem option[value=${userinfo.kidcountItem.id!-1}]").attr("selected", true);

                                </#if>
                            </script>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">
                            住房条件
                        </label>
                        <div class="col-sm-8">
                            <select class="form-control" id="houseconditionItem" name="houseconditionItem.id"
                                    style="width: 180px" autocomplate="off">
                                <option value="0">-请选择-</option>

                                <#list houseConditions as item>

                                    <option value="${item.id}">${item.title}</option>

                                </#list>

                            </select>
                            <script type="text/javascript">
                                <#if (userinfo.houseconditionId)!=0>
                                $("#houseconditionItem option[value=${userinfo.houseconditionItem.id!-1}]").attr("selected", true);
                                </#if>
                            </script>

                        </div>
                    </div>

                    <div class="form-group">
                        <button id="submitBtn" type="submit" class="btn btn-primary col-sm-offset-5"
                                data-loading-text="数据保存中" autocomplate="off">
                            保存数据
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<#include "common/footer-tpl.ftl" />
</body>
</html>