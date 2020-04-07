<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
</head>
<body>

<form method="post" action="document" enctype="application/x-www-form-urlencoded">


    <p>
        Вы вошли в систему как ${sessionScope['verifiedUserName']}.
    </p>

    <p>
        <label>
            Импортер:
        </label>
    </p>
     <p>
        <label>
            Тип документа:
            <input type="text" name="docTypeField" value="${param['docType']}">
        </label>
    </p>
    <p>
        <label>
            Название:
            <input type="text" name="titleField" value="${param['title']}">
        </label>
    </p>

    <p>
        <label>
            Внутрнний номер документа в системе импортера:
            <input type="text" name="importerDocNumField" value="${param['importerDocNum']}">
        </label>
    </p>

    <p>
        <input type="submit">
    </p>

</form>



</body>
</html>
