/**
 * Created by Administrator on 2017/12/22.
 */
//初始化2017-12-22
    $(function () {
// var imgh1=parseInt($(".warper").find("img").height())-0+"px";
// $(".warper").css("height",imgh1);
// $(".focusBox").css("top",imgh1);
var h1=parseInt($(".swiper-slide").find(".thumbnail").height())+30+"px";
$(".swiper-wrapper,.swiper-slide").css("height",h1);
$(".swiper-container").css("height",h1);
// 导航
//2017-12-22
var navh1=parseInt($(".nav").find("img").height())-8+"px";
var navh=$(".nav").find("img").height();
$(".nav").css("height",navh1);
$(".nav a").css("height",navh1);
$(".nav a").css("lineHeight",navh1);
$(".nav li").css("lineHeight",navh1); //2017-12-26
$(".nav li").css("lineHeight",navh1); //2017-12-26
$(".nav div").css("bottom",navh);
// $(".nav >div> ul>.weather").css("height",navh1);
// $(".nav >div> ul>.weather").css("lineHeight",navh1);

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
   if(document.body.clientWidth>=1200){
       $(".actirl .right").css("width",leftw);
       $(".actirl .right").show()
      }else {
        $(".actirl .right").hide()
         }
}

//星光
var stars_box=document.getElementById('stars_box');  //获取id为star_box的元素
var Obj=function(){}   //创建一个对象
Obj.prototype.drawStar=function(){     //增加对象原型方法drawStar
    var odiv=document.createElement('div');   //创建div
    var ord
    var num=Math.ceil(Math.random()*3);
    // var num=2
    switch (num){
        case 1:
            odiv.style.width='60px';
            odiv.style.height='70px';
            break;
        case 2:
            odiv.style.width='30px';
            odiv.style.height='35px';
            break;
        case 3:
            odiv.style.width='40px';
            odiv.style.height='46.66px';
            break;
    }
    ord=Math.floor(180*Math.random())
    odiv.style.transform="rotate("+ord+"deg)"
    odiv.style.position='absolute';   //设置div为相对定位
    odiv.style.left=Math.floor((stars_box.offsetWidth-60)*Math.random())+'px';   //div的left值不能超出屏幕的宽度
    odiv.style.top=Math.floor((stars_box.offsetHeight-70)*Math.random())+'px';//div的left值不能超出屏幕的高度
    odiv.style.overflow='hidden';  //设置div的overflow为hidden
    // odiv.style.border='1px solid red';  //设置div的overflow为hidden
    stars_box.appendChild(odiv);   //添加div到stars_box元素上
    var ostar=document.createElement('img');   //再创建img元素
     switch (num){
        case 1:
            ostar.style.width='420px';
            ostar.style.height='70px';
            break;
        case 2:
            ostar.style.width='210px';
            ostar.style.height='35px';
            break;
        case 3:
            ostar.style.width='280px';
            ostar.style.height='46.66px';
            break;
    }
    var path=window.location.pathname.split("/")[1];
    ostar.src='/'+path+'/front/img/start1.png';
    ostar.style.position='absolute';   //设置img为绝对定位
    ostar.style.top='0px';
    odiv.appendChild(ostar);   //把img添加到div中
    Play(ostar,num);    //实现动画闪烁的方法Play();
}
function Play(ele,num){
    var w;
    switch (num){
        case 1:
            w=60;
            break;
        case 2:
            w=30;
            break;
        case 3:
            w=40;
            break;
    }
    var i=Math.floor(Math.random()*7);  //为了使星星不同时闪烁，设置随机值
    var timer=setInterval(function(){     //每100ms执行一次匿名方法
        if(i<7){
            ele.style.left=-i*w+'px';
            i++;
        }else{
            i=0;
        }
    },100);
}
//使用for循环创建30个不同的对象
for(var i=0;i<10;i++){
    var obj=new Obj();
    obj.drawStar();
}