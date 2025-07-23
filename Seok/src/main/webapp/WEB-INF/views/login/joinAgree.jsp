<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	
	const $checkAll = $('#checkAll');
	const $terms1 = $('#terms1');
	const $terms2 = $('#terms2');
	const $nextBtn = $('#nextBtn');
	
	$('#nextBtn').on('click', function () {
		
		const terms1Agreed = $('#terms1').is(':checked') ? 'Y' : 'N';
		const terms2Agreed = $('#terms2').is(':checked') ? 'Y' : 'N';
		
		window.location.href = '/join/getJoinPage.do?terms1=' + terms1Agreed + '&terms2=' + terms2Agreed;
	});
	
	// 전체 동의 클릭 시
	$checkAll.on('change', function () {
	  const isChecked = $(this).prop('checked');
	  $terms1.prop('checked', isChecked);
	  $terms2.prop('checked', isChecked);
	  updateButtonState();
	});
	
	// 개별 체크박스 클릭 시
	$terms1.add($terms2).on('change', function () {
	  const allChecked = $terms1.prop('checked') && $terms2.prop('checked');
	  $checkAll.prop('checked', allChecked);
	  updateButtonState();
	});
	
	// 초기 버튼 상태 확인
	updateButtonState();
	
});

// 버튼 상태 업데이트 함수
function updateButtonState() {
  if ($('#terms1').prop('checked') && $('#terms2').prop('checked')) {
	  $('#nextBtn').prop('disabled', false);
  } else {
	  $('#nextBtn').prop('disabled', true);
  }
}

</script>
<div class="card">
	<h2 class="text-center mb-2">약관에 동의해주세요</h2>
	
	<!-- 전체 동의 -->
	<div class="mb-2">
	  <input type="checkbox" id="checkAll" />
	  <label for="checkAll"><strong>전체 동의</strong></label>
	</div>
	
	<!-- 서비스 이용 약관 -->
	<div class="mb-2">
	  <div class="card" style="height: 150px; overflow-y: scroll; font-size: 14px;">
	    <strong>[서비스 이용 약관]</strong><br/>
	    본 서비스는 유기견 봉사활동을 위한 플랫폼입니다. 회원은 선의와 책임감을 가지고 서비스를 이용해야 하며...
	  </div>
	  <input type="checkbox" id="terms1" value="Y"/>
	  <label for="terms1">(필수) 서비스 이용 약관에 동의합니다</label>
	</div>
	
	<!-- 개인정보 수집 및 이용 -->
	<div class="mb-2">
	  <div class="card" style="height: 150px; overflow-y: scroll; font-size: 14px;">
	    <strong>[개인정보 수집 및 이용 동의]</strong><br/>
	    이름, 이메일, 전화번호는 봉사 신청, 활동 내역 저장 등의 목적으로 수집됩니다. 수집된 정보는 보안 정책에 따라 보호되며...
	  </div>
	  <input type="checkbox" id="terms2"  value="Y"/>
	  <label for="terms2">(필수) 개인정보 수집 및 이용에 동의합니다</label>
	</div>
	
	<!-- 다음 버튼 -->
	<div class="mt-4">
	  <button type="button" class="btn w-full" id="nextBtn">다음 단계로</button>
	</div>
</div>