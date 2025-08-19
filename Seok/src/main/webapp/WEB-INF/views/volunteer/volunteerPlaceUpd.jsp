<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerPlaceUpd.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사장소 수정</h2>

  <form action="/service/updVolunteerPlace.do" method="post" id="updVolunteerForm">
  	<input type="hidden" id="flag" name="flag" value="U">
	<input type="hidden" id="placeCd" name="placeCd" value="${volunteerPlace.placeCd}">
    <div class="form-group">
      <label for="placeNm">봉사장명</label>
      <input type="text" id="placeNm" name="placeNm" value="${volunteerPlace.placeNm}">
    </div>
    
    <div class="form-group">	
  	  <label for="cityCode">봉사장 지역</label>
      <select name="cityCode" id="cityCode">
        <option value="">지역선택</option>
        <c:forEach var="mainCity" items="${mainCityList}">
	  		<option value="${mainCity.cityCode}" ${volunteerPlace.cityCode eq mainCity.cityCode ? 'selected' : ''}>${mainCity.cityName}</option>
        </c:forEach>
      </select>
    </div>
    
    <div class="form-group">
      <label for="userPostcode">봉사장 주소</label>
      <div style="display: flex; gap: 10px; flex-wrap: wrap;">
        <input type="text" id="placePostCode" name="placePostCode" placeholder="우편번호"  value="${volunteerPlace.placePostCode}"readonly>
        <input type="button" class="btn" id="getPostCode" value="우편번호 찾기">
      </div>
      <input type="text" id="placeAd" name="placeAd" placeholder="도로명주소" class="mt-2" value="${volunteerPlace.placeAd}" readonly>
      <input type="text" id="placeAdd" name="placeAdd" placeholder="상세주소" class="mt-2" value="${volunteerPlace.placeAdd}">
    </div>
    
    <div class="form-group">
      <label for="placeNote">봉사장 특징</label>
      <textarea id="placeNote" name="placeNote" maxlength="333">${volunteerPlace.placeNote}</textarea>
    </div>

    <div class="btn-group">
      <button type="button" class="btn" id="updBtn">수정</button>
      <button type="button" class="btn" id="cancelBtn">취소</button>
    </div>

  </form>
</div>