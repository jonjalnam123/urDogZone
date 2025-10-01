<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerPlaceList.js"></script>

<div class="content-wrapper">
  <!-- 페이지 타이틀 + 브레드크럼 -->
  <div class="page-header">
    <h2>봉사장소 목록</h2>
    <div class="breadcrumb">
      <a href="#">봉사활동</a> &gt; <span>봉사장소 목록</span>
    </div>
  </div>
  
  <!-- 검색 조건 -->
  <div class="search-bar">
    <form class="search-form" action="/service/volunteerPlaceList.do" method="get" id="seacrhForm">
  		<select id="param" name="param" class="combo-scroll">  
	  		<option value="" ${empty searchDTO.param ? 'selected' : ''}>지역선택</option>
	      	<c:forEach var="mainCity" items="${mainCityList}">
		  		<option value="${mainCity.cityCode}" ${searchDTO.param eq mainCity.cityCode ? 'selected' : ''}>${mainCity.cityName}</option>
		  	</c:forEach>
	  	</select>
      <input type="text" class="search-input" id="param1" name="param1" placeholder="제목 검색" value="${searchDTO.param1}">
      <button type="button" id="searchBtn" class="search-btn">검색</button>
      <button type="button" id="regBtn" class="btn-insert">등록</button>
  	  <button type="button" id="delBtn" class="btn-delete">삭제</button>
    </form>
  </div>
  
  <c:choose>
  	<c:when test="${empty volunteerPlaceList || volunteerPlaceList eq null || volunteerPlaceList eq ''}">
	  <h2>봉사장소 데이터가 없습니다.</h2>
  	</c:when>
  	<c:otherwise>
  		<!-- 테이블 -->
	  	<div class="table-wrapper">
		    <table class="table-grid" id="volPlaceTb">
	      		<thead>
			        <tr>
		          		<th><input type="checkbox" id="checkAll"></th>
			          	<th>봉사장명</th>
			          	<th>봉사장 지역</th>
			          	<th>봉사장 주소</th>
			        </tr>
		      	</thead>
		      	<tbody>
	       		  	<c:forEach var="volPlace" items="${volunteerPlaceList}">
	       				<tr data-placecd="${volPlace.placeCd}">
		 		        	<td><input type="checkbox" class="rowCheck"></td>
				            <td class="placeNm">${volPlace.placeNm}</td>
				            <td>${volPlace.cityName}</td>
				            <td>${volPlace.placeAd}&nbsp;${volPlace.placeAdd}</td>
			       		</tr>
			        </c:forEach>
	      		</tbody>
		    </table>
	  	</div>
	  	<c:import url="/WEB-INF/views/layout/paging.jsp" />
  	</c:otherwise>
  </c:choose>
</div>