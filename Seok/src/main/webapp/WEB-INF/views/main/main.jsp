<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#joinBtn').on('click', function() {
		goToUri('/join/selectJoinMethod.do');
	})
	
	$('#loginBtn').on('click', function() {
		var userId = $('#userId').val()
		var userPw = $('#userPw').val()
		
		var url = '/join/login.do';
		var params = {
				  userId : userId
				, userPw : userPw
		};
		var dataType = 'json'
		
	 	ajaxStart(url, params, dataType, function(data) {
			if ( data.resultVal === 'N' ) {
				alert('아이디, 비밀번호를 다시 확인해주세요.');
				return;
			} else {
				goToUri('/');
			}
		});
	});
	
	$('#logoutBtn').on('click', function() {
		goToUri('/join/logout.do');
	})
	
});
</script>
<c:choose>
	<c:when test="${userId eq '' || userId eq null || empty userId}">
	<form action="/join/login.do" method="post" id="loginForm">
		<div>
			<input id="userId" name="userId" type="text" placeholder="아이디"><br>
			<input id="userPw" name="userPw" type="password"  placeholder="비밀번호" ><br>
			<button type="button" class="" id="loginBtn">로그인</button>
			<button type="button" class="" id="joinBtn">회원가입</button>
			<button type="button" class="" id="findBtn">아이디/비밀번호 찾기</button>		
		</div>
	</form>
	</c:when>
	<c:otherwise>
		<div>
			<input id="userId" type="text" value="${userId}님 안녕하세요."><br>
			<button type="button" id="logoutBtn">로그아웃</button>
		</div>
	</c:otherwise>
</c:choose>
<div class="card">
	<h2 class="text-center mb-2">보호 중인 강아지</h2>
	<p>이름: 초코 | 나이: 3살 | 성별: 남아</p>
	<img src="https://www.shutterstock.com/shutterstock/photos/2610092393/display_1500/stock-photo-cheerful-golden-retriever-puppy-ready-fun-2610092393.jpg" alt="강아지 사진" style="max-width: 100%; border-radius: 8px; margin-top: 10px;">
	<button class="btn mt-4">입양 신청</button>
</div>