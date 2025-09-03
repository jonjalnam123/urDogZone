package web.comm.dto;

import lombok.Data;

@Data
public class FileDTO {
	
	// PK
    private int fileNo;             
    
    // 참조 PK (예: placeCd)
    private int fileRefNo;         
    
    // 참조 타입 (예: volPlace)
    private String fileRefType;     
    
    // 원본 파일명
    private String fileOrgNm;       
    
    // 저장 파일명
    private String fileSaveNm;    
    
    // 저장 경로
    private String filePath;       
    
    // 파일 크기
    private long fileSize;         
    
    // MIME 타입
    private String fileContentType; 
    
    // 등록자
    private String regId;           
    
    // 등록일
    private String regDt;           
    
    // 수정자
    private String updId;           
    
    // 수정일
    private String updDt;          

}
