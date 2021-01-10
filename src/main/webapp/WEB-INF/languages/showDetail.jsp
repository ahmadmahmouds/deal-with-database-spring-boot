<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/10/2021
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2> Name:<c:out value="${language.name}"/></h2>

</div>
<div>
    <h2>Creater:<c:out value="${language.creater}"/></h2>
</div>
<div>
    <h2>Current Version:<c:out value="${language.currentVersion}"/></h2>
</div>

</body>
</html>
