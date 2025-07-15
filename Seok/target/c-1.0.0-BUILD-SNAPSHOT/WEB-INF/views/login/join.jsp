<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자체 회원가입</title>
<style>
  table {
    border-collapse: collapse;
    width: 400px;
    margin: 20px auto;
  }
  td {
    padding: 10px;
  }
  input[type="text"],
  input[type="email"],
  input[type="password"],
  input[type="date"] {
    width: 100%;
    padding: 5px;
  }
  .submit-row {
    text-align: center;
  }
</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	// 등록버튼 이벤트
	$('#regBtn').on('click', function () {
/* 		var queryString = $('#joinForm').serialize() ;
		var url = '/join/insertMember.do';
		var params = queryString;
		var dataType = 'json'
	 	ajaxStart(url, params, dataType); */
	})
	
	// 등록버튼 이벤트
	$('#idChkBtn').on('click', function () {
 		var userId = $("#userId").val();
		var url = '/join/selectUserIdCheck.do';
		var params = {
				userId : userId
		}
		var dataType = 'json'
	 	ajaxStart(url, params, dataType);
	})
	
});
</script>
<body>

  <h2 style="text-align:center;">회원가입</h2>

  <form action="/join/insertMember.do" method="post" id="joinForm">
    <table border="1">
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
        <td>이름</td>
        <td><input type="text" name="userNm" id="userNm"></td>
      </tr>
      <tr>
        <td>핸드폰</td>
        <td><input type="text" name="userPhone" id="userPhone"></td>
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
        <td>봉사경험</td>
        <td>
          <label><input type="radio" name="userVol" value="Y"> 유</label>
          <label><input type="radio" name="userVol" value="N"> 무</label>
        </td>
      </tr>
      <tr>
        <td>자동차</td>
        <td>
          <label><input type="radio" name="userCar" value="Y"> 보유</label>
          <label><input type="radio" name="userCar" value="N"> 미보유</label>
        </td>
      </tr>
      <tr>
        <td>카풀제공</td>
        <td>
          <label><input type="radio" name="userCarP" value="Y"> 가능</label>
          <label><input type="radio" name="userCarP" value="N"> 불가능</label>
        </td>
      </tr>
      <tr>
        <td>약관 동의</td>
        <td>
        	<textarea rows="" cols="" readonly="readonly">봉사 중 찍힌 사진은 SNS에 활용될수있습니다.</textarea><br>
        	<label><input type="checkbox" name="agree" required> 동의합니다</label>
        </td>
      </tr>
    </table>
    <div>
    	<button type="submit" id="regBtn">등록</button>
    	<button type="button" id="delBtn">취소</button>
    </div>
  </form>

</body>
</html>