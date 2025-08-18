/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.18
 * 내용 : 봉사 장소 목록 스크립트
 */

$(document).ready(function(){
	
	$('#searchBtn').on('click', function() {
		var form = $('#seacrhForm');
  		form.submit();
	})
	
	$('#regBtn').on('click', function() {
		goToUri('/service/getRegVolunteerPlace.do');
	})
	
});