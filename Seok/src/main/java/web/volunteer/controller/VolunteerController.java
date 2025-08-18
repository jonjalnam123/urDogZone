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

import web.comm.dto.CommCityDTO;
import web.comm.service.face.CommService;
import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;
import web.volunteer.dto.VolunteerPlaceDTO;
import web.volunteer.service.face.VolunteerService;

@Controller
@RequestMapping(value="/service")
public class VolunteerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CommService commService;
	@Autowired VolunteerService volunteerService;
	
	/**
	******************************************
	* @MethodName    : getVolunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/getVolunteerList.do")  
	public String getVolunteerList( Model model, @RequestParam(defaultValue = "0") int curPage) {
		logger.info("=== 봉사목록 화면 컨트롤러 진입 ===");  
		
		// 페이징 처리
		String tbNm = "TB_VOLUNTEER_INFO";
		Paging paging = commService.getPaging(curPage, tbNm);
		paging.setUri("/service/getVolunteerList.do");
		model.addAttribute("paging", paging);
		
		// 메인 도시 조회
		List<CommCityDTO> mainCityList = commService.getMainCity();
		model.addAttribute("mainCityList", mainCityList);
		
		// 목록 조회
		List<VolunteerDTO> volunteerList = volunteerService.getVolunteerList(paging);
		model.addAttribute("volunteerList", volunteerList);
		
		return "volunteer/volunteerList.admin";
	}
	
	/**
	******************************************
	* @MethodName    : volunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/volunteerList.do")
	public String volunteerList( Model model
								  , @RequestParam(defaultValue = "0") int curPage 
								  , @ModelAttribute SearchDTO searchDTO) {
		logger.info("=== 봉사 목록 컨트롤러 진입 ===");  
		
		// 페이징 처리
		searchDTO.setTbNm("TB_VOLUNTEER_INFO");
		searchDTO.setCol("VOLUNTEER_LOCATE_CITY_CD");
		searchDTO.setCol1("VOLUNTEER_TITLE");
		Paging paging = commService.getSearchPaging(curPage, searchDTO);
		paging.setUri("/service/volunteerList.do");
		model.addAttribute("paging", paging);
		
		// 메인 도시 조회
		List<CommCityDTO> mainCityList = commService.getMainCity();
		model.addAttribute("mainCityList", mainCityList);
		
		// 목록 조회
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paging", paging);
		paramMap.put("searchDTO", searchDTO);
		
		List<VolunteerDTO> volunteerList = volunteerService.volunteerList(paramMap);
		model.addAttribute("volunteerList", volunteerList);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("param", searchDTO.getParam());
		model.addAttribute("param1", searchDTO.getParam1());
		
		
		return "volunteer/volunteerList.admin";
	}
	
	/**
	******************************************
	* @MethodName    : getVolunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.12
	* @Comment : 봉사 장소 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getVolunteerPlaceList.do")
	public String getVolunteerPlaceList( Model model, @RequestParam(defaultValue = "0") int curPage ) {
		logger.info("=== 봉사장소 화면 컨트롤러 진입 ==="); 
		
		// 페이징 처리
		String tbNm = "TB_PLACE_INFO";
		Paging paging = commService.getPaging(curPage, tbNm);
		paging.setUri("/service/getVolunteerPlaceList.do");
		model.addAttribute("paging", paging);
		
		// 메인 도시 조회
		List<CommCityDTO> mainCityList = commService.getMainCity();
		model.addAttribute("mainCityList", mainCityList);
		
		// 목록 조회
		List<VolunteerPlaceDTO> volunteerPlaceList = volunteerService.getVolunteerPlaceList(paging);
		model.addAttribute("volunteerPlaceList", volunteerPlaceList);
		
		return "volunteer/volunteerPlaceList.admin";
	}
	
	/**
	******************************************
	* @MethodName    : volunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 장소 목록 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/volunteerPlaceList.do")
	public String volunteerPlaceList( Model model
								  , @RequestParam(defaultValue = "0") int curPage 
								  , @ModelAttribute SearchDTO searchDTO) {
		logger.info("=== 봉사 장소 목록 컨트롤러 진입 ===");  
		
		// 페이징 처리
		searchDTO.setTbNm("TB_PLACE_INFO"); // 테이블명
		searchDTO.setCol("CITY_CODE"); // 조회 컬럼
		searchDTO.setCol1("PLACE_NM"); // 조회 컬럼 1
		Paging paging = commService.getSearchPaging(curPage, searchDTO);
		paging.setUri("/service/volunteerPlaceList.do"); //페이징URI
		model.addAttribute("paging", paging);
		
		// 메인 도시 조회
		List<CommCityDTO> mainCityList = commService.getMainCity();
		model.addAttribute("mainCityList", mainCityList);
		
		// 목록 조회
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paging", paging);
		paramMap.put("searchDTO", searchDTO);
		
		List<VolunteerPlaceDTO> volunteerPlaceList = volunteerService.volunteerPlaceList(paramMap);
		model.addAttribute("volunteerPlaceList", volunteerPlaceList);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("param1", searchDTO.getParam1());
		
		return "volunteer/volunteerPlaceList.admin";
	}
	
	/**
	******************************************
	* @MethodName    : getRegVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 등록 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/getRegVolunteerPlace.do")
	public String getRegVolunteerPlace( Model model ) {
		logger.info("=== 봉사 장소 등록 화면 조회 컨트롤러 진입 ===");  

		// 메인 도시 조회
		List<CommCityDTO> mainCityList = commService.getMainCity();
		model.addAttribute("mainCityList", mainCityList);
		
		return "volunteer/volunteerPlaceReg.admin";
	}
	
	/**
	******************************************
	* @MethodName    : regVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 등록
	* @return
	*******************************************
	*/
	@RequestMapping(value = "/regVolunteerPlace.do")
	public String regVolunteerPlace( Model model, @ModelAttribute VolunteerPlaceDTO volunteerPlaceDTO) {
		
		String uri = "";
		try {
			logger.info("=== 봉사 장소 등록 컨트롤러 진입 ===");
			int result = volunteerService.regVolunteerPlace(volunteerPlaceDTO);
			if ( result == 1 ) {
				uri = "redirect:/service/getVolunteerPlaceList.do";
			} else {
				uri = "redirect:/login/getJoinFailPage.do";
			}
		} catch (Exception e) {
			logger.info("=== 봉사 장소 등록 컨트롤러 실패===");  
		}
		
		return uri;
	}
	

}
