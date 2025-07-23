/*
* 공통 JS
*/


/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : 공통 AJAX 통신 함수
* 파라미터 : URL, PARAMS, DATATYPE, CALLBACK
**************************************************************/
function ajaxStart(url, params, dataType, callback) {
	$.ajax({
	    url: url,
	    method: 'post',
	    data : params,
	    dataType : dataType,
	    success: function (data, status, xhr) {
	        if (typeof callback === 'function' && callback !== null ) {
				console.log('data>>>>', data);
	            callback(data);
	        } else {
	            console.warn("callback이 function이 아닙니다:", callback);
	        }
	    },
	    error: function (data, status, err) {
			console.error("AJAX 에러", err);
	    }
	});
}

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : 현재서버 URI 확인
* 파라미터 : 
**************************************************************/
function getNowUri() {
	const fullUrl = window.location.origin;
	return fullUrl;
}

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : kakao 주소 찾기 함수
* 파라미터 : 
**************************************************************/
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('userPostcode').value = data.zonecode;
            document.getElementById("userAd").value = roadAddr;
        }
    }).open();
}

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : 빈 값 확인 함수
* 파라미터 : param ( value 값 )
**************************************************************/
function isEmpty(param) {
	if ( param === '' || param === null || param === undefined ) {
		return false;
	} else {
		return true;
	}
};

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : 라디오 버튼 체크 값 구하기 함수
* 파라미터 : name ( name 태그 값 )
**************************************************************/
function getCheckedVal(name) {
	const value = $('input[name=' + name + ']:checked').val();
	return value;
};

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : URI 경로 이동 함수
* 파라미터 : uri ( 호출경로 )
**************************************************************/
function goToUri(uri) {
	window.location.href = uri;
};

/*************************************************************
* 작성자 : 최정석
* 작성날짜 : 2025.07.22
* 내용 : Confirm 호출 함수
* 파라미터 : conMsg
**************************************************************/
function callConfirm(conMsg) {
	
	var result = '';
	
	if(confirm(conMsg)){
		result = 'Y'
	}else{
		result = 'N'
	}

	return result
};