<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자체 회원가입</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	// 아이디 중복검사 이벤트
	$('#idChkBtn').on('click', function () {
		
 		var userId = $("#userId").val();

 		if ( !isEmpty(userId) ) {
 			alert('아이디를 입력해주세요.');
 			return;
 		}
 		
		var url = '/join/selectUserIdCheck.do';
		var params = {
				userId : userId
		}
		var dataType = 'json'
	 	ajaxStart(url, params, dataType, function(data) {
	        if (data.resultId === 'Y' ) {
	            alert("사용 불가능한 아이디 입니다.");
	        } else {
	            alert("사용 가능한 아이디입니다.");
	            $('#idChk').val('1');
	        }
		});
	});
	
	// 등록버튼 이벤트
	$('#regBtn').on('click', function () {

		var result = validationCheck();
		var form = $('#joinForm');
		
		if ( result ) {
	  		form.submit();
		}
	});
	
	$('#delBtn').on('click', function() {
		goToUri('/');
	});
	
});


function validationCheck() {
	
	var result = true;
	
	var userNm = $('#userNm').val();
	var userId = $("#userId").val();
	var idCheck = parseInt($("#idChk").val());
	var userPw = $("#userPw").val();
	var userPwCheck = $("#userPwCheck").val();
	var userPhone = $("#userPhone").val();
	var userEmail = $("#userEmail").val();
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
	
	if ( !isEmpty(userEmail) ) {
		alert('이메일을 입력해주세요.');
		$('#userEmail').focus();
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
</script>
<body>
  <h2 style="text-align:center;">회원가입</h2>

  <form action="/join/insertMember.do" method="post" id="joinForm">
  <input type="hidden" name="userTermsF" id="userTermsF" value="${terms1}">
  <input type="hidden" name="userTermsS" id="userTermsS" value="${terms2}">
  <input type="hidden" name="idChk" id="idChk" value="0">
    <table border="1">
      <tr>
        <td>이름</td>
        <td><input type="text" name="userNm" id="userNm"></td>
      </tr>
      <tr>
        <td>아이디</td>
        <td>
        	<input type="text" name="userId" id="userId">
        	<button type="button" id="idChkBtn">중복확인</button>
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td><input type="password" name="userPw" id="userPw"></td>
      </tr>
      <tr>
        <td>비밀번호 확인</td>
        <td><input type="password" name="userPwCheck" id="userPwCheck"></td>
      </tr>
      <tr>
        <td>핸드폰</td>
        <td><input type="text" name="userPhone" id="userPhone" placeholder=" '-' 없이 숫자만 입력해주세요."></td>
      </tr>
      <tr>
        <td>이메일</td>
        <td><input type="email" name="userEmail" id="userEmail"></td>
      </tr>
      <tr>
        <td>생년월일</td>
        <td><input type="date" name="userBirth" id="userBirth"></td>
      </tr>
      <tr>
        <td>성별</td>
        <td>
          <label><input type="radio" name="userGen" value="M"> 남성</label>
          <label><input type="radio" name="userGen" value="F"> 여성</label>
        </td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td>
        	<input type="text" name="userPostcode" id="userPostcode" placeholder="우편번호" readonly>
       	  	<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
       	  	<input type="text" name="userAd" id="userAd" placeholder="도로명주소" readonly>
       	  	<input type="text" name="userAdd" id="userAdd" placeholder="상세주소">
        </td>
      </tr>
      <tr>
        <td>봉사경험</td>
        <td>
          <label><input type="radio" name="userVolExpYn" value="Y"> 유</label>
          <label><input type="radio" name="userVolExpYn" value="N"> 무</label>
        </td>
      </tr>
      <tr>
        <td>자동차</td>
        <td>
          <label><input type="radio" name="userCarYn" value="Y"> 보유</label>
          <label><input type="radio" name="userCarYn" value="N"> 미보유</label>
        </td>
      </tr>
      <tr>
        <td>카풀제공</td>
        <td>
          <label><input type="radio" name="userCarPoolYn" value="Y"> 가능</label>
          <label><input type="radio" name="userCarPoolYn" value="N"> 불가능</label>
        </td>
      </tr>
    </table>
    <div>
    	<button type="button" id="regBtn">등록</button>
    	<button type="button" id="delBtn">취소</button>
    </div>
  </form>
</body>
</html>