<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- <jsp:include page="../layout/header.jsp"></jsp:include> --%>
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
</body>

<%-- <jsp:include page="../layout/footer.jsp"></jsp:include> --%>
</html>