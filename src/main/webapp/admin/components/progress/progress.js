var Progressbar={
    init:function(){
        var fill=document.getElementById('fill');
        var count=0;
    //通过间隔定时器实现百分比文字效果,通过计算CSS动画持续时间进行间隔设置
        var timer=setInterval(function(e){
            count++;
            fill.innerHTML=count+'%';
            document.getElementById("fill").style.width = count+'%';
            if(count===100) clearInterval(timer);
        },10);
    },
    progress: function(){
    	
    }
};