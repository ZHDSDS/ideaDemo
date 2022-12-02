<%--
  Created by IntelliJ IDEA.
  User: ASINA
  Date: 2022/11/16
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="uploadFile" method="post" enctype="multipart/form-data">
    文件：<input name="myfile" type="file">
    <button>上传</button>
</form>
<form action="uploadFiles" method="post" enctype="multipart/form-data">
    文件：<input name="myfiles" type="file"><input name="myfiles" type="file"><input name="myfiles" type="file">
    <button>上传</button>
</form>
</body>
</html>
