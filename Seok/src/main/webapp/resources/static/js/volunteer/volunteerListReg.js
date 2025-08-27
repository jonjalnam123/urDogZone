/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.20
 * 내용 : 봉사 일정 등록 스크립트
 */

$(document).ready(function(){
	
	// 등록 버튼 이벤트
	$('#regBtn').on('click', function() {
		var conMsg = "봉사일정을 등록 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 
			var form = $('#regVolunteerListForm');
	  		form.submit();
		} 
	});
	
	// 모집 인원 이벤트
	$('#volunteerMaxCnt').on('keyup', function(){
		$(this).val(checkNum('volunteerMaxCnt'));
	});
	
	// 취소 버튼 이벤트
	$('#cancelBtn').on('click', function(){
		goToUri('/service/getVolunteerList.do');
	});
});