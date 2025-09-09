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
<!-- <section class="card" style="max-width: 400px; margin: 40px auto;">
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
</section> -->

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                <div class="card-body">
                    <form>
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" />
                            <label for="inputEmail">Email address</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputPassword" type="password" placeholder="Password" />
                            <label for="inputPassword">Password</label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                            <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                        </div>
                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a class="small" href="password.html">Forgot Password?</a>
                            <a class="btn btn-primary" href="index.html">Login</a>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-center py-3">
                    <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
                </div>
            </div>
        </div>
    </div>
</div>