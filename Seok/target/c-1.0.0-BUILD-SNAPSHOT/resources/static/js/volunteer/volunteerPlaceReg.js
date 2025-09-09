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
	$('#regBtn').on('click', function() {
		var conMsg = "봉사장소를 등록 하시겠습니까?"
		var conResult = callConfirm(conMsg);
		if ( conResult === 'Y') { 
			var form = $('#regVolunteerPlaceForm');
	  		form.submit();
		} 
	});
	
	// 취소 버튼 이벤트
	$('#cancelBtn').on('click', function(){
		goToUri('/service/getVolunteerPlaceList.do');
	});
	
    document.getElementById("addFileBtn").addEventListener("click", function() {
    const fileInputsDiv = document.getElementById("fileInputs");

    // 새 파일 입력 행 생성
    const fileRow = document.createElement("div");
    fileRow.className = "file-row";

    const newInput = document.createElement("input");
    newInput.type = "file";
    newInput.name = "files";
    newInput.className = "file-input";

    const removeBtn = document.createElement("button");
    removeBtn.type = "button";
    removeBtn.className = "removeFileBtn";
    removeBtn.textContent = "삭제";

    // 삭제 이벤트 연결
    removeBtn.addEventListener("click", function() {
      fileRow.remove();
    });

    fileRow.appendChild(newInput);
    fileRow.appendChild(removeBtn);
    fileInputsDiv.appendChild(fileRow);
  });

  // 초기 "삭제" 버튼 이벤트 연결
  document.querySelectorAll(".removeFileBtn").forEach(btn => {
    btn.addEventListener("click", function() {
      btn.parentElement.remove();
    });
  });
	
});