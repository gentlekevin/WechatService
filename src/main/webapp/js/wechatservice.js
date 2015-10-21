function firstMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    this.getAllFirstMenu();
    $('#firstMenu').show();
    $('#secondMenu').hide();
    $('#thirdMenu').hide();
}

function secondMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    this.getAllSecondMenu();
    $('#firstMenu').hide();
    $('#secondMenu').show();
    $('#thirdMenu').hide();
}

function ThirdMenuClick() {
    if (window.event) {
        this.selectMenu(window.event);
    }
    $('#firstMenu').hide();
    $('#secondMenu').hide();
    $('#thirdMenu').show();
    this.getAllThirdMenu();
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
                var text ='<tr>' + '<th scope="row">'+ datas[i].content +'</th>' + '<td>' + type + '</td>'+ '<td>' + datas[i].answer + '</td>'+ '<td firstMenuId=' + datas[i].id + '><a class="pointer" onclick="getFirstMenuById()">修改</a>&nbsp;&nbsp;  <a class="pointer" onclick="deleteFirstMenu()">删除</a></td></tr>';
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
    var url = 'web/updateFirstMenu?content=' + menu1_content + '&type=' + menu1_type + '&answer=' + menu1_answer ;
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
                var text ='<tr>' + '<th scope="row">'+ datas[i].category_id +'</th>' +'<td>' + datas[i].content + '</td>'+'<td>' + type + '</td>'+ '<td>' + datas[i].answer + '</td>'+ '<td secondMenuId=' + datas[i].id + '><a class="pointer" onclick="getSecondMenuById()">修改</a>&nbsp;&nbsp;  <a class="pointer" onclick="deleteSecondMenu()">删除</a></td></tr>';
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
    var url = 'web/updateSecondMenu?content=' + menu2_content + '&type=' + menu2_type + '&answer=' + menu2_answer + '&category_id=' + menu2_category_id ;
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