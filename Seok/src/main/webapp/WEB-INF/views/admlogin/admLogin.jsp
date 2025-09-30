<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Script Part -->
<script src="${pageContext.request.contextPath}/resources/static/js/login/admLogin.js"></script>

<!-- Draw view [S] -->
<div class="login-container">
  <div class="login-box">
    <h2 class="login-title">UMS</h2>
    
      <div class="form-group">
        <input type="text" id="userId" name="userId" class="login-input" placeholder="아이디">
      </div>
      <div class="form-group">
        <input type="password" id="userPw" name="userPw" class="login-input" placeholder="비밀번호">
      </div>

      <!-- 로그인 / 회원가입 / 비밀번호 찾기 버튼 묶음 -->
      <div class="login-actions">
        <button type="button" id="admLoginBtn" class="action-btn">로그인</button>
      </div>
<!--     <div class="divider">또는</div>

    카카오 로그인
    <a href="/oauth2/authorization/kakao" class="kakao-btn">
      <i class="fa-solid fa-comment"></i> 카카오 계정으로 로그인
    </a>

    네이버 로그인
    <a href="/oauth2/authorization/naver" class="naver-btn">
      <i class="fa-solid fa-n"></i> 네이버 계정으로 로그인
    </a>

    구글 로그인
    <a href="/oauth2/authorization/google" class="google-btn">
      <i class="fa-brands fa-google"></i> 구글 계정으로 로그인
    </a> -->
  </div>
</div>
<!-- Draw view [E] -->