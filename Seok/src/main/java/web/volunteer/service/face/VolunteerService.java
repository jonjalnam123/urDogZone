package web.volunteer.service.face;

import java.util.List;
import java.util.Map;

import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;

public interface VolunteerService {
	
	public Paging getPaging(int curPage);

	List<VolunteerDTO> getVolunteerList(Paging paging);

	public Paging getPaging(int curPage, SearchDTO searchDTO);

	public List<VolunteerDTO> getVolunteerListNew(Map<String, Object> paramMap);

}
