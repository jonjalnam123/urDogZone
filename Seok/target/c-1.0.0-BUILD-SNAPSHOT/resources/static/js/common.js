/**
 * 공통 기능 JS
 */

// AJAX 통신 함수
function ajaxStart(url, params, dataType) {
	
	$.ajax({
    url: url,
    method: 'post',
    data : params,
    dataType : dataType,
    success: function (data, status, xhr) {

    },
    error: function (data, status, err) {

    }
});
	
}

// 현재 서버 URI 구하기
function getNowUri() {
	const fullUrl = window.location.origin;
	return fullUrl;
}