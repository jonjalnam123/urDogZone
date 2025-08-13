package web.comm.dto;

import lombok.Data;

@Data
public class CommCityDTO {
	
	// 도시코드
	private int cityCode;
	
	// 도시 부모코드
	private int cityParentCode;
	
	// 도시 시/도
	private String cityName;
	
	// 도시 시/군/구
	private String cityDistrict;
	
	// 도시 삭제 여부
	private String cityDelYn;
	
	//등록자 아이디
	private String regId;
	
	//등록 날짜
	private String regDt;
	
	//수정자 아이디
	private String updId;
	
	//수정 날짜
	private String updDt;
}
