/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.18
 * 내용 : 봉사 장소 목록 스크립트
 */

$(document).ready(function(){
	
	// 검색 버튼 이벤트
	$('#searchBtn').on('click', function() {
		var form = $('#seacrhForm');
  		form.submit();
	})
	
	// 등록 버튼 이벤트
	$('#regBtn').on('click', function() {
		goToUri('/service/getRegVolunteerPlace.do');
	})
	
	// 이름 클릭 시 상세페이지 이동
  	$("#volPlaceTb").on("click", ".placeNm", function(){
	    var placeCd = $(this).closest("tr").data("placecd");
		var uri = "/service/updVolunteerPlace.do?placeCd=" + placeCd;
		goToUri(uri);
    });

	// 전체 선택 / 해제
	$("#checkAll").on("click", function () {
	  $(".rowCheck").prop("checked", this.checked );
	});
	
	// 삭제 버튼 이벤트
	$("#delBtn").on("click", function () {

		var conMsg = "봉사 장소를 삭제 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 	
		    var checkPlaceCdList = [];
		    $(".rowCheck:checked").each(function () {
		        var placeCd = $(this).closest("tr").data("placecd");
		        checkPlaceCdList.push(placeCd);
		    });
		
		    if (checkPlaceCdList.length === 0) {
		        alert("선택된 봉사 장소가 없습니다.");
		        return;
		    }
	
			var url = '/service/delVolunteerPlace.do';
			var params = {
					checkPlaceCdList : checkPlaceCdList
			}
			var dataType = 'json'
			
		 	ajaxStart(url, params, dataType, function(data) {
				if ( data.resultCd === 'Y' ) {
					goToUri('/service/getVolunteerPlaceList.do')
				} else {
					alert("삭제할 봉사 장소가 없습니다.");
				}
			});
		} 
	});
	
});