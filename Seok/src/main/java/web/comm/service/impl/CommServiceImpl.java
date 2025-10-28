package web.comm.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.comm.dao.face.CommDao;
import web.comm.dto.CommCityDTO;
import web.comm.dto.CommDTO;
import web.comm.dto.FileDTO;
import web.comm.service.face.CommService;
import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;

@Service
public class CommServiceImpl implements CommService{
	
	@Autowired CommDao commDao;
	@Autowired HttpSession session;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 파일 업로드 경로
	private final String uploadDir = "C:/upload/volunteer/";
	
	/**
	******************************************
	* @MethodName    : getEmailCd
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 이메일 코드 조회
	* @Param : code
	* @return
	*******************************************
	*/
	@Override
	public List<CommDTO> getEmailCd(String code) {
		
		List<CommDTO> commEmailList = commDao.getEmailCd(code);
		
		if ( commEmailList.isEmpty() || commEmailList.size() < 0 || commEmailList == null ) {
			commEmailList = null;
		}
		
		return commEmailList;
	}
	
	/**
	******************************************
	* @MethodName    : getMainCity
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 메인 도시 조회
	* @return
	*******************************************
	*/
	@Override
	public List<CommCityDTO> getMainCity() {
		List<CommCityDTO> mainCityList = commDao.getMainCity();
		
		if( mainCityList.isEmpty() || mainCityList.size() < 0 || mainCityList == null ) {
			mainCityList = null;
		}
		
		return mainCityList;
	}
	
	/**
	******************************************
	* @MethodName    : getVolPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.26
	* @Comment : 봉사 장소 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerDTO> getVolPlaceList() {
		List<VolunteerDTO> volPlaceList = commDao.getVolPlaceList();
		
		if( volPlaceList.isEmpty() || volPlaceList.size() < 0 || volPlaceList == null ) {
			volPlaceList = null;
		}
		
		return volPlaceList;
	}
	
	/**
	******************************************
	* @MethodName    : getPaging
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 전체 목록 페이징 처리
	* @Param : curPage, tbNm
	* @return
	*******************************************
	*/
	@Override
	public Paging getPaging(int curPage, String tbNm) {
		
		//총 게시글 수 조회
		int totalCount = commDao.selectCntall(tbNm);
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	/**
	******************************************
	* @MethodName    : getSearchPaging
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 검색 조건 페이징 처리
	* @Param : curPage, searchDTO
	* @return
	*******************************************
	*/
	@Override
	public Paging getSearchPaging(int curPage, SearchDTO searchDTO) {	
		
		//총 게시글 수 조회
		int totalCount = commDao.selectCntSearchAll(searchDTO); 
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	/**
	******************************************
	* @MethodName    : saveFiles
	* @Author        : Jung Seok Choi
	* @Date        : 2025.09.03
	* @Comment : 파일 업로드
	* @Param : files ( 파일 리스트 )
	* @Param : refNo ( 참조 번호 )
	* @Param : refType ( 참조 타입 )
	* @return
	*******************************************
	*/
	@Override
	public int saveFiles(List<MultipartFile> files, int refNo, String refType) throws IOException {
		logger.info("=== 파일 업로드 진입 ===");  
		int result = 0;
	    for (MultipartFile file : files) {
	        if (!file.isEmpty()) {
	        	
	            // 원본 파일명
	            String originalName = file.getOriginalFilename();
	            
	            // 확장자 추출 
	            String ext = "";
	            if (originalName != null && originalName.lastIndexOf(".") > -1) {
	                ext = originalName.substring(originalName.lastIndexOf("."));
	            }
	            
	            // 저장 파일명 (UUID)
	            String saveName = UUID.randomUUID().toString() + ext;
	            
	            // 저장 경로
	            File dest = new File(uploadDir, saveName);
	            if (!dest.getParentFile().exists()) {
	                dest.getParentFile().mkdirs();
	            }
	            file.transferTo(dest);
	
	            // DTO 세팅
	            FileDTO fileDTO = new FileDTO();
	            fileDTO.setFileRefNo(refNo);
	            fileDTO.setFileRefType(refType);
	            fileDTO.setFileOrgNm(originalName);
	            fileDTO.setFileSaveNm(saveName);
	            fileDTO.setFilePath(dest.getAbsolutePath());
	            fileDTO.setFileSize((int) file.getSize());
	            fileDTO.setFileContentType(file.getContentType());
	
	            // 로그인에 따라 분기
	            if (session.getAttribute("adminId") != null) {
	            	 fileDTO.setRegId((String) session.getAttribute("adminId"));
	            	 fileDTO.setUpdId((String) session.getAttribute("adminId"));
	            } else {
	               	 fileDTO.setRegId((String) session.getAttribute("userId"));
	               	 fileDTO.setUpdId((String) session.getAttribute("userId"));
	            }
	            
	            // DB 저장
	            result = commDao.saveFiles(fileDTO);
	        }
	    }
	    
	    return result;
		
	}

}
