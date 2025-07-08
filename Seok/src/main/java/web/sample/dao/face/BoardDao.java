package web.sample.dao.face;

import java.util.List;

import web.sample.dto.Board;
import web.util.Paging;

public interface BoardDao {

	public int selectCntall();

	public List<Board> selectList(Paging paging);

	public void testList(String testData);

}
