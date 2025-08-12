package web.admlogin.service.impl;

import javax.servlet.http.HttpServletRequest;
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
	@Autowired private HttpServletRequest request;
	
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
        // 로그인 시도
        AdminDTO adminInfo = admLoginDao.adminLogin(adminDTO);

        if (adminInfo != null) {
            // 사용자 세션이 있으면 세션 초기화
            if (session.getAttribute("userId") != null) {
                session.invalidate();
                session = request.getSession(true); // 새 세션 생성
            }

            // 관리자 정보 저장
            session.setAttribute("adminId", adminInfo.getAdminId());
            session.setAttribute("adminNm", adminInfo.getAdminNm());
            session.setAttribute("adminType", adminInfo.getAdminType());

            return 1;
        }
        return 0;
    }

}
