package web.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.sample.dao.face.MemberDao;
import web.sample.dto.Member;
import web.sample.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDao memberDao;
	
	
	@Override
	public void join(Member joinproc) {
		
		memberDao.insert(joinproc);
	}
	
	@Override
	public boolean login(Member loginproc) {
		logger.info("login() {}", loginproc);
		
		if(memberDao.selectCntByIdPw(loginproc) > 0) {
			return true;
		}
		
		return false;
	}

}
