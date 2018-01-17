var WebSetting = function () {
    return {
		baseurl: "",
		slideDownAlert: function(msg){
			var self = this;
			$(".alert .alertMsg").html(msg);
			$(".alert").slideDown();
			setTimeout(function(){
				self.slideUpAlert();
			}, 1500);
		},
		slideUpAlert: function(){
			$(".alert").slideUp();
		},
        init: function () {
            this.baseurl = CommonUtils.baseUrl;
            console.log("WebSetting init");
        },
        initEvent: function(){
        	var self = this;
       	 	$("#addNav").click(function(){
	        		if($(this).html() === "添加"){
	        			$(".addNavInput").fadeIn();
	        			$(this)
	        				.html("隐藏")
	        				.removeClass("btn-success")
	        				.addClass("btn-primary");
	        		}else{
	        			$(".addNavInput").fadeOut();
	        			$(this).html("添加");
	        			$(this)
	        				.html("添加")
	        				.removeClass("btn-primary")
	        				.addClass("btn-success");
	        		}
        		});
	        	$("#saveAddNav").click(function(){
	        		// 设置保存按钮不可用，防止连续点击
	        		document.getElementById("saveAddNav").disabled = true;
	        		var navName = $(".navName").val();
	        		var navLink = $(".navLink").val();
	        		var navPos = $(".navPos").val();
	        		console.log(navName);
	        		console.log(navLink);
	        		console.log(navPos);
	        		if(navName === ""){
	        			alert("名称不能为空");
	        			document.getElementById("saveAddNav").disabled = false;
	        			return;
	        		}
	        		if(navLink === ""){
	        			alert("链接不能为空");
	        			document.getElementById("saveAddNav").disabled = false;
	        			return;
	        		}
	        		if(navPos === ""){
	        			navPos = 0;
	        		}
	        		$(".navName").attr("value", "");
	        		$(".navLink").attr("value", "");
	        		$(".navPos").attr("value", "");
	        		$.ajax({
	        			type: "post",
	        			url: self.baseurl+"/nav/insertNav",
	        			async: true,
	        			data: {
	        				name: navName,
	        				jumpLink: navLink,
	        				sort: navPos
	        			},
	        			success: function(res){
	        				document.getElementById("saveAddNav").disabled = false;
	        				if(res.code === 200){
	        					self.slideDownAlert(res.msg);
	        					self.initNavTable();
	        				}else{
	        					self.slideDownAlert(res.msg);
	        				}
	        			},
	        			error: function(){
	        				document.getElementById("saveAddNav").disabled = false;
	        			}
	        		});
	        	});
	        	// 友情链接添加功能
	        	$("#addFriendLink").click(function(){
	        		if($(this).html() === "添加"){
	        			$(".addFriendLinkInput").fadeIn();
	        			$(this)
	        				.html("隐藏")
	        				.removeClass("btn-success")
	        				.addClass("btn-primary");
	        		}else{
	        			$(".addFriendLinkInput").fadeOut();
	        			$(this)
	        				.html("添加")
	        				.removeClass("btn-primary")
	        				.addClass("btn-success");
	        		}
	        	});
	        	
	        	//专题标签添加功能
	        	$("#addSpecial").click(function(){
	        		if($(this).html() === "添加"){
	        			$(".addSpecialInput").fadeIn();
	        			$(this)
	        				.html("隐藏")
	        				.removeClass("btn-success")
	        				.addClass("btn-primary");
	        		}else{
	        			$(".addSpecialInput").fadeOut();
	        			$(this)
	        				.html("添加")
	        				.removeClass("btn-primary")
	        				.addClass("btn-success");
	        		}
	        	});
	        	// 友情链接保存功能
	        	$("#saveAddFriendLink").click(function(){
	        		// 设置保存按钮不可用，防止连续点击
	        		document.getElementById("saveAddFriendLink").disabled = true;
	        		var friendLinkName = $(".friendLinkName").val();
	        		var friendLinkUrl = $(".friendLinkUrl").val();
	        		var friendLinkPic = $(".friendLinkPic").val();
	        		console.log(friendLinkName);
	        		console.log(friendLinkUrl);
	        		console.log(friendLinkPic);
	        		if(friendLinkName === ""){
	        			alert("名称不能为空");
	        			document.getElementById("saveAddFriendLink").disabled = false;
	        			return;
	        		}
	        		if(friendLinkUrl === ""){
	        			alert("链接不能为空");
	        			document.getElementById("saveAddFriendLink").disabled = false;
	        			return;
	        		}
	        		if(friendLinkPic === ""){
	        			alert("图片不能为空");
	        			document.getElementById("saveAddFriendLink").disabled = false;
	        			return;
	        		}
	        		// 组装FormData对象
					var form = document.getElementById("friendLinkForm");
					var formData = new FormData(form);
					formData.append("type", 1);
					
	        		$(".friendLinkName").attr("value", "");
	        		$(".friendLinkUrl").attr("value", "");
	        		$(".friendLinkPic").attr("value", "");
	        		
	        		var xhr = new XMLHttpRequest();
					xhr.open("POST", self.baseurl+"/banner/insertBanner", true);
					
					 //注册相关事件回调处理函数
					xhr.onload = function(e) { 
					    if(this.status == 200||this.status == 304){
					        console.log(this.responseText);
					        var res = window.JSON.parse(this.responseText);
					        if(res.code === 200){
	                        	self.slideDownAlert(res.msg);
					        	
					        	document.getElementById("saveAddFriendLink").disabled = false;
					        	self.initFriendLinkTable();
					        }else{
					        	self.slideDownAlert(res.msg);
					        }
					    }
					};
					/*xhr.ontimeout = function(e) { ... };
					xhr.onerror = function(e) { ... };
					xhr.upload.onprogress = function(e) { ... };*/
					//发送数据
					xhr.send(formData);
	        	});
	        	// 专题标签保存功能
	        	$("#saveAddSpecial").click(function(){
	        		// 设置保存按钮不可用，防止连续点击
	        		document.getElementById("saveAddSpecial").disabled = true;
	        		var specialName = $(".SpecialName").val();
	        		var specialPic = $(".specialPic").val();
	        		console.log(specialName);
	        		console.log(specialPic);
	        		if(specialName === ""){
	        			alert("名称不能为空");
	        			document.getElementById("saveAddSpecial").disabled = false;
	        			return;
	        		}
	        		if(specialPic === ""){
	        			alert("图片不能为空");
	        			document.getElementById("saveAddSpecial").disabled = false;
	        			return;
	        		}
	        		// 组装FormData对象
					var form = document.getElementById("specialForm");
					var formData = new FormData(form);
					formData.append("sort", 0);
					
	        		$(".specialName").attr("value", "");
	        		$(".specialPic").attr("value", "");
	        		
	        		var xhr = new XMLHttpRequest();
					xhr.open("POST", self.baseurl+"/activity/insertActivity", true);
					
					 //注册相关事件回调处理函数
					xhr.onload = function(e) { 
					    if(this.status == 200||this.status == 304){
					        console.log(this.responseText);
					        var res = window.JSON.parse(this.responseText);
					        if(res.code === 200){
	                        	self.slideDownAlert(res.msg);
					        	
					        	document.getElementById("saveAddSpecial").disabled = false;
					        	self.initSpecialtable();
					        }else{
					        	self.slideDownAlert(res.msg);
					        }
					    }
					};
					//发送数据
					xhr.send(formData);
	        	});
        },
        initTable: function(){// 初始化表格
        	var self = this;
        	// 网站设置
        	$('#baseinfotable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				columns : [ {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "id"
				},{
					field : 'logoUrl',
					align : 'center',
					valign : 'middle',
					title : "logo图标",
					formatter : function(value, row, index) {
						return "<img class='baseinfo_img' style='width:100px;' src="+ self.baseurl+"/upload/"+value + " />"
					}
				}, {
					field : 'titleUrl',
					align : 'center',
					valign : 'middle',
					title : "标题图标",
					formatter : function(value, row, index) {
						return "<img class='baseinfo_img' style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
					}
				}, {
					field : 'backgroundUrl',
					align : 'center',
					valign : 'middle',
					title : "背景图片",
					formatter : function(value, row, index) {
						return "<img class='baseinfo_img' style='width:100px;' src=" + self.baseurl+"/upload/"+ value + " />"
					}
				}, {
					field : 'field1',
					align : 'center',
					valign : 'middle',
					title : "字段1"
				}, {
					field : 'field2',
					align : 'center',
					valign : 'middle',
					title : "字段2"
				}, {
					field : 'field3',
					align : 'center',
					valign : 'middle',
					title : "字段3"
				}, {
					field : 'field4',
					align : 'center',
					valign : 'middle',
					title : "字段4"
				}, {
					field : 'field5',
					align : 'center',
					valign : 'middle',
					title : "字段5"
				}],
				data : []
			});
			this.initWebInfoTable();
			// 导航栏
			$('#navinfotable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				/*toolbar: "#toolbar",*/
				//是否显示分页（*）  
                pagination: true,   
                 //是否启用排序  
                sortable: false, 
                 //排序方式 
                sortOrder: "asc",
                pageSize: 10,  
                //可供选择的每页的行数（*）    
                pageList: [10, 25, 50, 100],
				columns : [ {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "导航id"
				},{
					field : 'name',
					align : 'center',
					valign : 'middle',
					title : "名称",
					editable: {
	                    type: 'text',
	                    title: '名称',
	                    mode: 'inline',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'jumpLink',
					align : 'center',
					valign : 'middle',
					title : "链接",
					editable: {
	                    type: 'text',
	                    title: '链接',
	                    mode: 'inline',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'sort',
					align : 'center',
					valign : 'middle',
					title : "排序",
					editable: {
	                    type: 'text',
	                    title: '排序',
	                    mode: 'inline',
	                    validate: function (v) {
	                        if (!v) return '排序不能为空';
	                        if (isNaN(v)) return '排序必须是数字';
	                    }
	                }
				},{
					field : 'operate',
					align : 'center',
					valign : 'middle',
					title : "操作",
					visible: false,
					formatter : function(value, row, index) {
						return "<button id='remove' class='btn btn-danger btn-mini'><i class='icon-remove'></i>  删除</button>";
					},
					events : {
						'click #remove': function(e, value, row) {
							if(confirm("确定删除吗?")){
								$.ajax({
									type:"get",
									url: self.baseurl+"/nav/deleteNav",
									async:true,
									data: {
										id: row.id
									},
									success: function(res){
										self.slideDownAlert(res.msg);
										self.initNavTable();
									},
									error: function(){
										self.slideDownAlert("删除失败");
									}
								});
							}
							
						}
					}
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/nav/updateNav",
	                    data: row,
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (status == "success") {
	                        		self.initNavTable();
	                        		self.slideDownAlert("修改数据成功");
	                        }
	                    },
	                    error: function () {
	                   	 	self.slideDownAlert("修改失败");
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
				data : []
			});
			this.initNavTable();
			// banner图
			$('#bannertable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				columns : [ {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "id"
				},{
					field : 'name',
					align : 'center',
					valign : 'middle',
					title : "名称",
					editable: {
	                    type: 'text',
	                    title: '名称',
	                    mode: 'inline',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'picUrl',
					align : 'center',
					valign : 'middle',
					title : "图片(像素1200*197)",
					/*formatter : function(value, row, index) {
						return "<img style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
					},*/
					formatter : function(value, row, index) {
						return ["<img style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
							,"&nbsp;&nbsp;<form class='uploadForm' id=bannerform enctype='multipart/form-data'><div class='myinput'><i class='modifybtn'>修改</i><input name='picFile' type='file' id='bannnerinput'  accept='image/jpeg,image/png,image/gif' /></div></form>"
						].join("");
					},
					events : {
						'change #bannnerinput': function(e, value, row){
							// todo
							
							// 组装FormData对象
							var form = document.getElementById("bannerform");
							var formData = new FormData(form);
							formData.append("id", row.id);
							formData.append("name", row.name);
							formData.append("jumpLink", row.jumpLink);
							formData.append("type", 0);
							
							var xhr = new XMLHttpRequest();
							xhr.open("POST", self.baseurl+"/banner/updateBanner", true);
							
							 //注册相关事件回调处理函数
							xhr.onload = function(e) { 
							    if(this.status == 200||this.status == 304){
							        console.log(this.responseText);
							        var res = window.JSON.parse(this.responseText);
							        if(res.code === 200){
							        		self.slideDownAlert(res.msg);
							        		self.initBannnerTable();
							        }else{
							        	self.slideDownAlert(res.msg);
							        }
							    }
							};
							
							//发送数据
							xhr.send(formData);
						}
					}
				}, {
					field : 'jumpLink',
					align : 'center',
					valign : 'middle',
					title : "链接",
					editable: {
	                    type: 'text',
	                    title: '链接',
	                    mode: 'inline',
	                    
	                }
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/banner/updateBanner",
	                    data: {
	                    	id: row.id,
	                    	name: row.name,
	                    	jumpLink: row.jumpLink
	                    },
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (status == "success") {
	                        		self.slideDownAlert("修改数据成功!");
	                        		self.initBannnerTable();
	                        }
	                    },
	                    error: function () {
	                    	self.slideDownAlert("修改失败!");
	                        //alert('修改失败');
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
				data : []
			});
			this.initBannnerTable();
			// 友情链接
			$('#friendLinktable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				//是否显示分页（*）  
                pagination: true,   
                 //是否启用排序  
                sortable: false, 
                 //排序方式 
                sortOrder: "asc",
                pageSize: 10,  
                //可供选择的每页的行数（*）    
                pageList: [10, 25, 50, 100],
                toolbar: "#toolbar_friendLink",
				columns : [ {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "id"
				},{
					field : 'name',
					align : 'center',
					valign : 'middle',
					title : "名称",
					editable: {
	                    type: 'text',
	                    title: '名称',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'picUrl',
					align : 'center',
					valign : 'middle',
					title : "图片(像素186*63)",
					width: 200,
					formatter : function(value, row, index) {
						return ["<img style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
							,"&nbsp;&nbsp;<form class='uploadForm' id=friendform"+row.id+" enctype='multipart/form-data'><div class='myinput'><i class='modifybtn'>修改</i><input name='picFile' type='file' id='uploadfileinput'  accept='image/jpeg,image/png,image/gif' /></div></form>"
						].join("");
					},
					events : {
						'change #uploadfileinput': function(e, value, row){
							// 组装FormData对象
							var form = document.getElementById("friendform"+row.id);
							var formData = new FormData(form);
							formData.append("id", row.id);
							formData.append("name", row.name);
							formData.append("jumpLink", row.jumpLink);
							
							var xhr = new XMLHttpRequest();
							xhr.open("POST", self.baseurl+"/banner/updateBanner", true);
							
							 //注册相关事件回调处理函数
							xhr.onload = function(e) { 
							    if(this.status == 200||this.status == 304){
							        console.log(this.responseText);
							        var res = window.JSON.parse(this.responseText);
							        if(res.code === 200){
							        		self.slideDownAlert(res.msg);
							        		self.initFriendLinkTable();
							        }else{
							        	self.slideDownAlert(res.msg);
							        }
							    }
							};
							//发送数据
							xhr.send(formData);
						}
					}
				}, {
					field : 'jumpLink',
					align : 'center',
					valign : 'middle',
					title : "链接",
					editable: {
	                    type: 'text',
	                    title: '链接',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'sort',
					align : 'center',
					valign : 'middle',
					title : "排序",
					editable: {
	                    type: 'text',
	                    title: '排序',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '排序不能为空';
	                        if (isNaN(v)) return '排序必须是数字';
	                    }
	                }
				},{
					field : 'operate',
					align : 'center',
					valign : 'middle',
					title : "操作",
					width: 100,
					formatter : function(value, row, index) {
						return "<button id='remove' class='btn btn-danger btn-mini'><i class='icon-remove'></i>  删除</button>";
					},
					events : {
						'click #remove': function(e, value, row) {
							if(confirm("确定删除吗?")){
								$.ajax({
									type:"post",
									url: self.baseurl+"/banner/deleteBanner",
									async:true,
									data: {
										id: row.id
									},
									success: function(res){
										if(res.code === 200){
											self.slideDownAlert("删除成功！");
											self.initFriendLinkTable();
										}else{
	                            				self.slideDownAlert(res.msg);
										}
										
									}
								});
							}
						}
					}
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/banner/updateBanner",
	                    data: {
	                    	id: row.id,
	                    	name: row.name,
	                    	jumpLink: row.jumpLink,
	                    	sort: row.sort
	                    },
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (status == "success") {
	                        	self.initBannnerTable();
	                            self.slideDownAlert("修改数据成功");
	                        }
	                    },
	                    error: function () {
	                       	self.slideDownAlert("修改失败");
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
				data : []
			});
			this.initFriendLinkTable();
			// 水印设置
			$('#waterMarktable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				columns : [{
					field : 'isWatermark',
					align : 'center',
					valign : 'middle',
					title : "水印状态",
					formatter : function(value, row, index) {
						var text = "开启";
						if(value == false){
							text = "关闭";
						}
						return ["<button id='waterBtn' class='btn btn-primary'>"+text+"</button>"].join("");
					},
					events: {
						'click #waterBtn': function(e, value, row){
							var text = $("#waterBtn").html();
							var isMark = null;
							if(text === "关闭"){
								isMark = true;
							}else{
								isMark = false;
							}
							$.ajax({
								type:"post",
								url:self.baseurl+"/news/watermark",
								async:true,
								data: {
									isWatermark: isMark
								},
								success: function(res){
									if(res.code == 200){
										self.slideDownAlert(res.msg);
							        	self.initWaterMarkTable();
									}
								},
								error: function(error){
									
								}
							});
						}
					}
				},{
					field : 'watermarkType',
					align : 'center',
					valign : 'middle',
					title : "水印类型",
					editable: {
						type: "select",
            			source: [{ value: "text", text: "底部文本" }, { value: "icon", text: "底部图标" }, {value:"alltext",text:"全图文本"}, {value:"allicon",text:"全图图标"}],
	                    title: '水印类型',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				},{
					field : 'watermarkText',
					align : 'center',
					valign : 'middle',
					title : "水印文字",
					editable: {
	                    type: 'text',
	                    title: '水印文字',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				},{
					field : 'watermarkImgPath',
					align : 'center',
					valign : 'middle',
					title : "水印图片(像素100*30)",
					formatter : function(value, row, index) {
						return ["<img style='width:100px;' src="+ self.baseurl+ value + " />"
							,"&nbsp;&nbsp;<form class='uploadForm' id=friendform"+row.id+" enctype='multipart/form-data'><div class='myinput'><i class='modifybtn'>修改</i><input name='picFile' type='file' id='uploadfileinput'  accept='image/jpeg,image/png,image/gif' /></div></form>"
						].join("");
					},
					events : {
						'change #uploadfileinput': function(e, value, row){
							// 组装FormData对象
							var form = document.getElementById("friendform"+row.id);
							var formData = new FormData(form);
							
							var xhr = new XMLHttpRequest();
							xhr.open("POST", self.baseurl+"/news/watermark", true);
							
							 //注册相关事件回调处理函数
							xhr.onload = function(e) { 
							    if(this.status == 200||this.status == 304){
							        console.log(this.responseText);
							        var res = window.JSON.parse(this.responseText);
							        if(res.code === 200){
							        		self.slideDownAlert(res.msg);
							        		self.initWaterMarkTable();
							        }else{
							        	self.slideDownAlert(res.msg);
							        }
							    }
							};
							//发送数据
							xhr.send(formData);
						}
					}
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/news/watermark",
	                    data: {
	                    	watermarkType: row.watermarkType,
	                    	watermarkText: row.watermarkText
	                    },
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (res.code == 200) {
	                        	self.slideDownAlert(res.msg);
							    self.initWaterMarkTable();
	                        }
	                        self.slideDownAlert(res.msg);
	                    },
	                    error: function () {
	                       	
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
				data : []
			});
			this.initWaterMarkTable();
			
			// 专题标签
			$('#specialtable').bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				//是否显示分页（*）  
                pagination: true,   
                 //是否启用排序  
                sortable: false, 
                 //排序方式 
                sortOrder: "asc",
                pageSize: 10,  
                //可供选择的每页的行数（*）    
                pageList: [10, 25, 50, 100],
                toolbar: "#toolbar_special",
				columns : [ {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "id"
				},{
					field : 'name',
					align : 'center',
					valign : 'middle',
					title : "名称",
					editable: {
	                    type: 'text',
	                    title: '名称',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '不能为空';
	                    }
	                }
				}, {
					field : 'url',
					align : 'center',
					valign : 'middle',
					title : "图片(像素287*69)",
					formatter : function(value, row, index) {
						return ["<img style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
							,"&nbsp;&nbsp;<form class='uploadForm' id=Specform"+row.id+" enctype='multipart/form-data'><div class='myinput'><i class='modifybtn'>修改</i><input name='picFile' type='file' id='uploadSpecfileinput'  accept='image/jpeg,image/png,image/gif' /></div></form>"
						].join("");
					},
					events : {
						'change #uploadSpecfileinput': function(e, value, row){
							// 组装FormData对象
							var form = document.getElementById("Specform"+row.id);
							var formData = new FormData(form);
							formData.append("id", row.id);
							formData.append("name", row.name);
							formData.append("sort", row.sort);
							
							var xhr = new XMLHttpRequest();
							xhr.open("POST", self.baseurl+"/activity/updateActivity", true);
							
							 //注册相关事件回调处理函数
							xhr.onload = function(e) { 
							    if(this.status == 200||this.status == 304){
							        console.log(this.responseText);
							        var res = window.JSON.parse(this.responseText);
							        if(res.code === 200){
							        		self.slideDownAlert(res.msg);
							        		self.initSpecialtable();
							        }else{
							        	self.slideDownAlert(res.msg);
							        }
							    }
							};
							//发送数据
							xhr.send(formData);
						}
					}
				}, {
					field : 'sort',
					align : 'center',
					valign : 'middle',
					title : "排序",
					editable: {
	                    type: 'text',
	                    title: '排序',
	                    mode: 'popup',
	                    validate: function (v) {
	                        if (!v) return '排序不能为空';
	                        if (isNaN(v)) return '排序必须是数字';
	                    }
	                }
				},{
					field : 'operate',
					align : 'center',
					valign : 'middle',
					title : "操作",
					width: 100,
					formatter : function(value, row, index) {
						return "<button id='removeSpec' class='btn btn-danger btn-mini'><i class='icon-remove'></i>  删除</button>";
					},
					events : {
						'click #removeSpec': function(e, value, row) {
							if(confirm("确定删除吗?")){
								$.ajax({
									type:"post",
									url: self.baseurl+"/activity/deleteActivity",
									async:true,
									data: {
										ids: row.id
									},
									success: function(res){
										if(res.code === 200){
											self.slideDownAlert("删除成功！");
											self.initSpecialtable();
										}else{
	                            				self.slideDownAlert(res.msg);
										}
										
									}
								});
							}
						}
					}
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/activity/updateActivity",
	                    data: {
	                    	id: row.id,
	                    	name: row.name,
	                    	sort: row.sort
	                    },
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (status == "success") {
	                        	self.initSpecialtable();
	                            self.slideDownAlert(res.msg);
	                        }
	                    },
	                    error: function () {
	                       	self.slideDownAlert("修改失败");
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
				data : []
			});
			this.initSpecialtable();
        },
        initSpecialtable: function(){
        	var self = this;
        	$.ajax({
        		type: "get",
        		url: self.baseurl+"/activity/queryAllActivity",
        		async:true,
        		success: function(res){
        			if (res.code == 200) {
						$('#specialtable').bootstrapTable('load', res.rows);
						
						// 加载图片的点击事件
						//self.initEvent();
					} else {
						
					}
        		},
        		error: function(err){
        			self.slideDownAlert("error");
        		}
        	});
        },
        initWaterMarkTable: function(){
        	var self = this;
        	$.ajax({
        		type:"get",
        		url: self.baseurl+"/news/queryWatermark",
        		async:true,
        		success: function(res){
        			var arr = [];
        			if(res.code === 200){
        				var data = {};
        				data.isWatermark = res.rows[0];
        				data.watermarkText = res.rows[1];
        				data.watermarkImgPath = res.rows[2];
        				data.watermarkType = res.rows[3];
        				arr.push(data);
        				$('#waterMarktable').bootstrapTable("load", arr);
        			}
        		}
        	});
        },
        initWebInfoTable: function(){
        	var self = this;
        	$.ajax({
        		type:"get",
        		url: self.baseurl+"/webInfo/queryWebInfo",
        		async:true,
        		success: function(res){
        			if (res.code == 200) {
						$('#baseinfotable').bootstrapTable('load', res.rows);
						// 初始化表单text数据
						$("input[name=id]").val(res.rows[0].id);
						$("input[name=field1]").val(res.rows[0].field1);
						$("input[name=field2]").val(res.rows[0].field2);
						$("input[name=field3]").val(res.rows[0].field3);
						$("input[name=field4]").val(res.rows[0].field4);
						$("input[name=field5]").val(res.rows[0].field5);
						
						// 加载图片的点击事件
						self.initEvent();
					} else {
						
					}
        		},
        		error: function(err){
        			self.slideDownAlert("error");
        		}
        	});
        },
        initNavTable: function(){
        	var self = this;
        	$.ajax({
        		type:"get",
        		url: self.baseurl+"/nav/queryAllNavs",
        		async:true,
        		success: function(res){
        			if (res.code == 200) {
						$('#navinfotable').bootstrapTable('load', res.rows);
					} else {
						
					}
        		},
        		error: function(err){
        			self.slideDownAlert("error");
        		}
        	});
        },
        initBannnerTable: function(){
        	var self = this;
        	$.ajax({
        		type:"POST",
        		url: self.baseurl+"/banner/queryAllBanners",
        		async:true,
        		data: {
        			type: 0
        		},
        		success: function(res){
        			if (res.code == 200) {
						$('#bannertable').bootstrapTable('load', res.rows);
						$("#bannerid").val(res.rows[0].id);
						$("#bannername").val(res.rows[0].name);
						$("#bannerlink").val(res.rows[0].jumpLink);
						
					} else {
						
					}
        		},
        		error: function(err){
        			self.slideDownAlert("error");
        		}
        	});
        },
        initFriendLinkTable: function(){
        	var self = this;
        	$.ajax({
        		type:"POST",
        		url: self.baseurl+"/banner/queryAllBanners",
        		async:true,
        		data: {
        			type: 1
        		},
        		success: function(res){
        			if (res.code == 200) {
						$('#friendLinktable').bootstrapTable('load', res.rows);
						/*$("#bannerid").val(res.rows[0].id);
						$("#bannername").val(res.rows[0].name);
						$("#bannerlink").val(res.rows[0].jumpLink);*/
						
					} else {
						
					}
        		},
        		error: function(err){
        			self.slideDownAlert("error");
        		}
        	});
        },
        initData: function(){// 初始化表格数据
        	
        	
        },
        initPostAjax: function(){
        	var self = this;
        	$("#modifybaseInfo").click(function(){
        		var options = {
					dataType: "json",
					type: "post",
					url: self.baseurl+"/webInfo/updateWebInfo",
					beforeSubmit: function(){
						console.log("正在上传");
					},
					success: function(res){
						if(res.code==200){
							self.initWebInfoTable();
        						self.slideDownAlert(res.msg);
						}else{
							self.slideDownAlert(res.msg);
						}
					},
					error: function(err){
						self.slideDownAlert("上传失败");
					}
				};
				$("#mybaseForm").ajaxSubmit(options);
        	});
        	
        	
        	$("#bannerModify").click(function(){
        		var options = {
					dataType: "json",
					type: "post",
					url: self.baseurl+"/banner/updateBanner",
					beforeSubmit: function(){
						console.log("正在上传");
					},
					success: function(res){
						if(res.code==200){
							self.initBannnerTable();
							self.slideDownAlert(res.msg);
						}else{
							self.slideDownAlert(res.msg);
						}
					},
					error: function(err){
						self.slideDownAlert("上传失败");
					}
				};
				$("#mybannerForm").ajaxSubmit(options);
        	});
    	}
	}
}();