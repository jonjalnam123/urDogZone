/**
 * 작성자 : 최정석
 * 작성날짜 : 2025.08.18
 * 내용 : 봉사 목록 스크립트
 */

$(document).ready(function(){
	
	// 검색 버튼 이벤트
	$('#searchBtn').on('click', function() {
		var form = $('#seacrhForm');
  		form.submit();
	})
	
	// 등록 버튼 이벤트
	$('#regBtn').on('click', function() {
		goToUri('/service/getRegVolunteerList.do');
	})
	
	// 전체 선택 / 해제
	$("#checkAll").on("click", function () {
	  $(".rowCheck").prop("checked", this.checked );
	});
	
	// 봉사명 클릭 시 상세페이지 이동
  	$("#volListTb").on("click", ".volunteerTitle", function(){
	    var volCd = $(this).closest("tr").data("volcd");
		var uri = "/service/updVolunteerList.do?volCd=" + volCd;
		goToUri(uri);
    });
	
	// 삭제 버튼 이벤트
	$("#delBtn").on("click", function () {
		
		var conMsg = "봉사 일정을 삭제 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 	
		    var checkVolCdList = [];
		    $(".rowCheck:checked").each(function () {
		        var volCd = $(this).closest("tr").data("volcd");
		        checkVolCdList.push(volCd);
		    });
		
		    if (checkVolCdList.length === 0) {
		        alert("선택된 봉사 일정이 없습니다.");
		        return;
		    }
	
			var url = '/service/delVolunteerList.do';
			var params = {
					checkVolCdList : checkVolCdList
			}
			var dataType = 'json'
			
		 	ajaxStart(url, params, dataType, function(data) {
				if ( data.resultCd === 'Y' ) {
					goToUri('/service/getVolunteerList.do')
				} else {
					alert("삭제할 봉사 일정이 없습니다.");
				}
			});
		} 
	});
	
});