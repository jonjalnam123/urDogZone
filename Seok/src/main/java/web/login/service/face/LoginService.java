package web.login.service.face;

import web.login.dto.UserDTO;

public interface LoginService {

	public void insertMember(UserDTO userDTO);

	public String selectUserIdCheck(String userId);

}
