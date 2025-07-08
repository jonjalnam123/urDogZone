package web.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.login.dto.UserDTO;
import web.login.service.face.LoginService;
 
@Controller
@RequestMapping("/join")
public class LoginController { 
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private LoginService loginService;
	
	@RequestMapping(value="/getJoinPage.do")
	public String join() {
		logger.info("=== 회원가입 진입 ===");  
		return "login/join.page";
	}
	
	@RequestMapping(value="/insertMember.do")
	public String insertMember( @ModelAttribute UserDTO userDTO ) {
		
		try {
			logger.info("=== 회원가입 진행 === ");
			loginService.insertMember(userDTO);
		} catch (Exception e) {  
			logger.info("=== 회원가입 실패 === ");
		}
	
		return "redirect:/";
	}
	
	@RequestMapping(value="/selectUserIdCheck.do")
	@ResponseBody
	public Map<String, Object> selectUserIdCheck( @RequestParam("userId") String userId ) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", "SUCCESS");
		} catch (Exception e) {
			result.put("result", "FAIL");
		}
		
		return result;
	}
}
