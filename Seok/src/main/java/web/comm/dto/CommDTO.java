package web.comm.dto;

import lombok.Data;

@Data
public class CommDTO {
	
	//공통코드
	private String commCd;
	
	//공통부모코드
	private String commUpperCd;
	
	//공통코드명
	private String commNm;
	
	//공통코드 삭제 여부
	private String commDelYn;
	
	//등록자 아이디
	private String regId;
	
	//등록 날짜
	private String regDt;
	
	//수정자 아이디
	private String updId;
	
	//수정 날짜
	private String updDt;
	
}
