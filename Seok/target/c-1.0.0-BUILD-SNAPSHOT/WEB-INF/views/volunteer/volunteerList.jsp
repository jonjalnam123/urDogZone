<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#searchBtn').on('click', function() {
		var keyword = $('#keyword').val()
		window.location.href='/service/volunteerList.do?param=' + keyword
	})
	
})

</script>

<div class="card">
  <h2 class="text-center mb-2">봉사활동 정보</h2>
  <input type="text" id="keyword" name="keyword" placeholder="제목">
  <button type="button" id="searchBtn">검색</button>
  <div class="table-responsive">
    <table class="volunteer-table w-full">
      <thead>
        <tr>
          <th>봉사 코드</th>
          <th>장소 코드</th>
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
          <tr>
            <td>${vol.volunteerCd}</td>
            <td>${vol.placeCd}</td>
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
</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />