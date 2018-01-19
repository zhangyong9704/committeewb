var Lifechat = function(){
	return {
		baseurl: "",
		$table: null,
		init: function(){
			this.baseurl = CommonUtils.baseUrl;
			this.$table = $("#lifechattable");
			this.initTable();
		},
		initTable: function(){
			var self = this;
			self.$table.bootstrapTable({
				url: self.baseurl+"/lifeChat/queryLifeChat",
				sidePagination: "server",
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
					title : "图片（380*122）",
					formatter : function(value, row, index) {
						return ["<img style='width:100px;' src="+ self.baseurl+"/upload/"+ value + " />"
							,"&nbsp;&nbsp;<form class='uploadForm' id=friendform"+row.id+" enctype='multipart/form-data'><div class='myinput'><i class='modifybtn'>修改</i><input name='picFile' type='file' id='uploadfileinput' /></div></form>"
						].join("");
					},
					events : {
						'change #uploadfileinput': function(e, value, row){
							// 组装FormData对象
							var form = document.getElementById("friendform"+row.id);
							var formData = new FormData(form);
							formData.append("id", row.id);
							formData.append("name", row.name);
							
							var xhr = new XMLHttpRequest();
							xhr.open("POST", self.baseurl+"/lifeChat/updateLifeChat", true);
							
							 //注册相关事件回调处理函数
							xhr.onload = function(e) { 
							    if(this.status == 200||this.status == 304){
							        console.log(this.responseText);
							        var res = window.JSON.parse(this.responseText);
							        if(res.code === 200){
							        	self.$table.bootstrapTable("refresh");
							        	alert(res.msg);
							        }else{
							        	
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
	                    url: self.baseurl+"/lifeChat/updateLifeChat",
	                    data: {
	                    	id: row.id,
	                    	name: row.name
	                    },
	                    dataType: 'JSON',
	                    success: function (res, status) {
	                        if (status == "success") {
	                        	alert(res.msg);
	                        }
	                    },
	                    error: function () {
	                       	self.slideDownAlert("修改失败");
	                    },
	                    complete: function () {
	
	                    }
	                });
				},
			});
		}
	};
}()
