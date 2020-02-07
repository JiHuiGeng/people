<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/7 0007
  Time: 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>

</head>
<body>
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:forEach items="${peopleList}" var="peopleList">
        <tr>
            <td>${peopleList.id}</td>
            <td>${peopleList.name}</td>
            <td>${peopleList.age}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
