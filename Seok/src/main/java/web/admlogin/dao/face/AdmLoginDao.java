package web.admlogin.dao.face;

import org.apache.ibatis.annotations.Mapper;

import web.admlogin.dto.AdminDTO;

@Mapper
public interface AdmLoginDao {
	
	/**
	******************************************
	* @MethodName    : adminLogin
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 관리자 로그인 진행
	* @param adminDTO
	* @param session
	* @return
	*******************************************
	*/
	AdminDTO adminLogin(AdminDTO adminDTO);

}
