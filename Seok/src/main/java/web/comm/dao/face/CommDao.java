package web.comm.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	* @MethodName    : selectCntall
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 전체 목록 페이징 처리
	* @Param : tbNm
	* @return
	*******************************************
	*/
	public int selectCntall(String tbNm);


}
