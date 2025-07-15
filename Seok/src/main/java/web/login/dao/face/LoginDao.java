package web.login.dao.face;

import org.apache.ibatis.annotations.Mapper;

import web.login.dto.UserDTO;

@Mapper
public interface LoginDao {

	UserDTO selectUserIdCheck(String userId);

}
