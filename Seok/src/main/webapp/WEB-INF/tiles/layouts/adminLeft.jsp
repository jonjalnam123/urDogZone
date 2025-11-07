<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Draw view [S] -->
<nav id="sidenavAccordion">
  <div class="sb-sidenav-menu">
    <ul>
      <!-- Home -->
      <li>
        <a class="nav-link" href="/admMain.do">
          <i class="fas fa-home"></i> 홈
        </a>
      </li>

      <!-- Volunteer -->
      <li>
        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVolunteer" aria-expanded="false" aria-controls="collapseVolunteer">
          <i class="fas fa-hands-helping"></i> 봉사활동
          <span class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></span>
        </a>
        <div class="collapse" id="collapseVolunteer" data-bs-parent="#sidenavAccordion">
          <ul>
            <li><a class="nav-link" href="/service/getVolunteerList.do">봉사일정</a></li>
            <li><a class="nav-link" href="/service/getVolunteerPlaceList.do">봉사장소</a></li>
          </ul>
        </div>
      </li>

      <!-- Pages -->
      <li>
        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
          <i class="fas fa-book-open"></i> 관리자
          <span class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></span>
        </a>
        <div class="collapse" id="collapsePages" data-bs-parent="#sidenavAccordion">
          <ul>
            <li><a class="nav-link" href="/menu/menuMng.do">메뉴관리</a></li>
          </ul>
        </div>
      </li>
      
      <!-- Pages -->
      <li>
        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSample" aria-expanded="false" aria-controls="collapseSample">
          <i class="fas fa-book-open"></i> 샘플
          <span class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></span>
        </a>
        <div class="collapse" id="collapseSample" data-bs-parent="#sidenavAccordion">
          <ul>
            <li><a class="nav-link" href="/sample/sampleForm">폼화면</a></li>
            <li><a class="nav-link" href="/sample/sampleList">리스트화면</a></li>
            <li><a class="nav-link" href="/sample/sampleTreeForm">트리폼화면</a></li>
          </ul>
        </div>
      </li>

      <!-- Addons -->
      <li>
        <a class="nav-link" href="/charts.do"><i class="fas fa-chart-area"></i> 통계</a>
      </li>
      <li>
        <a class="nav-link" href="/tables.do"><i class="fas fa-table"></i> 테이블</a>
      </li>
    </ul>
  </div>
</nav>
<!-- Draw view [E] -->