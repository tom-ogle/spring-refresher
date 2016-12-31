<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Tweeter</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1>Welcome to Tweeter</h1>
        <a href="<c:url value="/tweets" />">Tweets</a>
        <a href="<c:url value="/tweeter/register" />">Register</a>
    </body>
</html>