<%--
  Created by IntelliJ IDEA.
  User: walba
  Date: 2017-11-23
  Time: 오전 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>doD</title>
</head>
<body>
    <h2>doD</h2>
    <p>model.addAttribute(vo) : ${productVO.name}</p>

    <c:out value="${productVO}" ></c:out>

    <br/>
    <p>model.addAttribute("vo", vo) : ${vo}</p>
</body>
</html>
