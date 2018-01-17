var Write = (function(){
	return {
		baseurl: "",
		textarea: null, // 文本框对象
		ue: null, // 富文本对象
		timer: null, // 节流器中的定时器,
		picSize: 5 * 1024 * 1024, // 1M
		firstgetdata: 1,
		init: function(){
			var self = this;
			// 初始化进度条
			Progressbar.init();
			this.baseurl = CommonUtils.baseUrl;
			this.initTextArea();
			this.initUE();
			this.initEvent();
			this.initSpecialData(function(){
				// 专题标签的change事件
				$("input[name='special']").change(function(){
					var newstype = $("input[name='newstype']:checked").val();
					// 获取专题标签的选中的值
					var acts = [];
					$('input[name="special"]:checked').each(function(){ 
						acts.push($(this).val()); 
					}); 
					
					console.log(acts.join(","));
					self.ajaxEdit({
						activities: acts.join(","),
						newsTypeID: newstype
					});
				})
				self.initData();
			});
			//执行一个laydate实例
			laydate.render({
			  elem: '#datatimeid',
			  type: 'datetime'
			});
		},
		initSpecialData: function(callback){
			var self = this;
			$.ajax({
				type:"get",
				url: self.baseurl + "/activity/queryAllActivity",
				async:true,
				success: function(res){
					if(res.code === 200){
						var text = "";
						for(var i=0;i < res.rows.length;i++){
							var checkbox = ['<label for="special'+i+'">',
											'<input id="special'+i+'" name="special" type="checkbox" value="'+res.rows[i].id+'" />'+res.rows[i].name+' <span style="color: #EEEEEE;">|</span>&nbsp;',
											'</label>'];
							text += checkbox.join("");
						}
						$(".label-checkbox").html(text);
						
						callback();
					}else{
						alert(res.msg);
					}
				},
				error: function(error){
					
				}
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
			$("#inputid").val("");
			/*$(".addtext").show();*/
		},
		initData: function(){
			var self = this;
			self.ue.addListener("ready", function () {
				self.ajaxEdit({});
	        }); 
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
		// 上传图片前获取图片的尺寸和大小
		imgSize: function(input, formid, callback){
			var self = this;
			if(input.files){
                //读取图片数据  
				var f = input.files[0]; 
				
				if(f.size > self.picSize){
  					alert("抱歉！请上传大小为 5M 以下的图片文件");
  				}else{
  					callback(formid, self);
  				}
	  		}else{
				var image = new Image();   
				image.onload =function(){  
				    var width = image.width;  
				    var height = image.height;  
				    var fileSize = image.fileSize;  
				   // alert(width+'======'+height+"====="+fileSize);
				    if(fileSize > self.picSize){
      					alert("抱歉！请上传大小为 5M 以下的图片文件");
      				}else{
      					callback(formid, self);
      				}
				}  
				image.src = input.value;
			}
		},
		uploadTiTu: function(formId, that){
			var self = that;
			$(".writeCover-previewWrapper").show();
			// 显示进度条
			Progressbar.show();
			// 显示进度条的同时，隐藏file input
			self.hideFileInput();
			$(".img-wrapper").hide();
			// 组装FormData对象
			var form = document.getElementById(formId);
			var formData = new FormData(form);
			// 新闻类型id
			var newstype = $("input[name='newstype']:checked").val();
			formData.append('newsTypeID', newstype);
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
			        	// 像素不合适
		        		alert(res.msg);
		        		$(".writeCover-previewWrapper").show();
						// 显示进度条
						Progressbar.hide();
						// 显示进度条的同时，隐藏file input
						self.showFileInput();
						$(".img-wrapper").show();
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
			// 点击除发布按钮和box框之外的区域关闭box框
			var publishBtn = $(".publish-btn")[0];
			var box = $(".box")[0];
			$(document).click(function(e){
				var aim = e.target;
				//console.log(aim);
				//console.log(publishBtn)
				if(aim==publishBtn || aim==box){
					//alert(123)
				}else{
					$(".box").slideUp();
				}
			});
			$(".box").click(function(e){
				e.stopPropagation();
			});
			// 是否作为题图checkbox
			$("#isPicNews").change(function(){
				// 检验是否已经上传题图
				// 如果是选中状态，必须上传题图
				if($(this).is(':checked')){
					var imgsrc = $("#tiTuImg").attr("src");
					console.log(imgsrc);
					if(imgsrc != "" && imgsrc != undefined){
						//$(".nextbtn").attr("disabled", false);
					}else{
						alert("请上传题图");
						$(this).attr("checked", false);
						//$(".nextbtn").attr("disabled", true);
					}
				}
			});
			// 发布按钮
			$(".publish-btn").click(function(e){
				$(".box").slideDown();
				e.stopPropagation();
			});
			$(".nextbtn").click(function(){
				var isPicNews = $('#isPicNews').is(':checked')?1:0;
				var showTime = $("#datatimeid").val();
				var articleId = $("#articleId").html();
				$.ajax({
					type:"post",
					url:self.baseurl+"/news/publishNews",
					async:true,
					data: {
						id: articleId,
						showTime: showTime===""?new Date():new Date(showTime),
						isRollImg: isPicNews
					},
					success: function(res){
						alert(res.msg);
						$(".box").slideUp();
					},
					error: function(error){
						
					}
				});
				
			});
			// 新闻类型的change事件
			$("input[name='newstype']").change(function(){
				var value = $(this).val();
				self.ajaxEdit({
					newsTypeID: value,
					picUrl: ""
				});
				// 隐藏图片展示
				$("#tiTuImg").attr("src", "");
				$(".img-wrapper").hide();
				// 显示file表单
				self.showFileInput();
				$(".writeCover-previewWrapper").show();
				$("#isPicNews").attr("checked", false);
				
				switch (value){
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
						$("#isPicNews").attr("disabled", false);
						$("#isPicNewsLable").removeClass("linethrough");
						$(".noticeInfo").html("图片像素要求334*193");
						break;
					case '6':
						$("#isPicNews").attr("disabled", true);
						$("#isPicNewsLable").addClass("linethrough");
						$(".noticeInfo").html("图片像素宽高要求287*69");		
						break;
					case '7':
						$("#isPicNews").attr("disabled", true);
						$("#isPicNewsLable").addClass("linethrough");
						$(".noticeInfo").html("图片像素宽高要求222:148");		
						break;
					case '8':
						$("#isPicNews").attr("disabled", true);
						$("#isPicNewsLable").addClass("linethrough");
						$(".noticeInfo").html("图片像素宽高要求186:63");		
						break;
					default:
						break;
				}
			});
			
			// 题图的change事件
			$("#tiTuFileInput").change(function(){
				// 获取图片的大小-->上传图片
				var input = document.getElementById("inputid");  
				self.imgSize(input, 'tiTuFileInput', self.uploadTiTu);
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
				if(length === 0){
					// 不允许发布
					//alert("不允许发布")
					$(".publish-btn").removeClass("publish-yes").addClass("publish-no");
					$(".publish-btn").attr("disabled", true);
				}else{
					var contentVallength = self.ue.getContent().length;
					if(contentVallength!=0){
						$(".publish-btn").removeClass("publish-no").addClass("publish-yes");
						$(".publish-btn").attr("disabled", false);
					}
				}
				if(length > 100){
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
				// 获取类型值
				var newstype = $("input[name='newstype']:checked").val();
				self.ajaxEdit({title: textareaVal,newsTypeID:newstype});
			}, 1000));
			self.ue.addListener('focus',function(editor){
				$(".box").slideUp();
			});
			
			// 富文本框的内容改变事件
			self.ue.addListener("contentChange",CommonUtils.throttle(function(){
				/*if(self.firstgetdata === 1 && $("#articleId").html()!=-1){
					self.firstgetdata = 2;
					return;
				}*/
				var contentVal = self.ue.getContent();
				if(contentVal.length===0){
					//alert("不允许发布");
					$(".publish-btn").removeClass("publish-yes").addClass("publish-no");
					$(".publish-btn").attr("disabled", true);
				}else{
					var textareaVallength = self.textarea.val().length;
					if(textareaVallength!=0){
						$(".publish-btn").removeClass("publish-no").addClass("publish-yes");
						$(".publish-btn").attr("disabled", false);
					}
				}
				// 获取类型值
				var newstype = $("input[name='newstype']:checked").val();
				self.ajaxEdit({content: contentVal, newsTypeID:newstype});
			}, 2000));
			
			// 替换删除的click事件
			$("#resettiTuFileInput").change(function(){
				// 获取图片的大小-->上传图片
				var input = document.getElementById("resetInputid");  
				self.imgSize(input, 'resettiTuFileInput', self.uploadTiTu);
				
				//self.uploadTiTu("resettiTuFileInput");
			});
			$(".remove").click(function(){
				self.showFileInput();
				$(".writeCover-previewWrapper").show();
				$("#tiTuImg").attr("src", "");
				$(".img-wrapper").hide();
				self.ajaxEdit({
					picUrl: ""
				});
			});
		},
		// 获取新闻是否是图片新闻
		setIsPicNews: function(id, newsType){
			var self = this;
			switch (newsType){
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					$("#isPicNews").attr("disabled", false);
					$("#isPicNewsLable").removeClass("linethrough");
					$(".noticeInfo").html("图片像素要求334*193");
					break;
				case 6:
					$("#isPicNews").attr("disabled", true);
					$("#isPicNewsLable").addClass("linethrough");
					$(".noticeInfo").html("图片像素宽高要求287*69");		
					break;
				case 7:
					$("#isPicNews").attr("disabled", true);
					$("#isPicNewsLable").addClass("linethrough");
					$(".noticeInfo").html("图片像素宽高要求222:148");		
					break;
				case 8:
					$("#isPicNews").attr("disabled", true);
					$("#isPicNewsLable").addClass("linethrough");
					$(".noticeInfo").html("图片像素宽高要求186:63");		
					break;
				default:
					break;
			}
			$.ajax({
				type:"post",
				url:self.baseurl+"/rollImg/queryRollImgByNewsID/"+id,
				async:true,
				success: function(res){
					console.log(res);
					if(res.rows.length>0){
						// 是图片新闻
						$("#isPicNews").attr("checked", true);
					}else{
						// 不是图片新闻
						$("#isPicNews").attr("checked", false);
					}
				},
				error: function(error){
					
				}
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
							// 发布按钮状态,title and content都不为空值，设置发布按钮为可用状态
							if(res.rows[0].title!="" && res.rows[0].content!=""){
								$(".publish-btn").removeClass("publish-no").addClass("publish-yes");
								$(".publish-btn").attr("disabled", false);
							}
							// 题图赋值
							if(res.rows[0].picUrl != null && res.rows[0].picUrl != ""){
								$(".writeCover-previewWrapper").hide();
						        	$("#tiTuImg").attr("src", self.baseurl+"/upload/"+res.rows[0].picUrl);
						        	$(".img-wrapper").show();
							}
							// 判断文章发布状态
							if(res.rows[0].status===0){
								$(".publish-btn").html("更新<i class='icon-chevron-down'></i>");
							}
							// 类型赋值
							$("input[name='newstype'][value="+res.rows[0].newsTypeID+"]").attr("checked",true);
							// 专题标签 todo
							var activityIDs = res.rows[0].activityIDs;
							for(var i=0;i<activityIDs.length;i++){
								$("input[name='special'][value="+activityIDs[i]+"]").attr("checked",true);
							}
							
							// 是否是轮播图赋值
							self.setIsPicNews(res.rows[0].id, res.rows[0].newsTypeID);
							// 时间选择框赋值
							if(res.rows[0].showTime != null){
								var time = CommonUtils.timeStampToDate(res.rows[0].showTime);
								$("#datatimeid").val(time);
							}
							// textarea赋值							
							self.textarea.val(res.rows[0].title);
							self.initTextArea();
							self.ue.setContent(res.rows[0].content);
							/*if(res.rows[0].content == ""){
								self.firstgetdata = 2;
							}else{
								console.log("-----------");
								console.log(res.rows[0].content);
					            self.ue.setContent(res.rows[0].content);
							}*/
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