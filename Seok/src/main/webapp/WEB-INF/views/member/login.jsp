<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인</h1>


<form action="./login" method="post">

<label>아이디<input type="text" name="userid"></label><br>
<label>비밀번호<input type="password" name="userpw"></label>
<br>
<button type="submit">로그인</button>
<button type="button" onclick="location.href='./main' ">메인으로</button>

</form>
</body>
</html>