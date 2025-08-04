package web.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/")
	public String main() {
		logger.info("===[main] 진입===");
		return "main/main.page";
	}
	
	@RequestMapping(value="/admin.do")
	public String adminMain() {
		logger.info("===[adminMain] 진입===");
		return "admmain/admMain.admin";
	}
}
