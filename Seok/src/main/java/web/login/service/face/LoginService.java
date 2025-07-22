package web.login.service.face;

import javax.servlet.http.HttpSession;

import web.login.dto.UserDTO;

public interface LoginService {
	
	public String selectUserIdCheck(String userId);

	int insertMember(UserDTO userDTO, HttpSession session);

	public String selectUserInfo(UserDTO userDTO, HttpSession session);

}
