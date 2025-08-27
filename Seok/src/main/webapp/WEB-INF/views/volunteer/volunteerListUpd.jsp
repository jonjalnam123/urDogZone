<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerListUpd.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사장소 수정</h2>

  <form action="/service/updVolunteerList.do" method="post" id="updVolunteerListForm">
  
  	<input type="hidden" id="flag" name="flag" value="U">
	<input type="hidden" id="volunteerCd" name="volunteerCd" value="${volunteerList.volunteerCd}">
	
 	<div class="form-group">	
      <label for="volunteerTitle">봉사명</label>
	  <input type="text" id="volunteerTitle" name="volunteerTitle" value="${volunteerList.volunteerTitle}">
    </div>
    
    <div class="form-group">
    	<label for="placeCd">봉사장소</label>
		<select id="placeCd" name="placeCd" class="combo-scroll">  
		<option value="">선택</option>
   			<c:forEach var="volPlace" items="${volPlaceList}">
  				<option value="${volPlace.placeCd}" ${volPlace.placeCd eq volunteerList.placeCd ? 'selected' : ''}>${volPlace.placeNm}</option>
	  		</c:forEach>
	  	</select>
    </div>
    
    <div class="form-group">
      <label for="volunteerNote">봉사내용</label>
      <textarea id="volunteerNote" name="volunteerNote" maxlength="333">${volunteerList.volunteerNote}</textarea>
    </div>
    
    <div class="form-group">
      <label for="volunteerMaxCnt">모집인원</label>
	  <input type="number"  id="volunteerMaxCnt" name="volunteerMaxCnt" min="0" max="30" step="1" value="${volunteerList.volunteerMaxCnt}">
    </div>
    
    <div class="form-group">
      <label for="volunteerDt">봉사 일자</label>
      <input type="date" id="volunteerDt" name="volunteerDt" value="${volunteerList.volunteerDt}">
    </div>

    <div class="btn-group">
      <button type="button" class="btn" id="updBtn">수정</button>
      <button type="button" class="btn" id="cancelBtn">취소</button>
    </div>

  </form>
</div>