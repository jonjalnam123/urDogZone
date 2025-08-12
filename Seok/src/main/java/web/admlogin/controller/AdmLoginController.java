package web.admlogin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.admlogin.dto.AdminDTO;
import web.admlogin.service.face.AdmLoginService;

@Controller
@RequestMapping(value = "/admLogin")
public class AdmLoginController {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdmLoginService admLoginService;
	
	/**
	******************************************
	* @MethodName    : getAdminLogin
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 관리자 로그인 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getAdminLogin.do")
	public String getAdminLogin() {
		logger.info("=== 관리자 로그인 화면 컨트롤러 진입 === ");
	    return "admlogin/admLogin.admin";
	}
	
	/**
	******************************************
	* @MethodName    : adminLogin
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 관리자 로그인 진행
	* @param adminDTO
	* @param session
	* @return
	*******************************************
	*/
	@RequestMapping(value="/adminLogin.do")
	@ResponseBody
	public Map<String,Object> adminLogin( @ModelAttribute AdminDTO adminDTO, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info("=== 관리자 로그인 진행 컨트롤러 진입 === ");
			int resultCnt = admLoginService.adminLogin(adminDTO, session);
			String resultCd = "";
			if ( resultCnt > 0 ) {
				 resultCd = "Y";
				 result.put("resultCd", resultCd);
			} else {
				resultCd = "N";
				result.put("resultCd", resultCd);
			}
			result.put("result", "SUCCESS");
		} catch (Exception e) {
			logger.info("=== 오류발생 : 관리자 로그인 진행 컨트롤러 === ");
			result.put("result", "FAIL");
		}
		
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : admLogout
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.12
	* @Comment : 로그아웃
	* @param session
	* @return
	*******************************************
	*/
	@RequestMapping(value="/admLogout.do")
	public String logout(HttpSession session) {
		logger.info("=== 관리자 로그아웃 컨트롤러 진입 === ");
	    session.invalidate();
	    return "redirect:/admLogin/getAdminLogin.do";
	}

}
