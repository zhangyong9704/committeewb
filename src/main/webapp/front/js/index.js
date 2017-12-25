/**
 * Created by Administrator on 2017/12/14.
 */
// //初始化2017-12-22
// var imgh1=$(".warper").find("img").height();
// $(".warper").css("height",imgh1);
// var h1=parseInt($(".swiper-slide").find(".thumbnail").height())+0+"px";
// $(".swiper-wrapper,.swiper-slide").css("height",h1);
// $(".swiper-container").css("height",h1);
// // 导航
// //2017-12-22
// var navh1=parseInt($(".nav").find("img").height())-6+"px";
// var navh=$(".nav").find("img").height();
// $(".nav").css("height",navh1);
// $(".nav a").css("height",navh1);
// $(".nav a").css("lineHeight",navh1);
// $(".nav div").css("bottom",navh);
//
//
// $('.nav>div a').mouseover(function () {
//     $('.nav>div a').css("background","#C90102");
//     $(this).css("background","#A00314")
// })

   //轮播
    var len = $('.warper .sildebar li').length;
    var timer;
    var index = 0;
    var focusBox = '<ul class="focusBox"></ul>';
    $('.warper').append(focusBox);

    for(var i=0;i<len;i++){
        var li=$("<li>"+(i+1)+"</li>")[0];
        $('.focusBox')[0].appendChild(li);
    }
    $('.warper .focusBox li').click(function(){
        index = $('.warper .focusBox li').index(this);
        showPic(index);
    }).eq(0).trigger('click');

    $('.warper').hover(function(){
        clearInterval(timer);
    },function(){
      timer = setInterval(function(){
            showPic(index);
            index++;
            if(index == len){index = 0;}
        },2000);
    });
    function showPic(index) {
        $('.sildebar li').fadeOut(0);
        $('.sildebar li').eq(index).fadeIn(500);
        $('.focusBox li').eq(index).css("background", "#F70A1C").siblings().css("background","#320B4E");
        // alert(index)
    }
//下拉
 $(".cli").click(function () {;
     for(var n=0;n<4;n++){
         $('.img').append($("<img src='img/samll.png'>"))
     }
     var h=($('.img img').eq(0).height()*4);
     alert(h)
     $('.img').css("height",h+"px");
     $('.img img').animate({top:"-"+h+"px"},3000,function () {
         $('.img img').css("top",0);
     })
     var t=setTimeout(function () {
         $('.img img:lt(4)').remove();
     },3000)


 })
//星光
var stars_box=document.getElementById('stars_box');  //获取id为star_box的元素

var Obj=function(){}   //创建一个对象

Obj.prototype.drawStar=function(){     //增加对象原型方法drawStar
    var odiv=document.createElement('div');   //创建div
    odiv.style.width='7px';
    odiv.style.height='7px';
    odiv.style.position='relative';   //设置div为相对定位
    odiv.style.left=Math.floor(stars_box.clientWidth*Math.random())+'px';   //div的left值不能超出屏幕的宽度
    odiv.style.top=Math.floor(stars_box.clientHeight*Math.random())+'px';//div的left值不能超出屏幕的高度
    odiv.style.overflow='hidden';  //设置div的overflow为hidden
    stars_box.appendChild(odiv);   //添加div到stars_box元素上
    var ostar=document.createElement('img');   //再创建img元素
    ostar.style.width='49px';
    ostar.style.height='7px';
    ostar.src='img/start1.png';
    ostar.style.position='absolute';   //设置img为绝对定位
    ostar.style.top='0px';
    odiv.appendChild(ostar);   //把img添加到div中
    Play(ostar);    //实现动画闪烁的方法Play();
}

function Play(ele){
    var i=Math.floor(Math.random()*7);  //为了使星星不同时闪烁，设置随机值
    var timer=setInterval(function(){     //每100ms执行一次匿名方法
        if(i<7){
            ele.style.left=-i*7+'px';
            i++;
        }else{
            i=0;
        }
    },100);
}

//使用for循环创建30个不同的对象
for(var i=0;i<500;i++){
    var obj=new Obj();
    obj.drawStar();
}
//横向滚动
var mySwiper = new Swiper ('.swiper-container', {
//    autoHeight:true,
    loop : true,
    slidesPerView : 5,
    spaceBetween :5,
    freeMode :true,
    freeModeMomentum : false,
    freeModeSticky : false,
    speed:3000,
    autoplay :true,
})
$('.swiper-container').mouseover(function(){
    mySwiper.stopAutoplay();
})
$('.swiper-slide').mouseover(function(){
    mySwiper.stopAutoplay();
    $('.swiper-slide a').css({"color":"#333"})
    $('.swiper-slide img').css({"border":"4px solid transparent"})
    $(this).find('img').css({"border":"4px solid #D7AD4B"})
    $(this).find('a').css({"color":"red"})

})
$('.swiper-slide').mouseout(function(){
    mySwiper.startAutoplay();
    $('.swiper-slide a').css({"color":"#333"})
    $('.swiper-slide img').css({"border":"4px solid transparent"})
})
