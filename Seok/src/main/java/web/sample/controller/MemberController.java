package web.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.sample.dto.Member;
import web.sample.service.face.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberService memberService;
	
	
	@GetMapping("/main")
	public void main() {
		logger.info("/main [GET] 요청 완료");
	}
	
	@GetMapping("/join")
	public void join() {
		logger.info("join [GET]요청 완료");
	}
	
	@PostMapping("/join")
	public String joinprocess(Member joinproc) {
		logger.info("/member/join [POST] 요청완료!");
		logger.info("전달{}", joinproc);
		
		memberService.join(joinproc);
		
		return "redirect:/member/login";
	}
	
	
	@GetMapping("/login") 
	public void login() {
		logger.info("/member/login [GET] 요청완료!");
	}
	
	@PostMapping("/login")
	public String loginprocess(Member loginproc, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("전달{}", loginproc);
		
		boolean isLogin = memberService.login(loginproc);
		logger.info("isLogin:{}",isLogin);
		
		if(isLogin) {
			session.setAttribute("login", isLogin);
			session.setAttribute("loginid", loginproc.getUserid());
			
		}else {
			logger.info("로그인 실패");
			
			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디와 비밀번호를 확인해 주세요!'); history.go(-1);</script>");
            out.flush(); 

    	return null;
		} 
		
		
		
		return "redirect:/member/main";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	
	@RequestMapping("/showMain")
	public String showmain(Model model) {
		
		System.out.println("showMain [진입]");
		
        // List 생성
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        // 첫 번째 Map 생성
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alice");
        map1.put("age", "30");

        // 두 번째 Map 생성
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Bob");
        map2.put("age", "25");

        // Map을 List에 추가
        dataList.add(map1);
        dataList.add(map2);
		
		
		model.addAttribute("dataList", dataList);
		
		return "member/showMain";
	}
	
}
