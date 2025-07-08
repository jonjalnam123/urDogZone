<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>

<form action="./join" method="post">

<label>아이디<input type="text" name="userid"></label><br>
<label>비밀번호<input type="password" name="userpw"></label><br>
<label>이름<input type="text" name="username"></label><br>
<label>전화번호<input type="text" name="userphone"></label>
<br>
<button type="submit">가입</button>
<button type="button" onclick="location.href='./main' ">메인으로</button>

</form>
</body>
</html>