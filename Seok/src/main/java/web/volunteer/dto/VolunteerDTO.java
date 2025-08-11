package web.volunteer.dto;

import lombok.Data;

@Data
public class VolunteerDTO {
	
	//봉사 코드
	private String volunteerCd;
	
	//봉사 장소 코드
	private String placeCd;
	
	//봉사 장소 이름
	private String placeNm;
	
	//봉사 장소 도시
	private String volunteerLocateCityCd;
	
	//봉사 제목
	private String volunteerTitle;
	
	//봉사 설명
	private String volunteerNote;
	
	//봉사 신청 최대 인원
	private String volunteerMaxCnt;
	
	//봉사 날짜
	private String volunteerDt;
	
	//등록자 아이디
	private String regId;
	
	//등록 날짜
	private String regDt;
	
	//수정자 아이디
	private String updId;
	
	//수정 날짜
	private String updDt;
}
