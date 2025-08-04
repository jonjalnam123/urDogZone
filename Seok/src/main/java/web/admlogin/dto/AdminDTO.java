package web.admlogin.dto;

import lombok.Data;

@Data
public class AdminDTO {
	
	//관리자 아이디
	private String adminId;
	
	//관리자 이름
	private String adminNm;
	
	//관리자 비밀번호
	private String adminPw;
	
	//관리자 삭제 유무
	private String adminDelYn;
	
	//관리자 분류
	private String adminType;
	
	//등록자 아이디
	private String regId;
	
	//등록 날짜
	private String regDt;
	
	//수정자 아이디
	private String updId;
	
	//수정 날짜
	private String updDt;

}
