<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeChat web service</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div style = "margin-left: 30px; margin-right: 30px;">
        <h3>获取开发人员列表</h3>
        <form name="form" action="web/getDevelopers" method="GET"
              id ="userForm" class="" style="margin-left: 40px;">
            <input type="button" id = "submitForm" value="获取开发人员信息" class = "btn btn-default btn-small"
                   onclick="submitFormFun()"/>
        </form>
        <span id="message"  class="help-block alert  alert-success"
              style="padding: 8px; width: 150px;">数据结果:</span>
        <table style="" cellpadding="0" cellspacing="0" border="0"
        class="table table-striped table-bordered table-hover" id="dataTableContent">
        </table>
    </div>
</body>
</html>
