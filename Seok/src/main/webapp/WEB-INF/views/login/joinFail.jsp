<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function() {
	$('#goToMainBtn').on('click', function() {
		window.location.href = '/';
	})
});
</script>
<div>
	<h2>가입실패</h2>
	<button type="button" id="goToMainBtn">메인으로</button>
</div>