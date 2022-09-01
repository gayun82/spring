package co.micol.prj.member.map;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	int memberInsert(MemberVO vo);
}
