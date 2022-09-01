package co.micol.prj.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.member.map.MemberMapper;
import co.micol.prj.member.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper map;
	
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

}
