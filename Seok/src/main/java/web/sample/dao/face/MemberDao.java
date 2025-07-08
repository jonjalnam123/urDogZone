package web.sample.dao.face;

import web.sample.dto.Member;

public interface MemberDao {

	public void insert(Member joinproc);

	public int selectCntByIdPw(Member loginproc);

}
