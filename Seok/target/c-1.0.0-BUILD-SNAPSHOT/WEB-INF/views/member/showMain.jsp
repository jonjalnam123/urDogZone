<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1>User List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <c:forEach var="data" items="${dataList}">
            <tr>
                <td>${data.name}</td>
                <td>${data.age}</td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>