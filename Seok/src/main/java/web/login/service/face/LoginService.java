package web.login.service.face;

import javax.servlet.http.HttpSession;

import web.admlogin.dto.AdminDTO;
import web.login.dto.UserDTO;

public interface LoginService {
	
	/**
	******************************************
	* @MethodName    : selectUserIdCheck
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 아이디 중복검사
	* @param userId
	* @return
	*******************************************
	*/
	public String selectUserIdCheck(String userId);

	/**
	******************************************
	* @MethodName    : insertMember
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 회원가입 진행
	* @param userDTO
	* @param session
	* @return
	*******************************************
	*/
	int insertMember(UserDTO userDTO, HttpSession session);

	
	/**
	******************************************
	* @MethodName    : userLogin
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 로그인
	* @param userDTO
	* @param session
	* @return
	*******************************************
	*/
	public String userLogin(UserDTO userDTO, HttpSession session);

}
