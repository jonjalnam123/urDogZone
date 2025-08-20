<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerListReg.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사장소 등록</h2>

  <form action="/service/regVolunteerPlace.do" method="post" id="regVolunteerListForm">
  
    <div class="form-group">
      <label for="placeNm">봉사장명</label>
      <input type="text" id="placeNm" name="placeNm">
    </div>
    
    <div class="form-group">	
      <label for="volunteerTitle">봉사 제목</label>
	  <input type="text" id="volunteerTitle" name="volunteerTitle">
    </div>
    
    <div class="form-group">
      <label for="volunteerNote">봉사 설명</label>
      <textarea id="volunteerNote" name="volunteerNote" maxlength="333"></textarea>
    </div>
    
    <div class="form-group">
      <label for="volunteerMaxCnt">봉사 모집인원</label>
	  <input type="text" id="volunteerMaxCnt" name="volunteerMaxCnt">
    </div>
    
    <div class="form-group">
      <label for="volunteerDt">봉사 일자</label>
      <input type="date" id="volunteerDt" name="volunteerDt">
    </div>

    <div class="btn-group">
      <button type="button" class="btn" id="regBtn">등록</button>
      <button type="button" class="btn" id="cancelBtn">취소</button>
    </div>
  </form>
</div>