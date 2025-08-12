<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#searchBtn').on('click', function() {
		var form = $('#seacrhForm');
  		form.submit();
	})
	
})

</script>

<div class="card">
  <h2 class="text-center mb-2">봉사활동 정보</h2>
  
  <form action="/service/volunteerList.do" method="get" id="seacrhForm" >
	  <input type="text" id="param1" name="param1" placeholder="제목" value="${searchDTO.param1}">
	  <button type="button" id="searchBtn">검색</button>
  </form>
  
  <div class="table-responsive">
    <table class="volunteer-table w-full">
      <thead>
        <tr>
          <th>이름</th>
          <th>주소</th>
          <th>특징</th>
          <th>등록일</th>
          <th>등록자</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="volPlace" items="${volunteerPlaceList}">
          <tr>
            <td>${volPlace.placeNm}</td>
            <td>${volPlace.placeAd}</td>
            <td>${volPlace.placeNote}</td>
            <td>${volPlace.regId}</td>
            <td>${volPlace.regDt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />