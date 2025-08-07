package web.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.comm.dao.face.CommDao;
import web.comm.dto.CommDTO;
import web.comm.service.face.CommService;

@Service
public class CommServiceImpl implements CommService{
	
	@Autowired CommDao commDao;
	
	@Override
	public List<CommDTO> getEmailCd(String code) {
		
		List<CommDTO> commEmailList = commDao.getEmailCd(code);
		
		if ( commEmailList.isEmpty() || commEmailList.size() < 0 || commEmailList == null ) {
			commEmailList = null;
		}
		
		return commEmailList;
	}

}
