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
	
	// 이름 클릭 시 상세페이지 이동
  	$(".volunteer-table").on("click", ".placeNm", function(){
	    var placeCd = $(this).closest("tr").data("placecd");
		var uri = "/service/updVolunteerPlace.do?placeCd=" + placeCd;
		goToUri(uri);
    });
	
});