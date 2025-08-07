package web.comm.service.face;

import java.util.List;

import web.comm.dto.CommDTO;

public interface CommService {

	List<CommDTO> getEmailCd(String code);

}
