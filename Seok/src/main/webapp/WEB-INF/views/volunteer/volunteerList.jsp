<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerList.js"></script>

<div class="content-wrapper">
  <!-- 페이지 타이틀 + 브레드크럼 -->
  <div class="page-header">
    <h2>공지사항 목록</h2>
    <div class="breadcrumb">
      <a href="#">공지사항</a> &gt; <span>공지사항 목록</span>
    </div>
  </div>

  <!-- 검색 조건 -->
  <form action="/service/volunteerList.do" method="get" id="seacrhForm">
    <input type="text" placeholder="제목 검색">
  		<select id="param" name="param" class="combo-scroll">  
	  		<option value="" ${empty searchDTO.param ? 'selected' : ''}>지역선택</option>
	      	<c:forEach var="mainCity" items="${mainCityList}">
		  		<option value="${mainCity.cityCode}" ${searchDTO.param eq mainCity.cityCode ? 'selected' : ''}>${mainCity.cityName}</option>
		  	</c:forEach>
	  	</select>
    <button type="submit">검색</button>
  </form>

  <!-- 테이블 -->
  <div class="table-wrapper">
    <table class="table-grid">
    	<thead>
              <tr>
              	<th><input type="checkbox" id="checkAll"></th>
				<th>봉사명</th>
				<th>봉사장명</th>
				<th>모집인원</th>
				<th>봉사일자</th>
              </tr>
          </thead>
          <tbody>
		   	<c:forEach var="vol" items="${volunteerList}">
				<tr data-volcd="${vol.volunteerCd}">
				<td><input type="checkbox" class="rowCheck"></td>
				<td class="volunteerTitle">${vol.volunteerTitle}</td>
				<td>${vol.placeNm}</td>
		        <td>${vol.volunteerMaxCnt}</td>
		        <td>${vol.volunteerDt}</td>
		     	</tr>
 			</c:forEach>
        </tbody>
    </table>
  </div>

  <!-- 페이징 -->
  <c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>