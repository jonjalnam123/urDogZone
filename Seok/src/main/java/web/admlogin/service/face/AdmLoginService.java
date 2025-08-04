package web.admlogin.service.face;

import javax.servlet.http.HttpSession;

import web.admlogin.dto.AdminDTO;

public interface AdmLoginService {
	
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
	public int adminLogin(AdminDTO adminDTO, HttpSession session);

}
