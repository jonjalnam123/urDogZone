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
	
	// 등록 버튼 이벤트
	$('#updBtn').on('click', function() {
		var conMsg = "봉사장소를 수정 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 
			var form = $('#updVolunteerForm');
	  		form.submit();
		} 
	});
	
	// 취소 버튼 이벤트
	$('#cancelBtn').on('click', function(){
		goToUri('/service/getVolunteerPlaceList.do');
	});
	
});