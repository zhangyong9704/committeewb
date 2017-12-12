var Write = (function(){
	return {
		textarea: null,
		ue: null,
		timer: null,
		init: function(){
			this.initTextArea();
			this.initUE();
			this.initEvent();
		},
		// 初始化textArea使其能够随着输入文本的多少换行
		initTextArea: function(){
			/**
			 * 文本框根据输入内容自适应高度
			 * @param                {HTMLElement}        输入框元素
			 * @param                {Number}                设置光标与输入框保持的距离(默认0)
			 * @param                {Number}                设置最大高度(可选)
			 */
			var autoTextarea = function (elem, extra, maxHeight) {
	        extra = extra || 0;
	        var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
	        isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
	                addEvent = function (type, callback) {
	                        elem.addEventListener ?
	                                elem.addEventListener(type, callback, false) :
	                                elem.attachEvent('on' + type, callback);
	                },
	                getStyle = elem.currentStyle ? function (name) {
	                        var val = elem.currentStyle[name];
	 
	                        if (name === 'height' && val.search(/px/i) !== 1) {
	                                var rect = elem.getBoundingClientRect();
	                                return rect.bottom - rect.top -
	                                        parseFloat(getStyle('paddingTop')) -
	                                        parseFloat(getStyle('paddingBottom')) + 'px';        
	                        };
	 
	                        return val;
	                } : function (name) {
	                                return getComputedStyle(elem, null)[name];
	                },
	                minHeight = parseFloat(getStyle('height'));
	 
	        elem.style.resize = 'none';
	 
	        var change = function () {
	                var scrollTop, height,
	                        padding = 0,
	                        style = elem.style;
	 
	                if (elem._length === elem.value.length) return;
	                elem._length = elem.value.length;
	 
	                if (!isFirefox && !isOpera) {
	                        padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
	                };
	                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
	 
	                elem.style.height = minHeight + 'px';
	                if (elem.scrollHeight > minHeight) {
	                        if (maxHeight && elem.scrollHeight > maxHeight) {
	                                height = maxHeight - padding;
	                                style.overflowY = 'auto';
	                        } else {
	                                height = elem.scrollHeight - padding;
	                                style.overflowY = 'hidden';
	                        };
	                        style.height = height + extra + 'px';
	                        scrollTop += parseInt(style.height) - elem.currHeight;
	                        document.body.scrollTop = scrollTop;
	                        document.documentElement.scrollTop = scrollTop;
	                        elem.currHeight = parseInt(style.height);
	                };
	        };
	 
	        addEvent('propertychange', change);
	        addEvent('input', change);
	        addEvent('focus', change);
	        change();
			};
			var ta = document.getElementById("textarea");
      autoTextarea(ta);// 调用
      this.textarea = $("#textarea");
		},
		initUE: function(){
			this.ue = UE.getEditor('editor',{
	    	toolbars: [[
	        'fullscreen', 'source', '|', 'undo', 'redo', '|',
	        'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
	        'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
	        'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	        'directionalityltr', 'directionalityrtl', 'indent', '|',
	        'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
	        'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
	        'simpleupload', 'insertimage', 'emotion', 'scrawl', 'music', 'attachment', 'map', 'insertframe', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
	        'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
	        'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
	        'print', 'preview', 'searchreplace', 'drafts', 'help'
	    	]],
	    });
		},
		// 节流函数
		throttle: function(action, delay){
		  var last = 0;
		  return function(){
		    var curr = +new Date();
		    if (curr - last > delay){
		      action.apply(this, arguments);
		      last = curr;
		    }
		  }
		},
		initEvent: function(){
			var self = this; 
			var throttle = function (fn, delay) {
				console.log("throttle");
			    var timer = null;
			    return function () {
			        clearTimeout(timer);
			        timer = setTimeout(function() {
			            fn();
			        }, delay);
			    }
			};
			self.ue.addListener("contentChange",throttle(function(){
				console.log('内容改变:'+self.ue.getContent());
			}, 1000));
			
			self.textarea.bind('input propertychange', throttle(function(){
				console.log('内容改变textarea:'+self.textarea.val());
			}, 1000));
		}
	}
})()
