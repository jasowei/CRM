<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js">

    </script>
    <script type="text/javascript">
        $(function () {

            $.post(
                    "${pageContext.request.contextPath}/listDept.action",
                    function (data) {
                        var _html = "";
                        $.each(data, function (i, n) {
                            _html += '<option value=' + n.depID + ' >' + n.depName + '</option>';

                        });
                        $("#deptSelectId").append(_html);
                    },
                    'json'
            );

            $("#deptSelectId").change(function () {
                $("#postSelectId").empty();
                $("#postSelectId").append('<option value="-1">---请选择职务---</option>');
                $.post(
                        "${pageContext.request.contextPath}/listPost.action",
                        {
                            departid: $("#deptSelectId").val()
                        },
                        function (data) {

                            $.each(data, function (i, n) {
                                $("#postSelectId").append('<option value=' + n.postId + '>' + n.postName + '</option>');
                            });
                        },
                        'json'
                );
            });
        });
    </script>

</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="${pageContext.request.contextPath}/listStaff.action"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="${pageContext.request.contextPath}/addStaff.action" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value=""/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/></td>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select id="deptSelectId" name="depId">
                    <option value="-1">----请--选--择----</option>
                </select>

            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select id="postSelectId" name="postID">
                    <option value="-1">----请--选--择----</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>
<s:actionerror/>
</body>
</html>
