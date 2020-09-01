<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/31
  Time: 9:13
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
<table>
    <tr>
        <td colspan="10">
            <form action="list">
                姓名:<input type="text" name="name">
                <input type="submit" value="查询">
                <a href="add.jsp">添加</a>
            </form>
            <a href="list?purpose=1">住宅</a>
            <a href="list?purpose=2">商住两用</a>
            <a href="list?purpose=3">写字楼</a>
        </td>
    </tr>
    <tr>
        <td>编号</td>
        <td>房主</td>
        <td>地址</td>
        <td>图片</td>
        <td>用途</td>
        <td>面积</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${plist.list}" var="tt">
        <tr>
            <td>${tt.hid}</td>
            <td>${tt.owner.name}</td>
            <td>${tt.address}</td>
            <td><img src="lookImg?path=${tt.pic}" alt="图片受损"></td>
            <td>
                <c:if test="${tt.purpose==1}">住宅</c:if>
                <c:if test="${tt.purpose==2}">商住两用</c:if>
                <c:if test="${tt.purpose==3}">写字楼</c:if>
            </td>
            <td>${tt.acreage}</td>
            <td><a href="del?hid=${tt.hid}">删除</a>
                <a href="find?hid=${tt.hid}">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="10">
            当前 ${plist.pageNum}/${plist.pages}页,
            共 ${plist.total}条记录,
            <a href="list?pageNum=1">首页</a>
            <a href="list?pageNum=${plist.pageNum-1}">上一页</a>
            <a href="list?pageNum=${plist.pageNum+1}">下一页</a>
            <a href="list?pageNum=${plist.pages}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
