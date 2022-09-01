package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("members", service.memberSelectList());
		return "member/memberList";
	}
	
	@RequestMapping("/memberInsertForm.do")
	public String memberInsertForm(MemberVO vo, Model model) {
		return "member/memberInsertForm";
	}
	
	@PostMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		service.memberInsert(vo);
		return "member/memberInsert";
	}
}
