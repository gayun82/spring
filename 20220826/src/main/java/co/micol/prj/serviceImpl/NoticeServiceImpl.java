package co.micol.prj.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.service.NoticeService;
import co.micol.prj.service.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper map;
	
	@Override
	public List<Map<String, Object>> noticeSelectList() {
		
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearch(String key, String val) {
		// TODO Auto-generated method stub
		return map.noticeSearch(key, val);
	}

	@Override
	public int noticeHitUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeHitUpdate(vo);
	}

}
