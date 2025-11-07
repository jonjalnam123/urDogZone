package web.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.sample.dto.Board;
import web.sample.service.face.BoardService;
import web.util.Paging;

@Controller
@RequestMapping("/sample")
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardService boardService;
	
	
	@RequestMapping("/list")
	public void list(@RequestParam(defaultValue = "0") int curPage , Model model) {		
		
		System.out.println(curPage);
		Paging paging = boardService.getPaging(curPage);
		logger.info("{}", paging);
		model.addAttribute("paging", paging);
		
		List<Board> list = boardService.list(paging);
		for (Board b : list) logger.info("{}",b);
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/{path}") 
	public String sampleView (@PathVariable String path) {
		System.out.println("=======[샘플 진입]==========");
		logger.info("path : {}", path);
		String view = path;
		String viewResult = "sample/" + view + ".admin";
		logger.info("viewResult : {}", viewResult);
		return viewResult;
	}
	
}
