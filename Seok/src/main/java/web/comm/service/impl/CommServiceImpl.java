package web.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.comm.dao.face.CommDao;
import web.comm.dto.CommCityDTO;
import web.comm.dto.CommDTO;
import web.comm.service.face.CommService;
import web.util.Paging;
import web.volunteer.dto.SearchDTO;

@Service
public class CommServiceImpl implements CommService{
	
	@Autowired CommDao commDao;
	
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
		System.out.println("searchDTO====" + searchDTO);
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

}
