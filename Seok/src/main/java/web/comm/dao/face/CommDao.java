package web.comm.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import web.comm.dto.CommDTO;

@Mapper
public interface CommDao {

	List<CommDTO> getEmailCd(String code);

}
