var PictureNews = function(){
	return {
		baseurl: "",
		$table: null,
		init: function(){
			this.baseurl = CommonUtils.baseUrl;
			$table = $("#picNewstable");
			this.initTable();
		},
		initTable: function(){
			var self = this;
			$table.bootstrapTable({
				dataType : "json",	
				cache : false, // 不缓存
				striped : true, // 隔行加亮
				url: self.baseurl+"/rollImg/queryAllRollImg",
                sidePagination: "server",
                toolbar: "#toolbar",
                queryParams: function(params) {
                	return params;
                },
				columns : [{
					field : 'id',
					align : 'center',
					valign : 'middle',
					title : "文章ID",
				},{
					field : 'title',
					align : 'left',
					valign : 'middle',
					title : "标题"
				},{
					field : 'picUrl',
					align : 'center',
					valign : 'middle',
					title : "图片",
					formatter: function(value, row, e){
						return "<img style='width: 100px;' src="+self.baseurl+"/upload/"+value+" />";
					}
				},{
					field : 'count',
					align : 'center',
					valign : 'middle',
					title : "访问量",
					formatter: function(value, row, e){
						return "<span class='badge badge-warning'>"+row.count+"</span>";
					}
				},{
					field : 'sort',
					align : 'center',
					valign : 'middle',
					title : "排序(点击更改)",
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
					field : 'isShow',
					align : 'center',
					valign : 'middle',
					title : "是否显示(点击切换)",
					width: 100,
					formatter: function(value, row, e){
						var newsID = row.id;
						var text = "显示";
						if(!value){
							text = "不显示";
						}
						return "<button id='isShow' class='btn btn-primary btn-mini'>"+text+"</button>";
					},
					events : {
						'click #isShow': function(e, value, row) {
							var text = row.isShow===1?"不显示":"显示";
							//row.isShow = row.isShow===1?0:1;
							$(this).html(text);
							$.ajax({
								type:"post",
								url: self.baseurl+"/rollImg/updateRollImg",
								async:true,
								data: {
									newsID: row.id,
									isShow: row.isShow===1?0:1,
									sort: row.sort
								},
								success: function(res){
									$table.bootstrapTable("refresh");
								},
								error: function(error){
									
								}
							});
						}
					}
				},{
					field : 'operate',
					align : 'center',
					valign : 'middle',
					title : "操作",
					width: 100,
					formatter: function(value, row, index){
						return ["<a class='btn btn-primary btn-mini' target='_blank' href=/committeewb/news/edit/"+row.id+">编辑</a>",
						" <button id='remove' class='btn btn-danger btn-mini'>删除</button>",].join("");
					},
					events : {
						'click #remove': function(e, value, row) {
							$.ajax({
								type:"post",
								url: self.baseurl+"/rollImg/deleteRollImg",
								async:true,
								data: {
									newsIDs: row.id
								},
								success: function(res){
									$table.bootstrapTable("refresh");
								},
								error: function(error){
									
								}
							});
						}
					}
				}],
				onEditableSave: function(field, row, oldValue, $el){
					$.ajax({
	                    type: "post",
	                    url: self.baseurl+"/rollImg/updateRollImg",
	                    dataType: 'JSON',
	                    data: {
	                    	newsID: row.id,
							sort: row.sort,
							isShow: row.isShow
	                    },
	                    success: function (res, status) {
	                    	
	                    },
	                    error: function () {
	                    	
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
			});
		}
	};
}();
