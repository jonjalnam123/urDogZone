/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.09.09
 * 내용 : 관리자 헤더 스크립트
 */
$(document).ready(function () {
	
	// 사이드 메뉴 토글 이벤트
    var $sidebarToggle = $('#sidebarToggle');
    if ($sidebarToggle.length) {
        // Uncomment below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     $('body').toggleClass('sb-sidenav-toggled');
        // }

        $sidebarToggle.on('click', function (e) {
            e.preventDefault();
            $('body').toggleClass('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', $('body').hasClass('sb-sidenav-toggled'));
        });
    }

	// 로그아웃 이벤트
	$('#logoutBtn').on('click', function() {
		goToUri('/admLogin/admLogout.do');
	});
	
});
