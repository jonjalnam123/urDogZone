package web.login.service.impl;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import web.login.dao.face.LoginDao;
import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
import web.util.Sha256;

@Service
public class LoginServiceImpl implements LoginService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired LoginDao loginDao;
	@Autowired JavaMailSenderImpl mailSender;
	private int authNumber; 
	
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
		if ( resultCnt == 0 ) {
			result = "Y";
		} else {
			result = "N";
		}
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : mailCheck
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 이메일 인증
	* @param email
	* @return
	*******************************************
	*/
	@Override
	public String mailCheck(String email) {
		makeRandomNumber();
		String setFrom = "jeongseogc26@gmail.com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = email;
		String title = "유아독존 가입 인증 이메일 입니다.";
		String content = 
				"유아독존을 방문해주셔서 감사합니다." +
                "<br><br>" + 
			    "인증 번호는 " + authNumber + "입니다." + 
			    "<br>" + 
			    "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
	
	public void makeRandomNumber() {
		logger.info("=== makeRandomNumber 진입 ===");
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		logger.info("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) { 
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
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
