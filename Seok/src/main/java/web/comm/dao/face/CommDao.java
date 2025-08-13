package web.comm.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import web.comm.dto.CommCityDTO;
import web.comm.dto.CommDTO;
import web.volunteer.dto.SearchDTO;

@Mapper
public interface CommDao {

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
	* @MethodName    : selectCntall
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 전체 목록 페이징 처리
	* @Param : tbNm
	* @return
	*******************************************
	*/
	public int selectCntall(String tbNm);
	
	/**
	******************************************
	* @MethodName    : selectCntSearchAll
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 검색 조건 페이징 처리
	* @Param : searchDTO
	* @return
	*******************************************
	*/
	public int selectCntSearchAll(SearchDTO searchDTO);

}
