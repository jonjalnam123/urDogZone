package web.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.comm.dto.CommDTO;
import web.comm.service.face.CommService;
import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
 
@Controller
@RequestMapping("/login")
public class LoginController { 
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired LoginService loginService;
	@Autowired CommService commService;
	
	/**
	******************************************
	* @MethodName    : selectJoinMethod
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 회원가입 방법 선택 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/selectJoinMethod.do")
	public String selectJoinMethod() {
		logger.info("=== 회원가입 방법 선택 화면 컨트롤러 진입 ===");  
		return "login/joinMethod.page";
	}
	
	/**
	******************************************
	* @MethodName    : getJoinAgreePage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 약관동의 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/getJoinAgreePage.do")
	public String getJoinAgreePage() {
		logger.info("=== 약관동의 화면 컨트롤러 진입 ===");  
		return "login/joinAgree.page";
	}
	
	/**
	******************************************
	* @MethodName    : getJoinPage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 회원가입 화면 조회
	* @param model
	* @param terms1
	* @param terms2
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getJoinPage.do")
	public String getJoinPage( Model model, @RequestParam("terms1") String terms1, @RequestParam("terms2") String terms2) {
		logger.info("=== 회원가입 화면 컨트롤러 진입 ===");  
		
		// 약관동의
		model.addAttribute("terms1", terms1); 
		model.addAttribute("terms2", terms2); 
		
		// 이메일 공통 코드
		List<CommDTO> emailList = commService.getEmailCd("1");
		model.addAttribute("emailList", emailList);
		
		return "login/join.page";
	}
	
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
	@RequestMapping(value="/selectUserIdCheck.do")
	@ResponseBody
	public Map<String, Object> selectUserIdCheck( @RequestParam("userId") String userId ) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info("=== 아이디 중복검사 컨트롤러 진행 === ");
			String resultId = loginService.selectUserIdCheck(userId);
			result.put("result", "SUCCESS");
			result.put("resultId", resultId);
		} catch (Exception e) {
			logger.info("=== 아이디 중복검사 컨트롤러 실패 === ");
			result.put("result", "FAIL");
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
	@RequestMapping(value="/insertMember.do")
	public String insertMember( @ModelAttribute UserDTO userDTO, HttpSession session) {
		String uri = "";
		try {
			logger.info("=== 회원가입 컨트롤러 실행 === ");
			int result = loginService.insertMember(userDTO, session);
			if ( result == 1 ) {
				uri = "redirect:/login/getJoinSuccessPage.do";
			} else {
				uri = "redirect:/login/getJoinFailPage.do";
			}
		} catch (Exception e) {  
			logger.info("=== 회원가입 컨트롤러 실패 === ");
		}
		return uri;
	}
	
	/**
	******************************************
	* @MethodName    : getJoinSuccessPage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.23
	* @Comment : 회원가입 성공 화면 호출
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getJoinSuccessPage.do")
	public String getJoinSuccessPage() {
	    return "login/joinSuccess.page";
	}
	
	/**
	******************************************
	* @MethodName    : getJoinFailPage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.23
	* @Comment : 회원가입 실패 화면 호출
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getJoinFailPage.do")
	public String getJoinFailPage() {
	    return "login/joinFail.page";
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
	@RequestMapping(value="/userLogin.do")
	@ResponseBody
	public Map<String,Object> userLogin(@ModelAttribute UserDTO userDTO, HttpSession session) {
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			logger.info("=== 로그인 컨트롤러 진입 === ");
			String resultVal = loginService.userLogin(userDTO, session);
			result.put("result", "SUCCESS");
			result.put("resultVal", resultVal);
		} catch (Exception e) {
			logger.info("=== 로그인 컨트롤러 실패 === ");
			result.put("result", "FAIL");
		}
		
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : logout
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 로그아웃
	* @param session
	* @return
	*******************************************
	*/
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		logger.info("=== 로그아웃 컨트롤러 진입 === ");
	    session.invalidate();
	    return "redirect:/";
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
	@RequestMapping(value="/mailCheck.do")
	@ResponseBody
	public Map<String, Object> mailCheck(@RequestParam("email") String email) {
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			logger.info("=== 이메일 인증 컨트롤러 진입 === ");
			String emailCode = loginService.mailCheck(email);
			result.put("result", "SUCCESS");
			result.put("emailCode", emailCode);
		} catch (Exception e) {
			logger.info("=== 이메일 인증 컨트롤러 실패 === ");
			result.put("result", "FAIL");
		}
		return result;
	}
}
