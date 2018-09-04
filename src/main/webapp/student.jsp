<%--
  Created by IntelliJ IDEA.
  User: 张元亮
  Date: 2018/8/16
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm-demo</title>
</head>
<body>
    <c:if test="${not empty student}">
        ${student.id} &nbsp; ${student.name}
    </c:if>
    <c:if test="${empty student}">
       数据为空，请坚持数据！
    </c:if>
</body>
</html>
