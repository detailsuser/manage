/*改变背景色 */
$(function () {
    $(".center_left li").on("click", function () {
        $(".center_left li").css('background-color', '#ededed');
        $(this).css('background-color', '#ffffff')
    })
})
$(function () {
    $(".center_left ul li a").on("click", function () {
        $(".center_left ul li a").css('color','#8d8d8d');
        $(this).css('color','#1a87ec')
    })
})
$(function () {
    $(".nav_title li a").on("click",function () {
        $(".nav_title li a").css('color','#080808');
        $(this).css('color','#ffffff')
    })
})
$(function () {
    $(".dv").on("click",function () {
        $(".dv").css('background-color','#ededed')
        $(".dv").css('color','#080808')
        $(this).css('background-color', '#1a87ec')
        $(this).css('color', '#ffffff')
    })
})
/*实现点击div跳转到相应的界面*/
$(function () {
    $("#l1").click(function () {
        $(".d1").toggle(true);
        $(".d2,.d3,.d4").hide();
    })
    $("#l2").click(function () {
        $(".d2").toggle(true);
        $(".d1,.d3,.d4").hide();
    })
    $("#l3").click(function () {
        $(".d3").toggle(true);
        $(".d1,.d2,.d4").hide();
    })
    $("#l4").click(function () {
        $(".d4").toggle(true);
        $(".d1,.d2,.d3").hide();
    })

})
/*下拉菜单*/
$(document).ready(function () {
    $('.inactive').click(function () {
        if ($(this).siblings('ul').css('display') == 'none') {
            $(this).addClass('inactives');
            $(this).siblings('ul').slideDown(100).children('li');
        } else {
            $(this).removeClass('inactives');
            $(this).siblings('ul').slideUp(100);
        }
    })
});
/*给所有的编辑框和单选按钮加一个不可编辑的属性*/
$(function () {
    $(".payment input[type='text'],.payment input[type='radio']").attr('disabled','disabled');
});
$(function () {
    $(".reimburse input[type='text'],.reimburse input[type='radio']").attr('disabled','disabled');
});
$(function () {
    var disabled = true;
    $(".edit").click(function () {
        $(".payment_table input[type='text'], .payment_table input[type='radio']").removeAttr("disabled");
    });
});
$(function () {
    var disabled = true;
    $(".edit1").click(function () {
        $(".table input[type='text'], .table input[type='radio']").removeAttr("disabled");
    });
});
/*==============点击弹出div视层===============*/
function OpenDiv(){
    document.getElementById("div1").style.display="block";
    document.getElementById("div2").style.display="block";
}
//给div层中的关闭添加onclick事件：
function CloseDiv(){
    document.getElementById("div1").style.display="none";
    document.getElementById("div2").style.display="none";
}
/*======点击增加明细新增一个div======*/
$(function () {
    var box = $(".purchase-requisition");
    var addBtn = $(".add-btn");
    $(".add-btn").click(function () {
        var appendHtml = '<div class="purchase-requisition">\n' +
            '                    <table border="0" cellspacing="0" cellpadding="0">\n' +
            '                        <tr>\n' +
            '                            <td class="shopping-title">采购明细(<span>1</span>)</td>\n' +
            '                            <td><span class="shopping-delete">删除</span></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>名称</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>规格</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>单价(元)</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>数量</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>总价</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                    <p>如需采购多种产品，请点击增加明细</p>\n' +
            '                    <button class="add-btn1" type="button">增加明细</button>\n' +
            '                </div>';
        box.append(appendHtml);
    });
    // 绑定在追加在元苏的父级上面  就可以解决 追加input的点击事件失效
    $(".purchase-requisition").on("click",".add-btn1",function(){
        var appendHtml = '<div class="purchase-requisition">\n' +
            '                    <table border="0" cellspacing="0" cellpadding="0">\n' +
            '                        <tr>\n' +
            '                            <td class="shopping-title">采购明细(<span>1</span>)</td>\n' +
            '                            <td><span class="shopping-delete">删除</span></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>名称</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>规格</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>单价(元)</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>数量</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>总价</td>\n' +
            '                            <td><input type="text" name="" value=""></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                    <p>如需采购多种产品，请点击增加明细</p>\n' +
            '                    <button class="add-btn1" type="button">增加明细</button>\n' +
            '                </div>';
        box.append(appendHtml);

    });
    $(".purchase-requisition").on("click",".shopping-delete",function () {
        $(".tablea").parent().remove();
    });

});
$(function () {
    $(".purchase-requisition table").addClass(function (index) {
        return "item"+index;
    });
});