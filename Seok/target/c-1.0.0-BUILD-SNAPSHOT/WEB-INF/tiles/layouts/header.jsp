<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
  <h1>🐶 유아독존 - 유기견 보호 플랫폼</h1>
  <nav>
    <ul class="menu">
      <li><a href="/">홈</a></li>
      <li>
        <a href="#">보호소 소개</a>
        <ul class="submenu">
          <li><a href="#">기관 안내</a></li>
          <li><a href="#">오시는 길</a></li>
        </ul>
      </li>
      <li>
        <a href="#">입양하기</a>
        <ul class="submenu">
          <li><a href="#">입양 절차</a></li>
          <li><a href="#">입양 가능한 강아지</a></li>
        </ul>
      </li>
      <li>
        <a href="#">봉사활동</a>
        <ul class="submenu">
          <li><a href="#">봉사 신청</a></li>
          <li><a href="#">봉사 내역</a></li>
        </ul>
      </li>
      <li><a href="#">문의하기</a></li>
	  <c:choose>
	  	<c:when test="${empty adminId || adminId eq '' || adminId eq null}">
     		<li class="admin-login"><a href="/admLogin/getAdminLogin.do">관리자 로그인</a></li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="admin-login"><a href="/admMain.do">관리자 로그인</a></li>
	  	</c:otherwise>
	  </c:choose>
    </ul>
  </nav>
</header>