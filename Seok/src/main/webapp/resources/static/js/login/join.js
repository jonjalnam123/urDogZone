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
	
	//비밀번호 이벤트
	$('#userPw').on('keyup', function () {
		passChkText();
	});
	
	//비밀번호 확인 이벤트
	$('#userPwCheck').on('keyup', function () {
		passChkText();
	});
	
	$('#userPhone2').on('keyup', function() {
		$(this).val(checkNum('userPhone2'));
	});
	
	$('#userPhone3').on('keyup', function() {
		$(this).val(checkNum('userPhone3'));
	});
	
	// 이메일 인증 버튼 이벤트
	var code = "";
	$('#mailCheckBtn').click(function() {
		var email = $('#userEmail1').val() + '@' + $('#userEmail2').val();
		console.log('완성된 이메일 : ' + email); 
		$('#userEmail').val(email);
		var checkInput = $('#mailCheckInput')
		
		var url = '/login/mailCheck.do';
		var params = {
				email : email
		};
		var dataType = 'json';
	 	ajaxStart(url, params, dataType, function(data) {
			checkInput.attr('disabled', false);
			code = data.emailCode;
			alert('인증번호가 전송되었습니다.');
		});
	});
	
	// 이메일 인증 코드 이벤트
	$('#mailCheckInput').on('keyup', function () {
		$(this).val(checkNum('mailCheckInput'));
		
		var inputCode = $(this).val();
		var resultMsg = $('#mailCheckWarn');
		
		if ( !isEmpty(inputCode) ) {
			resultMsg.html('');
			return;
		} else {
			if(inputCode === code){
				resultMsg.html('✅ 인증번호가 일치합니다.');
				resultMsg.css('color','green');
				$('#mailCheckBtn').attr('disabled', true); 
				$('#mailCheckInput').attr('readonly', true);
				$('#userEmail1').attr('readonly', true);
				$('#userEmail2').attr('readonly', true);
				$('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
		        $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
		        $('#mailCheck').val('1');
			}else{
				resultMsg.html('❌ 인증번호가 불일치 합니다. 다시 확인해주세요!.');
				resultMsg.css('color','red');
				$('#mailCheck').val('0');
			}	
		}
	});
	
	// 우편번호 찾기 이벤트
	$('#getPostCode').on('click', function(){
		var postId =  $('#userPostcode').attr('id');
		var adId = $('#userAd').attr('id');
		execDaumPostcode( postId, adId )
	})
	
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
	
});

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.08.08
* 내용 : 비밀번호 형식 및 텍스트 알림 처리
* 파라미터 : 
**************************************************************/
function passChkText(){

	var userPwVal = $('#userPw').val();
	var userPwCheckVal = $('#userPwCheck').val();
	var userPwCheckText = $('#userPwCheckText');
	
	// 비밀번호, 비밀번호 확인
	if ( !isEmpty(userPwVal) && !isEmpty(userPwCheckVal) ) {
		$('#passWordText').text('');
		userPwCheckText.html('');
		return;
	}
	
	// 비밀번호
	if ( !isEmpty(userPwVal) ) {
		$('#passWordText').text('')
	} else {
		var regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+~`\\\-={}[\]:;"'<>,.?/]).{12}$/;
	    if (regex.test(userPwVal)) {
	      	$('#passWordText').text('✅ 사용 가능한 비밀번호입니다.').css('color', 'green');
			$('#pwChk').val('1');	    
		} else {
	      	$('#passWordText').text('❌ 비밀번호는 영문+숫자+특수문자 포함 12자리여야 합니다.').css('color', 'red');
			$('#pwChk').val('0');	    
		}
	}
	
	// 비밀번호 확인
	if ( !isEmpty(userPwCheckVal) ) {
		userPwCheckText.html('');
	} else {
		if ( userPwVal !== userPwCheckVal ) {
			userPwCheckText.css('color','red');
			userPwCheckText.html('❌ 비밀번호가 일치하지 않습니다.')
		} else {
			userPwCheckText.css('color','green');
			userPwCheckText.html('✅ 비밀번호가 일치합니다.')
		}	
	}
	
}


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
	var pwCheck = parseInt($("#pwChk").val());
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
		$('#userId').focus();
		return false;
	}
	
	if ( !isEmpty(userPw) ) {
		alert('비밀번호를 입력해주세요.');
		$('#userPw').focus();
		return false;
	}
	
	if ( pwCheck === 0 ) {
		alert('비밀번호 형식을 확인해주세요.')
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
		$('#userEmail1').focus();
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