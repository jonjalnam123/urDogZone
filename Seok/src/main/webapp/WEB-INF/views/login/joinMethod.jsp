<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	// 등록버튼 이벤트
	$('#joinBtn').on('click', function () {
		goToUri('/login/getJoinAgreePage.do');
	})
	
	window.Kakao.init('a594e9d0378896fcec9e7b2822bf6977');
	
	$('#kakaoJoinBtn').on('click', function() {
		kakaoLogin();
	});
	 
});

function kakaoLogin() {
	
	const returnUrl = getNowUri() + '/login/getJoinPage.do';
	
	window.Kakao.Auth.login({
		  scope : 'profile_nickname, profile_image, account_email'
		, success : function(authObj) {
			console.log('authObj===', authObj);
			window.Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
			window.Kakao.API.request({
				  url : '/v2/user/me'
				, success : res => {
					const kakao_account = res.kakao_account;
					console.log('kakao_account====', kakao_account);
					window.location.href = '/';
				}
			});
		}
	});
}

function kakaoLogout() {
	console.log('window.Kakao.Auth.getAccessToken()===', window.Kakao.Auth.getAccessToken())
    if (!window.Kakao.Auth.getAccessToken()) {
        alert('Not logged in.');
        return;
    }
    Kakao.Auth.logout(function() {
        alert('logout ok\naccess token -> ' + window.Kakao.Auth.getAccessToken());
    });
}

</script>

<div class="login-container">
  <h2>로그인 / 회원가입</h2>
  
<!--   <button type="button" id="kakaoJoinBtn" class="btn kakao-btn btn-block">
    <img src="https://developers.kakao.com/tool/resource/static/img/button/login/full/ko/kakao_login_medium_narrow.png" 
         alt="카카오 로그인" style="height:20px; vertical-align:middle; margin-right:6px;">
    카카오로 시작하기
  </button> -->
  
  <button type="button" id="joinBtn" class="btn btn-block">
    이메일로 회원가입
  </button>
  
  <button type="button" onclick="kakaoLogout()" class="btn logout-btn btn-block">
    로그아웃
  </button>
</div>