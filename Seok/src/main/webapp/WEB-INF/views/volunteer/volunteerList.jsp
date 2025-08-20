<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerList.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사활동 정보</h2>
  
  <form action="/service/volunteerList.do" method="get" id="seacrhForm" >
  	  <select id="param" name="param" class="combo-scroll">  
		  <option value="" ${empty searchDTO.param ? 'selected' : ''}>지역선택</option>
	      <c:forEach var="mainCity" items="${mainCityList}">
			  <option value="${mainCity.cityCode}" ${searchDTO.param eq mainCity.cityCode ? 'selected' : ''}>${mainCity.cityName}</option>
		  </c:forEach>
	  </select>
	  <input type="text" id="param1" name="param1" placeholder="제목" value="${searchDTO.param1}">
	  <button type="button" id="searchBtn">검색</button>
	  <button type="button" id="regBtn">등록</button>
	  <button type="button" id="delBtn">삭제</button>
  </form>
  
  <div class="table-responsive">
    <table class="volunteer-table w-full">
      <thead>
        <tr>
          <th>장소명</th>
          <th>제목</th>
          <th>설명</th>
          <th>모집 인원</th>
          <th>봉사 일자</th>
          <th>등록자</th>
          <th>등록일</th>
          <th>수정자</th>
          <th>수정일</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="vol" items="${volunteerList}">
			<tr data-volcd="${vol.volunteerCd}">
				<td>${vol.placeNm}</td>
	            <td>${vol.volunteerTitle}</td>
	            <td>${vol.volunteerNote}</td>
	            <td>${vol.volunteerMaxCnt}</td>
	            <td>${vol.volunteerDt}</td>
	            <td>${vol.regId}</td>
	            <td>${vol.regDt}</td>
	            <td>${vol.updId}</td>
	            <td>${vol.updDt}</td>
          	</tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>