function firstMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    this.getAllFirstMenu();
    $('#firstMenu').show();
    $('#secondMenu').hide();
    $('#thirdMenu').hide();
    $('#dataCountInfo').hide();
}

function secondMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    this.getAllSecondMenu();
    $('#firstMenu').hide();
    $('#secondMenu').show();
    $('#thirdMenu').hide();
    $('#dataCountInfo').hide();
}

function ThirdMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    $('#firstMenu').hide();
    $('#secondMenu').hide();
    $('#dataCountInfo').hide();
    $('#thirdMenu').show();
    this.getAllThirdMenu();
}

function dataCountInfoClick () {
    this.selectMenu(window.event);
    $('#firstMenu').hide();
    $('#secondMenu').hide();
    $('#thirdMenu').hide();
    $('#dataCountInfo').show();
    this.getDataCountInfo();
}

function getDataCountInfo() {
    var url = "web/getDataCountInfo"
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            for (var key in info.data) {
                var text = '<tr><td>' + key + '</td><td>' + info.data[key] +'</td></tr>';
                content += text;
            }
            $('#dataCountInfo tbody').html(content) ;
        },
        error: function() {
            $('#message').text('获取数据失败!')
            $('#message').show();
        }
    });
}

function getAllFirstMenu() {
    var url = "web/getAllFirstMenu"
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                var type = datas[i].type;
                if (type ==  0) {
                    type = '菜单';
                } else if ( type == 1) {
                    type = '问题';
                }
                var text ='<tr>' + '<th scope="row">'+ datas[i].sequence +'</th>'  + '<td>' + datas[i].content + '</td>'+ '<td>' + type + '</td>'+ '<td>' + datas[i].answer + '</td>'+ '<td firstMenuId=' + datas[i].id + '><a class="pointer" onclick="getFirstMenuById()">修改</a>&nbsp;&nbsp;  <a class="pointer" onclick="deleteFirstMenu()">删除</a></td></tr>';
                content += text;
            }
            $('#firstMenu tbody').html(content) ;
        },
        error: function() {
            $('#message').text('获取数据失败!')
            $('#message').show();
        }
    });
}

function selectMenu(event) {
    var menus = $('li[role=presentation]');
    for (var i = 0; i < menus.length; i++) {
        $(menus[i]).removeAttr('class', 'active');
    }
    $('#message').hide();
    $(event.target).parent().attr("class", 'active');
}

function updateFistMenu () {

    var menu1_content = $('#menu1_content').val();
    var menu1_type = $('#menu1_type').val();
    var menu1_answer = $('#menu1_answer').val();
    var menu1_sequence = $('#menu1_sequence').val();
    $('#menu1_sequence_message').hide();
    $('#menu1_content_message').hide();
    $('#menu1_answer_message').hide();
    if (!menu1_sequence) {
        $('#menu1_sequence_message').text('序列不能为空!');
        $('#menu1_sequence_message').show();
        return;
    }
    if (!menu1_content) {
        $('#menu1_content_message').text('内容不能为空!');
        $('#menu1_content_message').show();
        return;
    }
    if (menu1_type == 1 && !menu1_answer) {
        $('#menu1_answer_message').text('答案不能为空!');
        $('#menu1_answer_message').show();
        return;
    }
    var url = 'web/updateFirstMenu?content=' + menu1_content + '&type=' + menu1_type + '&answer=' + menu1_answer + '&sequence=' + menu1_sequence;
    var id = -1;
    if ($('#firstMenuSubmit').attr('firstMenuId')) {
        id = $('#firstMenuSubmit').attr('firstMenuId');
    };
    url +=  '&id=' + id;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu1_content').val('');
            $('#menu1_answer').val('');
            $('#menu1_sequence').val('');
            $('#message').text('数据修改成功!')
            $('#message').show();
            // 隐藏提示框
            setTimeout(function() {
                $('#message').hide();
                $('#firstMenuSubmit').attr('firstMenuId','');
                $('#firstMenuSubmit').text('新增')
                setTimeout(function() {
                    $('#menu1').click();
                }, 500);
            },2000);
        },
        error: function() {
            $('#message').text('数据修改失败!')
            $('#message').show();
        }
    });
}

