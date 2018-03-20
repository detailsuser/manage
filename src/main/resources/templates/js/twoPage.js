$(function() {
    $(".spanStyle").click(function() {
        $(this).html( $(".data").is(":hidden") ?  "<span>收起</span>" : "<span>编辑</span>");
        $(".data").slideToggle();
    });
});
$(function() {
    $(".up").click(function() {
        $(this).html( $(".resume").is(":hidden") ?  "<span>收起</span>" : "<span>编辑</span>");
        $(".resume").slideToggle();
    });
});
$(function() {
    $(".cancel").click(function() {
        $(this).html( $(".experience").is(":hidden") ?  "<span>取消</span>" : "<span>编辑</span>");
        $(".experience").slideToggle();
    });
});
$(function() {
    $(".edit3").click(function() {
        $(this).html( $(".pxjl").is(":hidden") ?  "<span>收起</span>" : "<span>编辑</span>");
        $(".pxjl").slideToggle();
    });
});


/*实现点击可编辑*/
$(function () {
    var disabled = true;
    $(".edit").click(function () {
        $(".table1 input[type='text'], .table1 input[type='radio']").removeAttr("disabled");
    });
});
$(function () {
    var disabled = true;
    $(".edit1").click(function () {
        $(".table2 input[type='text']").removeAttr("disabled");
    });
});
$(function () {
    var disabled = true;
    $(".edit2").click(function () {
        $(".table3 input[type='text']").removeAttr("disabled");
    });
});
/*给所有的编辑框和单选按钮加一个不可编辑的属性*/
$(function () {
    $("#twoPage input[type='text'],#twoPage input[type='radio']").attr('disabled','disabled');
});
/*去掉不可编辑属性*/
$(function () {
    $(".experience input[type='text']").removeAttr('disabled','disabled');
});