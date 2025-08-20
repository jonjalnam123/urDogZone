package web.volunteer.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.util.Paging;
import web.volunteer.dao.face.VolunteerDao;
import web.volunteer.dto.VolunteerDTO;
import web.volunteer.dto.VolunteerPlaceDTO;
import web.volunteer.service.face.VolunteerService;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired VolunteerDao volunteerDao;
	@Autowired private HttpSession session;
	
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
	* @MethodName    : volunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 조회
	* @return
	*******************************************
	*/
	@Override
	public List<VolunteerDTO> volunteerList(Map<String, Object> paramMap) {
		logger.info("=== 봉사 목록 조회 임플 진입 ===");  
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
		logger.info("=== 봉사 장소 화면 조회 임플 진입 ===");  
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
		logger.info("=== 봉사 장소 목록 조회 임플 진입 ===");  
		return volunteerDao.volunteerPlaceList(paramMap);
	}
	
	/**
	******************************************
	* @MethodName    : regVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 등록
	* @return
	*******************************************
	*/
	@Override
	public int regVolunteerPlace(VolunteerPlaceDTO volunteerPlaceDTO) {
		logger.info("=== 봉사 장소 등록 임플 진입 ===");  
		String admId = (String) session.getAttribute("adminId");
		volunteerPlaceDTO.setRegId(admId);
		volunteerPlaceDTO.setUpdId(admId);
		int result = volunteerDao.regVolunteerPlace(volunteerPlaceDTO);
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : getVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 상세 조회
	* @return
	*******************************************
	*/
	@Override
	public VolunteerPlaceDTO getVolunteerPlaceDetail(VolunteerPlaceDTO volunteerPlaceDTO) {
		logger.info("=== 봉사 장소 상세 조회 임플 진입 ===");  
		int placeCd = volunteerPlaceDTO.getPlaceCd();
		VolunteerPlaceDTO volunteerPlace = volunteerDao.getVolunteerPlaceDetail(placeCd);
		if ( volunteerPlace == null ) {
			volunteerPlace = null;
		}
		return volunteerPlace;
	}
	
	/**
	******************************************
	* @MethodName    : updVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 수정
	* @return
	*******************************************
	*/
	@Override
	public int updVolunteerPlace(VolunteerPlaceDTO volunteerPlaceDTO) {
		logger.info("=== 봉사 장소 수정 임플 진입 ===");  
		String admId = (String) session.getAttribute("adminId");
		volunteerPlaceDTO.setUpdId(admId);
		int result = volunteerDao.updVolunteerPlace(volunteerPlaceDTO);
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : delVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.20
	* @Comment : 봉사 장소 삭제
	* @return
	*******************************************
	*/
	@Override
	public int delVolunteerPlace(VolunteerPlaceDTO volunteerPlaceDTO) {
		logger.info("=== 봉사 장소 삭제 임플 진입 ===");  
		int result = volunteerDao.delVolunteerPlace(volunteerPlaceDTO);
		return result;
	}

}
