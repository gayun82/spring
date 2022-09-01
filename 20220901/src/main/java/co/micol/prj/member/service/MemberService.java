package co.micol.prj.member.service;

import java.util.List;
import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	int memberInsert(MemberVO vo);

}
