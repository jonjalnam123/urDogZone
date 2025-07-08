package web.sample.service.impl;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.sample.dao.face.BoardDao;
import web.sample.dto.Board;
import web.sample.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardDao boardDao;
	
	@Autowired ServletContext context;
	
	
	@Override
	public Paging getPaging(int curPage) {
		
		//총 게시글 수 조회
		int totalCount = boardDao.selectCntall();
		
		//페이징계산
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<Board> list(Paging paging) {
		
		return boardDao.selectList(paging);
	}
	
	@Override
	public void testList(String testData) {
		 boardDao.testList(testData);
		
	}

}
