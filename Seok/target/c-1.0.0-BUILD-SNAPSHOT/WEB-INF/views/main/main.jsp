<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#joinBtn').on('click', function() {
		goToUri('/login/getJoinAgreePage.do');
	})
	
	$('#loginBtn').on('click', function() {
		var userId = $('#userId').val()
		var userPw = $('#userPw').val()
		
		var url = '/login/userLogin.do';
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
		goToUri('/login/logout.do');
	})
	
	setInterval(function(){
		  var slides = $('.slider .slide');
		  var current = slides.filter('.active');
		  var next = current.next('.slide').length ? current.next('.slide') : slides.first();
		  
		  current.removeClass('active');
		  next.addClass('active');
		}, 3000);
	
});
</script>
<main class="main-grid">
	<!-- 좌측 영역 -->
	<section class="main-left">
		<!-- 유기견 슬라이더 -->
		<div class="slider card">
			<div class="slide active">
				<img src="https://www.shutterstock.com/shutterstock/photos/2610092393/display_1500/stock-photo-cheerful-golden-retriever-puppy-ready-fun-2610092393.jpg" alt="강아지1">
				<p>이름: 초코 | 나이: 3살 | 성별: 남아</p>
			</div>
			<div class="slide">
				<img src="https://www.shutterstock.com/shutterstock/photos/2609570817/display_1500/stock-photo-happy-beagle-dog-walking-2609570817.jpg" alt="강아지2">
				<p>이름: 보리 | 나이: 2살 | 성별: 여아</p>
			</div>
			<div class="slide">
				<img src="https://www.shutterstock.com/shutterstock/photos/2610195632/display_1500/stock-photo-cute-corgi-puppy-posing-on-white-background-2610195632.jpg" alt="강아지3">
				<p>이름: 꼬미 | 나이: 1살 | 성별: 남아</p>
			</div>
		</div>

		<!-- 공지사항 -->
		<div class="card">
			<h2 class="text-center mb-2">공지사항</h2>
			<ul class="notice-list">
				<li><a href="#">8월 입양 캠페인 안내</a></li>
				<li><a href="#">봉사자 교육 일정 변경</a></li>
				<li><a href="#">임시 보호소 증설 예정</a></li>
			</ul>
		</div>
	</section>

	<!-- 우측 영역 -->
	<section class="main-right">
		<!-- 로그인 영역 -->
		<div class="card">
			<c:choose>
				<c:when test="${userId eq '' || userId eq null || empty userId}">
				<form id="loginForm">
					<input id="userId" name="userId" type="text" placeholder="아이디"><br>
					<input id="userPw" name="userPw" type="password" placeholder="비밀번호"><br>
					<button type="button" class="btn mt-2" id="loginBtn">로그인</button>
					<button type="button" class="btn mt-2" id="joinBtn">회원가입</button>
					<button type="button" class="btn mt-2" id="findBtn">아이디/비밀번호 찾기</button>
				</form>
				</c:when>
				<c:otherwise>
				<div>
					<p>${userId}님 안녕하세요.</p>
					<button type="button" class="btn mt-2" id="logoutBtn">로그아웃</button>
				</div>
				</c:otherwise>
			</c:choose>
		</div>

		<!-- 봉사 일정 -->
		<div class="card">
			<h2 class="text-center mb-2">봉사 일정</h2>
			<ul class="notice-list">
				<li><a href="#">8/10(토) 오전 10시 - 정기 봉사</a></li>
				<li><a href="#">8/17(토) 오후 2시 - 특별 청소 봉사</a></li>
				<li><a href="#">8/24(토) 오전 10시 - 입양 홍보</a></li>
			</ul>
		</div>
	</section>
</main>