function getFirstMenuById () {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('firstMenuId')) {
        id = parent.attr('firstMenuId');
    }
    var url = 'web/getFirstMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu1_content').val(info.data.content);
            $('#menu1_answer').val(info.data.answer);
            $('#menu1_sequence').val(info.data.sequence);
            $('#firstMenuSubmit').attr('firstMenuId', id);
            $('#firstMenuSubmit').text('修改');
        },
        error: function() {
            $('#message').text('数据修改失败!')
            $('#message').show();
        }
    });

}

function deleteFirstMenu () {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('firstMenuId')) {
        id = parent.attr('firstMenuId');
    }
    var url = 'web/deleteFirstMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            if (!info.success) {
                $('#message').text('数据删除失败!');
                $('#message').show();
            } else {
                $('#message').text('数据删除成功!');
                $('#message').show();
                setTimeout(function() {
                    $('#message').hide();
                    $('#menu1').click();
                }, 2000);
            }
        },
        error: function() {
            $('#message').text('数据删除失败!');
            $('#message').show();
        }
    });
}

function getAllSecondMenu() {
    var url = "web/getAllSecondMenu"
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                var type = datas[i].type;
                if (type ==  0) {
                    type = '菜单';
                } else if ( type == 1) {
                    type = '问题';
                }
                var text ='<tr>' + '<th scope="row">'+ datas[i].category_id +'</th>' +'<td>' + datas[i].sequence + '</td>' + '<td>' + datas[i].content + '</td>'+'<td>' + type + '</td>'+ '<td>' + datas[i].answer + '</td>'+ '<td secondMenuId=' + datas[i].id + '><a class="pointer" onclick="getSecondMenuById()">修改</a>&nbsp;&nbsp;  <a class="pointer" onclick="deleteSecondMenu()">删除</a></td></tr>';
                content += text;
            }
            $('#secondMenu tbody').html(content) ;
        },
        error: function() {
            $('#message').text('获取数据失败!')
            $('#message').show();
        }
    });

    // 加载一级菜单信息
    $.ajax({
        url: "web/getAllFirstMenu",
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                if (datas[i].type == 0) {
                    var text = "<option value='"+ datas[i].id +"'>" + datas[i].content + "</option>";
                    content += text;
                }
            }
            $('#secondMenu #menu2_category').html(content) ;
        },
        error: function() {
            $('#message').text('获取一级数据失败!')
            $('#message').show();
        }
    });
}

function updateSecondMenu () {

    var menu2_content = $('#menu2_content').val();
    var menu2_type = $('#menu2_type').val();
    var menu2_answer = $('#menu2_answer').val();
    var menu2_category_id = $('#menu2_category').val();
    var menu2_sequence =  $('#menu2_sequence').val();
    $('#menu2_sequence_message').hide();
    $('#menu2_content_message').hide();
    $('#menu2_answer_message').hide();
    if (!menu2_sequence) {
        $('#menu2_sequence_message').text('序列不能为空!');
        $('#menu2_sequence_message').show();
        return;
    }
    if (!menu2_content) {
        $('#menu2_content_message').text('内容不能为空!');
        $('#menu2_content_message').show();
        return;
    }
    if (menu2_type == 1 && !menu2_answer) {
        $('#menu2_answer_message').text('答案不能为空!');
        $('#menu2_answer_message').show();
        return;
    }
    var url = 'web/updateSecondMenu?content=' + menu2_content + '&type=' + menu2_type + '&answer=' + menu2_answer + '&category_id=' + menu2_category_id + '&sequence=' + menu2_sequence ;
    var id = -1;
    if ($('#secondMenuSubmit').attr('secondMenuId')) {
        id = $('#secondMenuSubmit').attr('secondMenuId');
    };
    url +=  '&id=' + id;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu2_content').val('');
            $('#menu2_answer').val('');
            $('#menu2_sequence').val('');
            $('#message').text('数据修改成功!');
            $('#message').show();
            // 隐藏提示框
            setTimeout(function() {
                $('#message').hide();
                $('#secondMenuSubmit').attr('secondMenuId','');
                $('#secondMenuSubmit').text('新增');
                setTimeout(function() {
                    $('#menu2').click();
                }, 500);
            },2000);
        },
        error: function() {
            $('#message').text('数据修改失败!');
            $('#message').show();
        }
    });
}

