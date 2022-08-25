package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired//컨테이너에 등록되있는 것 
	private NoticeService dao;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices",dao.noticeSelectList());
		return "notice/noticeList";
		
	}
	@RequestMapping("/noticeSelectList.do")
	public ModelAndView noticeSelectList(ModelAndView mv) {
		mv.addObject("notices",dao.noticeSelectList());// 결과 담고
		mv.setViewName("notice/noticeList"); //view 선택
		return mv;
	}
	@RequestMapping("/noticeForm.do")//글쓰기 폼 호출
	public String noticeForm() {
		return "notice/noticeForm";
	}
	
	@PostMapping("/noticeInsert.do")//글 등록
	public String noticeInsert(NoticeVO vo, MultipartFile mFile) { //첨부파일 안함
		//여기 부분에 첨부파일 처리 
		dao.noticeInsert(vo); //글 내용 등록
		return "redirect:noticeList.do";//글 목록으로 돌아가기
		
	}
	
	
}
