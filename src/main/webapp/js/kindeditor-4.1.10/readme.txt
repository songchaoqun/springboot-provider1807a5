var editor = null;
KindEditor.ready(function(K) {//将编辑器添加到文档中
	editor = K.create('#content', {
		cssPath : '<%=request.getContextPath()%>/js/kindeditor/plugins/code/prettify.css',//指定编辑器iframe document的CSS文件，用于设置可视化区域的样式。
		uploadJson : '<%=request.getContextPath()%>/js/kindeditor/jsp/upload_json.jsp', //指定上传文件的服务器端程序。
		fileManagerJson : '<%=request.getContextPath()%>/js/kindeditor/jsp/file_manager_json.jsp',//指定浏览远程图片的服务器端程序。
		allowFileManager : true,  //true时显示浏览远程服务器按钮 ;默认值: false  
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['example'].submit();
			});
			K.ctrl(self.edit.doc, 13, function() {
				self.sync();
				document.forms['example'].submit();
			});
		}
	});
	prettyPrint();
});