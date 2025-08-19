package web.volunteer.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import web.util.Paging;
import web.volunteer.dto.SearchDTO;
import web.volunteer.dto.VolunteerDTO;
import web.volunteer.dto.VolunteerPlaceDTO;

@Mapper
public interface VolunteerDao {

	/**
	******************************************
	* @MethodName    : getVolunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 화면 조회
	* @return
	*******************************************
	*/
	public List<VolunteerDTO> getVolunteerList(Paging paging);

	/**
	******************************************
	* @MethodName    : volunteerList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 목록 조회
	* @return
	*******************************************
	*/
	public List<VolunteerDTO> volunteerList(Map<String, Object> paramMap);

	/**
	******************************************
	* @MethodName    : getVolunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.12
	* @Comment : 봉사 장소 화면 조회
	* @return
	*******************************************
	*/
	public List<VolunteerPlaceDTO> getVolunteerPlaceList(Paging paging);

	
	/**
	******************************************
	* @MethodName    : volunteerPlaceList
	* @Author        : Jung Seok Choi
	* @Date        : 2025.07.27
	* @Comment : 봉사 장소 목록 조회
	* @return
	*******************************************
	*/
	public List<VolunteerPlaceDTO> volunteerPlaceList(Map<String, Object> paramMap);

	/**
	******************************************
	* @MethodName    : regVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 등록
	* @return
	*******************************************
	*/
	public int regVolunteerPlace(VolunteerPlaceDTO volunteerPlaceDTO);

	/**
	******************************************
	* @MethodName    : getVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 상세 조회
	* @return
	*******************************************
	*/
	public VolunteerPlaceDTO getVolunteerPlace(int placeCd);

	/**
	******************************************
	* @MethodName    : updVolunteerPlace
	* @Author        : Jung Seok Choi
	* @Date        : 2025.08.18
	* @Comment : 봉사 장소 수정
	* @return
	*******************************************
	*/
	public int updVolunteerPlace(VolunteerPlaceDTO volunteerPlaceDTO);
	
}
