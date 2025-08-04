package web.login.service.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.admlogin.dto.AdminDTO;
import web.login.dao.face.LoginDao;
import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
import web.util.Sha256;

@Service
public class LoginServiceImpl implements LoginService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired LoginDao loginDao;
	
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
	@Override
	public String selectUserIdCheck(String userId) {
		int resultCnt = loginDao.selectUserIdCheck(userId);
		String result = "";
		if ( resultCnt < 0 ) {
			result = "Y";
		} else {
			result = "N";
		}
		return result;
	}
	
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
	@Override
	public int insertMember(UserDTO userDTO, HttpSession session) {
		
		String userId = userDTO.getUserId();
		userDTO.setRegId(userId);
		userDTO.setUpdId(userId);
		
		// 비밀번호 암호화
		String encryPassword = Sha256.encrypt(userDTO.getUserPw());
		userDTO.setUserPw(encryPassword);
		
		// 핸드폰 암호화
		String encryPhone = Sha256.encrypt(userDTO.getUserPhone());
		userDTO.setUserPhone(encryPhone);
		
		int result = loginDao.insertMember(userDTO);
		
		if ( result == 1) {
			logger.info("==회원가입 성공==");
			session.setAttribute("userId", userId);
			session.setAttribute("userNm", userDTO.getUserNm());
		} else {
			logger.info("==회원가입 실패==");
		}
		
		return result;
		
	}
	
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
	@Override
	public String userLogin(UserDTO userDTO, HttpSession session) {
		String result = "";
		String userPwOrg = userDTO.getUserPw();
		
		// 비밀번호 암호화
		String encryPassword = Sha256.encrypt(userPwOrg);
		userDTO.setUserPw(encryPassword); 
				
		UserDTO userDto = loginDao.userLogin(userDTO);
		
		if ( userDto != null ) {
			String userId = userDto.getUserId();
			String userNm = userDto.getUserNm();
			String userType = userDto.getUserType();
			Object adminId = session.getAttribute("adminId");
			if ( adminId != null ) {
				session.invalidate();
			}
			session.setAttribute("userId", userId);
			session.setAttribute("userNm", userNm);
			session.setAttribute("userType", userType);
			result = "Y";
		} else {
			result = "N";
		}
		
		return result;
	}
}
