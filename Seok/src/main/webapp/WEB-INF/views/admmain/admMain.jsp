<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#logoutBtn').on('click', function() {
		goToUri('/admLogin/admLogout.do');
	})
	
});
</script>
<div>
	<input id="adminId" type="text" value="${adminId}님 안녕하세요."><br>
	<button type="button" id="logoutBtn">로그아웃</button>
</div>
<div class="card">
	<h2 class="text-center mb-2">보호 중인 강아지</h2>
	<p>이름: 초코 | 나이: 3살 | 성별: 남아</p>
	<img src="https://www.shutterstock.com/shutterstock/photos/2610092393/display_1500/stock-photo-cheerful-golden-retriever-puppy-ready-fun-2610092393.jpg" alt="강아지 사진" style="max-width: 100%; border-radius: 8px; margin-top: 10px;">
	<button class="btn mt-4">입양 신청</button>
</div>