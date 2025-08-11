package web.volunteer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;
import web.volunteer.service.face.VolunteerService;

@Controller
@RequestMapping(value="/service")
public class VolunteerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired VolunteerService volunteerService;
	
	@RequestMapping(value = "/getVolunteerList.do")  
	public String getVolunteerList( Model model, @RequestParam(defaultValue = "0") int curPage) {
		logger.info("=== 봉사목록 화면 컨트롤러 진입 ===");  
		
		Paging paging = volunteerService.getPaging(curPage);
		paging.setUri("/service/getVolunteerList.do");
		model.addAttribute("paging", paging);
		
		List<VolunteerDTO> volunteerList = volunteerService.getVolunteerList(paging);
		model.addAttribute("volunteerList", volunteerList);
		
		return "volunteer/volunteerList.admin";
	}
	
	@RequestMapping(value = "/volunteerList.do")
	public String volunteerList( Model model
								  , @RequestParam(defaultValue = "0") int curPage 
								  , @ModelAttribute SearchDTO searchDTO) {
		logger.info("=== 봉사목록 화면 컨트롤러 진입 ===");  
		System.out.println("searchDTO===" + searchDTO);
		Paging paging = volunteerService.getPaging(curPage, searchDTO);
		paging.setUri("/service/volunteerList.do");
		model.addAttribute("paging", paging);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paging", paging);
		paramMap.put("searchDTO", searchDTO);
		
		List<VolunteerDTO> volunteerList = volunteerService.getVolunteerListNew(paramMap);
		model.addAttribute("volunteerList", volunteerList);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("param", searchDTO.getParam());
		model.addAttribute("param1", searchDTO.getParam1());
		
		
		/*
		 * String test1 = "test1"; String test2 = "test2";
		 */
		
		/*
		 * if ( !param.isEmpty() ) { System.out.println("진입?");
		 * model.addAttribute("param", param); }
		 */
		
		return "volunteer/volunteerList.admin";
	}

}
