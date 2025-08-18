/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.18
 * 내용 : 봉사 장소 등록 스크립트
 */

$(document).ready(function(){
	
	// 우편 번호 찾기 이벤트
	$('#getPostCode').on('click', function() {
		var postId =  $('#placePostCode').attr('id');
		var adId = $('#placeAd').attr('id');
		execDaumPostcode( postId, adId );
	})
	
	$('#regBtn').on('click', function() {
		var conMsg = "봉사장소를 등록 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 
			var form = $('#regVolunteerForm');
	  		form.submit();
		} 
	});
	
});