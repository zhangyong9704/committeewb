/**
 * Created by Administrator on 2017/12/22.
 */
//初始化2017-12-22
    $(function () {


var imgh1=$(".warper").find("img").height();
$(".warper").css("height",imgh1);
var h1=parseInt($(".swiper-slide").find(".thumbnail").height())+30+"px";
$(".swiper-wrapper,.swiper-slide").css("height",h1);
$(".swiper-container").css("height",h1);
// 导航
//2017-12-22
var navh1=parseInt($(".nav").find("img").height())-6+"px";
var navh=$(".nav").find("img").height();
$(".nav").css("height",navh1);
$(".nav a").css("height",navh1);
$(".nav a").css("lineHeight",navh1);
$(".nav div").css("bottom",navh);


$('.nav>div a').mouseover(function () {
    $('.nav>div a').css("background","#C90102");
    $(this).css("background","#A00314")
})
    })

//2017-12-25
setwidth()
window.onresize = function(){
    setwidth();
};
function setwidth() {
       var leftw=parseInt($(".actirl").width())-690+"px";
   if(document.body.clientWidth>=1301){
       $(".actirl .right").css("width",leftw);
       $(".actirl .right").show()
      }else {
        $(".actirl .right").hide()
         }
}
