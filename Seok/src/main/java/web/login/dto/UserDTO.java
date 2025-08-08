package web.login.dto;

import lombok.Data;

@Data
public class UserDTO {
	
	//사용자 아이디
	private String userId;
	
	//사용자 비밀번호
	private String userPw;
	
	//사용자 이름
	private String userNm;
	
	//사용자 우편번호
	private String userPostcode;
	
	//사용자 주소
	private String userAd;
	
	//사용자 상세주소
	private String userAdd;
	
	//사용자 이메일
	private String userEmail;
	
	//사용자 핸드폰
	private String userPhone;
	
	//사용자 생일
	private String userBirth;
	
	//사용자 자동차 보유 유무
	private String userCarYn;
	
	//사용자 봉사경험 유무
	private String userVolExpYn;
	
	//사용자 카풀제공 가능 유무
	private String userCarPoolYn;
	
	//사용자 약관동의 1
	private String userTermsF;
	
	//사용자 약관동의 2
	private String userTermsS;
	
	//사용자 분류
	private String userType;
	
	//사용자 봉사 횟 수
	private String userVolCnt;
	
	//등록자 아이디
	private String regId;
	
	//등록 날짜
	private String regDt;
	
	//수정자 아이디
	private String updId;
	
	//수정 날짜
	private String updDt;
	
}
