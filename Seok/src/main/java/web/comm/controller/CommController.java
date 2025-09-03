package web.comm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import web.comm.dto.CommCityDTO;
import web.comm.dto.FileDTO;
import web.comm.service.face.CommService;

@Controller
@RequestMapping(value="/comm")
public class CommController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CommService commService;
	
	/**
	******************************************
	* @MethodName    : getMainCity
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 메인 도시 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getMainCity.do")
	@ResponseBody
	public Map<String, Object> getMainCity() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info("=== 메인 도시 조회 컨트롤러 진입 ===");  
			List<CommCityDTO> mainCityList = commService.getMainCity();
			result.put("result", "SUCCESS");
			result.put("mainCityList", mainCityList);
		} catch (Exception e) {
			logger.info("=== 메인 도시 조회 컨트롤러 실패 === ");
			result.put("result", "FAIL");
		}
		return result;
	}
	
	/**
	******************************************
	* @MethodName    : getFailPage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.20
	* @Comment : 공통 실패 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getFailPage.do")
	public String getFailPage() {
		logger.info("=== 공통 실패 화면 조회 컨트롤러 진입 ===");  
		return "comm/failPage.none";
	}
	
	/**
	******************************************
	* @MethodName    : getFailFilePage
	* @Author        : Jung Seok Choi
	* @Date        : 2025.09.03
	* @Comment : 공통 파일 실패 화면 조회
	* @return
	*******************************************
	*/
	@RequestMapping(value="/getFailFilePage.do")
	public String getFailFilePage() {
		logger.info("=== 공통 파일 실패 화면 조회 컨트롤러 진입 ===");  
		return "comm/failFilePage.none";
	}
}
