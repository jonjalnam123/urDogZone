<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#joinBtn').on('click', function() {
		window.location.href = '/join/selectJoinMethod.do'
	})
	
	$('#loginBtn').on('click', function() {
		test();
	})
	
});
</script>

<body>
	<div>
		<input id="userId" type="text" placeholder="아이디"><br>
		<input id="userPw" type="password"  placeholder="비밀번호" ><br>
		<button type="button" id="loginBtn">로그인</button>
		<button type="button" id="joinBtn">회원가입</button>
		<button type="button" id="findBtn">아이디/비밀번호 찾기</button>		
	</div>
	<div class="card">
	  <h2 class="text-center mb-2">보호 중인 강아지</h2>
	  <p>이름: 초코 | 나이: 3살 | 성별: 남아</p>
	  <img src="https://www.shutterstock.com/shutterstock/photos/2610092393/display_1500/stock-photo-cheerful-golden-retriever-puppy-ready-fun-2610092393.jpg" alt="강아지 사진" style="max-width: 100%; border-radius: 8px; margin-top: 10px;">
	  <button class="btn mt-4">입양 신청</button>
	</div>
</body>
</html>