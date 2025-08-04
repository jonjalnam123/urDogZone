package web.admlogin.service.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.admlogin.dao.face.AdmLoginDao;
import web.admlogin.dto.AdminDTO;
import web.admlogin.service.face.AdmLoginService;

@Service
public class AdmLoginServiceImpl implements AdmLoginService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdmLoginDao admLoginDao;
	
	/**
	******************************************
	* @MethodName    : adminLogin
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 관리자 로그인 진행
	* @param adminDTO
	* @param session
	* @return
	*******************************************
	*/
	@Override
	public int adminLogin(AdminDTO adminDTO, HttpSession session) {
		int result = 0;
		AdminDTO adminDto = admLoginDao.adminLogin(adminDTO); 
		if ( adminDto != null ) {
			String adminId = adminDto.getAdminId();
			String adminNm = adminDto.getAdminNm();
			String adminType = adminDto.getAdminType();
			Object userId = session.getAttribute("userId");
			if ( userId != null ) {
				session.invalidate();
			}
			session.setAttribute("adminId", adminId);
			session.setAttribute("adminNm", adminNm);
			session.setAttribute("adminType", adminType);
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

}