function getSecondMenuById() {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('secondMenuId')) {
        id = parent.attr('secondMenuId');
    }
    var url = 'web/getSecondMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu2_content').val(info.data.content);
            $('#menu2_answer').val(info.data.answer);
            $('#menu2_sequence').val(info.data.sequence);
            $('#secondMenuSubmit').attr('secondMenuId', id);
            $('#secondMenuSubmit').text('修改');
        },
        error: function() {
            $('#message').text('数据修改失败!')
            $('#message').show();
        }
    });

}

function deleteSecondMenu() {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('secondMenuId')) {
        id = parent.attr('secondMenuId');
    }
    var url = 'web/deleteSecondMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            if (!info.success) {
                $('#message').text('数据删除失败!');
                $('#message').show();
            } else {
                $('#message').text('数据删除成功!');
                $('#message').show();
                setTimeout(function() {
                    $('#message').hide();
                    $('#menu2').click();
                }, 2000);
            }
        },
        error: function() {
            $('#message').text('数据删除失败!');
            $('#message').show();
        }
    });
}

function updateThirdMenu() {
    var menu3_category = $('#menu3_category').val();
    var menu3_subcategory = $('#menu3_subcategory').val();
    var menu3_content = $('#menu3_content').val();
    var menu3_answer = $('#menu3_answer').val();
    var url = 'web/updateThirdMenu?category_id=' + menu3_category + '&subcategory_id='+ menu3_subcategory +'&content=' + menu3_content +  '&answer=' + menu3_answer ;
    var id = -1;
    if ($('#thirdMenuSubmit').attr('thirdMenuId')) {
        id = $('#thirdMenuSubmit').attr('thirdMenuId');
    };
    url +=  '&id=' + id;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu3_content').val('');
            $('#menu3_answer').val('');
            $('#message').text('数据修改成功!')
            $('#message').show();
            // 隐藏提示框
            setTimeout(function() {
                $('#message').hide();
                $('#thirdMenuSubmit').attr('thirdMenuId','');
                $('#thirdMenuSubmit').text('新增')
                setTimeout(function() {
                    $('#menu3').click();
                }, 500);
            },2000);
        },
        error: function() {
            $('#message').text('数据修改失败!')
            $('#message').show();
        }
    });
}

function getAllThirdMenu() {
    var url = "web/getAllThirdMenu"
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                var text ='<tr>' + '<th scope="row">'+ datas[i].category_id +'</th>' +'<td>' + datas[i].subcategory_id + '</td>'+'<td>' + datas[i].content + '</td>'+ '<td>' + datas[i].answer + '</td>'+ '<td thirdMenuId=' + datas[i].id + '><a class="pointer" onclick="getThirdMenuById()">修改</a>&nbsp;&nbsp;  <a class="pointer" onclick="deleteThirdMenu()">删除</a></td></tr>';
                content += text;
            }
            $('#thirdMenu tbody').html(content) ;
        },
        error: function() {
            $('#message').text('获取数据失败!')
            $('#message').show();
        }
    });

    // 加载一级菜单信息
    $.ajax({
        url: "web/getAllFirstMenu",
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                if (datas[i].type == 0) {
                    var text = "<option value='"+ datas[i].id +"'>" + datas[i].content + "</option>";
                    content += text;
                }
            }
            $('#thirdMenu #menu3_category').html(content) ;
        },
        error: function() {
            $('#message').text('获取一级数据失败!')
            $('#message').show();
        }
    });

    // 加载二级菜单信息
    $.ajax({
        url: "web/getAllSecondMenu",
        type: 'get',
        async : false,
        success: function(info) {
            var content = '';
            var datas = info.data;
            for (var i = 0; i < datas.length; i++) {
                if (datas[i].type == 0) {
                    var text = "<option value='"+ datas[i].id +"'>" + datas[i].content + "</option>";
                    content += text;
                }
            }
            $('#thirdMenu #menu3_subcategory').html(content) ;
        },
        error: function() {
            $('#message').text('获取一级数据失败!')
            $('#message').show();
        }
    });
}


