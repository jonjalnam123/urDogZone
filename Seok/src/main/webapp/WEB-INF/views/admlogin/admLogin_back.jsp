<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#adLoginBtn').on('click', function() {
		
		var adminId = $("#adminId").val();
		var adminPw = $("#adminPw").val();
		
		var url = '/admLogin/adminLogin.do';
		var params = {
				adminId : adminId
		  	  , adminPw : adminPw
		}
		var dataType = 'json'
	 	ajaxStart(url, params, dataType, function(data) {
	        if (data.resultCd === 'Y' ) {
	        	goToUri('/admMain.do');
	        } else {
				alert('아이디/비밀번호를 다시 확인해주세요.');
				return;
	        }
		});
		
	})
});
</script>
<section class="card" style="max-width: 400px; margin: 40px auto;">
  <h2 class="text-center mb-2">로그인</h2>
  <table>
    <tr>
      <td>아이디</td>
      <td><input type="text" name="adminId" id="adminId" required></td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td><input type="password" name="adminPw" id="adminPw" required></td>
    </tr>
  </table>

  <div class="submit-row mt-4">
    <button type="button" id="adLoginBtn" class="btn w-full">로그인</button>
  </div>

  <div class="text-center mt-2">
    <button class="btn mt-2" onclick="">회원가입</button>
    <button class="btn mt-2" onclick="">아이디/비밀번호 찾기</button>
  </div>
</section>