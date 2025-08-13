package web.volunteer.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.util.Paging;
import web.volunteer.dao.face.VolunteerDao;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;
import web.volunteer.dto.VolunteerPlaceDTO;
import web.volunteer.service.face.VolunteerService;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired VolunteerDao volunteerDao;
	
	/**
	******************************************
	* @MethodName    : getVolunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 화면 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerDTO> getVolunteerList(Paging paging) {
		logger.info("=== 봉사목록 화면 조회 임플 진입 ===");  
		return volunteerDao.getVolunteerList(paging);
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
		int totalCount = volunteerDao.selectCntSearchAll(searchDTO);
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	/**
	******************************************
	* @MethodName    : volunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerDTO> volunteerList(Map<String, Object> paramMap) {
		return volunteerDao.volunteerList(paramMap);
	}
	
	/**
	******************************************
	* @MethodName    : getVolunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.12
	* @Comment : 봉사 장소 화면 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerPlaceDTO> getVolunteerPlaceList(Paging paging) {
		logger.info("=== 봉사장소 화면 조회 임플 진입 ===");  
		return volunteerDao.getVolunteerPlaceList(paging);
	}
	
	/**
	******************************************
	* @MethodName    : volunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 장소 목록 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerPlaceDTO> volunteerPlaceList(Map<String, Object> paramMap) {
		return volunteerDao.volunteerPlaceList(paramMap);
	}

}
