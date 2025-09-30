<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Draw view [S] -->
<div class="content-wrapper">

  <!-- 페이지 타이틀 + 브레드크럼 -->
  <div class="page-header">
    <h2>공지사항 목록</h2>
    <div class="breadcrumb">
      <a href="#">공지사항</a> &gt; <span>공지사항 목록</span>
    </div>
  </div>

  <!-- 검색 조건 -->
  <form class="search-form">
    <input type="text" placeholder="제목 검색">
    <select>
      <option value="">전체</option>
      <option value="공지">공지</option>
      <option value="이벤트">이벤트</option>
    </select>
    <button type="submit">검색</button>
  </form>

  <!-- 테이블 -->
  <div class="table-wrapper">
    <table class="table-grid">
      <thead>
        <tr>
          <th>No</th>
          <th>제목</th>
          <th>작성자</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody>
        <tr><td>1</td><td>시스템 점검 안내</td><td>관리자</td><td>2025-09-30</td></tr>
        <tr><td>2</td><td>이벤트 공지</td><td>운영팀</td><td>2025-09-28</td></tr>
        <tr><td>3</td><td>업데이트 내역</td><td>개발팀</td><td>2025-09-25</td></tr>
      </tbody>
    </table>
  </div>

  <!-- 페이징 -->
  <div class="pagination">
    <button>&laquo;</button>
    <button class="active">1</button>
    <button>2</button>
    <button>3</button>
    <button>&raquo;</button>
  </div>

</div>
<!-- Draw view [E] -->