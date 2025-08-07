package web.comm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.comm.dto.CommDTO;
import web.comm.service.face.CommService;

@Controller
@RequestMapping(value="/comm")
public class CommController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CommService commService;
	
	public List<?> getEmailCd( String code ) {
		List<CommDTO> commList = new ArrayList<CommDTO>();		
		try {
			logger.info("=== 이메일 코드 조회 컨트롤러 진입 ===");  
			commList = commService.getEmailCd(code);
		} catch (Exception e) {
			logger.info("=== 이메일 코드 조회 컨트롤러 실패 ===");  
		}
		
		return commList;
	}
}
