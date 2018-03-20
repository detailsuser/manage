/*===========改变背景色===========*/
$(function () {
    $(".lod-title li").on("click", function () {
        $(".lod-title li").css('background-color', '#ededed');
        $(this).css('background-color', '#ffffff')
    })
})
$(function () {
    $(".list-title li button").on("click",function () {
        $(".list-title li button").css('background-color','#ffffff');
        $(".list-title li button").css('color','#616161');
        $(this).css('background-color','#1998ec');
        $(this).css('color','#ffffff');
    })
})
function changespan() {
    var text = document.getElementsByClassName("weeksreport");
    document.getElementById("dayreport").innerHTML=text;
}
/*==========切换页面==============*/
$(function () {
    $(".out").click(function () {
        $(".left-container").toggle(true);
        $(".right-container,.readlog").hide();
    })
    $(".myout").click(function () {
        $(".right-container").toggle(true);
        $(".left-container,.readlog").hide();
    })
    $(".look-log").click(function () {
        $(".readlog").toggle(true);
        $(".left-container,.right-container").hide();
    })
})
/*切换相对应的界面*/
$(function () {
    $(".dayreport").click(function () {
        $(".report1").toggle(true);
        $(".report2,.report3,.report4,.report5,.report6,.report7,.report8").hide();
    })
    $(".weeksreport").click(function () {
        $(".report2").toggle(true);
        $(".report1,.report3,.report4,.report5,.report6,.report7,.report8").hide();
    })
    $(".monthreport").click(function () {
        $(".report3").toggle(true);
        $(".report1,.report2,.report4,.report5,.report6,.report7,.report8").hide();
    })
    $(".yearreport").click(function () {
        $(".report4").toggle(true);
        $(".report1,.report2,.report3,.report5,.report6,.report7,.report8").hide();
    })
    $(".seasonreport").click(function () {
        $(".report5").toggle(true);
        $(".report1,.report2,.report3,.report4,.report6,.report7,.report8").hide();
    })
    $(".technicalreport").click(function () {
        $(".report6").toggle(true);
        $(".report1,.report2,.report3,.report4,.report5,.report7,.report8").hide();
    })
    $(".visitrecord").click(function () {
        $(".report7").toggle(true);
        $(".report1,.report2,.report3,.report4,.report5,.report6,.report8").hide();
    })
    $(".resultsreport").click(function () {
        $(".report8").toggle(true);
        $(".report1,.report2,.report3,.report4,.report5,.report6,.report7").hide();
    })
})
/*点击不同的li显示相对应的内容*/
window.onload = function () {
    var a = document.getElementById("dayreport");
    var obj_lis = document.getElementById("test").getElementsByTagName("button");
    for(i=0;i<obj_lis.length;i++){
        obj_lis[i].onclick = function () {
            a.innerHTML = this.innerHTML;
        }
    }
}