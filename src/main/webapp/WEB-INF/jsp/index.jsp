<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
</head>

<body>
	<h1>Index Page ${name}</h1>

    <form method="get" action="/">
        First Name : <input type="text" name="firstName" value="${firstNameKey}" style="margin-bottom:10px">
        <br>
        Email : <input type="text" name="email" value="${emailNameKey}" style="margin-bottom:10px">
        <br>
        Users Id: <input type="text" name="usersId" value="${usersIdKey}" style="margin-bottom:10px">
        <br>
        <button type="submit">Search</button>
    </form>

    <br><br>

    <table border="1" cellpadding="5">
        <tr>
            <td><B>ID</B></td>
            <td><b>First Name</b></td>
            <td><b>Email</b></td>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.email}</td>
            </tr>
        </c:forEach>
    </table>

<jsp:include page="include/header.jsp" />