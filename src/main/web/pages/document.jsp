<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
</head>
<body>

<form method="post" action="journal" enctype="application/x-www-form-urlencoded" title="Document">
     <p>
        <label>
            Тип документа:
            <input type="text" name="usernameField" value="${param['docType']}">
        </label>
    </p>
    <p>
        <label>
            Название:
            <input type="text" name="usernameField" value="${param['login']}">
        </label>
    </p>

    <p>
        <label>
            Внутрнний номер документа в системе импортера:
            <input type="text" name="usernameField" value="${param['login']}">
        </label>
    </p>

</form>



</body>
</html>
