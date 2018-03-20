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
        $(".d2,.d3").hide();
    })
    $("#two").click(function () {
        $(".d2").toggle(true);
        $(".d1,.d3").hide();
    })
    $("#three").click(function () {
        $(".d3").toggle(true);
        $(".d1,.d2").hide();
    })
});
$(function () {
    $(".m1").click(function () {
        $(".minutes_one").toggle(true);
        $(".minutes_two").hide();
    })
    $(".m2").click(function () {
        $(".minutes_two").toggle(true);
        $(".minutes_one").hide();
    });
});
$(function () {
    $(".meeting_minutes ul li").on("click", function () {
        $(".meeting_minutes ul li").css('background-color', '#ededed');
        $(this).css('background-color', '#ffffff')
    })
})