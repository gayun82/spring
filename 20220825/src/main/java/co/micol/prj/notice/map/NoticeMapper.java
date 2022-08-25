package co.micol.prj.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import co.micol.prj.service.NoticeVO;

public interface NoticeMapper {
	@Select("select * from notice")//ibatis 속성이라서 안쓰는 것을 권장
	List<Map<String, Object>> noticeSelectList();// 조인 또는 vo객체를 만들지 않고 사용하려고 할때

	// List<NoticeVO> noticeSelectListVo();//vo객체를 이용해서 받을 때

	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);

	List<NoticeVO> noticeSearch(@Param("key") String key,  @Param("val") String val);// 어떤 단어가 포함되어있으면 다 불러와라
	//중요							   //속성명   키값으로 인식   
	//두개이상일 때 Param로 받아야한다.
}
