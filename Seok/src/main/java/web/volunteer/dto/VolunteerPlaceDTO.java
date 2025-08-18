package web.volunteer.dto;

import lombok.Data;

@Data
public class VolunteerPlaceDTO {
	
	// 봉사장 코드
	private int placeCd;
	
	// 봉사장명
	private String placeNm;
	
	// 봉사장 우편번호
	private String placePostCode;
	
	// 봉사장 주소
	private String placeAd;
	
	// 봉사장 상세 주소
	private String placeAdd;
	
	// 도시 지역 이름
	private String cityName;
	
	// 도시 코드 
	private String cityCode;
	
	// 봉사장 특징
	private String placeNote;
	
	// 봉사장 삭제 유무
	private String placeDelYn;
	
	// 첨부파일 번호
	private String fileNo;
	
	// 등록자 아이디
	private String regId;
	
	// 등록 날짜
	private String regDt;
	
	// 수정자 아이디
	private String updId;
	
	// 수정 날짜
	private String updDt;

}
