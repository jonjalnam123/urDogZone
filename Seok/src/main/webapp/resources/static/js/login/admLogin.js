/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.07
 * 내용 : 회원가입 페이지 스크립트
 */
$(document).ready(function(){
	
	// 관리자 로그인 버튼 이벤트
	$('#admLoginBtn').on('click', function() {
		var adminId = $("#adminId").val();
		var adminPw = $("#adminPw").val();
		
		var url = '/admLogin/adminLogin.do';
		var params = {
				adminId : adminId
		  	  , adminPw : adminPw
		}
		var dataType = 'json'
	 	ajaxStart(url, params, dataType, function(data) {
	 	goToUri('/admMain.do');
	        if (data.resultCd === 'Y' ) {
	        	//goToUri('/admMain.do');
	        } else {
				alert('아이디/비밀번호를 다시 확인해주세요.');
				return;
	        }
		});
	})
	
});