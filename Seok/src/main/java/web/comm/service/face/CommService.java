package web.comm.service.face;

import java.util.List;

import web.comm.dto.CommCityDTO;
import web.comm.dto.CommDTO;
import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;

public interface CommService {

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
	List<CommDTO> getEmailCd(String code);
	
	/**
	******************************************
	* @MethodName    : getMainCity
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 메인 도시 조회
	* @return
	*******************************************
	*/
	List<CommCityDTO> getMainCity();
	
	/**
	******************************************
	* @MethodName    : getVolPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.26
	* @Comment : 봉사 장소 조회
	* @return
	*******************************************
	*/
	public List<VolunteerDTO> getVolPlaceList();
	
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
	public Paging getPaging(int curPage, String tbNm);
	
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
	public Paging getSearchPaging(int curPage, SearchDTO searchDTO);

}
