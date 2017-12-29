/**
 * Created by Administrator on 2017/12/14.
 */
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

timer = setInterval(function(){
    showPic(index);
    index++;
    if(index == len){index = 0;}
},2000);

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
        $('.sildebar li').hide();
        $('.sildebar li').eq(index).show(); /*2017-12-25*/
        $('.focusBox li').eq(index).css("background", "#F70A1C").siblings().css("background","#320B4E");
        // $('.carousellist a').eq(index).show().siblings().hide(); /*2017-12-25*/
    }
//下拉
 $(".down").click(function () {
     var h=$('.img img').eq(0).height()*4;
     $('.img').css("height",h+"px");
     var num=$('.img a').length
     // alert(num)
     var tt
     if(num<=4){
         alert("没有更多数据")
     }if(4<num&&num<8){

         $('.img').append( $('.img a:lt('+(8-num)+')').clone(true))
         $('.img a').animate({top:"-"+h+"px"},3000)
     }else if(num>=8){
         $('.img a').animate({top:"-"+h+"px"},3000)
     }
     tt=setTimeout(function () {
             $('.img').append($('.img a:lt(4)'));
             $('.img a').css("top",0);

         },3100)


 })

///横向滚动
// var mySwiper = new Swiper ('.swiper-container', {
// //    autoHeight:true,
//     direction:"horizontal",
//     loop : true,
//     speed:2000,
//     autoplay:true,
//     slidesPerView : 5,
//     loopedSlides :5,
//     spaceBetween :5,
//     slidesPerGroup : 1,
//     freeMode :true,
//     freeModeMomentum : false,
//     freeModeSticky : false,
//
// })
// $('.swiper-container').mouseover(function(){
//     mySwiper.stopAutoplay();
// })
// $('.swiper-slide').mouseover(function(){
//     mySwiper.stopAutoplay();
//     $('.swiper-slide a').css({"color":"#333"})
//     $('.swiper-slide img').css({"border":"4px solid transparent"})
//     $(this).find('img').css({"border":"4px solid #D7AD4B"})
//     $(this).find('a').css({"color":"red"})
//
// })
// $('.swiper-slide').mouseout(function(){
//     mySwiper.startAutoplay();
//     $('.swiper-slide a').css({"color":"#333"})
//     $('.swiper-slide img').css({"border":"4px solid transparent"})
// })
//



//横向

ScrollImgLeft();
function ScrollImgLeft(){
    var speed=15;
    var scroll_begin = document.getElementById("scroll_begin");
    var scroll_end = document.getElementById("scroll_end");
    var scroll_div = document.getElementById("scroll_div");
    if(!scroll_begin){
        return;
    }
    scroll_end.innerHTML=scroll_begin.innerHTML;
    function Marquee(){
        if(scroll_end.offsetWidth-scroll_div.scrollLeft<=4)
        {
            scroll_div.scrollLeft-=scroll_begin.offsetWidth;
        }
        else
        {
            scroll_div.scrollLeft++;
        }
    }
    var MyMar=setInterval(Marquee,speed);
    $('.scroll_div li').mouseover(function()
    {
        clearInterval(MyMar);
        $('.thumbnail a').css({"color":"#333"})
        $('.thumbnail img').css({"border":"4px solid transparent"})
        $(this).find('img').css({"border":"4px solid #D7AD4B"})
        $(this).find('a').css({"color":"red"})
    })
    $('.scroll_div li').mouseout(function()
    {

        $('.thumbnail a').css({"color":"#333"})
        $('.thumbnail img').css({"border":"4px solid transparent"})
        MyMar=setInterval(Marquee,speed);
    })
}