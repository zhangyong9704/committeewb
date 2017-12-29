var NewsList = (function(){
	return {
		baseurl: "",
        selections: [],
        limit: 10,
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
        	console.log("NewsList init");
            this.baseurl = CommonUtils.baseUrl;
            // 初始化文章类型
            this.initCheckBox();
            this.initTable();
//          this.initEvent();
        },
        initCheckBox: function(){
        	var self = this;
        	var content = "<span class='title'>文章类型:</span>";
        	$.ajax({
        		type:"get",
        		url: self.baseurl+"/newsType/queryAllNewsType",
        		async:true,
        		success: function(res){
        			if(res.code === 200){
        				var length = res.rows.length;
        				for (var i = 0; i < length; i++) {
        					if(i===0){
        						temp = "<label class='checkbox inline'><input type='checkbox' name='optionCheckboxs' id="+ "inlineCheckbox"+res.rows[i].id +" value="+res.rows[i].id+" checked>"+res.rows[i].name+"</label>";
        					}else{
        						var temp = "<label class='checkbox inline'><input type='checkbox' name='optionCheckboxs' id="+ "inlineCheckbox"+res.rows[i].id +" value="+res.rows[i].id+">"+res.rows[i].name+"</label>";
        					}
							content += temp;
        				}
        				$(".my_checkbox").html("");
        				$(".my_checkbox").html(content);
        				// 设置单选按钮和复选框的change触发事件
        				self.initEvent();
        			}else{
        				
        			}
        		},
        		error: function(error){
        			
        		}
        	});
        },
        initEvent: function(){
        		console.log("NewsList initEvent");
        		$('input:radio[name="optionsRadios"]').change(function(){
				  $('#newslisttable').bootstrapTable("refresh", {query: {offset: 0,limit: self.limit}});
        		});
        		$('input:checkbox[name="optionCheckboxs"]').change(function(){
        			$('#newslisttable').bootstrapTable("refresh",{query: {offset: 0,limit: self.limit}});
        		});
        },
        initTable: function(){
        		console.log("NewsList initTable");
        		//self.baseurl+"/news/queryPageNews"
        		//"/shuweb/media/json/news.json",
        		var self = this;
        		var $table = $('#newslisttable');
        		var $remove = $('#remove');
        		var $reset = $('#reset');
        		$table.bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				url: self.baseurl+"/news/queryPageNews",
                pagination: true,   
                sortable: false,    
                sortOrder: "asc",    
                pageSize: self.limit,  
                pageList: [self.limit],
                sidePagination: "server",
                toolbar: "#toolbar",
                search: true,
                responseHandler: responseHandler,
                queryParams: function(params) {
                	console.log(params);
                	// offset: 偏移量 limit: 每页的数目 order: asc desc
                	// 获取类型和状态的值
                	var radioval=$('input:radio[name="optionsRadios"]:checked').val();
                	var checkboxval='';
                	var checkboxlen = $('input:checkbox[name="optionCheckboxs"]').length;
                	if(checkboxlen>0){
                		$('input:checkbox[name="optionCheckboxs"]:checked').each(function(index){ 
							checkboxval += ($(this).val()+',');
						});
						var checkboxvalarray = checkboxval.split(',');
                		checkboxvalarray.pop();
                		checkboxval = checkboxvalarray.join();
                	}else{
                		checkboxval = '1';
                	}
                	
                    return {
                		chooseStatus: radioval,
                		typeIDs: checkboxval,
                     	offset: params.offset,
                      	limit: params.limit,
                      	search: params.search,
                      	order: "desc"
                   };
                },
				columns : [{
					field : 'state',
					align : 'center',
					valign : 'middle',
					checkbox: true,
				}, {
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "文章ID",
					width: 60
				},{
					field : 'title',
					align : 'left',
					valign : 'middle',
					title : "标题",
					formatter: function(value, row, e){
						var val="";
						switch (row.newsTypeID){
							case 1:
								val+='[重点专注]';
								break;
							case 2:
								val+='[公告栏]';
								break;
							case 3:
								val+='[文件通知]';
								break;
							case 4:
								val+='[团青快讯]';
								break;
							case 5:
								val+='[蜀南青语]';
								break;
							case 6:
								val+='[专题活动]';
								break;
							case 7:
								val+='[青春剪影]';
								break;
							case 8:
								val+='[生活大家谈]';
								break;
							default:
								break;
						}
						
						if(row.isHavePic===1){
							return val+"&nbsp;&nbsp;<span style='color: blue;'>[图文]</span>"+row.title;
						}else{
							return val+"&nbsp;&nbsp;"+row.title;
						}
						
					}
				},{
					field : 'count',
					align : 'center',
					valign : 'middle',
					title : "访问量",
					width: 80,
					formatter: function(value, row, e){
						return "<span class='badge badge-warning'>"+row.count+"</span>";
					}
				},{
					field : 'createTime',
					align : 'center',
					valign : 'middle',
					title : "创建时间",
					width: 150,
					formatter: function(value, row, e){
						return CommonUtils.timeStampToDate(row.createTime);
					}
				},{
					field : 'showTime',
					align : 'center',
					valign : 'middle',
					title : "显示时间",
					width: 150,
					formatter: function(value, row, e){
						if(row.showTime == null){
							return "暂无";
						}
						return CommonUtils.timeStampToDate(row.showTime);
					}
				},{
					field : 'status',
					align : 'center',
					valign : 'middle',
					title : "状态",
					width: 100,
					formatter : function(value, row, index) {
						if(row.status === 0){
							return "<span class='label label-success'>已发布</span>";
						}else{
							return "<span class='label label-inverse'>草稿</span>";
						}
						
					}
				},{
					field : 'operate',
					align : 'center',
					valign : 'middle',
					title : "操作",
					width: 100,
					formatter: function(value, row, index){
						var text = "编辑";
						if(row.status===0){
							text = "更新";
						}
						return "<a target='_blank' href=/committeewb/news/edit/"+row.id+" class='btn btn-primary btn-mini'>"+text+"</a>";
					}
				}],
				data : []
			});
			//this.initDataTable();
			// 复选框的监听事件
			$table.on('check.bs.table uncheck.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function (e, rows) {
	            var ids = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
                    return row.id;
                }),
                func = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'union' : 'difference';
            	self.selections = _[func](self.selections, ids);
            	$remove.prop('disabled', !self.selections.length);
	            console.log(self.selections);
	        });
	        
	        $remove.click(function () {
	        	var len = self.selections.length;
	        	var info = len>1?"这样会删除 "+len+" 条数据,删除后不可恢复,请您谨慎操作!!!":"确定删除这条数据吗?";
	        	if(confirm(info)){
	        		$.ajax({
		            	type:"post",
		            	url: self.baseurl+"/news/deleteNews",
		            	async:true,
		            	data: {
		            		ids: self.selections.join(",")
		            	},
		            	success: function(res){
		            		console.log(res);
		            		if(res.code === 200){
		            			alert(res.msg);
		            			/*$table.bootstrapTable('remove', {
					                field: 'id',
					                values: self.selections
					            });*/
					           $table.bootstrapTable('refresh');
					            $remove.prop('disabled', true);
		            		}else{
		            			alert("删除失败");
		            		}
		            	},
		            	error: function(error){
		            		alert("删除失败");
		            	}
	            	});
	        	}
	            
	           
	        });
	        
	        function responseHandler(res) {
		        //加载服务器数据之前的处理程序，可以用来格式化数据。
		        //参数：res为从服务器请求到的数据。
		        $.each(res.rows, function (i, row) {
		            row.state = $.inArray(row.id, self.selections) !== -1;// $.inArray()搜索数组中指定值并返回它的索引（如果没有找到则返回-1）,相当于原声的indexof（）。
		        });
		        return res;
		    }
       },
       initDataTable: function(){
       		var self = this;
       		$.ajax({
       			type:"get",
       			url: self.baseurl+"/news/queryPageNews?typeID=1&chooseStatus=0&currentPage=1&pageSize=10&sort=1",
       			async:true,
       			success: function(res){
       				if(res.code === 200){
       					$('#newslisttable').bootstrapTable('load', res.data);
       				}
       			},
       			error: function(error){
       				
       			}
       		});
       }
	}
})()
