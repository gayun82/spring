package co.micol.prj.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	List<Map<String,Object>> noticeSelectList();//조인 또는 vo객체를 만들지 않고 사용하려고 할때
	
	//List<NoticeVO> noticeSelectListVo();//vo객체를 이용해서 받을 때
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(NoticeVO vo);//조회수 증가
	
	List<NoticeVO> noticeSearch(String key, String val);//어떤 단어가 포함되어있으면 다 불러와라
	
}
