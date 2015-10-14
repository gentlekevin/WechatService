var dataTable;

function submitFormFun() {
    // 是否已经构建过dataTable,已经构建过进行销毁
    if (dataTable) {
        dataTable.api().destroy();
        dataTable = null;
    }
    this.fetchData();
};

function fetchData() {
    $.ajax({
        url: 'web/getDevelopers',
        type: 'get',
        async : false,
        success: function(datas) {
            buildData(datas);
            $('#message').text('获取数据成功!')
        },
        error: function() {
            $('#message').text('获取数据失败!')
            $('#message').addClass("alert-danger");
        }
    });
}

function buildData(datas) {
    if (!datas || datas.length == 0) {
        $('#message').text('表中的信息为空!');
        $('#message').addClass("alert-danger");
        return;
    }
    var schmemas = [];
    for (var schema in datas[0]) {
        var obj = {};
        obj.title = schema;
        schmemas.push(obj);
    }
    var contents = [];
    for (var i = 0; i < datas.length; i++) {
        var innerContent = [];
        for (var schema in datas[0]) {
            innerContent.push(datas[i][schema]);
        }
        contents.push(innerContent);
    }
    dataTable = $("#dataTableContent").dataTable({
        data: contents,
        aoColumns: schmemas,
        oLanguage: {
            oPaginate: {
                sFirst: '首页',
                sPrevious: '上一页',
                sNext: '下一页',
                sLast: '末页'
            },
            sSearch: '快速过滤：',
            sLengthMenu: '每页 _MENU_ 条'
        },
        sEmptyTable: '没有相关数据',
        autoWidth: false
    });
}