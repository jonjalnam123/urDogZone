<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty adminId || adminId eq '' || adminId eq null}">
		<header>
	  		<h1>🐶 유아독존 - 유기견 보호 플랫폼</h1>
  			<nav>
			    <ul class="menu">
			      <li><a href="/admLogin/getAdminLogin.do">홈</a></li>
			      <li>
			        <a href="/admLogin/getAdminLogin.do">보호소</a>
			        <ul class="submenu">
			          <li><a href="/admLogin/getAdminLogin.do">보호소 등록</a></li>
			        </ul>
			      </li>
			      <li>
			        <a href="/admLogin/getAdminLogin.do">팀원관리</a>
			        <ul class="submenu">
			          <li><a href="/admLogin/getAdminLogin.do">팀원 리스트</a></li>
			          <li><a href="/admLogin/getAdminLogin.do">팀원 지도</a></li>
			        </ul>
			      </li>
			      <li>
			        <a href="/admLogin/getAdminLogin.do">봉사활동</a>
			        <ul class="submenu">
			          <li><a href="/admLogin/getAdminLogin.do">봉사 일정</a></li>
			          <li><a href="/admLogin/getAdminLogin.do">봉사 장소</a></li>
			        </ul>
			      </li>
			      <li><a href="/admLogin/getAdminLogin.do">문의하기</a></li>
			      <li class="admin-login"><a href="/">사용자 홈</a></li>
			    </ul>
	  		</nav>
		</header>
	</c:when>
	<c:otherwise>
		<header>
	  		<h1>🐶 유아독존 - 유기견 보호 플랫폼</h1>
  			<nav>
			    <ul class="menu">
			      <li><a href="/admMain.do">홈</a></li>
			      <li>
			        <a href="#">보호소</a>
			        <ul class="submenu">
			          <li><a href="#">보호소 등록</a></li>
			        </ul>
			      </li>
			      <li>
			        <a href="#">팀원관리</a>
			        <ul class="submenu">
			          <li><a href="#">팀원 리스트</a></li>
			          <li><a href="#">팀원 지도</a></li>
			        </ul>
			      </li>
			      <li>
			        <a href="#">봉사활동</a>
			        <ul class="submenu">
			          <li><a href="/service/getVolunteerList.do">봉사 일정</a></li>
			          <li><a href="/service/getVolunteerPlaceList.do">봉사 장소</a></li>
			        </ul>
			      </li>
			      <li><a href="#">문의하기</a></li>
			      <li class="admin-login"><a href="/">사용자 홈</a></li>
			    </ul>
	  		</nav>
		</header>
	</c:otherwise>
</c:choose>