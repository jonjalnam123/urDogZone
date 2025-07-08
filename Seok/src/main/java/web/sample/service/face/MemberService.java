package web.sample.service.face;

import web.sample.dto.Member;

public interface MemberService {

	public void join(Member joinproc);

	public boolean login(Member loginproc);

}
