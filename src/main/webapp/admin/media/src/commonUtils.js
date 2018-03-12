var CommonUtils = (function(){
	return {
		baseUrl: "/committeewb",
		add0: function(m){
			return m<10 ? '0'+m : m;
		},
		timeStampToDate: function(timeStamp){
			var time = new Date(timeStamp);
			var year=time.getFullYear();     
			var month=time.getMonth()+1; 
			var date=time.getDate();     
			var hour=time.getHours();     
			var minute=time.getMinutes();     
			var second=time.getSeconds();     
			return year+"-"+this.add0(month)+"-"+this.add0(date)+" "+this.add0(hour)+":"+this.add0(minute)+":"+this.add0(second);  
		},
		throttle: function (fn, delay) {
			//console.log("throttle");
		    var timer = null;
		    return function () {
		        clearTimeout(timer);
		        timer = setTimeout(function() {
		            fn();
		        }, delay);
		    }
		}
	}
})()
