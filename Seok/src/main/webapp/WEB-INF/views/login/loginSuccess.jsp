<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입성공</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
	$('#goToMainBtn').on('click', function() {
		window.location.href = '/';
	})
});
</script>
<body>
<div>
	<h2>가입성공</h2>
	<p>${userNm}님 가입을 축하드립니다.</p>
	<button type="button" id="goToMainBtn">메인으로</button>
</div>
</body>
</html>