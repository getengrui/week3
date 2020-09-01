<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/31
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/index_work.css">
    <script type="text/javascript" src="js/jQuery.3.5.1.js"></script>
</head>
<body>
<form action="update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="hid" value="${house.hid}">
    坐落地址:<input type="text" name="address" value="${house.address}"><br>
    用途:<select name="purpose" id="yt">
    <option value="1">住宅</option>
    <option value="2">商住两用</option>
    <option value="3">写字楼</option>
    </select><br>
    房屋面积:<input type="text" name="acreage" value="${house.acreage}"><br>
    房主姓名:<div id="xm">

</div><br>
    图片:<input type="file" name="file"><br>
    <input type="submit" name="保存">
</form>
<script type="text/javascript">
    $.post("query",function (obj) {
        for (var x in obj){
            $("#xm").append("<input type='checkbox' name='oid' value="+obj[x].id+">"+obj[x].name);
        }
        $("#yt").val(${house.purpose});
    })
</script>
</body>
</html>
