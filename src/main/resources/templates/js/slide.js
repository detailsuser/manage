function a() {
    $(this).html( $(".data").is(":hidden") ?  "<span>收起</span>" : "<span>编辑</span>");
    $(".data").slideToggle();
}