<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
</head>
<body>
<c:if test="${not empty sessionScope['verifiedUserName']}">
  <p>
      ${sessionScope['verifiedUserName']}
  </p>
</c:if>

<c:choose>
  <c:when test="${empty sessionScope['verifiedUserName']}">
    <a href="login">Login</a>
  </c:when>
  <c:otherwise>
    <p>
      Hello, ${sessionScope['verifiedUserName']}.
    </p>
    <p>
      <a href="document">New document</a>
    </p>
  </c:otherwise>
</c:choose>
</body>
</html>