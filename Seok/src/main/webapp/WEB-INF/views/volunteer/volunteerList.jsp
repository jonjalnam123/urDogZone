<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/resources/static/js/volunteer/volunteerList.js"></script>

<div class="card">
  <h2 class="text-center mb-2">봉사 일정</h2>
    <c:choose>
  	<c:when test="${empty volunteerList || volunteerList eq null || volunteerList eq ''}">
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
  		<h2>봉사목록 데이터가 없습니다.</h2>
  	</c:when>
  	<c:otherwise>
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
	    	<table id="volListTb" class="volunteer-table w-full">
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
	  <c:import url="/WEB-INF/views/layout/paging.jsp" />
  	</c:otherwise>
  </c:choose>
</div>