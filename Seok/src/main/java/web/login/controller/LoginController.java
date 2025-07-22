package web.login.controller;

import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
 
@Controller
@RequestMapping("/join")
public class LoginController { 
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired LoginService loginService;
	
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
		
		model.addAttribute("terms1", terms1); //약관동의1
		model.addAttribute("terms2", terms2); //약관동의2
		
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
				uri = "login/loginSuccess.page";
			} else {
				uri = "login/loginFail.page";
			}
		} catch (Exception e) {  
			logger.info("=== 회원가입 컨트롤러 실패 === ");
		}
		return uri;
	}
	
	/**
	 ******************************************
	* @MethodName    : login
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.22
	* @Comment : 로그인
	* @param userDTO
	* @param session
	* @param redirectAttributes
	* @return
	*******************************************
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public Map<String,Object> login(@ModelAttribute UserDTO userDTO, HttpSession session, RedirectAttributes redirectAttributes) {
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			logger.info("=== 로그인 컨트롤러 진입 === ");
			System.out.println("userDTO===" + userDTO);
			String resultVal = loginService.selectUserInfo(userDTO, session);
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
}
