package web.login.service.impl;

import org.springframework.stereotype.Service;

import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
import web.util.Sha256;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Override
	public void insertMember(UserDTO userDTO) {
		
		// 비밀번호 암호화
		String encryPassword = Sha256.encrypt(userDTO.getUserPw());
		userDTO.setUserPw(encryPassword);

		// 회원가입 메서드
		//reg_service.userReg_service(userVO);
		// 인증 메일 보내기 메서드
		//mailsender.mailSendWithUserKey(userVO.getUser_email(), userVO.getUser_id(), request);
		
	}

}
