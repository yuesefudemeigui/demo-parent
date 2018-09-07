<%--
  Created by IntelliJ IDEA.
  User: 硕果
  Date: 2018/9/5
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>DeptList Info</h2>
<table>
    <tr>
        <th>id</th><th>deptname</th>
    </tr>
    <c:forEach items="${deptList}" var="d">
        <tr><td>${d.id}</td><td>${d.deptname}</td></tr>
    </c:forEach>
    <a href="/index?pageNum=1">首页</a>
    <a href="/index?pageNum=${pageInfo.prePage}">上一页</a>
    <c:forEach items="${pageInfo.navigatepageNums}" var="n" >
    <a href="/index?pageNum=${n}">${n}</a>
    </c:forEach>
    <a href="/index?pageNum=${pageInfo.nextPage}">下一页</a>
    <a href="/index?pageNum=${pageInfo.pages}">尾页</a>
</table>
</body>
</html>
