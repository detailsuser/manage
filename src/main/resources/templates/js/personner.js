/*改变背景色 */
$(function () {
    $(".center_left li").on("click", function () {
        $(".center_left li").css('background-color', '#ededed');
        $(this).css('background-color', '#ffffff')
    })
})
$(function () {
    $(".center_left ul li a").on("click", function () {
        $(".center_left ul li a").css('color', '#8d8d8d');
        $(this).css('color', '#1a87ec')
    })
})
/*实现点击div跳转到相应的界面*/
$(function () {
    $("#one").click(function () {
        $(".d1").toggle(true);
        $(".d2,.d3,.d4").hide();
    })
    $("#two").click(function () {
        $(".d2").toggle(true);
        $(".d1,.d3,.d4").hide();
    })
    $("#three").click(function () {
        $(".d3").toggle(true);
        $(".d1,.d2,.d4").hide();
    })
    $("#four").click(function () {
        $(".d4").toggle(true);
        $(".d1,.d2,.d3").hide();
    })
});
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
$(document).ready(function () {
    $('.department').click(function () {
        if ($(this).siblings('ul').css('display') == 'none') {
            $(this).addClass('departments');
            $(this).siblings('ul').slideDown(100).children('li');
        } else {
            $(this).removeClass('departments');
            $(this).siblings('ul').slideUp(100);
        }
    })
});