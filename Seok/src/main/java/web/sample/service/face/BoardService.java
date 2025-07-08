package web.sample.service.face;

import java.util.List;

import web.sample.dto.Board;
import web.util.Paging;

public interface BoardService {

	public Paging getPaging(int curPage);

	public List<Board> list(Paging paging);

	public void testList(String testData);

	

}
