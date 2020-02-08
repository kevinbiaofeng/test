<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增-视频管理</title>
	<link rel="stylesheet" href="${statics }/css/upload/jquery-ui.min.css"/>
	<link rel="stylesheet" href="${statics }/css/upload/jquery.fileupload.css" />
	<link rel="stylesheet" href="${statics }/css/upload/jquery.fileupload-ui.css" />
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<style>
		body{font-size: 13px;}
	 	table{border-collapse: collapse;border-spacing: 0; width: 100%;}
     	table tr th,td{border:1px solid #ccc;text-align: center;}
     	table tr th{background:#D4D4D4}
     	table tr:hover{background:#fafafa}
     	table tbody tr:nth-child(even){background:#DCD3D0}
	</style>
</head>

<body>
<form id="fileupload" action="${ctx }/video/upload" method="post" enctype="multipart/form-data" class="fileupload-processing">
	<div class="fileupload-buttonbar">
		<div class="fileupload-buttons">
			<span class="fileinput-button">
                <span>打开文件</span>
                <input type="file" name="file" multiple/>
            </span>
            <button type="button" class="start">全部上传</button>
            <button type="reset" class="cancel">取消上传</button>
            <button type="button" class="delete">删除</button>
            <input type="checkbox" class="toggle"/>
        </div>
        <div class="fileupload-progress fade" style="display:none">
            <div class="progress" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
            <div class="progress-extended">&nbsp;</div>
        </div>
    </div>
    
    <table role="presentation" style="width: 100%;"><tbody class="files"></tbody></table>
    
</form>
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade" style="opacity: 1;">
        <td style="width:30%;height:100px;">
            <span class="preview"></span>
        </td>
        <td style="width:40%;">
            原文件名：
 			<input name="fileName" value="{%=file.name%}" style="width:70%;"><br/>
            新文件名：
            <input name="newFileName" style="width:70%;"><br/>
			关键字(逗号隔开)：
            <input name="keywords" style="width:70%;"><br/>
			国籍：
            <input name="country" style="width:70%;"><br/>
			类型（多选项）：
            <input name="types" style="width:70%;"><br/>
            <strong class="error"></strong>
        </td>
        <td style="width:10%;">
            <p class="size">Processing...</p>
            <div class="progress"></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="start" disabled>上传</button>
            {% } %}
            {% if (!i) { %}
                <button class="cancel">删除</button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade" style="opacity: 1;">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>k
        </td>
        <td>
            <p class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
            </p>
            {% if (file.error) { %}
                <div><span class="error">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            <button class="delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>Delete</button>
            <input type="checkbox" name="delete" value="1" class="toggle">
        </td>
    </tr>
{% } %}
</script>
<script src="${statics }/js/upload/jquery.min.js"></script>
<script src="${statics }/js/upload/jquery-ui.min.js"></script>
<script src="${statics }/js/upload/tmpl.min.js"></script>
<script src="${statics }/js/upload/load-image.all.min.js"></script>
<script src="${statics }/js/upload/jquery.iframe-transport.js"></script>
<script src="${statics }/js/upload/jquery.fileupload.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-process.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-image.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-audio.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-video.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-validate.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-ui.js"></script>
<script src="${statics }/js/upload/jquery.fileupload-jquery-ui.js"></script>
<!--[if (gte IE 8)&(lt IE 10)]>
<script src="${statics }/js/upload/cors/jquery.xdr-transport.js"></script>
<![endif]-->
<script type="text/javascript">
  $(function() {
	$('#fileupload').fileupload({});
  });
</script>
</body>
</html>