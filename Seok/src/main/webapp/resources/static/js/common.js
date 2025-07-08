/**
 * 공통 기능 JS
 */
 
function ajaxStart(url, params, dataType) {
	
	$.ajax({
    url: url,
    method: 'post',
    data : params,
    dataType : dataType,
    success: function (data, status, xhr) {
		console.log('성공 데이터====', data);
    },
    error: function (data, status, err) {
		console.log('실패 데이터====', data);
    }
});
	
}