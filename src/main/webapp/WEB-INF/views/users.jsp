<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<table border="1" class="table_dark">
    <tr>
        <th>Login</th>
        <th>Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.login}" />
            </td>
            <td>
                <c:out value="${user.name}" />
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/index">Home</a>
<%@include file="header.jsp" %>
</body>
</html>
