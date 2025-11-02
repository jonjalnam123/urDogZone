package web.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	@RequestMapping(value = "/fMenuList.do")
	public String getFmenuList () {
		return "menu/fMenuList.admin";
	}

}
