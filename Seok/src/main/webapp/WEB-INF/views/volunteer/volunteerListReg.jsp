<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerListReg.js"></script>

<div class="content-wrapper">
	<!-- 페이지 타이틀 + 브레드크럼 -->
	<div class="page-header">
	  <h2>봉사일정 등록</h2>
	  <div class="breadcrumb">
	    <a href="#">봉사활동</a> &gt; <span>봉사일정 등록</span>
	  </div>
	</div>
	
	<form action="/service/regVolunteerList.do" method="post" id="regVolunteerListForm">
		<div class="form-group">
			<label for="name">봉사명</label>
			<input type="text" id="name" class="login-input" placeholder="이름을 입력하세요">
		</div>
	
		<div class="form-group">
			<label for="role">봉사장소</label>
		 	<select id="role" class="login-input">
				<option value="">선택</option>
				<c:forEach var="volPlace" items="${volPlaceList}">
					<option value="${volPlace.placeCd}">${volPlace.placeNm}</option>
				</c:forEach>
			</select>
		</div>
	  
	    <div class="form-group">
	      <label for="volunteerNote">봉사내용</label>
	      <textarea id="volunteerNote" class="login-input" name="volunteerNote" maxlength="333"></textarea>
	    </div>
    
	    <div class="form-group">
	      <label for="volunteerMaxCnt">모집인원</label>
		  <input type="number"  id="volunteerMaxCnt" class="login-input"  name="volunteerMaxCnt" min="0" max="30" step="1">
	    </div>
    
		<div class="form-group">
		  <label for="volunteerDt">봉사 일자</label>
		  <input type="date" id="volunteerDt" class="login-input" name="volunteerDt">
		</div>
	
		<div style="text-align: right; margin-top: 20px;">
			<button type="button" class="btn btn-insert" id="regBtn">등록</button>
			<button type="button" class="btn btn-delete" id="cancelBtn">취소</button>
		</div>
	</form>
</div>