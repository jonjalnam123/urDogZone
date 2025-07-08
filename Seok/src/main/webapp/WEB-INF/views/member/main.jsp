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

<h1>메인</h1>

<c:if test="${empty login }">
<a href="./login">로그인</a>
<a href="./join">회원가입</a>
</c:if>

<c:if test="${not empty login }">
<a href="./logout">로그아웃</a>
</c:if>

<a href="./showMain">메인</a>  

</body>
</html>