function getThirdMenuById() {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('thirdMenuId')) {
        id = parent.attr('thirdMenuId');
    }
    var url = 'web/getThirdMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            $('#menu3_content').val(info.data.content);
            $('#menu3_answer').val(info.data.answer);
            $('#thirdMenuSubmit').attr('thirdMenuId', id);
            $('#thirdMenuSubmit').text('修改');
        },
        error: function() {
            $('#message').text('数据修改失败!')
            $('#message').show();
        }
    });
}

function deleteThirdMenu() {
    var parent = $(window.event.target).parent();
    var id = -1;
    if (parent.attr('thirdMenuId')) {
        id = parent.attr('thirdMenuId');
    }
    var url = 'web/deleteThirdMenuById?id=' + id  ;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            if (!info.success) {
                $('#message').text('数据删除失败!');
                $('#message').show();
            } else {
                $('#message').text('数据删除成功!');
                $('#message').show();
                setTimeout(function() {
                    $('#message').hide();
                    $('#menu3').click();
                }, 2000);
            }
        },
        error: function() {
            $('#message').text('数据删除失败!');
            $('#message').show();
        }
    });
}

function menu1SequenceCheck() {
    var sequence = $('#menu1_sequence').val();
    if (isNaN(sequence)) {
        $('#menu1_sequence_message').text('请输入正确的序列，只能为数字!');
        $('#menu1_sequence_message').show();
        $('#firstMenuSubmit').attr('disabled', '');
        return;
    } else if (!sequence) {
        $('#menu1_sequence_message').text('请输入正确的序列，不能为空!');
        $('#menu1_sequence_message').show();
        $('#firstMenuSubmit').attr('disabled', '');
        return;
    }
    $('#firstMenuSubmit').removeAttr('disabled');
    $('#menu1_sequence_message').hide();
    var url = 'web/menu1ContainsSequence?sequence=' + sequence;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            if (!info.success) {
                $('#menu1_sequence_message').text('该序列已经存在该菜单下，请检查后重新输入!');
                $('#menu1_sequence_message').show();
            }
        }
    });
}


function menu2SequenceCheck() {
    var sequence = $('#menu2_sequence').val();
    var category_id = $('#menu2_category').val();
    if (isNaN(sequence)) {
        $('#menu2_sequence_message').text('请输入正确的序列，只能为数字!');
        $('#menu2_sequence_message').show();
        $('#secondMenuSubmit').attr('disabled', '');
        return;
    } else if (!sequence) {
        $('#menu2_sequence_message').text('请输入正确的序列，不能为空!');
        $('#menu2_sequence_message').show();
        $('#secondMenuSubmit').attr('disabled', '');
        return;
    }
    $('#secondMenuSubmit').removeAttr('disabled');
    $('#menu2_sequence_message').hide();
    var url = 'web/menu2ContainsSequence?sequence=' + sequence + '&categoryId=' + category_id;
    $.ajax({
        url: url,
        type: 'get',
        async : false,
        success: function(info) {
            if (!info.success) {
                $('#menu2_sequence_message').text('该序列已经存在该菜单下，请检查后重新输入!');
                $('#menu2_sequence_message').show();
            }
        }
    });
}