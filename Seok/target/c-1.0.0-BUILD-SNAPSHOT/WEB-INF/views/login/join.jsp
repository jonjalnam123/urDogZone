<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/login/join.js"></script>

<div class="card">
  <form action="/login/insertMember.do" method="post" id="joinForm">
    <input type="hidden" name="userTermsF" id="userTermsF" value="${terms1}">
    <input type="hidden" name="userTermsS" id="userTermsS" value="${terms2}">
    <input type="hidden" name="idChk" id="idChk" value="0">
    <input type="hidden" name="pwChk" id="pwChk" value="0">
    <input type="hidden" name="mailCheck" id="mailCheck" value="0">

    <div class="form-group">
      <label for="userNm">이름</label>
      <input type="text" id="userNm" name="userNm">
    </div>

	<div class="form-group">
	  <label for="userId">아이디</label>
	  <div class="id-check-wrap">
	    <input type="text" id="userId" name="userId">
	    <button type="button" class="btn" id="idChkBtn">중복확인</button>
	  </div>
	  <span id="userIdText"></span>
	</div>

    <div class="form-group">
      <label for="userPw">비밀번호</label>
      <input type="password" id="userPw" name="userPw" maxlength="12">
      <span id="passWordText"></span>
    </div>

    <div class="form-group">
      <label for="userPwCheck">비밀번호 확인</label>
      <input type="password" id="userPwCheck" name="userPwCheck" maxlength="12">
      <span id="userPwCheckText"></span>
    </div>

    <div class="form-group">
      <label for="userPhone">핸드폰</label>
      <input type="hidden" id="userPhone" name="userPhone">
      <input type="text" id="userPhone1" name="userPhone1" value="010" readonly><span>-</span>
      <input type="text" id="userPhone2" name="userPhone2" maxlength="4"><span>-</span>
      <input type="text" id="userPhone3" name="userPhone3" maxlength="4">
    </div>

    <div class="form-group">
      <label for="userEmail">이메일</label>
      <input type="hidden" id="userEmail" name="userEmail">
      <input type="email" id="userEmail1" name="userEmail1">
      <span>@</span>
      <select name="userEmail2" id="userEmail2">
        <option value="">선택</option>
        <c:forEach var="email" items="${emailList}">
          <option value="${email.commNm}">${email.commNm}</option>
        </c:forEach>
      </select>
      <div class="email-auth">
        <input id="mailCheckInput" placeholder="인증번호 6자리를 입력해주세요." disabled="disabled" maxlength="6">
        <button type="button" class="btn" id="mailCheckBtn">본인인증</button>
      </div>
      <span id="mailCheckWarn"></span>
    </div>

    <div class="form-group">
      <label for="userBirth">생년월일</label>
      <input type="date" id="userBirth" name="userBirth">
    </div>

    <div class="form-group radio-group">
      <label>성별</label>
      <label><input type="radio" name="userGen" value="M"> 남성</label>
      <label><input type="radio" name="userGen" value="F"> 여성</label>
    </div>

    <div class="form-group">
      <label for="userPostcode">우편번호</label>
      <div style="display: flex; gap: 10px; flex-wrap: wrap;">
        <input type="text" id="userPostcode" name="userPostcode" placeholder="우편번호" readonly>
        <input type="button" class="btn" id="getPostCode" value="우편번호 찾기">
      </div>
      <input type="text" id="userAd" name="userAd" placeholder="도로명주소" class="mt-2" readonly>
      <input type="text" id="userAdd" name="userAdd" placeholder="상세주소" class="mt-2">
    </div>

    <div class="form-group radio-group">
      <label>봉사경험</label>
      <label><input type="radio" name="userVolExpYn" value="Y"> 유</label>
      <label><input type="radio" name="userVolExpYn" value="N"> 무</label>
    </div>

    <div class="form-group radio-group">
      <label>자동차</label>
      <label><input type="radio" name="userCarYn" value="Y"> 보유</label>
      <label><input type="radio" name="userCarYn" value="N"> 미보유</label>
    </div>

    <div class="form-group radio-group">
      <label>카풀 제공</label>
      <label><input type="radio" name="userCarPoolYn" value="Y"> 가능</label>
      <label><input type="radio" name="userCarPoolYn" value="N"> 불가능</label>
    </div>

    <div class="btn-group">
      <button type="button" class="btn" id="regBtn">등록</button>
      <button type="button" class="btn" id="delBtn">취소</button>
    </div>
  </form>
</div>