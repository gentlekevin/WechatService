<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeChat web service</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="bs-example" data-example-id="simple-nav-stacked" >
        <ul class="nav nav-pills nav-stacked nav-pills-stacked-example left-index">
            <h3>菜单管理</h3>
            <li role="presentation"><a onclick="firstMenuClick()"  class="pointer" id ="menu1"> ●一级菜单</a></li>
            <li role="presentation"><a onclick="secondMenuClick()" class="pointer" id ="menu2"> ●二级菜单</a></li>
            <li role="presentation"><a onclick="ThirdMenuClick()" class="pointer" id ="menu3" style="display: none;"> ●三级菜单</a></li>
            <h3>数据统计</h3>
            <li role="presentation"><a onclick="dataCountInfoClick()" class="pointer"> ●统计信息</a></li>
        </ul>
        <div class="left-line" >
            <div class="dragger-vertical-line">
                <div id="b4_dragHandle" class="dragger-handle-v">
                </div>
            </div>
        </div>
    </div>

    <span id="message" class="help-block alert  alert-success" style="margin-top: 20px; margin-left: 200px;width: 310px;">请选择左侧菜单管理或数据统计功能</span>
    <!-- 一级菜单-->
    <div class="wechatservice-page-right">
        <div id = "firstMenu" style="display: none">
            <table class="table table table-bordered">
                <caption>一级菜单</caption>
                <thead>
                    <tr>
                        <th>序列</th>
                        <th>内容</th>
                        <th>类型</th>
                        <th>答案</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <form>
                <div class="form-group">
                    <label for="menu1_sequence">序列</label>
                    <input type="text" class="form-control" id="menu1_sequence" placeholder="序列" onblur="menu1SequenceCheck()">
                </div>
                <span id="menu1_sequence_message" class="help-block alert  alert-success" style="display: none;"></span>
                <div class="form-group">
                    <label for="menu1_content">内容</label>
                    <input type="text" class="form-control" id="menu1_content" placeholder="内容">
                </div>
                <span id="menu1_content_message" class="help-block alert  alert-success" style="display: none;"></span>
                <label for="menu1_type">类型</label>
                <select class="form-control" id="menu1_type">
                    <option value="0">菜单</option>
                    <option value="1">问题</option>
                </select>
                <div class="form-group">
                     <label for="menu1_answer">答案</label>
                     <input type="text" class="form-control" id="menu1_answer" placeholder="答案">
                </div>
                <span id="menu1_answer_message" class="help-block alert  alert-success" style="display: none;"></span>
                <button type="button" class="btn btn-default" onclick="updateFistMenu()" id="firstMenuSubmit">新增</button>
            </form>
        </div>
    </div>

    <!-- 二级菜单-->
    <div class="wechatservice-page-right">
        <div id = "secondMenu" style="display: none">
            <table class="table table table-bordered">
                <caption>二级菜单</caption>
                <thead>
                <tr>
                    <th>一级菜单</th>
                    <th>序列</th>
                    <th>内容</th>
                    <th>类型</th>
                    <th>答案</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <form>
                <label for="menu2_category">一级菜单</label>
                <select class="form-control" id="menu2_category">
                </select>
                <div class="form-group">
                    <label for="menu2_sequence">序列</label>
                    <input type="text" class="form-control" id="menu2_sequence" placeholder="序列" onblur="menu2SequenceCheck()">
                </div>
                <span id="menu2_sequence_message" class="help-block alert  alert-success" style="display: none;"></span>
                <div class="form-group">
                    <label for="menu2_content">内容</label>
                    <input type="text" class="form-control" id="menu2_content" placeholder="内容">
                </div>
                <span id="menu2_content_message" class="help-block alert  alert-success" style="display: none;"></span>
                <label for="menu2_type">类型</label>
                <select class="form-control" id="menu2_type">
                    <option value="0">菜单</option>
                    <option value="1">问题</option>
                </select>
                <div class="form-group">
                    <label for="menu2_answer">答案</label>
                    <input type="text" class="form-control" id="menu2_answer" placeholder="答案">
                </div>
                <span id="menu2_answer_message" class="help-block alert  alert-success" style="display: none;"></span>
                <button type="button" class="btn btn-default" onclick="updateSecondMenu()" id="secondMenuSubmit">新增</button>
            </form>
        </div>
    </div>


    <!-- 三级菜单-->
    <div class="wechatservice-page-right">
        <div id = "thirdMenu" style="display: none">
            <table class="table table table-bordered">
                <caption>三级菜单</caption>
                <thead>
                    <tr>
                        <th>一级菜单</th>
                        <th>二级菜单</th>
                        <th>内容</th>
                        <th>答案</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <form>
                <label for="menu3_category">一级菜单</label>
                <select class="form-control" id="menu3_category">
                </select>
                <label for="menu3_subcategory">二级菜单</label>
                <select class="form-control" id="menu3_subcategory">
                </select>
                <div class="form-group">
                    <label for="menu3_content">内容</label>
                    <input type="text" class="form-control" id="menu3_content" placeholder="内容">
                </div>
                <div class="form-group">
                    <label for="menu3_answer">答案</label>
                    <input type="text" class="form-control" id="menu3_answer" placeholder="答案">
                </div>
                <button type="button" class="btn btn-default" onclick="updateThirdMenu()" id="thirdMenuSubmit">新增</button>
            </form>
        </div>
    </div>


    <!-- 数据统计信息-->
    <div class="wechatservice-page-right">
        <div id = "dataCountInfo" style="display: none">
            <table class="table table table-bordered">
                <caption>数据统计信息</caption>
                <thead>
                <tr>
                    <th>来源</th>
                    <th>比例</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
