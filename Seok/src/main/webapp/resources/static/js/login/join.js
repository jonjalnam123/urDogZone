/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.07
 * 내용 : 회원가입 페이지 스크립트
 */

$(document).ready(function(){
	
	// 아이디 체크 이벤트
	$('#userId').on('change', function () {
		$('#idChk').val('0');
	})
	
	// 아이디 중복검사 이벤트
	$('#idChkBtn').on('click', function () {
		
 		var userId = $("#userId").val();

 		if ( !isEmpty(userId) ) {
 			alert('아이디를 입력해주세요.');
 			return;
 		}
 		
		var url = '/login/selectUserIdCheck.do';
		var params = {
				userId : userId
		}
		var dataType = 'json'
	 	ajaxStart(url, params, dataType, function(data) {
	        if (data.resultId === 'Y' ) {
	        	alert("사용 가능한 아이디입니다.");
	        	$('#idChk').val('1');
	        } else {
	        	alert("사용 불가능한 아이디 입니다.");
	            $('#idChk').val('0');
	        }
		});
	});
	
	// 등록버튼 이벤트
	$('#regBtn').on('click', function () {
		
		var poh1 = $('#userPhone1').val()
		var poh2 = $('#userPhone1').val()
		var poh3 = $('#userPhone1').val()
		var pohoneVal = poh1 + poh2 + poh3
		$('#userPhone').val(pohoneVal);
		
		var result = validationCheck();
		if ( result ) {
			var conMsg = "회원가입 하시겠습니까?"
			var conResult = callConfirm(conMsg);
			if ( conResult === 'Y') { 
				var form = $('#joinForm');
		  		form.submit();
			} 
		}
	});
	
	// 삭제버튼 이벤트
	$('#delBtn').on('click', function() {
		goToUri('/');
	});
	
	//비밀번호 확인 이벤트
	$('#userPw').blur(function () {
		var userPwCheckText = $('#userPwCheckText');
		var userPwVal = $(this).val();
		var userPwCheckVal = $('#userPwCheck').val();
		
	    var regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+~`\\\-={}[\]:;"'<>,.?/]).{12}$/;

	    if (regex.test(userPwVal)) {
	      $('#passWordText').text('✅ 사용 가능한 비밀번호입니다.').css('color', 'green');
	    } else {
	      $('#passWordText').text('❌ 비밀번호는 영문+숫자+특수문자 포함 12자리여야 합니다.').css('color', 'red');
	    }

		if ( userPwVal !== userPwCheckVal ) {
			userPwCheckText.css('color','red');
			userPwCheckText.html('❌ 비밀번호가 일치하지 않습니다.')
		} else {
			userPwCheckText.css('color','green');
			userPwCheckText.html('✅ 비밀번호가 일치합니다.')
		}
	});
	
	//비밀번호 확인 이벤트
	$('#userPwCheck').blur(function () {
		var userPwCheckText = $('#userPwCheckText');
		var userPwVal = $('#userPw').val();
		var userPwCheckVal = $(this).val();
		
		if ( userPwVal !== userPwCheckVal) {
			userPwCheckText.css('color','red');
			userPwCheckText.html('❌ 비밀번호가 일치하지 않습니다.')
		} else {
			userPwCheckText.css('color','green');
			userPwCheckText.html('✅ 비밀번호가 일치합니다.')
		}
	});
	
	// 이메일 인증 버튼 이벤트
	var code = "";
	$('#mail-Check-Btn').click(function() {
		const email = $('#userEmail1').val() + '@' + $('#userEmail2').val();
		console.log('완성된 이메일 : ' + email); 
		$('#userEmail').val(email);
		const checkInput = $('.mail-check-input')
		
		var url = '/login/mailCheck.do';
		var params = {
				email : email
		};
		var dataType = 'json';
	 	ajaxStart(url, params, dataType, function(data) {
			checkInput.attr('disabled',false);
			code = data.emailCode;
			alert('인증번호가 전송되었습니다.');
		});
	});
	
	// 이메일 인증 코드 이벤트
	$('.mail-check-input').blur(function () {
		const inputCode = $(this).val();
		const $resultMsg = $('#mail-check-warn');
		
		if(inputCode === code){
			$resultMsg.html('✅ 인증번호가 일치합니다.');
			$resultMsg.css('color','green');
			$('#mail-Check-Btn').attr('disabled',true);
			$('#userEmail1').attr('readonly',true);
			$('#userEmail2').attr('readonly',true);
			$('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	        $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
	        $('#mailCheck').val('1');
		}else{
			$resultMsg.html('❌ 인증번호가 불일치 합니다. 다시 확인해주세요!.');
			$resultMsg.css('color','red');
		}
	});
	
});


/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.08.07
* 내용 : 유효성 검사
* 파라미터 : 
**************************************************************/
function validationCheck() {
	
	var result = true;
	
	var userNm = $('#userNm').val();
	var userId = $("#userId").val();
	var idCheck = parseInt($("#idChk").val());
	var userPw = $("#userPw").val();
	var userPwCheck = $("#userPwCheck").val();
	var userPhone = $("#userPhone").val();
	var userEmail1 = $("#userEmail1").val();
	var mailCheck = parseInt($("#mailCheck").val());
	var userBirth = $("#userBirth").val();
	var userPostcode = $("#userPostcode").val();
	var userAd = $("#userAd").val();
	var userAdd = $("#userAdd").val();
	
	var userGen = getCheckedVal('userGen');
	var userVolExpYn = getCheckedVal('userVolExpYn');
	var userCarYn = getCheckedVal('userCarYn');
	var userCarPoolYn = getCheckedVal('userCarPoolYn');

	if ( !isEmpty(userNm) ) {
		alert('이름을 입력해주세요.');
		$('#userNm').focus();
		return false;
	}

	if ( !isEmpty(userId) ) {
		alert('아이디를 입력해주세요.');
		$('#userId').focus();
		return false;
	}
	
	if ( idCheck === 0 ) {
		alert('아이디 중복검사를 진행해주세요.')
		return false;
	}
	
	if ( !isEmpty(userPw) ) {
		alert('비밀번호를 입력해주세요.');
		$('#userPw').focus();
		return false;
	}
	
	if ( !isEmpty(userPwCheck) ) {
		alert('비밀번호 확인을 입력해주세요.');
		$('#userPwCheck').focus();
		return false;
	}
	
	if ( userPw !== userPwCheck) {
		alert('비밀번호가 일치하지 않습니다.');
		$('#userPw').focus();
		return false;
	}
	
	if ( !isEmpty(userPhone) ) {
		alert('핸드폰번호를 입력해주세요.');
		$('#userPhone').focus();
		return false;
	}
	
	if ( !isEmpty(userEmail1) ) {
		alert('이메일을 입력해주세요.');
		$('#userEmail1').focus();
		return false;
	}
	
	if ( mailCheck === 0 ) {
		alert('이메일 본인인증을 진행해주세요.');
		return false;
	}
	
	if ( !isEmpty(userBirth) ) {
		alert('생년월일을 입력해주세요.');
		$('#userBirth').focus();
		return false;
	}

	if ( !isEmpty(userGen) ) {
		alert('성별을 입력해주세요.');
		return false;
	}
	
	if ( !isEmpty(userPostcode) ) {
		alert('주소를 찾아 입력해주세요.');
		$('#userPostcode').focus();
		return false;
	}
	
	if ( !isEmpty(userAd) ) {
		alert('주소를 찾아 입력해주세요.');
		$('#userAd').focus();
		return false;
	}
	
	if ( !isEmpty(userAdd) ) {
		alert('상세주소를 입력해주세요.');
		$('#userAdd').focus();
		return false;
	}
	
	if ( !isEmpty(userVolExpYn) ) {
		alert('봉사경험 여부를 입력해주세요.');
		return false;
	}
	
	if ( !isEmpty(userCarYn) ) {
		alert('자동차 여부를 입력해주세요.');
		return false;
	}
	
	if ( !isEmpty(userCarPoolYn) ) {
		alert('카풀제공 여부를 입력해주세요.');
		return false;
	}
	
	return result;
	
}