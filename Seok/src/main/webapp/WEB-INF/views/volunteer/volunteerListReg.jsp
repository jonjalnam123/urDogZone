<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerListReg.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사 일정 등록</h2>

  <form action="/service/regVolunteerList.do" method="post" id="regVolunteerListForm">
    
    <div class="form-group">	
      <label for="volunteerTitle">봉사명</label>
	  <input type="text" id="volunteerTitle" name="volunteerTitle">
    </div>
    
    <div class="form-group">
    	<label for="placeCd">봉사장소</label>
		<select id="placeCd" name="placeCd" class="combo-scroll">  
		<option value="">선택</option>
   			<c:forEach var="volPlace" items="${volPlaceList}">
  				<option value="${volPlace.placeCd}">${volPlace.placeNm}</option>
	  		</c:forEach>
	  	</select>
    </div>
    
    <div class="form-group">
      <label for="volunteerNote">봉사내용</label>
      <textarea id="volunteerNote" name="volunteerNote" maxlength="333"></textarea>
    </div>
    
    <div class="form-group">
      <label for="volunteerMaxCnt">모집인원</label>
	  <input type="number"  id="volunteerMaxCnt" name="volunteerMaxCnt" min="0" max="30" step="1">
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