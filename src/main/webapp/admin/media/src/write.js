var Write = (function(){
	return {
		baseurl: "",
		textarea: null, // 文本框对象
		ue: null, // 富文本对象
		timer: null, // 节流器中的定时器
		init: function(){
			// 初始化进度条
			Progressbar.init();
			this.baseurl = CommonUtils.baseUrl;
			this.initTextArea();
			this.initUE();
			this.initEvent();
			this.initData();
		},
		initData: function(){
			this.ajaxEdit({});
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
		        /*'fullscreen',*/ 'source', '|', 'undo', 'redo', '|',
		        'bold', 'italic', 'underline', 'fontborder', 'strikethrough', /*'superscript', 'subscript',*/ 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
		        'rowspacingtop', 'rowspacingbottom', 'lineheight', /*'|',*/
		        'customstyle', 'paragraph', /*'fontfamily',*/ 'fontsize', '|',
		        'directionalityltr', 'directionalityrtl', 'indent', '|',
		        'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
		        'link', 'unlink', /*'anchor',*/ '|', /*'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',*/
		        'simpleupload', 'insertimage', 'emotion', /*'scrawl', 'music',*/ 'attachment', /*'map', 'insertframe',*/ 'insertcode', /*'template',*/ '|',
		        'horizontal', 'date', 'time', 'spechars', /*'snapscreen', 'wordimage',*/ '|',
		        /*'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', '|',*/
		        'print', 'preview', 'searchreplace', 'drafts'/*, 'help'*/
		    	]],
		    });
		},
		hideFileInput: function(){
			$(".writeCover-uploadIcon").hide();
			$("#tiTuFileInput").hide();
			/*$(".addtext").hide();*/
		},
		showFileInput: function(){
			$(".writeCover-uploadIcon").show();
			$("#tiTuFileInput").show();
			/*$(".addtext").show();*/
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
		uploadTiTu: function(formId){
			var self = this;
			$(".writeCover-previewWrapper").show();
			// 显示进度条
			Progressbar.show();
			// 显示进度条的同时，隐藏file input
			self.hideFileInput();
			$(".img-wrapper").hide();
			// 组装FormData对象
			var form = document.getElementById(formId);
			var formData = new FormData(form);
			// 文章id
			var articleId = $("#articleId").html();
			
			var xhr = new XMLHttpRequest();
			xhr.open("POST", self.baseurl+"/news/draft/"+articleId, true);
			 //注册相关事件回调处理函数
			xhr.onload = function(e) {
			    if(this.status == 200||this.status == 304){
			        console.log(this.responseText);
			        var res = window.JSON.parse(this.responseText);
			        if(res.code === 200){
			        	if(articleId==-1){
			        		$("#articleId").html(res.rows[0].id);
							window.history.replaceState({}, '', "edit/"+res.rows[0].id);
			        	}
			        	$(".writeCover-previewWrapper").hide();
			        	$("#tiTuImg").attr("src", self.baseurl+"/upload/"+res.rows[0].picUrl);
			        	$(".img-wrapper").show();
			        }else{
			        	alert("未知错误3");
			        }
			    }
			};
			/*xhr.ontimeout = function(e) { ... };*/
			xhr.onerror = function(e) {
				alert("未知错误！");
			};
			/*
			 * console.log('总字节数-->'+e.total);
             * console.log('加载-->'+e.loaded);
			 * */
			xhr.upload.onprogress = function(e) {
				var percent =  ~~((e.loaded/e.total)*100)+"%";
				console.log(percent);
				Progressbar.updateProgress(percent);
				if(percent == '100%'){
					// 隐藏进度条
					Progressbar.hide();
				}
			};
			//发送数据
			xhr.send(formData);
		},
		initEvent: function(){
			var self = this; 
			// 题图的change事件
			$("#tiTuFileInput").change(function(){
				self.uploadTiTu("tiTuFileInput");
			});
			
			
			// 屏蔽textarea的回车换行事件
			self.textarea.keydown(function(e){
				if(e.keyCode!=13) return;
				e.preventDefault();
				var value = $(this).val();
                $(this).val(value);
			});
			// textarea的属性改变事件
			self.textarea.bind('input propertychange', CommonUtils.throttle(function(){
				// 获取标题文本内容
				var textareaVal = self.textarea.val();
				// 1.判断标题内容的长度，至多允许100个字符
				var length = textareaVal.length;
				if(length>100){
					$(".titleinfo")
						.html("标题超过  "+(length-100)+"  个字，无法保存")
						.removeClass("titlegray")
						.addClass("titlered");
					return;
				}
				$(".titleinfo")
					.html("草稿自动保存")
					.removeClass("titlered")
					.addClass("titlegray");
				// 2.提交后台交互保存数据
				// 第一次提交数据，地址为 /news/draft/-1
				var articleId = $("#articleId").html();
				self.ajaxEdit({title: textareaVal});
			}, 1000));
			// 富文本框的内容改变事件
			self.ue.addListener("contentChange",CommonUtils.throttle(function(){
				var contentVal = self.ue.getContent();
				self.ajaxEdit({content: contentVal});
			}, 2000));
			
			// 替换删除的click事件
			/*$(".reset").click(function(){
				alert("重置");
			});*/
			$("#resettiTuFileInput").change(function(){
				self.uploadTiTu("resettiTuFileInput");
			});
			$(".remove").click(function(){
				self.showFileInput();
				$(".writeCover-previewWrapper").show();
				$(".img-wrapper").hide();
				self.ajaxEdit({
					picUrl: ""
				});
	        	
			});
		},
		ajaxEdit: function(dataObj){
			var self = this;
			// 获取对象中的属性个数
			var objPropertyCount = Object.getOwnPropertyNames(dataObj).length;
			var articleId = $("#articleId").html();
			if(articleId == -1 && objPropertyCount == 0){
				return;
			}
			$.ajax({
				type: "post",
				url: self.baseurl+"/news/draft/"+articleId,
				async: true,
				data: dataObj,
				success: function(res){
					if(res.code===200){
						if(articleId == -1){
							$("#articleId").html(res.rows[0].id);
							window.history.replaceState({}, '', "edit/"+res.rows[0].id);
						}else if(objPropertyCount==0){
							console.log("初始化数据");
							// 题图赋值
							console.log(res);
							if(res.rows[0].picUrl != null && res.rows[0].picUrl != ""){
								$(".writeCover-previewWrapper").hide();
					        	$("#tiTuImg").attr("src", self.baseurl+"/upload/"+res.rows[0].picUrl);
					        	$(".img-wrapper").show();
							}else{
								
							}
							
							
							// textarea赋值							
							self.textarea.val(res.rows[0].title);
							self.initTextArea();
							// ue赋值	
							self.ue.addListener("ready", function () {
					            self.ue.setContent(res.rows[0].content);
					        }); 
						}
					}else{
						alert(res.msg);
					}
				},
				error: function(){
					alert("未知错误2");
				}
			});
		}
	}
})()
