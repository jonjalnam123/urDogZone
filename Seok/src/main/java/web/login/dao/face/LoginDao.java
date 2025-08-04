package web.login.dao.face;

import org.apache.ibatis.annotations.Mapper;

import web.admlogin.dto.AdminDTO;
import web.login.dto.UserDTO;

@Mapper
public interface LoginDao {

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
	int selectUserIdCheck(String userId);

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
	int insertMember(UserDTO userDTO);

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
	UserDTO userLogin(UserDTO userDTO);

}
