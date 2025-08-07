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
					//window.location.href = returnUrl;
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
<button type="button" onclick="kakaoLogout()"> 로그아웃</button>
<button type="button" id="kakaoJoinBtn">카카오 로그인</button>
<button type="button" id="joinBtn">회원가입</button>