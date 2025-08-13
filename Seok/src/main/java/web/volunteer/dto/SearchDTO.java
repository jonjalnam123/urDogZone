package web.volunteer.dto;

import lombok.Data;

@Data
public class SearchDTO {
	
	// 검색 조건
	private String param;
	
	// 검색 조건 1
	private String param1;
	
	// 검색 조건 2
	private String param2;
	
	// 검색 조건 테이블 명
	private String tbNm;
	
	// 검색 조건 테이블 컬럼
	private String col;
	
	// 검색 조건 테이블 컬럼1
	private String col1;
	
	// 검색 조건 테이블 컬럼2
	private String col2;

}
