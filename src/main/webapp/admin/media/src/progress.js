var Progressbar={
	wrapper: null,
	fill: null,
    init:function(){
        this.fill=document.getElementById('fill');
        this.wrapper = document.getElementById('progress-wrapper');
    },
    updateProgress: function(value){
    	if(this.fill!=null){
    		this.fill.innerHTML = value;
            this.fill.style.width = value;
    	}
    },
    hide: function(){
    	this.wrapper.style.display = "none";
    },
    show: function(){
    	this.wrapper.style.display='block';
    }
};