
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All languages</h1>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>creater</th>
        <th>current Version</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${languages}" var="lang">
        <tr>
            <td><a href="languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
            <td><c:out value="${lang.creater}"/></td>
            <td><c:out value="${lang.currentVersion}"/></td>
            <td>
                <form action="/languages/${lang.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit"  value="Delete">
                </form>
                <a href="languages/edit/${lang.id}">Edit</a>
            </td>



        </tr>
    </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creater">creater</form:label>
        <form:errors path="creater"/>
        <form:textarea path="creater"/>
    </p>
    <p>
        <form:label path="currentVersion">current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
