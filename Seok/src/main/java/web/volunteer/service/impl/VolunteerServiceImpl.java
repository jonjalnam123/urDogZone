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
import web.volunteer.service.face.VolunteerService;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired VolunteerDao volunteerDao;
	
	@Override
	public Paging getPaging(int curPage) {
		
		//총 게시글 수 조회
		int totalCount = volunteerDao.selectCntall();
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<VolunteerDTO> getVolunteerList(Paging paging) {
		logger.info("=== 봉사목록 화면 임플 진입 ===");  
		return volunteerDao.getVolunteerList(paging);
	}
	
	@Override
	public Paging getPaging(int curPage, SearchDTO searchDTO) {	
		
		//총 게시글 수 조회
		int totalCount = volunteerDao.selectCntallNew(searchDTO);
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<VolunteerDTO> getVolunteerListNew(Map<String, Object> paramMap) {
		return volunteerDao.getVolunteerListNew(paramMap);
	}

}
