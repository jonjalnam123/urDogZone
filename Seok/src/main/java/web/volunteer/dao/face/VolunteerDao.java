package web.volunteer.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;

@Mapper
public interface VolunteerDao {
	
	public int selectCntall();

	List<VolunteerDTO> getVolunteerList(Paging paging);

	public int selectCntallNew(SearchDTO searchDTO);

	public List<VolunteerDTO> getVolunteerListNew(Map<String, Object> paramMap);
	
}
